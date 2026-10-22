package com.larus.live.impl.bridge.download;

import ae7.e;
import android.content.Context;
import com.bytedance.common.utility.concurrent.TTExecutors;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.base.runtime.thread.ThreadUtils;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.bytedance.ies.xbridge.s;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.platform.service.z2;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public abstract class a extends XCoreBridgeMethod {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final XBridgeMethod.Access f355760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f355761b;

    /* JADX INFO: renamed from: com.larus.live.impl.bridge.download.a$a, reason: collision with other inner class name */
    public interface InterfaceC4402a {
        void a(String r100, d r101);

        void b(d r100, String r101);
    }

    public static final class b implements InterfaceC4402a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f355762a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ XBridgeMethod.Callback f355763b;

        public b(a r100, XBridgeMethod.Callback r101) {
            this.f355762a = r100;
            this.f355763b = r101;
        }

        @Override // com.larus.live.impl.bridge.download.a.InterfaceC4402a
        public final void a(String r100, d r101) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            if (r101 == null) goto L5;
            int r102 = d.f355769e;
            Map<String, Object> r103 = d.a.a(r101);
        L6:
            this.f355762a.onFailure(this.f355763b, 0, r100, r103);
            return;
        L5:
            r103 = new LinkedHashMap();
            goto L6
        }

        @Override // com.larus.live.impl.bridge.download.a.InterfaceC4402a
        public final void b(d r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = d.f355769e;
            Map<String, Object> r103 = d.a.a(r100);
            this.f355762a.onSuccess(this.f355763b, r103, r101);
        }
    }

    public a() {
        this.f355760a = XBridgeMethod.Access.PROTECT;
        this.f355761b = "x.downloadFile";
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final XBridgeMethod.Access getAccess() {
        return this.f355760a;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final String getName() {
        return this.f355761b;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<XDownloadFileMethodParamModel> provideParamModel() {
        return XDownloadFileMethodParamModel.class;
    }

    @Override // com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod, com.bytedance.ies.xbridge.XBridgeMethod
    public final Class<d> provideResultModel() {
        return d.class;
    }

    @Override // com.bytedance.ies.xbridge.XBridgeMethod
    public final void handle(XReadableMap r110, XBridgeMethod.Callback r210, final XBridgePlatformType r211) {
        Intrinsics.checkNotNullParameter(r110, "params");
        Intrinsics.checkNotNullParameter(r210, "callback");
        Intrinsics.checkNotNullParameter(r211, "type");
        boolean r100 = z2.f365865a.getECommerceSettingsConfig().getEnableDownloadFileJsbOpt();
        int r101 = XDownloadFileMethodParamModel.f355751g;
        Intrinsics.checkNotNullParameter(r110, "source");
        String r111 = s.f(r110, "url", "");
        if (r111.length() != 0) goto L5;
        boolean r112 = true;
    L7:
        if (r112 == false) goto L9;
    L8:
        String r113 = "extension";
    L30:
        final XDownloadFileMethodParamModel r102 = null;
    L31:
        if (r102 != null) goto L34;
        XCoreBridgeMethod.onFailure$default(this, r210, -3, null, null, 12, null);
        return;
    L34:
        final b r114 = new b(this, r210);
        final c r115 = (c) this;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r114, "callback");
        Intrinsics.checkNotNullParameter(r211, "type");
        final Context r103 = (Context) r115.provideContext(Context.class);
        if (r103 != null) goto L37;
        r114.a("Context not provided in host", null);
        return;
    L37:
        StringBuilder r104 = new StringBuilder();
        char[] r105 = e.f3111a;
        String r106 = r102.f355752a;
        if (r106 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("url");
        r106 = null;
    L41:
        r104.append(e.a(r106));
        r104.append(System.currentTimeMillis());
        String r107 = r104.toString();
        String r108 = r102.f355753b;
        if (r108 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException(r113);
        r108 = null;
    L45:
        String r109 = r107 + '.' + r108;
        File r116 = r103.getExternalCacheDir();
        if (r116 != null) goto L48;
        r116 = r103.getCacheDir();
    L48:
        if (r116 == null) goto L56;
        final String r117 = r116.getAbsolutePath();
        if (r117 == null) goto L56;
        final String r118 = r117 + '/' + r109;
        if (new PolarisFileWrapper(r118).exists() == false) goto L55;
        ThreadUtils.a().post(new ri9.a(r114));
        return;
    L55:
        r56.c r119 = (r56.c) r115.provideContext(r56.c.class);
        r56.c r120 = r56.c.f536312g;
        TTExecutors.getNormalExecutor().execute(new ri9.b(r102, r211, r115, r118, r117, r103, r114));
        return;
    L56:
        r114.a("cacheDir is null", null);
        return;
    L9:
        String r121 = s.f(r110, "extension", "");
        if (r121.length() != 0) goto L12;
        boolean r122 = true;
    L13:
        if (r122 == true) goto L8;
        if (r100 == false) goto L18;
        Intrinsics.checkNotNullParameter(r121, "<this>");
        r113 = "extension";
        if ((!StringsKt.contains$default(r121, "../", false, 2, null)) == false) goto L30;
    L19:
        XReadableMap r123 = s.e(r110, "params");
        XReadableMap r124 = s.e(r110, "header");
        String r125 = s.f(r110, "saveToAlbum", "");
        r102 = new XDownloadFileMethodParamModel();
        Intrinsics.checkNotNullParameter(r111, "<set-?>");
        r102.f355752a = r111;
        Intrinsics.checkNotNullParameter(r121, "<set-?>");
        r102.f355753b = r121;
        r102.f355757f = r100;
        if (r123 == null) goto L22;
        r102.f355754c = r123;
    L22:
        if (r124 == null) goto L25;
        r102.f355755d = r124;
    L25:
        if (r125.length() <= 0) goto L27;
        boolean r126 = true;
    L28:
        if (r126 == false) goto L31;
        r102.f355756e = XDownloadFileMethodParamModel.SaveWay.valueOf(r125);
        goto L31
    L27:
        r126 = false;
        goto L28
    L18:
        r113 = "extension";
        goto L19
    L12:
        r122 = false;
        goto L13
    L5:
        r112 = false;
        goto L7
    }
}
