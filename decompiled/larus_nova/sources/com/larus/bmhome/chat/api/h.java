package com.larus.bmhome.chat.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class h {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f297203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f297204b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f297203a, r101.f297203a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f297204b, r101.f297204b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f297203a.hashCode() * 31) + this.f297204b.hashCode();
        }

        public final String toString() {
            return "Filtered(conversationId=" + this.f297203a + ", reason=" + this.f297204b + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            Intrinsics.checkNotNullParameter("filtered_by_conversation_list_rule", "reason");
            this.f297203a = r100;
            this.f297204b = "filtered_by_conversation_list_rule";
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final wh8.a f297205a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f297205a, ((b) r100).f297205a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f297205a.hashCode();
        }

        public final String toString() {
            return "Hit(data=" + this.f297205a + ')';
        }

        public b(wh8.a r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f297205a = r100;
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f297206a = null;

        static {
            f297206a = new c();
        }

        public c() {
        }
    }

    public h() {
    }
}
