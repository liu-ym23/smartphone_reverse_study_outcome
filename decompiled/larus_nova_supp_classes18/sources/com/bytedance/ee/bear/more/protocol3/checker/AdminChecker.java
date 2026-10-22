package com.bytedance.ee.bear.more.protocol3.checker;

import android.view.View;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.BizDomain;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionRequest;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.UniBaseEntity;
import com.bytedance.ee.bear.more.protocol3.j;
import com.ss.android.lark.security.compliance.api.model.filepolicy.FileBizDomain;
import jg5.e;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class AdminChecker extends j {
    public final AdminPermissionType e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/ee/bear/more/protocol3/checker/AdminChecker$AdminPermissionType;", "", "<init>", "(Ljava/lang/String;I)V", "Upload", "Download", "Export", "Print", "Copy", "OtherAppOpen", "ExternalShare", "CreateCopy", "AttachFileDownload", "AttachFileUpload", "features-more-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum AdminPermissionType extends Enum<AdminPermissionType> {
        public static final AdminPermissionType AttachFileDownload = null;
        public static final AdminPermissionType AttachFileUpload = null;
        public static final AdminPermissionType Copy = null;
        public static final AdminPermissionType CreateCopy = null;
        public static final AdminPermissionType Download = null;
        public static final AdminPermissionType Export = null;
        public static final AdminPermissionType ExternalShare = null;
        public static final AdminPermissionType OtherAppOpen = null;
        public static final AdminPermissionType Print = null;
        public static final AdminPermissionType Upload = null;
        public static final /* synthetic */ AdminPermissionType[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<AdminPermissionType> getEntries() {
            return b;
        }

        static {
            AdminPermissionType r0 = new AdminPermissionType("Upload", 0);
            Upload = r0;
            AdminPermissionType r1 = new AdminPermissionType("Download", 1);
            Download = r1;
            AdminPermissionType r3 = new AdminPermissionType("Export", 2);
            Export = r3;
            AdminPermissionType r5 = new AdminPermissionType("Print", 3);
            Print = r5;
            AdminPermissionType r7 = new AdminPermissionType("Copy", 4);
            Copy = r7;
            AdminPermissionType r9 = new AdminPermissionType("OtherAppOpen", 5);
            OtherAppOpen = r9;
            AdminPermissionType r11 = new AdminPermissionType("ExternalShare", 6);
            ExternalShare = r11;
            AdminPermissionType r13 = new AdminPermissionType("CreateCopy", 7);
            CreateCopy = r13;
            AdminPermissionType r15 = new AdminPermissionType("AttachFileDownload", 8);
            AttachFileDownload = r15;
            AdminPermissionType r14 = new AdminPermissionType("AttachFileUpload", 9);
            AttachFileUpload = r14;
            AdminPermissionType[] r12 = {r0, r1, r3, r5, r7, r9, r11, r13, r15, r14};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static AdminPermissionType[] values() {
            return (AdminPermissionType[]) a.clone();
        }

        public static AdminPermissionType valueOf(String r1) {
            return (AdminPermissionType) r27.a.a(AdminPermissionType.class, r1);
        }

        public AdminPermissionType(String r1, int r2) {
            super(r1, r2);
        }
    }

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[AdminPermissionType.values().length];
            r0[AdminPermissionType.Upload.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L27:
            r0[AdminPermissionType.Download.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L43:
            r0[AdminPermissionType.Export.ordinal()] = 3;     // Catch: NoSuchFieldError -> L17
        L31:
            r0[AdminPermissionType.Print.ordinal()] = 4;     // Catch: NoSuchFieldError -> L18
        L35:
            r0[AdminPermissionType.Copy.ordinal()] = 5;     // Catch: NoSuchFieldError -> L19
        L25:
            r0[AdminPermissionType.OtherAppOpen.ordinal()] = 6;     // Catch: NoSuchFieldError -> L20
        L37:
            r0[AdminPermissionType.ExternalShare.ordinal()] = 7;     // Catch: NoSuchFieldError -> L21
        L39:
            r0[AdminPermissionType.CreateCopy.ordinal()] = 8;     // Catch: NoSuchFieldError -> L22
        L29:
            r0[AdminPermissionType.AttachFileDownload.ordinal()] = 9;     // Catch: NoSuchFieldError -> L23
        L33:
            r0[AdminPermissionType.AttachFileUpload.ordinal()] = 10;     // Catch: NoSuchFieldError -> L24
        L13:
            a = r0;
        }
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final int c() {
        return 2131887246;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j
    public final boolean e() {
        oj5.c r0 = d();
        if (r0 != null) goto L5;
        return false;
    L5:
        int r2 = r0.getType();
        String r3 = r0.getToken();
        if (r2 != (-1)) goto L8;
        return false;
    L8:
        gj5.b r1 = (gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6);
        com.bytedance.ee.bear.middleground_permission_export.model.b r4 = (com.bytedance.ee.bear.middleground_permission_export.model.b) org.koin.java.a.c(com.bytedance.ee.bear.middleground_permission_export.model.b.class, null, null, 6);
        AdminPermissionType r5 = this.e;
        switch(a.a[r5.ordinal()]) {
            case 1: goto L22;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L28;
            case 6: goto L27;
            case 7: goto L26;
            case 8: goto L25;
            case 9: goto L24;
            case 10: goto L23;
            default: goto L11;
        };
    L11:
        throw new NoWhenBranchMatchedException();
    L23:
        return r1.g("CCM_ATTACHMENT_UPLOAD", FileBizDomain.FileBizDomainCCM, r2, r3).a;
    L24:
        return r1.g("CCM_ATTACHMENT_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r2, r3).a;
    L25:
        return f(r0, "CREATE_COPY", "CCM_CREATE_COPY");
    L26:
        return r4.a(r2, r3);
    L27:
        return r1.g("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r2, r3).a;
    L28:
        return r1.g("CCM_CONTENT_COPY", FileBizDomain.FileBizDomainCCM, r2, r3).a;
    L29:
        return r1.g("CCM_PRINT", FileBizDomain.FileBizDomainCCM, r2, r3).a;
    L30:
        return f(r0, "EXPORT", "CCM_EXPORT");
    L31:
        return r1.g("CCM_FILE_DOWNLOAD", FileBizDomain.FileBizDomainCCM, r2, r3).a;
    L22:
        return r1.g("CCM_FILE_UPLOAD", FileBizDomain.FileBizDomainCCM, r2, r3).a;
    }

    @Override // com.bytedance.ee.bear.more.protocol3.j, com.bytedance.ee.bear.more.protocol3.a
    public final View.OnClickListener a() {
        return this.d;
    }

    public AdminChecker(AdminPermissionType r2) {
        Intrinsics.checkNotNullParameter(r2, "permissionType");
        this.e = r2;
    }

    public static boolean f(oj5.c r16, String r17, String r18) {
        int r0 = r16.getType();
        String r2 = r16.getToken();
        ((cj5.b) org.koin.java.a.c(cj5.b.class, null, null, 6)).getConfig();
        if (e.a.a.g() == false) goto L7;
        String r5 = r16.a();
        String r6 = r16.d();
        UniBaseEntity r15 = new UniBaseEntity(r2, sbb.e.d(r0), BizDomain.FileBizDomainCCM, r5, r6, null, null, null, null, 480, null);
        return ((ph5.b) org.koin.java.a.c(ph5.b.class, null, null, 6)).f(new PermissionRequest(r15, r17), null).getAllow();
    L7:
        return ((gj5.b) org.koin.java.a.c(gj5.b.class, null, null, 6)).g(r18, FileBizDomain.FileBizDomainCCM, r0, r2).a;
    }
}
