package org.apache.commons.lang3.math;

import androidx.camera.video.AudioStats;
import androidx.collection.SieveCacheKt;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.ttm.player.MediaPlayer;
import java.math.BigInteger;
import org.apache.commons.lang3.Validate;

/* JADX INFO: loaded from: classes42.dex */
public final class Fraction extends Number implements Comparable<Fraction> {
    public static final Fraction FOUR_FIFTHS = null;
    public static final Fraction ONE = null;
    public static final Fraction ONE_FIFTH = null;
    public static final Fraction ONE_HALF = null;
    public static final Fraction ONE_QUARTER = null;
    public static final Fraction ONE_THIRD = null;
    public static final Fraction THREE_FIFTHS = null;
    public static final Fraction THREE_QUARTERS = null;
    public static final Fraction TWO_FIFTHS = null;
    public static final Fraction TWO_QUARTERS = null;
    public static final Fraction TWO_THIRDS = null;
    public static final Fraction ZERO = null;
    private static final long serialVersionUID = 65382027393090L;
    private final int denominator;
    private transient int hashCode;
    private final int numerator;
    private transient String toProperString;
    private transient String toString;

    static {
        ZERO = new Fraction(0, 1);
        ONE = new Fraction(1, 1);
        ONE_HALF = new Fraction(1, 2);
        ONE_THIRD = new Fraction(1, 3);
        TWO_THIRDS = new Fraction(2, 3);
        ONE_QUARTER = new Fraction(1, 4);
        TWO_QUARTERS = new Fraction(2, 4);
        THREE_QUARTERS = new Fraction(3, 4);
        ONE_FIFTH = new Fraction(1, 5);
        TWO_FIFTHS = new Fraction(2, 5);
        THREE_FIFTHS = new Fraction(3, 5);
        FOUR_FIFTHS = new Fraction(4, 5);
    }

    public Fraction abs() {
        if (this.numerator < 0) goto L6;
        return this;
    L6:
        return negate();
    }

    @Override // java.lang.Number
    public double doubleValue() {
        return ((double) this.numerator) / ((double) this.denominator);
    }

    @Override // java.lang.Number
    public float floatValue() {
        return this.numerator / this.denominator;
    }

    public int getProperNumerator() {
        return Math.abs(this.numerator % this.denominator);
    }

    public int getProperWhole() {
        return this.numerator / this.denominator;
    }

    public int hashCode() {
        if (this.hashCode != 0) goto L6;
        this.hashCode = ((getNumerator() + MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_START_TIME) * 37) + getDenominator();
    L6:
        return this.hashCode;
    }

    @Override // java.lang.Number
    public int intValue() {
        return this.numerator / this.denominator;
    }

    public Fraction invert() {
        int r100 = this.numerator;
        if (r100 == 0) goto L14;
        if (r100 == Integer.MIN_VALUE) goto L12;
        if (r100 >= 0) goto L10;
        return new Fraction(-this.denominator, -r100);
    L10:
        return new Fraction(this.denominator, r100);
    L12:
        throw new ArithmeticException("overflow: can't negate numerator");
    L14:
        throw new ArithmeticException("Unable to invert zero.");
    }

    @Override // java.lang.Number
    public long longValue() {
        return ((long) this.numerator) / ((long) this.denominator);
    }

    public Fraction negate() {
        int r100 = this.numerator;
        if (r100 == Integer.MIN_VALUE) goto L7;
        return new Fraction(-r100, this.denominator);
    L7:
        throw new ArithmeticException("overflow: too large to negate");
    }

    public Fraction reduce() {
        int r100 = this.numerator;
        if (r100 != 0) goto L8;
        Fraction r101 = ZERO;
        if (equals(r101) == true) goto L7;
        return r101;
    L7:
        return this;
    L8:
        int r102 = greatestCommonDivisor(Math.abs(r100), this.denominator);
        if (r102 != 1) goto L12;
        return this;
    L12:
        return getFraction(this.numerator / r102, this.denominator / r102);
    }

    public String toProperString() {
        if (this.toProperString != null) goto L23;
        int r100 = this.numerator;
        if (r100 != 0) goto L7;
        this.toProperString = "0";
        goto L23
    L7:
        int r101 = this.denominator;
        if (r100 != r101) goto L11;
        this.toProperString = "1";
        goto L23
    L11:
        if (r100 != (r101 * (-1))) goto L13;
        this.toProperString = "-1";
        goto L23
    L13:
        if (r100 <= 0) goto L16;
        r100 = -r100;
    L16:
        if (r100 >= (-r101)) goto L21;
        int r102 = getProperNumerator();
        if (r102 != 0) goto L20;
        this.toProperString = Integer.toString(getProperWhole());
        goto L23
    L20:
        this.toProperString = getProperWhole() + " " + r102 + HTTP.URL_DEFAULT + getDenominator();
        goto L23
    L21:
        this.toProperString = getNumerator() + HTTP.URL_DEFAULT + getDenominator();
    L23:
        return this.toProperString;
    }

