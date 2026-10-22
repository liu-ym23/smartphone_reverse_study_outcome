package com.ss.android.lark.appcontext.applifecycle;

import java.util.Objects;

/* JADX INFO: loaded from: classes34.dex */
public interface y {

    /* JADX INFO: loaded from: classes5.dex */
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f408858a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f408859b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f408860c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f408861d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f408862e;

        public a() {
            this(null, null, null, 0);
        }

        public final String toString() {
            return String.format("topProc:%s, topAct: %s, appFront: %s, procFront: %s", new Object[]{this.f408858a, this.f408859b, Boolean.valueOf(this.f408860c), Boolean.valueOf(this.f408861d)});
        }

        public final int hashCode() {
            return super.hashCode();
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == false) goto L12;
            a r101 = (a) r100;
            if (this.f408860c == r101.f408860c) goto L7;
            return false;
        L7:
            if (this.f408861d == r101.f408861d) goto L9;
            return false;
        L9:
            if (Objects.equals(this.f408859b, r101.f408859b) == false) goto L15;
            return true;
        L15:
            return false;
        L12:
            return false;
        }

        public a(String r100, String r101, String r102, long r103) {
            this.f408858a = r100;
            boolean r104 = true;
            if (r100 == null) goto L5;
            boolean r105 = true;
        L6:
            this.f408860c = r105;
            this.f408859b = r101;
            if (r102 != null) goto L9;
        L11:
            r104 = false;
        L12:
            this.f408861d = r104;
            this.f408862e = r103;
            return;
        L9:
            if (r102.equals(r100) == false) goto L11;
        L5:
            r105 = false;
            goto L6
        }

        public static a a(String r100, String r101, String r102, long r110) {
            return new a(r100, r101, r102, r110);
        }
    }

    void f(a r100, a r101);
}
