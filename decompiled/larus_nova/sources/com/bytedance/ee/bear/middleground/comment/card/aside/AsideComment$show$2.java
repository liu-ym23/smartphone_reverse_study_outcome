package com.bytedance.ee.bear.middleground.comment.card.aside;

import androidx.lifecycle.FlowLiveDataConversions;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.p;
import com.bytedance.ee.bear.middleground.comment.share.SharePermissionViewModel;
import com.larus.nova.R;
import com.ss.ttvideoengine.model.VideoRef;
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

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$show$2", f = "AsideComment.kt", i = {}, l = {208}, m = "invokeSuspend", n = {}, s = {})
public final class AsideComment$show$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ AsideComment this$0;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$show$2$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements FlowCollector {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AsideComment f230911a;

        /* JADX INFO: renamed from: com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$show$2$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.bytedance.ee.bear.middleground.comment.card.aside.AsideComment$show$2$1$1", f = "AsideComment.kt", i = {0, 0, 0, 1, 1, 1}, l = {VideoRef.VALUE_VIDEO_REF_SUBTITLE_POSITION_X, 245}, m = "invokeSuspend", n = {"position", "panelHeight", "dataOld", "position", "dataOld", "lastPosition"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "I$0"})
        public static final class C33061 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
            final /* synthetic */ List<CommentBean> $data;
            int I$0;
            Object L$0;
            Object L$1;
            Object L$2;
            int label;
            final /* synthetic */ AsideComment this$0;

