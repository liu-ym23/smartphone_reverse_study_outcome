package com.google.android.gms.common.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* JADX INFO: loaded from: classes23.dex */
public final class Preconditions {
    public static void checkMainThread() {
        checkMainThread("Must be called on the main application thread");
    }

    public static void checkNotGoogleApiHandlerThread() {
        checkNotGoogleApiHandlerThread("Must not be called on GoogleApiHandler thread.");
    }

    public static void checkNotMainThread() {
        checkNotMainThread("Must not be called on the main application thread");
    }

    private Preconditions() {
        throw new AssertionError("Uninstantiable");
    }

    public static void checkArgument(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException();
    }

    public static void checkHandlerThread(Handler r100) {
        Looper r101 = Looper.myLooper();
        if (r101 == r100.getLooper()) goto L9;
        if (r101 == null) goto L6;
        String r102 = ThreadMethodProxy.getLooperThread(r101).getName();
    L8:
        throw new IllegalStateException("Must be called on " + ThreadMethodProxy.getLooperThread(r100.getLooper()).getName() + " thread, but got " + r102 + ".");
    L6:
        r102 = "null current looper";
        goto L8
    }

    public static void checkMainThread(String r100) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return;
    L9:
        throw new IllegalStateException(r100);
    L5:
        r101 = false;
        goto L6
    }

    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String r100) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Given String is empty or null");
    }

    public static void checkNotGoogleApiHandlerThread(String r100) {
        Looper r101 = Looper.myLooper();
        if (r101 == null) goto L12;
        String r102 = ThreadMethodProxy.getLooperThread(r101).getName();
        if (r102 == "GoogleApiHandler") goto L11;
        if (r102 != null) goto L8;
        return;
    L8:
        if (r102.equals("GoogleApiHandler") == true) goto L11;
        return;
    L11:
        throw new IllegalStateException(r100);
    }

    public static void checkNotMainThread(String r100) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == true) goto L9;
        return;
    L9:
        throw new IllegalStateException(r100);
    L5:
        r101 = false;
        goto L6
    }

    @EnsuresNonNull({"#1"})
    public static <T> T checkNotNull(T r100) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException("null reference");
    }

    public static long checkNotZero(long r100) {
        if (r100 == 0) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException("Given Long is zero");
    }

    public static void checkState(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException();
    }

    public static int checkNotZero(int r100) {
        if (r100 == 0) goto L5;
        return r100;
    L5:
        throw new IllegalArgumentException("Given Integer is zero");
    }

    public static void checkArgument(boolean r100, Object r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    public static void checkHandlerThread(Handler r100, String r101) {
        if (Looper.myLooper() != r100.getLooper()) goto L6;
        return;
    L6:
        throw new IllegalStateException(r101);
    }

    @EnsuresNonNull({"#1"})
    public static String checkNotEmpty(String r100, Object r101) {
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    @EnsuresNonNull({"#1"})
    public static <T> T checkNotNull(T r100, Object r101) {
        if (r100 == null) goto L5;
        return r100;
    L5:
        throw new NullPointerException(String.valueOf(r101));
    }

    public static long checkNotZero(long r100, Object r101) {
        if (r100 == 0) goto L6;
        return r100;
    L6:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    public static void checkState(boolean r100, Object r101) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.valueOf(r101));
    }

    public static String zza(String r100, Object... r101) {
        StringBuilder r102 = new StringBuilder(r100.length() + 48);
        int r103 = 0;
        int r104 = 0;
    L4:
        if (r103 >= 3) goto L9;
        int r105 = r100.indexOf("%s", r104);
        if (r105 == (-1)) goto L9;
        r102.append(r100.substring(r104, r105));
        int r106 = r103 + 1;
        r102.append(r101[r103]);
        r104 = r105 + 2;
        r103 = r106;
    L9:
        r102.append(r100.substring(r104));
        if (r103 >= 3) goto L16;
        r102.append(" [");
        int r107 = r103 + 1;
        r102.append(r101[r103]);
    L12:
        if (r107 >= 3) goto L14;
        r102.append(", ");
        int r108 = r107 + 1;
        r102.append(r101[r107]);
        r107 = r108;
        goto L12
    L14:
        r102.append("]");
    L16:
        return r102.toString();
    }

    public static int checkNotZero(int r100, Object r101) {
        if (r100 == 0) goto L5;
        return r100;
    L5:
        throw new IllegalArgumentException(String.valueOf(r101));
    }

    public static void checkArgument(boolean r100, String r101, Object... r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalArgumentException(String.format(r101, r102));
    }

    public static void checkState(boolean r100, String r101, Object... r102) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new IllegalStateException(String.format(r101, r102));
    }

    public static double checkArgumentInRange(double r100, double r101, double r102, String r110) {
        if (r100 < r101) goto L10;
        if (r100 > r102) goto L8;
        return r100;
    L8:
        throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", new Object[]{r110, Double.valueOf(r101), Double.valueOf(r102)}));
    L10:
        throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", new Object[]{r110, Double.valueOf(r101), Double.valueOf(r102)}));
    }

    public static float checkArgumentInRange(float r100, float r101, float r102, String r103) {
        if (r100 < r101) goto L10;
        if (r100 > r102) goto L8;
        return r100;
    L8:
        throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too high)", new Object[]{r103, Float.valueOf(r101), Float.valueOf(r102)}));
    L10:
        throw new IllegalArgumentException(zza("%s is out of range of [%f, %f] (too low)", new Object[]{r103, Float.valueOf(r101), Float.valueOf(r102)}));
    }

    public static long checkArgumentInRange(long r100, long r101, long r102, String r110) {
        if (r100 < r101) goto L10;
        if (r100 > r102) goto L8;
        return r100;
    L8:
        throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", new Object[]{r110, Long.valueOf(r101), Long.valueOf(r102)}));
    L10:
        throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", new Object[]{r110, Long.valueOf(r101), Long.valueOf(r102)}));
    }

    public static int checkArgumentInRange(int r100, int r101, int r102, String r103) {
        if (r100 < r101) goto L9;
        if (r100 > r102) goto L7;
        return r100;
    L7:
        throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too high)", new Object[]{r103, Integer.valueOf(r101), Integer.valueOf(r102)}));
    L9:
        throw new IllegalArgumentException(zza("%s is out of range of [%d, %d] (too low)", new Object[]{r103, Integer.valueOf(r101), Integer.valueOf(r102)}));
    }
}
