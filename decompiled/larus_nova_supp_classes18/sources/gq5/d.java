package gq5;

import com.bytedance.ee.bear.creationmenu.SelectIndex;
import com.bytedance.ee.bear.middleground.permission.permission.doc.DocUserPermission;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final Boolean e;
        public final String f;
        public final String g;
        public final boolean h;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (this.h == r6.h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            Boolean r11 = this.e;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.f;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.g;
            if (r17 == null) goto L26;
            r2 = r17.hashCode();
        L26:
            int r18 = (r16 + r2) * 31;
            if (this.h == false) goto L29;
            int r19 = 1231;
        L31:
            return r18 + r19;
        L29:
            r19 = 1237;
            goto L31
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportSpaceDocsMoreClickBean(click=" + this.a + ", target=" + this.b + ", containerId=" + this.c + ", pageToken=" + this.d + ", isShortcut=" + this.e + ", fileId=" + this.f + ", fileType=" + this.g + ", isOriginExternal=" + this.h + ')';
        }

        public a(String r2, String r3, String r4, String r5, Boolean r6, String r7, String r8, boolean r9) {
            Intrinsics.checkNotNullParameter(r2, "click");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public final Boolean c;
        public final String d;
        public final String e;
        public final Boolean f;
        public final String g;
        public final String h;
        public final String i;
        public final Boolean j;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Boolean r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.e;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Boolean r14 = this.f;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.g;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.h;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            String r23 = this.i;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            Boolean r26 = this.j;
            if (r26 == null) goto L39;
            r2 = r26.hashCode();
        L39:
            return r25 + r2;
        L33:
            r24 = r23.hashCode();
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportWikiDelClickBean(click=" + this.a + ", target=" + this.b + ", isFavorites=" + this.c + ", containerId=" + this.d + ", pageToken=" + this.e + ", isShortcut=" + this.f + ", fileId=" + this.g + ", fileType=" + this.h + ", deleteScope=" + this.i + ", isIncludeChildrenPage=" + this.j + ')';
        }

        public b(String r2, String r3, Boolean r4, String r5, String r6, Boolean r7, String r8, String r9, String r10, Boolean r11) {
            Intrinsics.checkNotNullParameter(r2, "click");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
        }
    }

    public static final class c {
        public final String a;
        public final String b;
        public final Boolean c;
        public final String d;
        public final String e;
        public final Boolean f;

        public c() {
            this(null, null, null, null, null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Boolean r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Boolean r16 = this.f;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportWikiDeleteConfirmBean(containerId=" + this.a + ", pageToken=" + this.b + ", isShortcut=" + this.c + ", fileId=" + this.d + ", fileType=" + this.e + ", isIncludeChildrenPage=" + this.f + ')';
        }

        public c(String r1, String r2, Boolean r3, String r4, String r5, Boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    /* JADX INFO: renamed from: gq5.d$d, reason: collision with other inner class name */
    public static final class C0238d {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final String e;
        public final String f;
        public final String g;
        public final String h;
        public final String i;
        public final String j;
        public final String k;
        public final String l;
        public final String m;
        public final String n;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0238d) == true) goto L8;
            return false;
        L8:
            C0238d r6 = (C0238d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L45;
            return false;
        L45:
            if (Intrinsics.areEqual(this.m, r6.m) == true) goto L48;
            return false;
        L48:
            if (Intrinsics.areEqual(this.n, r6.n) == true) goto L50;
            return false;
        L50:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.e;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.f;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.g;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.h;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            String r23 = this.i;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            String r26 = this.j;
            if (r26 != null) goto L37;
            int r27 = 0;
        L38:
            int r28 = (r25 + r27) * 31;
            String r29 = this.k;
            if (r29 != null) goto L41;
            int r30 = 0;
        L42:
            int r31 = (r28 + r30) * 31;
            String r32 = this.l;
            if (r32 != null) goto L45;
            int r33 = 0;
        L46:
            int r34 = (r31 + r33) * 31;
            String r35 = this.m;
            if (r35 != null) goto L49;
            int r36 = 0;
        L50:
            int r37 = (r34 + r36) * 31;
            String r38 = this.n;
            if (r38 == null) goto L55;
            r2 = r38.hashCode();
        L55:
            return r37 + r2;
        L49:
            r36 = r35.hashCode();
            goto L50
        L45:
            r33 = r32.hashCode();
            goto L46
        L41:
            r30 = r29.hashCode();
            goto L42
        L37:
            r27 = r26.hashCode();
            goto L38
        L33:
            r24 = r23.hashCode();
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportWikiLocSelectClickBean(click=" + this.a + ", target=" + this.b + ", viewTitle=" + this.c + ", targetSpaceId=" + this.d + ", containerId=" + this.e + ", pageToken=" + this.f + ", childrenFileType=" + this.g + ", childrenFileId=" + this.h + ", childrenPageToken=" + this.i + ", triggerLocation=" + this.j + ", targetLocation=" + this.k + ", targetFolderType=" + this.l + ", originalModule=" + this.m + ", targetModule=" + this.n + ')';
        }

        public C0238d(String r3, String r4, String r5, String r6, String r7, String r8, String r9, String r10, String r11, String r12, String r13, String r14) {
            Intrinsics.checkNotNullParameter("confirm", "click");
            this.a = "confirm";
            this.b = "ccm_docs_page_view";
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
            this.j = r10;
            this.k = r11;
            this.l = r12;
            this.m = r13;
            this.n = r14;
        }
    }

    public static final class e {
        public final String a;
        public final String b;
        public final Boolean c;
        public final String d;
        public final String e;
        public final Boolean f;

        public e() {
            this(null, null, null, null, null, null);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof e) == true) goto L8;
            return false;
        L8:
            e r6 = (e) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Boolean r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            Boolean r16 = this.f;
            if (r16 == null) goto L27;
            r1 = r16.hashCode();
        L27:
            return r15 + r1;
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportWikiTreeAddBean(containerId=" + this.a + ", pageToken=" + this.b + ", isShortcut=" + this.c + ", fileId=" + this.d + ", fileType=" + this.e + ", isSelfWiki=" + this.f + ')';
        }

        public e(String r1, String r2, Boolean r3, String r4, String r5, Boolean r6) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
        }
    }

    public static final class f {
        public final String a;
        public final String b;
        public final String c;
        public final String d;
        public final Boolean e;
        public final String f;
        public final String g;
        public final Boolean h;
        public final String i;
        public final String j;
        public final Boolean k;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof f) == true) goto L8;
            return false;
        L8:
            f r6 = (f) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L41;
            return false;
        L41:
            return true;
        }

        public final int hashCode() {
            int r0 = ((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31;
            String r1 = this.d;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Boolean r5 = this.e;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.f;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.g;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Boolean r14 = this.h;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.i;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.j;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            Boolean r23 = this.k;
            if (r23 == null) goto L35;
            r2 = r23.hashCode();
        L35:
            return r22 + r2;
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportWikiTreeAddClickBean(click=" + this.a + ", target=" + this.b + ", triggerLocation=" + this.c + ", childrenFileType=" + this.d + ", isFavorites=" + this.e + ", containerId=" + this.f + ", pageToken=" + this.g + ", isShortcut=" + this.h + ", fileId=" + this.i + ", fileType=" + this.j + ", isSelfWiki=" + this.k + ')';
        }

        public f(String r2, String r3, String r4, String r5, Boolean r6, String r7, String r8, Boolean r9, String r10, String r11, Boolean r12) {
            Intrinsics.checkNotNullParameter(r2, "click");
            Intrinsics.checkNotNullParameter(r3, "target");
            Intrinsics.checkNotNullParameter(r4, "triggerLocation");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
        }
    }

    public static final class g {
        public final String a;
        public final String b;
        public final Boolean c;
        public final String d;
        public final String e;
        public final Boolean f;
        public final String g;
        public final String h;
        public final Integer i;
        public final Boolean j;
        public final Boolean k;
        public final String l;

        public g(Boolean r3, String r4) {
            Intrinsics.checkNotNullParameter("slide", "click");
            this("slide", r3, r4, 4080);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof g) == true) goto L8;
            return false;
        L8:
            g r6 = (g) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.i, r6.i) == true) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L39;
            return false;
        L39:
            if (Intrinsics.areEqual(this.k, r6.k) == true) goto L42;
            return false;
        L42:
            if (Intrinsics.areEqual(this.l, r6.l) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Boolean r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.e;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Boolean r14 = this.f;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.g;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.h;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            Integer r23 = this.i;
            if (r23 != null) goto L33;
            int r24 = 0;
        L34:
            int r25 = (r22 + r24) * 31;
            Boolean r26 = this.j;
            if (r26 != null) goto L37;
            int r27 = 0;
        L38:
            int r28 = (r25 + r27) * 31;
            Boolean r29 = this.k;
            if (r29 == null) goto L43;
            r2 = r29.hashCode();
        L43:
            return ((r28 + r2) * 31) + this.l.hashCode();
        L37:
            r27 = r26.hashCode();
            goto L38
        L33:
            r24 = r23.hashCode();
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportWikiTreeClickBean(click=" + this.a + ", target=" + this.b + ", isFavorites=" + this.c + ", containerId=" + this.d + ", pageToken=" + this.e + ", isShortcut=" + this.f + ", fileId=" + this.g + ", fileType=" + this.h + ", isFromShareLink=" + this.i + ", isSelfWiki=" + this.j + ", isFirstNode=" + this.k + ", location=" + this.l + ')';
        }

        public /* synthetic */ g(String r17, Boolean r18, String r19, int r20) {
            String r2 = null;
            if ((r20 & 2) == 0) goto L5;
            String r5 = null;
        L7:
            if ((r20 & 4) == 0) goto L9;
            Boolean r6 = null;
        L11:
            if ((r20 & 8) == 0) goto L13;
            String r7 = null;
        L15:
            if ((r20 & DocUserPermission.USER_PREVIEW) == 0) goto L17;
            r2 = DocumentType.WIKI_NAME;
        L17:
            this(r17, r5, r6, r7, null, null, null, null, null, null, null, r2);
            return;
        L13:
            r7 = r19;
            goto L15
        L9:
            r6 = r18;
            goto L11
        L5:
            r5 = "none";
            goto L7
        }

        public g(String r2, String r3, Boolean r4, String r5, String r6, Boolean r7, String r8, String r9, Integer r10, Boolean r11, Boolean r12, String r13) {
            Intrinsics.checkNotNullParameter(r2, "click");
            Intrinsics.checkNotNullParameter(r13, "location");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
            this.k = r12;
            this.l = r13;
        }
    }

    public static final class h {
        public final String a;
        public final String b;
        public final Boolean c;
        public final String d;
        public final String e;
        public final boolean f;
        public final Boolean g;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof h) == true) goto L8;
            return false;
        L8:
            h r6 = (h) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (this.f == r6.f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
            return false;
        L29:
            return true;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            Boolean r7 = this.c;
            if (r7 != null) goto L13;
            int r8 = 0;
        L14:
            int r9 = (r6 + r8) * 31;
            String r10 = this.d;
            if (r10 != null) goto L17;
            int r11 = 0;
        L18:
            int r12 = (r9 + r11) * 31;
            String r13 = this.e;
            if (r13 != null) goto L21;
            int r14 = 0;
        L22:
            int r15 = (r12 + r14) * 31;
            if (this.f == false) goto L25;
            int r16 = 1231;
        L26:
            int r17 = (r15 + r16) * 31;
            Boolean r18 = this.g;
            if (r18 == null) goto L31;
            r1 = r18.hashCode();
        L31:
            return r17 + r1;
        L25:
            r16 = 1237;
            goto L26
        L21:
            r14 = r13.hashCode();
            goto L22
        L17:
            r11 = r10.hashCode();
            goto L18
        L13:
            r8 = r7.hashCode();
            goto L14
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportWikiTreeMoreBean(containerId=" + this.a + ", pageToken=" + this.b + ", isShortcut=" + this.c + ", fileId=" + this.d + ", fileType=" + this.e + ", isOriginExternal=" + this.f + ", isSelfwiki=" + this.g + ')';
        }

        public h(String r1, String r2, Boolean r3, String r4, String r5, boolean r6, Boolean r7) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
        }
    }

    public static final class i {
        public final String a;
        public final String b;
        public final Boolean c;
        public final String d;
        public final String e;
        public final Boolean f;
        public final String g;
        public final String h;
        public final boolean i;
        public final Boolean j;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof i) == true) goto L8;
            return false;
        L8:
            i r6 = (i) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.g, r6.g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.h, r6.h) == true) goto L33;
            return false;
        L33:
            if (this.i == r6.i) goto L36;
            return false;
        L36:
            if (Intrinsics.areEqual(this.j, r6.j) == true) goto L38;
            return false;
        L38:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            Boolean r5 = this.c;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.d;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.e;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            Boolean r14 = this.f;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            String r17 = this.g;
            if (r17 != null) goto L25;
            int r18 = 0;
        L26:
            int r19 = (r16 + r18) * 31;
            String r20 = this.h;
            if (r20 != null) goto L29;
            int r21 = 0;
        L30:
            int r22 = (r19 + r21) * 31;
            if (this.i == false) goto L33;
            int r23 = 1231;
        L34:
            int r24 = (r22 + r23) * 31;
            Boolean r25 = this.j;
            if (r25 == null) goto L39;
            r2 = r25.hashCode();
        L39:
            return r24 + r2;
        L33:
            r23 = 1237;
            goto L34
        L29:
            r21 = r20.hashCode();
            goto L30
        L25:
            r18 = r17.hashCode();
            goto L26
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "ReportWikiTreeMoreClickBean(click=" + this.a + ", target=" + this.b + ", isFavorites=" + this.c + ", containerId=" + this.d + ", pageToken=" + this.e + ", isShortcut=" + this.f + ", fileId=" + this.g + ", fileType=" + this.h + ", isOriginExternal=" + this.i + ", isSelfWiki=" + this.j + ')';
        }

        public i(String r2, String r3, Boolean r4, String r5, String r6, Boolean r7, String r8, String r9, boolean r10, Boolean r11) {
            Intrinsics.checkNotNullParameter(r2, "click");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r7;
            this.g = r8;
            this.h = r9;
            this.i = r10;
            this.j = r11;
        }
    }

    public static final class j {
        static {
        }

        @JvmStatic
        public static final String a(int r2) {
            SelectIndex.Companion.getClass();
            SelectIndex r3 = SelectIndex.a.a(r2);
            int r0 = r3.getDocumentType();
            if (r0 != 2) goto L5;
            return DocumentType.DOC_NAME;
        L5:
            if (r0 != 3) goto L7;
            return DocumentType.SHEET_NAME;
        L7:
            if (r0 == 8) goto L25;
            if (r0 != 22) goto L11;
            return DocumentType.DOCX_NAME;
        L11:
            if (r0 != 111) goto L13;
            return DocumentType.WIKI_FOLDER_NAME;
        L13:
            if (r0 != 11) goto L15;
            return DocumentType.MINDNOTE_NAME;
        L15:
            if (r0 == 12) goto L18;
            return "";
        L18:
            if (r3 != SelectIndex.MEDIA) goto L20;
            return "upload_picture";
        L20:
            return "upload_file";
        L25:
            if (r3 != SelectIndex.SURVEY) goto L27;
            return "new_form_templates";
        L27:
            return DocumentType.BITABLE_NAME;
        }

        @JvmStatic
        public static final String b(int r1, int r2) {
            boolean r0 = true;
            if (r1 != 1) goto L5;
            SelectIndex.Companion.getClass();
            if (r2 != SelectIndex.MEDIA.ordinal()) goto L17;
        L20:
            if (r0 == false) goto L22;
            return "upload_file_to";
        L22:
            return "create_file";
        L17:
            if (r2 == SelectIndex.FILE.ordinal()) goto L20;
            r0 = false;
            goto L20
        L5:
            if (r1 != 2) goto L7;
            return "move_to";
        L7:
            if (r1 != 3) goto L9;
            return "shortcut_to";
        L9:
            if (r1 == 4) goto L11;
            return "";
        L11:
            return "make_a_copy_to";
        }
    }

    static {
    }

    public d() {
    }

    @JvmStatic
    public static final void d(a r10) {
        Intrinsics.checkNotNullParameter(r10, "bean");
        JSONObject r0 = new JSONObject();
        gq5.e.b(r0, "click", r10.a);
        gq5.e.b(r0, "target", r10.b);
        if (r10.h == false) goto L5;
        String r1 = "space";
    L6:
        r0.put("original_docs_container", r1);
        if (Intrinsics.areEqual(r10.e, Boolean.TRUE) == false) goto L9;
        String r2 = "true";
    L10:
        r0.put("is_shortcut", r2);
        a(r0, r10.c, r10.d, r10.e, r10.f, r10.g, null, null, 96);
        gq5.e.c("ccm_space_docs_more_menu_click", r0);
        return;
    L9:
        r2 = "false";
        goto L10
    L5:
        r1 = DocumentType.WIKI_NAME;
        goto L6
    }

    @JvmStatic
    public static final void g(Boolean r10) {
        JSONObject r9 = new JSONObject();
        if (r10 == null) goto L5;
        String r11 = r10.toString();
    L6:
        gq5.e.b(r9, "is_category_show", r11);
        a(r9, null, null, null, null, null, "wiki_home", null, 95);
        gq5.e.c("ccm_wiki_all_space_view", r9);
        return;
    L5:
        r11 = null;
        goto L6
    }

    @JvmStatic
    public static final void h(b r10) {
        Intrinsics.checkNotNullParameter(r10, "bean");
        JSONObject r0 = new JSONObject();
        gq5.e.b(r0, "click", r10.a);
        gq5.e.b(r0, "target", r10.b);
        gq5.e.b(r0, "is_success", Boolean.TRUE);
        Boolean r1 = r10.c;
        String r2 = null;
        if (r1 == null) goto L5;
        String r3 = r1.toString();
    L6:
        gq5.e.b(r0, "is_favorites", r3);
        gq5.e.b(r0, "delete_scope", r10.i);
        Boolean r4 = r10.j;
        if (r4 == null) goto L9;
        r2 = r4.toString();
    L9:
        gq5.e.b(r0, "is_include_children_page", r2);
        a(r0, r10.d, r10.e, r10.f, r10.g, r10.h, null, null, 96);
        gq5.e.c("ccm_wiki_delete_confirm_click", r0);
        return;
    L5:
        r3 = null;
        goto L6
    }

    @JvmStatic
    public static final void i(C0238d r10) {
        Intrinsics.checkNotNullParameter(r10, "bean");
        JSONObject r0 = new JSONObject();
        gq5.e.b(r0, "click", r10.a);
        gq5.e.b(r0, "target", r10.b);
        gq5.e.b(r0, "view_title", r10.c);
        gq5.e.b(r0, "target_space_id", gq5.e.a(r10.d));
        gq5.e.b(r0, "children_file_type", r10.g);
        gq5.e.b(r0, "trigger_location", r10.j);
        gq5.e.b(r0, "target_folder_type", r10.l);
        gq5.e.b(r0, "target_location", r10.k);
        gq5.e.b(r0, "children_file_id", gq5.e.a(r10.h));
        gq5.e.b(r0, "children_page_token", gq5.e.a(r10.i));
        gq5.e.b(r0, "original_module", r10.m);
        gq5.e.b(r0, "target_module", r10.n);
        a(r0, r10.e, r10.f, null, null, null, null, null, 124);
        gq5.e.c("ccm_wiki_file_location_select_click", r0);
    }

    @JvmStatic
    public static final void m(String r10) {
        JSONObject r9 = new JSONObject();
        gq5.e.b(r9, "view_title", "move_to");
        a(r9, r10, null, null, null, null, null, null, 126);
        gq5.e.c("ccm_wiki_permission_change_view", r9);
    }

    @JvmStatic
    public static final void n(g r10) {
        Intrinsics.checkNotNullParameter(r10, "bean");
        JSONObject r0 = new JSONObject();
        gq5.e.b(r0, "click", r10.a);
        gq5.e.b(r0, "target", r10.b);
        Boolean r1 = r10.c;
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        gq5.e.b(r0, "is_favorites", r2);
        Integer r3 = r10.i;
        if (r3 != null) goto L10;
    L12:
        gq5.e.b(r0, "is_first_node", String.valueOf(r10.k));
        gq5.e.b(r0, "trigger_location", r10.l);
        a(r0, r10.d, r10.e, r10.f, r10.g, r10.h, null, r10.j, 32);
        gq5.e.c("ccm_wiki_tree_click", r0);
        return;
    L10:
        if (r3.intValue() != 1) goto L12;
        gq5.e.b(r0, "is_from_share_link", "true");
        goto L12
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final void o(i r10) {
        Intrinsics.checkNotNullParameter(r10, "bean");
        JSONObject r0 = new JSONObject();
        gq5.e.b(r0, "click", r10.a);
        gq5.e.b(r0, "target", r10.b);
        Boolean r1 = r10.c;
        if (r1 == null) goto L5;
        String r2 = r1.toString();
    L6:
        gq5.e.b(r0, "is_favorites", r2);
        if (r10.i == false) goto L9;
        String r3 = "space";
    L10:
        r0.put("original_docs_container", r3);
        a(r0, r10.d, r10.e, r10.f, r10.g, r10.h, null, r10.j, 32);
        gq5.e.c("ccm_wiki_tree_more_click", r0);
        return;
    L9:
        r3 = DocumentType.WIKI_NAME;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    @JvmStatic
    public static final void j(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "view_title");
        JSONObject r10 = new JSONObject();
        gq5.e.b(r10, "view_title", r11);
        a(r10, r12, null, null, null, null, null, null, 126);
        gq5.e.c("ccm_wiki_file_location_select_view", r10);
    }

    @JvmStatic
    public static final void k(String r12, String r13) {
        Intrinsics.checkNotNullParameter(r12, "click");
        Intrinsics.checkNotNullParameter(r13, "target");
        JSONObject r11 = new JSONObject();
        gq5.e.b(r11, "click", r12);
        gq5.e.b(r11, "target", r13);
        a(r11, null, null, null, null, null, "wiki_home", null, 95);
        gq5.e.c("ccm_wiki_home_click", r11);
    }

    @JvmStatic
    public static final void l(String r13, String r14) {
        Intrinsics.checkNotNullParameter(r13, "click");
        Intrinsics.checkNotNullParameter("none", "target");
        JSONObject r12 = new JSONObject();
        gq5.e.b(r12, "view_title", "move_to");
        gq5.e.b(r12, "click", r13);
        gq5.e.b(r12, "target", "none");
        gq5.e.b(r12, "is_success", "true");
        a(r12, r14, null, null, null, null, null, null, 126);
        gq5.e.c("ccm_wiki_permission_change_click", r12);
    }

    @JvmStatic
    public static final void b(String r11, String r12, String r13, String r14) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        JSONObject r10 = new JSONObject();
        r10.put("click", "docs_view");
        r10.put("view_title", "shortcut_to");
        a(r10, r11, r12, Boolean.TRUE, r13, r14, null, null, 96);
        r0.u("ccm_wiki_docs_move_result_toast_click", r10);
    }

    @JvmStatic
    public static final void c(String r11, String r12, String r13, String r14) {
        com.bytedance.ee.bear.contract.d r0 = (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6);
        JSONObject r10 = new JSONObject();
        r10.put("is_success", "true");
        r10.put("view_title", "shortcut_to");
        a(r10, r11, r12, Boolean.TRUE, r13, r14, null, null, 96);
        r0.u("ccm_wiki_docs_move_result_toast_view", r10);
    }

    @JvmStatic
    public static final void e(String r12, String r13, Boolean r14, String r15) {
        Intrinsics.checkNotNullParameter(r12, "click");
        Intrinsics.checkNotNullParameter(r13, "target");
        JSONObject r11 = new JSONObject();
        gq5.e.b(r11, "click", r12);
        gq5.e.b(r11, "target", r13);
        if (r14 == null) goto L5;
        String r16 = r14.toString();
    L6:
        gq5.e.b(r11, "is_category_show", r16);
        gq5.e.b(r11, "category_id", r15);
        a(r11, null, null, null, null, null, "wiki_home", null, 95);
        gq5.e.c("ccm_wiki_all_space_click", r11);
        return;
    L5:
        r16 = null;
        goto L6
    }

    public static /* synthetic */ void f(String r1, String r2, Boolean r3, int r4) {
        if ((r4 & 4) == 0) goto L5;
        r3 = null;
    L5:
        e(r1, r2, r3, null);
    }

    public static void p(String r11, String r12, Integer r13, boolean r14, int r15) {
        if ((r15 & 1) == 0) goto L5;
        String r3 = null;
    L7:
        if ((r15 & 2) == 0) goto L9;
        String r4 = null;
    L11:
        if ((r15 & 4) == 0) goto L14;
        r13 = null;
    L14:
        if ((r15 & 8) == 0) goto L16;
        r14 = false;
    L16:
        JSONObject r16 = new JSONObject();
        a(r16, r3, r4, null, null, null, null, Boolean.valueOf(r14), 60);
        if (r13 != null) goto L20;
    L22:
        gq5.e.c("ccm_wiki_tree_view", r16);
        return;
    L20:
        if (r13.intValue() != 1) goto L22;
        gq5.e.b(r16, "is_from_share_link", "true");
        goto L22
    L9:
        r4 = r12;
        goto L11
    L5:
        r3 = r11;
        goto L7
    }

    public static void a(JSONObject r3, String r4, String r5, Boolean r6, String r7, String r8, String r9, Boolean r10, int r11) {
        String r1 = null;
        if ((r11 & 1) == 0) goto L6;
        r4 = null;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r8 = null;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r9 = DocumentType.WIKI_NAME;
    L21:
        if ((r11 & 64) == 0) goto L23;
        r10 = null;
    L23:
        gq5.e.b(r3, "container_id", gq5.e.a(r4));
        gq5.e.b(r3, "container_type", DocumentType.WIKI_NAME);
        gq5.e.b(r3, "page_token", gq5.e.a(r5));
        if (r6 == null) goto L26;
        String r12 = r6.toString();
    L27:
        gq5.e.b(r3, "is_shortcut", r12);
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L30;
        String r13 = gq5.e.a(r5);
    L31:
        gq5.e.b(r3, "shortcut_id", r13);
        if (r10 == null) goto L34;
        r1 = r10.toString();
    L34:
        gq5.e.b(r3, "is_self_wiki", r1);
        gq5.e.b(r3, "file_id", gq5.e.a(r7));
        gq5.e.b(r3, "file_type", r8);
        gq5.e.b(r3, "app_form", "null");
        gq5.e.b(r3, "module", r9);
        gq5.e.b(r3, "sub_module", "null");
        if (qc5.a.h() == false) goto L37;
        String r14 = "new_format";
    L38:
        gq5.e.b(r3, "space_version", r14);
        return;
    L37:
        r14 = "original";
        goto L38
    L30:
        r13 = null;
        goto L31
    L26:
        r12 = null;
        goto L27
    }
}