            public C33061(AsideComment r100, List<CommentBean> r101, Continuation<? super C33061> r102) {
                this.this$0 = r100;
                this.$data = r101;
                super(1, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Continuation<?> r100) {
                return new C33061(this.this$0, this.$data, r100);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Unit> r100) {
                return invoke2(r100);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(Continuation<? super Unit> r100) {
                return ((C33061) create(r100)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r110) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                if (r101 == 0) goto L10;
                if (r101 == 1) goto L9;
                if (r101 != 2) goto L8;
                int r102 = this.I$0;
                List<CommentBean> r103 = (List) this.L$1;
                Integer r104 = (Integer) this.L$0;
                ResultKt.throwOnFailure(r110);
            L95:
                this.this$0.f230881e.N.a(new m(this.$data, r104, Boxing.boxInt(r102), r103));
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                r103 = (List) this.L$2;
                Integer r105 = (Integer) this.L$1;
                Integer r106 = (Integer) this.L$0;
                ResultKt.throwOnFailure(r110);
                Integer r111 = r106;
            L83:
                if (this.this$0.f230881e.f232241q.getComment() == true) goto L87;
                AsidePageAdapter r107 = this.this$0.f230889m;
                r107.getClass();
                int r108 = com.bytedance.ee.bear.middleground.comment.card.e.f230973a;
                if (com.bytedance.ee.bear.middleground.comment.card.e.c(r107.f230915c) == false) goto L87;
                this.this$0.f230889m.B2();
            L87:
                this.this$0.f230889m.notifyDataSetChanged();
                Integer r109 = this.this$0.f230889m.f230927o;
                if (r109 == null) goto L90;
                int r112 = r109.intValue();
            L91:
                AsidePageAdapter r113 = this.this$0.f230889m;
                this.L$0 = r111;
                this.L$1 = r103;
                this.L$2 = null;
                this.I$0 = r112;
                this.label = 2;
                if (r113.G2(r111, false, r105, this) != r100) goto L94;
                return r100;
            L94:
                r104 = r111;
                r102 = r112;
                goto L95
            L90:
                r112 = 0;
                goto L91
            L10:
                ResultKt.throwOnFailure(r110);
                this.this$0.f230882f.q1().invoke(Boxing.boxInt(this.$data.size()));
                if (this.$data.isEmpty() == false) goto L13;
                tt5.a.d("Comment#AsideComment", "data is empty");
            L13:
                com.bytedance.ee.bear.middleground.comment.card.d r114 = this.this$0.f230890n;
                MutableLiveData<List<CommentBean>> r115 = r114.f230964f;
                if (r115 == null) goto L53;
                List<CommentBean> r116 = r115.getValue();
                if (r116 == null) goto L53;
                String r117 = r114.f230962d;
                r114.f230962d = "";
                Iterator<CommentBean> r118 = r116.iterator();
                int r119 = 0;
            L19:
                int r120 = -1;
                if (r118.hasNext() == false) goto L25;
                if (Intrinsics.areEqual(r118.next().getComment_id(), r117) == true) goto L26;
                r119 = r119 + 1;
            L26:
                if (r119 < 0) goto L28;
                r111 = Integer.valueOf(r119);
            L54:
                AsideComment r121 = this.this$0;
                Integer r122 = r121.f230890n.f230965g;
                r121.f230887k.setText(this.this$0.f230881e.getActivity().getString(R.string.Doc_Facade_Comment) + '(' + this.$data.size() + ')');
                SharePermissionViewModel.PreviewPermissionState r123 = this.this$0.f230884h.h();
                if (r123 != null) goto L57;
            L58:
                List<CommentBean> r124 = this.$data;
                AsideComment r125 = this.this$0;
                Iterator<T> r126 = r124.iterator();
            L60:
                if (r126.hasNext() == false) goto L78;
                List<CommentBean.CommentDetail> r127 = ((CommentBean) r126.next()).getComment_list();
                if (r127 == null) goto L60;
                Iterator<T> r128 = r127.iterator();
            L65:
                if (r128.hasNext() == false) goto L60;
                CommentBean.CommentDetail.ExtraEntity r129 = ((CommentBean.CommentDetail) r128.next()).getExtra();
                if (r129 == null) goto L65;
                List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r130 = r129.getImage_list();
                if (r130 == null) goto L65;
                Iterator<T> r131 = r130.iterator();
            L72:
                if (r131.hasNext() == false) goto L65;
                CommentBean.CommentDetail.ExtraEntity.CommentImageEntity r132 = (CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r131.next();
                if (r132 == null) goto L72;
                String r133 = r132.getToken();
                if (r133 == null) goto L72;
                r125.f230884h.m(r125.f230881e, r133);
            L78:
                tt5.a.h("Comment#AsideComment", "data size = " + this.$data.size());
                AsideComment r134 = this.this$0;
                AsidePageAdapter r135 = r134.f230889m;
                List<CommentBean> r136 = r135.f230915c;
                r134.f230881e.f232232h.getClass();
                this.this$0.f230881e.f232232h.getClass();
                List<String> r137 = CollectionsKt.listOf(new String[]{p.a(), null});
                List<CommentBean> r138 = this.$data;
                this.L$0 = r111;
                this.L$1 = r122;
                this.L$2 = r136;
                this.label = 1;
                if (r135.H2(r137, r138, this) != r100) goto L81;
                return r100;
            L81:
                r105 = r122;
                r103 = r136;
                goto L83
            L57:
                if (r123 != SharePermissionViewModel.PreviewPermissionState.STATE_INIT) goto L78;
            L28:
                String r139 = r114.f230969k;
                if (r139 != null) goto L31;
            L34:
                boolean r140 = true;
            L35:
                if (r140 == false) goto L37;
                int r141 = AsidePageAdapter.f230912u;
                goto L53
            L37:
                Iterator<CommentBean> r142 = r116.iterator();
                int r143 = 0;
            L39:
                if (r142.hasNext() == false) goto L50;
                CommentBean r144 = r142.next();
                if (Intrinsics.areEqual(r144.getComment_id(), r114.f230969k) == false) goto L43;
            L46:
                boolean r145 = true;
            L47:
                if (r145 == true) goto L48;
                r143 = r143 + 1;
                goto L39
            L48:
                r120 = r143;
                goto L50
            L43:
                if (Intrinsics.areEqual(r144.getCommentUUID(), r114.f230969k) == true) goto L46;
                r145 = false;
            L50:
                if (r120 < 0) goto L52;
                r111 = Integer.valueOf(r120);
                goto L54
            L52:
                int r146 = AsidePageAdapter.f230912u;
                goto L53
            L31:
                if (r139.length() == 0) goto L34;
                r140 = false;
                goto L35
            L25:
                r119 = -1;
            L53:
                r111 = null;
                goto L54
            }
        }

        public AnonymousClass1(AsideComment r100) {
            this.f230911a = r100;
        }

        public final Object a(List<CommentBean> r100, Continuation<? super Unit> r101) {
            if ((r101 instanceof AsideComment$show$2$1$emit$1) == false) goto L7;
            AsideComment$show$2$1$emit$1 r102 = (AsideComment$show$2$1$emit$1) r101;
            int r103 = r102.label;
            if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
            r102.label = r103 - Integer.MIN_VALUE;
        L8:
            Object r104 = r102.result;
            Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r106 = r102.label;
            if (r106 == 0) goto L16;
            if (r106 == 1) goto L15;
            if (r106 != 2) goto L14;
            ResultKt.throwOnFailure(r104);
        L33:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r104);
        L23:
            AsideComment.a r107 = this.f230911a.f230892p;
            r102.label = 2;
            r107.getClass();
            kotlinx.coroutines.j r108 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r102), 1);
            r108.C();
            r107.b("await", new AsideComment$CommentHandler$await$2$1(r108, null));
            Object r109 = r108.B();
            if (r109 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
            DebugProbesKt.probeCoroutineSuspended(r102);
        L27:
            if (r109 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L30;
            r109 = Unit.INSTANCE;
        L30:
            if (r109 != r105) goto L33;
            return r105;
        L16:
            ResultKt.throwOnFailure(r104);
            if (r100 != null) goto L20;
            tt5.a.k("Comment#AsideComment", "data is null");
            return Unit.INSTANCE;
        L20:
            AsideComment r110 = this.f230911a;
            r110.f230892p.b("dataChange", new C33061(r110, r100, null));
            r102.label = 1;
            if (DelayKt.delay(100, r102) != r105) goto L23;
            return r105;
        L7:
            r102 = new AsideComment$show$2$1$emit$1(this, r101);
            goto L8
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        public final /* bridge */ /* synthetic */ Object emit(Object r100, Continuation r101) {
            return a((List) r100, r101);
        }
    }

    public AsideComment$show$2(AsideComment r100, Continuation<? super AsideComment$show$2> r101) {
        this.this$0 = r100;
        super(2, r101);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
        return new AsideComment$show$2(this.this$0, r101);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((AsideComment$show$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r100) {
        Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = this.label;
        if (r102 == 0) goto L8;
        if (r102 != 1) goto L7;
        ResultKt.throwOnFailure(r100);
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r100);
        MutableLiveData<List<CommentBean>> r103 = this.this$0.f230890n.f230964f;
        if (r103 == null) goto L16;
        Flow r104 = FlowLiveDataConversions.asFlow(r103);
        if (r104 == null) goto L16;
        AnonymousClass1 r105 = new AnonymousClass1(this.this$0);
        this.label = 1;
        if (r104.collect(r105, this) != r101) goto L16;
        return r101;
    }
}
