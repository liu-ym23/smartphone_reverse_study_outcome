package org.bouncycastle.util.test;

import java.io.PrintStream;
import java.util.Enumeration;
import java.util.Vector;
import org.bouncycastle.util.Arrays;

/* JADX INFO: loaded from: classes42.dex */
public abstract class SimpleTest implements Test {
    public SimpleTest() {
    }

    public static void runTest(Test r100) {
        runTest(r100, System.out);
    }

    public static void runTest(Test r100, PrintStream r101) {
        TestResult r102 = r100.perform();
        if (r102.getException() == null) goto L5;
        r102.getException().printStackTrace(r101);
    L5:
        r101.println(r102);
    }

    public static void runTests(Test[] r100) {
        runTests(r100, System.out);
    }

    public static void runTests(Test[] r100, PrintStream r101) {
        Vector r102 = new Vector();
        int r103 = 0;
    L4:
        if (r103 == r100.length) goto L12;
        TestResult r104 = r100[r103].perform();
        if (r104.isSuccessful() == true) goto L9;
        r102.addElement(r104);
    L9:
        if (r104.getException() == null) goto L11;
        r104.getException().printStackTrace(r101);
    L11:
        r101.println(r104);
        r103 = r103 + 1;
        goto L4
    L12:
        r101.println("-----");
        if (r102.isEmpty() == false) goto L15;
        r101.println("All tests successful.");
        return;
    L15:
        r101.println("Completed with " + r102.size() + " FAILURES:");
        Enumeration r105 = r102.elements();
    L17:
        if (r105.hasMoreElements() == false) goto L24;
        System.out.println("=>  " + ((TestResult) r105.nextElement()));
        goto L17
    }

    private TestResult success() {
        return SimpleTestResult.successful(this, "Okay");
    }

    public boolean areEqual(byte[] r100, int r101, int r102, byte[] r103, int r104, int r105) {
        return Arrays.areEqual(r100, r101, r102, r103, r104, r105);
    }

    public boolean areEqual(byte[] r100, byte[] r101) {
        return Arrays.areEqual(r100, r101);
    }

    public boolean areEqual(byte[][] r100, byte[][] r101) {
        if (r100 != null) goto L7;
        if (r101 != null) goto L7;
        return true;
    L7:
        if (r100 == null) goto L21;
        if (r101 == null) goto L21;
        if (r100.length == r101.length) goto L13;
        return false;
    L13:
        int r102 = 0;
    L15:
        if (r102 >= r100.length) goto L20;
        if (areEqual(r100[r102], r101[r102]) == false) goto L19;
        r102 = r102 + 1;
        goto L15
    L19:
        return false;
    L20:
        return true;
    L21:
        return false;
    }

    public void fail(String r100) {
        throw new TestFailedException(SimpleTestResult.failed(this, r100));
    }

    public void fail(String r100, Object r101, Object r102) {
        throw new TestFailedException(SimpleTestResult.failed(this, r100, r101, r102));
    }

    public void fail(String r100, Throwable r101) {
        throw new TestFailedException(SimpleTestResult.failed(this, r100, r101));
    }

    @Override // org.bouncycastle.util.test.Test
    public abstract String getName();

    public void isEquals(int r100, int r101) {
        if (r100 != r101) goto L5;
        return;
    L5:
        throw new TestFailedException(SimpleTestResult.failed(this, "no message"));
    }

    public void isEquals(long r100, long r101) {
        if (r100 != r101) goto L6;
        return;
    L6:
        throw new TestFailedException(SimpleTestResult.failed(this, "no message"));
    }

    public void isEquals(Object r100, Object r101) {
        if (r100.equals(r101) == false) goto L6;
        return;
    L6:
        throw new TestFailedException(SimpleTestResult.failed(this, "no message"));
    }

    public void isEquals(String r100, long r101, long r102) {
        if (r101 != r102) goto L6;
        return;
    L6:
        throw new TestFailedException(SimpleTestResult.failed(this, r100));
    }

    public void isEquals(String r100, Object r101, Object r102) {
        if (r101 != null) goto L5;
        if (r102 != null) goto L5;
        return;
    L5:
        if (r101 == null) goto L15;
        if (r102 == null) goto L13;
        if (r101.equals(r102) == false) goto L11;
        return;
    L11:
        throw new TestFailedException(SimpleTestResult.failed(this, r100));
    L13:
        throw new TestFailedException(SimpleTestResult.failed(this, r100));
    L15:
        throw new TestFailedException(SimpleTestResult.failed(this, r100));
    }

    public void isEquals(String r100, boolean r101, boolean r102) {
        if (r101 != r102) goto L5;
        return;
    L5:
        throw new TestFailedException(SimpleTestResult.failed(this, r100));
    }

    public void isTrue(String r100, boolean r101) {
        if (r101 == false) goto L5;
        return;
    L5:
        throw new TestFailedException(SimpleTestResult.failed(this, r100));
    }

    public void isTrue(boolean r100) {
        if (r100 == false) goto L5;
        return;
    L5:
        throw new TestFailedException(SimpleTestResult.failed(this, "no message"));
    }

    @Override // org.bouncycastle.util.test.Test
    public TestResult perform() {
        performTest();     // Catch: Exception -> L4 TestFailedException -> L7
        return success();
    L7:
        e = move-exception;
        return e.getResult();
    L4:
        e = move-exception;
        return SimpleTestResult.failed(this, "Exception: " + e, e);
    }

    public abstract void performTest() throws Exception;
}
