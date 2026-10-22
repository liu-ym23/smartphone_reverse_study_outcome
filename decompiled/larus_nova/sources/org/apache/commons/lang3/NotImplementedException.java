package org.apache.commons.lang3;

/* JADX INFO: loaded from: classes42.dex */
public class NotImplementedException extends UnsupportedOperationException {
    private static final long serialVersionUID = 20131021;
    private final String code;

    public String getCode() {
        return this.code;
    }

    public NotImplementedException(String r100) {
        this(r100, null);
    }

    public NotImplementedException(Throwable r100) {
        this(r100, null);
    }

    public NotImplementedException(String r100, String r101) {
        super(r100);
        this.code = r101;
    }

    public NotImplementedException(Throwable r100, String r101) {
        super(r100);
        this.code = r101;
    }

    public NotImplementedException(String r100, Throwable r101) {
        this(r100, r101, null);
    }

    public NotImplementedException(String r100, Throwable r101, String r102) {
        super(r100, r101);
        this.code = r102;
    }
}
