package com.google.crypto.tink.shaded.protobuf;

import java.io.IOException;

/* JADX INFO: loaded from: classes23.dex */
abstract enum WireFormat$Utf8Validation extends Enum<WireFormat$Utf8Validation> {
    public static final WireFormat$Utf8Validation LAZY = null;
    public static final WireFormat$Utf8Validation LOOSE = null;
    public static final WireFormat$Utf8Validation STRICT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WireFormat$Utf8Validation[] f275853a = null;

    public WireFormat$Utf8Validation() {
        throw null;
    }

    public abstract Object readString(d r100) throws IOException;

    static {
        final String r100 = "LOOSE";
        final int r101 = 0;
        WireFormat$Utf8Validation r102 = new AnonymousClass1(r100, r101);
        LOOSE = r102;
        final String r103 = "STRICT";
        final int r104 = 1;
        WireFormat$Utf8Validation r105 = new AnonymousClass2(r103, r104);
        STRICT = r105;
        final String r106 = "LAZY";
        final int r107 = 2;
        WireFormat$Utf8Validation r108 = new AnonymousClass3(r106, r107);
        LAZY = r108;
        f275853a = new WireFormat$Utf8Validation[]{r102, r105, r108};
    }

    public static WireFormat$Utf8Validation[] values() {
        return (WireFormat$Utf8Validation[]) f275853a.clone();
    }

    public static WireFormat$Utf8Validation valueOf(String r100) {
        return (WireFormat$Utf8Validation) r27.a.a(WireFormat$Utf8Validation.class, r100);
    }

    public WireFormat$Utf8Validation(String r100, int r101, j r102) {
        super(r100, r101);
    }
}
