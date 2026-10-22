package org.bouncycastle.pqc.crypto.rainbow;

import java.lang.reflect.Array;
import java.security.SecureRandom;
import org.bouncycastle.crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.KeyGenerationParameters;
import org.bouncycastle.pqc.crypto.rainbow.util.ComputeInField;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;

/* JADX INFO: loaded from: classes42.dex */
public class RainbowKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    private short[][] A1;
    private short[][] A1inv;
    private short[][] A2;
    private short[][] A2inv;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    private short[] f525581b1;

    /* JADX INFO: renamed from: b2, reason: collision with root package name */
    private short[] f525582b2;
    private boolean initialized;
    private Layer[] layers;
    private int numOfLayers;
    private short[][] pub_quadratic;
    private short[] pub_scalar;
    private short[][] pub_singular;
    private RainbowKeyGenerationParameters rainbowParams;

    /* JADX INFO: renamed from: sr, reason: collision with root package name */
    private SecureRandom f525583sr;

    /* JADX INFO: renamed from: vi, reason: collision with root package name */
    private int[] f525584vi;

    public RainbowKeyPairGenerator() {
        this.initialized = false;
    }

    private void compactPublicKey(short[][][] r110) {
        int r100 = r110.length;
        int r101 = r110[0].length;
        this.pub_quadratic = (short[][]) Array.newInstance(Short.TYPE, new int[]{r100, ((r101 + 1) * r101) / 2});
        int r102 = 0;
    L3:
        if (r102 >= r100) goto L15;
        int r103 = 0;
        int r104 = 0;
    L5:
        if (r103 >= r101) goto L14;
        int r105 = r103;
    L7:
        if (r105 >= r101) goto L13;
        short[][] r106 = this.pub_quadratic;
        if (r105 != r103) goto L11;
        r106[r102][r104] = r110[r102][r103][r105];
    L12:
        r104 = r104 + 1;
        r105 = r105 + 1;
        goto L7
    L11:
        short[] r107 = r106[r102];
        short[][] r108 = r110[r102];
        r107[r104] = GF2Field.addElem(r108[r103][r105], r108[r105][r103]);
        goto L12
    L13:
        r103 = r103 + 1;
        goto L5
    L14:
        r102 = r102 + 1;
        goto L3
    }

    private void computePublicKey() {
        ComputeInField r100 = new ComputeInField();
        int[] r101 = this.f525584vi;
        int r102 = 0;
        int r103 = r101[r101.length - 1] - r101[0];
        int r104 = r101[r101.length - 1];
        short[][][] r105 = (short[][][]) Array.newInstance(Short.TYPE, new int[]{r103, r104, r104});
        this.pub_singular = (short[][]) Array.newInstance(Short.TYPE, new int[]{r103, r104});
        this.pub_scalar = new short[r103];
        short[] r106 = new short[r104];
        int r107 = 0;
        int r110 = 0;
    L3:
        Layer[] r111 = this.layers;
        if (r107 >= r111.length) goto L25;
        short[][][] r112 = r111[r107].getCoeffAlpha();
        short[][][] r113 = this.layers[r107].getCoeffBeta();
        short[][] r114 = this.layers[r107].getCoeffGamma();
        short[] r115 = this.layers[r107].getCoeffEta();
        int r116 = r112[r102].length;
        int r108 = r113[r102].length;
    L6:
        if (r102 >= r116) goto L24;
        int r109 = 0;
    L8:
        if (r109 >= r116) goto L13;
        int r117 = 0;
    L10:
        if (r117 >= r108) goto L12;
        int r118 = r103;
        int r119 = r104;
        int r120 = r109 + r108;
        short[] r121 = r100.multVect(r112[r102][r109][r117], this.A2[r120]);
        int r122 = r110 + r102;
        int r123 = r107;
        r105[r122] = r100.addSquareMatrix(r105[r122], r100.multVects(r121, this.A2[r117]));
        short[] r124 = r100.multVect(this.f525582b2[r117], r121);
        short[][] r125 = this.pub_singular;
        r125[r122] = r100.addVect(r124, r125[r122]);
        short[] r126 = r100.multVect(this.f525582b2[r120], r100.multVect(r112[r102][r109][r117], this.A2[r117]));
        short[][] r127 = this.pub_singular;
        r127[r122] = r100.addVect(r126, r127[r122]);
        short r128 = GF2Field.multElem(r112[r102][r109][r117], this.f525582b2[r120]);
        short[] r129 = this.pub_scalar;
        r129[r122] = GF2Field.addElem(r129[r122], GF2Field.multElem(r128, this.f525582b2[r117]));
        r117 = r117 + 1;
        r104 = r119;
        r103 = r118;
        r112 = r112;
        r107 = r123;
        r115 = r115;
        goto L10
    L12:
        r109 = r109 + 1;
        goto L8
    L13:
        int r130 = r104;
        int r131 = r103;
        int r132 = r107;
        short[][][] r133 = r112;
        short[] r210 = r115;
        int r134 = 0;
    L14:
        if (r134 >= r108) goto L19;
        int r135 = 0;
    L16:
        if (r135 >= r108) goto L18;
        short[] r136 = r100.multVect(r113[r102][r134][r135], this.A2[r134]);
        int r137 = r110 + r102;
        r105[r137] = r100.addSquareMatrix(r105[r137], r100.multVects(r136, this.A2[r135]));
        short[] r138 = r100.multVect(this.f525582b2[r135], r136);
        short[][] r139 = this.pub_singular;
        r139[r137] = r100.addVect(r138, r139[r137]);
        short[] r140 = r100.multVect(this.f525582b2[r134], r100.multVect(r113[r102][r134][r135], this.A2[r135]));
        short[][] r141 = this.pub_singular;
        r141[r137] = r100.addVect(r140, r141[r137]);
        short r142 = GF2Field.multElem(r113[r102][r134][r135], this.f525582b2[r134]);
        short[] r143 = this.pub_scalar;
        r143[r137] = GF2Field.addElem(r143[r137], GF2Field.multElem(r142, this.f525582b2[r135]));
        r135 = r135 + 1;
        goto L16
    L18:
        r134 = r134 + 1;
        goto L14
    L19:
        int r144 = 0;
    L21:
        if (r144 >= (r108 + r116)) goto L23;
        short[] r145 = r100.multVect(r114[r102][r144], this.A2[r144]);
        short[][] r146 = this.pub_singular;
        int r147 = r110 + r102;
        r146[r147] = r100.addVect(r145, r146[r147]);
        short[] r148 = this.pub_scalar;
        r148[r147] = GF2Field.addElem(r148[r147], GF2Field.multElem(r114[r102][r144], this.f525582b2[r144]));
        r144 = r144 + 1;
        goto L21
    L23:
        short[] r149 = this.pub_scalar;
        int r150 = r110 + r102;
        r149[r150] = GF2Field.addElem(r149[r150], r210[r102]);
        r102 = r102 + 1;
        r104 = r130;
        r103 = r131;
        r112 = r133;
        r107 = r132;
        r115 = r210;
        goto L6
    L24:
        r110 = r110 + r116;
        r107 = r107 + 1;
        r102 = 0;
        goto L3
    L25:
        int r151 = r104;
        int r152 = r103;
        short[][][] r153 = (short[][][]) Array.newInstance(Short.TYPE, new int[]{r152, r151, r151});
        short[][] r154 = (short[][]) Array.newInstance(Short.TYPE, new int[]{r152, r151});
        short[] r155 = new short[r152];
        int r156 = 0;
    L26:
        if (r156 >= r152) goto L32;
        int r157 = 0;
    L28:
        short[][] r158 = this.A1;
        if (r157 >= r158.length) goto L31;
        r153[r156] = r100.addSquareMatrix(r153[r156], r100.multMatrix(r158[r156][r157], r105[r157]));
        r154[r156] = r100.addVect(r154[r156], r100.multVect(this.A1[r156][r157], this.pub_singular[r157]));
        r155[r156] = GF2Field.addElem(r155[r156], GF2Field.multElem(this.A1[r156][r157], this.pub_scalar[r157]));
        r157 = r157 + 1;
        goto L28
    L31:
        r155[r156] = GF2Field.addElem(r155[r156], this.f525581b1[r156]);
        r156 = r156 + 1;
        goto L26
    L32:
        this.pub_singular = r154;
        this.pub_scalar = r155;
        compactPublicKey(r153);
    }

    private void generateF() {
        this.layers = new Layer[this.numOfLayers];
        int r100 = 0;
    L4:
        if (r100 >= this.numOfLayers) goto L6;
        Layer[] r101 = this.layers;
        int[] r102 = this.f525584vi;
        int r103 = r100 + 1;
        r101[r100] = new Layer(r102[r100], r102[r103], this.f525583sr);
        r100 = r103;
        goto L4
    }

    private void generateL1() {
        int[] r100 = this.f525584vi;
        int r101 = 0;
        int r102 = r100[r100.length - 1] - r100[0];
        this.A1 = (short[][]) Array.newInstance(Short.TYPE, new int[]{r102, r102});
        this.A1inv = null;
        ComputeInField r103 = new ComputeInField();
    L4:
        if (this.A1inv != null) goto L12;
        int r104 = 0;
    L6:
        if (r104 >= r102) goto L11;
        int r105 = 0;
    L8:
        if (r105 >= r102) goto L10;
        this.A1[r104][r105] = (short) (this.f525583sr.nextInt() & 255);
        r105 = r105 + 1;
        goto L8
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        this.A1inv = r103.inverse(this.A1);
        goto L4
    L12:
        this.f525581b1 = new short[r102];
    L13:
        if (r101 >= r102) goto L15;
        this.f525581b1[r101] = (short) (this.f525583sr.nextInt() & 255);
        r101 = r101 + 1;
        goto L13
    }

    private void generateL2() {
        int[] r100 = this.f525584vi;
        int r101 = r100[r100.length - 1];
        int r102 = 0;
        this.A2 = (short[][]) Array.newInstance(Short.TYPE, new int[]{r101, r101});
        this.A2inv = null;
        ComputeInField r103 = new ComputeInField();
    L4:
        if (this.A2inv != null) goto L12;
        int r104 = 0;
    L6:
        if (r104 >= r101) goto L11;
        int r105 = 0;
    L8:
        if (r105 >= r101) goto L10;
        this.A2[r104][r105] = (short) (this.f525583sr.nextInt() & 255);
        r105 = r105 + 1;
        goto L8
    L10:
        r104 = r104 + 1;
        goto L6
    L11:
        this.A2inv = r103.inverse(this.A2);
        goto L4
    L12:
        this.f525582b2 = new short[r101];
    L13:
        if (r102 >= r101) goto L15;
        this.f525582b2[r102] = (short) (this.f525583sr.nextInt() & 255);
        r102 = r102 + 1;
        goto L13
    }

    private void initializeDefault() {
        initialize(new RainbowKeyGenerationParameters(CryptoServicesRegistrar.getSecureRandom(), new RainbowParameters()));
    }

    private void keygen() {
        generateL1();
        generateL2();
        generateF();
        computePublicKey();
    }

    public AsymmetricCipherKeyPair genKeyPair() {
        if (this.initialized == true) goto L5;
        initializeDefault();
    L5:
        keygen();
        RainbowPrivateKeyParameters r100 = new RainbowPrivateKeyParameters(this.A1inv, this.f525581b1, this.A2inv, this.f525582b2, this.f525584vi, this.layers);
        int[] r101 = this.f525584vi;
        return new AsymmetricCipherKeyPair(new RainbowPublicKeyParameters(r101[r101.length - 1] - r101[0], this.pub_quadratic, this.pub_singular, this.pub_scalar), r100);
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        return genKeyPair();
    }

    @Override // org.bouncycastle.crypto.AsymmetricCipherKeyPairGenerator
    public void init(KeyGenerationParameters r100) {
        initialize(r100);
    }

    public void initialize(KeyGenerationParameters r100) {
        RainbowKeyGenerationParameters r101 = (RainbowKeyGenerationParameters) r100;
        this.rainbowParams = r101;
        this.f525583sr = r101.getRandom();
        this.f525584vi = this.rainbowParams.getParameters().getVi();
        this.numOfLayers = this.rainbowParams.getParameters().getNumOfLayers();
        this.initialized = true;
    }
}
