package org.bouncycastle.util.test;

/* JADX INFO: loaded from: classes42.dex */
public class TestFailedException extends RuntimeException {
    private TestResult _result;

    public TestFailedException(TestResult r100) {
        this._result = r100;
    }

    public TestResult getResult() {
        return this._result;
    }
}
