package com.google.protobuf.util;

import com.google.protobuf.Duration;
import com.google.protobuf.Timestamp;
import java.math.BigInteger;
import java.text.ParseException;

/* JADX INFO: loaded from: classes23.dex */
public final class TimeUtil {
    public static final long DURATION_SECONDS_MAX = 315576000000L;
    public static final long DURATION_SECONDS_MIN = -315576000000L;
    private static final long NANOS_PER_SECOND = 1000000000;
    private static final BigInteger NANOS_PER_SECOND_BIG_INTEGER = null;
    public static final long TIMESTAMP_SECONDS_MAX = 253402300799L;
    public static final long TIMESTAMP_SECONDS_MIN = -62135596800L;

    private TimeUtil() {
    }

    static {
        NANOS_PER_SECOND_BIG_INTEGER = new BigInteger(String.valueOf(1000000000));
    }

    public static Timestamp getCurrentTime() {
        return Timestamps.fromMillis(System.currentTimeMillis());
    }

    public static Timestamp getEpoch() {
        return Timestamp.getDefaultInstance();
    }

    private static Duration createDurationFromBigInteger(BigInteger r100) {
        return normalizedDuration(r100.divide(new BigInteger(String.valueOf(1000000000))).longValue(), r100.remainder(new BigInteger(String.valueOf(1000000000))).intValue());
    }

    public static Duration createDurationFromMicros(long r100) {
        return Durations.fromMicros(r100);
    }

    public static Duration createDurationFromMillis(long r100) {
        return Durations.fromMillis(r100);
    }

    public static Duration createDurationFromNanos(long r100) {
        return Durations.fromNanos(r100);
    }

    public static Timestamp createTimestampFromMicros(long r100) {
        return Timestamps.fromMicros(r100);
    }

    public static Timestamp createTimestampFromMillis(long r100) {
        return Timestamps.fromMillis(r100);
    }

    public static Timestamp createTimestampFromNanos(long r100) {
        return Timestamps.fromNanos(r100);
    }

    public static Duration parseDuration(String r100) throws ParseException {
        return Durations.parse(r100);
    }

    public static Timestamp parseTimestamp(String r100) throws ParseException {
        return Timestamps.parse(r100);
    }

    private static BigInteger toBigInteger(Duration r100) {
        return toBigInteger(r100.getSeconds()).multiply(NANOS_PER_SECOND_BIG_INTEGER).add(toBigInteger(r100.getNanos()));
    }

    public static long toMicros(Duration r100) {
        return Durations.toMicros(r100);
    }

    public static long toMillis(Duration r100) {
        return Durations.toMillis(r100);
    }

    public static long toNanos(Duration r100) {
        return Durations.toNanos(r100);
    }

    public static String toString(Duration r100) {
        return Durations.toString(r100);
    }

    private static BigInteger toBigInteger(long r100) {
        return new BigInteger(String.valueOf(r100));
    }

    public static long toMicros(Timestamp r100) {
        return Timestamps.toMicros(r100);
    }

    public static long toMillis(Timestamp r100) {
        return Timestamps.toMillis(r100);
    }

    public static long toNanos(Timestamp r100) {
        return Timestamps.toNanos(r100);
    }

    public static String toString(Timestamp r100) {
        return Timestamps.toString(r100);
    }

    public static Duration add(Duration r100, Duration r101) {
        return Durations.add(r100, r101);
    }

    public static Duration distance(Timestamp r100, Timestamp r101) {
        return Timestamps.between(r100, r101);
    }

    public static long divide(Duration r100, Duration r101) {
        return toBigInteger(r100).divide(toBigInteger(r101)).longValue();
    }

    public static Duration multiply(Duration r100, double r101) {
        double r102 = (r100.getSeconds() * r101) + ((((double) r100.getNanos()) * r101) / 1.0E9d);
        if (r102 < (-9.223372036854776E18d)) goto L9;
        if (r102 > 9.223372036854776E18d) goto L9;
        long r103 = (long) r102;
        return normalizedDuration(r103, (int) ((r102 - r103) * 1.0E9d));
    L9:
        throw new IllegalArgumentException("Result is out of valid range.");
    }

    private static Duration normalizedDuration(long r100, int r110) {
        long r101 = r110;
        if (r101 > (-1000000000)) goto L5;
    L6:
        r100 = r100 + (r101 / 1000000000);
        r110 = (int) (r101 % 1000000000);
    L8:
        if (r100 <= 0) goto L12;
        if (r110 >= 0) goto L12;
        r110 = (int) (((long) r110) + 1000000000);
        r100 = r100 - 1;
    L12:
        if (r100 >= 0) goto L16;
        if (r110 <= 0) goto L16;
        r110 = (int) (((long) r110) - 1000000000);
        r100 = r100 + 1;
    L16:
        if (r100 < DURATION_SECONDS_MIN) goto L22;
        if (r100 > DURATION_SECONDS_MAX) goto L22;
        return Duration.newBuilder().setSeconds(r100).setNanos(r110).build();
    L22:
        throw new IllegalArgumentException("Duration is out of valid range.");
    L5:
        if (r101 < 1000000000) goto L8;
        goto L6
    }

    public static Duration remainder(Duration r100, Duration r101) {
        return createDurationFromBigInteger(toBigInteger(r100).remainder(toBigInteger(r101)));
    }

    public static Duration subtract(Duration r100, Duration r101) {
        return Durations.subtract(r100, r101);
    }

    public static Timestamp add(Timestamp r100, Duration r101) {
        return Timestamps.add(r100, r101);
    }

    public static Duration divide(Duration r100, long r101) {
        return createDurationFromBigInteger(toBigInteger(r100).divide(toBigInteger(r101)));
    }

    public static Duration multiply(Duration r100, long r101) {
        return createDurationFromBigInteger(toBigInteger(r100).multiply(toBigInteger(r101)));
    }

    public static Timestamp subtract(Timestamp r100, Duration r101) {
        return Timestamps.subtract(r100, r101);
    }

    public static Duration divide(Duration r100, double r101) {
        return multiply(r100, 1.0d / r101);
    }
}
