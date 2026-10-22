package com.larus.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.business.floatchat.impl.TouchDelegateFrameLayout;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes31.dex */
public final class v0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f375471a = 0;

    public static final class a extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f375472a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f375473b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f375474c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final ViewGroup f375475d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f375476e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final Rect f375477f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f375478g;

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (8 != this.f375474c.getVisibility()) goto L6;
            return false;
        L6:
            if (this.f375474c.isEnabled() == true) goto L8;
            return false;
        L8:
            ViewGroup r101 = this.f375475d;
            boolean r102 = true;
            if (r101 != null) goto L11;
        L10:
            boolean r103 = true;
        L17:
            if (r103 == true) goto L20;
            this.f375476e = false;
            return false;
        L20:
            ViewGroup r104 = this.f375475d;
            if (r104 != null) goto L23;
            this.f375474c.getHitRect(this.f375472a);
        L24:
            Rect r105 = this.f375472a;
            int r106 = r105.left;
            Rect r107 = this.f375473b;
            r105.left = r106 - r107.left;
            r105.top -= r107.top;
            r105.right += r107.right;
            r105.bottom += r107.bottom;
            this.f375477f.set(r105);
            Rect r108 = this.f375477f;
            int r109 = -this.f375478g;
            r108.inset(r109, r109);
            int r110 = (int) r100.getX();
            int r111 = (int) r100.getY();
            int r112 = r100.getAction();
            if (r112 == 0) goto L39;
            if (r112 == 1) goto L32;
            if (r112 == 2) goto L32;
            if (r112 != 3) goto L42;
            boolean r113 = this.f375476e;
            this.f375476e = false;
        L41:
            boolean r114 = r113;
        L43:
            if (r114 == false) goto L52;
            View r115 = this.f375474c;
            if (r102 == false) goto L47;
            r100.setLocation(r115.getWidth() / 2, r115.getHeight() / 2);
        L49:
            return r115.dispatchTouchEvent(r100);
        L47:
            float r116 = -(this.f375478g * 2);
            r100.setLocation(r116, r116);
            goto L49
        L52:
            return false;
        L42:
            r114 = false;
        L32:
            r114 = this.f375476e;
            if (r114 == true) goto L35;
        L37:
            r113 = r114;
            goto L41
        L35:
            if (this.f375477f.contains(r110, r111) == true) goto L37;
            r102 = false;
            goto L43
        L39:
            if (this.f375472a.contains(r110, r111) == false) goto L42;
            this.f375476e = true;
            r113 = true;
            goto L41
        L23:
            this.f375474c.getDrawingRect(this.f375472a);
            r104.offsetDescendantRectToMyCoords(this.f375474c, this.f375472a);
            goto L24
        L11:
            ViewParent r117 = this.f375474c.getParent();
        L12:
            if (r117 == null) goto L16;
            if (r117 == r101) goto L10;
            r117 = r117.getParent();
            goto L12
        L16:
            r103 = false;
            goto L17
        }

        public a(View r100, Rect r101) {
            Intrinsics.checkNotNullParameter(r100, "delegateView");
            Intrinsics.checkNotNullParameter(r101, "mExpandBounds");
            this(new Rect(), r101, r100, null);
        }

        public a(Rect r100, Rect r101, View r102, TouchDelegateFrameLayout r103) {
            super(r100, r102);
            this.f375472a = r100;
            this.f375473b = r101;
            this.f375474c = r102;
            this.f375475d = r103;
            this.f375477f = new Rect(r100);
            this.f375478g = ViewConfiguration.get(r102.getContext()).getScaledTouchSlop();
        }
    }

    public static final class b extends TouchDelegate {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Rect f375479c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a> f375480a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f375481b;

        public static final class a {
        }

        static {
            f375479c = new Rect();
        }

        public b(View r100) {
            super(f375479c, r100);
            this.f375480a = new LinkedList();
        }

        public final void a(a r100) {
            Intrinsics.checkNotNullParameter(r100, "touchDelegate");
            ((LinkedList) this.f375480a).add(r100);
        }

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            int r101 = r100.getAction();
            a r102 = null;
            if (r101 == 0) goto L12;
            if (r101 != 1) goto L6;
        L11:
            a r103 = this.f375481b;
            this.f375481b = null;
            r102 = r103;
        L31:
            if (r102 != null) goto L33;
            return false;
        L33:
            if (r102.onTouchEvent(r100) == false) goto L46;
            return true;
        L46:
            return false;
        L6:
            if (r101 != 2) goto L8;
            r102 = this.f375481b;
            goto L31
        L8:
            if (r101 == 3) goto L11;
        L12:
            int r104 = 0;
        L14:
            if (r104 >= ((LinkedList) this.f375480a).size()) goto L31;
            a r105 = (a) ListProtector.get(this.f375480a, r104);
            ViewGroup r106 = r105.f375475d;
            if (r106 != null) goto L18;
        L17:
            boolean r107 = true;
        L24:
            if (r107 == false) goto L25;
            if (r105.onTouchEvent(r100) == true) goto L28;
            r104 = r104 + 1;
            goto L14
        L28:
            this.f375481b = r105;
            return true;
        L25:
            ListProtector.remove(this.f375480a, r104);
            goto L14
        L18:
            ViewParent r108 = r105.f375474c.getParent();
        L19:
            if (r108 == null) goto L23;
            if (r108 == r106) goto L17;
            r108 = r108.getParent();
            goto L19
        L23:
            r107 = false;
            goto L24
        }
    }

    static {
    }

    public static void a(View r100, int r101, int r102, int r103, int r104) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Object r105 = r100.getParent();
        if ((r105 instanceof View) == false) goto L5;
        View r106 = (View) r105;
    L6:
        if (r106 != null) goto L8;
        return;
    L8:
        Rect r107 = new Rect();
        r107.left = c7.b(Integer.valueOf(r101));
        r107.top = c7.b(Integer.valueOf(r102));
        r107.right = c7.b(Integer.valueOf(r103));
        r107.bottom = c7.b(Integer.valueOf(r104));
        TouchDelegate r108 = r106.getTouchDelegate();
        if ((r108 instanceof b) == false) goto L11;
        ((b) r108).a(new a(r100, r107));
        return;
    L11:
        b r109 = new b(r100);
        r106.setTouchDelegate(r109);
        r109.a(new a(r100, r107));
        return;
    L5:
        r106 = null;
        goto L6
    }
}
