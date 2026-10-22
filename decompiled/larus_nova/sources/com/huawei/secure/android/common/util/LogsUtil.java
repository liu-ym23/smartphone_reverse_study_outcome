package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes23.dex */
public class LogsUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f278209a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char f278210b = '*';

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f278211c = 2;

    public static class a extends Throwable {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final long f278212d = 7129050843360571879L;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f278213a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Throwable f278214b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Throwable f278215c;

        @Override // java.lang.Throwable
        public synchronized Throwable getCause() {
            monitor-enter(this);
            Throwable r100 = this.f278214b;     // Catch: Throwable -> L8
            if (r100 != this) goto L6;
            r100 = null;
        L6:
            monitor-exit(this);
            return r100;
        L8:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Throwable
        public String toString() {
            Throwable r100 = this.f278215c;
            if (r100 != null) goto L6;
            return "";
        L6:
            String r101 = r100.getClass().getName();
            if (this.f278213a == null) goto L14;
            String r102 = r101.concat(": ");
            if (this.f278213a.startsWith(r102) == false) goto L13;
            return this.f278213a;
        L13:
            return r102 + this.f278213a;
        L14:
            return r101;
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return this.f278213a;
        }

        public a(Throwable r100) {
            this.f278215c = r100;
        }

        public void a(String r100) {
            this.f278213a = r100;
        }

        public void a(Throwable r100) {
            this.f278214b = r100;
        }
    }

    static {
        f278209a = PatternProtector.compile("[0-9]*[a-z|A-Z]*[一-龥]*");
    }

    public LogsUtil() {
    }

    private static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        int r101 = r100.length();
        int r102 = 1;
        if (1 == r101) goto L8;
        StringBuilder r103 = new StringBuilder(r101);
        int r104 = 0;
    L10:
        if (r104 >= r101) goto L19;
        char r105 = r100.charAt(r104);
        if (f278209a.matcher(String.valueOf(r105)).matches() == false) goto L17;
        if ((r102 % 2) != 0) goto L16;
        r105 = f278210b;
    L16:
        r102 = r102 + 1;
    L17:
        r103.append(r105);
        r104 = r104 + 1;
        goto L10
    L19:
        return r103.toString();
    L8:
        return String.valueOf(f278210b);
    }

    private static String b(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return r100;
    L5:
        char[] r101 = r100.toCharArray();
        int r102 = 0;
    L7:
        if (r102 >= r101.length) goto L13;
        if ((r102 % 2) != 0) goto L11;
        r101[r102] = f278210b;
    L11:
        r102 = r102 + 1;
        goto L7
    L13:
        return new String(r101);
    }

    public static Throwable getNewThrowable(Throwable r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        a r101 = new a(r100);
        r101.setStackTrace(r100.getStackTrace());
        r101.a(b(r100.getMessage()));
        Throwable r102 = r100.getCause();
        a r103 = r101;
    L6:
        if (r102 == null) goto L8;
        a r104 = new a(r102);
        r104.setStackTrace(r102.getStackTrace());
        r104.a(b(r102.getMessage()));
        r103.a(r104);
        r102 = r102.getCause();
        r103 = r104;
        goto L6
    L8:
        return r101;
    }

    private static String a(String r100, String r101) {
        StringBuilder r102 = new StringBuilder(512);
        if (TextUtils.isEmpty(r100) == true) goto L6;
        r102.append(r100);
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        r102.append(a(r101));
    L9:
        return r102.toString();
    }

    public static void d(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a(r101, false);
    }

    public static void e(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a(r101, false);
    }

    public static void i(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a(r101, false);
    }

    public static void w(String r100, String r101) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a(r101, false);
    }

    private static String a(String r100, boolean r101) {
        StringBuilder r102 = new StringBuilder(512);
        if (TextUtils.isEmpty(r100) == true) goto L8;
        if (r101 == false) goto L6;
        r102.append(a(r100));
        goto L8
    L6:
        r102.append(r100);
    L8:
        return r102.toString();
    }

    public static void d(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
    L7:
        a(r101, r102);
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L7;
    }

    public static void e(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
    L7:
        a(r101, r102);
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L7;
    }

    public static void i(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
    L7:
        a(r101, r102);
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L7;
    }

    public static void w(String r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
    L7:
        a(r101, r102);
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L7;
    }

    public static void d(String r100, String r101, Throwable r102) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        a(r101, false);
        getNewThrowable(r102);
    }

    public static void e(String r100, String r101, Throwable r102) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        a(r101, false);
        getNewThrowable(r102);
    }

    public static void i(String r100, String r101, Throwable r102) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        a(r101, false);
        getNewThrowable(r102);
    }

    public static void w(String r100, String r101, Throwable r102) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        a(r101, false);
        getNewThrowable(r102);
    }

    public static void d(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a(r101, r102);
    }

    public static void e(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a(r101, r102);
    }

    public static void i(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a(r101, r102);
    }

    public static void w(String r100, String r101, boolean r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a(r101, r102);
    }

    public static void d(String r100, String r101, String r102, Throwable r103) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
    L7:
        a(r101, r102);
        getNewThrowable(r103);
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L7;
    }

    public static void e(String r100, String r101, String r102, Throwable r103) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
    L7:
        a(r101, r102);
        getNewThrowable(r103);
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L7;
    }

    public static void i(String r100, String r101, String r102, Throwable r103) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
    L7:
        a(r101, r102);
        getNewThrowable(r103);
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L7;
    }

    public static void w(String r100, String r101, String r102, Throwable r103) {
        if (TextUtils.isEmpty(r101) == true) goto L5;
    L7:
        a(r101, r102);
        getNewThrowable(r103);
        return;
    L5:
        if (TextUtils.isEmpty(r102) == false) goto L7;
    }

    public static void d(String r100, String r101, Throwable r102, boolean r103) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        a(r101, r103);
        getNewThrowable(r102);
    }

    public static void e(String r100, String r101, Throwable r102, boolean r103) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        a(r101, r103);
        getNewThrowable(r102);
    }

    public static void i(String r100, String r101, Throwable r102, boolean r103) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        a(r101, r103);
        getNewThrowable(r102);
    }

    public static void w(String r100, String r101, Throwable r102, boolean r103) {
        if (TextUtils.isEmpty(r101) == false) goto L6;
        if (r102 != null) goto L6;
        return;
    L6:
        a(r101, r103);
        getNewThrowable(r102);
    }
}
