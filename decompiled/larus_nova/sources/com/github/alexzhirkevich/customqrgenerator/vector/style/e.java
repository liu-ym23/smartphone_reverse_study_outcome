package com.github.alexzhirkevich.customqrgenerator.vector.style;

import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;

/* JADX INFO: loaded from: classes23.dex */
public interface e {

    public static final class a implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f274280a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f274280a == ((a) r100).f274280a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f274280a;
        }

        public final String toString() {
            return "Solid(color=" + this.f274280a + ')';
        }

        public a(int r100) {
            this.f274280a = r100;
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.e
        public final Paint a(float r100, float r101) {
            Paint r102 = new Paint();
            r102.setColor(this.f274280a);
            return r102;
        }
    }

    public static final class b implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f274281a = null;

        static {
            f274281a = new b();
        }

        public b() {
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.e
        public final Paint a(float r100, float r101) {
            Paint r102 = new Paint();
            r102.setColor(com.github.alexzhirkevich.customqrgenerator.style.g.a(0));
            r102.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST));
            return r102;
        }
    }

    public static final class c implements e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f274282b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f274283a;

        static {
            f274282b = new c();
        }

        @Override // com.github.alexzhirkevich.customqrgenerator.vector.style.e
        public final Paint a(float r100, float r101) {
            return this.f274283a.a(r100, r101);
        }

        public c() {
            this.f274283a = b.f274281a;
        }
    }

    Paint a(float r100, float r101);
}
