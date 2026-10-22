package com.bytedance.ee.bear.drive.mimetype;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum MimeTypeCategory extends Enum<MimeTypeCategory> {
    public static final MimeTypeCategory APP = null;
    public static final MimeTypeCategory AUDIO = null;
    public static final MimeTypeCategory BINARY = null;
    public static final MimeTypeCategory COMPRESS = null;
    public static final MimeTypeCategory DATABASE = null;
    public static final MimeTypeCategory DOCUMENT = null;
    public static final MimeTypeCategory EBOOK = null;
    public static final MimeTypeCategory EXEC = null;
    public static final MimeTypeCategory FONT = null;
    public static final MimeTypeCategory IMAGE = null;
    public static final MimeTypeCategory MAIL = null;
    public static final MimeTypeCategory NONE = null;
    public static final MimeTypeCategory SECURITY = null;
    public static final MimeTypeCategory SYSTEM = null;
    public static final MimeTypeCategory TEXT = null;
    public static final MimeTypeCategory VIDEO = null;
    public static final /* synthetic */ MimeTypeCategory[] a = null;

    static {
        MimeTypeCategory r0 = new MimeTypeCategory("NONE", 0);
        NONE = r0;
        MimeTypeCategory r1 = new MimeTypeCategory("SYSTEM", 1);
        SYSTEM = r1;
        MimeTypeCategory r3 = new MimeTypeCategory("APP", 2);
        APP = r3;
        MimeTypeCategory r5 = new MimeTypeCategory("BINARY", 3);
        BINARY = r5;
        MimeTypeCategory r7 = new MimeTypeCategory("TEXT", 4);
        TEXT = r7;
        MimeTypeCategory r9 = new MimeTypeCategory("DOCUMENT", 5);
        DOCUMENT = r9;
        MimeTypeCategory r11 = new MimeTypeCategory("EBOOK", 6);
        EBOOK = r11;
        MimeTypeCategory r13 = new MimeTypeCategory("MAIL", 7);
        MAIL = r13;
        MimeTypeCategory r16 = new MimeTypeCategory("COMPRESS", 8);
        COMPRESS = r16;
        MimeTypeCategory r14 = new MimeTypeCategory("EXEC", 9);
        EXEC = r14;
        MimeTypeCategory r12 = new MimeTypeCategory("DATABASE", 10);
        DATABASE = r12;
        MimeTypeCategory r10 = new MimeTypeCategory("FONT", 11);
        FONT = r10;
        MimeTypeCategory r8 = new MimeTypeCategory("IMAGE", 12);
        IMAGE = r8;
        MimeTypeCategory r6 = new MimeTypeCategory("AUDIO", 13);
        AUDIO = r6;
        MimeTypeCategory r4 = new MimeTypeCategory("VIDEO", 14);
        VIDEO = r4;
        MimeTypeCategory r2 = new MimeTypeCategory("SECURITY", 15);
        SECURITY = r2;
        a = new MimeTypeCategory[]{r0, r1, r3, r5, r7, r9, r11, r13, r16, r14, r12, r10, r8, r6, r4, r2};
    }

    public static MimeTypeCategory[] values() {
        return (MimeTypeCategory[]) a.clone();
    }

    public static MimeTypeCategory valueOf(String r1) {
        return (MimeTypeCategory) a.a(MimeTypeCategory.class, r1);
    }

    public MimeTypeCategory(String r1, int r2) {
        super(r1, r2);
    }
}
