package com.bytedance.ee.bear.drive.biz.importfile.request.error;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum ImportFailedType extends Enum<ImportFailedType> {
    public static final ImportFailedType EncryptFile = null;
    public static final ImportFailedType FailedCanContactSupport = null;
    public static final ImportFailedType FailedCanRetry = null;
    public static final ImportFailedType FailedDlpError = null;
    public static final ImportFailedType FailedEmptyFile = null;
    public static final ImportFailedType FailedEncrypt = null;
    public static final ImportFailedType FailedImportBlockHierarchyOverLimit = null;
    public static final ImportFailedType FailedImportBlockNumberOverLimit = null;
    public static final ImportFailedType FailedImportBlockStorageOverLimit = null;
    public static final ImportFailedType FailedImportDriveFileEncrypted = null;
    public static final ImportFailedType FailedMigateBrand = null;
    public static final ImportFailedType FailedMigateDoc = null;
    public static final ImportFailedType FailedNoNet = null;
    public static final ImportFailedType FailedNoPermisson = null;
    public static final ImportFailedType FailedNotExist = null;
    public static final ImportFailedType FailedOverLimitCount = null;
    public static final ImportFailedType FailedQuotaLimit = null;
    public static final ImportFailedType FailedSize = null;
    public static final ImportFailedType FailedType = null;
    public static final ImportFailedType ImDlpFail = null;
    public static final ImportFailedType ImDlpProgress = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImportFailedType[] f223077a = null;

    static {
        ImportFailedType r100 = new ImportFailedType("FailedNoPermisson", 0);
        FailedNoPermisson = r100;
        ImportFailedType r101 = new ImportFailedType("FailedNoNet", 1);
        FailedNoNet = r101;
        ImportFailedType r102 = new ImportFailedType("FailedType", 2);
        FailedType = r102;
        ImportFailedType r103 = new ImportFailedType("FailedSize", 3);
        FailedSize = r103;
        ImportFailedType r104 = new ImportFailedType("FailedCanRetry", 4);
        FailedCanRetry = r104;
        ImportFailedType r105 = new ImportFailedType("FailedOverLimitCount", 5);
        FailedOverLimitCount = r105;
        ImportFailedType r110 = new ImportFailedType("FailedCanContactSupport", 6);
        FailedCanContactSupport = r110;
        ImportFailedType r111 = new ImportFailedType("ImDlpProgress", 7);
        ImDlpProgress = r111;
        ImportFailedType r112 = new ImportFailedType("ImDlpFail", 8);
        ImDlpFail = r112;
        ImportFailedType r113 = new ImportFailedType("EncryptFile", 9);
        EncryptFile = r113;
        ImportFailedType r114 = new ImportFailedType("FailedEncrypt", 10);
        FailedEncrypt = r114;
        ImportFailedType r115 = new ImportFailedType("FailedImportBlockNumberOverLimit", 11);
        FailedImportBlockNumberOverLimit = r115;
        ImportFailedType r106 = new ImportFailedType("FailedImportBlockHierarchyOverLimit", 12);
        FailedImportBlockHierarchyOverLimit = r106;
        ImportFailedType r107 = new ImportFailedType("FailedImportBlockStorageOverLimit", 13);
        FailedImportBlockStorageOverLimit = r107;
        ImportFailedType r108 = new ImportFailedType("FailedNotExist", 14);
        FailedNotExist = r108;
        ImportFailedType r109 = new ImportFailedType("FailedEmptyFile", 15);
        FailedEmptyFile = r109;
        ImportFailedType r116 = new ImportFailedType("FailedMigateBrand", 16);
        FailedMigateBrand = r116;
        ImportFailedType r117 = new ImportFailedType("FailedMigateDoc", 17);
        FailedMigateDoc = r117;
        ImportFailedType r118 = new ImportFailedType("FailedDlpError", 18);
        FailedDlpError = r118;
        ImportFailedType r119 = new ImportFailedType("FailedQuotaLimit", 19);
        FailedQuotaLimit = r119;
        ImportFailedType r120 = new ImportFailedType("FailedImportDriveFileEncrypted", 20);
        FailedImportDriveFileEncrypted = r120;
        f223077a = new ImportFailedType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120};
    }

    public static ImportFailedType[] values() {
        return (ImportFailedType[]) f223077a.clone();
    }

    public static ImportFailedType valueOf(String r100) {
        return (ImportFailedType) a.a(ImportFailedType.class, r100);
    }

    public ImportFailedType(String r100, int r101) {
        super(r100, r101);
    }
}
