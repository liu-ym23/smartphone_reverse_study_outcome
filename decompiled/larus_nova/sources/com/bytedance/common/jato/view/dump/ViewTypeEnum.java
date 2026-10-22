package com.bytedance.common.jato.view.dump;

import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ss.texturerender.VideoSurfaceTexture;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum ViewTypeEnum extends Enum<ViewTypeEnum> {
    private static final /* synthetic */ ViewTypeEnum[] $VALUES = null;
    public static final ViewTypeEnum group = null;
    public static final ViewTypeEnum image = null;
    public static final ViewTypeEnum normal = null;
    public static final ViewTypeEnum surface = null;
    public static final ViewTypeEnum text = null;
    public static final ViewTypeEnum texture = null;
    public final int index;
    public final Class<? extends View> type;

    static {
        ViewTypeEnum r100 = new ViewTypeEnum("text", 0, TextView.class, 2);
        text = r100;
        ViewTypeEnum r101 = new ViewTypeEnum("image", 1, ImageView.class, 3);
        image = r101;
        ViewTypeEnum r102 = new ViewTypeEnum(VideoSurfaceTexture.KEY_TEXTURE, 2, TextureView.class, 4);
        texture = r102;
        ViewTypeEnum r103 = new ViewTypeEnum("surface", 3, SurfaceView.class, 5);
        surface = r103;
        ViewTypeEnum r104 = new ViewTypeEnum("group", 4, ViewGroup.class, 1);
        group = r104;
        ViewTypeEnum r110 = new ViewTypeEnum("normal", 5, View.class, 0);
        normal = r110;
        $VALUES = new ViewTypeEnum[]{r100, r101, r102, r103, r104, r110};
    }

    public static ViewTypeEnum[] values() {
        return (ViewTypeEnum[]) $VALUES.clone();
    }

    public static ViewTypeEnum valueOf(String r100) {
        return (ViewTypeEnum) a.a(ViewTypeEnum.class, r100);
    }

    private ViewTypeEnum(String r100, int r101, Class r102, int r103) {
        super(r100, r101);
        this.type = r102;
        this.index = r103;
    }
}
