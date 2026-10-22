package com.larus.livetutor.impl.rtc;

import android.util.Base64;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.livetutor.api.idl.BizParams;
import com.larus.livetutor.api.idl.BizScenes;
import com.larus.livetutor.api.idl.DoubaoActionbarPageQueryParams;
import com.larus.livetutor.api.idl.Image;
import com.larus.livetutor.api.idl.LiveTutorV2Params;
import com.larus.livetutor.api.idl.StartCallRequest;
import com.larus.livetutor.api.idl.TutorEntranceType;
import com.larus.livetutor.impl.utils.track.LiveTutorTrackerService;
import com.larus.utils.o0;
import com.larus.utils.y0;
import java.io.IOException;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.livetutor.impl.rtc.TutorRtcService$requestConnectService$2$1", f = "TutorRtcService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class TutorRtcService$requestConnectService$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ LiveTutorV2Params $params;
    final /* synthetic */ ij9.b $rtc;
    int label;
    final /* synthetic */ l0 this$0;

    public TutorRtcService$requestConnectService$2$1(l0 r100, LiveTutorV2Params r101, ij9.b r102, Continuation<? super TutorRtcService$requestConnectService$2$1> r103) {
        this.this$0 = r100;
        this.$params = r101;
        this.$rtc = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new TutorRtcService$requestConnectService$2$1(this.this$0, this.$params, this.$rtc, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((TutorRtcService$requestConnectService$2$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [com.larus.livetutor.impl.rtc.k0] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L81;
        ResultKt.throwOnFailure(r110);
        kj9.b.a("requestConnectService");
        LiveTutorTrackerService r100 = kj9.b.c();
        if (r100 == null) goto L7;
        LiveTutorTrackerService.i(r100, "request_start_call", null, "", 0, 18);
    L7:
        l0 r111 = this.this$0;
        LiveTutorV2Params r101 = this.$params;
        r111.getClass();
        String r112 = null;
        if (r101 == null) goto L75;
        Integer r102 = r101.getTutorEntranceType();
        int r103 = TutorEntranceType.DoubaoActionbarPage.getValue();
        if (r102 == null) goto L75;
        if (r102.intValue() != r103) goto L75;
        DoubaoActionbarPageQueryParams r104 = r101.getDoubaoActionbarPageQueryParams();
        if (r104 == null) goto L20;
        List<Image> r105 = r104.getImages();
        if (r105 == null) goto L20;
        Image r106 = (Image) CollectionsKt.firstOrNull(r105);
    L21:
        if (r106 == null) goto L23;
        String r107 = r106.getImageUrl();
    L24:
        if (r106 == null) goto L26;
        String r108 = r106.getImageBase64();
    L28:
        if (o0.d(r107) == false) goto L72;
        boolean r109 = true;
        if (r108 != null) goto L32;
    L35:
        boolean r113 = true;
    L36:
        if (r113 == false) goto L72;
        kj9.b.b("checkV2Params trans ImageUrl = " + r107 + " to base64");
        DoubaoActionbarPageQueryParams r114 = r101.getDoubaoActionbarPageQueryParams();
        if (r114 == null) goto L64;
        List<Image> r115 = r114.getImages();
        if (r115 == null) goto L64;
        Image r116 = (Image) CollectionsKt.firstOrNull(r115);
        if (r116 == null) goto L64;
        if (r107 != null) goto L45;
    L48:
        if (r109 == false) goto L51;
    L62:
        String r117 = null;
    L63:
        r116.setImageBase64(r117);
        goto L64
    L51:
        if (y0.e(r107) == true) goto L62;
        PolarisFileWrapper r118 = new PolarisFileWrapper(r107);     // Catch: IOException -> L60
        if (r118.exists() == false) goto L62;
        if (r118.isFile() == false) goto L62;
        PolarisFileInputStreamWrapper r119 = new PolarisFileInputStreamWrapper(r118);     // Catch: IOException -> L60
        byte[] r120 = new byte[(int) r118.length()];     // Catch: IOException -> L60
        r119.read(r120);     // Catch: IOException -> L60
        r119.close();     // Catch: IOException -> L60
        r117 = Base64.encodeToString(r120, 2);     // Catch: IOException -> L60
    L60:
        e = move-exception;
        e.printStackTrace();
        goto L62
    L45:
        if (r107.length() == 0) goto L48;
        r109 = false;
    L64:
        DoubaoActionbarPageQueryParams r121 = r101.getDoubaoActionbarPageQueryParams();
        if (r121 == null) goto L75;
        List<Image> r122 = r121.getImages();
        if (r122 == null) goto L75;
        Image r123 = (Image) CollectionsKt.firstOrNull(r122);
        if (r123 == null) goto L75;
        r123.setImageUrl("");
        goto L75
    L32:
        if (r108.length() == 0) goto L35;
        r113 = false;
    L72:
        if (o0.d(r108) == false) goto L74;
        kj9.b.a("checkV2Params imageBase64 is not empty");
        goto L75
    L74:
        kj9.b.b("checkV2Params imageUrl is empty");
        goto L75
    L26:
        r108 = null;
        goto L28
    L23:
        r107 = null;
    L20:
        r106 = null;
    L75:
        ij9.b r124 = this.$rtc;
        this.this$0.getClass();
        BizParams r125 = new BizParams(Boxing.boxLong(AppHost.f326268a.getAppId()), Boxing.boxLong(BizScenes.RtcLiveTutorProd.getValue()), null, null, this.$params, null, 44, null);
        LiveTutorV2Params r126 = this.$params;
        if (r126 == null) goto L78;
        r112 = r126.getEnterMethod();
    L78:
        StartCallRequest r127 = new StartCallRequest(r125, r112, MapsKt.emptyMap());
        final l0 r128 = this.this$0;
        r124.b(r127, r128.f356398c, new k0(r128));
        return Unit.INSTANCE;
    L81:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
