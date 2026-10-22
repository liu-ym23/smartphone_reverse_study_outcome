package com.bytedance.ee.bear.middleground.comment.card.aside;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.p;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import ef5.m;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$show$2", f = "AsideComment.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
public final class AsideComment$show$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AsideComment this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$show$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {
        public final /* synthetic */ AsideComment a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$show$2$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$show$2$1$1", f = "AsideComment.kt", i = {0, 0, 0, 1, 1, 1}, l = {239, 245}, m = "invokeSuspend", n = {"position", "panelHeight", "dataOld", "position", "dataOld", "lastPosition"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "I$0"})
        public static final class C00591 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ List<CommentBean> $data;
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ AsideComment this$0;

            public C00591(AsideComment r1, List<CommentBean> r2, Continuation<? super C00591> r3) {
                this.this$0 = r1;
                this.$data = r2;
                super(1, r3);
            }

            public final Continuation<Unit> create(Continuation<?> r4) {
                return new C00591(this.this$0, this.$data, r4);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object r1) {
                return invoke((Continuation) r1);
            }

            public final Object invoke(Continuation<? super Unit> r2) {
                return create(r2).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object r15) {
                Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r1 = this.label;
                if (r1 == 0) goto L10;
                if (r1 == 1) goto L9;
                if (r1 != 2) goto L8;
                int r2 = this.I$0;
                List<CommentBean> r3 = (List) this.L$1;
                Integer r4 = (Integer) this.L$0;
                ResultKt.throwOnFailure(r15);
            L95:
                this.this$0.e.N.a(new m(this.$data, r4, Boxing.boxInt(r2), r3));
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                r3 = (List) this.L$2;
                Integer r5 = (Integer) this.L$1;
                Integer r6 = (Integer) this.L$0;
                ResultKt.throwOnFailure(r15);
                Integer r16 = r6;
            L83:
                if (this.this$0.e.q.getComment() == true) goto L87;
                AsidePageAdapter r7 = this.this$0.m;
                r7.getClass();
                int r8 = com.bytedance.ee.bear.middleground.comment.card.e.a;
                if (com.bytedance.ee.bear.middleground.comment.card.e.c(r7.c) == false) goto L87;
                this.this$0.m.B2();
            L87:
                this.this$0.m.notifyDataSetChanged();
                Integer r9 = this.this$0.m.o;
                if (r9 == null) goto L90;
                int r10 = r9.intValue();
            L91:
                AsidePageAdapter r11 = this.this$0.m;
                this.L$0 = r16;
                this.L$1 = r3;
                this.L$2 = null;
                this.I$0 = r10;
                this.label = 2;
                if (r11.G2(r16, false, r5, this) != r0) goto L94;
                return r0;
            L94:
                r4 = r16;
                r2 = r10;
                goto L95
            L90:
                r10 = 0;
                goto L91
            L10:
                ResultKt.throwOnFailure(r15);
                this.this$0.f.q1().invoke(Boxing.boxInt(this.$data.size()));
                if (this.$data.isEmpty() == false) goto L13;
                tt5.a.d("Comment#AsideComment", "data is empty");
            L13:
                com.bytedance.ee.bear.middleground.comment.card.d r17 = this.this$0.n;
                MutableLiveData<List<CommentBean>> r12 = r17.f;
                if (r12 == null) goto L53;
                List r13 = (List) r12.getValue();
                if (r13 == null) goto L53;
                String r14 = r17.d;
                r17.d = "";
                Iterator r18 = r13.iterator();
                int r19 = 0;
            L19:
                int r110 = -1;
                if (r18.hasNext() == false) goto L25;
                if (Intrinsics.areEqual(((CommentBean) r18.next()).getComment_id(), r14) == true) goto L26;
                r19 = r19 + 1;
            L26:
                if (r19 < 0) goto L28;
                r16 = Integer.valueOf(r19);
            L54:
                AsideComment r20 = this.this$0;
                Integer r21 = r20.n.g;
                r20.k.setText(this.this$0.e.getActivity().getString(2131887718) + '(' + this.$data.size() + ')');
                SharePermissionViewModel.PreviewPermissionState r22 = this.this$0.h.h();
                if (r22 != null) goto L57;
            L58:
                List<CommentBean> r23 = this.$data;
                AsideComment r24 = this.this$0;
                Iterator<T> r25 = r23.iterator();
            L60:
                if (r25.hasNext() == false) goto L78;
                List<CommentBean.CommentDetail> r26 = ((CommentBean) r25.next()).getComment_list();
                if (r26 == null) goto L60;
                Iterator<T> r27 = r26.iterator();
            L65:
                if (r27.hasNext() == false) goto L60;
                CommentBean.CommentDetail.ExtraEntity r111 = ((CommentBean.CommentDetail) r27.next()).getExtra();
                if (r111 == null) goto L65;
                List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r112 = r111.getImage_list();
                if (r112 == null) goto L65;
                Iterator<T> r113 = r112.iterator();
            L72:
                if (r113.hasNext() == false) goto L65;
                CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r114 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r113.next();
                if (r114 == null) goto L72;
                String r115 = r114.getToken();
                if (r115 == null) goto L72;
                r24.h.m(r24.e, r115);
            L78:
                tt5.a.h("Comment#AsideComment", "data size = " + this.$data.size());
                AsideComment r28 = this.this$0;
                AsidePageAdapter r29 = r28.m;
                List<CommentBean> r30 = r29.c;
                r28.e.h.getClass();
                this.this$0.e.h.getClass();
                List<String> r31 = CollectionsKt.listOf(new String[]{p.a(), null});
                List<CommentBean> r32 = this.$data;
                this.L$0 = r16;
                this.L$1 = r21;
                this.L$2 = r30;
                this.label = 1;
                if (r29.H2(r31, r32, this) != r0) goto L81;
                return r0;
            L81:
                r5 = r21;
                r3 = r30;
                goto L83
            L57:
                if (r22 != SharePermissionViewModel.PreviewPermissionState.STATE_INIT) goto L78;
            L28:
                String r33 = r17.k;
                if (r33 != null) goto L31;
            L34:
                boolean r34 = true;
            L35:
                if (r34 == false) goto L37;
                int r116 = AsidePageAdapter.u;
                goto L53
            L37:
                Iterator r35 = r13.iterator();
                int r36 = 0;
            L39:
                if (r35.hasNext() == false) goto L50;
                CommentBean r37 = (CommentBean) r35.next();
                if (Intrinsics.areEqual(r37.getComment_id(), r17.k) == false) goto L43;
            L46:
                boolean r38 = true;
            L47:
                if (r38 == true) goto L48;
                r36 = r36 + 1;
                goto L39
            L48:
                r110 = r36;
                goto L50
            L43:
                if (Intrinsics.areEqual(r37.getCommentUUID(), r17.k) == true) goto L46;
                r38 = false;
            L50:
                if (r110 < 0) goto L52;
                r16 = Integer.valueOf(r110);
                goto L54
            L52:
                int r117 = AsidePageAdapter.u;
                goto L53
            L31:
                if (r33.length() == 0) goto L34;
                r34 = false;
                goto L35
            L25:
                r19 = -1;
            L53:
                r16 = null;
                goto L54
            }
        }

        public AnonymousClass1(AsideComment r1) {
            this.a = r1;
        }

        public final Object a(List<CommentBean> r8, Continuation<? super Unit> r9) {
            if ((r9 instanceof AsideComment$show$2$1$emit$1) == false) goto L7;
            AsideComment$show$2$1$emit$1 r0 = (AsideComment$show$2$1$emit$1) r9;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r10 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L16;
            if (r3 == 1) goto L15;
            if (r3 != 2) goto L14;
            ResultKt.throwOnFailure(r10);
        L33:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r10);
        L23:
            AsideComment.a r11 = this.a.p;
            r0.label = 2;
            r11.getClass();
            kotlinx.coroutines.j r12 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r0), 1);
            r12.C();
            r11.b("await", new AsideComment$CommentHandler$await$2$1(r12, null));
            Object r13 = r12.B();
            if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
            DebugProbesKt.probeCoroutineSuspended(r0);
        L27:
            if (r13 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
            r13 = Unit.INSTANCE;
        L30:
            if (r13 != r2) goto L33;
            return r2;
        L16:
            ResultKt.throwOnFailure(r10);
            if (r8 != null) goto L20;
            tt5.a.k("Comment#AsideComment", "data is null");
            return Unit.INSTANCE;
        L20:
            AsideComment r14 = this.a;
            r14.p.b("dataChange", new C00591(r14, r8, null));
            r0.label = 1;
            if (DelayKt.delay(100, r0) != r2) goto L23;
            return r2;
        L7:
            r0 = new AsideComment$show$2$1$emit$1(this, r9);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            return a((List) r1, r2);
        }
    }

    public AsideComment$show$2(AsideComment r1, Continuation<? super AsideComment$show$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AsideComment$show$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        MutableLiveData<List<CommentBean>> r6 = this.this$0.n.f;
        if (r6 == null) goto L16;
        Flow r7 = FlowLiveDataConversions.asFlow(r6);
        if (r7 == null) goto L16;
        AnonymousClass1 r2 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r7.collect(r2, this) != r0) goto L16;
        return r0;
    }
}
