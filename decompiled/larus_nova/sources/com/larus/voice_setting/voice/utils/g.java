package com.larus.voice_setting.voice.utils;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.appcompat.widget.AppCompatImageView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.LinkedList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f377028a = 0;

    public static final class a extends TouchDelegate {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Rect f377029a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Rect f377030b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f377031c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f377032d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final Rect f377033e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final int f377034f;

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (8 != this.f377031c.getVisibility()) goto L6;
            return false;
        L6:
            if (this.f377031c.isEnabled() == true) goto L8;
            return false;
        L8:
            this.f377031c.getHitRect(this.f377029a);
            Rect r101 = this.f377029a;
            int r102 = r101.left;
            Rect r103 = this.f377030b;
            r101.left = r102 - r103.left;
            r101.top -= r103.top;
            r101.right += r103.right;
            r101.bottom += r103.bottom;
            this.f377033e.set(r101);
            Rect r104 = this.f377033e;
            int r105 = this.f377034f;
            r104.inset(-r105, -r105);
            int r106 = (int) r100.getX();
            int r107 = (int) r100.getY();
            int r108 = r100.getAction();
            boolean r109 = true;
            if (r108 == 0) goto L24;
            if (r108 == 1) goto L16;
            if (r108 == 2) goto L16;
            if (r108 != 3) goto L26;
            boolean r110 = this.f377032d;
            this.f377032d = false;
            r109 = r110;
        L22:
            boolean r111 = true;
        L27:
            if (r109 == false) goto L34;
            View r112 = this.f377031c;
            if (r111 == false) goto L31;
            r100.setLocation(r112.getWidth() / 2, r112.getHeight() / 2);
        L33:
            return r112.dispatchTouchEvent(r100);
        L31:
            float r113 = -(this.f377034f * 2);
            r100.setLocation(r113, r113);
            goto L33
        L34:
            return false;
        L26:
            r111 = true;
            r109 = false;
        L16:
            boolean r114 = this.f377032d;
            if (r114 == true) goto L19;
        L21:
            r109 = r114;
            goto L22
        L19:
            if (this.f377033e.contains(r106, r107) == true) goto L21;
            r109 = r114;
            r111 = false;
            goto L27
        L24:
            if (this.f377029a.contains(r106, r107) == false) goto L26;
            this.f377032d = true;
            goto L22
        }

        public a(AppCompatImageView r100, Rect r101) {
            Intrinsics.checkNotNullParameter(r100, "delegateView");
            Intrinsics.checkNotNullParameter(r101, "mExpandBounds");
            Rect r102 = new Rect();
            super(r102, r100);
            this.f377029a = r102;
            this.f377030b = r101;
            this.f377031c = r100;
            this.f377033e = new Rect(r102);
            this.f377034f = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        }
    }

    public static final class b extends TouchDelegate {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Rect f377035c = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<a> f377036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public a f377037b;

        public static final class a {
        }

        static {
            f377035c = new Rect();
        }

        public b(AppCompatImageView r100) {
            super(f377035c, r100);
            this.f377036a = new LinkedList();
        }

        @Override // android.view.TouchDelegate
        public final boolean onTouchEvent(MotionEvent r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            int r101 = r100.getAction();
            a r102 = null;
            if (r101 == 0) goto L12;
            if (r101 != 1) goto L6;
        L11:
            a r103 = this.f377037b;
            this.f377037b = null;
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
            r102 = this.f377037b;
            goto L20
        L8:
            if (r101 == 3) goto L11;
        L12:
            int r104 = 0;
        L14:
            if (r104 >= ((LinkedList) this.f377036a).size()) goto L20;
            a r105 = (a) ListProtector.get(this.f377036a, r104);
            if (r105.onTouchEvent(r100) == true) goto L17;
            r104 = r104 + 1;
            goto L14
        L17:
            this.f377037b = r105;
            return true;
        }
    }

    static {
    }

    public static void a(AppCompatImageView r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        Object r102 = r100.getParent();
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.view.View");
        View r103 = (View) r102;
        Rect r104 = new Rect();
        r104.left = c7.b(Integer.valueOf(r101));
        r104.top = c7.b(Integer.valueOf(r101));
        r104.right = c7.b(Integer.valueOf(r101));
        r104.bottom = c7.b(Integer.valueOf(r101));
        TouchDelegate r105 = r103.getTouchDelegate();
        if ((r105 instanceof b) == false) goto L5;
        b r106 = (b) r105;
        a r107 = new a(r100, r104);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "touchDelegate");
        ((LinkedList) r106.f377036a).add(r107);
        return;
    L5:
        b r108 = new b(r100);
        r103.setTouchDelegate(r108);
        a r109 = new a(r100, r104);
        Intrinsics.checkNotNullParameter(r109, "touchDelegate");
        ((LinkedList) r108.f377036a).add(r109);
    }
}
