package com.google.zxing;

import com.larus.dora.api.model.FlowDoraWifiScene;

/* JADX INFO: loaded from: classes23.dex */
public final enum ResultMetadataType extends Enum<ResultMetadataType> {
    public static final ResultMetadataType BYTE_SEGMENTS = null;
    public static final ResultMetadataType ERROR_CORRECTION_LEVEL = null;
    public static final ResultMetadataType ISSUE_NUMBER = null;
    public static final ResultMetadataType ORIENTATION = null;
    public static final ResultMetadataType OTHER = null;
    public static final ResultMetadataType PDF417_EXTRA_METADATA = null;
    public static final ResultMetadataType POSSIBLE_COUNTRY = null;
    public static final ResultMetadataType STRUCTURED_APPEND_PARITY = null;
    public static final ResultMetadataType STRUCTURED_APPEND_SEQUENCE = null;
    public static final ResultMetadataType SUGGESTED_PRICE = null;
    public static final ResultMetadataType SYMBOLOGY_IDENTIFIER = null;
    public static final ResultMetadataType UPC_EAN_EXTENSION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ResultMetadataType[] f275936a = null;

    static {
        ResultMetadataType r100 = new ResultMetadataType(FlowDoraWifiScene.OTHER, 0);
        OTHER = r100;
        ResultMetadataType r101 = new ResultMetadataType("ORIENTATION", 1);
        ORIENTATION = r101;
        ResultMetadataType r102 = new ResultMetadataType("BYTE_SEGMENTS", 2);
        BYTE_SEGMENTS = r102;
        ResultMetadataType r103 = new ResultMetadataType("ERROR_CORRECTION_LEVEL", 3);
        ERROR_CORRECTION_LEVEL = r103;
        ResultMetadataType r104 = new ResultMetadataType("ISSUE_NUMBER", 4);
        ISSUE_NUMBER = r104;
        ResultMetadataType r105 = new ResultMetadataType("SUGGESTED_PRICE", 5);
        SUGGESTED_PRICE = r105;
        ResultMetadataType r110 = new ResultMetadataType("POSSIBLE_COUNTRY", 6);
        POSSIBLE_COUNTRY = r110;
        ResultMetadataType r111 = new ResultMetadataType("UPC_EAN_EXTENSION", 7);
        UPC_EAN_EXTENSION = r111;
        ResultMetadataType r112 = new ResultMetadataType("PDF417_EXTRA_METADATA", 8);
        PDF417_EXTRA_METADATA = r112;
        ResultMetadataType r113 = new ResultMetadataType("STRUCTURED_APPEND_SEQUENCE", 9);
        STRUCTURED_APPEND_SEQUENCE = r113;
        ResultMetadataType r114 = new ResultMetadataType("STRUCTURED_APPEND_PARITY", 10);
        STRUCTURED_APPEND_PARITY = r114;
        ResultMetadataType r115 = new ResultMetadataType("SYMBOLOGY_IDENTIFIER", 11);
        SYMBOLOGY_IDENTIFIER = r115;
        f275936a = new ResultMetadataType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
    }

    public static ResultMetadataType[] values() {
        return (ResultMetadataType[]) f275936a.clone();
    }

    public static ResultMetadataType valueOf(String r100) {
        return (ResultMetadataType) r27.a.a(ResultMetadataType.class, r100);
    }

    public ResultMetadataType(String r100, int r101) {
        super(r100, r101);
    }
}
