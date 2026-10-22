package com.bytedance.ee.bear.drive.biz.importfile.request.error;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
    public static final /* synthetic */ ImportFailedType[] a = null;

    static {
        ImportFailedType r0 = new ImportFailedType("FailedNoPermisson", 0);
        FailedNoPermisson = r0;
        ImportFailedType r1 = new ImportFailedType("FailedNoNet", 1);
        FailedNoNet = r1;
        ImportFailedType r3 = new ImportFailedType("FailedType", 2);
        FailedType = r3;
        ImportFailedType r5 = new ImportFailedType("FailedSize", 3);
        FailedSize = r5;
        ImportFailedType r7 = new ImportFailedType("FailedCanRetry", 4);
        FailedCanRetry = r7;
        ImportFailedType r9 = new ImportFailedType("FailedOverLimitCount", 5);
        FailedOverLimitCount = r9;
        ImportFailedType r11 = new ImportFailedType("FailedCanContactSupport", 6);
        FailedCanContactSupport = r11;
        ImportFailedType r13 = new ImportFailedType("ImDlpProgress", 7);
        ImDlpProgress = r13;
        ImportFailedType r16 = new ImportFailedType("ImDlpFail", 8);
        ImDlpFail = r16;
        ImportFailedType r14 = new ImportFailedType("EncryptFile", 9);
        EncryptFile = r14;
        ImportFailedType r12 = new ImportFailedType("FailedEncrypt", 10);
        FailedEncrypt = r12;
        ImportFailedType r10 = new ImportFailedType("FailedImportBlockNumberOverLimit", 11);
        FailedImportBlockNumberOverLimit = r10;
        ImportFailedType r8 = new ImportFailedType("FailedImportBlockHierarchyOverLimit", 12);
        FailedImportBlockHierarchyOverLimit = r8;
        ImportFailedType r6 = new ImportFailedType("FailedImportBlockStorageOverLimit", 13);
        FailedImportBlockStorageOverLimit = r6;
        ImportFailedType r4 = new ImportFailedType("FailedNotExist", 14);
        FailedNotExist = r4;
        ImportFailedType r2 = new ImportFailedType("FailedEmptyFile", 15);
        FailedEmptyFile = r2;
        ImportFailedType r17 = new ImportFailedType("FailedMigateBrand", 16);
        FailedMigateBrand = r17;
        ImportFailedType r18 = new ImportFailedType("FailedMigateDoc", 17);
        FailedMigateDoc = r18;
        ImportFailedType r19 = new ImportFailedType("FailedDlpError", 18);
        FailedDlpError = r19;
        ImportFailedType r20 = new ImportFailedType("FailedQuotaLimit", 19);
        FailedQuotaLimit = r20;
        ImportFailedType r21 = new ImportFailedType("FailedImportDriveFileEncrypted", 20);
        FailedImportDriveFileEncrypted = r21;
        a = new ImportFailedType[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14, r12, r10, r8, r6, r4, r2, r17, r18, r19, r20, r21};
    }

    public static ImportFailedType[] values() {
        return (ImportFailedType[]) a.clone();
    }

    public static ImportFailedType valueOf(String r1) {
        return (ImportFailedType) a.a(ImportFailedType.class, r1);
    }

    public ImportFailedType(String r1, int r2) {
        super(r1, r2);
    }
}
