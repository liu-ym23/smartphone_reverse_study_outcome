package com.bytedance.bdp.appbase.network.wrapper;

import android.content.Context;
import android.util.Pair;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdp.appbase.network.BdpFromSource;
import com.bytedance.bdp.appbase.network.BdpHttpDnsScene;
import com.bytedance.bdp.appbase.network.BdpNetRequest;
import com.bytedance.bdp.appbase.network.BdpNetResponse;
import com.bytedance.bdp.appbase.network.BdpRequestHelper;
import com.bytedance.bdp.appbase.network.BdpRequestType;
import com.bytedance.bdp.appbase.network.IBdpNetCall;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.bdp.bdpbase.util.i;
import com.bytedance.bdp.serviceapi.defaults.network.BdpNetworkService;
import com.bytedance.retrofit2.client.Request;
import java.util.Iterator;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes11.dex */
public final class BdpHostCallWrapper implements IBdpNetCall {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f200933c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f200934d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f200935e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f200936a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BdpNetRequest f200937b;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static void a(gb4.c.a r100, String r101, BdpFromSource r102) {
            if (((Boolean) BdpHostCallWrapper.f200934d.getValue()).booleanValue() == true) goto L5;
            return;
        L5:
            BdpHttpDnsScene r103 = BdpHttpDnsScene.Companion.fromSourceToHttpDnsScene(r102);
            if (r103 != BdpHttpDnsScene.SDK) goto L8;
            return;
        L8:
            r100.a("x-ttnet-httpdns-enable", "1");
            if (r101 == null) goto L12;
            r100.a("x-ttnet-httpdns-micro-app-id", r101);
        L12:
            if (i.e((Context) BdpHostCallWrapper.f200933c.getValue()) == false) goto L14;
            r100.a("x-ttnet-httpdns-auth-id", BDLocationException.ERROR_BACKGROUND_LOCATE);
            r100.a("x-ttnet-httpdns-auth-key", "MmRMRWNRNGVWdEpVd2l6Mg==");
        L15:
            r100.a("x-ttnet-httpdns-micro-scene", r103.getScene());
            return;
        L14:
            r100.a("x-ttnet-httpdns-auth-id", "35");
            r100.a("x-ttnet-httpdns-auth-key", "Z3hKODliMENvOVdMNVZDWA==");
            goto L15
        }
    }

    @Override // com.bytedance.bdp.appbase.network.IBdpNetCall
    public final void cancel() {
        g94.b.d("BdpHostCallWrapper", new Object[]{"cancel"});
        throw null;
    }

    static {
        f200935e = new a();
        f200933c = LazyKt.lazy(BdpHostCallWrapper$Companion$baseContext$2.INSTANCE);
        f200934d = LazyKt.lazy(BdpHostCallWrapper$Companion$httpDnsCostStatisticsEnable$2.INSTANCE);
    }

    @Override // com.bytedance.bdp.appbase.network.IBdpNetCall
    public final BdpNetResponse execute() {
        if (this.f200936a == true) goto L5;
        this.f200936a = true;
        throw null;
    L5:
        return BdpRequestHelper.INSTANCE.buildNativeErrorResponse(this.f200937b.getUrl(), -201, "call has requested", this.f200937b.getRequestLibType());
    }

    @Override // com.bytedance.bdp.appbase.network.IBdpNetCall
    public final BdpNetRequest getRequest() {
        return this.f200937b;
    }

    public BdpHostCallWrapper(BdpNetRequest r100) {
        this.f200937b = r100;
        gb4.c.a r101 = new gb4.c.a(r100.getHeaders());
        if (r100.getAddBdpCommonParams() == false) goto L9;
        Iterator<Map.Entry<String, String>> r102 = BdpRequestHelper.INSTANCE.getBdpCommonParams(r100.getAppInfo()).entrySet().iterator();
    L6:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, String> r103 = r102.next();
        r101.c(r103.getKey(), r103.getValue());
    L9:
        if (this.f200937b.getRequestLibType() != BdpRequestType.PURETTNET) goto L12;
        r101.a(Request.KEY_BYPASS_TTNET_FEATURES, "1");
        r101.a(Request.KEY_BYPASS_DISPATCH, "1");
        r101.a("bypass-boe", "1");
        r101.a("bdp_ttnet_request_type", TemplateNodeType.RAW);
    L12:
        if (this.f200937b.getRequestLibType() != BdpRequestType.HOST) goto L17;
        if (this.f200937b.getAddHostSecurityParams() == true) goto L17;
        r101.c("x-metasec-mode", "1");
    L17:
        if (this.f200937b.getDyeTagType() == null) goto L21;
        BdpNetworkService r104 = (BdpNetworkService) BdpManager.getInst().getService(BdpNetworkService.class);
        this.f200937b.getDyeTagType().booleanValue();
        Pair r105 = r104.B2();
        if (r105 == null) goto L21;
        r101.a((String) r105.first, (String) r105.second);
        g94.b.d("BdpHostCallWrapper", new Object[]{"增加染色: " + r105});
    L21:
        a r106 = f200935e;
        String r107 = this.f200937b.getAppId();
        if (r107 != null) goto L27;
        com.bytedance.bdp.appbase.core.a r108 = this.f200937b.getAppInfo();
        if (r108 == null) goto L26;
        r108.getAppId();
    L26:
        r107 = null;
    L27:
        BdpFromSource r109 = this.f200937b.getFrom();
        r106.getClass();
        a.a(r101, r107, r109);
        this.f200937b.getUrl();
        this.f200937b.getMethod();
        this.f200937b.getResponseStreaming();
        this.f200937b.getAddHostCommonParams();
        this.f200937b.getAddHostMd5Stub();
        this.f200937b.getWithRequestEncrypt();
        r101.b();
        this.f200937b.getRequestBody();
        this.f200937b.getConnectTimeOut();
        this.f200937b.getReadTimeOut();
        this.f200937b.getWriteTimeOut();
        ((BdpNetworkService) BdpManager.getInst().getService(BdpNetworkService.class)).W0();
    }
}
