package xb9;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class a extends TouchDelegate {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Rect f563160c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<C8211a> f563161a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public C8211a f563162b;

    /* JADX INFO: renamed from: xb9.a$a, reason: collision with other inner class name */
    public static final class C8211a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f563163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f563164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f563165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f563166d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f563167e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f563168f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f563169g;

        public final boolean a(MotionEvent r100, int r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "event");
            if (this.f563163a.getVisibility() != 8) goto L5;
        L32:
            return false;
        L5:
            if (this.f563163a.isEnabled() == false) goto L32;
            Rect r103 = new Rect();
            this.f563163a.getHitRect(r103);
            r103.left -= this.f563164b;
            r103.top -= this.f563165c;
            r103.right += this.f563166d;
            r103.bottom += this.f563167e;
            Rect r104 = new Rect(r103);
            int r105 = -this.f563169g;
            r104.inset(r105, r105);
            int r106 = r100.getActionMasked();
            boolean r107 = true;
            if (r106 == 0) goto L22;
            if (r106 == 1) goto L15;
            if (r106 == 2) goto L15;
            if (r106 != 3) goto L25;
            boolean r108 = this.f563168f;
            this.f563168f = false;
        L24:
            boolean r109 = r108;
        L26:
            if (r109 == false) goto L32;
            if (r107 == false) goto L29;
            r100.setLocation(this.f563163a.getWidth() / 2.0f, this.f563163a.getHeight() / 2.0f);
        L31:
            return this.f563163a.dispatchTouchEvent(r100);
        L29:
            float r110 = -(this.f563169g * 2);
            r100.setLocation(r110, r110);
        L25:
            r109 = false;
        L15:
            r109 = this.f563168f;
            if (r109 == true) goto L18;
        L20:
            r108 = r109;
            goto L24
        L18:
            if (r104.contains(r101, r102) == true) goto L20;
            r107 = false;
            goto L26
        L22:
            if (r103.contains(r101, r102) == false) goto L25;
            this.f563168f = true;
            r108 = true;
            goto L24
        }

        public C8211a(View r100, int r101, int r102, int r103, int r104) {
            Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
            this.f563163a = r100;
            this.f563164b = r101;
            this.f563165c = r102;
            this.f563166d = r103;
            this.f563167e = r104;
            this.f563169g = ViewConfiguration.get(r100.getContext()).getScaledTouchSlop();
        }
    }

    public static final class b {
    }

    static {
        f563160c = new Rect();
    }

    public a(View r100) {
        Intrinsics.checkNotNullParameter(r100, "uselessView");
        super(f563160c, r100);
        this.f563161a = new ArrayList();
    }

    @Override // android.view.TouchDelegate
    public final boolean onTouchEvent(MotionEvent r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        int r101 = (int) r100.getX();
        int r102 = (int) r100.getY();
        int r103 = r100.getActionMasked();
        boolean r104 = false;
        if (r103 == 0) goto L19;
        if (r103 != 1) goto L6;
    L14:
        C8211a r105 = this.f563162b;
        if (r105 == null) goto L17;
        r104 = r105.a(r100, r101, r102);
    L17:
        this.f563162b = null;
        return r104;
    L6:
        if (r103 != 2) goto L8;
        C8211a r106 = this.f563162b;
        if (r106 != null) goto L13;
        return false;
    L13:
        return r106.a(r100, r101, r102);
    L8:
        if (r103 == 3) goto L14;
    L26:
        return false;
    L19:
        Iterator r107 = ((ArrayList) this.f563161a).iterator();
    L21:
        if (r107.hasNext() == false) goto L26;
        C8211a r108 = (C8211a) r107.next();
        if (r108.a(r100, r101, r102) == false) goto L21;
        this.f563162b = r108;
        return true;
    }

    public final void a(View r100, int r110, int r111, int r112, int r113) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        List<C8211a> r101 = this.f563161a;
        ArrayList r102 = (ArrayList) r101;
        r102.add(new C8211a(r100, r110, r111, r112, r113));
    }
}
