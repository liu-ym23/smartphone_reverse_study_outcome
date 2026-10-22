package com.larus.bmhome.interactionpanel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class n {

    public static final class a extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f312386a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f312386a, ((a) r100).f312386a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f312386a.hashCode();
        }

        public final String toString() {
            return "MainConversation(conversationId=" + this.f312386a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f312386a = r100;
        }
    }

    public static final class b extends n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f312387a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f312388b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f312387a, r101.f312387a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f312388b, r101.f312388b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f312387a.hashCode() * 31) + this.f312388b.hashCode();
        }

        public final String toString() {
            return "ThreadOrganizer(conversationId=" + this.f312387a + ", threadId=" + this.f312388b + ')';
        }

        public b(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter(r101, "threadId");
            this.f312387a = r100;
            this.f312388b = r101;
        }
    }

    public n() {
    }
}
