package org.bouncycastle.pqc.crypto.mceliece;

/* JADX INFO: loaded from: classes42.dex */
public class McElieceCCA2Parameters extends McElieceParameters {
    private final String digest;

    public McElieceCCA2Parameters() {
        this(11, 50, "SHA-256");
    }

    public McElieceCCA2Parameters(int r100) {
        this(r100, "SHA-256");
    }

    public McElieceCCA2Parameters(int r100, int r101) {
        this(r100, r101, "SHA-256");
    }

    public McElieceCCA2Parameters(int r100, int r101, int r102) {
        this(r100, r101, r102, "SHA-256");
    }

    public McElieceCCA2Parameters(int r100, int r101, int r102, String r103) {
        super(r100, r101, r102);
        this.digest = r103;
    }

    public McElieceCCA2Parameters(int r100, int r101, String r102) {
        super(r100, r101);
        this.digest = r102;
    }

    public McElieceCCA2Parameters(int r100, String r101) {
        super(r100);
        this.digest = r101;
    }

    public McElieceCCA2Parameters(String r100) {
        this(11, 50, r100);
    }

    public String getDigest() {
        return this.digest;
    }
}
