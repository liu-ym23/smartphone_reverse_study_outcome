package com.bytedance.ee.bear.middleground.comment.card;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.middleground.comment.widget.NoTopFadingEdgeRecyclerView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements View.OnTouchListener {
    public final /* synthetic */ Ref.LongRef a;
    public final /* synthetic */ Ref.FloatRef b;
    public final /* synthetic */ Ref.FloatRef c;
    public final /* synthetic */ NoTopFadingEdgeRecyclerView d;
    public final /* synthetic */ CommentPagerAdapter2 e;

    public h(Ref.LongRef r1, Ref.FloatRef r2, Ref.FloatRef r3, NoTopFadingEdgeRecyclerView r4, CommentPagerAdapter2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r4, MotionEvent r5) {
        if (r5.getAction() != 0) goto L6;
        Ref.LongRef r0 = this.a;
        r0.element = System.currentTimeMillis();
        Ref.FloatRef r1 = this.b;
        r1.element = r5.getX();
        Ref.FloatRef r2 = this.c;
        r2.element = r5.getY();
    L6:
        if (r5.getAction() == 1) goto L8;
        return false;
    L8:
        if (r4.getId() != 0) goto L10;
        return false;
    L10:
        if (Math.abs(this.b.element - r5.getX()) <= 5.0f) goto L12;
        return false;
    L12:
        if (Math.abs(this.c.element - r5.getY()) <= 5.0f) goto L14;
        return false;
    L14:
        if (this.d.getScrollState() != 1) goto L16;
        return false;
    L16:
        if ((System.currentTimeMillis() - this.a.element) >= 300) goto L27;
        Function0<Unit> r6 = this.e.o;
        if (r6 == null) goto L28;
        r6.invoke();
        return false;
    L28:
        return false;
    L27:
        return false;
    }
}
