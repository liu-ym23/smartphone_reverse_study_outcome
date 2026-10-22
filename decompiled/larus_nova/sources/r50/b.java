package r50;

import com.bytedance.android.live.core.gl.primitive.Align;
import kotlin.jvm.internal.Intrinsics;
import m50.c;
import m50.e;

/* JADX INFO: loaded from: classes45.dex */
public final class b extends r50.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f536136d = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: r50.b$b, reason: collision with other inner class name */
    public static final class C7435b {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public static final /* synthetic */ int f536137h = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Align f536138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f536139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f536140c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f536141d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final float f536142e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f536143f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public com.bytedance.android.live.core.gl.primitive.b f536144g;

        /* JADX INFO: renamed from: r50.b$b$a */
        public static final class a {
            public static float[] b(float r110, float r111, boolean r112, boolean r113) {
                if (r110 > 0.0f) goto L5;
                return null;
            L5:
                if (r111 > 0.0f) goto L8;
                return null;
            L8:
                if (r112 == true) goto L11;
                if (r113 == true) goto L11;
                float r114 = r110 * 0.0f;
                float r100 = 0.0f * r111;
                float r115 = r111 * 1.0f;
                float r116 = r110 * 1.0f;
                return new float[]{r114, r100, r114, r115, r116, r115, r116, r100};
            L11:
                if (r112 == false) goto L14;
                if (r113 == true) goto L14;
                float r117 = r110 * 0.0f;
                float r101 = r111 * 1.0f;
                float r118 = r111 * 0.0f;
                float r119 = r110 * 1.0f;
                return new float[]{r117, r101, r117, r118, r119, r118, r119, r101};
            L14:
                if (r112 == true) goto L17;
                if (r113 == false) goto L17;
                float r120 = r110 * 1.0f;
                float r102 = r111 * 0.0f;
                float r121 = r111 * 1.0f;
                float r122 = r110 * 0.0f;
                return new float[]{r120, r102, r120, r121, r122, r121, r122, r102};
            L17:
                float r123 = r110 * 1.0f;
                float r124 = 1.0f * r111;
                float r125 = r111 * 0.0f;
                float r126 = r110 * 0.0f;
                return new float[]{r123, r124, r123, r125, r126, r125, r126, r124};
            }

            public static float[] a(boolean r100, boolean r101) {
                if (r100 == true) goto L6;
                return null;
            L6:
                if (r101 == false) goto L9;
                return new float[]{0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
            L9:
                return new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f};
            }

            public static float[] c(float r110, float r111, boolean r112, Align r210) {
                Intrinsics.checkNotNullParameter(r210, "align");
                if (r112 == false) goto L6;
                return new float[]{-r210.getLeftMargin(r110), r210.getTopMargin(r111), 0.0f, -r210.getLeftMargin(r110), -r210.getBottomMargin(r111), 0.0f, r210.getRightMargin(r110), -r210.getBottomMargin(r111), 0.0f, r210.getRightMargin(r110), r210.getTopMargin(r111), 0.0f};
            L6:
                return new float[]{-r210.getLeftMargin(r110), 0.0f, r210.getTopMargin(r111), -r210.getLeftMargin(r110), 0.0f, -r210.getBottomMargin(r111), r210.getRightMargin(r110), 0.0f, -r210.getBottomMargin(r111), r210.getRightMargin(r110), 0.0f, r210.getTopMargin(r111)};
            }
        }

        static {
        }

        public final b a() {
            b r100 = new b(a.c(this.f536139b, this.f536140c, true, this.f536138a), a.b(this.f536141d, this.f536142e, false, false), a.a(false, true), new short[]{1, 2, 3, 1, 3, 0});
            int r101 = this.f536143f;
            if (r101 == (-1)) goto L5;
            r100.f536135c.f512075a = r101;
        L5:
            Intrinsics.checkNotNullParameter(this.f536138a, "<set-?>");
            m50.a r102 = r100.f536134b;
            e r103 = r102.f512062a;
            if (r103 == null) goto L8;
            r103.f512082e = null;
        L8:
            e r104 = r102.f512064c;
            if (r104 == null) goto L11;
            r104.f512082e = null;
        L11:
            e r105 = r102.f512063b;
            if (r105 == null) goto L14;
            r105.f512082e = null;
        L14:
            e r106 = r102.f512065d;
            if (r106 == null) goto L17;
            r106.f512082e = null;
        L17:
            c r107 = r102.f512066e;
            if (r107 == null) goto L20;
            r107.f512072e = null;
        L20:
            return r100;
        }

        public C7435b() {
            this.f536138a = Align.CENTER;
            this.f536139b = 1.0f;
            this.f536140c = 1.0f;
            this.f536141d = 1.0f;
            this.f536142e = 1.0f;
            this.f536143f = -1;
        }

        public final void b(float r100, float r101) {
            com.bytedance.android.live.core.gl.primitive.b r102 = this.f536144g;
            if (r102 == null) goto L5;
            r100 = r102.b(r100);
        L5:
            this.f536139b = r100;
            com.bytedance.android.live.core.gl.primitive.b r103 = this.f536144g;
            if (r103 == null) goto L8;
            r101 = r103.b(r101);
        L8:
            this.f536140c = r101;
        }
    }

    static {
    }

    public b(float[] r110, float[] r111, float[] r112, short[] r113) {
        Align r100 = Align.CENTER;
        Intrinsics.checkNotNullParameter(r100, "align");
        m50.a r101 = this.f536134b;
        int r102 = C7435b.f536137h;
        r101.b(C7435b.a.c(1.0f, 1.0f, true, r100), C7435b.a.b(1.0f, 1.0f, false, false), C7435b.a.a(false, true), null, new short[]{1, 2, 3, 1, 3, 0});
        this.f536134b.a();
        this.f536134b.d();
        this.f536134b.b(r110, r111, r112, null, r113);
        this.f536134b.a();
        this.f536134b.d();
    }
}
