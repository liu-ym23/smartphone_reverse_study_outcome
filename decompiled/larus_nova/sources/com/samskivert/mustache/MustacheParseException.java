package com.samskivert.mustache;

/* JADX INFO: loaded from: classes34.dex */
public class MustacheParseException extends MustacheException {
    public MustacheParseException(String r100) {
        super(r100);
    }

    public MustacheParseException(String r100, int r101) {
        super(r100 + " @ line " + r101);
    }
}
