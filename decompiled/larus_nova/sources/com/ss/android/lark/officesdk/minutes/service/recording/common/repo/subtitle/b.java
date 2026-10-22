package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface b {

    public static final class a {
        public static String a(b r100) {
            if (Intrinsics.areEqual(r100, c.f435199a) == false) goto L6;
            return "none";
        L6:
            if ((r100 instanceof C5190b) == false) goto L9;
            StringBuilder r101 = new StringBuilder("key:");
            C5190b r102 = (C5190b) r100;
            r101.append(r102.f435197a);
            r101.append(':');
            r101.append(r102.f435198b);
            return r101.toString();
        L9:
            if ((r100 instanceof d) == false) goto L12;
            return "url:" + ((d) r100).f435200a;
        L12:
            if ((r100 instanceof e) == false) goto L16;
            return "fallback:" + ((e) r100).f435201a;
        L16:
            throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b$b, reason: collision with other inner class name */
    public static final class C5190b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f435197a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f435198b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5190b) == true) goto L8;
            return false;
        L8:
            C5190b r101 = (C5190b) r100;
            if (Intrinsics.areEqual(this.f435197a, r101.f435197a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f435198b, r101.f435198b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f435197a.hashCode() * 31) + this.f435198b.hashCode();
        }

        public final String toString() {
            return "Key(key=" + this.f435197a + ", userId=" + this.f435198b + ')';
        }

        public C5190b() {
            this("", "");
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b
        public final String a() {
            return a.a(this);
        }

        public C5190b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "userId");
            this.f435197a = r100;
            this.f435198b = r101;
        }
    }

    public static final class c implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f435199a = null;

        static {
            f435199a = new c();
        }

        public c() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            c r101 = (c) r100;
            return true;
        }

        public final int hashCode() {
            return -1489531885;
        }

        public final String toString() {
            return "None";
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b
        public final String a() {
            return a.a(this);
        }
    }

    public static final class d implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f435200a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f435200a, ((d) r100).f435200a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f435200a.hashCode();
        }

        public final String toString() {
            return "Url(url=" + this.f435200a + ')';
        }

        public d() {
            this("");
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b
        public final String a() {
            return a.a(this);
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f435200a = r100;
        }
    }

    public static final class e implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f435201a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f435201a, ((e) r100).f435201a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f435201a.hashCode();
        }

        public final String toString() {
            return "UserIdFallback(userId=" + this.f435201a + ')';
        }

        public e() {
            this("");
        }

        @Override // com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.b
        public final String a() {
            return a.a(this);
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "userId");
            this.f435201a = r100;
        }
    }

    String a();
}
