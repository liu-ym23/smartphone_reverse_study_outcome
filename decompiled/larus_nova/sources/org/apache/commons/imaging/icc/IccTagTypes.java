package org.apache.commons.imaging.icc;

import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum IccTagTypes extends Enum<IccTagTypes> {
    private static final /* synthetic */ IccTagTypes[] $VALUES = null;
    public static final IccTagTypes A_TO_B0_TAG = null;
    public static final IccTagTypes A_TO_B1_TAG = null;
    public static final IccTagTypes A_TO_B2_TAG = null;
    public static final IccTagTypes BLUE_MATRIX_COLUMN_TAG = null;
    public static final IccTagTypes BLUE_TRC_TAG = null;
    public static final IccTagTypes B_TO_A0_TAG = null;
    public static final IccTagTypes B_TO_A1_TAG = null;
    public static final IccTagTypes B_TO_A2_TAG = null;
    public static final IccTagTypes CALIBRATION_DATE_TIME_TAG = null;
    public static final IccTagTypes CHAR_TARGET_TAG = null;
    public static final IccTagTypes CHROMATICITY_TAG = null;
    public static final IccTagTypes CHROMATIC_ADAPTATION_TAG = null;
    public static final IccTagTypes COLORANT_ORDER_TAG = null;
    public static final IccTagTypes COLORANT_TABLE_TAG = null;
    public static final IccTagTypes COPYRIGHT_TAG = null;
    public static final IccTagTypes DEVICE_MFG_DESC_TAG = null;
    public static final IccTagTypes DEVICE_MODEL_DESC_TAG = null;
    public static final IccTagTypes GAMUT_TAG = null;
    public static final IccTagTypes GRAY_TRC_TAG = null;
    public static final IccTagTypes GREEN_MATRIX_COLUMN_TAG = null;
    public static final IccTagTypes GREEN_TRC_TAG = null;
    public static final IccTagTypes LUMINANCE_TAG = null;
    public static final IccTagTypes MEASUREMENT_TAG = null;
    public static final IccTagTypes MEDIA_BLACK_POINT_TAG = null;
    public static final IccTagTypes MEDIA_WHITE_POINT_TAG = null;
    public static final IccTagTypes NAMED_COLOR_2_TAG = null;
    public static final IccTagTypes OUTPUT_RESPONSE_TAG = null;
    public static final IccTagTypes PREVIEW_0_TAG = null;
    public static final IccTagTypes PREVIEW_1_TAG = null;
    public static final IccTagTypes PREVIEW_2_TAG = null;
    public static final IccTagTypes PROFILE_DESCRIPTION_TAG = null;
    public static final IccTagTypes PROFILE_SEQUENCE_DESC_TAG = null;
    public static final IccTagTypes RED_MATRIX_COLUMN_TAG = null;
    public static final IccTagTypes RED_TRC_TAG = null;
    public static final IccTagTypes TECHNOLOGY_TAG = null;
    public static final IccTagTypes VIEWING_CONDITIONS_TAG = null;
    public static final IccTagTypes VIEWING_COND_DESC_TAG = null;
    public final String name;
    public final int signature;
    public final String typeDescription;

    static {
        IccTagTypes r100 = new IccTagTypes("A_TO_B0_TAG", 0, "AToB0Tag", "lut8Type or lut16Type or lutAtoBType", 1093812784);
        A_TO_B0_TAG = r100;
        IccTagTypes r101 = new IccTagTypes("A_TO_B1_TAG", 1, "AToB1Tag", "lut8Type or lut16Type or lutAtoBType", 1093812785);
        A_TO_B1_TAG = r101;
        IccTagTypes r102 = new IccTagTypes("A_TO_B2_TAG", 2, "AToB2Tag", "lut8Type or lut16Type or lutAtoBType", 1093812786);
        A_TO_B2_TAG = r102;
        IccTagTypes r103 = new IccTagTypes("BLUE_MATRIX_COLUMN_TAG", 3, "blueMatrixColumnTag", "XYZType", 1649957210);
        BLUE_MATRIX_COLUMN_TAG = r103;
        IccTagTypes r104 = new IccTagTypes("BLUE_TRC_TAG", 4, "blueTRCTag", "curveType or parametricCurveType", 1649693251);
        BLUE_TRC_TAG = r104;
        IccTagTypes r105 = new IccTagTypes("B_TO_A0_TAG", 5, "BToA0Tag", "lut8Type or lut16Type or lutBtoAType", 1110589744);
        B_TO_A0_TAG = r105;
        IccTagTypes r106 = new IccTagTypes("B_TO_A1_TAG", 6, "BToA1Tag", "lut8Type or lut16Type or lutBtoAType", 1110589745);
        B_TO_A1_TAG = r106;
        IccTagTypes r110 = new IccTagTypes("B_TO_A2_TAG", 7, "BToA2Tag", "lut8Type or lut16Type or lutBtoAType", 1110589746);
        B_TO_A2_TAG = r110;
        IccTagTypes r107 = new IccTagTypes("CALIBRATION_DATE_TIME_TAG", 8, "calibrationDateTimeTag", "dateTimeType", 1667329140);
        CALIBRATION_DATE_TIME_TAG = r107;
        IccTagTypes r108 = new IccTagTypes("CHAR_TARGET_TAG", 9, "charTargetTag", "textType", 1952543335);
        CHAR_TARGET_TAG = r108;
        IccTagTypes r109 = new IccTagTypes("CHROMATIC_ADAPTATION_TAG", 10, "chromaticAdaptationTag", "s15Fixed16ArrayType", 1667785060);
        CHROMATIC_ADAPTATION_TAG = r109;
        IccTagTypes r111 = new IccTagTypes("CHROMATICITY_TAG", 11, "chromaticityTag", "chromaticityType", 1667789421);
        CHROMATICITY_TAG = r111;
        IccTagTypes r112 = new IccTagTypes("COLORANT_ORDER_TAG", 12, "colorantOrderTag", "colorantOrderType", 1668051567);
        COLORANT_ORDER_TAG = r112;
        IccTagTypes r113 = new IccTagTypes("COLORANT_TABLE_TAG", 13, "colorantTableTag", "colorantTableType", 1668051572);
        COLORANT_TABLE_TAG = r113;
        IccTagTypes r210 = new IccTagTypes("COPYRIGHT_TAG", 14, "copyrightTag", "multiLocalizedUnicodeType", 1668313716);
        COPYRIGHT_TAG = r210;
        IccTagTypes r114 = new IccTagTypes("DEVICE_MFG_DESC_TAG", 15, "deviceMfgDescTag", "multiLocalizedUnicodeType", 1684893284);
        DEVICE_MFG_DESC_TAG = r114;
        IccTagTypes r115 = new IccTagTypes("DEVICE_MODEL_DESC_TAG", 16, "deviceModelDescTag", "multiLocalizedUnicodeType", 1684890724);
        DEVICE_MODEL_DESC_TAG = r115;
        IccTagTypes r116 = new IccTagTypes("GAMUT_TAG", 17, "gamutTag", "lut8Type or lut16Type or lutBtoAType", 1734438260);
        GAMUT_TAG = r116;
        IccTagTypes r117 = new IccTagTypes("GRAY_TRC_TAG", 18, "grayTRCTag", "curveType or parametricCurveType", 1800688195);
        GRAY_TRC_TAG = r117;
        IccTagTypes r118 = new IccTagTypes("GREEN_MATRIX_COLUMN_TAG", 19, "greenMatrixColumnTag", "XYZType", 1733843290);
        GREEN_MATRIX_COLUMN_TAG = r118;
        IccTagTypes r119 = new IccTagTypes("GREEN_TRC_TAG", 20, "greenTRCTag", "curveType or parametricCurveType", 1733579331);
        GREEN_TRC_TAG = r119;
        IccTagTypes r211 = new IccTagTypes("LUMINANCE_TAG", 21, "luminanceTag", "XYZType", 1819635049);
        LUMINANCE_TAG = r211;
        IccTagTypes r212 = new IccTagTypes("MEASUREMENT_TAG", 22, "measurementTag", "measurementType", 1835360627);
        MEASUREMENT_TAG = r212;
        IccTagTypes r213 = new IccTagTypes("MEDIA_BLACK_POINT_TAG", 23, "mediaBlackPointTag", "XYZType", 1651208308);
        MEDIA_BLACK_POINT_TAG = r213;
        IccTagTypes r214 = new IccTagTypes("MEDIA_WHITE_POINT_TAG", 24, "mediaWhitePointTag", "XYZType", 2004119668);
        MEDIA_WHITE_POINT_TAG = r214;
        IccTagTypes r215 = new IccTagTypes("NAMED_COLOR_2_TAG", 25, "namedColor2Tag", "namedColor2Type", 1852009522);
        NAMED_COLOR_2_TAG = r215;
        IccTagTypes r216 = new IccTagTypes("OUTPUT_RESPONSE_TAG", 26, "outputResponseTag", "responseCurveSet16Type", 1919251312);
        OUTPUT_RESPONSE_TAG = r216;
        IccTagTypes r217 = new IccTagTypes("PREVIEW_0_TAG", 27, "preview0Tag", "lut8Type or lut16Type or lutBtoAType", 1886545200);
        PREVIEW_0_TAG = r217;
        IccTagTypes r310 = new IccTagTypes("PREVIEW_1_TAG", 28, "preview1Tag", "lut8Type or lut16Type or lutBtoAType", 1886545201);
        PREVIEW_1_TAG = r310;
        IccTagTypes r218 = new IccTagTypes("PREVIEW_2_TAG", 29, "preview2Tag", "lut8Type or lut16Type or lutBtoAType", 1886545202);
        PREVIEW_2_TAG = r218;
        IccTagTypes r219 = new IccTagTypes("PROFILE_DESCRIPTION_TAG", 30, "profileDescriptionTag", "multiLocalizedUnicodeType", 1684370275);
        PROFILE_DESCRIPTION_TAG = r219;
        IccTagTypes r311 = new IccTagTypes("PROFILE_SEQUENCE_DESC_TAG", 31, "profileSequenceDescTag", "profileSequenceDescType", 1886610801);
        PROFILE_SEQUENCE_DESC_TAG = r311;
        IccTagTypes r312 = new IccTagTypes("RED_MATRIX_COLUMN_TAG", 32, "redMatrixColumnTag", "XYZType", 1918392666);
        RED_MATRIX_COLUMN_TAG = r312;
        IccTagTypes r313 = new IccTagTypes("RED_TRC_TAG", 33, "redTRCTag", "curveType or parametricCurveType", 1918128707);
        RED_TRC_TAG = r313;
        IccTagTypes r314 = new IccTagTypes("TECHNOLOGY_TAG", 34, "technologyTag", "signatureType", 1952801640);
        TECHNOLOGY_TAG = r314;
        IccTagTypes r410 = new IccTagTypes("VIEWING_COND_DESC_TAG", 35, "viewingCondDescTag", "multiLocalizedUnicodeType", 1987405156);
        VIEWING_COND_DESC_TAG = r410;
        IccTagTypes r315 = new IccTagTypes("VIEWING_CONDITIONS_TAG", 36, "viewingConditionsTag", "viewingConditionsType", 1986618743);
        VIEWING_CONDITIONS_TAG = r315;
        $VALUES = new IccTagTypes[]{r100, r101, r102, r103, r104, r105, r106, r110, r107, r108, r109, r111, r112, r113, r210, r114, r115, r116, r117, r118, r119, r211, r212, r213, r214, r215, r216, r217, r310, r218, r219, r311, r312, r313, r314, r410, r315};
    }

    public static IccTagTypes[] values() {
        return (IccTagTypes[]) $VALUES.clone();
    }

    public String getName() {
        return this.name;
    }

    public int getSignature() {
        return this.signature;
    }

    public String getTypeDescription() {
        return this.typeDescription;
    }

    public static IccTagTypes valueOf(String r100) {
        return (IccTagTypes) a.a(IccTagTypes.class, r100);
    }

    private IccTagTypes(String r100, int r101, String r102, String r103, int r104) {
        super(r100, r101);
        this.name = r102;
        this.typeDescription = r103;
        this.signature = r104;
    }
}
