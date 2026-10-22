package com.larus.office.plugins.offline;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes30.dex */
public final class OfficeOfflineDocCreateCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f363057a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/office/plugins/offline/OfficeOfflineDocCreateCoordinator$CreateDocumentStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_STARTED", "WAITING_CALLBACK", "SUCCEEDED", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CreateDocumentStatus extends Enum<CreateDocumentStatus> {
        public static final CreateDocumentStatus FAILED = null;
        public static final CreateDocumentStatus NOT_STARTED = null;
        public static final CreateDocumentStatus SUCCEEDED = null;
        public static final CreateDocumentStatus WAITING_CALLBACK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CreateDocumentStatus[] f363058a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f363059b = null;

        public static EnumEntries<CreateDocumentStatus> getEntries() {
            return f363059b;
        }

        static {
            CreateDocumentStatus r100 = new CreateDocumentStatus("NOT_STARTED", 0);
            NOT_STARTED = r100;
            CreateDocumentStatus r101 = new CreateDocumentStatus("WAITING_CALLBACK", 1);
            WAITING_CALLBACK = r101;
            CreateDocumentStatus r102 = new CreateDocumentStatus("SUCCEEDED", 2);
            SUCCEEDED = r102;
            CreateDocumentStatus r103 = new CreateDocumentStatus("FAILED", 3);
            FAILED = r103;
            CreateDocumentStatus[] r104 = {r100, r101, r102, r103};
            f363058a = r104;
            f363059b = EnumEntriesKt.enumEntries(r104);
        }

        public static CreateDocumentStatus[] values() {
            return (CreateDocumentStatus[]) f363058a.clone();
        }

        public static CreateDocumentStatus valueOf(String r100) {
            return (CreateDocumentStatus) r27.a.a(CreateDocumentStatus.class, r100);
        }

        public CreateDocumentStatus(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public CreateDocumentStatus f363060a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f363061b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f363062c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f363063d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f363064e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f363065f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f363066g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.larus.office.plugins.offline.a f363067h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public com.larus.office.plugins.offline.a f363068i;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f363060a == r101.f363060a) goto L12;
            return false;
        L12:
            if (this.f363061b == r101.f363061b) goto L15;
            return false;
        L15:
            if (this.f363062c == r101.f363062c) goto L18;
            return false;
        L18:
            if (this.f363063d == r101.f363063d) goto L21;
            return false;
        L21:
            if (this.f363064e == r101.f363064e) goto L24;
            return false;
        L24:
            if (this.f363065f == r101.f363065f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f363066g, r101.f363066g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f363067h, r101.f363067h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f363068i, r101.f363068i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f363060a.hashCode() * 31;
            int r101 = 1231;
            if (this.f363061b == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f363062c == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            if (this.f363063d == false) goto L13;
            int r106 = 1231;
        L14:
            int r107 = (r105 + r106) * 31;
            if (this.f363064e == false) goto L17;
            int r108 = 1231;
        L18:
            int r109 = (r107 + r108) * 31;
            if (this.f363065f == true) goto L22;
            r101 = 1237;
        L22:
            int r110 = (r109 + r101) * 31;
            String r111 = this.f363066g;
            int r112 = 0;
            if (r111 != null) goto L25;
            int r113 = 0;
        L26:
            int r114 = (r110 + r113) * 31;
            com.larus.office.plugins.offline.a r115 = this.f363067h;
            if (r115 != null) goto L29;
            int r116 = 0;
        L30:
            int r117 = (r114 + r116) * 31;
            com.larus.office.plugins.offline.a r118 = this.f363068i;
            if (r118 == null) goto L35;
            r112 = r118.hashCode();
        L35:
            return r117 + r112;
        L29:
            r116 = r115.hashCode();
            goto L30
        L25:
            r113 = r111.hashCode();
            goto L26
        L17:
            r108 = 1237;
            goto L18
        L13:
            r106 = 1237;
            goto L14
        L9:
            r104 = 1237;
            goto L10
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "State(createDocumentStatus=" + this.f363060a + ", hasFrontendLinked=" + this.f363061b + ", hasUserChanges=" + this.f363062c + ", hasAcceptCommit=" + this.f363063d + ", hasHostDestroyed=" + this.f363064e + ", hasDispatchedCreateDocByMessage=" + this.f363065f + ", realToken=" + this.f363066g + ", latestSnapshot=" + this.f363067h + ", destroySnapshot=" + this.f363068i + ')';
        }

        public a(int r100) {
            CreateDocumentStatus r101 = CreateDocumentStatus.NOT_STARTED;
            Intrinsics.checkNotNullParameter(r101, "createDocumentStatus");
            this.f363060a = r101;
            this.f363061b = false;
            this.f363062c = false;
            this.f363063d = false;
            this.f363064e = false;
            this.f363065f = false;
            this.f363066g = null;
            this.f363067h = null;
            this.f363068i = null;
        }
    }

    public OfficeOfflineDocCreateCoordinator() {
        this.f363057a = new a(0);
    }

    public final d a(String r100) {
        a r101 = this.f363057a;
        com.larus.office.plugins.offline.a r102 = r101.f363068i;
        if (r102 != null) goto L5;
        r102 = r101.f363067h;
    L5:
        com.larus.office.plugins.offline.a r103 = r102;
        String r104 = r101.f363066g;
        if (r104 != null) goto L8;
    L10:
        String r105 = null;
    L11:
        if (r105 != null) goto L14;
        Boolean r106 = null;
    L18:
        if (r105 != null) goto L22;
        String r107 = "create_doc_by_message_not_started";
    L26:
        return c(r103, r105, r106, r107, r100);
    L22:
        if (this.f363057a.f363061b == false) goto L24;
        r107 = "no_accept_commit";
        goto L26
    L24:
        r107 = "offline_file_sync_started";
        goto L26
    L14:
        if (this.f363057a.f363061b == false) goto L16;
        Boolean r108 = Boolean.FALSE;
    L17:
        r106 = r108;
        goto L18
    L16:
        r108 = Boolean.TRUE;
        goto L17
    L8:
        if ((!StringsKt.isBlank(r104)) == false) goto L10;
        r105 = r104;
        goto L11
    }

    public final d b(String r100) {
        String r101 = this.f363057a.f363066g;
        if (r101 == null) goto L33;
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L33;
        a r102 = this.f363057a;
        if (r102.f363061b == true) goto L15;
        return new d.c(r100.concat(":frontend_not_linked"));
    L15:
        if (r102.f363063d == false) goto L17;
        com.larus.office.plugins.offline.a r103 = r102.f363067h;
        if (r103 != null) goto L23;
        return new d.c(r100.concat(":missing_snapshot"));
    L23:
        if (r102.f363065f == true) goto L25;
        r102.f363065f = true;
        OfficeCreateDocByMessageActionType r104 = OfficeCreateDocByMessageActionType.FORMAL;
        if (StringsKt.isBlank(r101) == false) goto L29;
        boolean r105 = true;
    L30:
        boolean r106 = true ^ r105;
        a r107 = this.f363057a;
        return new d.b(r103, r101, r100, new b(r104, r106, r107.f363062c, r107.f363061b));
    L29:
        r105 = false;
        goto L30
    L25:
        return new d.c(r100.concat(":create_doc_by_message_started"));
    L17:
        return new d.c(r100.concat(":accept_commit_not_ready"));
    L33:
        return new d.c(r100.concat(":no_real_token"));
    }

    public final synchronized d d(com.larus.office.plugins.offline.a r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "snapshot");     // Catch: Throwable -> L6
        a r101 = this.f363057a;     // Catch: Throwable -> L6
        r101.f363067h = r100;     // Catch: Throwable -> L6
        r101.f363063d = true;     // Catch: Throwable -> L6
        d r102 = b("accept_commit");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r102;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized d.c e(String r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, HiAnalyticsConstant.HaKey.BI_KEY_ERRORREASON);     // Catch: Throwable -> L7
        this.f363057a.f363065f = false;     // Catch: Throwable -> L7
        d.c r101 = new d.c("retry_open_rejected:".concat(r100));     // Catch: Throwable -> L7
        monitor-exit(this);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public final d c(com.larus.office.plugins.offline.a r110, String r111, Boolean r112, String r113, String r114) {
        a r100 = this.f363057a;
        if (r100.f363065f == true) goto L5;
        if (r110 == null) goto L8;
        r100.f363065f = true;
        OfficeCreateDocByMessageActionType r101 = OfficeCreateDocByMessageActionType.COMPENSATE;
        if (r111 != null) goto L12;
    L15:
        boolean r102 = true;
    L16:
        boolean r103 = true ^ r102;
        a r104 = this.f363057a;
        return new d.a(r110, r111, r112, r113, r114, new b(r101, r103, r104.f363062c, r104.f363061b));
    L12:
        if (StringsKt.isBlank(r111) == true) goto L15;
        r102 = false;
        goto L16
    L8:
        return new d.c(r114 + ":missing_snapshot");
    L5:
        return new d.c(r114 + ":create_doc_by_message_started");
    }
}
