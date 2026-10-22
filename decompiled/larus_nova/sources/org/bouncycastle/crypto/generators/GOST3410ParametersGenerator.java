package org.bouncycastle.crypto.generators;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.crypto.params.GOST3410Parameters;
import org.bouncycastle.crypto.params.GOST3410ValidationParameters;
import org.bouncycastle.util.BigIntegers;

/* JADX INFO: loaded from: classes42.dex */
public class GOST3410ParametersGenerator {
    private static final BigInteger ONE = null;
    private static final BigInteger TWO = null;
    private SecureRandom init_random;
    private int size;
    private int typeproc;

    static {
        ONE = BigInteger.valueOf(1);
        TWO = BigInteger.valueOf(2);
    }

    public GOST3410ParametersGenerator() {
    }

    private int procedure_A(int r110, int r210, BigInteger[] r211, int r212) {
        int r100 = r110;
    L4:
        if (r100 < 0) goto L48;
        if (r100 > 65536) goto L48;
        int r101 = r210;
    L10:
        if (r101 < 0) goto L47;
        if (r101 > 65536) goto L47;
        if ((r101 / 2) == 0) goto L47;
        BigInteger r102 = new BigInteger(Integer.toString(r101));
        BigInteger r103 = new BigInteger("19381");
        BigInteger r104 = new BigInteger(Integer.toString(r100));
        int r105 = 0;
        BigInteger[] r106 = {r104};
        int[] r107 = {r212};
        int r108 = 0;
        int r109 = 0;
    L17:
        if (r107[r108] < 17) goto L19;
        int r111 = r107.length + 1;
        int[] r112 = new int[r111];
        System.arraycopy(r107, 0, r112, 0, r107.length);
        r107 = new int[r111];
        System.arraycopy(r112, 0, r107, 0, r111);
        r109 = r108 + 1;
        r107[r109] = r107[r108] / 2;
        r108 = r109;
        goto L17
    L19:
        BigInteger[] r113 = new BigInteger[r109 + 1];
        int r114 = 16;
        r113[r109] = new BigInteger("8003", 16);
        int r115 = r109 - 1;
        int r116 = 0;
    L20:
        if (r116 >= r109) goto L46;
        int r117 = r107[r115] / r114;
    L22:
        int r118 = r106.length;
        BigInteger[] r119 = new BigInteger[r118];
        System.arraycopy(r106, r105, r119, r105, r106.length);
        BigInteger[] r120 = new BigInteger[r117 + 1];
        System.arraycopy(r119, r105, r120, r105, r118);
        int r121 = 0;
    L23:
        if (r121 >= r117) goto L25;
        int r122 = r121 + 1;
        r120[r122] = r120[r121].multiply(r103).add(r102).mod(TWO.pow(r114));
        r121 = r122;
        goto L23
    L25:
        BigInteger r123 = new BigInteger("0");
        int r124 = 0;
    L26:
        if (r124 >= r117) goto L28;
        r123 = r123.add(r120[r124].multiply(TWO.pow(r124 * 16)));
        r124 = r124 + 1;
        goto L26
    L28:
        r120[r105] = r120[r117];
        BigInteger r125 = TWO;
        int r126 = r115 + 1;
        BigInteger r127 = r125.pow(r107[r115] - 1).divide(r113[r126]).add(r125.pow(r107[r115] - 1).multiply(r123).divide(r113[r126].multiply(r125.pow(r117 * 16))));
        BigInteger r128 = r127.mod(r125);
        BigInteger r129 = ONE;
        if (r128.compareTo(r129) != 0) goto L31;
        r127 = r127.add(r129);
    L31:
        int r130 = 0;
    L32:
        BigInteger r131 = r102;
        BigInteger r132 = r103;
        long r133 = r130;
        int r213 = r109;
        BigInteger r134 = r113[r126].multiply(r127.add(BigInteger.valueOf(r133)));
        BigInteger r135 = ONE;
        BigInteger r136 = r134.add(r135);
        r113[r115] = r136;
        BigInteger r137 = TWO;
        int r138 = r117;
        if (r136.compareTo(r137.pow(r107[r115])) == 1) goto L34;
        if (r137.modPow(r113[r126].multiply(r127.add(BigInteger.valueOf(r133))), r113[r115]).compareTo(r135) != 0) goto L45;
        if (r137.modPow(r127.add(BigInteger.valueOf(r133)), r113[r115]).compareTo(r135) == 0) goto L45;
        r115 = r115 - 1;
        if (r115 < 0) goto L42;
        r116 = r116 + 1;
        r109 = r213;
        r103 = r132;
        r106 = r120;
        r102 = r131;
        r105 = 0;
        r114 = 16;
        goto L20
    L42:
        r211[0] = r113[0];
        r211[1] = r113[1];
        BigInteger r139 = r120[0];
    L44:
        return r139.intValue();
    L45:
        r130 = r130 + 2;
        r109 = r213;
        r103 = r132;
        r102 = r131;
        r117 = r138;
        goto L32
    L34:
        r109 = r213;
        r103 = r132;
        r106 = r120;
        r102 = r131;
        r117 = r138;
        r105 = 0;
        r114 = 16;
        goto L22
    L46:
        r139 = r106[0];
    L47:
        r101 = (this.init_random.nextInt() / 32768) + 1;
    L48:
        r100 = this.init_random.nextInt() / 32768;
        goto L4
    }

