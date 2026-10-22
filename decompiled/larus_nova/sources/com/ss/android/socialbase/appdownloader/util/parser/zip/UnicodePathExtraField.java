package com.ss.android.socialbase.appdownloader.util.parser.zip;

/* JADX INFO: loaded from: classes38.dex */
public class UnicodePathExtraField extends AbstractUnicodeExtraField {
    public static final ZipShort UPATH_ID = null;

    static {
        UPATH_ID = new ZipShort(28789);
    }

    public UnicodePathExtraField() {
    }

    @Override // com.ss.android.socialbase.appdownloader.util.parser.zip.ZipExtraField
    public ZipShort getHeaderId() {
        return UPATH_ID;
    }

    public UnicodePathExtraField(String r100, byte[] r101) {
        super(r100, r101);
    }

    public UnicodePathExtraField(String r100, byte[] r101, int r102, int r103) {
        super(r100, r101, r102, r103);
    }
}
