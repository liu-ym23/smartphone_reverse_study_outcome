package org.bouncycastle.crypto.engines;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.Enumeration;
import java.util.Hashtable;
import kotlin.UByte;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class GOST28147Engine implements BlockCipher {
    protected static final int BLOCK_SIZE = 8;
    private static byte[] DSbox_A;
    private static byte[] DSbox_Test;
    private static byte[] ESbox_A;
    private static byte[] ESbox_B;
    private static byte[] ESbox_C;
    private static byte[] ESbox_D;
    private static byte[] ESbox_Test;
    private static byte[] Param_Z;
    private static byte[] Sbox_Default;
    private static Hashtable sBoxes;
    private byte[] S;
    private boolean forEncryption;
    private int[] workingKey;

    static {
        Sbox_Default = new byte[]{4, 10, 9, 2, HTTP.CR, 8, 0, 14, 6, 11, 1, 12, 7, 15, 5, 3, 14, 11, 4, 12, 6, HTTP.CR, 15, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, HTTP.CR, 10, 3, 4, 2, 14, 15, 12, 7, 6, 0, 9, 11, 7, HTTP.CR, 10, 1, 0, 8, 9, 15, 14, 4, 6, 12, 11, 2, 5, 3, 6, 12, 7, 1, 5, 15, HTTP.CR, 8, 4, 10, 9, 14, 0, 3, 11, 2, 4, 11, 10, 0, 7, 2, 1, HTTP.CR, 3, 6, 8, 5, 9, 12, 15, 14, HTTP.CR, 11, 4, 1, 3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 2, 12, 1, 15, HTTP.CR, 0, 5, 7, 10, 4, 9, 2, 3, 14, 6, 11, 8, 12};
        ESbox_Test = new byte[]{4, 2, 15, 5, 9, 1, 0, 8, 14, 3, 11, 12, HTTP.CR, 7, 10, 6, 12, 9, 15, 14, 8, 1, 3, 10, 2, 7, 4, HTTP.CR, 6, 0, 11, 5, HTTP.CR, 8, 14, 12, 7, 3, 9, 10, 1, 5, 2, 4, 6, 15, 0, 11, 14, 9, 11, 2, 5, 15, 7, 1, 0, HTTP.CR, 12, 6, 10, 4, 3, 8, 3, 14, 5, 9, 6, 8, 0, HTTP.CR, 10, 11, 7, 12, 2, 1, 15, 4, 8, 15, 6, 11, 1, 9, 12, 5, HTTP.CR, 3, 7, 10, 0, 14, 2, 4, 9, 11, 12, 0, 3, 6, 7, 5, 4, 8, 14, 15, 1, 10, 2, HTTP.CR, 12, 6, 5, 2, 11, 0, 9, HTTP.CR, 3, 14, 7, 10, 15, 4, 1, 8};
        ESbox_A = new byte[]{9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 14, 15, 12, 0, HTTP.CR, 5, 3, 7, 14, 9, 8, 10, 15, 0, 5, 2, 6, 12, 11, 4, HTTP.CR, 1, 14, 4, 6, 2, 11, 3, HTTP.CR, 8, 12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 10, 12, HTTP.CR, 1, 3, 9, 0, 2, 11, 4, 15, 8, 5, 6, 11, 5, 1, 9, 8, HTTP.CR, 15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 3, 10, HTTP.CR, 12, 1, 2, 0, 11, 7, 5, 9, 4, 8, 15, 14, 6, 1, HTTP.CR, 2, 9, 7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 6, 2, 3, 9, 1, 7, HTTP.CR, 4};
        ESbox_B = new byte[]{8, 4, 11, 1, 3, 5, 0, 9, 2, 14, 10, 12, HTTP.CR, 6, 7, 15, 0, 1, 2, 10, 4, HTTP.CR, 5, 12, 9, 7, 3, 15, 11, 8, 6, 14, 14, 12, 0, 10, 9, 2, HTTP.CR, 11, 7, 5, 8, 15, 3, 6, 1, 4, 7, 5, 0, HTTP.CR, 11, 6, 1, 2, 3, 10, 12, 15, 4, 14, 9, 8, 2, 7, 12, 15, 9, 5, 10, 11, 1, 4, 0, HTTP.CR, 6, 8, 14, 3, 8, 3, 2, 6, 4, HTTP.CR, 14, 11, 12, 1, 7, 15, 10, 0, 9, 5, 5, 2, 10, 11, 9, 1, 12, 3, 7, 4, HTTP.CR, 0, 6, 15, 8, 14, 0, 4, 11, 14, 8, 3, 7, 1, 10, 2, 9, 6, 15, HTTP.CR, 5, 12};
        ESbox_C = new byte[]{1, 11, 12, 2, 9, HTTP.CR, 0, 15, 4, 5, 8, 14, 10, 7, 6, 3, 0, 1, 7, HTTP.CR, 11, 4, 5, 2, 8, 14, 15, 12, 9, 10, 6, 3, 8, 2, 5, 0, 4, 9, 15, 10, 3, 7, 12, HTTP.CR, 6, 14, 1, 11, 3, 6, 0, 1, 5, HTTP.CR, 10, 8, 11, 2, 9, 7, 14, 15, 12, 4, 8, HTTP.CR, 11, 0, 4, 5, 1, 2, 9, 3, 12, 14, 6, 15, 10, 7, 12, 9, 11, 1, 8, 14, 2, 4, 7, 3, 6, 5, 10, 0, 15, HTTP.CR, 10, 9, 6, 8, HTTP.CR, 14, 2, 0, 15, 3, 5, 11, 4, 1, 12, 7, 7, 4, 0, 5, 10, 2, 15, 14, 12, 6, 1, 11, HTTP.CR, 9, 3, 8};
        ESbox_D = new byte[]{15, 12, 2, 10, 6, 4, 5, 0, 7, 9, 14, HTTP.CR, 1, 11, 8, 3, 11, 6, 3, 4, 12, 15, 14, 2, 7, HTTP.CR, 8, 0, 5, 10, 9, 1, 1, 12, 11, 0, 15, 14, 6, 5, 10, HTTP.CR, 4, 8, 9, 3, 7, 2, 1, 5, 14, 12, 10, 7, 0, HTTP.CR, 6, 2, 11, 4, 9, 3, 15, 8, 0, 12, 8, 9, HTTP.CR, 2, 10, 11, 7, 3, 6, 5, 4, 14, 15, 1, 8, 0, 15, 3, 2, 5, 14, 11, 1, 10, 4, 7, 12, 9, HTTP.CR, 6, 3, 0, 6, 15, 1, 14, 9, 2, HTTP.CR, 8, 12, 4, 11, 10, 5, 7, 1, 10, 6, 8, 15, 11, 0, 4, 12, 3, 5, 9, 7, HTTP.CR, 2, 14};
        Param_Z = new byte[]{12, 4, 6, 2, 10, 5, 11, 9, 14, 8, HTTP.CR, 7, 0, 3, 15, 1, 6, 8, 2, 3, 9, 10, 5, 12, 1, 14, 4, 7, 11, HTTP.CR, 0, 15, 11, 3, 5, 8, 2, 15, 10, HTTP.CR, 14, 1, 7, 4, 12, 9, 6, 0, 12, 8, 2, 1, HTTP.CR, 4, 15, 6, 7, 0, 10, 5, 3, 14, 9, 11, 7, 15, 5, 10, 8, 1, 6, HTTP.CR, 0, 9, 3, 14, 11, 4, 2, 12, 5, HTTP.CR, 15, 6, 9, 2, 12, 10, 11, 7, 8, 1, 4, 3, 14, 0, 8, 14, 2, 5, 6, 9, 1, 12, 15, 4, 11, 0, HTTP.CR, 10, 3, 7, 1, 7, 14, HTTP.CR, 0, 5, 8, 3, 4, 15, 10, 6, 9, 12, 11, 2};
        DSbox_Test = new byte[]{4, 10, 9, 2, HTTP.CR, 8, 0, 14, 6, 11, 1, 12, 7, 15, 5, 3, 14, 11, 4, 12, 6, HTTP.CR, 15, 10, 2, 3, 8, 1, 0, 7, 5, 9, 5, 8, 1, HTTP.CR, 10, 3, 4, 2, 14, 15, 12, 7, 6, 0, 9, 11, 7, HTTP.CR, 10, 1, 0, 8, 9, 15, 14, 4, 6, 12, 11, 2, 5, 3, 6, 12, 7, 1, 5, 15, HTTP.CR, 8, 4, 10, 9, 14, 0, 3, 11, 2, 4, 11, 10, 0, 7, 2, 1, HTTP.CR, 3, 6, 8, 5, 9, 12, 15, 14, HTTP.CR, 11, 4, 1, 3, 15, 5, 9, 0, 10, 14, 7, 6, 8, 2, 12, 1, 15, HTTP.CR, 0, 5, 7, 10, 4, 9, 2, 3, 14, 6, 11, 8, 12};
        DSbox_A = new byte[]{10, 4, 5, 6, 8, 1, 3, 7, HTTP.CR, 12, 14, 0, 9, 2, 11, 15, 5, 15, 4, 0, 2, HTTP.CR, 11, 9, 1, 7, 6, 3, 12, 14, 10, 8, 7, 15, 12, 14, 9, 4, 1, 0, 3, 11, 5, 2, 6, 10, 8, HTTP.CR, 4, 10, 7, 12, 0, 15, 2, 8, 14, 1, 6, 5, HTTP.CR, 11, 9, 3, 7, 6, 4, 11, 9, 12, 2, 10, 1, 8, 0, 14, 15, HTTP.CR, 3, 5, 7, 6, 2, 4, HTTP.CR, 9, 15, 0, 10, 1, 5, 11, 8, 14, 12, 3, HTTP.CR, 14, 4, 1, 7, 0, 5, 10, 3, 12, 8, 15, 6, 2, 9, 11, 1, 3, 10, 9, 5, 11, 4, 15, 8, 6, 7, 14, HTTP.CR, 0, 2, 12};
        sBoxes = new Hashtable();
        addSBox("Default", Sbox_Default);
        addSBox("E-TEST", ESbox_Test);
        addSBox("E-A", ESbox_A);
        addSBox("E-B", ESbox_B);
        addSBox("E-C", ESbox_C);
        addSBox("E-D", ESbox_D);
        addSBox("Param-Z", Param_Z);
        addSBox("D-TEST", DSbox_Test);
        addSBox("D-A", DSbox_A);
    }

    public GOST28147Engine() {
        this.workingKey = null;
        this.S = Sbox_Default;
    }

    private void GOST28147Func(int[] r100, byte[] r110, int r111, byte[] r112, int r113) {
        int r101 = bytesToint(r110, r111);
        int r114 = bytesToint(r110, r111 + 4);
        int r102 = 7;
        if (this.forEncryption == false) goto L13;
        int r115 = 0;
    L5:
        if (r115 >= 3) goto L10;
        int r103 = 0;
    L7:
        if (r103 >= 8) goto L9;
        int r116 = r114 ^ GOST28147_mainStep(r101, r100[r103]);
        r103 = r103 + 1;
        int r104 = r101;
        r101 = r116;
        r114 = r104;
        goto L7
    L9:
        r115 = r115 + 1;
        goto L5
    L10:
        int r117 = r114;
        int r118 = r101;
    L11:
        if (r102 <= 0) goto L26;
        int r119 = r117 ^ GOST28147_mainStep(r118, r100[r102]);
        r102 = r102 - 1;
        r117 = r118;
        r118 = r119;
    L26:
        int r105 = GOST28147_mainStep(r118, r100[0]) ^ r117;
        intTobytes(r118, r112, r113);
        intTobytes(r105, r112, r113 + 4);
        return;
    L13:
        int r120 = 0;
    L14:
        if (r120 >= 8) goto L16;
        int r121 = r114 ^ GOST28147_mainStep(r101, r100[r120]);
        r120 = r120 + 1;
        int r106 = r101;
        r101 = r121;
        r114 = r106;
        goto L14
    L16:
        r117 = r114;
        r118 = r101;
        int r107 = 0;
    L17:
        if (r107 >= 3) goto L26;
        int r108 = 7;
    L19:
        if (r108 < 0) goto L25;
        if (r107 != 2) goto L24;
        if (r108 == 0) goto L25;
    L24:
        int r122 = r117 ^ GOST28147_mainStep(r118, r100[r108]);
        r108 = r108 - 1;
        r117 = r118;
        r118 = r122;
    L25:
        r107 = r107 + 1;
        goto L17
    }

    private int GOST28147_mainStep(int r100, int r101) {
        int r102 = r101 + r100;
        byte[] r103 = this.S;
        int r104 = (((((((r103[((r102 >> 0) & 15) + 0] << 0) + (r103[((r102 >> 4) & 15) + 16] << 4)) + (r103[((r102 >> 8) & 15) + 32] << 8)) + (r103[((r102 >> 12) & 15) + 48] << 12)) + (r103[((r102 >> 16) & 15) + 64] << 16)) + (r103[((r102 >> 20) & 15) + 80] << 20)) + (r103[((r102 >> 24) & 15) + 96] << 24)) + (r103[((r102 >> 28) & 15) + 112] << 28);
        return (r104 << 11) | (r104 >>> 21);
    }

    private static void addSBox(String r100, byte[] r101) {
        sBoxes.put(Strings.toUpperCase(r100), r101);
    }

    private int bytesToint(byte[] r100, int r101) {
        return ((((r100[r101 + 3] << 24) & (-16777216)) + ((r100[r101 + 2] << 16) & 16711680)) + ((r100[r101 + 1] << 8) & 65280)) + (r100[r101] & UByte.MAX_VALUE);
    }

    private int[] generateWorkingKey(boolean r100, byte[] r101) {
        this.forEncryption = r100;
        if (r101.length != 32) goto L9;
        int[] r102 = new int[8];
        int r103 = 0;
    L5:
        if (r103 == 8) goto L7;
        r102[r103] = bytesToint(r101, r103 * 4);
        r103 = r103 + 1;
        goto L5
    L7:
        return r102;
    L9:
        throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
    }

    public static byte[] getSBox(String r100) {
        byte[] r101 = (byte[]) sBoxes.get(Strings.toUpperCase(r100));
        if (r101 == null) goto L7;
        return Arrays.clone(r101);
    L7:
        throw new IllegalArgumentException("Unknown S-Box - possible types: \"Default\", \"E-Test\", \"E-A\", \"E-B\", \"E-C\", \"E-D\", \"Param-Z\", \"D-Test\", \"D-A\".");
    }

    public static String getSBoxName(byte[] r100) {
        Enumeration r101 = sBoxes.keys();
    L4:
        if (r101.hasMoreElements() == false) goto L9;
        String r102 = (String) r101.nextElement();
        if (Arrays.areEqual((byte[]) sBoxes.get(r102), r100) == false) goto L4;
        return r102;
    L9:
        throw new IllegalArgumentException("SBOX provided did not map to a known one");
    }

    private void intTobytes(int r100, byte[] r101, int r102) {
        r101[r102 + 3] = (byte) (r100 >>> 24);
        r101[r102 + 2] = (byte) (r100 >>> 16);
        r101[r102 + 1] = (byte) (r100 >>> 8);
        r101[r102] = (byte) r100;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public String getAlgorithmName() {
        return "GOST28147";
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithSBox) == false) goto L12;
        ParametersWithSBox r102 = (ParametersWithSBox) r101;
        byte[] r103 = r102.getSBox();
        if (r103.length != Sbox_Default.length) goto L10;
        this.S = Arrays.clone(r103);
        if (r102.getParameters() == null) goto L15;
        this.workingKey = generateWorkingKey(r100, ((KeyParameter) r102.getParameters()).getKey());
        return;
    L15:
        return;
    L10:
        throw new IllegalArgumentException("invalid S-box passed to GOST28147 init");
    L12:
        if ((r101 instanceof KeyParameter) == false) goto L14;
        this.workingKey = generateWorkingKey(r100, ((KeyParameter) r101).getKey());
        return;
    L14:
        if (r101 != null) goto L17;
        return;
    L17:
        throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - ".concat(r101.getClass().getName()));
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public int processBlock(byte[] r100, int r101, byte[] r102, int r110) {
        int[] r103 = this.workingKey;
        if (r103 == null) goto L15;
        if ((r101 + 8) > r100.length) goto L13;
        if ((r110 + 8) > r102.length) goto L11;
        GOST28147Func(r103, r100, r101, r102, r110);
        return 8;
    L11:
        throw new OutputLengthException("output buffer too short");
    L13:
        throw new DataLengthException("input buffer too short");
    L15:
        throw new IllegalStateException("GOST28147 engine not initialised");
    }

    @Override // org.bouncycastle.crypto.BlockCipher
    public void reset() {
    }
}
