package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import android.graphics.RectF;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes23.dex */
public interface h extends m {

    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f274288a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f274288a, ((a) r100).f274288a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f274288a.hashCode();
        }

        public final String toString() {
            return "AsPixelShape(pixelShape=" + this.f274288a + ')';
        }

        public a(l r100) {
            Intrinsics.checkNotNullParameter(r100, "pixelShape");
            this.f274288a = r100;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
        public final Path a(float r110, com.github.alexzhirkevich.customqrgenerator.style.c r111) {
            Intrinsics.checkNotNullParameter(r111, "neighbors");
            Path r112 = new Path();
            QrCodeMatrix r100 = com.github.alexzhirkevich.customqrgenerator.encoder.c.a(new com.google.zxing.qrcode.encoder.b(7, 7));
            int r101 = 0;
        L3:
            if (r101 >= 7) goto L16;
            int r102 = 0;
        L5:
            if (r102 >= 7) goto L15;
            if (r101 == 0) goto L13;
            if (r102 == 0) goto L13;
            if (r101 == 6) goto L13;
            if (r102 == 6) goto L13;
            QrCodeMatrix.PixelType r103 = QrCodeMatrix.PixelType.Background;
        L14:
            r100.b(r101, r102, r103);
            r102 = r102 + 1;
        L13:
            r103 = QrCodeMatrix.PixelType.DarkPixel;
            goto L14
        L15:
            r101 = r101 + 1;
            goto L3
        L16:
            int r104 = 0;
        L17:
            if (r104 >= 7) goto L25;
            int r105 = 0;
        L19:
            if (r105 >= 7) goto L24;
            if (r100.a(r104, r105) != QrCodeMatrix.PixelType.DarkPixel) goto L23;
            float r106 = r110 / 7;
            r112.addPath(this.f274288a.a(r106, com.github.alexzhirkevich.customqrgenerator.encoder.a.a(r100, r104, r105)), r104 * r106, r106 * r105);
        L23:
            r105 = r105 + 1;
            goto L19
        L24:
            r104 = r104 + 1;
            goto L17
        L25:
            return r112;
        }
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f274289a = null;

        static {
            f274289a = new b();
        }

        public b() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
        public final Path a(float r110, com.github.alexzhirkevich.customqrgenerator.style.c r111) {
            Intrinsics.checkNotNullParameter(r111, "neighbors");
            Path r112 = new Path();
            float r100 = r110 / 7.0f;
            r112.addRect(0.0f, 0.0f, r110, r100, Path.Direction.CW);
            r112.addRect(0.0f, 0.0f, r100, r110, Path.Direction.CW);
            float r101 = r110 - r100;
            r112.addRect(r101, 0.0f, r110, r110, Path.Direction.CW);
            r112.addRect(0.0f, r101, r110, r110, Path.Direction.CW);
            return r112;
        }
    }

    public static final class c implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f274290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f274291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f274292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f274293d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f274294e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f274295f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(Float.valueOf(this.f274290a), Float.valueOf(r101.f274290a)) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(Float.valueOf(this.f274291b), Float.valueOf(r101.f274291b)) == true) goto L15;
            return false;
        L15:
            if (this.f274292c == r101.f274292c) goto L18;
            return false;
        L18:
            if (this.f274293d == r101.f274293d) goto L21;
            return false;
        L21:
            if (this.f274294e == r101.f274294e) goto L24;
            return false;
        L24:
            if (this.f274295f == r101.f274295f) goto L26;
            return false;
        L26:
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v11, types: [int] */
        /* JADX WARN: Type inference failed for: r0v5, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7, types: [int] */
        /* JADX WARN: Type inference failed for: r0v9, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v13 */
        /* JADX WARN: Type inference failed for: r1v14 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        /* JADX WARN: Type inference failed for: r2v0 */
        /* JADX WARN: Type inference failed for: r2v1, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        public final int hashCode() {
            int r100 = ((Float.floatToIntBits(this.f274290a) * 31) + Float.floatToIntBits(this.f274291b)) * 31;
            boolean r101 = this.f274292c;
            ?? r102 = 1;
            ?? r103 = r101;
            if (r101 == false) goto L5;
            r103 = 1;
        L5:
            int r104 = (r100 + r103) * 31;
            boolean r105 = this.f274293d;
            ?? r106 = r105;
            if (r105 == false) goto L8;
            r106 = 1;
        L8:
            int r107 = (r104 + r106) * 31;
            boolean r108 = this.f274294e;
            ?? r109 = r108;
            if (r108 == false) goto L11;
            r109 = 1;
        L11:
            int r110 = (r107 + r109) * 31;
            boolean r111 = this.f274295f;
            if (r111 == true) goto L16;
            r102 = r111;
        L16:
            return r110 + r102;
        }

        public final String toString() {
            return "RoundCorners(corner=" + this.f274290a + ", width=" + this.f274291b + ", topLeft=" + this.f274292c + ", bottomLeft=" + this.f274293d + ", topRight=" + this.f274294e + ", bottomRight=" + this.f274295f + ')';
        }

        public c() {
            this.f274290a = 0.25f;
            this.f274291b = 1.0f;
            this.f274292c = true;
            this.f274293d = true;
            this.f274294e = true;
            this.f274295f = true;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
        public final Path a(float r210, com.github.alexzhirkevich.customqrgenerator.style.c r211) {
            Intrinsics.checkNotNullParameter(r211, "neighbors");
            float r100 = 0.0f;
            float r101 = (r210 / 7.0f) * RangesKt.coerceAtLeast(this.f274291b, 0.0f);
            float r102 = this.f274290a;
            float r103 = r102 * r210;
            float r104 = r102 * (r210 - (4 * r101));
            Path r105 = new Path();
            RectF r106 = new RectF(0.0f, 0.0f, r210, r210);
            float[] r110 = new float[8];
            boolean r111 = this.f274292c;
            if (r111 == false) goto L5;
            float r112 = r103;
        L6:
            r110[0] = r112;
            if (r111 == false) goto L9;
            float r113 = r103;
        L10:
            r110[1] = r113;
            boolean r114 = this.f274294e;
            if (r114 == false) goto L13;
            float r115 = r103;
        L14:
            r110[2] = r115;
            if (r114 == false) goto L17;
            float r116 = r103;
        L18:
            r110[3] = r116;
            boolean r117 = this.f274295f;
            if (r117 == false) goto L21;
            float r118 = r103;
        L22:
            r110[4] = r118;
            if (r117 == false) goto L25;
            float r119 = r103;
        L26:
            r110[5] = r119;
            boolean r120 = this.f274293d;
            if (r120 == false) goto L29;
            float r121 = r103;
        L30:
            r110[6] = r121;
            if (r120 == true) goto L34;
            r103 = 0.0f;
        L34:
            r110[7] = r103;
            r105.addRoundRect(r106, r110, Path.Direction.CW);
            Path r107 = new Path();
            float r108 = r210 - r101;
            RectF r109 = new RectF(r101, r101, r108, r108);
            float[] r122 = new float[8];
            boolean r123 = this.f274292c;
            if (r123 == false) goto L37;
            float r124 = r104;
        L38:
            r122[0] = r124;
            if (r123 == false) goto L41;
            float r125 = r104;
        L42:
            r122[1] = r125;
            boolean r126 = this.f274294e;
            if (r126 == false) goto L45;
            float r127 = r104;
        L46:
            r122[2] = r127;
            if (r126 == false) goto L49;
            float r128 = r104;
        L50:
            r122[3] = r128;
            boolean r129 = this.f274295f;
            if (r129 == false) goto L53;
            float r130 = r104;
        L54:
            r122[4] = r130;
            if (r129 == false) goto L57;
            float r131 = r104;
        L58:
            r122[5] = r131;
            boolean r132 = this.f274293d;
            if (r132 == false) goto L61;
            float r133 = r104;
        L62:
            r122[6] = r133;
            if (r132 == false) goto L65;
            r100 = r104;
        L65:
            r122[7] = r100;
            r107.addRoundRect(r109, r122, Path.Direction.CCW);
            Path r134 = new Path(r105);
            r134.op(r107, Path.Op.DIFFERENCE);
            return r134;
        L61:
            r133 = 0.0f;
            goto L62
        L57:
            r131 = 0.0f;
            goto L58
        L53:
            r130 = 0.0f;
            goto L54
        L49:
            r128 = 0.0f;
            goto L50
        L45:
            r127 = 0.0f;
            goto L46
        L41:
            r125 = 0.0f;
            goto L42
        L37:
            r124 = 0.0f;
            goto L38
        L29:
            r121 = 0.0f;
            goto L30
        L25:
            r119 = 0.0f;
            goto L26
        L21:
            r118 = 0.0f;
            goto L22
        L17:
            r116 = 0.0f;
            goto L18
        L13:
            r115 = 0.0f;
            goto L14
        L9:
            r113 = 0.0f;
            goto L10
        L5:
            r112 = 0.0f;
            goto L6
        }
    }
}