    private long procedure_Aa(long r110, long r210, BigInteger[] r211, int r212) {
        long r100 = r110;
    L4:
        if (r100 < 0) goto L49;
        if (r100 > 4294967296L) goto L49;
        long r101 = r210;
    L10:
        if (r101 < 0) goto L48;
        if (r101 > 4294967296L) goto L48;
        if ((r101 / 2) == 0) goto L48;
        BigInteger r102 = new BigInteger(Long.toString(r101));
        BigInteger r103 = new BigInteger("97781173");
        BigInteger r104 = new BigInteger(Long.toString(r100));
        int r105 = 0;
        BigInteger[] r106 = {r104};
        int[] r107 = {r212};
        int r108 = 0;
        int r109 = 0;
    L18:
        if (r107[r108] < 33) goto L20;
        int r111 = r107.length + 1;
        int[] r112 = new int[r111];
        System.arraycopy(r107, 0, r112, 0, r107.length);
        r107 = new int[r111];
        System.arraycopy(r112, 0, r107, 0, r111);
        r109 = r108 + 1;
        r107[r109] = r107[r108] / 2;
        r108 = r109;
        goto L18
    L20:
        BigInteger[] r113 = new BigInteger[r109 + 1];
        r113[r109] = new BigInteger("8000000B", 16);
        int r114 = r109 - 1;
        int r115 = 0;
    L21:
        if (r115 >= r109) goto L47;
        int r116 = 32;
        int r117 = r107[r114] / 32;
    L23:
        int r118 = r106.length;
        BigInteger[] r119 = new BigInteger[r118];
        System.arraycopy(r106, r105, r119, r105, r106.length);
        BigInteger[] r120 = new BigInteger[r117 + 1];
        System.arraycopy(r119, r105, r120, r105, r118);
        int r121 = 0;
    L24:
        if (r121 >= r117) goto L26;
        int r122 = r121 + 1;
        r120[r122] = r120[r121].multiply(r103).add(r102).mod(TWO.pow(r116));
        r121 = r122;
        goto L24
    L26:
        BigInteger r123 = new BigInteger("0");
        int r124 = 0;
    L27:
        if (r124 >= r117) goto L29;
        r123 = r123.add(r120[r124].multiply(TWO.pow(r124 * 32)));
        r124 = r124 + 1;
        goto L27
    L29:
        r120[r105] = r120[r117];
        BigInteger r125 = TWO;
        int r126 = r114 + 1;
        BigInteger r127 = r125.pow(r107[r114] - 1).divide(r113[r126]).add(r125.pow(r107[r114] - 1).multiply(r123).divide(r113[r126].multiply(r125.pow(r117 * 32))));
        BigInteger r128 = r127.mod(r125);
        BigInteger r129 = ONE;
        if (r128.compareTo(r129) != 0) goto L32;
        r127 = r127.add(r129);
    L32:
        int r130 = 0;
    L33:
        long r131 = r130;
        BigInteger r213 = r102;
        BigInteger r132 = r113[r126].multiply(r127.add(BigInteger.valueOf(r131)));
        BigInteger r133 = ONE;
        BigInteger r134 = r132.add(r133);
        r113[r114] = r134;
        BigInteger r135 = r103;
        BigInteger r136 = TWO;
        int r214 = r109;
        if (r134.compareTo(r136.pow(r107[r114])) == 1) goto L35;
        if (r136.modPow(r113[r126].multiply(r127.add(BigInteger.valueOf(r131))), r113[r114]).compareTo(r133) != 0) goto L46;
        if (r136.modPow(r127.add(BigInteger.valueOf(r131)), r113[r114]).compareTo(r133) == 0) goto L46;
        r114 = r114 - 1;
        if (r114 < 0) goto L43;
        r115 = r115 + 1;
        r102 = r213;
        r109 = r214;
        r106 = r120;
        r103 = r135;
        r105 = 0;
        goto L21
    L43:
        r211[0] = r113[0];
        r211[1] = r113[1];
        BigInteger r137 = r120[0];
    L45:
        return r137.longValue();
    L46:
        r130 = r130 + 2;
        r102 = r213;
        r109 = r214;
        r103 = r135;
        goto L33
    L35:
        r102 = r213;
        r109 = r214;
        r106 = r120;
        r103 = r135;
        r105 = 0;
        r116 = 32;
        goto L23
    L47:
        r137 = r106[0];
    L48:
        r101 = (this.init_random.nextInt() * 2) + 1;
    L49:
        r100 = this.init_random.nextInt() * 2;
        goto L4
    }

