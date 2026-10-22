package gr3;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.android.ec.core.utils.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class a {

    /* JADX INFO: renamed from: gr3.a$a, reason: collision with other inner class name */
    public static final class C0129a {
    }

    public static final class b extends a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // gr3.a
        public final void a(Canvas r8, Rect r9, Paint r10, gr3.b r11) {
            Intrinsics.checkNotNullParameter(r8, "c");
            Intrinsics.checkNotNullParameter(r9, "area");
            Intrinsics.checkNotNullParameter(r10, "paint");
            Intrinsics.checkNotNullParameter(r11, "areaCutter");
            int r0 = r10.getColor();
            Rect r2 = r11.a(r9);
            r10.setColor(-1);
            Path r12 = new Path();
            a.b(r8, r2, r10, 3, q.a(10), r12);
            r8.drawPath(r12, r10);
            r10.setColor(r0);
        }
    }

    public static final class c extends a {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // gr3.a
        public final void a(Canvas r9, Rect r10, Paint r11, gr3.b r12) {
            Intrinsics.checkNotNullParameter(r9, "c");
            Intrinsics.checkNotNullParameter(r10, "area");
            Intrinsics.checkNotNullParameter(r11, "paint");
            Intrinsics.checkNotNullParameter(r12, "areaCutter");
            int r0 = r11.getColor();
            r11.setColor(-1);
            Path r1 = new Path();
            a.b(r9, r12.a(r10), r11, 3, q.a(10), r1);
            r9.drawPath(r1, r11);
            r11.setColor(r0);
        }
    }

    public static final class d extends a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }

        @Override // gr3.a
        public final void a(Canvas r8, Rect r9, Paint r10, gr3.b r11) {
            Intrinsics.checkNotNullParameter(r8, "c");
            Intrinsics.checkNotNullParameter(r9, "area");
            Intrinsics.checkNotNullParameter(r10, "paint");
            Intrinsics.checkNotNullParameter(r11, "areaCutter");
            Rect r2 = r11.a(r9);
            int r12 = r10.getColor();
            r10.setColor(-1);
            Path r13 = new Path();
            a.b(r8, r2, r10, 12, q.a(10), r13);
            r8.drawPath(r13, r10);
            r10.setColor(r12);
        }
    }

    public static final class e extends a {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // gr3.a
        public final void a(Canvas r3, Rect r4, Paint r5, gr3.b r6) {
            Intrinsics.checkNotNullParameter(r3, "c");
            Intrinsics.checkNotNullParameter(r4, "area");
            Intrinsics.checkNotNullParameter(r5, "paint");
            Intrinsics.checkNotNullParameter(r6, "areaCutter");
            int r0 = r5.getColor();
            r5.setColor(-1);
            r3.drawRect(r6.a(r4), r5);
            r5.setColor(r0);
        }
    }

    public static final class f extends a {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }

        @Override // gr3.a
        public final void a(Canvas r8, Rect r9, Paint r10, gr3.b r11) {
            Intrinsics.checkNotNullParameter(r8, "c");
            Intrinsics.checkNotNullParameter(r9, "area");
            Intrinsics.checkNotNullParameter(r10, "paint");
            Intrinsics.checkNotNullParameter(r11, "areaCutter");
            int r0 = r10.getColor();
            Rect r2 = r11.a(r9);
            r10.setColor(-1);
            Path r12 = new Path();
            a.b(r8, r2, r10, 15, q.a(10), r12);
            r8.drawPath(r12, r10);
            r10.setColor(r0);
        }
    }

    public static final class g extends a {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }

        @Override // gr3.a
        public final void a(Canvas r8, Rect r9, Paint r10, gr3.b r11) {
            Intrinsics.checkNotNullParameter(r8, "c");
            Intrinsics.checkNotNullParameter(r9, "area");
            Intrinsics.checkNotNullParameter(r10, "paint");
            Intrinsics.checkNotNullParameter(r11, "areaCutter");
            int r0 = r10.getColor();
            Rect r2 = r11.a(r9);
            r10.setColor(-1);
            Path r12 = new Path();
            a.b(r8, r2, r10, 12, q.a(10), r12);
            r8.drawPath(r12, r10);
            r10.setColor(r0);
        }
    }

    static {
    }

    public a() {
    }

    public abstract void a(Canvas r1, Rect r2, Paint r3, gr3.b r4);

    public static void b(Canvas r7, Rect r8, Paint r9, int r10, float r11, Path r12) {
        Intrinsics.checkNotNullParameter(r7, "c");
        Intrinsics.checkNotNullParameter(r8, "area");
        Intrinsics.checkNotNullParameter(r9, "paint");
        Intrinsics.checkNotNullParameter(r12, "cleanPath");
        if ((r10 & 15) != 0) goto L6;
        r7.drawRect(r8, r9);
        return;
    L6:
        float r13 = 2 * r11;
        float r0 = r8.width();
        float r1 = r8.height();
        r12.moveTo(0.0f, r11);
        if ((r10 & 1) != 1) goto L9;
        r12.arcTo(new RectF(0.0f, 0.0f, r13, r13), 180.0f, 90.0f);
    L10:
        float r3 = r0 - r11;
        r12.lineTo(r3, 0.0f);
        if ((r10 & 2) != 2) goto L13;
        r12.arcTo(new RectF(r0 - r13, 0.0f, r0, r13), 270.0f, 90.0f);
    L14:
        float r14 = r1 - r11;
        r12.lineTo(r0, r14);
        if ((r10 & 4) != 4) goto L17;
        r12.arcTo(new RectF(r0 - r13, r1 - r13, r0, r1), 0.0f, 90.0f);
    L18:
        r12.lineTo(r11, r1);
        if ((r10 & 8) != 8) goto L21;
        r12.arcTo(new RectF(0.0f, r1 - r13, r13, r1), 90.0f, 90.0f);
    L22:
        r12.lineTo(0.0f, r11);
        r12.close();
        r12.offset(r8.left, r8.top);
        return;
    L21:
        r12.lineTo(0.0f, r1);
        r12.lineTo(0.0f, r14);
        goto L22
    L17:
        r12.lineTo(r0, r1);
        r12.lineTo(r3, r1);
        goto L18
    L13:
        r12.lineTo(r0, 0.0f);
        r12.lineTo(r0, r11);
        goto L14
    L9:
        r12.lineTo(0.0f, 0.0f);
        r12.lineTo(r11, 0.0f);
        goto L10
    }
}
