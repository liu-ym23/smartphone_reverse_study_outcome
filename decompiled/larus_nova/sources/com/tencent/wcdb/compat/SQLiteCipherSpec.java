package com.tencent.wcdb.compat;

import com.obric.sva.sdk.controller.RecordingsMgr;

/* JADX INFO: loaded from: classes40.dex */
public class SQLiteCipherSpec {
    static final String[] HMAC_ALGO_MAPPING = null;
    public static final int HMAC_DEFAULT = -1;
    public static final int HMAC_SHA1 = 0;
    public static final int HMAC_SHA256 = 1;
    public static final int HMAC_SHA512 = 2;
    static final String[] PBKDF2_ALGO_MAPPING = null;
    int cipherVersion;
    public int hmacAlgorithm;
    public boolean hmacEnabled;
    public int kdfAlgorithm;
    public int kdfIteration;
    public int pageSize;

    static {
        HMAC_ALGO_MAPPING = new String[]{"HMAC_SHA1", "HMAC_SHA256", "HMAC_SHA512"};
        PBKDF2_ALGO_MAPPING = new String[]{"PBKDF2_HMAC_SHA1", "PBKDF2_HMAC_SHA256", "PBKDF2_HMAC_SHA512"};
    }

    public SQLiteCipherSpec() {
        this.hmacEnabled = true;
        this.hmacAlgorithm = -1;
        this.kdfAlgorithm = -1;
        this.pageSize = 4096;
        this.cipherVersion = 0;
    }

    public SQLiteCipherSpec(SQLiteCipherSpec r100) {
        this.hmacEnabled = true;
        this.hmacAlgorithm = -1;
        this.kdfAlgorithm = -1;
        this.pageSize = 4096;
        this.cipherVersion = 0;
        this.kdfIteration = r100.kdfIteration;
        this.hmacEnabled = r100.hmacEnabled;
        this.hmacAlgorithm = r100.hmacAlgorithm;
        this.kdfAlgorithm = r100.kdfAlgorithm;
        this.cipherVersion = r100.cipherVersion;
        this.pageSize = r100.pageSize;
    }

    public SQLiteCipherSpec setHmacAlgorithm(int r100) {
        if (this.hmacAlgorithm == r100) goto L5;
        this.hmacAlgorithm = r100;
        this.cipherVersion = -1;
    L5:
        return this;
    }

    public SQLiteCipherSpec setKDFIteration(int r100) {
        if (this.kdfIteration == r100) goto L5;
        this.kdfIteration = r100;
        this.cipherVersion = -1;
    L5:
        return this;
    }

    public SQLiteCipherSpec setKdfAlgorithm(int r100) {
        if (this.kdfAlgorithm == r100) goto L5;
        this.kdfAlgorithm = r100;
        this.cipherVersion = -1;
    L5:
        return this;
    }

    public SQLiteCipherSpec setPageSize(int r100) {
        this.pageSize = r100;
        return this;
    }

    public SQLiteCipherSpec setSQLCipherVersion(int r100) {
        if (r100 != 1) goto L5;
        this.cipherVersion = 1;
        this.hmacEnabled = false;
        this.kdfIteration = 4000;
        this.hmacAlgorithm = 0;
        this.kdfAlgorithm = 0;
    L16:
        return this;
    L5:
        if (r100 != 2) goto L7;
        this.cipherVersion = 2;
        this.hmacEnabled = true;
        this.kdfIteration = 4000;
        this.hmacAlgorithm = 0;
        this.kdfAlgorithm = 0;
        goto L16
    L7:
        if (r100 != 3) goto L9;
        this.cipherVersion = 3;
        this.hmacEnabled = true;
        this.kdfIteration = RecordingsMgr.SAMPLE_SIZE_SENCOND;
        this.hmacAlgorithm = 0;
        this.kdfAlgorithm = 0;
        goto L16
    L9:
        if (r100 != 4) goto L12;
        this.cipherVersion = 4;
        this.hmacEnabled = true;
        this.kdfIteration = 256000;
        this.hmacAlgorithm = 2;
        this.kdfAlgorithm = 2;
        goto L16
    L12:
        throw new IllegalArgumentException("Unsupported SQLCipher version: " + r100);
    }

    public SQLiteCipherSpec withHMACEnabled(boolean r100) {
        if (this.hmacEnabled == r100) goto L5;
        this.hmacEnabled = r100;
        this.cipherVersion = -1;
    L5:
        return this;
    }
}
