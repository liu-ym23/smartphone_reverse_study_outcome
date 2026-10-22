package org.apache.commons.imaging.icc;

import java.io.IOException;
import java.util.logging.Logger;
import org.apache.commons.imaging.ImageReadException;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public abstract enum IccTagDataTypes extends Enum<IccTagDataTypes> {
    private static final /* synthetic */ IccTagDataTypes[] $VALUES = null;
    public static final IccTagDataTypes DATA_TYPE = null;
    public static final IccTagDataTypes DESC_TYPE = null;
    private static final Logger LOGGER = null;
    public static final IccTagDataTypes MULTI_LOCALIZED_UNICODE_TYPE = null;
    public static final IccTagDataTypes SIGNATURE_TYPE = null;
    public static final IccTagDataTypes TEXT_TYPE = null;
    public final String name;
    public final int signature;

    public abstract /* synthetic */ void dump(String r100, byte[] r101) throws ImageReadException, IOException;

    static {
        final String r100 = "descType";
        final int r101 = 1684370275;
        final String r102 = "DESC_TYPE";
        final int r103 = 0;
        IccTagDataTypes r104 = new AnonymousClass1(r102, r103, r100, r101);
        DESC_TYPE = r104;
        final String r105 = "dataType";
        final int r106 = 1684108385;
        final String r107 = "DATA_TYPE";
        final int r108 = 1;
        IccTagDataTypes r109 = new AnonymousClass2(r107, r108, r105, r106);
        DATA_TYPE = r109;
        final String r110 = "multiLocalizedUnicodeType";
        final int r111 = 1835824483;
        final String r112 = "MULTI_LOCALIZED_UNICODE_TYPE";
        final int r113 = 2;
        IccTagDataTypes r114 = new AnonymousClass3(r112, r113, r110, r111);
        MULTI_LOCALIZED_UNICODE_TYPE = r114;
        final String r115 = "signatureType";
        final int r116 = 1936287520;
        final String r117 = "SIGNATURE_TYPE";
        final int r118 = 3;
        IccTagDataTypes r119 = new AnonymousClass4(r117, r118, r115, r116);
        SIGNATURE_TYPE = r119;
        final String r120 = "textType";
        final int r121 = 1952807028;
        final String r122 = "TEXT_TYPE";
        final int r123 = 4;
        IccTagDataTypes r124 = new AnonymousClass5(r122, r123, r120, r121);
        TEXT_TYPE = r124;
        $VALUES = new IccTagDataTypes[]{r104, r109, r114, r119, r124};
        LOGGER = Logger.getLogger(IccTagDataTypes.class.getName());
    }

    public static IccTagDataTypes[] values() {
        return (IccTagDataTypes[]) $VALUES.clone();
    }

    public static /* synthetic */ Logger access$100() {
        return LOGGER;
    }

    public String getName() {
        return this.name;
    }

    public int getSignature() {
        return this.signature;
    }

    public static IccTagDataTypes valueOf(String r100) {
        return (IccTagDataTypes) a.a(IccTagDataTypes.class, r100);
    }

    private IccTagDataTypes(String r100, int r101, String r102, int r103) {
        super(r100, r101);
        this.name = r102;
        this.signature = r103;
    }

    public /* synthetic */ IccTagDataTypes(String r100, int r101, String r102, int r103, AnonymousClass1 r104) {
        this(r100, r101, r102, r103);
    }
}
