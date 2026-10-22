package com.bytedance.ee.bear.middleground.comment.card;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.middleground.comment.widget.NoTopFadingEdgeRecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes18.dex */
public final class h implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f230982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f230983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f230984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ NoTopFadingEdgeRecyclerView f230985d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ CommentPagerAdapter2 f230986e;

    public h(Ref.LongRef r100, Ref.FloatRef r101, Ref.FloatRef r102, NoTopFadingEdgeRecyclerView r103, CommentPagerAdapter2 r104) {
        this.f230982a = r100;
        this.f230983b = r101;
        this.f230984c = r102;
        this.f230985d = r103;
        this.f230986e = r104;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        if (r101.getAction() != 0) goto L6;
        Ref.LongRef r102 = this.f230982a;
        r102.element = System.currentTimeMillis();
        Ref.FloatRef r103 = this.f230983b;
        r103.element = r101.getX();
        Ref.FloatRef r104 = this.f230984c;
        r104.element = r101.getY();
    L6:
        if (r101.getAction() == 1) goto L8;
        return false;
    L8:
        if (r100.getId() != 0) goto L10;
        return false;
    L10:
        if (Math.abs(this.f230983b.element - r101.getX()) <= 5.0f) goto L12;
        return false;
    L12:
        if (Math.abs(this.f230984c.element - r101.getY()) <= 5.0f) goto L14;
        return false;
    L14:
        if (this.f230985d.getScrollState() != 1) goto L16;
        return false;
    L16:
        if ((System.currentTimeMillis() - this.f230982a.element) >= 300) goto L27;
        Function0<Unit> r105 = this.f230986e.f230767o;
        if (r105 == null) goto L28;
        r105.invoke();
        return false;
    L28:
        return false;
    L27:
        return false;
    }
}
