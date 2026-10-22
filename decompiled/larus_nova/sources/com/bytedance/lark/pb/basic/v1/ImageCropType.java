package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ImageCropType extends Enum<ImageCropType> implements WireEnum {
    private static final /* synthetic */ ImageCropType[] $VALUES = null;
    public static final ProtoAdapter<ImageCropType> ADAPTER = null;
    public static final ImageCropType COVER = null;
    public static final ImageCropType INTACT = null;
    public static final ImageCropType MIDDLE = null;
    public static final ImageCropType MIDDLE_MP4 = null;
    public static final ImageCropType MIDDLE_WEBP = null;
    public static final ImageCropType ORIGIN = null;
    public static final ImageCropType THUMB = null;
    public static final ImageCropType THUMB_WEBP = null;
    private final int value;

    static {
        ImageCropType r100 = new ImageCropType("ORIGIN", 0, 1);
        ORIGIN = r100;
        ImageCropType r101 = new ImageCropType("MIDDLE", 1, 2);
        MIDDLE = r101;
        ImageCropType r102 = new ImageCropType("THUMB", 2, 3);
        THUMB = r102;
        ImageCropType r103 = new ImageCropType("MIDDLE_WEBP", 3, 4);
        MIDDLE_WEBP = r103;
        ImageCropType r104 = new ImageCropType("THUMB_WEBP", 4, 5);
        THUMB_WEBP = r104;
        ImageCropType r110 = new ImageCropType("MIDDLE_MP4", 5, 6);
        MIDDLE_MP4 = r110;
        ImageCropType r111 = new ImageCropType("COVER", 6, 7);
        COVER = r111;
        ImageCropType r112 = new ImageCropType("INTACT", 7, 8);
        INTACT = r112;
        $VALUES = new ImageCropType[]{r100, r101, r102, r103, r104, r110, r111, r112};
        ADAPTER = ProtoAdapter.newEnumAdapter(ImageCropType.class);
    }

    public static ImageCropType[] values() {
        return (ImageCropType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ImageCropType fromValue(int r100) {
        switch(r100) {
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return INTACT;
    L8:
        return COVER;
    L10:
        return MIDDLE_MP4;
    L12:
        return THUMB_WEBP;
    L14:
        return MIDDLE_WEBP;
    L16:
        return THUMB;
    L18:
        return MIDDLE;
    L20:
        return ORIGIN;
    }

    public static ImageCropType valueOf(String r100) {
        return (ImageCropType) a.a(ImageCropType.class, r100);
    }

    private ImageCropType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