    private void procedure_B(int r110, int r111, BigInteger[] r112) {
        int r100 = r110;
    L4:
        if (r100 < 0) goto L38;
        if (r100 > 65536) goto L38;
        int r101 = r111;
    L10:
        if (r101 < 0) goto L37;
        if (r101 > 65536) goto L37;
        if ((r101 / 2) == 0) goto L37;
        BigInteger[] r102 = new BigInteger[2];
        BigInteger r103 = new BigInteger(Integer.toString(r101));
        BigInteger r104 = new BigInteger("19381");
        int r105 = procedure_A(r100, r101, r102, 256);
        char r106 = 0;
        BigInteger r107 = r102[0];
        int r108 = procedure_A(r105, r101, r102, 512);
        BigInteger r109 = r102[0];
        BigInteger[] r113 = new BigInteger[65];
        r113[0] = new BigInteger(Integer.toString(r108));
    L16:
        int r114 = 0;
    L18:
        if (r114 >= 64) goto L20;
        int r115 = r114 + 1;
        r113[r115] = r113[r114].multiply(r104).add(r103).mod(TWO.pow(16));
        r114 = r115;
        goto L18
    L20:
        BigInteger r116 = new BigInteger("0");
        int r117 = 0;
    L21:
        if (r117 >= 64) goto L23;
        r116 = r116.add(r113[r117].multiply(TWO.pow(r117 * 16)));
        r117 = r117 + 1;
        goto L21
    L23:
        r113[r106] = r113[64];
        BigInteger r118 = TWO;
        int r119 = 1024;
        BigInteger r120 = r118.pow(1023).divide(r107.multiply(r109)).add(r118.pow(1023).multiply(r116).divide(r107.multiply(r109).multiply(r118.pow(1024))));
        BigInteger r121 = r120.mod(r118);
        BigInteger r122 = ONE;
        if (r121.compareTo(r122) != 0) goto L26;
        r120 = r120.add(r122);
    L26:
        BigInteger r123 = r120;
        int r124 = 0;
    L27:
        long r125 = r124;
        BigInteger r126 = r107.multiply(r109).multiply(r123.add(BigInteger.valueOf(r125)));
        BigInteger r127 = ONE;
        BigInteger r128 = r126.add(r127);
        BigInteger r129 = TWO;
        if (r128.compareTo(r129.pow(r119)) == 1) goto L29;
        if (r129.modPow(r107.multiply(r109).multiply(r123.add(BigInteger.valueOf(r125))), r128).compareTo(r127) != 0) goto L36;
        if (r129.modPow(r107.multiply(r123.add(BigInteger.valueOf(r125))), r128).compareTo(r127) == 0) goto L36;
        r112[0] = r128;
        r112[1] = r107;
        return;
    L36:
        r124 = r124 + 2;
        r119 = 1024;
        goto L27
    L29:
        r106 = 0;
    L37:
        r101 = (this.init_random.nextInt() / 32768) + 1;
    L38:
        r100 = this.init_random.nextInt() / 32768;
        goto L4
    }

