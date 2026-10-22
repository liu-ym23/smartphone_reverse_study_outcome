package com.google.protobuf.util;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.common.math.LongMath;
import com.google.common.math.c;
import com.google.protobuf.Duration;
import com.ss.ttm.player.C;
import java.text.ParseException;
import java.util.Comparator;

/* JADX INFO: loaded from: classes23.dex */
public final class Durations {
    private static final Comparator<Duration> COMPARATOR = null;
    static final long DURATION_SECONDS_MAX = 315576000000L;
    static final long DURATION_SECONDS_MIN = -315576000000L;
    public static final Duration MAX_VALUE = null;
    public static final Duration MIN_VALUE = null;

    private Durations() {
    }

    public static boolean isValid(long r100, int r101) {
        if (r100 >= (-315576000000L)) goto L5;
    L20:
        return false;
    L5:
        if (r100 > 315576000000L) goto L20;
        long r102 = r101;
        if (r102 < (-999999999)) goto L20;
        if (r102 >= C.NANOS_PER_SECOND) goto L20;
        if (r100 < 0) goto L15;
        if (r101 < 0) goto L15;
        return true;
    L15:
        if (r100 > 0) goto L20;
        if (r101 > 0) goto L20;
        return true;
    }

    static {
        MIN_VALUE = Duration.newBuilder().setSeconds(-315576000000L).setNanos(-999999999).build();
        MAX_VALUE = Duration.newBuilder().setSeconds(315576000000L).setNanos(999999999).build();
        COMPARATOR = new AnonymousClass1();
    }

    public static Comparator<Duration> comparator() {
        return COMPARATOR;
    }

    public static Duration checkValid(Duration r100) {
        long r101 = r100.getSeconds();
        int r102 = r100.getNanos();
        if (isValid(r101, r102) == false) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(String.format("Duration is not valid. See proto definition for valid values. Seconds (%s) must be in range [-315,576,000,000, +315,576,000,000]. Nanos (%s) must be in range [-999,999,999, +999,999,999]. Nanos must have the same sign as seconds", new Object[]{Long.valueOf(r101), Integer.valueOf(r102)}));
    }

    public static Duration fromMicros(long r100) {
        return normalizedDuration(r100 / 1000000, (int) ((r100 % 1000000) * 1000));
    }

    public static Duration fromMillis(long r100) {
        return normalizedDuration(r100 / 1000, (int) ((r100 % 1000) * 1000000));
    }

    public static Duration fromNanos(long r100) {
        return normalizedDuration(r100 / C.NANOS_PER_SECOND, (int) (r100 % C.NANOS_PER_SECOND));
    }

    public static Duration fromSeconds(long r100) {
        return normalizedDuration(r100, 0);
    }

    public static boolean isValid(Duration r100) {
        return isValid(r100.getSeconds(), r100.getNanos());
    }

    public static Duration parse(String r100) throws ParseException {
        if (r100.isEmpty() == true) goto L29;
        if (r100.charAt(r100.length() - 1) != 's') goto L29;
        if (r100.charAt(0) != '-') goto L9;
        r100 = r100.substring(1);
        boolean r101 = true;
    L10:
        String r102 = r100.substring(0, r100.length() - 1);
        int r103 = r102.indexOf(46);
        if (r103 == (-1)) goto L13;
        String r104 = r102.substring(r103 + 1);
        r102 = r102.substring(0, r103);
    L14:
        long r105 = CastLongProtector.parseLong(r102);
        if (r104.isEmpty() == false) goto L17;
        int r106 = 0;
    L19:
        if (r105 < 0) goto L27;
        if (r101 == false) goto L30;
        r105 = -r105;
        r106 = -r106;
    L30:
        return normalizedDuration(r105, r106);
    L25:
        throw new ParseException("Duration value is out of range.", 0);
    L27:
        throw new ParseException("Invalid duration string: ".concat(r100), 0);
    L17:
        r106 = Timestamps.parseNanos(r104);
        goto L19
    L13:
        r104 = "";
        goto L14
    L9:
        r101 = false;
    L29:
        throw new ParseException("Invalid duration string: ".concat(r100), 0);
    }

    public static long toMicros(Duration r100) {
        checkValid(r100);
        return LongMath.a(LongMath.b(r100.getSeconds(), 1000000), ((long) r100.getNanos()) / 1000);
    }

    public static long toMillis(Duration r100) {
        checkValid(r100);
        return LongMath.a(LongMath.b(r100.getSeconds(), 1000), ((long) r100.getNanos()) / 1000000);
    }

    public static long toNanos(Duration r100) {
        checkValid(r100);
        return LongMath.a(LongMath.b(r100.getSeconds(), C.NANOS_PER_SECOND), r100.getNanos());
    }

    public static long toSeconds(Duration r100) {
        return checkValid(r100).getSeconds();
    }

    public static String toString(Duration r100) {
        checkValid(r100);
        long r101 = r100.getSeconds();
        int r102 = r100.getNanos();
        StringBuilder r103 = new StringBuilder();
        if (r101 < 0) goto L5;
        if (r102 < 0) goto L5;
    L6:
        r103.append(r101);
        if (r102 == 0) goto L9;
        r103.append(".");
        r103.append(Timestamps.formatNanos(r102));
    L9:
        r103.append("s");
        return r103.toString();
    L5:
        r103.append("-");
        r101 = -r101;
        r102 = -r102;
        goto L6
    }

    public static Duration add(Duration r100, Duration r101) {
        checkValid(r100);
        checkValid(r101);
        return normalizedDuration(LongMath.a(r100.getSeconds(), r101.getSeconds()), c.a(r100.getNanos(), r101.getNanos()));
    }

    public static int compare(Duration r100, Duration r101) {
        return COMPARATOR.compare(r100, r101);
    }

    public static Duration normalizedDuration(long r100, int r110) {
        long r101 = r110;
        if (r101 > (-1000000000)) goto L5;
    L6:
        r100 = LongMath.a(r100, r101 / C.NANOS_PER_SECOND);
        r110 = (int) (r101 % C.NANOS_PER_SECOND);
    L8:
        if (r100 <= 0) goto L12;
        if (r110 >= 0) goto L12;
        r110 = (int) (((long) r110) + C.NANOS_PER_SECOND);
        r100 = r100 - 1;
    L12:
        if (r100 >= 0) goto L16;
        if (r110 <= 0) goto L16;
        r110 = (int) (((long) r110) - C.NANOS_PER_SECOND);
        r100 = r100 + 1;
    L16:
        return checkValid(Duration.newBuilder().setSeconds(r100).setNanos(r110).build());
    L5:
        if (r101 < C.NANOS_PER_SECOND) goto L8;
        goto L6
    }

    public static Duration subtract(Duration r100, Duration r101) {
        checkValid(r100);
        checkValid(r101);
        return normalizedDuration(LongMath.c(r100.getSeconds(), r101.getSeconds()), c.b(r100.getNanos(), r101.getNanos()));
    }
}
