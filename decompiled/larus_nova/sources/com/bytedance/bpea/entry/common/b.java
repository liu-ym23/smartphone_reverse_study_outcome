package com.bytedance.bpea.entry.common;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public interface b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f202196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f202197b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (this.f202196a == r101.f202196a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f202197b, r101.f202197b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r100 = this.f202196a * 31;
            String r101 = this.f202197b;
            if (r101 == null) goto L5;
            int r102 = r101.hashCode();
        L7:
            return r100 + r102;
        L5:
            r102 = 0;
            goto L7
        }

        public final String toString() {
            return "ApiControlResult(resultCode=" + this.f202196a + ", msg=" + this.f202197b + ")";
        }

        public final boolean a() {
            if (this.f202196a == 0) goto L5;
            return true;
        L5:
            return false;
        }

        public a(String r100) {
            this.f202196a = 0;
            this.f202197b = r100;
        }
    }

    a a();

    a b();

    void c();
}
