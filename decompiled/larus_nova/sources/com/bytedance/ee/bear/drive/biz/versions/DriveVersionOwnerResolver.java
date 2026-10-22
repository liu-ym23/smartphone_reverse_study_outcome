package com.bytedance.ee.bear.drive.biz.versions;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class DriveVersionOwnerResolver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f223955a = 0;

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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ UnknownReason[] f223956a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f223957b = null;

        public static EnumEntries<UnknownReason> getEntries() {
            return f223957b;
        }

        static {
            UnknownReason r100 = new UnknownReason("TARGET_VERSION_MISSING", 0);
            TARGET_VERSION_MISSING = r100;
            UnknownReason r101 = new UnknownReason("CURRENT_USER_MISSING", 1);
            CURRENT_USER_MISSING = r101;
            UnknownReason r102 = new UnknownReason("RESPONSE_MISSING", 2);
            RESPONSE_MISSING = r102;
            UnknownReason r103 = new UnknownReason("RESPONSE_CODE_ERROR", 3);
            RESPONSE_CODE_ERROR = r103;
            UnknownReason r104 = new UnknownReason("DATA_MISSING", 4);
            DATA_MISSING = r104;
            UnknownReason r105 = new UnknownReason("HISTORY_EMPTY", 5);
            HISTORY_EMPTY = r105;
            UnknownReason r110 = new UnknownReason("VERSION_NOT_FOUND", 6);
            VERSION_NOT_FOUND = r110;
            UnknownReason r111 = new UnknownReason("MULTIPLE_VERSION_RECORDS", 7);
            MULTIPLE_VERSION_RECORDS = r111;
            UnknownReason r112 = new UnknownReason("EDIT_USER_MISSING", 8);
            EDIT_USER_MISSING = r112;
            UnknownReason r113 = new UnknownReason("REQUEST_FAILED", 9);
            REQUEST_FAILED = r113;
            UnknownReason[] r114 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
            f223956a = r114;
            f223957b = EnumEntriesKt.enumEntries(r114);
        }

        public static UnknownReason[] values() {
            return (UnknownReason[]) f223956a.clone();
        }

        public static UnknownReason valueOf(String r100) {
            return (UnknownReason) r27.a.a(UnknownReason.class, r100);
        }

        public UnknownReason(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static abstract class a {

        /* JADX INFO: renamed from: com.bytedance.ee.bear.drive.biz.versions.DriveVersionOwnerResolver$a$a, reason: collision with other inner class name */
        public static final class C3214a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f223958a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C3214a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f223958a, ((C3214a) r100).f223958a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f223958a.hashCode();
            }

            public final String toString() {
                return "Other(editUid=" + this.f223958a + ')';
            }

            public C3214a(String r100) {
                Intrinsics.checkNotNullParameter(r100, "editUid");
                this.f223958a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f223959a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f223959a, ((b) r100).f223959a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f223959a.hashCode();
            }

            public final String toString() {
                return "Self(editUid=" + this.f223959a + ')';
            }

            public b(String r100) {
                Intrinsics.checkNotNullParameter(r100, "editUid");
                this.f223959a = r100;
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final UnknownReason f223960a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L9;
                return false;
            L9:
                if (this.f223960a == ((c) r100).f223960a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f223960a.hashCode();
            }

            public final String toString() {
                return "Unknown(reason=" + this.f223960a + ')';
            }

            public c(UnknownReason r100) {
                Intrinsics.checkNotNullParameter(r100, "reason");
                this.f223960a = r100;
            }
        }

        public a() {
        }
    }

    static {
    }
}
