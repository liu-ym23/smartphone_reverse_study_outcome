package com.ss.android.socialbase.appdownloader.util.parser.zip;

/* JADX INFO: loaded from: classes38.dex */
public class UnicodeCommentExtraField extends AbstractUnicodeExtraField {
    public static final ZipShort UCOM_ID = null;

    static {
        UCOM_ID = new ZipShort(25461);
    }

    public UnicodeCommentExtraField() {
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return UCOM_ID;
    }

    public UnicodeCommentExtraField(String r100, byte[] r101) {
        super(r100, r101);
    }

    public UnicodeCommentExtraField(String r100, byte[] r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
