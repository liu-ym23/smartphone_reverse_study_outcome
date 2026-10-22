package com.larus.uaigc.helper;

import com.larus.bmhome.resource.access.ResourceMediaType;
import com.larus.bmhome.resource.access.ResourceNodeHandler;
import com.larus.platform.model.upload.ResourceUploadInstantInfo;
import com.larus.uaigc.api.ReviewUgcImageApi;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u0010J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/uaigc/helper/CreationImageReviewHandler;", "Lcom/larus/bmhome/resource/access/ResourceNodeHandler;", "<init>", "()V", "key", "", "getKey", "()Ljava/lang/String;", "nodeKey", "getNodeKey", "supports", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Lcom/larus/bmhome/resource/access/ResourceContext;", "execute", "Lcom/larus/bmhome/resource/access/NodeResult;", "(Lcom/larus/bmhome/resource/access/ResourceContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "reviewUri", "shouldSkipReviewOnInstantUpload", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationImageReviewHandler implements ResourceNodeHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f372946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f372947b;

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final void getPriority() {
    }

    public CreationImageReviewHandler() {
        this.f372946a = "creation_image_review";
        this.f372947b = "review";
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final String a() {
        return this.f372947b;
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final String getKey() {
        return this.f372946a;
    }

    public static String d(com.larus.bmhome.resource.access.h0 r100) {
        com.larus.bmhome.resource.access.f0 r101 = r100.f313678h;
        if (r101 == null) goto L13;
        String r102 = r101.f313645c;
        if (r102 == null) goto L13;
        if ((!StringsKt.isBlank(r102)) == true) goto L10;
        r102 = null;
    L10:
        if (r102 == null) goto L13;
        return r102;
    L13:
        com.larus.bmhome.resource.access.f0 r103 = r100.f313678h;
        if (r103 == null) goto L22;
        String r104 = r103.f313646d;
        if (r104 != null) goto L18;
        return null;
    L18:
        if ((!StringsKt.isBlank(r104)) == true) goto L20;
        return null;
    L20:
        return r104;
    L22:
        return null;
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final boolean b(com.larus.bmhome.resource.access.h0 r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (a0.b(r100) == false) goto L26;
        com.larus.bmhome.resource.access.w r101 = r100.f313671a;
        if (r101.f313764c != ResourceMediaType.IMAGE) goto L27;
        com.larus.bmhome.resource.access.j0 r102 = r101.f313763b;
        Set<String> r103 = i.f373022a;
        if ((r102 instanceof com.larus.bmhome.resource.access.j0.c) == false) goto L9;
    L12:
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        return false;
    L15:
        if (a0.a(r100, "enable_review", new q()) == false) goto L29;
        String r105 = d(r100);
        if (r105 != null) goto L19;
    L22:
        boolean r106 = true;
    L23:
        if (r106 == true) goto L30;
        return true;
    L30:
        return false;
    L19:
        if (StringsKt.isBlank(r105) == true) goto L22;
        r106 = false;
        goto L23
    L29:
        return false;
    L9:
        if ((r102 instanceof com.larus.bmhome.resource.access.j0.d) == true) goto L12;
        r104 = false;
        goto L13
    L27:
        return false;
    L26:
        return false;
    }

    @Override // com.larus.bmhome.resource.access.ResourceNodeHandler
    public final Object c(com.larus.bmhome.resource.access.h0 r210, Continuation<? super com.larus.bmhome.resource.access.g> r211) {
        if ((r211 instanceof CreationImageReviewHandler$execute$1) == false) goto L7;
        CreationImageReviewHandler$execute$1 r100 = (CreationImageReviewHandler$execute$1) r211;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        String r105 = null;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        String r106 = (String) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L42:
        dm9.a r107 = (dm9.a) r102;
        boolean r108 = r107 instanceof dm9.a.b;
        if (r108 == false) goto L57;
        dm9.a.b r109 = (dm9.a.b) r107;
        if (r109.f469231a.isSuccess() == false) goto L57;
        ReviewUgcImageApi.c r110 = (ReviewUgcImageApi.c) r109.f469231a.getData();
        if (r110 == null) goto L54;
        Integer r111 = r110.a();
        if (r111 == null) goto L54;
        if (r111.intValue() != 3) goto L54;
        boolean r112 = true;
    L55:
        if (r112 == false) goto L57;
        return new com.larus.bmhome.resource.access.g.b(new com.larus.bmhome.resource.access.r(this.f372947b, "review_un_pass", "creation image review unpass", null));
    L54:
        r112 = false;
    L57:
        if (r108 == false) goto L68;
        dm9.a.b r113 = (dm9.a.b) r107;
        if (r113.f469231a.isSuccess() == false) goto L68;
        Pair[] r114 = new Pair[2];
        r114[0] = TuplesKt.to("review_result", CreationReviewState.PASS.getValue());
        ReviewUgcImageApi.c r115 = (ReviewUgcImageApi.c) r113.f469231a.getData();
        if (r115 == null) goto L65;
        Boolean r116 = r115.b();
        if (r116 == null) goto L65;
        r105 = r116.toString();
    L65:
        if (r105 != null) goto L67;
        r105 = "";
    L67:
        r114[1] = TuplesKt.to("face_detected", r105);
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(r114), 63));
    L68:
        FLogger.f375446a.w("CreationImageNodeHandlers", "[review] degraded, uri=" + r106);
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to("review_result", CreationReviewState.DEGRADE.getValue())), 63));
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        String r117 = d(r210);
        if (r117 == null) goto L17;
        f.f373014a.getClass();
        Boolean r118 = f.b().b();
        Boolean r119 = Boolean.TRUE;
        if (Intrinsics.areEqual(r118, r119) == false) goto L34;
        com.larus.bmhome.resource.access.f0 r120 = r210.f313678h;
        if (r120 == null) goto L34;
        mr9.l r121 = r120.f313647e;
        if (r121 == null) goto L34;
        if (r121.f515027f == true) goto L33;
        ResourceUploadInstantInfo r122 = r121.f515028g;
        if (r122 == null) goto L31;
        boolean r123 = Intrinsics.areEqual(r122.getPreQueryHit(), r119);
    L32:
        if (r123 == false) goto L34;
    L31:
        r123 = false;
    L33:
        boolean r124 = true;
    L35:
        if (r124 == false) goto L38;
        FLogger.f375446a.i("CreationImageNodeHandlers", "[review] skip on instant hit");
        return new com.larus.bmhome.resource.access.g.a(new com.larus.bmhome.resource.access.i0(null, null, null, null, null, null, MapsKt.mapOf(TuplesKt.to("review_result", CreationReviewState.INSTANT_SKIP.getValue())), 63));
    L38:
        ReviewUgcImageApi.Companion r125 = ReviewUgcImageApi.f370263a;
        CreationImageReviewHandler$execute$checkResult$1 r126 = new CreationImageReviewHandler$execute$checkResult$1(r117, null);
        r100.L$0 = r117;
        r100.label = 1;
        r125.getClass();
        Object r127 = ReviewUgcImageApi.Companion.a(r126, r100);
        if (r127 != r103) goto L41;
        return r103;
    L41:
        r106 = r117;
        r102 = r127;
    L34:
        r124 = false;
        goto L35
    L17:
        return com.larus.bmhome.resource.access.g.e.f313653a;
    L7:
        r100 = new CreationImageReviewHandler$execute$1(this, r211);
        goto L8
    }
}
