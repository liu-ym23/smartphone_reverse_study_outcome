package com.ss.android.socialbase.downloader.constants;

import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final enum Md5CheckStatus extends Enum<Md5CheckStatus> {
    private static final /* synthetic */ Md5CheckStatus[] $VALUES = null;
    public static final Md5CheckStatus INVALID_FILE_MD5_EMPTY = null;
    public static final Md5CheckStatus INVALID_FILE_NO_EXIST = null;
    public static final Md5CheckStatus INVALID_MD5_NOT_EQUALS = null;
    public static final Md5CheckStatus VALID = null;

    static {
        Md5CheckStatus r100 = new Md5CheckStatus("VALID", 0);
        VALID = r100;
        Md5CheckStatus r101 = new Md5CheckStatus("INVALID_FILE_NO_EXIST", 1);
        INVALID_FILE_NO_EXIST = r101;
        Md5CheckStatus r102 = new Md5CheckStatus("INVALID_FILE_MD5_EMPTY", 2);
        INVALID_FILE_MD5_EMPTY = r102;
        Md5CheckStatus r103 = new Md5CheckStatus("INVALID_MD5_NOT_EQUALS", 3);
        INVALID_MD5_NOT_EQUALS = r103;
        $VALUES = new Md5CheckStatus[]{r100, r101, r102, r103};
    }

    public static Md5CheckStatus[] values() {
        return (Md5CheckStatus[]) $VALUES.clone();
    }

    public static Md5CheckStatus valueOf(String r100) {
        return (Md5CheckStatus) a.a(Md5CheckStatus.class, r100);
    }

    private Md5CheckStatus(String r100, int r101) {
        super(r100, r101);
    }
}
