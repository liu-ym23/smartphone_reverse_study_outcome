package com.larus.dora.impl.onboarding.g.v2.viewmodel;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class a0 {

    public static final class a extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f336794a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bitmap f336795b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f336796c;

        public a() {
            this(0, null, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f336794a == r101.f336794a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f336795b, r101.f336795b) == true) goto L15;
            return false;
        L15:
            if (this.f336796c == r101.f336796c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f336794a * 31;
            Bitmap r101 = this.f336795b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            long r104 = this.f336796c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "QueryAnswering(type=" + this.f336794a + ", data=" + this.f336795b + ", ts=" + this.f336796c + ')';
        }

        public final int getType() {
            return this.f336794a;
        }

        public a(int r100, Bitmap r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r102 & 2) == 0) goto L9;
            r101 = null;
        L9:
            if ((r102 & 4) == 0) goto L11;
            long r103 = System.currentTimeMillis();
        L12:
            this.f336794a = r100;
            this.f336795b = r101;
            this.f336796c = r103;
            return;
        L11:
            r103 = 0;
            goto L12
        }
    }

    public static final class b extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f336797a = null;

        static {
            f336797a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f336798a = null;

        static {
            f336798a = new c();
        }

        public c() {
        }
    }

    public static final class d extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f336799a = null;

        static {
            f336799a = new d();
        }

        public d() {
        }
    }

    public static final class e extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f336800a = null;

        static {
            f336800a = new e();
        }

        public e() {
        }
    }

    public a0() {
    }
}
