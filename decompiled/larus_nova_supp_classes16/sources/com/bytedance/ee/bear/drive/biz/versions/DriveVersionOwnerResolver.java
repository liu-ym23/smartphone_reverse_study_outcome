package com.bytedance.ee.bear.drive.biz.versions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DriveVersionOwnerResolver {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/drive/biz/versions/DriveVersionOwnerResolver$UnknownReason;", "", "<init>", "(Ljava/lang/String;I)V", "TARGET_VERSION_MISSING", "CURRENT_USER_MISSING", "RESPONSE_MISSING", "RESPONSE_CODE_ERROR", "DATA_MISSING", "HISTORY_EMPTY", "VERSION_NOT_FOUND", "MULTIPLE_VERSION_RECORDS", "EDIT_USER_MISSING", "REQUEST_FAILED", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum UnknownReason extends Enum<UnknownReason> {
        public static final UnknownReason CURRENT_USER_MISSING = null;
        public static final UnknownReason DATA_MISSING = null;
        public static final UnknownReason EDIT_USER_MISSING = null;
        public static final UnknownReason HISTORY_EMPTY = null;
        public static final UnknownReason MULTIPLE_VERSION_RECORDS = null;
        public static final UnknownReason REQUEST_FAILED = null;
        public static final UnknownReason RESPONSE_CODE_ERROR = null;
        public static final UnknownReason RESPONSE_MISSING = null;
        public static final UnknownReason TARGET_VERSION_MISSING = null;
        public static final UnknownReason VERSION_NOT_FOUND = null;
        public static final /* synthetic */ UnknownReason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<UnknownReason> getEntries() {
            return b;
        }

        static {
            UnknownReason r0 = new UnknownReason("TARGET_VERSION_MISSING", 0);
            TARGET_VERSION_MISSING = r0;
            UnknownReason r1 = new UnknownReason("CURRENT_USER_MISSING", 1);
            CURRENT_USER_MISSING = r1;
            UnknownReason r3 = new UnknownReason("RESPONSE_MISSING", 2);
            RESPONSE_MISSING = r3;
            UnknownReason r5 = new UnknownReason("RESPONSE_CODE_ERROR", 3);
            RESPONSE_CODE_ERROR = r5;
            UnknownReason r7 = new UnknownReason("DATA_MISSING", 4);
            DATA_MISSING = r7;
            UnknownReason r9 = new UnknownReason("HISTORY_EMPTY", 5);
            HISTORY_EMPTY = r9;
            UnknownReason r11 = new UnknownReason("VERSION_NOT_FOUND", 6);
            VERSION_NOT_FOUND = r11;
            UnknownReason r13 = new UnknownReason("MULTIPLE_VERSION_RECORDS", 7);
            MULTIPLE_VERSION_RECORDS = r13;
            UnknownReason r16 = new UnknownReason("EDIT_USER_MISSING", 8);
            EDIT_USER_MISSING = r16;
            UnknownReason r14 = new UnknownReason("REQUEST_FAILED", 9);
            REQUEST_FAILED = r14;
            UnknownReason[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r16, r14};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static UnknownReason[] values() {
            return (UnknownReason[]) a.clone();
        }

        public static UnknownReason valueOf(String r1) {
            return (UnknownReason) r27.a.a(UnknownReason.class, r1);
        }

        public UnknownReason(String r1, int r2) {
            super(r1, r2);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.versions.DriveVersionOwnerResolver$a$a, reason: collision with other inner class name */
        public static final class C0158a extends a {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof C0158a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((C0158a) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Other(editUid=" + this.a + ')';
            }

            public C0158a(String r2) {
                Intrinsics.checkNotNullParameter(r2, "editUid");
                this.a = r2;
            }
        }

        public static final class b extends a {
            public final String a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Self(editUid=" + this.a + ')';
            }

            public b(String r2) {
                Intrinsics.checkNotNullParameter(r2, "editUid");
                this.a = r2;
            }
        }

        public static final class c extends a {
            public final UnknownReason a;

            public final boolean equals(Object r4) {
                if (this != r4) goto L6;
                return true;
            L6:
                if ((r4 instanceof c) == true) goto L9;
                return false;
            L9:
                if (this.a == ((c) r4).a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.a.hashCode();
            }

            public final String toString() {
                return "Unknown(reason=" + this.a + ')';
            }

            public c(UnknownReason r2) {
                Intrinsics.checkNotNullParameter(r2, "reason");
                this.a = r2;
            }
        }

        public a() {
        }
    }

    static {
    }
}
