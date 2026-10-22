package com.bytedance.lark.pb.im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum ImageTranslateScene extends Enum<ImageTranslateScene> implements WireEnum {
    private static final /* synthetic */ ImageTranslateScene[] $VALUES = null;
    public static final ProtoAdapter<ImageTranslateScene> ADAPTER = null;
    public static final ImageTranslateScene IMAGE_TRANSLATION_IMAGE_VIEWER = null;
    public static final ImageTranslateScene IMAGE_TRANSLATION_SCENE_CHAT = null;
    public static final ImageTranslateScene IMAGE_TRANSLATION_SCENE_FAVORITE = null;
    public static final ImageTranslateScene IMAGE_TRANSLATION_SCENE_MOMENTS = null;
    public static final ImageTranslateScene IMAGE_TRANSLATION_SCENE_TODO = null;
    public static final ImageTranslateScene IMAGE_TRANSLATION_SCENE_UNKNOWN = null;
    private final int value;

    static {
        ImageTranslateScene r100 = new ImageTranslateScene("IMAGE_TRANSLATION_SCENE_UNKNOWN", 0, 0);
        IMAGE_TRANSLATION_SCENE_UNKNOWN = r100;
        ImageTranslateScene r101 = new ImageTranslateScene("IMAGE_TRANSLATION_SCENE_CHAT", 1, 1);
        IMAGE_TRANSLATION_SCENE_CHAT = r101;
        ImageTranslateScene r102 = new ImageTranslateScene("IMAGE_TRANSLATION_SCENE_FAVORITE", 2, 2);
        IMAGE_TRANSLATION_SCENE_FAVORITE = r102;
        ImageTranslateScene r103 = new ImageTranslateScene("IMAGE_TRANSLATION_SCENE_TODO", 3, 3);
        IMAGE_TRANSLATION_SCENE_TODO = r103;
        ImageTranslateScene r104 = new ImageTranslateScene("IMAGE_TRANSLATION_SCENE_MOMENTS", 4, 4);
        IMAGE_TRANSLATION_SCENE_MOMENTS = r104;
        ImageTranslateScene r105 = new ImageTranslateScene("IMAGE_TRANSLATION_IMAGE_VIEWER", 5, 5);
        IMAGE_TRANSLATION_IMAGE_VIEWER = r105;
        $VALUES = new ImageTranslateScene[]{r100, r101, r102, r103, r104, r105};
        ADAPTER = ProtoAdapter.newEnumAdapter(ImageTranslateScene.class);
    }

    public static ImageTranslateScene[] values() {
        return (ImageTranslateScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static ImageTranslateScene fromValue(int r100) {
        if (r100 == 0) goto L26;
        if (r100 == 1) goto L24;
        if (r100 == 2) goto L22;
        if (r100 == 3) goto L20;
        if (r100 == 4) goto L18;
        if (r100 == 5) goto L16;
        return null;
    L16:
        return IMAGE_TRANSLATION_IMAGE_VIEWER;
    L18:
        return IMAGE_TRANSLATION_SCENE_MOMENTS;
    L20:
        return IMAGE_TRANSLATION_SCENE_TODO;
    L22:
        return IMAGE_TRANSLATION_SCENE_FAVORITE;
    L24:
        return IMAGE_TRANSLATION_SCENE_CHAT;
    L26:
        return IMAGE_TRANSLATION_SCENE_UNKNOWN;
    }

    public static ImageTranslateScene valueOf(String r100) {
        return (ImageTranslateScene) a.a(ImageTranslateScene.class, r100);
    }

    private ImageTranslateScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
