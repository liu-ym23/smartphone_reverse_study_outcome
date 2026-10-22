package com.ss.android.socialbase.appdownloader.util.parser.zip;

/* JADX INFO: loaded from: classes38.dex */
public final class GeneralPurposeBit implements Cloneable {
    private static final int DATA_DESCRIPTOR_FLAG = 8;
    private static final int ENCRYPTION_FLAG = 1;
    private static final int STRONG_ENCRYPTION_FLAG = 64;
    public static final int UFT8_NAMES_FLAG = 2048;
    private boolean dataDescriptorFlag;
    private boolean encryptionFlag;
    private boolean languageEncodingFlag;
    private boolean strongEncryptionFlag;

    public byte[] encode() {
        byte[] r100 = new byte[2];
        encode(r100, 0);
        return r100;
    }

    public int hashCode() {
        return (((((((this.encryptionFlag ? 1 : 0) * 17) + (this.strongEncryptionFlag ? 1 : 0)) * 13) + (this.languageEncodingFlag ? 1 : 0)) * 7) + (this.dataDescriptorFlag ? 1 : 0)) * 3;
    }

    public boolean usesStrongEncryption() {
        if (this.encryptionFlag == true) goto L5;
    L7:
        return false;
    L5:
        if (this.strongEncryptionFlag == false) goto L7;
        return true;
    }

    public GeneralPurposeBit() {
        this.languageEncodingFlag = false;
        this.dataDescriptorFlag = false;
        this.encryptionFlag = false;
        this.strongEncryptionFlag = false;
    }

    public Object clone() {
        return super.clone();
    L4:
        e = move-exception;
        throw new RuntimeException("GeneralPurposeBit is not Cloneable?", e);
    }

    public boolean usesDataDescriptor() {
        return this.dataDescriptorFlag;
    }

    public boolean usesEncryption() {
        return this.encryptionFlag;
    }

    public boolean usesUTF8ForNames() {
        return this.languageEncodingFlag;
    }

    public boolean equals(Object r100) {
        if ((r100 instanceof GeneralPurposeBit) == false) goto L14;
        GeneralPurposeBit r101 = (GeneralPurposeBit) r100;
        if (r101.encryptionFlag == this.encryptionFlag) goto L7;
        return false;
    L7:
        if (r101.strongEncryptionFlag == this.strongEncryptionFlag) goto L9;
        return false;
    L9:
        if (r101.languageEncodingFlag == this.languageEncodingFlag) goto L11;
        return false;
    L11:
        if (r101.dataDescriptorFlag != this.dataDescriptorFlag) goto L18;
        return true;
    L18:
        return false;
    L14:
        return false;
    }

    public void useDataDescriptor(boolean r100) {
        this.dataDescriptorFlag = r100;
    }

    public void useEncryption(boolean r100) {
        this.encryptionFlag = r100;
    }

    public void useStrongEncryption(boolean r100) {
        this.strongEncryptionFlag = r100;
        if (r100 == false) goto L6;
        useEncryption(true);
        return;
    }

    public void useUTF8ForNames(boolean r100) {
        this.languageEncodingFlag = r100;
    }

    public static GeneralPurposeBit parse(byte[] r100, int r101) {
        int r102 = ZipShort.getValue(r100, r101);
        GeneralPurposeBit r103 = new GeneralPurposeBit();
        boolean r104 = false;
        if ((r102 & 8) == 0) goto L5;
        boolean r105 = true;
    L6:
        r103.useDataDescriptor(r105);
        if ((r102 & 2048) == 0) goto L9;
        boolean r106 = true;
    L10:
        r103.useUTF8ForNames(r106);
        if ((r102 & 64) == 0) goto L13;
        boolean r107 = true;
    L14:
        r103.useStrongEncryption(r107);
        if ((r102 & 1) == 0) goto L17;
        r104 = true;
    L17:
        r103.useEncryption(r104);
        return r103;
    L13:
        r107 = false;
        goto L14
    L9:
        r106 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }

    public void encode(byte[] r100, int r101) {
        int r102 = 0;
        if (this.dataDescriptorFlag == false) goto L5;
        int r103 = 8;
    L7:
        if (this.languageEncodingFlag == false) goto L9;
        int r104 = 2048;
    L10:
        int r105 = (r103 | r104) | (this.encryptionFlag ? 1 : 0);
        if (this.strongEncryptionFlag == false) goto L13;
        r102 = 64;
    L13:
        ZipShort.putShort(r105 | r102, r100, r101);
        return;
    L9:
        r104 = 0;
        goto L10
    L5:
        r103 = 0;
        goto L7
    }
}
