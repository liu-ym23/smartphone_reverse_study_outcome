package com.bytedance.fresco.encoder;

import com.obric.sva.sdk.data.ISmModel;
import kotlin.UByte;

/* JADX INFO: loaded from: classes19.dex */
class NeuQuant {
    protected static final int alphabiasshift = 10;
    protected static final int alpharadbias = 262144;
    protected static final int alpharadbshift = 18;
    protected static final int beta = 64;
    protected static final int betagamma = 65536;
    protected static final int betashift = 10;
    protected static final int gamma = 1024;
    protected static final int gammashift = 10;
    protected static final int initalpha = 1024;
    protected static final int initrad = 32;
    protected static final int initradius = 2048;
    protected static final int intbias = 65536;
    protected static final int intbiasshift = 16;
    protected static final int maxnetpos = 255;
    protected static final int minpicturebytes = 1509;
    protected static final int ncycles = 100;
    protected static final int netbiasshift = 4;
    protected static final int netsize = 256;
    protected static final int prime1 = 499;
    protected static final int prime2 = 491;
    protected static final int prime3 = 487;
    protected static final int prime4 = 503;
    protected static final int radbias = 256;
    protected static final int radbiasshift = 8;
    protected static final int radiusbias = 64;
    protected static final int radiusbiasshift = 6;
    protected static final int radiusdec = 30;
    protected int alphadec;
    protected int[] bias;
    protected int[] freq;
    protected int lengthcount;
    protected int[] netindex;
    protected int[][] network;
    protected int[] radpower;
    protected int samplefac;
    protected byte[] thepicture;

    public void inxbuild() {
        int r100 = 0;
        int r101 = 0;
        int r102 = 0;
    L4:
        if (r100 >= 256) goto L21;
        int[] r103 = this.network[r100];
        int r104 = r103[1];
        int r105 = r100 + 1;
        int r110 = r100;
        int r106 = r105;
    L6:
        if (r106 >= 256) goto L11;
        int r111 = this.network[r106][1];
        if (r111 >= r104) goto L10;
        r110 = r106;
        r104 = r111;
    L10:
        r106 = r106 + 1;
        goto L6
    L11:
        int[] r107 = this.network[r110];
        if (r100 == r110) goto L14;
        int r108 = r107[0];
        r107[0] = r103[0];
        r103[0] = r108;
        int r109 = r107[1];
        r107[1] = r103[1];
        r103[1] = r109;
        int r112 = r107[2];
        r107[2] = r103[2];
        r103[2] = r112;
        int r113 = r107[3];
        r107[3] = r103[3];
        r103[3] = r113;
    L14:
        if (r104 == r101) goto L20;
        this.netindex[r101] = (r102 + r100) >> 1;
    L16:
        r101 = r101 + 1;
        if (r101 >= r104) goto L19;
        this.netindex[r101] = r100;
        goto L16
    L19:
        r102 = r100;
        r101 = r104;
    L20:
        r100 = r105;
        goto L4
    L21:
        this.netindex[r101] = (r102 + 255) >> 1;
        int r114 = r101 + 1;
    L22:
        if (r114 >= 256) goto L24;
        this.netindex[r114] = 255;
        r114 = r114 + 1;
        goto L22
    }

    public void unbiasnet() {
        int r100 = 0;
    L4:
        if (r100 >= 256) goto L6;
        int[] r101 = this.network[r100];
        r101[0] = r101[0] >> 4;
        r101[1] = r101[1] >> 4;
        r101[2] = r101[2] >> 4;
        r101[3] = r100;
        r100 = r100 + 1;
        goto L4
    }

