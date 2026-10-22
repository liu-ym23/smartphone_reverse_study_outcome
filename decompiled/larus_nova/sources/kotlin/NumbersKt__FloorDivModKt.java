package kotlin;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0007H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\b*\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0002*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0004*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0015\u0010\u0006\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b¨\u0006\t"}, d2 = {"floorDiv", "", "", "other", "", "", "mod", "", "", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/NumbersKt")
class NumbersKt__FloorDivModKt extends NumbersKt__BigIntegersKt {
    public NumbersKt__FloorDivModKt() {
    }

    private static final long floorDiv(byte r100, long r101) {
        long r102 = r100;
        long r103 = r102 / r101;
        if ((r102 ^ r101) < 0) goto L5;
        return r103;
    L5:
        if ((r101 * r103) != r102) goto L7;
        return r103;
    L7:
        return r103 - 1;
    }

    private static final double mod(double r100, float r110) {
        double r101 = r110;
        double r102 = r100 % r101;
        boolean r111 = true;
        if (r102 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        return r102;
    L8:
        if (Math.signum(r102) == Math.signum(r101)) goto L11;
        r111 = false;
    L11:
        if (r111 == false) goto L13;
        return r102;
    L13:
        return r102 + r101;
    L5:
        r103 = false;
        goto L6
    }

    private static final long floorDiv(int r100, long r101) {
        long r102 = r100;
        long r103 = r102 / r101;
        if ((r102 ^ r101) < 0) goto L5;
        return r103;
    L5:
        if ((r101 * r103) != r102) goto L7;
        return r103;
    L7:
        return r103 - 1;
    }

    private static final double mod(float r100, double r101) {
        double r102 = ((double) r100) % r101;
        boolean r103 = true;
        if (r102 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return r102;
    L8:
        if (Math.signum(r102) == Math.signum(r101)) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L13;
        return r102;
    L13:
        return r102 + r101;
    L5:
        r104 = false;
        goto L6
    }

    private static final long floorDiv(long r100, byte r110) {
        long r101 = r110;
        long r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final double mod(double r100, double r101) {
        double r102 = r100 % r101;
        boolean r103 = true;
        if (r102 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return r102;
    L8:
        if (Math.signum(r102) == Math.signum(r101)) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L13;
        return r102;
    L13:
        return r102 + r101;
    L5:
        r104 = false;
        goto L6
    }

    private static final long floorDiv(long r100, int r110) {
        long r101 = r110;
        long r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final float mod(float r100, float r101) {
        float r102 = r100 % r101;
        boolean r103 = true;
        if (r102 != 0.0f) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == false) goto L8;
        return r102;
    L8:
        if (Math.signum(r102) == Math.signum(r101)) goto L11;
        r103 = false;
    L11:
        if (r103 == false) goto L13;
        return r102;
    L13:
        return r102 + r101;
    L5:
        r104 = false;
        goto L6
    }

    private static final long floorDiv(long r100, short r110) {
        long r101 = r110;
        long r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final byte mod(long r100, byte r101) {
        long r102 = r101;
        long r103 = r100 % r102;
        return (byte) (r103 + (r102 & (((r103 ^ r102) & ((-r103) | r103)) >> 63)));
    }

    private static final long floorDiv(short r100, long r101) {
        long r102 = r100;
        long r103 = r102 / r101;
        if ((r102 ^ r101) < 0) goto L5;
        return r103;
    L5:
        if ((r101 * r103) != r102) goto L7;
        return r103;
    L7:
        return r103 - 1;
    }

    private static final short mod(long r100, short r101) {
        long r102 = r101;
        long r103 = r100 % r102;
        return (short) (r103 + (r102 & (((r103 ^ r102) & ((-r103) | r103)) >> 63)));
    }

    private static final long floorDiv(long r100, long r101) {
        long r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final int mod(long r100, int r101) {
        long r102 = r101;
        long r103 = r100 % r102;
        return (int) (r103 + (r102 & (((r103 ^ r102) & ((-r103) | r103)) >> 63)));
    }

    private static final int floorDiv(byte r100, byte r101) {
        int r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final long mod(byte r100, long r101) {
        long r102 = ((long) r100) % r101;
        return r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 63));
    }

    private static final int floorDiv(byte r100, int r101) {
        int r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final long mod(int r100, long r101) {
        long r102 = ((long) r100) % r101;
        return r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 63));
    }

    private static final int floorDiv(byte r100, short r101) {
        int r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final long mod(short r100, long r101) {
        long r102 = ((long) r100) % r101;
        return r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 63));
    }

    private static final int floorDiv(int r100, byte r101) {
        int r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final byte mod(byte r100, byte r101) {
        int r102 = r100 % r101;
        return (byte) (r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 31)));
    }

    private static final int floorDiv(int r100, int r101) {
        int r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final byte mod(int r100, byte r101) {
        int r102 = r100 % r101;
        return (byte) (r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 31)));
    }

    private static final int floorDiv(int r100, short r101) {
        int r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final byte mod(short r100, byte r101) {
        int r102 = r100 % r101;
        return (byte) (r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 31)));
    }

    private static final int floorDiv(short r100, byte r101) {
        int r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final long mod(long r100, long r101) {
        long r102 = r100 % r101;
        return r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 63));
    }

    private static final int floorDiv(short r100, int r101) {
        int r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final short mod(byte r100, short r101) {
        int r102 = r100 % r101;
        return (short) (r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 31)));
    }

    private static final int floorDiv(short r100, short r101) {
        int r102 = r100 / r101;
        if ((r100 ^ r101) < 0) goto L5;
        return r102;
    L5:
        if ((r101 * r102) != r100) goto L7;
        return r102;
    L7:
        return r102 - 1;
    }

    private static final short mod(int r100, short r101) {
        int r102 = r100 % r101;
        return (short) (r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 31)));
    }

    private static final short mod(short r100, short r101) {
        int r102 = r100 % r101;
        return (short) (r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 31)));
    }

    private static final int mod(byte r100, int r101) {
        int r102 = r100 % r101;
        return r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 31));
    }

    private static final int mod(int r100, int r101) {
        int r102 = r100 % r101;
        return r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 31));
    }

    private static final int mod(short r100, int r101) {
        int r102 = r100 % r101;
        return r102 + (r101 & (((r102 ^ r101) & ((-r102) | r102)) >> 31));
    }
}
