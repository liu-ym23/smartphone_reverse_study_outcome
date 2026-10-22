package org.apache.commons.imaging.common;

import androidx.camera.video.AudioStats;
import androidx.collection.SieveCacheKt;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes42.dex */
public class RationalNumber extends Number {
    private static final long serialVersionUID = -8412262656468158691L;
    public final int divisor;
    public final int numerator;

    public static final class Option {
        public final double error;
        public final RationalNumber rationalNumber;

        public String toString() {
            return this.rationalNumber.toString();
        }

        private Option(RationalNumber r100, double r101) {
            this.rationalNumber = r100;
            this.error = r101;
        }

        public static Option factory(RationalNumber r100, double r101) {
            return new Option(r100, Math.abs(r100.doubleValue() - r101));
        }
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.divisor);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.numerator / this.divisor;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.numerator / this.divisor;
    }

    @Override // java.lang.Number
    public long longValue() {
        return ((long) this.numerator) / ((long) this.divisor);
    }

    public RationalNumber negate() {
        return new RationalNumber(-this.numerator, this.divisor);
    }

    public String toDisplayString() {
        int r100 = this.numerator;
        int r101 = this.divisor;
        if ((r100 % r101) == 0) goto L5;
        NumberFormat r102 = NumberFormat.getInstance();
        r102.setMaximumFractionDigits(3);
        return r102.format(((double) this.numerator) / ((double) this.divisor));
    L5:
        return Integer.toString(r100 / r101);
    }

    public String toString() {
        if (this.divisor == 0) goto L5;
        NumberFormat r100 = NumberFormat.getInstance();
        int r101 = this.numerator;
        int r102 = this.divisor;
        if ((r101 % r102) != 0) goto L11;
        return r100.format(r101 / r102);
    L11:
        return this.numerator + HTTP.URL_DEFAULT + this.divisor + " (" + r100.format(((double) this.numerator) / ((double) this.divisor)) + ")";
    L5:
        return "Invalid rational (" + this.numerator + HTTP.URL_DEFAULT + this.divisor + ")";
    }

    public static RationalNumber valueOf(double r110) {
        if (r110 < 2.147483647E9d) goto L7;
        return new RationalNumber(Integer.MAX_VALUE, 1);
    L7:
        if (r110 <= (-2.147483647E9d)) goto L9;
        int r100 = 0;
        if (r110 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
        r110 = Math.abs(r110);
        boolean r101 = true;
    L15:
        if (r110 != AudioStats.AUDIO_AMPLITUDE_NONE) goto L19;
        return new RationalNumber(0, 1);
    L19:
        if (r110 < 1.0d) goto L24;
        int r102 = (int) r110;
        if (r102 >= r110) goto L23;
        RationalNumber r103 = new RationalNumber(r102, 1);
        RationalNumber r104 = new RationalNumber(r102 + 1, 1);
    L29:
        Option r105 = Option.factory(r103, r110);
        Option r106 = Option.factory(r104, r110);
        if (r105.error >= r106.error) goto L32;
        Option r107 = r105;
    L34:
        if (r107.error <= 1.0E-8d) goto L51;
        if (r100 >= 100) goto L51;
        RationalNumber r108 = r105.rationalNumber;
        long r109 = r108.numerator;
        RationalNumber r111 = r106.rationalNumber;
        RationalNumber r112 = factoryMethod(r109 + ((long) r111.numerator), ((long) r108.divisor) + ((long) r111.divisor));
        Option r113 = Option.factory(r112, r110);
        if (r110 >= r112.doubleValue()) goto L44;
        if (r106.error <= r113.error) goto L51;
        r106 = r113;
    L48:
        if (r113.error >= r107.error) goto L50;
        r107 = r113;
    L50:
        r100 = r100 + 1;
        goto L34
    L44:
        if (r105.error <= r113.error) goto L51;
        r105 = r113;
    L51:
        RationalNumber r114 = r107.rationalNumber;
        if (r101 == true) goto L54;
        return r114;
    L54:
        return r114.negate();
    L32:
        r107 = r106;
        goto L34
    L23:
        r103 = new RationalNumber(r102 - 1, 1);
        r104 = new RationalNumber(r102, 1);
        goto L29
    L24:
        int r115 = (int) (1.0d / r110);
        if ((1.0d / ((double) r115)) >= r110) goto L27;
        r103 = new RationalNumber(1, r115);
        RationalNumber r116 = new RationalNumber(1, r115 - 1);
    L28:
        r104 = r116;
        goto L29
    L27:
        r103 = new RationalNumber(1, r115 + 1);
        r116 = new RationalNumber(1, r115);
        goto L28
    L13:
        r101 = false;
        goto L15
    L9:
        return new RationalNumber(-2147483647, 1);
    }

    public RationalNumber(int r100, int r101) {
        this.numerator = r100;
        this.divisor = r101;
    }

    public static RationalNumber factoryMethod(long r100, long r110) {
        if (r100 > SieveCacheKt.NodeLinkMask) goto L11;
        if (r100 < SieveCacheKt.NodeMetaAndPreviousMask) goto L11;
        if (r110 > SieveCacheKt.NodeLinkMask) goto L11;
        if (r110 < SieveCacheKt.NodeMetaAndPreviousMask) goto L11;
    L25:
        long r101 = gcd(r100, r110);
        return new RationalNumber((int) (r100 / r101), (int) (r110 / r101));
    L11:
        if (r100 > SieveCacheKt.NodeLinkMask) goto L19;
        if (r100 < SieveCacheKt.NodeMetaAndPreviousMask) goto L19;
        if (r110 > SieveCacheKt.NodeLinkMask) goto L19;
        if (r110 < SieveCacheKt.NodeMetaAndPreviousMask) goto L19;
    L24:
        if (r110 != 0) goto L25;
        throw new NumberFormatException("Invalid value, numerator: " + r100 + ", divisor: " + r110);
    L19:
        if (Math.abs(r100) <= 1) goto L24;
        if (Math.abs(r110) <= 1) goto L24;
        r100 = r100 >> 1;
        r110 = r110 >> 1;
        goto L11
    }

    private static long gcd(long r100, long r101) {
        if (r101 != 0) goto L6;
        return r100;
    L6:
        return gcd(r101, r100 % r101);
    }
}
