package com.bytedance.live.zdanmaku.render.canvas.template;

import com.bumptech.glide.Registry;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/live/zdanmaku/render/canvas/template/SnapType;", "", "Picture", Registry.BUCKET_BITMAP, "zdanmaku_release"}, k = 1, mv = {1, 4, 0})
public final enum SnapType extends Enum<SnapType> {
    public static final SnapType Bitmap = null;
    public static final SnapType Picture = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SnapType[] f255888a = null;

    static {
        SnapType r100 = new SnapType("Picture", 0);
        Picture = r100;
        SnapType r101 = new SnapType(Registry.BUCKET_BITMAP, 1);
        Bitmap = r101;
        f255888a = new SnapType[]{r100, r101};
    }

    public static SnapType valueOf(String r100) {
        return (SnapType) a.a(SnapType.class, r100);
    }

    public static SnapType[] values() {
        return (SnapType[]) f255888a.clone();
    }

    public SnapType(String r100, int r101) {
        super(r100, r101);
    }
}
