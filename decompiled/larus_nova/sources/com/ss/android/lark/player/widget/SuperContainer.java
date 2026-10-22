package com.ss.android.lark.player.widget;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import v0c.f;
import v0c.g;
import v0c.h;
import v0c.i;
import v0c.k;
import v0c.l;
import v0c.m;
import v0c.n;
import v0c.o;
import v0c.p;
import v0c.q;
import v0c.t;

/* JADX INFO: loaded from: classes37.dex */
public class SuperContainer extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FrameLayout f438733a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v0c.c f438734b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public x0c.c f438735c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public q f438736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t f438737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public g f438738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p f438739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public y0c.a f438740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GestureDetector f438741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final a f438742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final b f438743k;

    public class a implements q {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperContainer f438744a;

        public a(SuperContainer r100) {
            this.f438744a = r100;
        }

        @Override // v0c.q
        public final void a(int r100, Bundle r101) {
            q r102 = this.f438744a.f438736d;
            if (r102 == null) goto L5;
            r102.a(r100, r101);
        L5:
            g r103 = this.f438744a.f438738f;
            if (r103 == null) goto L11;
            r103.f552359a.b(null, new k(r100, r101));
            if (r101 == null) goto L12;
            r101.clear();
            return;
        L12:
            return;
        }
    }

    public class b implements p.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperContainer f438745a;

        public b(SuperContainer r100) {
            this.f438745a = r100;
        }

        @Override // v0c.p.b
        public final void a(v0c.a r100) {
            SuperContainer.a(this.f438745a, r100);
        }
    }

    public class c implements y0c.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperContainer f438746a;

        @Override // y0c.b
        public final void f() {
            g r100 = this.f438746a.f438738f;
            if (r100 == null) goto L6;
            r100.a(new v0c.e());
            return;
        }

        public c(SuperContainer r100) {
            this.f438746a = r100;
        }

        @Override // y0c.b
        public final void onDoubleTap(MotionEvent r100) {
            g r101 = this.f438746a.f438738f;
            if (r101 == null) goto L6;
            r101.a(new m(r100));
            return;
        }

        @Override // y0c.b
        public final void onDown(MotionEvent r100) {
            g r101 = this.f438746a.f438738f;
            if (r101 == null) goto L6;
            r101.a(new n(r100));
            return;
        }

        @Override // y0c.b
        public final void onLongPress(MotionEvent r100) {
            g r101 = this.f438746a.f438738f;
            if (r101 == null) goto L6;
            r101.a(new f(r100));
            return;
        }

        @Override // y0c.b
        public final void onSingleTapUp(MotionEvent r100) {
            g r101 = this.f438746a.f438738f;
            if (r101 == null) goto L6;
            r101.a(new l(r100));
            return;
        }

        @Override // y0c.b
        public final void onScroll(MotionEvent r100, MotionEvent r101, float r102, float r103) {
            g r104 = this.f438746a.f438738f;
            if (r104 == null) goto L6;
            r104.a(new v0c.d(r100, r101, r102, r103));
            return;
        }
    }

    public class d {
        public d() {
        }
    }

    public class e implements p.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SuperContainer f438747a;

        public e(SuperContainer r100) {
            this.f438747a = r100;
        }

        @Override // v0c.p.a
        public final void a(o r100) {
            SuperContainer.a(this.f438747a, r100);
        }
    }

    public final void c() {
        measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
        layout(getLeft(), getTop(), getRight(), getBottom());
    }

    public q getOnReceiverEventListener() {
        return this.f438736d;
    }

    public t getStateGetter() {
        return this.f438737e;
    }

    public SuperContainer(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (r100.getAction() != 1) goto L8;
        y0c.b r101 = this.f438740h.f565606a;
        if (r101 == null) goto L8;
        r101.f();
    L8:
        return this.f438741i.onTouchEvent(r100);
    }

    public void setOnReceiverEventListener(q r100) {
        this.f438736d = r100;
    }

    public final void setReceiverGroup(p r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.equals(this.f438739g) == true) goto L12;
        v0c.c r101 = this.f438734b;
        ((ArrayList) r101.f552353b).clear();
        r101.f552352a.removeAllViews();
        p r102 = this.f438739g;
        if (r102 == null) goto L9;
        r102.c(this.f438743k);
    L9:
        this.f438739g = r100;
        this.f438738f = new g(r100);
        r100.d(new e(this));
        this.f438739g.a(this.f438743k);
        return;
    }

    public final void setRenderView(View r100) {
        FrameLayout r101 = this.f438733a;
        if (r101 == null) goto L5;
        r101.removeAllViews();
    L5:
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(-2, -2, 17);
        this.f438733a.addView(r100, r102);
    }

    public void setStateGetter(t r100) {
        this.f438737e = r100;
    }

    public SuperContainer(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public static void a(SuperContainer r100, o r101) {
        r101.b(r100.f438742j);
        r101.c(r100.f438737e);
        if ((r101 instanceof v0c.a) == false) goto L12;
        v0c.a r102 = (v0c.a) r101;
        v0c.c r103 = r100.f438734b;
        r103.getClass();
        if (r102.f552348d == null) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == false) goto L10;
        ((ArrayList) r103.f552353b).add(r102);
        r103.f552352a.addView(r102.f552348d, new ViewGroup.LayoutParams(-1, -1));
    L10:
        Log.d("SuperContainer", "on cover attach : " + r102.getClass().getSimpleName() + " ,0");
        return;
    L7:
        r104 = false;
        goto L8
    }

    public final void b(int r100, Bundle r101) {
        g r102 = this.f438738f;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r100 == (-99019)) goto L7;
        r102.f552359a.d(new i(r100, r101));
    L8:
        if (r101 == null) goto L12;
        r101.clear();
        return;
    L12:
        return;
    L7:
        r102.f552359a.d(new h(r101, r100));
        goto L8
    }

    public SuperContainer(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f438742j = new a(this);
        this.f438743k = new b(this);
        c r103 = new c(this);
        new d();
        this.f438735c = new x0c.c();
        this.f438740h = new y0c.a(r103);
        this.f438741i = new GestureDetector(r100, this.f438740h);
        FrameLayout r104 = new FrameLayout(r100);
        this.f438733a = r104;
        addView(r104, new ViewGroup.LayoutParams(-1, -1));
        v0c.c r105 = new v0c.c();
        this.f438734b = r105;
        FrameLayout r106 = new FrameLayout(r100);
        r105.f552352a = r106;
        r106.setBackgroundColor(0);
        addView(r105.f552352a, new ViewGroup.LayoutParams(-1, -1));
    }
}
