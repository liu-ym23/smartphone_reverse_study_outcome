package com.bytedance.ee.bear.document.associateddocs.service;

import android.content.Context;
import com.bytedance.ee.bear.document.associateddocs.bean.DocAssociatedAppUrlInfo;
import com.bytedance.ee.bear.document.associateddocs.bean.DocAssociatedAppUrlInfos;
import com.bytedance.ee.bear.lark.dependency.t;
import com.bytedance.lark.pb.basic.v1.PreviewHangPoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService$requestUrlPreview$1", f = "AssociatedPreviewService.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
final class AssociatedPreviewService$requestUrlPreview$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ArrayList<PreviewHangPoint> $hangPoints;
    final /* synthetic */ DocAssociatedAppUrlInfos $urlsResult;
    int label;
    final /* synthetic */ AssociatedPreviewService this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService$requestUrlPreview$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService$requestUrlPreview$1$1", f = "AssociatedPreviewService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ ArrayList<PreviewHangPoint> $hangPoints;
        final /* synthetic */ DocAssociatedAppUrlInfos $urlsResult;
        int label;
        final /* synthetic */ AssociatedPreviewService this$0;

        public AnonymousClass1(DocAssociatedAppUrlInfos r100, ArrayList<PreviewHangPoint> r101, AssociatedPreviewService r102, Context r103, Continuation<? super AnonymousClass1> r104) {
            this.$urlsResult = r100;
            this.$hangPoints = r101;
            this.this$0 = r102;
            this.$context = r103;
            super(2, r104);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$urlsResult, this.$hangPoints, this.this$0, this.$context, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService$requestUrlPreview$1$1$2] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r100);
            DocAssociatedAppUrlInfos r101 = this.$urlsResult;
            AssociatedPreviewService r102 = this.this$0;
            ArrayList<PreviewHangPoint> r103 = this.$hangPoints;
            r102.f219012b.clear();
            Iterator<DocAssociatedAppUrlInfo> r104 = r101.getData().iterator();
        L6:
            if (r104.hasNext() == false) goto L11;
            DocAssociatedAppUrlInfo r105 = r104.next();
            r103.add(new PreviewHangPoint.Builder().url(r105.getUrl()).preview_id(r105.getPrevieToken()).is_lazy_load(Boxing.boxBoolean(r105.isLazyLoad())).need_local_preview(Boxing.boxBoolean(r105.getNeedLocalPreview())).close_card_preview(Boxing.boxBoolean(r105.getCloseCardPreview())).build());
            HashMap<String, String> r106 = r102.f219012b;
            String r107 = r105.getPrevieToken();
            String r108 = r105.getUrlMetaId();
            if (r108 != null) goto L10;
            r108 = "";
        L10:
            r106.put(r107, r108);
            goto L6
        L11:
            t r109 = (t) org.koin.java.a.c(t.class, null, null, 6);
            ArrayList<PreviewHangPoint> r110 = this.$hangPoints;
            final AssociatedPreviewService r111 = this.this$0;
            final Context r112 = this.$context;
            r109.O(r110, new AnonymousClass2(r111, r112));
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AssociatedPreviewService$requestUrlPreview$1(DocAssociatedAppUrlInfos r100, ArrayList<PreviewHangPoint> r101, AssociatedPreviewService r102, Context r103, Continuation<? super AssociatedPreviewService$requestUrlPreview$1> r104) {
        this.$urlsResult = r100;
        this.$hangPoints = r101;
        this.this$0 = r102;
        this.$context = r103;
        super(2, r104);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AssociatedPreviewService$requestUrlPreview$1(this.$urlsResult, this.$hangPoints, this.this$0, this.$context, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AssociatedPreviewService$requestUrlPreview$1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r101 = this.label;
        if (r101 == 0) goto L8;
        if (r101 != 1) goto L7;
        ResultKt.throwOnFailure(r110);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r110);
        CoroutineDispatcher r111 = Dispatchers.getIO();
        AnonymousClass1 r102 = new AnonymousClass1(this.$urlsResult, this.$hangPoints, this.this$0, this.$context, null);
        this.label = 1;
        if (BuildersKt.withContext(r111, r102, this) != r100) goto L12;
        return r100;
    }
}
