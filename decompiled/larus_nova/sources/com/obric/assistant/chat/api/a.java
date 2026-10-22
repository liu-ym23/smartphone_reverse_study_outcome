package com.obric.assistant.chat.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface a {

    /* JADX INFO: renamed from: com.obric.assistant.chat.api.a$a, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes32.dex */
    public static final class C4595a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f386610a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f386611b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Integer f386612c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Integer f386613d;

        public C4595a() {
            this("", "", 0, 0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4595a) == true) goto L8;
            return false;
        L8:
            C4595a r101 = (C4595a) r100;
            if (Intrinsics.areEqual(this.f386610a, r101.f386610a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f386611b, r101.f386611b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f386612c, r101.f386612c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f386613d, r101.f386613d) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f386610a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f386611b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Integer r107 = this.f386612c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            Integer r110 = this.f386613d;
            if (r110 == null) goto L19;
            r101 = r110.hashCode();
        L19:
            return r109 + r101;
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "ScreenPicInfo(tosKey=" + this.f386610a + ", resourceId=" + this.f386611b + ", width=" + this.f386612c + ", height=" + this.f386613d + ')';
        }

        public C4595a(String r100, String r101, Integer r102, Integer r103) {
            this.f386610a = r100;
            this.f386611b = r101;
            this.f386612c = r102;
            this.f386613d = r103;
        }
    }

    void a(String r100);
}