    private void procedure_Bb(long r110, long r111, BigInteger[] r210) {
        long r100 = r110;
    L4:
        if (r100 < 0) goto L39;
        if (r100 > 4294967296L) goto L39;
        long r101 = r111;
    L10:
        if (r101 < 0) goto L38;
        if (r101 > 4294967296L) goto L38;
        if ((r101 / 2) == 0) goto L38;
        BigInteger[] r112 = new BigInteger[2];
        BigInteger r113 = new BigInteger(Long.toString(r101));
        BigInteger r114 = new BigInteger("97781173");
        long r102 = r101;
        long r103 = procedure_Aa(r100, r102, r112, 256);
        char r115 = 0;
        BigInteger r116 = r112[0];
        long r104 = procedure_Aa(r103, r102, r112, 512);
        BigInteger r105 = r112[0];
        BigInteger[] r106 = new BigInteger[33];
        r106[0] = new BigInteger(Long.toString(r104));
    L17:
        int r107 = 0;
    L19:
        if (r107 >= 32) goto L21;
        int r108 = r107 + 1;
        r106[r108] = r106[r107].multiply(r114).add(r113).mod(TWO.pow(32));
        r107 = r108;
        goto L19
    L21:
        BigInteger r109 = new BigInteger("0");
        int r117 = 0;
    L22:
        if (r117 >= 32) goto L24;
        r109 = r109.add(r106[r117].multiply(TWO.pow(r117 * 32)));
        r117 = r117 + 1;
        goto L22
    L24:
        r106[r115] = r106[32];
        BigInteger r118 = TWO;
        int r119 = 1024;
        BigInteger r120 = r118.pow(1023).divide(r116.multiply(r105)).add(r118.pow(1023).multiply(r109).divide(r116.multiply(r105).multiply(r118.pow(1024))));
        BigInteger r121 = r120.mod(r118);
        BigInteger r122 = ONE;
        if (r121.compareTo(r122) != 0) goto L27;
        r120 = r120.add(r122);
    L27:
        int r123 = 0;
    L28:
        long r124 = r123;
        BigInteger r125 = r116.multiply(r105).multiply(r120.add(BigInteger.valueOf(r124)));
        BigInteger r126 = ONE;
        BigInteger r127 = r125.add(r126);
        BigInteger r128 = TWO;
        if (r127.compareTo(r128.pow(r119)) == 1) goto L30;
        if (r128.modPow(r116.multiply(r105).multiply(r120.add(BigInteger.valueOf(r124))), r127).compareTo(r126) != 0) goto L37;
        if (r128.modPow(r116.multiply(r120.add(BigInteger.valueOf(r124))), r127).compareTo(r126) == 0) goto L37;
        r210[0] = r127;
        r210[1] = r116;
        return;
    L37:
        r123 = r123 + 2;
        r119 = 1024;
        goto L28
    L30:
        r115 = 0;
    L38:
        r101 = (this.init_random.nextInt() * 2) + 1;
    L39:
        r100 = this.init_random.nextInt() * 2;
        goto L4
    }

    private BigInteger procedure_C(BigInteger r100, BigInteger r101) {
        BigInteger r102 = r100.subtract(ONE);
        BigInteger r103 = r102.divide(r101);
        int r104 = r100.bitLength();
    L3:
        BigInteger r105 = BigIntegers.createRandomBigInteger(r104, this.init_random);
        BigInteger r106 = ONE;
        if (r105.compareTo(r106) <= 0) goto L3;
        if (r105.compareTo(r102) >= 0) goto L3;
        BigInteger r107 = r105.modPow(r103, r100);
        if (r107.compareTo(r106) == 0) goto L3;
        return r107;
    }

    public GOST3410Parameters generateParameters() {
        BigInteger[] r100 = new BigInteger[2];
        if (this.typeproc != 1) goto L13;
        int r101 = this.init_random.nextInt();
        int r102 = this.init_random.nextInt();
        int r103 = this.size;
        if (r103 == 512) goto L10;
        if (r103 != 1024) goto L9;
        procedure_B(r101, r102, r100);
    L11:
        BigInteger r104 = r100[0];
        BigInteger r105 = r100[1];
        return new GOST3410Parameters(r104, r105, procedure_C(r104, r105), new GOST3410ValidationParameters(r101, r102));
    L9:
        throw new IllegalArgumentException("Ooops! key size 512 or 1024 bit.");
    L10:
        procedure_A(r101, r102, r100, 512);
        goto L11
    L13:
        long r110 = this.init_random.nextLong();
        long r111 = this.init_random.nextLong();
        int r106 = this.size;
        if (r106 == 512) goto L19;
        if (r106 != 1024) goto L18;
        procedure_Bb(r110, r111, r100);
    L20:
        BigInteger r107 = r100[0];
        BigInteger r108 = r100[1];
        return new GOST3410Parameters(r107, r108, procedure_C(r107, r108), new GOST3410ValidationParameters(r110, r111));
    L18:
        throw new IllegalStateException("Ooops! key size 512 or 1024 bit.");
    L19:
        procedure_Aa(r110, r111, r100, 512);
        goto L20
    }

    public void init(int r100, int r101, SecureRandom r102) {
        this.size = r100;
        this.typeproc = r101;
        this.init_random = r102;
    }
}
