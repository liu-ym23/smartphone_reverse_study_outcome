package org.bouncycastle.util;

import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.BlockDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.CharacterDevice;
import com.bytedance.ee.bear.drive.biz.upload.filepicker.model.Directory;
import org.bouncycastle.crypto.digests.SHA512tDigest;
import org.bouncycastle.crypto.digests.SHAKEDigest;

/* JADX INFO: loaded from: classes42.dex */
public class Fingerprint {
    private static char[] encodingTable;
    private final byte[] fingerprint;

    static {
        encodingTable = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', BlockDevice.UNIX_ID, CharacterDevice.UNIX_ID, Directory.UNIX_ID, 'e', 'f'};
    }

    public Fingerprint(byte[] r100) {
        this(r100, 160);
    }

    public Fingerprint(byte[] r100, int r101) {
        this.fingerprint = calculateFingerprint(r100, r101);
    }

    public Fingerprint(byte[] r100, boolean r101) {
        if (r101 == false) goto L5;
        this.fingerprint = calculateFingerprintSHA512_160(r100);
        return;
    L5:
        this.fingerprint = calculateFingerprint(r100);
    }

    public static byte[] calculateFingerprint(byte[] r100) {
        return calculateFingerprint(r100, 160);
    }

    public static byte[] calculateFingerprint(byte[] r100, int r101) {
        if ((r101 % 8) != 0) goto L7;
        SHAKEDigest r102 = new SHAKEDigest(256);
        r102.update(r100, 0, r100.length);
        int r103 = r101 / 8;
        byte[] r104 = new byte[r103];
        r102.doFinal(r104, 0, r103);
        return r104;
    L7:
        throw new IllegalArgumentException("bitLength must be a multiple of 8");
    }

    public static byte[] calculateFingerprintSHA512_160(byte[] r100) {
        SHA512tDigest r101 = new SHA512tDigest(160);
        r101.update(r100, 0, r100.length);
        byte[] r102 = new byte[r101.getDigestSize()];
        r101.doFinal(r102, 0);
        return r102;
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Fingerprint) == true) goto L8;
        return false;
    L8:
        return Arrays.areEqual(((Fingerprint) r100).fingerprint, this.fingerprint);
    }

    public byte[] getFingerprint() {
        return Arrays.clone(this.fingerprint);
    }

    public int hashCode() {
        return Arrays.hashCode(this.fingerprint);
    }

    public String toString() {
        StringBuffer r100 = new StringBuffer();
        int r101 = 0;
    L4:
        if (r101 == this.fingerprint.length) goto L9;
        if (r101 <= 0) goto L7;
        r100.append(":");
    L7:
        r100.append(encodingTable[(this.fingerprint[r101] >>> 4) & 15]);
        r100.append(encodingTable[this.fingerprint[r101] & 15]);
        r101 = r101 + 1;
        goto L4
    L9:
        return r100.toString();
    }
}
