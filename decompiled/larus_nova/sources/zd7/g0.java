package zd7;

import android.app.Activity;
import android.content.Context;
import com.bytedance.applet.impl.j2;
import com.bytedance.ies.argus.api.ArgusGlobalDelegate;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.CompletionBlock;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseParamModel;
import com.bytedance.sdk.xbridge.cn.registry.core.model.idl.XBaseResultModel;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostContextDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostMediaDependV2;
import com.bytedance.sdk.xbridge.cn.runtime.depend.IHostPermissionDepend;
import com.bytedance.sdk.xbridge.cn.runtime.depend.XBaseRuntime;
import java.util.Arrays;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
@XBridgeMethod(name = "x.uploadVideoToVOD")
public final class g0 extends yd7.k implements com.bytedance.sdk.xbridge.cn.protocol.h {

    public static final class a implements e0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f571363a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f571364b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Boolean f571365c;

        @Override // zd7.e0
        public final String a() {
            return this.f571363a;
        }

        @Override // zd7.e0
        public final String b() {
            return this.f571364b;
        }

        @Override // zd7.e0
        public final Boolean isBoeEnable() {
            return this.f571365c;
        }

        public a(String r100, String r101, g0 r102) {
            this.f571363a = r100;
            this.f571364b = r101;
            r102.getClass();
            XBaseRuntime.f270095a.getClass();
            IHostContextDepend r103 = XBaseRuntime.f270100f;
            if (r103 == null) goto L5;
            Boolean r104 = Boolean.valueOf(r103.isBoeEnable());
        L6:
            this.f571365c = r104;
            return;
        L5:
            r104 = null;
            goto L6
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CompletionBlock<yd7.k.g> f571366a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f571367b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IBDXBridgeContext f571368c;

        @Override // zd7.c
        public final void a(j2.a r100) {
            CompletionBlock<yd7.k.g> r101 = this.f571366a;
            XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.k.g.class));
            yd7.k.g r103 = (yd7.k.g) r102;
            r103.setTraceId(this.f571367b);
            yd7.k.e r104 = (yd7.k.e) ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.k.e.class));
            r104.setVid(r100.f191958a);
            r104.setCoverUri(r100.f191959b);
            int r105 = ne7.d.f518889a;
            Map<String, ? extends Object> r106 = ne7.d.b(new JSONObject(r100.f191962e));
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.Any>");
            r104.setMetaInfo(r106);
            r103.setVideoInfo(r104);
            CompletionBlock.DefaultImpls.onSuccess$default(r101, (XBaseResultModel) r102, null, 2, null);
        }

        @Override // zd7.c
        public final void c(j2.a r100) {
            CompletionBlock<yd7.k.g> r101 = this.f571366a;
            XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.k.g.class));
            yd7.k.g r103 = (yd7.k.g) r102;
            r103.setTraceId(this.f571367b);
            yd7.k.c r104 = (yd7.k.c) ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.k.c.class));
            r104.setErrorCode(r100.f191960c);
            r104.setErrorMessage(r100.f191961d);
            r103.setErrorInfo(r104);
            Unit r105 = Unit.INSTANCE;
            r101.onFailure(0, "upload failed", (XBaseResultModel) r102);
        }

        @Override // zd7.c
        public final void d(long r100) {
            this.f571368c.sendEvent("uploadVideoToVODProgress", MapsKt.mapOf(new Pair[]{TuplesKt.to("traceID", this.f571367b), TuplesKt.to("traceId", this.f571367b), TuplesKt.to("progress", Float.valueOf(r100 / 100))}));
        }

        @Override // zd7.c
        public final void e(j2.a r100) {
            CompletionBlock<yd7.k.g> r101 = this.f571366a;
            XBaseModel r102 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.k.g.class));
            yd7.k.g r103 = (yd7.k.g) r102;
            r103.setTraceId(this.f571367b);
            yd7.k.c r104 = (yd7.k.c) ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.k.c.class));
            r104.setErrorCode(r100.f191960c);
            r104.setErrorMessage(r100.f191961d);
            r103.setErrorInfo(r104);
            Unit r105 = Unit.INSTANCE;
            r101.onFailure(-7, "upload cancel", (XBaseResultModel) r102);
        }

        @Override // zd7.c
        public final void b(Exception r100, j2.a r101) {
            Intrinsics.checkNotNullParameter(r100, "e");
            CompletionBlock<yd7.k.g> r102 = this.f571366a;
            String r103 = "some exception happened : " + r100.getMessage() + "; metaInfo = " + r101.f191962e;
            XBaseModel r104 = ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.k.g.class));
            yd7.k.g r105 = (yd7.k.g) r104;
            r105.setTraceId(this.f571367b);
            yd7.k.e r106 = (yd7.k.e) ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.k.e.class));
            r106.setVid(r101.f191958a);
            r106.setCoverUri(r101.f191959b);
            r105.setVideoInfo(r106);
            yd7.k.c r107 = (yd7.k.c) ne7.e.c(Reflection.getOrCreateKotlinClass(yd7.k.c.class));
            r107.setErrorCode(r101.f191960c);
            r107.setErrorMessage(r101.f191961d);
            r105.setErrorInfo(r107);
            Unit r108 = Unit.INSTANCE;
            r102.onFailure(0, r103, (XBaseResultModel) r104);
        }

        public b(CompletionBlock<yd7.k.g> r100, String r101, IBDXBridgeContext r102) {
            this.f571366a = r100;
            this.f571367b = r101;
            this.f571368c = r102;
        }
    }

    @Override // com.bytedance.sdk.xbridge.cn.protocol.h
    public final void release() {
        XBaseRuntime.f270095a.getClass();
        IHostMediaDependV2 r100 = XBaseRuntime.f270098d;
        if (r100 == null) goto L6;
        r100.closeVideoUpload();
        return;
    }

    public g0() {
    }

    @Override // com.bytedance.sdk.xbridge.cn.registry.core.bridgeInterfaces.XCoreIDLBridgeMethod
    public final void handle(IBDXBridgeContext r110, XBaseParamModel r111, CompletionBlock r112) {
        yd7.k.f r100 = (yd7.k.f) r111;
        Intrinsics.checkNotNullParameter(r110, "bridgeContext");
        Intrinsics.checkNotNullParameter(r100, "params");
        Intrinsics.checkNotNullParameter(r112, "callback");
        Activity r101 = r110.getOwnerActivity();
        if (r101 != null) goto L6;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "Context not provided in host", null, 4, null);
    L31:
        return;
    L6:
        Activity r102 = com.bytedance.sdk.xbridge.cn.utils.k.f270262a.getActivity(r101);
        if (r102 != null) goto L9;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "context can not convert to activity", null, 4, null);
        goto L31
    L9:
        ae7.a r103 = ae7.a.f3109a;
        String r104 = r100.getFilePath();
        r103.getClass();
        if (ae7.a.e(r101, r104) == true) goto L12;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "file does not exist", null, 4, null);
        goto L31
    L12:
        IHostPermissionDepend r105 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r105 == null) goto L15;
        String[] r106 = ae7.h.f();
        boolean r107 = r105.isPermissionAllGranted(r102, (String[]) Arrays.copyOf(r106, r106.length));
    L16:
        if (r107 == false) goto L18;
    L26:
        String r108 = ae7.a.a(r101, r100.getFilePath());
        if (r108 != null) goto L29;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "get file absolute path failed, please check it", null, 4, null);
        return;
    L29:
        a(r110, r101, r108, r100, r112);
        return;
    L18:
        if (ae7.a.d(r101, r100.getFilePath()) == true) goto L26;
        IHostPermissionDepend r109 = com.bytedance.sdk.xbridge.cn.utils.g.f(r110);
        if (r109 == null) goto L23;
        String r113 = this.f567344a;
        String[] r114 = ae7.h.f();
        r109.requestPermission(r102, r110, r113, (String[]) Arrays.copyOf(r114, r114.length), new f0(r101, r100, r112, this, r110));
        Unit r115 = Unit.INSTANCE;
    L24:
        if (r115 != null) goto L32;
        CompletionBlock.DefaultImpls.onFailure$default(r112, 0, "uploadFileDepend is null", null, 4, null);
        return;
    L32:
        return;
    L23:
        r115 = null;
        goto L24
    L15:
        r107 = false;
        goto L16
    }

    public final void a(IBDXBridgeContext r110, Context r111, String r112, yd7.k.f r113, CompletionBlock<yd7.k.g> r114) {
        Lazy<ArgusGlobalDelegate> r100 = ArgusGlobalDelegate.f245624c;
        ArgusGlobalDelegate r101 = ArgusGlobalDelegate.a.a();
        Unit r102 = null;
        if (r101 == null) goto L5;
        com.bytedance.ies.argus.bean.i r103 = r101.b(new com.bytedance.ies.argus.api.params.b(r112, "x.uploadVideoToVOD"));
    L6:
        if (r103 == null) goto L10;
        boolean r104 = true;
        if (r103.c() != true) goto L10;
    L11:
        if (r104 == false) goto L14;
        CompletionBlock.DefaultImpls.onFailure$default(r114, 0, "file path " + r112 + " contains sensitive content, can not upload.", null, 4, null);
        return;
    L14:
        yd7.k.d r105 = r113.getUploadConfig();
        if (r105 == null) goto L18;
        String r106 = r105.getTraceId();
        if (r106 == null) goto L18;
    L19:
        b r107 = new b(r114, r106, r110);
        a r115 = new a(r106, r112, this);
        XBaseRuntime.f270095a.getClass();
        IHostMediaDependV2 r116 = XBaseRuntime.f270098d;
        if (r116 == null) goto L22;
        r116.startVideoUpload(r111, r113, r115, r107);
        r102 = Unit.INSTANCE;
    L22:
        if (r102 != null) goto L25;
        CompletionBlock.DefaultImpls.onFailure$default(r114, 0, "hostMediaDepend is null", null, 4, null);
        return;
    L25:
        return;
    L18:
        r106 = "bridge_" + UUID.randomUUID();
    L10:
        r104 = false;
        goto L11
    L5:
        r103 = null;
        goto L6
    }
}
