package com.larus.office.card.minutes.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361504a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f361505a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f361506b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f361507c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f361508d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f361509e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f361505a, r101.f361505a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f361506b, r101.f361506b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f361507c, r101.f361507c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f361508d, r101.f361508d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f361509e, r101.f361509e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f361505a.hashCode() * 31) + this.f361506b.hashCode()) * 31) + this.f361507c.hashCode()) * 31) + this.f361508d.hashCode()) * 31) + this.f361509e.hashCode();
        }

        public final String toString() {
            return "ReportContext(conversationId=" + this.f361505a + ", messageId=" + this.f361506b + ", replyMessageId=" + this.f361507c + ", recordId=" + this.f361508d + ", errorMsg=" + this.f361509e + ')';
        }

        public a(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r101, "messageId");
            Intrinsics.checkNotNullParameter(r102, "replyMessageId");
            Intrinsics.checkNotNullParameter(r103, "recordId");
            Intrinsics.checkNotNullParameter(r104, "errorMsg");
            this.f361505a = r100;
            this.f361506b = r101;
            this.f361507c = r102;
            this.f361508d = r103;
            this.f361509e = r104;
        }
    }

    static {
    }
}
