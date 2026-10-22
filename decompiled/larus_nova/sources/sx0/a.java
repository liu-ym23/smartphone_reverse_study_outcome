package sx0;

import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class a {

    /* JADX INFO: renamed from: sx0.a$a, reason: collision with other inner class name */
    public static final class C7666a extends a implements sx0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f543783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f543784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f543785c;

        @Override // sx0.b
        public final float a() {
            return this.f543783a;
        }

        public C7666a(float r100, int r101, float r102) {
            this.f543783a = r100;
            this.f543784b = r101;
            this.f543785c = r102;
        }
    }

    public static final class b extends a implements sx0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f543786a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f543787b;

        @Override // sx0.b
        public final float a() {
            return this.f543786a;
        }

        public b(float r100, int r101) {
            this.f543786a = r100;
            this.f543787b = r101;
        }
    }

    public static final class c extends a implements sx0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f543788a;

        @Override // sx0.b
        public final float a() {
            return this.f543788a;
        }

        public c(float r100) {
            this.f543788a = r100;
        }
    }

    public static final class d extends a implements sx0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f543789a;

        @Override // sx0.b
        public final float a() {
            return this.f543789a;
        }

        public d(float r100) {
            this.f543789a = r100;
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final RectF f543790a;

        public e(RectF r100) {
            Intrinsics.checkNotNullParameter(r100, "playerArea");
            this.f543790a = r100;
        }
    }

    public static final class f extends a implements sx0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f543791a;

        @Override // sx0.b
        public final float a() {
            return this.f543791a;
        }

        public f(float r100) {
            this.f543791a = r100;
        }
    }

    public static final class g extends a implements sx0.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f543792a;

        @Override // sx0.b
        public final float a() {
            return this.f543792a;
        }

        public g(float r100) {
            this.f543792a = r100;
        }
    }

    public a() {
    }
}