    public String toString() {
        if (this.toString != null) goto L6;
        this.toString = getNumerator() + HTTP.URL_DEFAULT + getDenominator();
    L6:
        return this.toString;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public static Fraction getFraction(double r210) {
        if (r210 >= AudioStats.AUDIO_AMPLITUDE_NONE) goto L5;
        int r100 = -1;
    L6:
        double r101 = Math.abs(r210);
        if (r101 > 2.147483647E9d) goto L25;
        if (Double.isNaN(r101) == true) goto L25;
        int r102 = (int) r101;
        double r103 = r101 - ((double) r102);
        int r104 = (int) r103;
        double r105 = r103 - ((double) r104);
        double r211 = r103;
        double r110 = Double.MAX_VALUE;
        int r106 = 1;
        int r111 = 1;
        int r112 = 1;
        double r113 = 1.0d;
        int r107 = 0;
        int r114 = 0;
    L11:
        int r108 = (int) (r113 / r105);
        double r109 = r113 - (((double) r108) * r105);
        int r115 = (r104 * r106) + r107;
        int r116 = (r104 * r114) + r111;
        double r117 = r105;
        double r118 = r211;
        double r119 = Math.abs(r118 - (((double) r115) / ((double) r116)));
        int r120 = r112 + 1;
        if (r110 <= r119) goto L19;
        if (r116 > 10000) goto L19;
        if (r116 <= 0) goto L19;
        if (r120 >= 25) goto L19;
        r110 = r119;
        r211 = r118;
        r111 = r114;
        r112 = r120;
        r105 = r109;
        r114 = r116;
        r104 = r108;
        r107 = r106;
        r106 = r115;
        r113 = r117;
    L19:
        if (r120 == 25) goto L23;
        return getReducedFraction((r106 + (r102 * r114)) * r100, r114);
    L23:
        throw new ArithmeticException("Unable to convert double to fraction");
    L25:
        throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
    L5:
        r100 = 1;
        goto L6
    }

    public Fraction add(Fraction r100) {
        return addSub(r100, true);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(Fraction r100) {
        if (this != r100) goto L5;
        return 0;
    L5:
        int r101 = this.numerator;
        int r102 = r100.numerator;
        if (r101 == r102) goto L8;
    L10:
        long r103 = ((long) r101) * ((long) r100.denominator);
        long r104 = ((long) r102) * ((long) this.denominator);
        if (r103 != r104) goto L13;
        return 0;
    L13:
        if (r103 >= r104) goto L16;
        return -1;
    L16:
        return 1;
    L8:
        if (this.denominator != r100.denominator) goto L10;
        return 0;
    }

    public Fraction divideBy(Fraction r100) {
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        Validate.isTrue(r101, "The fraction must not be null", new Object[0]);
        if (r100.numerator == 0) goto L11;
        return multiplyBy(r100.invert());
    L11:
        throw new ArithmeticException("The fraction to divide by must not be zero");
    L5:
        r101 = false;
        goto L6
    }

    public boolean equals(Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof Fraction) == true) goto L8;
        return false;
    L8:
        Fraction r101 = (Fraction) r100;
        if (getNumerator() == r101.getNumerator()) goto L11;
    L13:
        return false;
    L11:
        if (getDenominator() != r101.getDenominator()) goto L13;
        return true;
    }

    public Fraction multiplyBy(Fraction r100) {
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        Validate.isTrue(r101, "The fraction must not be null", new Object[0]);
        int r102 = this.numerator;
        if (r102 == 0) goto L14;
        if (r100.numerator == 0) goto L14;
        int r103 = greatestCommonDivisor(r102, r100.denominator);
        int r104 = greatestCommonDivisor(r100.numerator, this.denominator);
        return getReducedFraction(mulAndCheck(this.numerator / r103, r100.numerator / r104), mulPosAndCheck(this.denominator / r104, r100.denominator / r103));
    L14:
        return ZERO;
    L5:
        r101 = false;
        goto L6
    }

    public Fraction pow(int r100) {
        if (r100 != 1) goto L5;
        return this;
    L5:
        if (r100 != 0) goto L9;
        return ONE;
    L9:
        if (r100 < 0) goto L11;
        Fraction r101 = multiplyBy(this);
        if ((r100 % 2) != 0) goto L26;
        return r101.pow(r100 / 2);
    L26:
        return r101.pow(r100 / 2).multiplyBy(this);
    L24:
        th = move-exception;
        throw th;
    L11:
        if (r100 != Integer.MIN_VALUE) goto L15;
        return invert().pow(2).pow(-(r100 / 2));
    L15:
        return invert().pow(-r100);
    }

