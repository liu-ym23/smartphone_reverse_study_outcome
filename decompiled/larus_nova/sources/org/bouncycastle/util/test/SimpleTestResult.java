package org.bouncycastle.util.test;

import org.bouncycastle.util.Strings;

/* JADX INFO: loaded from: classes42.dex */
public class SimpleTestResult implements TestResult {
    private static final String SEPARATOR = null;
    private Throwable exception;
    private String message;
    private boolean success;

    static {
        SEPARATOR = Strings.lineSeparator();
    }

    public SimpleTestResult(boolean r100, String r101) {
        this.success = r100;
        this.message = r101;
    }

    public SimpleTestResult(boolean r100, String r101, Throwable r102) {
        this.success = r100;
        this.message = r101;
        this.exception = r102;
    }

    public static TestResult failed(Test r100, String r101) {
        return new SimpleTestResult(false, r100.getName() + ": " + r101);
    }

    public static TestResult failed(Test r100, String r101, Object r102, Object r103) {
        StringBuilder r104 = new StringBuilder();
        r104.append(r101);
        String r105 = SEPARATOR;
        r104.append(r105);
        r104.append("Expected: ");
        r104.append(r102);
        r104.append(r105);
        r104.append("Found   : ");
        r104.append(r103);
        return failed(r100, r104.toString());
    }

    public static TestResult failed(Test r100, String r101, Throwable r102) {
        return new SimpleTestResult(false, r100.getName() + ": " + r101, r102);
    }

    public static String failedMessage(String r100, String r101, String r102, String r103) {
        StringBuffer r104 = new StringBuffer(r100);
        r104.append(" failing ");
        r104.append(r101);
        String r105 = SEPARATOR;
        r104.append(r105);
        r104.append("    expected: ");
        r104.append(r102);
        r104.append(r105);
        r104.append("    got     : ");
        r104.append(r103);
        return r104.toString();
    }

    public static TestResult successful(Test r100, String r101) {
        return new SimpleTestResult(true, r100.getName() + ": " + r101);
    }

    @Override // org.bouncycastle.util.test.TestResult
    public Throwable getException() {
        return this.exception;
    }

    @Override // org.bouncycastle.util.test.TestResult
    public boolean isSuccessful() {
        return this.success;
    }

    @Override // org.bouncycastle.util.test.TestResult
    public String toString() {
        return this.message;
    }
}
