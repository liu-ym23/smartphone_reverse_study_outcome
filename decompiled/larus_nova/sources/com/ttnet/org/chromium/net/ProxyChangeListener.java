package com.ttnet.org.chromium.net;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.ProxyInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.Npth;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ttnet.org.chromium.base.ContextUtils;
import com.ttnet.org.chromium.base.TraceEvent;
import com.ttnet.org.chromium.base.annotations.JNINamespace;
import com.ttnet.org.chromium.base.annotations.NativeClassQualifiedName;
import com.ttnet.org.chromium.build.BuildConfig;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
@JNINamespace(com.alipay.sdk.m.k.b.f25406k)
public class ProxyChangeListener {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int GET_PROXY_CONFIG_DELAY_MILLIS = 1000;
    private static final String TAG = "ProxyChangeListener";
    private static boolean sEnabled;
    private Delegate mDelegate;
    private final Handler mHandler;
    private final Looper mLooper;
    private long mNativePtr;
    private ProxyReceiver mProxyReceiver;
    private BroadcastReceiver mRealProxyReceiver;

    /* JADX INFO: renamed from: com.ttnet.org.chromium.net.ProxyChangeListener$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes6.dex */
    public static /* synthetic */ class AnonymousClass1 {
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface Delegate {
        void proxySettingsChanged();
    }

    /* JADX INFO: loaded from: classes6.dex */
    public interface Natives {
        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void proxySettingsChanged(long r100, ProxyChangeListener r101);

        @NativeClassQualifiedName("ProxyConfigServiceAndroid::JNIDelegate")
        void proxySettingsChangedTo(long r100, ProxyChangeListener r101, String r102, int r103, String r104, String[] r105);
    }

    /* JADX INFO: loaded from: classes6.dex */
    public static class ProxyConfig {
        public static final ProxyConfig DIRECT = null;
        public final String[] mExclusionList;
        public final String mHost;
        public final String mPacUrl;
        public final int mPort;

        static {
            DIRECT = new ProxyConfig("", 0, "", new String[0]);
        }

        public static /* synthetic */ ProxyConfig access$300(ProxyInfo r100) {
            return fromProxyInfo(r100);
        }

        private static ProxyConfig fromProxyInfo(ProxyInfo r100) {
            String r101 = null;
            if (r100 != null) goto L5;
            return null;
        L5:
            String r102 = r100.getHost();
            Uri r103 = r100.getPacFileUrl();
            if (r102 != null) goto L8;
            r102 = "";
        L8:
            int r104 = r100.getPort();
            if (Uri.EMPTY.equals(r103) == true) goto L13;
            r101 = r103.toString();
        L13:
            return new ProxyConfig(r102, r104, r101, r100.getExclusionList());
        }

        public ProxyConfig(String r100, int r101, String r102, String[] r103) {
            this.mHost = r100;
            this.mPort = r101;
            this.mPacUrl = r102;
            this.mExclusionList = r103;
        }
    }

    public class ProxyReceiver extends BroadcastReceiver {
        final /* synthetic */ ProxyChangeListener this$0;

        public static /* synthetic */ void a(ProxyReceiver r100, Intent r101) {
            r100.lambda$onReceive$0(r101);
        }

        private ProxyReceiver(ProxyChangeListener r100) {
            this.this$0 = r100;
        }

        private /* synthetic */ void lambda$onReceive$0(Intent r100) {
            ProxyChangeListener.access$200(this.this$0, ProxyChangeListener.access$100(r100));
        }

        public /* synthetic */ ProxyReceiver(ProxyChangeListener r100, AnonymousClass1 r101) {
            this(r100);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r100, final Intent r101) {
            if (r101.getAction().equals("android.intent.action.PROXY_CHANGE") == false) goto L6;
            ProxyChangeListener.access$000(this.this$0).postDelayed(new c(this, r101), 1000);
            return;
        }
    }

    public static /* synthetic */ void a(ProxyChangeListener r100, Intent r101) {
        r100.lambda$updateProxyConfigFromConnectivityManager$0(r101);
    }

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sEnabled = true;
    }

    private void assertOnThread() {
        if (BuildConfig.ENABLE_ASSERTS == true) goto L5;
        return;
    L5:
        if (onThread() == false) goto L8;
        return;
    L8:
        throw new IllegalStateException("Must be called on ProxyChangeListener thread.");
    }

    public static ProxyChangeListener create() {
        return new ProxyChangeListener();
    }

    private boolean onThread() {
        if (this.mLooper != Looper.myLooper()) goto L5;
        return true;
    L5:
        return false;
    }

    private ProxyChangeListener() {
        Looper r100 = Looper.myLooper();
        this.mLooper = r100;
        this.mHandler = new Handler(r100);
    }

    private void registerReceiver() {
        assertOnThread();
        IntentFilter r100 = new IntentFilter();
        r100.addAction("android.intent.action.PROXY_CHANGE");
        this.mProxyReceiver = new ProxyReceiver(this, null);
        if (Build.VERSION.SDK_INT >= 23) goto L5;
        ContextUtils.registerNonExportedBroadcastReceiver(ContextUtils.getApplicationContext(), this.mProxyReceiver, r100);
        return;
    L5:
        ContextUtils.registerNonExportedBroadcastReceiver(ContextUtils.getApplicationContext(), this.mProxyReceiver, new IntentFilter());
        this.mRealProxyReceiver = new ProxyBroadcastReceiver(this);
        ContextUtils.registerNonExportedBroadcastReceiver(ContextUtils.getApplicationContext(), this.mRealProxyReceiver, r100);
    }

