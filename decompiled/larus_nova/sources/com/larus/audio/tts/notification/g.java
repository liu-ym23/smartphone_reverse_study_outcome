package com.larus.audio.tts.notification;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public interface g {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f289863a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f289864b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f289863a, r101.f289863a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f289864b, r101.f289864b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f289863a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f289864b;
            if (r104 == null) goto L11;
            r101 = r104.hashCode();
        L11:
            return r103 + r101;
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Metadata(title=" + this.f289863a + ", artist=" + this.f289864b + ')';
        }

        public a(String r100, String r101) {
            this.f289863a = r100;
            this.f289864b = r101;
        }
    }

    boolean a();

    void b();

    boolean c();

    void d();

    boolean e(boolean r100);

    boolean f(boolean r100);

    boolean g(a r100);

    void stopService();
}