    public Fraction subtract(Fraction r100) {
        return addSub(r100, false);
    }

    public static Fraction getFraction(String r100) {
        if (r100 == null) goto L5;
        boolean r101 = true;
    L6:
        Validate.isTrue(r101, "The string must not be null", new Object[0]);
        if (r100.indexOf(46) >= 0) goto L9;
        int r102 = r100.indexOf(32);
        if (r102 <= 0) goto L18;
        int r103 = CastIntegerProtector.parseInt(r100.substring(0, r102));
        String r104 = r100.substring(r102 + 1);
        int r105 = r104.indexOf(47);
        if (r105 < 0) goto L17;
        return getFraction(r103, CastIntegerProtector.parseInt(r104.substring(0, r105)), CastIntegerProtector.parseInt(r104.substring(r105 + 1)));
    L17:
        throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
    L18:
        int r106 = r100.indexOf(47);
        if (r106 >= 0) goto L23;
        return getFraction(CastIntegerProtector.parseInt(r100), 1);
    L23:
        return getFraction(CastIntegerProtector.parseInt(r100.substring(0, r106)), CastIntegerProtector.parseInt(r100.substring(r106 + 1)));
    L9:
        return getFraction(CastDoubleProtector.parseDouble(r100));
    L5:
        r101 = false;
        goto L6
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Fraction r100) {
        return compareTo2(r100);
    }

    private Fraction(int r100, int r101) {
        this.hashCode = 0;
        this.toString = null;
        this.toProperString = null;
        this.numerator = r100;
        this.denominator = r101;
    }

    private static int addAndCheck(int r100, int r101) {
        long r102 = ((long) r100) + ((long) r101);
        if (r102 < SieveCacheKt.NodeMetaAndPreviousMask) goto L9;
        if (r102 > SieveCacheKt.NodeLinkMask) goto L9;
        return (int) r102;
    L9:
        throw new ArithmeticException("overflow: add");
    }

