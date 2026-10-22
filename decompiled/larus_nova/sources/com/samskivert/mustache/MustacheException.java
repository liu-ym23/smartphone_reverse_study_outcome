package com.samskivert.mustache;

/* JADX INFO: loaded from: classes34.dex */
public class MustacheException extends RuntimeException {

    public static class Context extends MustacheException {
        public final String key;
        public final int lineNo;

        public Context(String r100, String r101, int r102) {
            super(r100);
            this.key = r101;
            this.lineNo = r102;
        }

        public Context(String r100, String r101, int r102, Throwable r103) {
            super(r100, r103);
            this.key = r101;
            this.lineNo = r102;
        }
    }

    public MustacheException(String r100) {
        super(r100);
    }

    public MustacheException(Throwable r100) {
        super(r100);
    }

    public MustacheException(String r100, Throwable r101) {
        super(r100, r101);
    }
}
