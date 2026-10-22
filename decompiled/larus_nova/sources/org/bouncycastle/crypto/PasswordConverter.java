package org.bouncycastle.crypto;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public abstract enum PasswordConverter extends Enum<PasswordConverter> implements CharToByteConverter {
    private static final /* synthetic */ PasswordConverter[] $VALUES = null;
    public static final PasswordConverter ASCII = null;
    public static final PasswordConverter PKCS12 = null;
    public static final PasswordConverter UTF8 = null;

    static {
        final String r100 = "ASCII";
        final int r101 = 0;
        PasswordConverter r102 = new AnonymousClass1(r100, r101);
        ASCII = r102;
        final String r103 = "UTF8";
        final int r104 = 1;
        PasswordConverter r105 = new AnonymousClass2(r103, r104);
        UTF8 = r105;
        final String r106 = "PKCS12";
        final int r107 = 2;
        PasswordConverter r108 = new AnonymousClass3(r106, r107);
        PKCS12 = r108;
        $VALUES = new PasswordConverter[]{r102, r105, r108};
    }

    private PasswordConverter(String r100, int r101) {
        super(r100, r101);
    }

    public /* synthetic */ PasswordConverter(String r100, int r101, AnonymousClass1 r102) {
        this(r100, r101);
    }

    public static PasswordConverter valueOf(String r100) {
        return (PasswordConverter) a.a(PasswordConverter.class, r100);
    }

    public static PasswordConverter[] values() {
        return (PasswordConverter[]) $VALUES.clone();
    }
}
