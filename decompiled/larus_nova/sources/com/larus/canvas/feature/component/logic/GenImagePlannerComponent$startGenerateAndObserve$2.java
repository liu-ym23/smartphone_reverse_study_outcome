package com.larus.canvas.feature.component.logic;

import androidx.lifecycle.LifecycleOwnerKt;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.canvas.service.bean.CanvasBlock;
import com.larus.canvas.service.bean.CanvasImageBlock;
import com.larus.canvas.service.bean.CanvasInfo;
import com.larus.platform.IFlowSdkDepend;
import com.larus.uaigc.nowatermark.CreationNoWatermarkManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$startGenerateAndObserve$2", f = "GenImagePlannerComponent.kt", i = {}, l = {1027}, m = "invokeSuspend", n = {}, s = {})
final class GenImagePlannerComponent$startGenerateAndObserve$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ky8.c $param;
    final /* synthetic */ CompletableDeferred<Unit> $releaseSignal;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ GenImagePlannerComponent this$0;

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.GenImagePlannerComponent$startGenerateAndObserve$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/larus/canvas/feature/component/logic/canvasGenerator/SseUpdateData;", "", "Lcom/larus/canvas/service/bean/CanvasBlock;", "t", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.canvas.feature.component.logic.GenImagePlannerComponent$startGenerateAndObserve$2$1", f = "GenImagePlannerComponent.kt", i = {}, l = {1016, 1019}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super com.larus.canvas.feature.component.logic.canvasGenerator.k<? extends List<? extends CanvasBlock>>>, Throwable, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<List<CanvasBlock>> $cachedBlockList;
        final /* synthetic */ ky8.c $param;
        final /* synthetic */ CompletableDeferred<Unit> $releaseSignal;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ GenImagePlannerComponent this$0;

        public AnonymousClass1(Ref.ObjectRef<List<CanvasBlock>> r100, GenImagePlannerComponent r101, ky8.c r102, CompletableDeferred<Unit> r103, Continuation<? super AnonymousClass1> r104) {
            this.$cachedBlockList = r100;
            this.this$0 = r101;
            this.$param = r102;
            this.$releaseSignal = r103;
            super(3, r104);
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super com.larus.canvas.feature.component.logic.canvasGenerator.k<? extends List<? extends CanvasBlock>>> r100, Throwable r101, Continuation<? super Unit> r102) {
            return invoke2(r100, r101, r102);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super com.larus.canvas.feature.component.logic.canvasGenerator.k<? extends List<CanvasBlock>>> r100, Throwable r101, Continuation<? super Unit> r102) {
            AnonymousClass1 r103 = new AnonymousClass1(this.$cachedBlockList, this.this$0, this.$param, this.$releaseSignal, r102);
            r103.L$0 = r101;
            return r103.invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r110);
        L39:
            GenImagePlannerComponent.C3(this.this$0, this.$param.f506681c, (List) r110);
            this.this$0.e4().cancelProgress(this.$param.f506681c);
        L41:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r110);
        L35:
            Boxing.boxBoolean(this.$releaseSignal.complete(Unit.INSTANCE));
            goto L41
        L10:
            ResultKt.throwOnFailure(r110);
            Throwable r111 = (Throwable) this.L$0;
            FLogger.f375446a.e("GenImagePlannerComponent", "generate error, msg: " + r111.getMessage(), r111);
            CanvasBlock r102 = (CanvasBlock) CollectionsKt.firstOrNull(this.$cachedBlockList.element);
            if (r102 == null) goto L22;
            CanvasImageBlock r103 = r102.content;
            if (r103 == null) goto L22;
            CanvasInfo r104 = r103.canvasInfo;
            if (r104 == null) goto L22;
            Integer r105 = r104.canvasStatus;
            if (r105 == null) goto L22;
            if (r105.intValue() != 10) goto L22;
            boolean r106 = true;
        L23:
            if (r106 == true) goto L36;
            ky8.f r107 = this.this$0.O30(this.$param.f506681c);
            if (r107 == null) goto L32;
            GenImagePlannerComponent r108 = this.this$0;
            com.larus.canvas.feature.component.logic.trace.a r109 = r108.X3();
            if (r109 == null) goto L29;
            r109.Xv(r107, true);
        L29:
            com.larus.canvas.feature.component.logic.trace.a r112 = r108.X3();
            if (r112 == null) goto L32;
            com.larus.canvas.feature.component.logic.trace.a.C4166a.a(r112, r107, true);
        L32:
            GenImagePlannerComponent r113 = this.this$0;
            String r114 = this.$param.f506681c;
            List<CanvasBlock> r115 = this.$cachedBlockList.element;
            String r116 = r111.getMessage();
            this.label = 1;
            if (GenImagePlannerComponent.j4(r113, r114, r115, r116, this, 8) != r100) goto L35;
            return r100;
        L36:
            GenImagePlannerComponent r117 = this.this$0;
            String r118 = this.$param.f506681c;
            List<CanvasBlock> r119 = this.$cachedBlockList.element;
            this.label = 2;
            r110 = GenImagePlannerComponent.p3(r117, r118, r119, this);
            if (r110 != r100) goto L39;
            return r100;
        L22:
            r106 = false;
            goto L23
        }
    }

    /* JADX INFO: renamed from: com.larus.canvas.feature.component.logic.GenImagePlannerComponent$startGenerateAndObserve$2$2, reason: invalid class name */
    public static final class AnonymousClass2<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoroutineScope f323275a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Ref.ObjectRef<List<CanvasBlock>> f323276b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ GenImagePlannerComponent f323277c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ ky8.c f323278d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ CompletableDeferred<Unit> f323279e;

        public AnonymousClass2(CoroutineScope r100, Ref.ObjectRef<List<CanvasBlock>> r101, GenImagePlannerComponent r102, ky8.c r103, CompletableDeferred<Unit> r104) {
            this.f323275a = r100;
            this.f323276b = r101;
            this.f323277c = r102;
            this.f323278d = r103;
            this.f323279e = r104;
        }

        /* JADX WARN: Type inference failed for: r2v15, types: [T, java.util.List] */
        public final Object a(com.larus.canvas.feature.component.logic.canvasGenerator.k<? extends List<CanvasBlock>> r310, Continuation<? super Unit> r311) {
            if ((r311 instanceof GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1) == false) goto L7;
            GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1 r100 = (GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1) r311;
            int r101 = r100.label;
            if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
            r100.label = r101 - Integer.MIN_VALUE;
        L8:
            GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1 r102 = r100;
            Object r103 = r102.result;
            Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r105 = r102.label;
            if (r105 == 0) goto L18;
            if (r105 == 1) goto L17;
            if (r105 == 2) goto L16;
            if (r105 != 3) goto L15;
            CompletableDeferred<Unit> r106 = (CompletableDeferred) r102.L$0;
            ResultKt.throwOnFailure(r103);
        L133:
            r106.complete(Unit.INSTANCE);
        L135:
            return Unit.INSTANCE;
        L15:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L16:
            CompletableDeferred<Unit> r107 = (CompletableDeferred) r102.L$1;
            com.larus.canvas.feature.component.logic.canvasGenerator.k r108 = (com.larus.canvas.feature.component.logic.canvasGenerator.k) r102.L$0;
            ResultKt.throwOnFailure(r103);
        L96:
            Boxing.boxBoolean(r107.complete(Unit.INSTANCE));
            goto L135
        L17:
            CompletableDeferred<Unit> r109 = (CompletableDeferred) r102.L$4;
            ky8.c r110 = (ky8.c) r102.L$3;
            GenImagePlannerComponent r111 = (GenImagePlannerComponent) r102.L$2;
            Ref.ObjectRef<List<CanvasBlock>> r112 = (Ref.ObjectRef) r102.L$1;
            com.larus.canvas.feature.component.logic.canvasGenerator.k r113 = (com.larus.canvas.feature.component.logic.canvasGenerator.k) r102.L$0;
            ResultKt.throwOnFailure(r103);
        L40:
            ?? r114 = (T) ((List) r103);
            r112.element = r114;
            IFlowSdkDepend r115 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r115 == null) goto L43;
            r115.r0();
            com.larus.home.impl.sdk.e2.f346164a.x();
        L43:
            GenImagePlannerComponent.C3(r111, r110.f506681c, r114);
            r111.e4().cancelProgress(r110.f506681c);
            Boxing.boxBoolean(r109.complete(Unit.INSTANCE));
            goto L135
        L18:
            ResultKt.throwOnFailure(r103);
            Integer r116 = null;
            if ((r310 instanceof com.larus.canvas.feature.component.logic.canvasGenerator.k.b) == false) goto L21;
            com.larus.canvas.feature.component.logic.canvasGenerator.k.b r117 = (com.larus.canvas.feature.component.logic.canvasGenerator.k.b) r310;
        L22:
            boolean r118 = false;
            if (r117 == null) goto L97;
            Ref.ObjectRef<List<CanvasBlock>> r119 = this.f323276b;
            GenImagePlannerComponent r120 = this.f323277c;
            ky8.c r121 = this.f323278d;
            CompletableDeferred<Unit> r122 = this.f323279e;
            T r123 = r117.f323340a;
            r119.element = r123;
            CanvasBlock r124 = (CanvasBlock) CollectionsKt.firstOrNull((List) r123);
            if (r124 == null) goto L32;
            CanvasImageBlock r125 = r124.content;
            if (r125 == null) goto L32;
            CanvasInfo r126 = r125.canvasInfo;
            if (r126 == null) goto L32;
            r116 = r126.canvasStatus;
        L32:
            if (r116 != null) goto L35;
        L44:
            if (r116 == null) goto L49;
            if (r116.intValue() != 11) goto L49;
        L84:
            ky8.f r127 = r120.O30(r121.f506681c);
            if (r127 == null) goto L92;
            com.larus.canvas.feature.component.logic.trace.a r128 = r120.X3();
            if (r128 == null) goto L89;
            r128.Xv(r127, true);
        L89:
            com.larus.canvas.feature.component.logic.trace.a r129 = r120.X3();
            if (r129 == null) goto L92;
            com.larus.canvas.feature.component.logic.trace.a.C4166a.a(r129, r127, true);
        L92:
            String r130 = r121.f506681c;
            List r131 = (List) r117.f323340a;
            r102.L$0 = r310;
            r102.L$1 = r122;
            r102.label = 2;
            if (GenImagePlannerComponent.j4(r120, r130, r131, null, r102, 12) != r104) goto L95;
            return r104;
        L95:
            r107 = r122;
        L49:
            if (r117.f323341b == false) goto L55;
            if (r116 == null) goto L84;
            if (r116.intValue() != 10) goto L84;
        L55:
            String r132 = r121.f506681c;
            List r133 = (List) r117.f323340a;
            int r134 = GenImagePlannerComponent.W;
            r120.getClass();
            CanvasBlock r135 = (CanvasBlock) CollectionsKt.firstOrNull(r133);
            if (r135 == null) goto L67;
            CanvasImageBlock r136 = r135.content;
            if (r136 == null) goto L67;
            CanvasInfo r137 = r136.canvasInfo;
            if (r137 == null) goto L67;
            Integer r138 = r137.canvasStatus;
            if (r138 == null) goto L67;
            if (r138.intValue() != 10) goto L67;
            boolean r139 = true;
        L68:
            if (r139 == true) goto L81;
            List r140 = GenImagePlannerComponent.Q3(r133);
            if (((ArrayList) r140).isEmpty() == true) goto L81;
            StringBuilder r141 = new StringBuilder();
            r141.append(r132);
            r141.append(':');
            CreationNoWatermarkManager.f373832a.getClass();
            CreationNoWatermarkManager.f r142 = CreationNoWatermarkManager.i(r140);
            if (r142.a() == false) goto L76;
            String r143 = "";
        L77:
            r141.append(r143);
            String r144 = r141.toString();
            if (r120.T.get(r144) != null) goto L81;
            r120.T.put(r144, Unit.INSTANCE);
            BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r120), Dispatchers.getIO(), null, new GenImagePlannerComponent$prefetchNoWatermarkBlocksForReview$1(r140, r120, r132, r133, r144, null), 2, null);
            goto L81
        L76:
            r143 = CollectionsKt.joinToString$default(CollectionsKt.listOf(new String[]{"image:" + CollectionsKt.joinToString$default(CollectionsKt.sorted(r142.f373867a), ",", null, null, 0, null, null, 62, null), "video:" + CollectionsKt.joinToString$default(CollectionsKt.sorted(r142.f373868b), ",", null, null, 0, null, null, 62, null)}), HiAnalyticsConstant.REPORT_VAL_SEPARATOR, null, null, 0, null, null, 62, null);
        L81:
            GenImagePlannerComponent.C3(r120, r121.f506681c, (List) r117.f323340a);
            if (r117.f323341b == false) goto L135;
            r120.e4().cancelProgress(r121.f506681c);
        L67:
            r139 = false;
            goto L68
        L35:
            if (r116.intValue() != 10) goto L44;
            String r145 = r121.f506681c;
            List r146 = (List) r117.f323340a;
            r102.L$0 = r310;
            r102.L$1 = r119;
            r102.L$2 = r120;
            r102.L$3 = r121;
            r102.L$4 = r122;
            r102.label = 1;
            r103 = GenImagePlannerComponent.p3(r120, r145, r146, r102);
            if (r103 != r104) goto L39;
            return r104;
        L39:
            r112 = r119;
            r109 = r122;
            r110 = r121;
            r111 = r120;
            goto L40
        L97:
            GenImagePlannerComponent r147 = this.f323277c;
            ky8.c r148 = this.f323278d;
            CompletableDeferred<Unit> r149 = this.f323279e;
            FLogger r150 = FLogger.f375446a;
            StringBuilder r151 = new StringBuilder("generate error, code: ");
            boolean r152 = r310 instanceof com.larus.canvas.feature.component.logic.canvasGenerator.k.a;
            if (r152 == false) goto L100;
            com.larus.canvas.feature.component.logic.canvasGenerator.k.a r153 = (com.larus.canvas.feature.component.logic.canvasGenerator.k.a) r310;
        L101:
            if (r153 == null) goto L103;
            Integer r154 = Boxing.boxInt(r153.f323337a);
        L104:
            r151.append(r154);
            r151.append(", msg: ");
            if (r152 == false) goto L107;
            com.larus.canvas.feature.component.logic.canvasGenerator.k.a r155 = (com.larus.canvas.feature.component.logic.canvasGenerator.k.a) r310;
        L108:
            if (r155 == null) goto L110;
            String r156 = r155.f323338b;
        L111:
            r151.append(r156);
            r150.i("GenImagePlannerComponent", r151.toString());
            ky8.f r157 = r147.O30(r148.f506681c);
            if (r157 == null) goto L122;
            com.larus.canvas.feature.component.logic.trace.a r158 = r147.X3();
            if (r158 != null) goto L116;
        L119:
            com.larus.canvas.feature.component.logic.trace.a r159 = r147.X3();
            if (r159 == null) goto L122;
            com.larus.canvas.feature.component.logic.trace.a.C4166a.a(r159, r157, true);
            goto L122
        L116:
            if (r157.a() == null) goto L118;
            r118 = true;
        L118:
            r158.Xv(r157, r118);
        L122:
            String r160 = r148.f506681c;
            if (r152 == false) goto L125;
            com.larus.canvas.feature.component.logic.canvasGenerator.k.a r161 = (com.larus.canvas.feature.component.logic.canvasGenerator.k.a) r310;
        L126:
            if (r161 == null) goto L128;
            String r162 = Boxing.boxInt(r161.f323337a).toString();
        L129:
            r102.L$0 = r149;
            r102.L$1 = null;
            r102.L$2 = null;
            r102.L$3 = null;
            r102.L$4 = null;
            r102.label = 3;
            if (GenImagePlannerComponent.j4(r147, r160, null, r162, r102, 8) != r104) goto L132;
            return r104;
        L132:
            r106 = r149;
            goto L133
        L128:
            r162 = null;
            goto L129
        L125:
            r161 = null;
            goto L126
        L110:
            r156 = null;
            goto L111
        L107:
            r155 = null;
            goto L108
        L103:
            r154 = null;
            goto L104
        L100:
            r153 = null;
            goto L101
        L21:
            r117 = null;
        L7:
            r100 = new GenImagePlannerComponent$startGenerateAndObserve$2$2$emit$1(this, r311);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((com.larus.canvas.feature.component.logic.canvasGenerator.k) r100, r101);
        }
    }

    public GenImagePlannerComponent$startGenerateAndObserve$2(GenImagePlannerComponent r100, ky8.c r101, CompletableDeferred<Unit> r102, Continuation<? super GenImagePlannerComponent$startGenerateAndObserve$2> r103) {
        this.this$0 = r100;
        this.$param = r101;
        this.$releaseSignal = r102;
        super(2, r103);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        GenImagePlannerComponent$startGenerateAndObserve$2 r102 = new GenImagePlannerComponent$startGenerateAndObserve$2(this.this$0, this.$param, this.$releaseSignal, r101);
        r102.L$0 = r100;
        return r102;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((GenImagePlannerComponent$startGenerateAndObserve$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.util.List] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        if (this.$releaseSignal.isCompleted() == true) goto L15;
        this.$releaseSignal.complete(Unit.INSTANCE);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        CoroutineScope r102 = (CoroutineScope) this.L$0;
        Ref.ObjectRef r111 = new Ref.ObjectRef();
        r111.element = CollectionsKt.emptyList();
        GenImagePlannerComponent r103 = this.this$0;
        int r104 = GenImagePlannerComponent.W;
        FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1 r105 = new FlowKt__ErrorsKt$catch$$inlined$unsafeFlow$1(kotlinx.coroutines.flow.e.n(((com.larus.canvas.feature.component.logic.canvasGenerator.j) r103.f323265z.getValue()).a(this.$param, com.larus.canvas.feature.component.logic.canvasGenerator.h.f323333b)), new AnonymousClass1(r111, this.this$0, this.$param, this.$releaseSignal, null));
        AnonymousClass2 r106 = new AnonymousClass2(r102, r111, this.this$0, this.$param, this.$releaseSignal);
        this.label = 1;
        if (r105.collect(r106, this) != r100) goto L12;
        return r100;
    }
}
