package com.obric.oui.constraintlayout.core.parser;

/* JADX INFO: loaded from: classes34.dex */
public class CLParsingException extends Exception {
    private final String mElementClass;
    private final int mLineNumber;
    private final String mReason;

    public String reason() {
        return this.mReason + " (" + this.mElementClass + " at line " + this.mLineNumber + ")";
    }

    @Override // java.lang.Throwable
    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }

    public CLParsingException(String r100, a r101) {
        super(r100);
        this.mReason = r100;
        this.mElementClass = "unknown";
        this.mLineNumber = 0;
    }
}
