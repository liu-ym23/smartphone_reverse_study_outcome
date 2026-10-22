package com.google.zxing;

import com.larus.dora.api.model.FlowDoraWifiScene;
import java.util.List;

/* JADX INFO: loaded from: classes23.dex */
public final enum DecodeHintType extends Enum<DecodeHintType> {
    public static final DecodeHintType ALLOWED_EAN_EXTENSIONS = null;
    public static final DecodeHintType ALLOWED_LENGTHS = null;
    public static final DecodeHintType ALSO_INVERTED = null;
    public static final DecodeHintType ASSUME_CODE_39_CHECK_DIGIT = null;
    public static final DecodeHintType ASSUME_GS1 = null;
    public static final DecodeHintType CHARACTER_SET = null;
    public static final DecodeHintType NEED_RESULT_POINT_CALLBACK = null;
    public static final DecodeHintType OTHER = null;
    public static final DecodeHintType POSSIBLE_FORMATS = null;
    public static final DecodeHintType PURE_BARCODE = null;
    public static final DecodeHintType RETURN_CODABAR_START_END = null;
    public static final DecodeHintType TRY_HARDER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DecodeHintType[] f275932a = null;
    private final Class<?> valueType;

    static {
        DecodeHintType r100 = new DecodeHintType(FlowDoraWifiScene.OTHER, 0, Object.class);
        OTHER = r100;
        DecodeHintType r101 = new DecodeHintType("PURE_BARCODE", 1, Void.class);
        PURE_BARCODE = r101;
        DecodeHintType r102 = new DecodeHintType("POSSIBLE_FORMATS", 2, List.class);
        POSSIBLE_FORMATS = r102;
        DecodeHintType r103 = new DecodeHintType("TRY_HARDER", 3, Void.class);
        TRY_HARDER = r103;
        DecodeHintType r104 = new DecodeHintType("CHARACTER_SET", 4, String.class);
        CHARACTER_SET = r104;
        DecodeHintType r105 = new DecodeHintType("ALLOWED_LENGTHS", 5, int[].class);
        ALLOWED_LENGTHS = r105;
        DecodeHintType r110 = new DecodeHintType("ASSUME_CODE_39_CHECK_DIGIT", 6, Void.class);
        ASSUME_CODE_39_CHECK_DIGIT = r110;
        DecodeHintType r111 = new DecodeHintType("ASSUME_GS1", 7, Void.class);
        ASSUME_GS1 = r111;
        DecodeHintType r112 = new DecodeHintType("RETURN_CODABAR_START_END", 8, Void.class);
        RETURN_CODABAR_START_END = r112;
        DecodeHintType r113 = new DecodeHintType("NEED_RESULT_POINT_CALLBACK", 9, e.class);
        NEED_RESULT_POINT_CALLBACK = r113;
        DecodeHintType r106 = new DecodeHintType("ALLOWED_EAN_EXTENSIONS", 10, int[].class);
        ALLOWED_EAN_EXTENSIONS = r106;
        DecodeHintType r114 = new DecodeHintType("ALSO_INVERTED", 11, Void.class);
        ALSO_INVERTED = r114;
        f275932a = new DecodeHintType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r106, r114};
    }

    public static DecodeHintType[] values() {
        return (DecodeHintType[]) f275932a.clone();
    }

    public Class<?> getValueType() {
        return this.valueType;
    }

    public static DecodeHintType valueOf(String r100) {
        return (DecodeHintType) r27.a.a(DecodeHintType.class, r100);
    }

    public DecodeHintType(String r100, int r101, Class r102) {
        super(r100, r101);
        this.valueType = r102;
    }
}
