package com.obric.assistant.component.task;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f388873a = 0;

    public static final class a extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f388874a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f388875b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f388876c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f388877d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Rect f388878e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f388879f;

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (8 != this.f388876c.getVisibility()) goto L6;
            return false;
        L6:
            if (this.f388876c.isEnabled() == true) goto L8;
            return false;
        L8:
            this.f388876c.getHitRect(this.f388874a);
            Rect r101 = this.f388874a;
            int r102 = r101.left;
            Rect r103 = this.f388875b;
            r101.left = r102 - r103.left;
            r101.top -= r103.top;
            r101.right += r103.right;
            r101.bottom += r103.bottom;
            this.f388878e.set(r101);
            Rect r104 = this.f388878e;
            int r105 = this.f388879f;
            r104.inset(-r105, -r105);
            int r106 = (int) r100.getX();
            int r107 = (int) r100.getY();
            int r108 = r100.getAction();
            boolean r109 = true;
            if (r108 == 0) goto L24;
            if (r108 == 1) goto L16;
            if (r108 == 2) goto L16;
            if (r108 != 3) goto L26;
            boolean r110 = this.f388877d;
            this.f388877d = false;
            r109 = r110;
        L22:
            boolean r111 = true;
        L27:
            if (r109 == false) goto L34;
            View r112 = this.f388876c;
            if (r111 == false) goto L31;
            r100.setLocation(r112.getWidth() / 2, r112.getHeight() / 2);
        L33:
            return r112.dispatchTouchEvent(r100);
        L31:
            float r113 = -(this.f388879f * 2);
            r100.setLocation(r113, r113);
            goto L33
        L34:
            return false;
        L26:
            r111 = true;
            r109 = false;
        L16:
            boolean r114 = this.f388877d;
            if (r114 == true) goto L19;
        L21:
            r109 = r114;
            goto L22
        L19:
            if (this.f388878e.contains(r106, r107) == true) goto L21;
            r109 = r114;
            r111 = false;
            goto L27
        L24:
            if (this.f388874a.contains(r106, r107) == false) goto L26;
            this.f388877d = true;
            goto L22
        }

        public a(SimpleDraweeView r100, Rect r101) {
            Intrinsics.checkNotNullParameter(r100, "delegateView");
            Intrinsics.checkNotNullParameter(r101, "mExpandBounds");
            Rect r102 = new Rect();
            super(r102, r100);
            this.f388874a = r102;
            this.f388875b = r101;
            this.f388876c = r100;
            this.f388878e = new Rect(r102);
            this.f388879f = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        }
    }

    public static final class b extends TouchDelegate {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Rect f388880c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a> f388881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f388882b;

        public static final class a {
        }

        static {
            f388880c = new Rect();
        }

        public b(SimpleDraweeView r100) {
            super(f388880c, r100);
            this.f388881a = new LinkedList();
        }

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            int r101 = r100.getAction();
            a r102 = null;
            if (r101 == 0) goto L12;
            if (r101 != 1) goto L6;
        L11:
            a r103 = this.f388882b;
            this.f388882b = null;
            r102 = r103;
        L20:
            if (r102 != null) goto L22;
            return false;
        L22:
            if (r102.onTouchEvent(r100) == false) goto L28;
            return true;
        L28:
            return false;
        L6:
            if (r101 != 2) goto L8;
            r102 = this.f388882b;
            goto L20
        L8:
            if (r101 == 3) goto L11;
        L12:
            int r104 = 0;
        L14:
            if (r104 >= ((LinkedList) this.f388881a).size()) goto L20;
            a r105 = (a) ListProtector.get(this.f388881a, r104);
            if (r105.onTouchEvent(r100) == true) goto L17;
            r104 = r104 + 1;
            goto L14
        L17:
            this.f388882b = r105;
            return true;
        }
    }

    static {
    }
}
