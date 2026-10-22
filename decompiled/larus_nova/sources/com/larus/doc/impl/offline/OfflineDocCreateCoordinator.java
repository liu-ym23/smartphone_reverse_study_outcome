package com.larus.doc.impl.offline;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class OfflineDocCreateCoordinator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f331222a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/doc/impl/offline/OfflineDocCreateCoordinator$CreateDocumentStatus;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_STARTED", "WAITING_CALLBACK", "SUCCEEDED", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum CreateDocumentStatus extends Enum<CreateDocumentStatus> {
        public static final CreateDocumentStatus FAILED = null;
        public static final CreateDocumentStatus NOT_STARTED = null;
        public static final CreateDocumentStatus SUCCEEDED = null;
        public static final CreateDocumentStatus WAITING_CALLBACK = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ CreateDocumentStatus[] f331223a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f331224b = null;

        public static EnumEntries<CreateDocumentStatus> getEntries() {
            return f331224b;
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
            f331223a = r104;
            f331224b = EnumEntriesKt.enumEntries(r104);
        }

        public static CreateDocumentStatus[] values() {
            return (CreateDocumentStatus[]) f331223a.clone();
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
        public CreateDocumentStatus f331225a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f331226b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f331227c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f331228d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f331229e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f331230f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f331231g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public com.larus.doc.impl.offline.a f331232h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public com.larus.doc.impl.offline.a f331233i;

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
            if (this.f331225a == r101.f331225a) goto L12;
            return false;
        L12:
            if (this.f331226b == r101.f331226b) goto L15;
            return false;
        L15:
            if (this.f331227c == r101.f331227c) goto L18;
            return false;
        L18:
            if (this.f331228d == r101.f331228d) goto L21;
            return false;
        L21:
            if (this.f331229e == r101.f331229e) goto L24;
            return false;
        L24:
            if (this.f331230f == r101.f331230f) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f331231g, r101.f331231g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f331232h, r101.f331232h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f331233i, r101.f331233i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f331225a.hashCode() * 31;
            int r101 = 1231;
            if (this.f331226b == false) goto L5;
            int r102 = 1231;
        L6:
            int r103 = (r100 + r102) * 31;
            if (this.f331227c == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r103 + r104) * 31;
            if (this.f331228d == false) goto L13;
            int r106 = 1231;
        L14:
            int r107 = (r105 + r106) * 31;
            if (this.f331229e == false) goto L17;
            int r108 = 1231;
        L18:
            int r109 = (r107 + r108) * 31;
            if (this.f331230f == true) goto L22;
            r101 = 1237;
        L22:
            int r110 = (r109 + r101) * 31;
            String r111 = this.f331231g;
            int r112 = 0;
            if (r111 != null) goto L25;
            int r113 = 0;
        L26:
            int r114 = (r110 + r113) * 31;
            com.larus.doc.impl.offline.a r115 = this.f331232h;
            if (r115 != null) goto L29;
            int r116 = 0;
        L30:
            int r117 = (r114 + r116) * 31;
            com.larus.doc.impl.offline.a r118 = this.f331233i;
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
            return "State(createDocumentStatus=" + this.f331225a + ", hasFrontendLinked=" + this.f331226b + ", hasUserChanges=" + this.f331227c + ", hasAcceptCommit=" + this.f331228d + ", hasHostDestroyed=" + this.f331229e + ", hasDispatchedCreateDocByMessage=" + this.f331230f + ", realToken=" + this.f331231g + ", latestSnapshot=" + this.f331232h + ", destroySnapshot=" + this.f331233i + ')';
        }

        public a(int r100) {
            CreateDocumentStatus r101 = CreateDocumentStatus.NOT_STARTED;
            Intrinsics.checkNotNullParameter(r101, "createDocumentStatus");
            this.f331225a = r101;
            this.f331226b = false;
            this.f331227c = false;
            this.f331228d = false;
            this.f331229e = false;
            this.f331230f = false;
            this.f331231g = null;
            this.f331232h = null;
            this.f331233i = null;
        }
    }

    public final synchronized String d() {
        monitor-enter(this);
        String r100 = this.f331222a.f331231g;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public OfflineDocCreateCoordinator() {
        this.f331222a = new a(0);
    }

    public final e a(String r100) {
        a r101 = this.f331222a;
        com.larus.doc.impl.offline.a r102 = r101.f331233i;
        if (r102 != null) goto L5;
        r102 = r101.f331232h;
    L5:
        com.larus.doc.impl.offline.a r103 = r102;
        String r104 = r101.f331231g;
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
        return e(r103, r105, r106, r107, r100);
    L22:
        if (this.f331222a.f331226b == false) goto L24;
        r107 = "no_accept_commit";
        goto L26
    L24:
        r107 = "offline_file_sync_started";
        goto L26
    L14:
        if (this.f331222a.f331226b == false) goto L16;
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

    public final e b(String r100) {
        String r101 = this.f331222a.f331231g;
        if (r101 == null) goto L30;
        if ((!StringsKt.isBlank(r101)) == true) goto L8;
        r101 = null;
    L8:
        if (r101 == null) goto L30;
        a r102 = this.f331222a;
        if (r102.f331226b == true) goto L15;
        return new e.c(r100.concat(":frontend_not_linked"));
    L15:
        if (r102.f331228d == false) goto L17;
        com.larus.doc.impl.offline.a r103 = r102.f331232h;
        if (r102.f331230f == true) goto L31;
        if (r103 == null) goto L32;
        r102.f331230f = true;
        com.larus.doc.impl.offline.a r104 = com.larus.doc.impl.offline.a.a(r103, r101, Boolean.FALSE);
        CreateDocByMessageActionType r105 = CreateDocByMessageActionType.FORMAL;
        if (StringsKt.isBlank(r101) == false) goto L26;
        boolean r106 = true;
    L27:
        a r107 = this.f331222a;
        return new e.b(r104, r100, new b(r105, !r106, r107.f331227c, r107.f331226b));
    L26:
        r106 = false;
        goto L27
    L32:
        return new e.c(r100.concat(":missing_snapshot"));
    L31:
        return new e.c(r100.concat(":create_doc_by_message_started"));
    L17:
        return new e.c(r100.concat(":accept_commit_not_ready"));
    L30:
        return new e.c(r100.concat(":no_real_token"));
    }

    public final void c(com.larus.doc.impl.offline.a r100) {
        a r101 = this.f331222a;
        r101.f331232h = r100;
        String r102 = r101.f331231g;
        boolean r103 = true;
        if (r102 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L19;
        String r105 = r100.f331239f;
        if (r105 != null) goto L13;
    L16:
        if (r103 == true) goto L20;
        a r106 = this.f331222a;
        r106.f331231g = r100.f331239f;
        return;
    L20:
        return;
    L13:
        if (StringsKt.isBlank(r105) == true) goto L16;
        r103 = false;
        goto L16
    L19:
        return;
    L5:
        if (StringsKt.isBlank(r102) == true) goto L8;
        r104 = false;
        goto L9
    }

    public final synchronized e f(com.larus.doc.impl.offline.a r100) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r100, "snapshot");     // Catch: Throwable -> L6
        c(r100);     // Catch: Throwable -> L6
        this.f331222a.f331228d = true;     // Catch: Throwable -> L6
        e r101 = b("accept_commit");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r101;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized e g(String r110) {
        monitor-enter(this);
        a r100 = this.f331222a;     // Catch: Throwable -> L11
        CreateDocumentStatus r101 = CreateDocumentStatus.FAILED;     // Catch: Throwable -> L11
        r100.getClass();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r101, "<set-?>");     // Catch: Throwable -> L11
        r100.f331225a = r101;     // Catch: Throwable -> L11
        a r102 = this.f331222a;     // Catch: Throwable -> L11
        if (r102.f331229e == false) goto L8;
        e r111 = e(r102.f331233i, null, null, "create_doc_by_message_not_started", "create_document_failed_after_destroy:".concat(r110));     // Catch: Throwable -> L11
    L9:
        monitor-exit(this);
        return r111;
    L8:
        r111 = new e.c("create_document_failed:".concat(r110));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        throw th;
    }

    public final e e(com.larus.doc.impl.offline.a r100, String r101, Boolean r102, String r103, String r104) {
        a r105 = this.f331222a;
        if (r105.f331230f == true) goto L5;
        if (r100 == null) goto L8;
        r105.f331230f = true;
        com.larus.doc.impl.offline.a r106 = com.larus.doc.impl.offline.a.a(r100, r101, r102);
        CreateDocByMessageActionType r107 = CreateDocByMessageActionType.COMPENSATE;
        if (r101 != null) goto L12;
    L15:
        boolean r108 = true;
    L16:
        a r109 = this.f331222a;
        return new e.a(r106, r103, r104, new b(r107, !r108, r109.f331227c, r109.f331226b));
    L12:
        if (StringsKt.isBlank(r101) == true) goto L15;
        r108 = false;
        goto L16
    L8:
        return new e.c(r104 + ":missing_snapshot");
    L5:
        return new e.c(r104 + ":create_doc_by_message_started");
    }
}
