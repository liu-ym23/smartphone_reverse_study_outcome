package org.bouncycastle.crypto.engines;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Wrapper;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public class DSTU7624WrapEngine implements Wrapper {
    private static final int BYTES_IN_INTEGER = 4;
    private byte[] B;
    private ArrayList<byte[]> Btemp;
    private byte[] checkSumArray;
    private DSTU7624Engine engine;
    private boolean forWrapping;
    private byte[] intArray;
    private byte[] zeroArray;

    public DSTU7624WrapEngine(int r100) {
        DSTU7624Engine r101 = new DSTU7624Engine(r100);
        this.engine = r101;
        this.B = new byte[r101.getBlockSize() / 2];
        this.checkSumArray = new byte[this.engine.getBlockSize()];
        this.zeroArray = new byte[this.engine.getBlockSize()];
        this.Btemp = new ArrayList();
        this.intArray = new byte[4];
    }

    private void intToBytes(int r100, byte[] r101, int r102) {
        r101[r102 + 3] = (byte) (r100 >> 24);
        r101[r102 + 2] = (byte) (r100 >> 16);
        r101[r102 + 1] = (byte) (r100 >> 8);
        r101[r102] = (byte) r100;
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public String getAlgorithmName() {
        return "DSTU7624WrapEngine";
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public void init(boolean r100, CipherParameters r101) {
        if ((r101 instanceof ParametersWithRandom) == false) goto L5;
        r101 = ((ParametersWithRandom) r101).getParameters();
    L5:
        this.forWrapping = r100;
        if ((r101 instanceof KeyParameter) == false) goto L10;
        this.engine.init(r100, r101);
        return;
    L10:
        throw new IllegalArgumentException("invalid parameters passed to DSTU7624WrapEngine");
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] unwrap(byte[] r110, int r111, int r112) throws InvalidCipherTextException {
        if (this.forWrapping == true) goto L31;
        if ((r112 % this.engine.getBlockSize()) != 0) goto L29;
        int r100 = (r112 * 2) / this.engine.getBlockSize();
        int r101 = r100 - 1;
        int r102 = r101 * 6;
        byte[] r103 = new byte[r112];
        System.arraycopy(r110, r111, r103, 0, r112);
        byte[] r113 = new byte[this.engine.getBlockSize() / 2];
        System.arraycopy(r103, 0, r113, 0, this.engine.getBlockSize() / 2);
        this.Btemp.clear();
        int r104 = r112 - (this.engine.getBlockSize() / 2);
        int r105 = this.engine.getBlockSize() / 2;
    L7:
        if (r104 == 0) goto L9;
        byte[] r106 = new byte[this.engine.getBlockSize() / 2];
        System.arraycopy(r103, r105, r106, 0, this.engine.getBlockSize() / 2);
        this.Btemp.add(r106);
        r104 = r104 - (this.engine.getBlockSize() / 2);
        r105 = r105 + (this.engine.getBlockSize() / 2);
        goto L7
    L9:
        int r107 = 0;
    L10:
        if (r107 >= r102) goto L19;
        System.arraycopy(ListProtector.get(this.Btemp, r100 - 2), 0, r103, 0, this.engine.getBlockSize() / 2);
        System.arraycopy(r113, 0, r103, this.engine.getBlockSize() / 2, this.engine.getBlockSize() / 2);
        intToBytes(r102 - r107, this.intArray, 0);
        int r108 = 0;
    L13:
        if (r108 >= 4) goto L15;
        int r109 = (this.engine.getBlockSize() / 2) + r108;
        r103[r109] = (byte) (r103[r109] ^ this.intArray[r108]);
        r108 = r108 + 1;
        goto L13
    L15:
        this.engine.processBlock(r103, 0, r103, 0);
        System.arraycopy(r103, 0, r113, 0, this.engine.getBlockSize() / 2);
        int r114 = 2;
    L16:
        if (r114 >= r100) goto L18;
        int r115 = r100 - r114;
        System.arraycopy(ListProtector.get(this.Btemp, r115 - 1), 0, ListProtector.get(this.Btemp, r115), 0, this.engine.getBlockSize() / 2);
        r114 = r114 + 1;
        goto L16
    L18:
        System.arraycopy(r103, this.engine.getBlockSize() / 2, ListProtector.get(this.Btemp, 0), 0, this.engine.getBlockSize() / 2);
        r107 = r107 + 1;
        goto L10
    L19:
        System.arraycopy(r113, 0, r103, 0, this.engine.getBlockSize() / 2);
        int r116 = this.engine.getBlockSize() / 2;
        int r117 = 0;
    L20:
        if (r117 >= r101) goto L22;
        System.arraycopy(ListProtector.get(this.Btemp, r117), 0, r103, r116, this.engine.getBlockSize() / 2);
        r116 = r116 + (this.engine.getBlockSize() / 2);
        r117 = r117 + 1;
        goto L20
    L22:
        System.arraycopy(r103, r112 - this.engine.getBlockSize(), this.checkSumArray, 0, this.engine.getBlockSize());
        byte[] r118 = new byte[r112 - this.engine.getBlockSize()];
        if (Arrays.areEqual(this.checkSumArray, this.zeroArray) == false) goto L27;
        System.arraycopy(r103, 0, r118, 0, r112 - this.engine.getBlockSize());
        return r118;
    L27:
        throw new InvalidCipherTextException("checksum failed");
    L29:
        throw new DataLengthException("unwrap data must be a multiple of " + this.engine.getBlockSize() + " bytes");
    L31:
        throw new IllegalStateException("not set for unwrapping");
    }

    @Override // org.bouncycastle.crypto.Wrapper
    public byte[] wrap(byte[] r100, int r110, int r111) {
        if (this.forWrapping == false) goto L30;
        if ((r111 % this.engine.getBlockSize()) != 0) goto L28;
        if ((r110 + r111) > r100.length) goto L26;
        int r101 = ((r111 / this.engine.getBlockSize()) + 1) * 2;
        int r102 = r101 - 1;
        int r103 = r102 * 6;
        int r104 = this.engine.getBlockSize() + r111;
        byte[] r105 = new byte[r104];
        System.arraycopy(r100, r110, r105, 0, r111);
        System.arraycopy(r105, 0, this.B, 0, this.engine.getBlockSize() / 2);
        this.Btemp.clear();
        int r106 = r104 - (this.engine.getBlockSize() / 2);
        int r107 = this.engine.getBlockSize() / 2;
    L9:
        if (r106 == 0) goto L11;
        byte[] r112 = new byte[this.engine.getBlockSize() / 2];
        System.arraycopy(r105, r107, r112, 0, this.engine.getBlockSize() / 2);
        this.Btemp.add(r112);
        r106 = r106 - (this.engine.getBlockSize() / 2);
        r107 = r107 + (this.engine.getBlockSize() / 2);
        goto L9
    L11:
        int r108 = 0;
    L12:
        if (r108 >= r103) goto L21;
        System.arraycopy(this.B, 0, r105, 0, this.engine.getBlockSize() / 2);
        System.arraycopy(ListProtector.get(this.Btemp, 0), 0, r105, this.engine.getBlockSize() / 2, this.engine.getBlockSize() / 2);
        this.engine.processBlock(r105, 0, r105, 0);
        r108 = r108 + 1;
        intToBytes(r108, this.intArray, 0);
        int r113 = 0;
    L15:
        if (r113 >= 4) goto L17;
        int r114 = (this.engine.getBlockSize() / 2) + r113;
        r105[r114] = (byte) (r105[r114] ^ this.intArray[r113]);
        r113 = r113 + 1;
        goto L15
    L17:
        System.arraycopy(r105, this.engine.getBlockSize() / 2, this.B, 0, this.engine.getBlockSize() / 2);
        int r115 = 2;
    L18:
        if (r115 >= r101) goto L20;
        System.arraycopy(ListProtector.get(this.Btemp, r115 - 1), 0, ListProtector.get(this.Btemp, r115 - 2), 0, this.engine.getBlockSize() / 2);
        r115 = r115 + 1;
        goto L18
    L20:
        System.arraycopy(r105, 0, ListProtector.get(this.Btemp, r101 - 2), 0, this.engine.getBlockSize() / 2);
        goto L12
    L21:
        System.arraycopy(this.B, 0, r105, 0, this.engine.getBlockSize() / 2);
        int r109 = this.engine.getBlockSize() / 2;
        int r116 = 0;
    L22:
        if (r116 >= r102) goto L24;
        System.arraycopy(ListProtector.get(this.Btemp, r116), 0, r105, r109, this.engine.getBlockSize() / 2);
        r109 = r109 + (this.engine.getBlockSize() / 2);
        r116 = r116 + 1;
        goto L22
    L24:
        return r105;
    L26:
        throw new DataLengthException("input buffer too short");
    L28:
        throw new DataLengthException("wrap data must be a multiple of " + this.engine.getBlockSize() + " bytes");
    L30:
        throw new IllegalStateException("not set for wrapping");
    }
}
