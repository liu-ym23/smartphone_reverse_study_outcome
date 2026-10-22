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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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

        public AnonymousClass1(DocAssociatedAppUrlInfos r1, ArrayList<PreviewHangPoint> r2, AssociatedPreviewService r3, Context r4, Continuation<? super AnonymousClass1> r5) {
            this.$urlsResult = r1;
            this.$hangPoints = r2;
            this.this$0 = r3;
            this.$context = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
            return new AnonymousClass1(this.$urlsResult, this.$hangPoints, this.this$0, this.$context, r8);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v2, types: [com.bytedance.ee.bear.document.associateddocs.service.AssociatedPreviewService$requestUrlPreview$1$1$2] */
        public final Object invokeSuspend(Object r6) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r6);
            DocAssociatedAppUrlInfos r7 = this.$urlsResult;
            AssociatedPreviewService r0 = this.this$0;
            ArrayList<PreviewHangPoint> r1 = this.$hangPoints;
            r0.b.clear();
            Iterator<DocAssociatedAppUrlInfo> r8 = r7.getData().iterator();
        L6:
            if (r8.hasNext() == false) goto L11;
            DocAssociatedAppUrlInfo r2 = r8.next();
            r1.add(new PreviewHangPoint.Builder().url(r2.getUrl()).preview_id(r2.getPrevieToken()).is_lazy_load(Boxing.boxBoolean(r2.isLazyLoad())).need_local_preview(Boxing.boxBoolean(r2.getNeedLocalPreview())).close_card_preview(Boxing.boxBoolean(r2.getCloseCardPreview())).build());
            HashMap<String, String> r3 = r0.b;
            String r4 = r2.getPrevieToken();
            String r5 = r2.getUrlMetaId();
            if (r5 != null) goto L10;
            r5 = "";
        L10:
            r3.put(r4, r5);
            goto L6
        L11:
            t r9 = (t) org.koin.java.a.c(t.class, null, null, 6);
            ArrayList<PreviewHangPoint> r10 = this.$hangPoints;
            final AssociatedPreviewService r11 = this.this$0;
            final Context r12 = this.$context;
            r9.O(r10, new AnonymousClass2(r11, r12));
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public AssociatedPreviewService$requestUrlPreview$1(DocAssociatedAppUrlInfos r1, ArrayList<PreviewHangPoint> r2, AssociatedPreviewService r3, Context r4, Continuation<? super AssociatedPreviewService$requestUrlPreview$1> r5) {
        this.$urlsResult = r1;
        this.$hangPoints = r2;
        this.this$0 = r3;
        this.$context = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AssociatedPreviewService$requestUrlPreview$1(this.$urlsResult, this.$hangPoints, this.this$0, this.$context, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        CoroutineDispatcher r11 = Dispatchers.getIO();
        AnonymousClass1 r2 = new AnonymousClass1(this.$urlsResult, this.$hangPoints, this.this$0, this.$context, null);
        this.label = 1;
        if (BuildersKt.withContext(r11, r2, this) != r0) goto L12;
        return r0;
    }
}
