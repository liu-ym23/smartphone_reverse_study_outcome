package gr3;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import com.bytedance.android.ec.core.utils.q;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class a {

    /* JADX INFO: renamed from: gr3.a$a, reason: collision with other inner class name */
    public static final class C6057a {
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f482342a = null;

        static {
            f482342a = new b();
        }

        public b() {
        }

        @Override // gr3.a
        public final void a(Canvas r100, Rect r101, Paint r110, gr3.b r111) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Intrinsics.checkNotNullParameter(r101, "area");
            Intrinsics.checkNotNullParameter(r110, "paint");
            Intrinsics.checkNotNullParameter(r111, "areaCutter");
            int r102 = r110.getColor();
            Rect r103 = r111.a(r101);
            r110.setColor(-1);
            Path r104 = new Path();
            a.b(r100, r103, r110, 3, q.a(10), r104);
            r100.drawPath(r104, r110);
            r110.setColor(r102);
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f482343a = null;

        static {
            f482343a = new c();
        }

        public c() {
        }

        @Override // gr3.a
        public final void a(Canvas r100, Rect r110, Paint r111, gr3.b r112) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Intrinsics.checkNotNullParameter(r110, "area");
            Intrinsics.checkNotNullParameter(r111, "paint");
            Intrinsics.checkNotNullParameter(r112, "areaCutter");
            int r101 = r111.getColor();
            r111.setColor(-1);
            Path r102 = new Path();
            a.b(r100, r112.a(r110), r111, 3, q.a(10), r102);
            r100.drawPath(r102, r111);
            r111.setColor(r101);
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f482344a = null;

        static {
            f482344a = new d();
        }

        public d() {
        }

        @Override // gr3.a
        public final void a(Canvas r100, Rect r101, Paint r110, gr3.b r111) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Intrinsics.checkNotNullParameter(r101, "area");
            Intrinsics.checkNotNullParameter(r110, "paint");
            Intrinsics.checkNotNullParameter(r111, "areaCutter");
            Rect r102 = r111.a(r101);
            int r103 = r110.getColor();
            r110.setColor(-1);
            Path r112 = new Path();
            a.b(r100, r102, r110, 12, q.a(10), r112);
            r100.drawPath(r112, r110);
            r110.setColor(r103);
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f482345a = null;

        static {
            f482345a = new e();
        }

        public e() {
        }

        @Override // gr3.a
        public final void a(Canvas r100, Rect r101, Paint r102, gr3.b r103) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Intrinsics.checkNotNullParameter(r101, "area");
            Intrinsics.checkNotNullParameter(r102, "paint");
            Intrinsics.checkNotNullParameter(r103, "areaCutter");
            int r104 = r102.getColor();
            r102.setColor(-1);
            r100.drawRect(r103.a(r101), r102);
            r102.setColor(r104);
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f482346a = null;

        static {
            f482346a = new f();
        }

        public f() {
        }

        @Override // gr3.a
        public final void a(Canvas r100, Rect r101, Paint r110, gr3.b r111) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Intrinsics.checkNotNullParameter(r101, "area");
            Intrinsics.checkNotNullParameter(r110, "paint");
            Intrinsics.checkNotNullParameter(r111, "areaCutter");
            int r102 = r110.getColor();
            Rect r103 = r111.a(r101);
            r110.setColor(-1);
            Path r104 = new Path();
            a.b(r100, r103, r110, 15, q.a(10), r104);
            r100.drawPath(r104, r110);
            r110.setColor(r102);
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f482347a = null;

        static {
            f482347a = new g();
        }

        public g() {
        }

        @Override // gr3.a
        public final void a(Canvas r100, Rect r101, Paint r110, gr3.b r111) {
            Intrinsics.checkNotNullParameter(r100, "c");
            Intrinsics.checkNotNullParameter(r101, "area");
            Intrinsics.checkNotNullParameter(r110, "paint");
            Intrinsics.checkNotNullParameter(r111, "areaCutter");
            int r102 = r110.getColor();
            Rect r103 = r111.a(r101);
            r110.setColor(-1);
            Path r104 = new Path();
            a.b(r100, r103, r110, 12, q.a(10), r104);
            r100.drawPath(r104, r110);
            r110.setColor(r102);
        }
    }

    static {
    }

    public a() {
    }

    public abstract void a(Canvas r100, Rect r101, Paint r102, gr3.b r103);

    public static void b(Canvas r100, Rect r101, Paint r102, int r110, float r111, Path r112) {
        Intrinsics.checkNotNullParameter(r100, "c");
        Intrinsics.checkNotNullParameter(r101, "area");
        Intrinsics.checkNotNullParameter(r102, "paint");
        Intrinsics.checkNotNullParameter(r112, "cleanPath");
        if ((r110 & 15) != 0) goto L6;
        r100.drawRect(r101, r102);
        return;
    L6:
        float r103 = 2 * r111;
        float r104 = r101.width();
        float r105 = r101.height();
        r112.moveTo(0.0f, r111);
        if ((r110 & 1) != 1) goto L9;
        r112.arcTo(new RectF(0.0f, 0.0f, r103, r103), 180.0f, 90.0f);
    L10:
        float r106 = r104 - r111;
        r112.lineTo(r106, 0.0f);
        if ((r110 & 2) != 2) goto L13;
        r112.arcTo(new RectF(r104 - r103, 0.0f, r104, r103), 270.0f, 90.0f);
    L14:
        float r107 = r105 - r111;
        r112.lineTo(r104, r107);
        if ((r110 & 4) != 4) goto L17;
        r112.arcTo(new RectF(r104 - r103, r105 - r103, r104, r105), 0.0f, 90.0f);
    L18:
        r112.lineTo(r111, r105);
        if ((r110 & 8) != 8) goto L21;
        r112.arcTo(new RectF(0.0f, r105 - r103, r103, r105), 90.0f, 90.0f);
    L22:
        r112.lineTo(0.0f, r111);
        r112.close();
        r112.offset(r101.left, r101.top);
        return;
    L21:
        r112.lineTo(0.0f, r105);
        r112.lineTo(0.0f, r107);
        goto L22
    L17:
        r112.lineTo(r104, r105);
        r112.lineTo(r106, r105);
        goto L18
    L13:
        r112.lineTo(r104, 0.0f);
        r112.lineTo(r104, r111);
        goto L14
    L9:
        r112.lineTo(0.0f, 0.0f);
        r112.lineTo(r111, 0.0f);
        goto L10
    }
}