    private void unregisterReceiver() {
        assertOnThread();
        INVOKEVIRTUAL_com_ttnet_org_chromium_net_ProxyChangeListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(ContextUtils.getApplicationContext(), this.mProxyReceiver);
        if (this.mRealProxyReceiver == null) goto L5;
        INVOKEVIRTUAL_com_ttnet_org_chromium_net_ProxyChangeListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(ContextUtils.getApplicationContext(), this.mRealProxyReceiver);
    L5:
        this.mProxyReceiver = null;
        this.mRealProxyReceiver = null;
    }

    public void stop() {
        assertOnThread();
        this.mNativePtr = 0;
        unregisterReceiver();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_ttnet_org_chromium_net_ProxyChangeListener_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class r103 = access$001(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r104 = access$001(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static /* synthetic */ Handler access$000(ProxyChangeListener r100) {
        return r100.mHandler;
    }

    public static /* synthetic */ ProxyConfig access$100(Intent r100) {
        return extractNewProxy(r100);
    }

    private static ProxyConfig extractNewProxy(Intent r100) {
        Bundle r101 = r100.getExtras();
        if (r101 != null) goto L7;
        return null;
    L7:
        return ProxyConfig.access$300((ProxyInfo) r101.get("android.intent.extra.PROXY_INFO"));
    }

    public static String getProperty(String r100) {
        return System.getProperty(r100);
    }

    private ProxyConfig getProxyConfig(Intent r100) {
        ProxyInfo r101 = ((ConnectivityManager) ContextUtils.getApplicationContext().getSystemService("connectivity")).getDefaultProxy();
        if (r101 != null) goto L7;
        return ProxyConfig.DIRECT;
    L7:
        if (Build.VERSION.SDK_INT < 29) goto L15;
        if ("localhost".equals(r101.getHost()) == false) goto L15;
        if (r101.getPort() != (-1)) goto L15;
        return extractNewProxy(r100);
    L15:
        return ProxyConfig.access$300(r101);
    }

    private /* synthetic */ void lambda$updateProxyConfigFromConnectivityManager$0(Intent r100) {
        proxySettingsChanged(getProxyConfig(r100));
    }

    private void proxySettingsChanged(ProxyConfig r110) {
        assertOnThread();
        if (sEnabled == true) goto L5;
        return;
    L5:
        Delegate r100 = this.mDelegate;
        if (r100 == null) goto L9;
        r100.proxySettingsChanged();
    L9:
        if (this.mNativePtr != 0) goto L11;
        return;
    L11:
        if (r110 == null) goto L13;
        ProxyChangeListenerJni.get().proxySettingsChangedTo(this.mNativePtr, this, r110.mHost, r110.mPort, r110.mPacUrl, r110.mExclusionList);
        return;
    L13:
        ProxyChangeListenerJni.get().proxySettingsChanged(this.mNativePtr, this);
    }

    private void runOnThread(Runnable r100) {
        if (onThread() == false) goto L5;
        r100.run();
        return;
    L5:
        this.mHandler.post(r100);
    }

    public static void setEnabled(boolean r100) {
        sEnabled = r100;
    }

    public void setDelegateForTesting(Delegate r100) {
        this.mDelegate = r100;
    }

    public void start(long r100) {
        TraceEvent r101 = TraceEvent.scoped("ProxyChangeListener.start");
        assertOnThread();     // Catch: Throwable -> L7
        this.mNativePtr = r100;     // Catch: Throwable -> L7
        registerReceiver();     // Catch: Throwable -> L7
        if (r101 == null) goto L18;
        r101.close();
        return;
    L18:
        return;
    L7:
        th = move-exception;
        if (r101 != null) goto L16;
    L13:
        throw th;
    L16:
        r101.close();     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        th.addSuppressed(th);
        goto L13
    }

    public void updateProxyConfigFromConnectivityManager(final Intent r100) {
        this.mHandler.postDelayed(new b(this, r100), 1000);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void INVOKEVIRTUAL_com_ttnet_org_chromium_net_ProxyChangeListener_com_bytedance_sysoptimizer_ReceiverRegisterLancet_unregisterReceiver(Context r100, BroadcastReceiver r101) {
        ReceiverRegisterLancet.loge(r101, false);
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == true) goto L14;
        r100.unregisterReceiver(r101);
        return;
    L14:
    L8:
        e = move-exception;
        if (r101 == null) goto L11;
        Npth.addTag("unregisterReceiver", r101.toString());
    L11:
        e.printStackTrace();
        return;
    L5:
        if (ReceiverRegisterAnrOptimizer.unregisterReceiverHasNonScreenFilter(r101, r100) == false) goto L16;
        r100.unregisterReceiver(r101);     // Catch: Exception -> L8
        return;
    }

    public static /* synthetic */ void access$200(ProxyChangeListener r100, ProxyConfig r101) {
        r100.proxySettingsChanged(r101);
    }
}
