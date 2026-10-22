package androidx.camera.core.impl.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes2.dex */
final class LongRational {
    private final long mDenominator;
    private final long mNumerator;

    public double toDouble() {
        return this.mNumerator / this.mDenominator;
    }

    public String toString() {
        return this.mNumerator + "/" + this.mDenominator;
    }

    public long getDenominator() {
        return this.mDenominator;
    }

    public long getNumerator() {
        return this.mNumerator;
    }

    public LongRational(double r3) {
        this((long) (r3 * 10000.0d), 10000);
    }

    public LongRational(long r1, long r3) {
        this.mNumerator = r1;
        this.mDenominator = r3;
    }
}
