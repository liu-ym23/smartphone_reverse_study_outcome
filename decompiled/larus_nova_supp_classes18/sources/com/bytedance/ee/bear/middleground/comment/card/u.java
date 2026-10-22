package com.bytedance.ee.bear.middleground.comment.card;

import android.view.View;
import com.bytedance.ee.bear.middleground.comment.export.Action;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.SmartReplyDataForInsert;
import com.bytedance.ee.bear.middleground.comment.input.b2;
import com.bytedance.ee.bear.middleground.comment.widget.CommentTextView;
import com.bytedance.ee.bear.widgets.viewpager.VerticalViewPager;
import io.reactivex.Flowable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class u implements View.OnClickListener {
    public final /* synthetic */ FloatCardComment a;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ FloatCardComment a;

        public a(FloatCardComment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            String r4 = (String) r3;
            com.bytedance.ee.bear.middleground.comment.control.t r0 = this.a.g;
            Intrinsics.checkNotNull(r4);
            r0.w(r4, Action.PUBLISH);
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ FloatCardComment a;

        public b(FloatCardComment r1) {
            this.a = r1;
        }

        public final void accept(Object r3) {
            FloatCardComment r0 = this.a;
            b2 r1 = r0.D;
            com.bytedance.ee.bear.middleground.comment.control.z r2 = r0.f;
            r1.g(r2, (Throwable) r3);
        }
    }

    public u(FloatCardComment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r28) {
        com.bytedance.ee.bear.middleground.comment.export.m r1 = this.a.e.M;
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L10;
        return;
    L10:
        d r3 = this.a.p;
        d r4 = null;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r3 = null;
    L13:
        VerticalViewPager r5 = this.a.m;
        if (r5 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r5 = null;
    L16:
        String r10 = r3.f(Integer.valueOf(r5.getCurrentItem()));
        d r6 = this.a.p;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r6 = null;
    L19:
        VerticalViewPager r7 = this.a.m;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r7 = null;
    L22:
        CommentBean r8 = r6.e(Integer.valueOf(r7.getCurrentItem()));
        CommentTextView r9 = this.a.s;
        if (r9 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("commentTv");
        r9 = null;
    L26:
        if (r9.getRawString() != null) goto L28;
        return;
    L28:
        FloatCardComment r11 = this.a;
        String r12 = r11.F;
        List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r13 = r11.G;
        SmartReplyDataForInsert r15 = r11.H;
        gf5.d r14 = r11.e.N;
        d r16 = r11.p;
        if (r16 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
        r16 = null;
    L31:
        VerticalViewPager r17 = this.a.m;
        if (r17 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("viewPager");
        r17 = null;
    L34:
        r14.a(new ef5.h(r16.f(Integer.valueOf(r17.getCurrentItem()))));
        String r18 = com.larksuite.framework.utils.l0.a().toString();
        af5.b r19 = this.a.e.Q;
        if (r19 == null) goto L39;
        com.bytedance.ee.bear.middleground.comment.performance.d r20 = r19.b();
        if (r20 == null) goto L39;
        r20.e(r18, "reply");
    L39:
        if (r8 == null) goto L41;
        String r21 = r8.getPosition();
    L42:
        if (r8 == null) goto L44;
        Map<Object, Object> r22 = r8.getBizParams();
    L45:
        if (r8 == null) goto L47;
        int r24 = r8.getCommentType();
    L48:
        Flowable<String> r23 = com.bytedance.ee.bear.middleground.comment.uitls.o.a(this.a.g.B(new com.bytedance.ee.bear.rn.e(null, r12, r10, false, false, r13, null, null, null, null, false, null, r21, r22, r18, null, r24, r15, 36809)), null);
        if (r23 == null) goto L51;
        FloatCardComment r25 = this.a;
        Disposable r26 = r23.subscribe(new a(r25), new b(r25));
    L52:
        d r27 = this.a.p;
        if (r27 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("dataViewModel");
    L56:
        r4.a(r26);
        return;
    L55:
        r4 = r27;
        goto L56
    L51:
        r26 = null;
        goto L52
    L47:
        r24 = 0;
        goto L48
    L44:
        r22 = null;
        goto L45
    L41:
        r21 = null;
        goto L42
    L5:
        if (r1.b() == true) goto L7;
        r2 = true;
        goto L8
    }
}
