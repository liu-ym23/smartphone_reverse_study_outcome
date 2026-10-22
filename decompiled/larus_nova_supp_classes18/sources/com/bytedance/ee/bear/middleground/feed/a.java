package com.bytedance.ee.bear.middleground.feed;

import android.R;
import android.animation.ValueAnimator;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.facade.common.widget.d;
import com.bytedance.ee.bear.middleground.comment.export.bean.TranslateConfig;
import com.bytedance.ee.bear.middleground.comment.h;
import com.bytedance.ee.bear.middleground.feed.export.bean.FeedCommentDetailBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageConfig;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MultiBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.f;
import com.bytedance.ee.bear.middleground.feed.export.bean.g;
import com.bytedance.ee.bear.middleground.feed.export.bean.i;
import com.bytedance.ee.bear.middleground.feed.view.adapter.FeedItemComment;
import com.bytedance.ee.util.ui.n;
import dg5.a0;
import dg5.d1;
import dg5.r;
import dg5.s;
import dg5.t;
import dg5.v;
import dg5.w;
import dg5.x;
import io.reactivex.Flowable;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import uf5.l0;
import uf5.q0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements f {
    public final a0 a;
    public MessageConfig b;

    public final void a() {
        if (this.a.f() == false) goto L5;
        this.a.e(false);
    L5:
        a0 r0 = this.a;
        r0.getClass();
        tt5.a.h("PanelView", "destroy message");
        d1 r1 = r0.l;
        FragmentActivity r2 = r0.a;
        r1.l = null;
        r1.f.setValue(null);
        r1.g.setValue(null);
        MutableLiveData<Triple<String, List<MultiBean>, MessageResultBean>> r4 = r1.k;
        if (r4 == null) goto L8;
        r4.removeObservers(r2);
        r1.k.postValue(null);
    L8:
        l0 r3 = l0.b();
        String r5 = r1.e.getToken();
        r3.getClass();
        if (TextUtils.isEmpty(r5) == false) goto L11;
    L13:
        q0 r6 = (q0) r1.c;
        r6.getClass();
        r6.a.p();
        r1.b();
        r0.n.a();
        return;
    L11:
        if (r5.equals(r3.a) == false) goto L13;
        r3.a = "";
        goto L13
    }

    public final void b() {
        this.a.e(false);
    }

    public final boolean c() {
        return this.a.f();
    }

    public final void e(List<String> r2) {
        this.a.l.i(r2);
    }

    public final void f(MessageConfig r4) {
        this.b = r4;
        a0 r0 = this.a;
        r0.getClass();
        tt5.a.h("PanelView", "setMessageConfig message");
        r0.l.e = r4;
        tt5.a.h("PanelView", "updateConfig: " + r0.l.e.isLoadingSuccess());
        if (r0.w == false) goto L5;
    L8:
        ag5.a r5 = (ag5.a) ((HashMap) r0.k.a).get(FeedCommentDetailBean.class);
        if ((r5 instanceof FeedItemComment) == false) goto L11;
        FeedItemComment r6 = (FeedItemComment) r5;
        TranslateConfig r1 = r0.l.e.getTranslateConfig();
        r6.getClass();
        Intrinsics.checkNotNullParameter(r1, "<set-?>");
        r6.b = r1;
    L11:
        d1 r7 = r0.l;
        MessageResultBean r2 = r7.l;
        if (r2 == null) goto L15;
        r7.l(r2);
        return;
    L15:
        return;
    L5:
        if (r0.l.e.isLoadingSuccess() == false) goto L7;
        r0.h.setVisibility(8);
        goto L8
    L7:
        r0.h.setVisibility(0);
        goto L8
    }

    public final void g(boolean r7) {
        final a0 r0 = this.a;
        r0.getClass();
        bg5.a.b();
        bg5.a.j.set(r7);
        r0.g();
        r0.j.e();
        r0.j.f();
        tt5.a.h("PanelView", "showPanel, auto: " + r0.l.e.isAuto());
        sa5.b r8 = r0.c();
        if (r8 == null) goto L5;
        r8.e(r0.r);
    L5:
        r0.l.d.b(true, false);
        r0.c.setTranslationX(0.0f);
        r0.c.setTranslationY(0.0f);
        if (r0.c.getParent() != null) goto L12;
        ViewGroup r9 = r0.b;
        if (r9 == null) goto L10;
        r9.addView(r0.c);
    L11:
        r0.b(r0.a.getResources().getConfiguration());
        r0.l.g.observe(r0.a, new v(r0));
        d1 r10 = r0.l;
        r10.d(r0.a);
        r10.f.observe(r0.a, new w(r0));
        r0.l.h.observe(r0.a, new x(r0));
        goto L12
    L10:
        ((ViewGroup) r0.a.findViewById(R.id.content)).addView(r0.c);
    L12:
        ValueAnimator r11 = ValueAnimator.ofFloat(new float[]{n.t() * d.q, 0.0f});
        r11.addUpdateListener(new s(r0));
        r11.setDuration(200);
        r11.start();
        View r12 = r0.c;
        d r3 = r0.j;
        Objects.requireNonNull(r3);
        r12.post(new t(r3));
        r0.u = true;
        r0.g.getLayoutManager().scrollToPositionWithOffset(0, 0);
        r0.l.j(true);
    }

    public final void h(boolean r8) {
        final a0 r0 = this.a;
        r0.getClass();
        tt5.a.h("PanelView", "toComment:" + r8);
        if (r8 == false) goto L5;
        h r9 = ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).f();
        int r6 = r0.j.c();
        r9.getClass();
        com.bytedance.ee.bear.middleground.comment.card.a.a = r6;
        ValueAnimator r10 = ValueAnimator.ofInt(new int[]{0, r0.c.getWidth()});
        r10.setDuration(300);
        r10.addUpdateListener(new dg5.a(r0));
        r10.start();
        return;
    L5:
        ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).f().getClass();
        if (com.bytedance.ee.bear.middleground.comment.card.a.b != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == true) goto L11;
        d r12 = r0.j;
        ((com.bytedance.ee.bear.middleground.comment.export.n) org.koin.java.a.a(com.bytedance.ee.bear.middleground.comment.export.n.class)).f().getClass();
        int r7 = com.bytedance.ee.bear.middleground.comment.card.a.b;
        com.bytedance.ee.bear.middleground.comment.card.a.b = 0;
        r12.l(r7);
    L11:
        ValueAnimator r13 = ValueAnimator.ofInt(new int[]{r0.c.getWidth(), 0});
        r13.setDuration(300);
        r13.addUpdateListener(new r(r0));
        r13.start();
        return;
    L8:
        r11 = false;
        goto L9
    }

    public final Flowable<String> d(boolean r3, String r4) {
        tt5.a.h("Feed", "pulldata");
        return this.a.l.g(r3, r4);
    }

    public a(FragmentActivity r8, ViewGroup r9, g r10, i r11, MessageConfig r12) {
        this.b = r12;
        this.a = new a0(r8, r9, r10, r11, r12);
    }
}
