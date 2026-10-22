package org.apache.commons.net.ftp.parser;

/* JADX INFO: loaded from: classes42.dex */
public class ParserInitializationException extends RuntimeException {
    private static final long serialVersionUID = 5563335279583210658L;

    public Throwable getRootCause() {
        return super.getCause();
    }

    public ParserInitializationException(String r100) {
        super(r100);
    }

    public ParserInitializationException(String r100, Throwable r101) {
        super(r100, r101);
    }
}
