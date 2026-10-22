package org.chromium;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.frameworks.baselib.network.TTNetInitMetrics;
import com.bytedance.frameworks.baselib.network.http.NativeRequestInterceptor;
import com.bytedance.frameworks.baselib.network.http.NetworkParams;
import com.bytedance.frameworks.baselib.network.http.cronet.ICronetAppProvider;
import com.bytedance.frameworks.baselib.network.http.cronet.JavaInterceptorCallbackRegistry;
import com.bytedance.frameworks.baselib.network.utils.TTReflectIOException;
import com.bytedance.retrofit2.mime.TTRequestCompressManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ttnet.org.chromium.net.TTEventListener;
import com.ttnet.org.chromium.net.impl.TTCronetInitTimingInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends TTEventListener {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static volatile e f525640b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f525641a;

    /* JADX INFO: loaded from: classes42.dex */
    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f525642a;

        @Override // java.lang.Runnable
        public final void run() {
            JSONObject r100 = TTNetInitMetrics.g().b();     // Catch: Throwable -> L4
            JSONObject r101 = TTNetInitMetrics.g().c(this.f525642a);     // Catch: Throwable -> L4
            c.h().k(r100.toString(), "ttnet_init");     // Catch: Throwable -> L4
            c.h().k(r101.toString(), "ttnet_init_v2");     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(long r100) {
            this.f525642a = r100;
        }
    }

    public static e a() {
        if (f525640b != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f525640b != null) goto L9;
        f525640b = new e();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f525640b;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onColdStartFinish() {
        if (this.f525641a == false) goto L25;
        c r100 = c.h();
        r100.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onColdStartFinish ");
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r101 = r100.f525635b;     // Catch: Throwable -> L18
        if (r101 == null) goto L21;
        r101.onColdStartFinish();     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r102 = r100.f525634a;     // Catch: Throwable -> L18
        if (r102 == null) goto L21;
        yx5.a.b(r102).call("onColdStartFinish");     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onCronetBootSucceed() {
        if (this.f525641a == false) goto L25;
        c r100 = c.h();
        r100.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onCronetBootSucceed ");
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r101 = r100.f525635b;     // Catch: Throwable -> L18
        if (r101 == null) goto L21;
        r101.onCronetBootSucceed();     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r102 = r100.f525634a;     // Catch: Throwable -> L18
        if (r102 == null) goto L21;
        yx5.a.b(r102).call("onCronetBootSucceed");     // Catch: Throwable -> L18
        goto L21
    }

    public e() {
        this.f525641a = false;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTLBDecompressFail() {
        TTRequestCompressManager.setGlobalForbidenCompress();
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onClientIPChanged(String r100) {
        if (this.f525641a == false) goto L25;
        c r101 = c.h();
        r101.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onClientIPChanged ");
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r102 = r101.f525635b;     // Catch: Throwable -> L18
        if (r102 == null) goto L21;
        r102.onClientIPChanged(r100);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r103 = r101.f525634a;     // Catch: Throwable -> L18
        if (r103 == null) goto L21;
        yx5.a.b(r103).call("onClientIPChanged", new Class[]{String.class}, new Object[]{r100});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onEffectiveConnectionTypeChanged(int r100) {
        c r101 = c.h();
        r101.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onEffectiveConnectionTypeChanged type = " + r100);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r102 = r101.f525635b;     // Catch: Throwable -> L16
        if (r102 == null) goto L20;
        r102.onEffectiveConnectionTypeChangedOnIOThread(r100);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r103 = r101.f525634a;     // Catch: Throwable -> L16
        if (r103 == null) goto L22;
        yx5.a.b(r103).call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r100)});     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onNetworkQualityLevelChanged(int r100) {
        c r101 = c.h();
        r101.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityLevelChanged, nql: " + r100);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r102 = r101.f525635b;     // Catch: Throwable -> L16
        if (r102 == null) goto L20;
        r102.onNetworkQualityLevelChangedOnIOThread(r100);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r103 = r101.f525634a;     // Catch: Throwable -> L16
        if (r103 == null) goto L22;
        yx5.a.b(r103).call("onNetworkQualityLevelChangedOnIOThread", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r100)}).get();     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onNetworkQualityTypeChangedV3(int r110) {
        c r100 = c.h();
        r100.getClass();
        if (d.a().loggerDebug() == false) goto L24;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityTypeChangedV3, network_quality_type = " + r110);
    L24:
    L21:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (NetworkParams.getOptReflection() == false) goto L12;
        ICronetAppProvider r101 = r100.f525635b;     // Catch: Throwable -> L21
        if (r101 == null) goto L27;
        r101.onEffectiveConnectionTypeChangedOnIOThread(r110);     // Catch: Throwable -> L21
        yx5.a.d("com.bytedance.ttnet.NQEManager").call("notifyNQTChanged", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(r110)});     // Catch: Throwable -> L21
        return;
    L27:
        return;
    L12:
        Object r102 = r100.f525634a;     // Catch: Throwable -> L21
        if (r102 == null) goto L29;
        yx5.a.b r103 = yx5.a.b(r102);     // Catch: Throwable -> L21
        Class<?> r104 = Integer.TYPE;     // Catch: Throwable -> L21
        r103.call("onEffectiveConnectionTypeChangedOnIOThread", new Class[]{r104}, new Object[]{Integer.valueOf(r110)});     // Catch: Throwable -> L21
        yx5.a.d("com.bytedance.ttnet.NQEManager").call("notifyNQTChanged", new Class[]{r104}, new Object[]{Integer.valueOf(r110)});     // Catch: Throwable -> L21
        return;
    L18:
        e = move-exception;
        throw new TTReflectIOException(e.getMessage(), e.getCause());     // Catch: Throwable -> L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTTNetDetectInfoChanged(String r100) {
        if (this.f525641a == false) goto L25;
        c r101 = c.h();
        r101.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onTTNetDetectInfoChanged info str = " + r100);
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r102 = r101.f525635b;     // Catch: Throwable -> L18
        if (r102 == null) goto L21;
        r102.onTTNetDetectInfoChanged(r100);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r103 = r101.f525634a;     // Catch: Throwable -> L18
        if (r103 == null) goto L21;
        yx5.a.b(r103).call("onTTNetDetectInfoChanged", new Class[]{String.class}, new Object[]{r100});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onUserSpecifiedNetworkEnabled(boolean r100) {
        c r101 = c.h();
        r101.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onUserSpecifiedNetworkEnabled, enable = " + r100);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r102 = r101.f525635b;     // Catch: Throwable -> L16
        if (r102 == null) goto L20;
        r102.onUserSpecifiedNetworkEnabled(r100);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r103 = r101.f525634a;     // Catch: Throwable -> L16
        if (r103 == null) goto L22;
        yx5.a.b(r103).call("onUserSpecifiedNetworkEnabled", new Class[]{Boolean.TYPE}, new Object[]{Boolean.valueOf(r100)});     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final Map<String, String> onCallToAddSecurityFactor(String r100, Map<String, String> r110) {
        c r101 = c.h();
        r101.getClass();
        if (d.a().loggerDebug() == false) goto L5;
        d.a().loggerD("CronetAppProviderManager", "onCallToAddSecurityFactor info url = " + r100);
    L5:
        Map<String, String> r102 = null;
    L17:
        th = move-exception;
        th.printStackTrace();
    L19:
        return r102;
    L7:
        if (NetworkParams.getOptReflection() == false) goto L12;
        ICronetAppProvider r103 = r101.f525635b;     // Catch: Throwable -> L17
        if (r103 == null) goto L20;
        r102 = r103.onCallToAddSecurityFactor(r100, r110);     // Catch: Throwable -> L17
    L20:
        goto L19
    L12:
        Object r104 = r101.f525634a;     // Catch: Throwable -> L17
        if (r104 == null) goto L20;
        r102 = (Map) yx5.a.b(r104).call("onCallToAddSecurityFactor", new Class[]{String.class, Map.class}, new Object[]{r100, r110}).get();     // Catch: Throwable -> L17
        goto L20
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onDropReasonChanged(boolean r100, List<Integer> r101) {
        if (this.f525641a == false) goto L25;
        c r102 = c.h();
        r102.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onDropReasonChanged " + r100 + ", Drop Reason List " + r101);
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r103 = r102.f525635b;     // Catch: Throwable -> L18
        if (r103 == null) goto L21;
        r103.onDropReasonChanged(r100, r101);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r104 = r102.f525634a;     // Catch: Throwable -> L18
        if (r104 == null) goto L21;
        yx5.a.b(r104).call("onDropReasonChanged", new Class[]{Boolean.TYPE, List.class}, new Object[]{Boolean.valueOf(r100), r101});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onMultiNetworkStateChanged(int r100, int r101) {
        c r102 = c.h();
        r102.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onMultiNetworkStateChanged, prev state = " + r100 + ", curr state = " + r101);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r103 = r102.f525635b;     // Catch: Throwable -> L16
        if (r103 == null) goto L20;
        r103.onMultiNetworkStateChanged(r100, r101);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r104 = r102.f525634a;     // Catch: Throwable -> L16
        if (r104 == null) goto L22;
        yx5.a.b r105 = yx5.a.b(r104);     // Catch: Throwable -> L16
        Class<?> r106 = Integer.TYPE;     // Catch: Throwable -> L16
        r105.call("onMultiNetworkStateChanged", new Class[]{r106, r106}, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)}).get();     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onPublicIPsChanged(List<String> r100, List<String> r101) {
        if (this.f525641a == false) goto L25;
        c r102 = c.h();
        r102.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onPublicIPsChanged ");
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r103 = r102.f525635b;     // Catch: Throwable -> L18
        if (r103 == null) goto L21;
        r103.onPublicIPsChanged(r100, r101);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r104 = r102.f525634a;     // Catch: Throwable -> L18
        if (r104 == null) goto L21;
        yx5.a.b(r104).call("onPublicIPsChanged", new Class[]{List.class, List.class}, new Object[]{r100, r101});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final String onRequestInterceptorJava(String r100, Map<String, String> r101) {
        return JavaInterceptorCallbackRegistry.onRequestInterceptorJava(r100, r101);
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTNCUpdateFailed(String[] r100, String r101) {
        if (this.f525641a == false) goto L29;
        c r102 = c.h();
        r102.getClass();
        if (d.a().loggerDebug() == false) goto L7;
        d.a().loggerD("CronetAppProviderManager", "onTNCUpdateFailed ");
    L7:
        if (r100 == null) goto L30;
    L22:
        th = move-exception;
        th.printStackTrace();
        return;
    L9:
        if (r100.length <= 0) goto L25;
        ArrayList<String> r103 = new ArrayList();     // Catch: Throwable -> L22
        Collections.addAll(r103, r100);     // Catch: Throwable -> L22
        if (NetworkParams.getOptReflection() == false) goto L17;
        ICronetAppProvider r104 = r102.f525635b;     // Catch: Throwable -> L22
        if (r104 == null) goto L25;
        r104.onTNCUpdateFailed(r103, r101);     // Catch: Throwable -> L22
        goto L25
    L17:
        Object r105 = r102.f525634a;     // Catch: Throwable -> L22
        if (r105 == null) goto L25;
        yx5.a.b(r105).call("onTNCUpdateFailed", new Class[]{ArrayList.class, String.class}, new Object[]{r103, r101});     // Catch: Throwable -> L22
    L25:
        return;
    L30:
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onWiFiToCellStateChanged(int r100, int r101) {
        c r102 = c.h();
        r102.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onWiFiToCellStateChanged, prev state = " + r100 + ", curr state = " + r101);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r103 = r102.f525635b;     // Catch: Throwable -> L16
        if (r103 == null) goto L20;
        r103.onWiFiToCellStateChanged(r100, r101);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r104 = r102.f525634a;     // Catch: Throwable -> L16
        if (r104 == null) goto L22;
        yx5.a.b r105 = yx5.a.b(r104);     // Catch: Throwable -> L16
        Class<?> r106 = Integer.TYPE;     // Catch: Throwable -> L16
        r105.call("onWiFiToCellStateChanged", new Class[]{r106, r106}, new Object[]{Integer.valueOf(r100), Integer.valueOf(r101)}).get();     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onNetworkQualityRttAndThroughputNotified(int r100, int r110, int r111) {
        c r101 = c.h();
        r101.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onNetworkQualityRttAndThroughputNotified, effectiveHrttMs: " + r100 + ", effectiveTrttMs: " + r110 + ", effectiveRxThroughputKbps: " + r111);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r102 = r101.f525635b;     // Catch: Throwable -> L16
        if (r102 == null) goto L20;
        r102.onNetworkQualityRttAndThroughputNotifiedOnIOThread(r100, r110, r111);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r103 = r101.f525634a;     // Catch: Throwable -> L16
        if (r103 == null) goto L22;
        yx5.a.b r104 = yx5.a.b(r103);     // Catch: Throwable -> L16
        Class<?> r105 = Integer.TYPE;     // Catch: Throwable -> L16
        r104.call("onNetworkQualityRttAndThroughputNotifiedOnIOThread", new Class[]{r105, r105, r105}, new Object[]{Integer.valueOf(r100), Integer.valueOf(r110), Integer.valueOf(r111)}).get();     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onRTTOrThroughputEstimatesComputed(int r100, int r110, int r111) {
        c r101 = c.h();
        r101.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onRTTOrThroughputEstimatesComputed httpRtt = " + r100 + ", transportRttMs = " + r110 + ",downstreamThroughputKbps = " + r111);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r102 = r101.f525635b;     // Catch: Throwable -> L16
        if (r102 == null) goto L20;
        r102.onRTTOrThroughputEstimatesComputedOnIOThread(r100, r110, r111);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r103 = r101.f525634a;     // Catch: Throwable -> L16
        if (r103 == null) goto L22;
        yx5.a.b r104 = yx5.a.b(r103);     // Catch: Throwable -> L16
        Class<?> r105 = Integer.TYPE;     // Catch: Throwable -> L16
        r104.call("onRTTOrThroughputEstimatesComputedOnIOThread", new Class[]{r105, r105, r105}, new Object[]{Integer.valueOf(r100), Integer.valueOf(r110), Integer.valueOf(r111)});     // Catch: Throwable -> L16
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final String onRequestInterceptorToStart(String r100, Map<String, String> r101, List<String> r102) {
        String r103 = null;
        if (NativeRequestInterceptor.f244668a != null) goto L6;
    L34:
        return r103;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("NativeRequestInterceptor", "request url:" + r100 + " headers:" + r101.toString() + " domains:" + r102);
    L8:
        NativeRequestInterceptor.c r104 = NativeRequestInterceptor.f244668a.b(r100);
        if (r104 == null) goto L34;
        JSONObject r105 = new JSONObject();
        int r106 = NativeRequestInterceptor.a.f244670a[r104.f244671a.ordinal()];     // Catch: Throwable -> L25
        if (r106 != 1) goto L16;
        r105.put("modified", NativeRequestInterceptor.RequestModified.URL_MODIFIED.getValue());     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(null) == true) goto L36;
        new URI(null);
        r105.put("new_url", null);
    L36:
        goto L31
    L16:
        if (r106 != 2) goto L18;
        r105.put("modified", NativeRequestInterceptor.RequestModified.HEADER_MODIFIED.getValue());     // Catch: Throwable -> L25
        NativeRequestInterceptor.c.a(r105, r104.f244672b);     // Catch: Throwable -> L25
        goto L36
    L18:
        if (r106 != 3) goto L36;
        r105.put("modified", NativeRequestInterceptor.RequestModified.BOTH_MODIFIED.getValue());     // Catch: Throwable -> L25
        if (TextUtils.isEmpty(null) == false) goto L39;
    L24:
        NativeRequestInterceptor.c.a(r105, r104.f244672b);     // Catch: Throwable -> L25
        goto L36
    L39:
        new URI(null);     // Catch: Exception -> L35
        r105.put("new_url", null);     // Catch: Exception -> L35
    L31:
        r103 = r105.toString();
        if (Logger.debug() == false) goto L34;
        Logger.d("NativeRequestInterceptor", "request json:" + r103);
        goto L34
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final String onResponseInterceptorToStart(String r100, Map<String, List<String>> r101, int r102) {
        if (NativeRequestInterceptor.f244668a != null) goto L6;
        return null;
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d("NativeRequestInterceptor", "response url:" + r100 + " headers:" + r101.toString() + " code:" + r102);
    L8:
        NativeRequestInterceptor.f244668a.a();
        return null;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onServerConfigUpdated(String r100, String r101, String r110) {
        if (this.f525641a == false) goto L25;
        c r102 = c.h();
        r102.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onServerConfigUpdated json = " + r100);
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r103 = r102.f525635b;     // Catch: Throwable -> L18
        if (r103 == null) goto L21;
        r103.onServerConfigEtagChanged(r101);     // Catch: Throwable -> L18
        r102.f525635b.onServerConfigABTestChanged(r110);     // Catch: Throwable -> L18
        r102.f525635b.onServerConfigUpdated(r100);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r104 = r102.f525634a;     // Catch: Throwable -> L18
        if (r104 == null) goto L21;
        yx5.a.b(r104).call("onServerConfigEtagChanged", new Class[]{String.class}, new Object[]{r101});     // Catch: Throwable -> L18
        yx5.a.b(r102.f525634a).call("onServerConfigABTestChanged", new Class[]{String.class}, new Object[]{r110});     // Catch: Throwable -> L18
        yx5.a.b(r102.f525634a).call("onServerConfigUpdated", new Class[]{String.class}, new Object[]{r100});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTncRequestSucceeded(boolean r100, boolean r110, int r111) {
        c r101 = c.h();
        r101.getClass();
    L14:
        th = move-exception;
        th.printStackTrace();
        return;
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r102 = r101.f525635b;     // Catch: Throwable -> L14
        if (r102 == null) goto L17;
        r102.onTncRequestSucceeded(r100, r110, r111);     // Catch: Throwable -> L14
    L17:
        return;
    L9:
        Object r103 = r101.f525634a;     // Catch: Throwable -> L14
        if (r103 == null) goto L17;
        yx5.a.b r104 = yx5.a.b(r103);     // Catch: Throwable -> L14
        Class<?> r105 = Boolean.TYPE;     // Catch: Throwable -> L14
        r104.call("onTncRequestSucceeded", new Class[]{r105, r105, Integer.TYPE}, new Object[]{Boolean.valueOf(r100), Boolean.valueOf(r110), Integer.valueOf(r111)}).get();     // Catch: Throwable -> L14
        goto L17
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onPacketLossComputed(int r210, double r211, double r212, double r213, double r214) {
        c r100 = c.h();
        r100.getClass();
        if (d.a().loggerDebug() == false) goto L20;
        d.a().loggerD("CronetAppProviderManager", "onPacketLossComputed protocol = " + r210 + ", upstreamLossRate = " + r211 + ", upstreamLossRateVariance = " + r212 + ", downstreamLossRate = " + r213 + ", downstreamLossRateVariance = " + r214);
    L20:
    L17:
        th = move-exception;
        th.printStackTrace();
        return;
    L7:
        if (NetworkParams.getOptReflection() == false) goto L12;
        ICronetAppProvider r101 = r100.f525635b;     // Catch: Throwable -> L17
        if (r101 == null) goto L21;
        r101.onPacketLossComputedOnIOThread(r210, r211, r212, r213, r214);     // Catch: Throwable -> L17
        return;
    L21:
        return;
    L12:
        Object r102 = r100.f525634a;     // Catch: Throwable -> L17
        if (r102 == null) goto L23;
        yx5.a.b r103 = yx5.a.b(r102);     // Catch: Throwable -> L17
        Class<?> r104 = Double.TYPE;     // Catch: Throwable -> L17
        r103.call("onPacketLossComputedOnIOThread", new Class[]{Integer.TYPE, r104, r104, r104, r104}, new Object[]{Integer.valueOf(r210), Double.valueOf(r211), Double.valueOf(r212), Double.valueOf(r213), Double.valueOf(r214)});     // Catch: Throwable -> L17
        return;
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onStoreIdcChanged(String r110, String r111, String r112, String r113, String r114, String r115) {
        if (this.f525641a == false) goto L25;
        c r100 = c.h();
        r100.getClass();
        if (d.a().loggerDebug() == false) goto L22;
        d.a().loggerD("CronetAppProviderManager", "onStoreIdcChanged ");
    L22:
    L18:
        th = move-exception;
        th.printStackTrace();
        return;
    L8:
        if (NetworkParams.getOptReflection() == false) goto L13;
        ICronetAppProvider r101 = r100.f525635b;     // Catch: Throwable -> L18
        if (r101 == null) goto L21;
        r101.onStoreIdcChanged(r110, r111, r112, r113, r114, r115);     // Catch: Throwable -> L18
    L21:
        return;
    L13:
        Object r102 = r100.f525634a;     // Catch: Throwable -> L18
        if (r102 == null) goto L21;
        yx5.a.b(r102).call("onStoreIdcChanged", new Class[]{String.class, String.class, String.class, String.class, String.class, String.class}, new Object[]{r110, r111, r112, r113, r114, r115});     // Catch: Throwable -> L18
        goto L21
    }

    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onTTDnsResolveResult(String r110, String r111, int r112, int r113, int r114, List<String> r210, String r211) {
        c r100 = c.h();
        r100.getClass();
        if (d.a().loggerDebug() == false) goto L19;
        d.a().loggerD("CronetAppProviderManager", "onTTDnsResolveResult info uuid = " + r110 + " host: " + r111);
    L19:
    L16:
        th = move-exception;
        th.printStackTrace();
        return;
    L6:
        if (NetworkParams.getOptReflection() == false) goto L11;
        ICronetAppProvider r101 = r100.f525635b;     // Catch: Throwable -> L16
        if (r101 == null) goto L20;
        r101.onTTDnsResolveResult(r110, r111, r112, r113, r114, r210, r211);     // Catch: Throwable -> L16
        return;
    L20:
        return;
    L11:
        Object r102 = r100.f525634a;     // Catch: Throwable -> L16
        if (r102 == null) goto L22;
        yx5.a.b r103 = yx5.a.b(r102);     // Catch: Throwable -> L16
        Class<?> r104 = Integer.TYPE;     // Catch: Throwable -> L16
        r103.call("onTTDnsResolveResult", new Class[]{String.class, String.class, r104, r104, r104, List.class, String.class}, new Object[]{r110, r111, Integer.valueOf(r112), Integer.valueOf(r113), Integer.valueOf(r114), r210, r211});     // Catch: Throwable -> L16
        return;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x0098 -> B:16:0x009b). Please report as a decompilation issue!!! */
    @Override // com.ttnet.org.chromium.net.TTEventListener
    public final void onContextInitCompleted(long r110, long r111, long r112, long r113, long r114, long r210, long r211, long r212, long r213, long r214, long r310, long r311, long r312, long r313, long r314, long r410) {
        TTNetInitMetrics r100 = TTNetInitMetrics.g();
        boolean r101 = false;
        r100.f244609c = Process.getThreadPriority(0);
        r100.F = TTCronetInitTimingInfo.sInitThreadStart;
        r100.G = TTCronetInitTimingInfo.sInitThreadEnd;
        r100.H = TTCronetInitTimingInfo.sLoadCronetSoStart;
        r100.I = TTCronetInitTimingInfo.sLoadCronetSoEnd;
        r100.f244604J = TTCronetInitTimingInfo.sNativeInitTimingJson;
        r100.L = TTCronetInitTimingInfo.sABTest;
        r100.K = System.nanoTime();
        r100.N = r110;
        r100.O = r111;
        r100.P = r112;
        r100.M = r113;
        r100.Q = r114;
        r100.R = r210;
        r100.S = r211;
        r100.T = r212;
        r100.U = r213;
        r100.V = r214;
        r100.W = r310;
        r100.X = r311;
        r100.Y = r312;
        r100.Z = r313;
        r100.f244606a0 = r314;
        r100.f244608b0 = r410;
        c r102 = c.h();
        r102.getClass();
    L14:
        th = move-exception;
        th.printStackTrace();
    L16:
        long r103 = -1;
    L17:
        TTNetInitMetrics r104 = TTNetInitMetrics.g();
        if (r104.f244610d != 0) goto L20;
    L72:
        if (r101 == true) goto L78;
        TTExecutors.getScheduledThreadPool().schedule(new a(r103), 5, TimeUnit.SECONDS);
        TTNetInitMetrics.f244602e0.set(true);
        if (TTNetInitMetrics.f244601d0.isEmpty() == true) goto L86;
        new com.bytedance.frameworks.baselib.network.c().start();
        return;
    L86:
        return;
    L78:
        JSONObject r105 = TTNetInitMetrics.g().b();
        JSONObject r106 = TTNetInitMetrics.g().c(r103);
        TTNetInitMetrics.f244602e0.set(true);
        if (TTNetInitMetrics.f244601d0.isEmpty() == true) goto L82;
        new com.bytedance.frameworks.baselib.network.c().start();
    L82:
        c.h().k(r105.toString(), "ttnet_init");
        c.h().k(r106.toString(), "ttnet_init_v2");
        return;
    L20:
        if (r104.f244611e == 0) goto L72;
        if (r104.f244612f == 0) goto L72;
        if (r104.f244613g == 0) goto L72;
        if (r104.f244614h == 0) goto L72;
        if (r104.f244615i == 0) goto L72;
        if (r104.f244616j == 0) goto L72;
        if (r104.f244617k == 0) goto L72;
        if (r104.f244618l == 0) goto L72;
        if (r104.f244620n == 0) goto L72;
        if (r104.f244621o == 0) goto L72;
        if (r104.f244622p == 0) goto L72;
        if (r104.f244623q == 0) goto L72;
        if (r104.f244624r == 0) goto L72;
        if (r104.f244625s == 0) goto L72;
        if (r104.f244626t == 0) goto L72;
        if (r104.f244627u == 0) goto L72;
        if (r104.f244628v == 0) goto L72;
        if (r104.f244629w == 0) goto L72;
        if (r104.f244630x == 0) goto L72;
        if (r104.f244631y == 0) goto L72;
        if (r104.f244632z == 0) goto L72;
        if (r104.A == 0) goto L72;
        if (r104.B == 0) goto L72;
        if (r104.C == 0) goto L72;
        if (r104.D == 0) goto L72;
        if (r104.E == 0) goto L72;
        r101 = true;
        goto L72
    L4:
        if (NetworkParams.getOptReflection() == false) goto L9;
        ICronetAppProvider r107 = r102.f525635b;     // Catch: Throwable -> L14
        if (r107 == null) goto L16;
        r103 = r107.getAppStartTime();     // Catch: Throwable -> L14
        goto L17
    L9:
        Object r108 = r102.f525634a;     // Catch: Throwable -> L14
        if (r108 == null) goto L16;
        r103 = ((Long) yx5.a.b(r108).call("getAppStartTime").get()).longValue();     // Catch: Throwable -> L14
        goto L17
    }
}
