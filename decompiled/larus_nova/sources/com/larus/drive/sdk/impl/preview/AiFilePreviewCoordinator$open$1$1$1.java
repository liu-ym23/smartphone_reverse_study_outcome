package com.larus.drive.sdk.impl.preview;

import android.content.Context;
import android.webkit.MimeTypeMap;
import com.bytedance.ee.drive.preview.DrivePreviewOpenItem;
import com.bytedance.ee.drive.preview.DrivePreviewOpenRequest;
import com.bytedance.ee.drive.preview.DrivePreviewResType;
import com.bytedance.ee.drive.preview.d;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.drive.sdk.impl.service.t;
import com.larus.drive.sdk.impl.store.DrivePreviewRequestStore;
import com.larus.drive.sdk.impl.utils.k;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$open$1$1$1", f = "AiFilePreviewCoordinator.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AiFilePreviewCoordinator$open$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $accountId;
    final /* synthetic */ Context $context;
    final /* synthetic */ Function0<Unit> $fallback;
    final /* synthetic */ cr9.a $request;
    final /* synthetic */ AiFilePreviewCoordinator.a $resolved;
    final /* synthetic */ CoroutineScope $scope;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$open$1$1$1$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.drive.sdk.impl.preview.AiFilePreviewCoordinator$open$1$1$1$2", f = "AiFilePreviewCoordinator.kt", i = {}, l = {98}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $accountId;
        final /* synthetic */ Context $context;
        final /* synthetic */ Function0<Unit> $fallback;
        final /* synthetic */ String $requestId;
        final /* synthetic */ CoroutineScope $scope;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        public AnonymousClass2(Context r100, CoroutineScope r101, String r102, String r103, Function0<Unit> r104, Continuation<? super AnonymousClass2> r105) {
            this.$context = r100;
            this.$scope = r101;
            this.$accountId = r102;
            this.$requestId = r103;
            this.$fallback = r104;
            super(2, r105);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r110) {
            AnonymousClass2 r101 = new AnonymousClass2(this.$context, this.$scope, this.$accountId, this.$requestId, this.$fallback, r110);
            r101.L$0 = r100;
            return r101;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 != 1) goto L9;
            String r103 = (String) this.L$3;
            String r104 = (String) this.L$2;
            CoroutineScope r105 = (CoroutineScope) this.L$1;
            Context r106 = (Context) this.L$0;
            ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L24
        L16:
            if (AiFilePreviewCoordinator.b(r106, r105, r104) == true) goto L18;
            FLogger.f375446a.i("AiFilePreview", "cancel, stage=container_ready_timeout");     // Catch: Throwable -> L24
            Object r107 = Boxing.boxBoolean(DrivePreviewRequestStore.f341970a.c(r103));     // Catch: Throwable -> L24
        L22:
            Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L24
        L26:
            Context r109 = this.$context;
            CoroutineScope r110 = this.$scope;
            String r111 = this.$accountId;
            Function0<Unit> r112 = this.$fallback;
            Throwable r113 = Result.m9452exceptionOrNullimpl(r108);
            if (r113 == null) goto L33;
            if ((r113 instanceof CancellationException) == true) goto L31;
            FLogger.f375446a.e("AiFilePreview", "fallback, stage=container_ready_timeout, errorType=".concat(r113.getClass().getSimpleName()), r113);
            AiFilePreviewCoordinator.a(r109, r110, r111, r112);
            goto L33
        L31:
            throw r113;
        L33:
            return Unit.INSTANCE;
        L18:
            if (DrivePreviewRequestStore.f341970a.d(r103) == false) goto L20;
            FLogger.f375446a.w("AiFilePreview", "fallback, stage=container_ready_timeout");     // Catch: Throwable -> L24
        L20:
            r107 = Unit.INSTANCE;     // Catch: Throwable -> L24
            goto L22
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r100);
            CoroutineScope r114 = (CoroutineScope) this.L$0;
            r106 = this.$context;
            CoroutineScope r115 = this.$scope;
            r104 = this.$accountId;
            String r116 = this.$requestId;
            Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L24
            this.L$0 = r106;     // Catch: Throwable -> L24
            this.L$1 = r115;     // Catch: Throwable -> L24
            this.L$2 = r104;     // Catch: Throwable -> L24
            this.L$3 = r116;     // Catch: Throwable -> L24
            this.label = 1;     // Catch: Throwable -> L24
            if (DelayKt.delay(20000, this) != r101) goto L14;
            return r101;
        L14:
            r105 = r115;
            r103 = r116;
        L24:
            th = move-exception;
            Result.Companion r118 = Result.Companion;
            r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L26
        }
    }

    public AiFilePreviewCoordinator$open$1$1$1(Context r100, CoroutineScope r101, String r102, AiFilePreviewCoordinator.a r103, cr9.a r104, Function0<Unit> r105, Continuation<? super AiFilePreviewCoordinator$open$1$1$1> r106) {
        this.$context = r100;
        this.$scope = r101;
        this.$accountId = r102;
        this.$resolved = r103;
        this.$request = r104;
        this.$fallback = r105;
        super(2, r106);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        AiFilePreviewCoordinator$open$1$1$1 r100 = new AiFilePreviewCoordinator$open$1$1$1(this.$context, this.$scope, this.$accountId, this.$resolved, this.$request, this.$fallback, r111);
        r100.L$0 = r110;
        return r100;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AiFilePreviewCoordinator$open$1$1$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [com.larus.drive.sdk.impl.preview.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [com.larus.drive.sdk.impl.preview.b, java.lang.Object] */
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
    public final Object invokeSuspend(Object r410) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L116;
        ResultKt.throwOnFailure(r410);
        final CoroutineScope r100 = (CoroutineScope) this.L$0;
        AiFilePreviewCoordinator r101 = AiFilePreviewCoordinator.f341877a;
        if (AiFilePreviewCoordinator.b(this.$context, this.$scope, this.$accountId) == true) goto L8;
        FLogger.f375446a.i("AiFilePreview", "cancel on route, reason=context_changed");
        return Unit.INSTANCE;
    L8:
        k r102 = k.f342040a;
        Context r103 = this.$context;
        AiFilePreviewCoordinator.a r104 = this.$resolved;
        String r105 = r104.f341878a;
        int r110 = r104.f341879b;
        String r106 = r104.f341881d;
        DrivePreviewResType r107 = r104.f341882e;
        cr9.a r108 = this.$request;
        String r111 = r108.f465109c;
        String r112 = r108.f465110d;
        String r109 = r104.f341880c;
        String r113 = r108.f465107a;
        String r114 = r108.f465112f;
        String r115 = r108.f465111e;
        String r116 = r108.f465113g;
        if (r116 != null) goto L11;
        String r210 = null;
    L16:
        String r117 = this.$request.f465114h;
        if (r117 != null) goto L19;
        String r211 = null;
    L24:
        String r118 = this.$request.f465115i;
        if (r118 != null) goto L27;
        String r212 = null;
    L32:
        final Context r119 = this.$context;
        final CoroutineScope r120 = this.$scope;
        final String r121 = this.$accountId;
        final Function0<Unit> r122 = this.$fallback;
        ?? r123 = new a(r119, r120, r121, r122);
        ?? r124 = new b(r119, r120, r121);
        r102.getClass();
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r105, "fileToken");
        Intrinsics.checkNotNullParameter(r106, "appId");
        Intrinsics.checkNotNullParameter(r107, "resType");
        Intrinsics.checkNotNullParameter(r113, "resourceUri");
        Intrinsics.checkNotNullParameter(r123, "launchFailureFallback");
        Intrinsics.checkNotNullParameter(r124, "isLaunchActive");
        if (StringsKt.isBlank(r105) == true) goto L105;
        if (r110 <= 0) goto L105;
        if (r112 == null) goto L40;
        String r125 = StringsKt.trim(r112).toString();
        if (r125 == null) goto L40;
        String r126 = r125.toLowerCase(Locale.ROOT);
    L41:
        if (r126 != null) goto L43;
    L46:
        boolean r213 = true;
    L47:
        if (r213 == false) goto L49;
        String r214 = "launchFailureFallback";
        String r215 = "DrivePreviewHelper";
        String r127 = r113;
        String r128 = null;
        String r129 = null;
    L54:
        if (r128 != null) goto L56;
    L64:
        if (r111 == null) goto L75;
        String r130 = StringsKt.substringAfterLast(r111, '.', "");
        if (r130 == null) goto L75;
        r128 = r130.toLowerCase(Locale.ROOT);
        if (r128 == null) goto L75;
        if (r128.length() <= 0) goto L72;
        boolean r131 = true;
    L73:
        if (r131 == false) goto L75;
    L76:
        String r310 = r214;
        String r411 = r215;
        String r216 = r129;
        String r412 = r127;
        DrivePreviewOpenRequest r132 = new DrivePreviewOpenRequest(new DrivePreviewOpenItem(r106, r107, r105, r110, r111, null, r128, null, r109, null, null, null, 3744, null), null, null, null, 14, null);
        Result.Companion r133 = Result.Companion;     // Catch: Throwable -> L84
        d r134 = t.f341962a;     // Catch: Throwable -> L84
        d r135 = t.f341962a;     // Catch: Throwable -> L84
        if (r135 == null) goto L82;
        DrivePreviewOpenRequest r136 = r135.o9(r132);     // Catch: Throwable -> L84
        if (r136 == null) goto L82;
        r132 = r136;
    L82:
        Object r137 = Result.m9449constructorimpl(r132);     // Catch: Throwable -> L84
    L86:
        Throwable r138 = Result.m9452exceptionOrNullimpl(r137);
        if (r138 == null) goto L89;
        String r139 = r411;
        FLogger.f375446a.e(r139, "prepare AI file preview request failed, errorType=".concat(r138.getClass().getSimpleName()));
    L91:
        if (Result.m9452exceptionOrNullimpl(r137) != null) goto L104;
        DrivePreviewOpenRequest r140 = (DrivePreviewOpenRequest) r137;
        DrivePreviewRequestStore r141 = DrivePreviewRequestStore.f341970a;
        Intrinsics.checkNotNullParameter(r140, "request");
        Intrinsics.checkNotNullParameter(r412, "resourceUri");
        Intrinsics.checkNotNullParameter(r123, r310);
        Intrinsics.checkNotNullParameter(r124, "isLaunchActive");
        String r142 = r141.f(r140, new com.larus.drive.sdk.impl.store.a(r140, r412, r114, r115, r111, r112, r210, r211, r212), r123, r124);
        i r143 = SmartRouter.buildRoute(r103, "//flow/drive_preview");     // Catch: Throwable -> L95
        r143.f267554c.putExtra("ai_file_preview_request_id", r142);     // Catch: Throwable -> L95
        r143.d();     // Catch: Throwable -> L95
        Object r144 = Result.m9449constructorimpl(r142);     // Catch: Throwable -> L95
    L97:
        Object r145 = r144;
        Throwable r146 = Result.m9452exceptionOrNullimpl(r145);
        if (r146 == null) goto L101;
        FLogger.f375446a.e(r139, "open AI file preview route failed, errorType=".concat(r146.getClass().getSimpleName()));
        DrivePreviewRequestStore.f341970a.d(r142);
    L101:
        if (Result.m9455isFailureimpl(r145) == false) goto L103;
        r145 = r216;
    L103:
        final String r147 = (String) r145;
    L107:
        if (r147 == null) goto L109;
        Job r148 = (Job) this.$scope.getCoroutineContext().get(Job.Key);
        if (r148 == null) goto L113;
        r148.invokeOnCompletion(new c(r100, r147));
    L113:
        CoroutineScope r149 = this.$scope;
        BuildersKt.launch$default(r149, null, null, new AnonymousClass2(this.$context, r149, this.$accountId, r147, this.$fallback, null), 3, null);
        FLogger.f375446a.i("AiFilePreview", "start route, scene=" + this.$request.f465108b.name());
        return Unit.INSTANCE;
    L109:
        return Unit.INSTANCE;
    L95:
        th = move-exception;
        Result.Companion r150 = Result.Companion;
        r144 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L97
    L104:
        r123.invoke();
    L106:
        r147 = r216;
        goto L107
    L89:
        r139 = r411;
    L84:
        th = move-exception;
        Result.Companion r151 = Result.Companion;
        r137 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L86
    L72:
        r131 = false;
    L75:
        r128 = r129;
        goto L76
    L56:
        if (r128.length() <= 0) goto L58;
        boolean r152 = true;
    L59:
        if (r152 == true) goto L62;
        r128 = r129;
    L62:
        if (r128 == null) goto L64;
    L58:
        r152 = false;
        goto L59
    L49:
        r214 = "launchFailureFallback";
        r215 = "DrivePreviewHelper";
        r127 = r113;
        r129 = null;
        if (StringsKt.contains$default(r126, '/', false, 2, null) == false) goto L53;
        r128 = MimeTypeMap.getSingleton().getExtensionFromMimeType(r126);
        goto L54
    L53:
        r128 = StringsKt.trimStart(r126, new char[]{'.'});
        goto L54
    L43:
        if (r126.length() == 0) goto L46;
        r213 = false;
    L40:
        r126 = null;
    L105:
        r216 = null;
        FLogger.f375446a.w("DrivePreviewHelper", "skip AI file preview, reason=invalid_request");
        r123.invoke();
        goto L106
    L27:
        if ((!StringsKt.isBlank(r118)) == true) goto L30;
        r118 = null;
    L30:
        r212 = r118;
        goto L32
    L19:
        if ((!StringsKt.isBlank(r117)) == true) goto L22;
        r117 = null;
    L22:
        r211 = r117;
        goto L24
    L11:
        if ((!StringsKt.isBlank(r116)) == true) goto L14;
        r116 = null;
    L14:
        r210 = r116;
        goto L16
    L116:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
