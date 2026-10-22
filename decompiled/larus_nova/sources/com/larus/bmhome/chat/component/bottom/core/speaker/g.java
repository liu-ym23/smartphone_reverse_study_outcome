package com.larus.bmhome.chat.component.bottom.core.speaker;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class g {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f299419a = null;

        static {
            f299419a = new a();
        }

        public a() {
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f299420a = null;

        static {
            f299420a = new b();
        }

        public b() {
        }
    }

    public static final class c extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f299421a = null;

        static {
            f299421a = new c();
        }

        public c() {
        }
    }

    public static final class d extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f299422a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f299422a, ((d) r100).f299422a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f299422a.hashCode();
        }

        public final String toString() {
            return "StreamResult(text=" + this.f299422a + ')';
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f299422a = r100;
        }
    }

    public static final class e extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f299423a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f299424b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f299425c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f299423a, r101.f299423a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f299424b, r101.f299424b) == true) goto L15;
            return false;
        L15:
            if (this.f299425c == r101.f299425c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f299423a.hashCode() * 31;
            String r101 = this.f299424b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f299425c == false) goto L9;
            int r104 = 1231;
        L11:
            return r103 + r104;
        L9:
            r104 = 1237;
            goto L11
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Success(text=" + this.f299423a + ", asrLogId=" + this.f299424b + ", backfilled=" + this.f299425c + ')';
        }

        public e(String r100, String r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f299423a = r100;
            this.f299424b = r101;
            this.f299425c = r102;
        }

        public /* synthetic */ e(String r100, String r101, int r102) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101, false);
        }
    }

    public g() {
    }
}