    public byte[] colorMap() {
        byte[] r100 = new byte[ISmModel.VERSION_0300];
        int[] r101 = new int[256];
        int r102 = 0;
    L3:
        if (r102 >= 256) goto L5;
        r101[this.network[r102][3]] = r102;
        r102 = r102 + 1;
        goto L3
    L5:
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r103 >= 256) goto L8;
        int r105 = r101[r103];
        int r106 = r104 + 1;
        int[] r107 = this.network[r105];
        r100[r104] = (byte) r107[0];
        int r108 = r106 + 1;
        r100[r106] = (byte) r107[1];
        r100[r108] = (byte) r107[2];
        r103 = r103 + 1;
        r104 = r108 + 1;
        goto L6
    L8:
        return r100;
    }

    public void learn() {
        int r100 = this.lengthcount;
        if (r100 >= 1509) goto L5;
        this.samplefac = 1;
    L5:
        int r101 = this.samplefac;
        this.alphadec = ((r101 - 1) / 3) + 30;
        byte[] r102 = this.thepicture;
        int r110 = r100 / (r101 * 3);
        int r103 = r110 / 100;
        int r104 = 0;
    L7:
        if (r104 >= 32) goto L9;
        this.radpower[r104] = 1024 * (((1024 - (r104 * r104)) * 256) / 1024);
        r104 = r104 + 1;
        goto L7
    L9:
        int r105 = this.lengthcount;
        if (r105 >= 1509) goto L13;
        int r111 = 3;
    L22:
        int r112 = r103;
        int r106 = 0;
        int r113 = 2048;
        int r114 = 1024;
        int r115 = 32;
        int r116 = 0;
    L23:
        if (r106 >= r110) goto L42;
        int r107 = (r102[r116 + 0] & UByte.MAX_VALUE) << 4;
        int r108 = (r102[r116 + 1] & UByte.MAX_VALUE) << 4;
        int r109 = (r102[r116 + 2] & UByte.MAX_VALUE) << 4;
        int r117 = contest(r107, r108, r109);
        int r210 = r106;
        altersingle(r114, r117, r107, r108, r109);
        if (r115 == 0) goto L27;
        alterneigh(r115, r117, r107, r108, r109);
    L27:
        int r118 = r116 + r111;
        if (r118 < r100) goto L30;
        r118 = r118 - this.lengthcount;
    L30:
        r116 = r118;
        r106 = r210 + 1;
        if (r112 != 0) goto L34;
        r112 = 1;
    L34:
        if ((r106 % r112) != 0) goto L23;
        r114 = r114 - (r114 / this.alphadec);
        r113 = r113 - (r113 / 30);
        int r119 = r113 >> 6;
        if (r119 > 1) goto L38;
        r119 = 0;
    L38:
        int r120 = 0;
    L39:
        if (r120 >= r119) goto L41;
        int r121 = r119 * r119;
        this.radpower[r120] = (((r121 - (r120 * r120)) * 256) / r121) * r114;
        r120 = r120 + 1;
        goto L39
    L41:
        r115 = r119;
        goto L23
    L42:
        return;
    L13:
        if ((r105 % 499) == 0) goto L16;
        r111 = 1497;
        goto L22
    L16:
        if ((r105 % 491) == 0) goto L19;
        r111 = 1473;
        goto L22
    L19:
        if ((r105 % 487) == 0) goto L21;
        r111 = 1461;
        goto L22
    L21:
        r111 = 1509;
        goto L22
    }

    public byte[] process() {
        learn();
        unbiasnet();
        inxbuild();
        return colorMap();
    }

    public NeuQuant(byte[] r100, int r101, int r102) {
        this.netindex = new int[256];
        this.bias = new int[256];
        this.freq = new int[256];
        this.radpower = new int[32];
        this.thepicture = r100;
        this.lengthcount = r101;
        this.samplefac = r102;
        this.network = new int[256][];
        int r103 = 0;
    L3:
        if (r103 >= 256) goto L5;
        this.network[r103] = new int[]{r6, r6, r6, 0};
        int r104 = (r103 << 12) / 256;
        this.freq[r103] = 256;
        this.bias[r103] = 0;
        r103 = r103 + 1;
        goto L3
    }

    public int contest(int r110, int r111, int r112) {
        int r100 = Integer.MAX_VALUE;
        int r101 = Integer.MAX_VALUE;
        int r102 = -1;
        int r103 = -1;
        int r104 = 0;
    L4:
        if (r104 >= 256) goto L21;
        int[] r105 = this.network[r104];
        int r106 = r105[0] - r110;
        if (r106 >= 0) goto L8;
        r106 = -r106;
    L8:
        int r107 = r105[1] - r111;
        if (r107 >= 0) goto L11;
        r107 = -r107;
    L11:
        int r108 = r106 + r107;
        int r109 = r105[2] - r112;
        if (r109 >= 0) goto L14;
        r109 = -r109;
    L14:
        int r113 = r108 + r109;
        if (r113 >= r100) goto L17;
        r102 = r104;
        r100 = r113;
    L17:
        int[] r114 = this.bias;
        int r115 = r113 - (r114[r104] >> 12);
        if (r115 >= r101) goto L20;
        r103 = r104;
        r101 = r115;
    L20:
        int[] r116 = this.freq;
        int r117 = r116[r104];
        int r118 = r117 >> 10;
        r116[r104] = r117 - r118;
        r114[r104] = r114[r104] + (r118 << 10);
        r104 = r104 + 1;
        goto L4
    L21:
        int[] r119 = this.freq;
        r119[r102] = r119[r102] + 64;
        int[] r120 = this.bias;
        r120[r102] = r120[r102] - 65536;
        return r103;
    }

    public int map(int r110, int r111, int r112) {
        int r100 = this.netindex[r111];
        int r101 = r100 - 1;
        int r102 = 1000;
        int r103 = -1;
    L4:
        if (r100 < 256) goto L9;
        if (r101 >= 0) goto L9;
        return r103;
    L9:
        if (r100 >= 256) goto L27;
        int[] r113 = this.network[r100];
        int r114 = r113[1] - r111;
        if (r114 < r102) goto L13;
        r100 = 256;
        goto L27
    L13:
        r100 = r100 + 1;
        if (r114 >= 0) goto L16;
        r114 = -r114;
    L16:
        int r104 = r113[0] - r110;
        if (r104 >= 0) goto L19;
        r104 = -r104;
    L19:
        int r115 = r114 + r104;
        if (r115 >= r102) goto L27;
        int r105 = r113[2] - r112;
        if (r105 >= 0) goto L24;
        r105 = -r105;
    L24:
        int r116 = r115 + r105;
        if (r116 >= r102) goto L27;
        r103 = r113[3];
        r102 = r116;
    L27:
        if (r101 < 0) goto L4;
        int[] r106 = this.network[r101];
        int r107 = r111 - r106[1];
        if (r107 >= r102) goto L30;
        r101 = r101 - 1;
        if (r107 >= 0) goto L34;
        r107 = -r107;
    L34:
        int r108 = r106[0] - r110;
        if (r108 >= 0) goto L37;
        r108 = -r108;
    L37:
        int r109 = r107 + r108;
        if (r109 >= r102) goto L4;
        int r117 = r106[2] - r112;
        if (r117 >= 0) goto L42;
        r117 = -r117;
    L42:
        int r118 = r117 + r109;
        if (r118 >= r102) goto L4;
        r103 = r106[3];
        r102 = r118;
        goto L4
    L30:
        r101 = -1;
        goto L4
    }

    public void alterneigh(int r110, int r111, int r112, int r113, int r114) {
        int r100 = r111 - r110;
        if (r100 >= (-1)) goto L5;
        r100 = -1;
    L5:
        int r101 = r111 + r110;
        if (r101 <= 256) goto L8;
        r101 = 256;
    L8:
        int r102 = r111 + 1;
        int r103 = r111 - 1;
        int r104 = 1;
    L9:
        if (r102 < r101) goto L13;
        if (r103 > r100) goto L13;
        return;
    L13:
        r104 = r104 + 1;
        int r105 = this.radpower[r104];
        if (r102 >= r101) goto L20;
        int r115 = r102 + 1;
        int[] r106 = this.network[r102];
        int r116 = r106[0];     // Catch: Exception -> L18
        r106[0] = r116 - (((r116 - r112) * r105) / 262144);     // Catch: Exception -> L18
        int r117 = r106[1];     // Catch: Exception -> L18
        r106[1] = r117 - (((r117 - r113) * r105) / 262144);     // Catch: Exception -> L18
        int r118 = r106[2];     // Catch: Exception -> L18
        r106[2] = r118 - (((r118 - r114) * r105) / 262144);     // Catch: Exception -> L18
    L19:
        r102 = r115;
    L20:
        if (r103 <= r100) goto L9;
        int r119 = r103 - 1;
        int[] r107 = this.network[r103];
        int r120 = r107[0];     // Catch: Exception -> L24
        r107[0] = r120 - (((r120 - r112) * r105) / 262144);     // Catch: Exception -> L24
        int r108 = r107[1];     // Catch: Exception -> L24
        r107[1] = r108 - (((r108 - r113) * r105) / 262144);     // Catch: Exception -> L24
        int r109 = r107[2];     // Catch: Exception -> L24
        r107[2] = r109 - ((r105 * (r109 - r114)) / 262144);     // Catch: Exception -> L24
    L25:
        r103 = r119;
        goto L9
    }

    public void altersingle(int r100, int r101, int r102, int r103, int r104) {
        int[] r105 = this.network[r101];
        int r106 = r105[0];
        r105[0] = r106 - (((r106 - r102) * r100) / 1024);
        int r107 = r105[1];
        r105[1] = r107 - (((r107 - r103) * r100) / 1024);
        int r108 = r105[2];
        r105[2] = r108 - ((r100 * (r108 - r104)) / 1024);
    }
}
