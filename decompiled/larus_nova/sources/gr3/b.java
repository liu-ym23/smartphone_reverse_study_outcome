package gr3;

import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f482348a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f482349b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f482350c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f482351d;

        public a(int r100) {
            this.f482348a = 0;
            this.f482349b = r100;
            this.f482350c = 0;
            this.f482351d = 0;
        }

        @Override // gr3.b
        public final Rect a(Rect r100) {
            Intrinsics.checkNotNullParameter(r100, "area");
            return new Rect(r100.left + this.f482348a, r100.top + this.f482349b, r100.right - this.f482350c, r100.bottom - this.f482351d);
        }
    }

    /* JADX INFO: renamed from: gr3.b$b, reason: collision with other inner class name */
    public static final class C6058b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6058b f482352a = null;

        static {
            f482352a = new C6058b();
        }

        public C6058b() {
        }

        @Override // gr3.b
        public final Rect a(Rect r100) {
            Intrinsics.checkNotNullParameter(r100, "area");
            return new Rect(r100);
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f482353a = null;

        static {
            f482353a = new c();
        }

        public c() {
        }

        @Override // gr3.b
        public final Rect a(Rect r100) {
            Intrinsics.checkNotNullParameter(r100, "area");
            int r101 = r100.height();
            int r102 = r100.top + (r101 / 2);
            return new Rect(r100.left, r102, r100.right, r102);
        }
    }

    public b() {
    }

    public abstract Rect a(Rect r100);
}
