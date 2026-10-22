package com.larus.bmhome.chat.markdown.richtext;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class r {

    public static final class a extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f307232a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f307233b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f307232a, r101.f307232a) == true) goto L12;
            return false;
        L12:
            if (this.f307233b == r101.f307233b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f307232a.hashCode() * 31) + this.f307233b;
        }

        public final String toString() {
            return "Attachment(uri=" + this.f307232a + ", type=" + this.f307233b + ')';
        }

        public final int getType() {
            return this.f307233b;
        }

        public a(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            this.f307232a = r100;
            this.f307233b = r101;
        }
    }

    public static final class b extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f307234a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f307234a, ((b) r100).f307234a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f307234a.hashCode();
        }

        public final String toString() {
            return "Conversation(conversationId=" + this.f307234a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f307234a = r100;
        }
    }

    public static final class c extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f307235a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final MessageFileKind f307236b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f307235a, r101.f307235a) == true) goto L12;
            return false;
        L12:
            if (this.f307236b == r101.f307236b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f307235a.hashCode() * 31) + this.f307236b.hashCode();
        }

        public final String toString() {
            return "File(path=" + this.f307235a + ", kind=" + this.f307236b + ')';
        }

        public c(String r100, MessageFileKind r101) {
            Intrinsics.checkNotNullParameter(r100, "path");
            Intrinsics.checkNotNullParameter(r101, "kind");
            this.f307235a = r100;
            this.f307236b = r101;
        }
    }

    public static final class d extends r {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f307237a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f307238b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f307239c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f307237a == r101.f307237a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f307238b, r101.f307238b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f307239c, r101.f307239c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f307237a * 31;
            String r101 = this.f307238b;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f307239c;
            if (r105 == null) goto L11;
            r102 = r105.hashCode();
        L11:
            return r104 + r102;
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Skill(type=" + this.f307237a + ", id=" + this.f307238b + ", path=" + this.f307239c + ')';
        }

        public final int getType() {
            return this.f307237a;
        }

        public d(int r100, String r101, String r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = null;
        L8:
            this.f307237a = r100;
            this.f307238b = r101;
            this.f307239c = r102;
        }
    }

    public r() {
    }
}
