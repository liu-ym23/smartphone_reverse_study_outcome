package org.apache.commons.net.telnet;

/* JADX INFO: loaded from: classes42.dex */
public class InvalidTelnetOptionException extends Exception {
    private static final long serialVersionUID = -2516777155928793597L;
    private final String msg;
    private final int optionCode;

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.msg + ": " + this.optionCode;
    }

    public InvalidTelnetOptionException(String r100, int r101) {
        this.optionCode = r101;
        this.msg = r100;
    }
}
