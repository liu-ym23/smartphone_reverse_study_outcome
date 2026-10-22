package com.larus.dora.obric.onboarding;

import android.graphics.Bitmap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class c2 {

    public static final class a extends c2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f340833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Bitmap f340834b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f340835c;

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
            if (this.f340833a == r101.f340833a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f340834b, r101.f340834b) == true) goto L15;
            return false;
        L15:
            if (this.f340835c == r101.f340835c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f340833a * 31;
            Bitmap r101 = this.f340834b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            long r104 = this.f340835c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "QueryAnswering(type=" + this.f340833a + ", data=" + this.f340834b + ", ts=" + this.f340835c + ')';
        }

        public final int getType() {
            return this.f340833a;
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
            this.f340833a = r100;
            this.f340834b = r101;
            this.f340835c = r103;
            return;
        L11:
            r103 = 0;
            goto L12
        }
    }

    public static final class b extends c2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f340836a = null;

        static {
            f340836a = new b();
        }

        public b() {
        }
    }

    public static final class c extends c2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f340837a = null;

        static {
            f340837a = new c();
        }

        public c() {
        }
    }

    public static final class d extends c2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f340838a = null;

        static {
            f340838a = new d();
        }

        public d() {
        }
    }

    public static final class e extends c2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f340839a = null;

        static {
            f340839a = new e();
        }

        public e() {
        }
    }

    public c2() {
    }
}
