package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Path;
import com.github.alexzhirkevich.customqrgenerator.encoder.QrCodeMatrix;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public interface d extends m {

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final l f274275a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f274275a, ((a) r100).f274275a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f274275a.hashCode();
        }

        public final String toString() {
            return "AsPixelShape(pixelShape=" + this.f274275a + ')';
        }

        public a(l r100) {
            Intrinsics.checkNotNullParameter(r100, "pixelShape");
            this.f274275a = r100;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
        public final Path a(float r110, com.github.alexzhirkevich.customqrgenerator.style.c r111) {
            Intrinsics.checkNotNullParameter(r111, "neighbors");
            Path r112 = new Path();
            com.google.zxing.qrcode.encoder.b r100 = new com.google.zxing.qrcode.encoder.b(3, 3);
            byte[][] r101 = r100.f275996a;
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L5;
            Arrays.fill(r101[r103], (byte) 1);
            r103 = r103 + 1;
            goto L3
        L5:
            QrCodeMatrix r104 = com.github.alexzhirkevich.customqrgenerator.encoder.c.a(r100);
            int r105 = 0;
        L6:
            if (r105 >= 3) goto L11;
            int r106 = 0;
        L8:
            if (r106 >= 3) goto L10;
            float r107 = r110 / 3;
            r112.addPath(this.f274275a.a(r107, com.github.alexzhirkevich.customqrgenerator.encoder.a.a(r104, r105, r106)), r105 * r107, r107 * r106);
            r106 = r106 + 1;
            goto L8
        L10:
            r105 = r105 + 1;
            goto L6
        L11:
            return r112;
        }
    }

    public static final class b implements d, m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f274276a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ com.github.alexzhirkevich.customqrgenerator.vector.style.a f274277b;

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
        public final Path a(float r100, com.github.alexzhirkevich.customqrgenerator.style.c r101) {
            Intrinsics.checkNotNullParameter(r101, "neighbors");
            return this.f274277b.a(r100, r101);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(Float.valueOf(this.f274276a), Float.valueOf(((b) r100).f274276a)) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f274276a);
        }

        public final String toString() {
            return "Circle(size=" + this.f274276a + ')';
        }

        public b() {
            this.f274276a = 0.8f;
            this.f274277b = new com.github.alexzhirkevich.customqrgenerator.vector.style.a();
        }
    }

    public static final class c implements d, m {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f274278b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.github.alexzhirkevich.customqrgenerator.vector.style.b f274279a;

        static {
            f274278b = new c();
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.m
        public final Path a(float r100, com.github.alexzhirkevich.customqrgenerator.style.c r101) {
            Intrinsics.checkNotNullParameter(r101, "neighbors");
            return this.f274279a.a(r100, r101);
        }

        public c() {
            this.f274279a = com.github.alexzhirkevich.customqrgenerator.vector.style.b.f274271a;
        }
    }
}