    private Fraction addSub(Fraction r100, boolean r101) {
        if (r100 == null) goto L5;
        boolean r102 = true;
    L6:
        Validate.isTrue(r102, "The fraction must not be null", new Object[0]);
        if (this.numerator != 0) goto L13;
        if (r101 == false) goto L11;
        return r100;
    L11:
        return r100.negate();
    L13:
        if (r100.numerator != 0) goto L15;
        return this;
    L15:
        int r103 = greatestCommonDivisor(this.denominator, r100.denominator);
        if (r103 != 1) goto L23;
        int r104 = mulAndCheck(this.numerator, r100.denominator);
        int r105 = mulAndCheck(r100.numerator, this.denominator);
        if (r101 == false) goto L20;
        int r106 = addAndCheck(r104, r105);
    L22:
        return new Fraction(r106, mulPosAndCheck(this.denominator, r100.denominator));
    L20:
        r106 = subAndCheck(r104, r105);
        goto L22
    L23:
        BigInteger r107 = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf(r100.denominator / r103));
        BigInteger r108 = BigInteger.valueOf(r100.numerator).multiply(BigInteger.valueOf(this.denominator / r103));
        if (r101 == false) goto L26;
        BigInteger r109 = r107.add(r108);
    L27:
        int r110 = r109.mod(BigInteger.valueOf(r103)).intValue();
        if (r110 != 0) goto L30;
        int r111 = r103;
    L31:
        BigInteger r112 = r109.divide(BigInteger.valueOf(r111));
        if (r112.bitLength() > 31) goto L36;
        return new Fraction(r112.intValue(), mulPosAndCheck(this.denominator / r103, r100.denominator / r111));
    L36:
        throw new ArithmeticException("overflow: numerator too large after multiply");
    L30:
        r111 = greatestCommonDivisor(r110, r103);
        goto L31
    L26:
        r109 = r107.subtract(r108);
        goto L27
    L5:
        r102 = false;
        goto L6
    }

    public static Fraction getFraction(int r100, int r101) {
        if (r101 == 0) goto L13;
        if (r101 >= 0) goto L11;
        if (r100 == Integer.MIN_VALUE) goto L9;
        if (r101 == Integer.MIN_VALUE) goto L9;
        r100 = -r100;
        r101 = -r101;
    L9:
        throw new ArithmeticException("overflow: can't negate");
    L11:
        return new Fraction(r100, r101);
    L13:
        throw new ArithmeticException("The denominator must not be zero");
    }

    public static Fraction getReducedFraction(int r100, int r101) {
        if (r101 == 0) goto L20;
        if (r100 != 0) goto L7;
        return ZERO;
    L7:
        if (r101 == Integer.MIN_VALUE) goto L9;
    L11:
        if (r101 >= 0) goto L17;
        if (r100 == Integer.MIN_VALUE) goto L16;
        if (r101 == Integer.MIN_VALUE) goto L16;
        r100 = -r100;
        r101 = -r101;
    L16:
        throw new ArithmeticException("overflow: can't negate");
    L17:
        int r102 = greatestCommonDivisor(r100, r101);
        return new Fraction(r100 / r102, r101 / r102);
    L9:
        if ((r100 & 1) != 0) goto L11;
        r100 = r100 / 2;
        r101 = r101 / 2;
        goto L11
    L20:
        throw new ArithmeticException("The denominator must not be zero");
    }

    private static int greatestCommonDivisor(int r100, int r101) {
        if (r100 == 0) goto L40;
        if (r101 == 0) goto L40;
        if (Math.abs(r100) != 1) goto L9;
    L38:
        return 1;
    L9:
        if (Math.abs(r101) == 1) goto L38;
        if (r100 <= 0) goto L13;
        r100 = -r100;
    L13:
        if (r101 <= 0) goto L15;
        r101 = -r101;
    L15:
        int r102 = 0;
    L16:
        int r103 = r100 & 1;
        if (r103 != 0) goto L22;
        if ((r101 & 1) != 0) goto L22;
        if (r102 >= 31) goto L22;
        r100 = r100 / 2;
        r101 = r101 / 2;
        r102 = r102 + 1;
    L22:
        if (r102 == 31) goto L37;
        if (r103 != 1) goto L25;
        int r104 = r101;
    L27:
        if ((r104 & 1) == 0) goto L28;
        if (r104 <= 0) goto L31;
        r100 = -r104;
    L32:
        r104 = (r101 - r100) / 2;
        if (r104 != 0) goto L27;
        return (-r100) * (1 << r102);
    L31:
        r101 = r104;
        goto L32
    L28:
        r104 = r104 / 2;
        goto L27
    L25:
        r104 = -(r100 / 2);
        goto L27
    L37:
        throw new ArithmeticException("overflow: gcd is 2^31");
    L40:
        if (r100 == Integer.MIN_VALUE) goto L45;
        if (r101 == Integer.MIN_VALUE) goto L45;
        return Math.abs(r100) + Math.abs(r101);
    L45:
        throw new ArithmeticException("overflow: gcd is 2^31");
    }

    private static int mulAndCheck(int r100, int r101) {
        long r102 = ((long) r100) * ((long) r101);
        if (r102 < SieveCacheKt.NodeMetaAndPreviousMask) goto L9;
        if (r102 > SieveCacheKt.NodeLinkMask) goto L9;
        return (int) r102;
    L9:
        throw new ArithmeticException("overflow: mul");
    }

    private static int mulPosAndCheck(int r100, int r101) {
        long r102 = ((long) r100) * ((long) r101);
        if (r102 > SieveCacheKt.NodeLinkMask) goto L7;
        return (int) r102;
    L7:
        throw new ArithmeticException("overflow: mulPos");
    }

    private static int subAndCheck(int r100, int r101) {
        long r102 = ((long) r100) - ((long) r101);
        if (r102 < SieveCacheKt.NodeMetaAndPreviousMask) goto L9;
        if (r102 > SieveCacheKt.NodeLinkMask) goto L9;
        return (int) r102;
    L9:
        throw new ArithmeticException("overflow: add");
    }

    public static Fraction getFraction(int r100, int r101, int r102) {
        if (r102 == 0) goto L21;
        if (r102 < 0) goto L19;
        if (r101 < 0) goto L17;
        if (r100 >= 0) goto L7;
        long r103 = (((long) r100) * ((long) r102)) - ((long) r101);
    L9:
        if (r103 < SieveCacheKt.NodeMetaAndPreviousMask) goto L15;
        if (r103 > SieveCacheKt.NodeLinkMask) goto L15;
        return new Fraction((int) r103, r102);
    L15:
        throw new ArithmeticException("Numerator too large to represent as an Integer.");
    L7:
        r103 = (((long) r100) * ((long) r102)) + ((long) r101);
        goto L9
    L17:
        throw new ArithmeticException("The numerator must not be negative");
    L19:
        throw new ArithmeticException("The denominator must not be negative");
    L21:
        throw new ArithmeticException("The denominator must not be zero");
    }
}
