package gr3;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class b {

    public static final class a extends b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;

        public a(int r2) {
            this.a = 0;
            this.b = r2;
            this.c = 0;
            this.d = 0;
        }

        @Override // gr3.b
        public final Rect a(Rect r6) {
            Intrinsics.checkNotNullParameter(r6, "area");
            return new Rect(r6.left + this.a, r6.top + this.b, r6.right - this.c, r6.bottom - this.d);
        }
    }

    /* JADX INFO: renamed from: gr3.b$b, reason: collision with other inner class name */
    public static final class C0130b extends b {
        public static final C0130b a = null;

        static {
            a = new C0130b();
        }

        public C0130b() {
        }

        @Override // gr3.b
        public final Rect a(Rect r2) {
            Intrinsics.checkNotNullParameter(r2, "area");
            return new Rect(r2);
        }
    }

    public static final class c extends b {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        @Override // gr3.b
        public final Rect a(Rect r4) {
            Intrinsics.checkNotNullParameter(r4, "area");
            int r0 = r4.height();
            int r1 = r4.top + (r0 / 2);
            return new Rect(r4.left, r1, r4.right, r1);
        }
    }

    public b() {
    }

    public abstract Rect a(Rect r1);
}
