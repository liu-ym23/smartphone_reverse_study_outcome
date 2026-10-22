package com.larus.bmhome.rc;

import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.platform.model.upload.FlowResourceType;
import com.larus.platform.model.upload.ResourceAttachmentExtra;
import com.larus.platform.model.upload.ResourceUploadError;
import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import mr9.j;
import mr9.k;
import mr9.l;

/* JADX INFO: loaded from: classes26.dex */
public final class ResourceCenterUploadDelegate implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f313548a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f313549b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.bmhome.rc.a f313550c;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.bmhome.rc.i
    public final void a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "processResult");
        this.f313550c.f313553b.invoke(r100);
    }

    @Override // com.larus.bmhome.rc.i
    public final void b(ResourceUploadError r110) {
        Intrinsics.checkNotNullParameter(r110, "processError");
        this.f313550c.f313554c.invoke(r110);     // Catch: Throwable -> L6
        ms8.b r100 = ms8.b.f515490a;
        ms8.b.g(r100, this.f313549b.f313564a, "callback_fail", "fail", null, r110, 40);
        ms8.b.d(r100, this.f313549b.f313564a, "fail", r110, 8);
        return;
    L6:
        th = move-exception;
        ms8.b r111 = ms8.b.f515490a;
        ms8.b.g(r111, this.f313549b.f313564a, "callback_fail", "fail", null, r110, 40);
        ms8.b.d(r111, this.f313549b.f313564a, "fail", r110, 8);
        throw th;
    }

    @Override // com.larus.bmhome.rc.i
    public final void c(l r110) {
        Intrinsics.checkNotNullParameter(r110, "uploadResult");
        if (r110.f515022a != null) goto L11;
        ResourceUploadError r111 = new ResourceUploadError(ResourceUploadError.UPLOAD_ERROR, "tosKey is null");
        this.f313550c.f313554c.invoke(r111);     // Catch: Throwable -> L8
        ms8.b r100 = ms8.b.f515490a;
        ms8.b.g(r100, this.f313549b.f313564a, "callback_fail", "fail", null, r111, 40);
        ms8.b.d(r100, this.f313549b.f313564a, "fail", r111, 8);
        return;
    L8:
        th = move-exception;
        ms8.b r112 = ms8.b.f515490a;
        ms8.b.g(r112, this.f313549b.f313564a, "callback_fail", "fail", null, r111, 40);
        ms8.b.d(r112, this.f313549b.f313564a, "fail", r111, 8);
        throw th;
    L11:
        this.f313550c.f313553b.invoke(new k(99L, false));
        BuildersKt.launch$default(this.f313548a, null, null, new ResourceCenterUploadDelegate$onUploadSuccess$1(this, r110, null), 3, null);
    }

    public final void e(ResourceUploadError r110, Map<String, ? extends Object> r111) {
        ms8.b r100 = ms8.b.f515490a;
        h r101 = this.f313549b;
        j r102 = r101.f313564a;
        FlowResourceScene.a r103 = FlowResourceScene.Companion;
        String r104 = r101.f313567d;
        r103.getClass();
        Map r112 = MapsKt.plus(MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_scene", FlowResourceScene.a.a(r104).name()), TuplesKt.to("register_type", "normal_after_upload"), TuplesKt.to("api_name", "resource_register"), TuplesKt.to("api_path", "/alice/resource/register")}), r111);
        r100.getClass();
        ms8.b.b(r102, "resource_register", "fail", r110, r112);
        FLogger.f375446a.e("ResourceCenterUploadDelegate", "[registerResource] failed, error=" + r110);
        this.f313550c.f313554c.invoke(r110);     // Catch: Throwable -> L6
        ms8.b.g(r100, this.f313549b.f313564a, "callback_fail", "fail", null, r110, 40);
        ms8.b.d(r100, this.f313549b.f313564a, "fail", r110, 8);
        return;
    L6:
        th = move-exception;
        ms8.b r105 = ms8.b.f515490a;
        ms8.b.g(r105, this.f313549b.f313564a, "callback_fail", "fail", null, r110, 40);
        ms8.b.d(r105, this.f313549b.f313564a, "fail", r110, 8);
        throw th;
    }

    public ResourceCenterUploadDelegate(CoroutineScope r100, h r101, com.larus.bmhome.rc.a r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "uploadContext");
        Intrinsics.checkNotNullParameter(r102, "bizCallback");
        this.f313548a = r100;
        this.f313549b = r101;
        this.f313550c = r102;
    }

    public static final Object d(ResourceCenterUploadDelegate r110, l r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof ResourceCenterUploadDelegate$registerResource$1) == false) goto L7;
        ResourceCenterUploadDelegate$registerResource$1 r100 = (ResourceCenterUploadDelegate$registerResource$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        ResourceCenterUploadDelegate$registerResource$1 r102 = r100;
        Object r113 = r102.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r102.label;
        if (r104 == 0) goto L15;
        if (r104 != 1) goto L14;
        ResultKt.throwOnFailure(r113);     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
    L19:
        ResourceRegisterData r114 = (ResourceRegisterData) r113;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        ms8.b r105 = ms8.b.f515490a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        h r115 = r110.f313549b;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        j r106 = r115.f313564a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        FlowResourceScene.a r107 = FlowResourceScene.Companion;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        String r116 = r115.f313567d;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        r107.getClass();     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        ms8.b.c(r105, r106, "resource_register", "success", null, MapsKt.mapOf(new Pair[]{TuplesKt.to("resource_scene", FlowResourceScene.a.a(r116).name()), TuplesKt.to("register_type", "normal_after_upload"), TuplesKt.to("api_name", "resource_register"), TuplesKt.to("api_path", "/alice/resource/register")}), 8);     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
    L30:
        return (ResourceRegisterData) r113;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r113);
        ms8.b r117 = ms8.b.f515490a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        j r108 = r110.f313549b.f313564a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        r117.getClass();     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        ms8.b.i(r108, "resource_register");     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        ResourceCenterPostUploadSupport r118 = ResourceCenterPostUploadSupport.f313547a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        h r119 = r110.f313549b;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        UplinkFileEntity r109 = r119.f313566c;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        ResourceAttachmentExtra r120 = r119.f313565b;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        String r121 = r119.f313567d;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        j r122 = r119.f313564a;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        String r123 = r122.f515010l;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        FlowResourceType r124 = com.larus.bmhome.upload.a.a(r122);     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        Long r125 = r110.f313549b.f313564a.f515018t;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        r102.label = 1;     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        r113 = ResourceCenterPostUploadSupport.b(r111, r109, r120, r121, r123, r124, null, r125, r102, 64);     // Catch: ResourceUploadError -> L21 ResourceRegisterTraceError -> L23
        if (r113 != r103) goto L19;
        return r103;
    L23:
        e = move-exception;
        r110.e(e.getUploadError(), e.getTraceExtra());
    L26:
        return null;
    L21:
        e = move-exception;
        r110.e(e, MapsKt.emptyMap());
    L7:
        r100 = new ResourceCenterUploadDelegate$registerResource$1(r110, r112);
        goto L8
    }
}
