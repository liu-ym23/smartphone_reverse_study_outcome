package com.bytedance.common.wschannel.channel.impl.ok;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.Message;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.bytedance.common.wschannel.WsChannelSdk;
import com.bytedance.common.wschannel.WsChannelSettings;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.common.wschannel.channel.IWsChannelClient;
import com.bytedance.common.wschannel.channel.impl.ok.policy.RetryTimesPolicy;
import com.bytedance.common.wschannel.model.WsChannelMsg;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import el9.a;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class OkChannelImpl implements IWsChannelClient, WeakHandler.IHandler {
    public static long sInitMSSdkMilliDuration;
    private final int mChannelId;
    private Map<String, Object> mConfigMap;
    private Context mContext;
    private Handler mHandler;
    private boolean mHasInit;
    private ContentObserver mOkChannelEnableObserver;
    private List<String> mUrls;
    private WsOkClient mWsClient;

    public static /* synthetic */ Class access$001(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
    public void handleMsg(Message r100) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onConnection(JSONObject r100) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(WsChannelMsg r100) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onServiceConnectEvent(int r100, boolean r101, String r102) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean privateProtocolProxyEnabled() {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void registerService(int r100) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(WsChannelMsg r100) {
        return false;
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void unregisterService(int r100) {
    }

    private void unregisterObserver() {
        Context r100 = this.mContext;     // Catch: Throwable -> L6
        if (r100 == null) goto L11;
        r100.getContentResolver().unregisterContentObserver(this.mOkChannelEnableObserver);     // Catch: Throwable -> L6
        return;
    L11:
        return;
    L6:
        th = move-exception;
        th.printStackTrace();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void destroy() {
        this.mWsClient.destroy();
        unregisterObserver();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean isConnected() {
        return this.mWsClient.isConnected();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void stopConnection() {
        this.mWsClient.stopConnect();
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_bytedance_common_wschannel_channel_impl_ok_OkChannelImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
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

    public static /* synthetic */ Context access$000(OkChannelImpl r100) {
        return r100.mContext;
    }

    public static /* synthetic */ Map access$200(OkChannelImpl r100) {
        return r100.mConfigMap;
    }

    public static /* synthetic */ List access$300(OkChannelImpl r100) {
        return r100.mUrls;
    }

    private void initMSSdk(Context r110) {
        long r100 = System.currentTimeMillis();
        Class r101 = INVOKESTATIC_com_bytedance_common_wschannel_channel_impl_ok_OkChannelImpl_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.mobsec.metasec.ov.MSB");     // Catch: ClassNotFoundException -> L5
    L6:
        if (r101 != null) goto L14;
        return;
    L14:
        r101.getMethod(BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, new Class[]{Context.class, Integer.TYPE, Map.class}).invoke(r101, new Object[]{r110, 2, null});     // Catch: Throwable -> L10
    L12:
        sInitMSSdkMilliDuration = System.currentTimeMillis() - r100;
        return;
    L10:
        th = move-exception;
        th.printStackTrace();
    L5:
        sInitMSSdkMilliDuration = -1;
        r101 = null;
        goto L6
    }

    private void observerSpChanged(Context r100) {
        r100.getContentResolver().registerContentObserver(WsChannelMultiProcessSharedProvider.getContentUri(r100, WsConstants.KEY_OK_IMPL_ENABLE, "boolean"), true, this.mOkChannelEnableObserver);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
    }

    private boolean okChannelEnable(Context r100) {
        return WsChannelSettings.inst(r100).isOkChannelEnable();
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onAppStateChanged(int r100) {
        if (okChannelEnable(this.mContext) == true) goto L5;
        return;
    L5:
        WsOkClient r101 = this.mWsClient;
        boolean r102 = true;
        if (r100 == 1) goto L9;
        r102 = false;
    L9:
        r101.onAppStateChanged(r102);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onMessage(byte[] r100) {
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onNetworkStateChanged(int r100) {
        if (okChannelEnable(this.mContext) == true) goto L5;
        return;
    L5:
        this.mWsClient.onNetworkStateChanged(r100);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public boolean sendMessage(byte[] r100) {
        if (okChannelEnable(this.mContext) == true) goto L7;
        return false;
    L7:
        return this.mWsClient.sendMessage(r100);
    }

    public OkChannelImpl(int r100, Handler r101) {
        this.mConfigMap = new HashMap();
        this.mChannelId = r100;
        this.mHandler = r101;
        final Handler r102 = this.mHandler;
        this.mOkChannelEnableObserver = new AnonymousClass1(this, r102);
    }

    public static /* synthetic */ boolean access$100(OkChannelImpl r100, Context r101) {
        return r100.okChannelEnable(r101);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void init(Context r100, IWsChannelClient r101) {
        if (this.mHasInit == false) goto L5;
        return;
    L5:
        this.mHasInit = true;
        this.mContext = r100.getApplicationContext();
        initMSSdk(r100);
        WsOkClient r102 = new WsOkClient.Builder(r100).retryPolicy(new RetryTimesPolicy(r100)).heartBeatPolicy(WsChannelSdk.getHeartBeatPolicy(this.mChannelId)).build();
        this.mWsClient = r102;
        r102.setWsStatusListener(new WsStatusChangedListener(this.mContext, r102, r101));
        observerSpChanged(r100);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void onParameterChange(Map<String, Object> r100, List<String> r101) {
        if (r100 == null) goto L4;
        this.mConfigMap.putAll(r100);
    L4:
        this.mUrls = r101;
        if (okChannelEnable(this.mContext) == true) goto L7;
        return;
    L7:
        this.mWsClient.onParameterChange(r100, r101);
    }

    @Override // com.bytedance.common.wschannel.channel.IWsChannelClient
    public void openConnection(Map<String, Object> r100, List<String> r101) {
        if (r100 == null) goto L4;
        this.mConfigMap.putAll(r100);
    L4:
        this.mUrls = r101;
        if (okChannelEnable(this.mContext) == true) goto L7;
        return;
    L7:
        this.mWsClient.connect(r100, r101);
    }
}
