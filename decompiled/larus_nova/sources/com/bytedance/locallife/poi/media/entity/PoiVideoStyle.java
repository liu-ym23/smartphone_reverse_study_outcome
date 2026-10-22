package com.bytedance.locallife.poi.media.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/poi/media/entity/PoiVideoStyle;", "", "", "style", "I", "getStyle", "()I", "VIDEO_STYLE_LYNX", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiVideoStyle extends Enum<PoiVideoStyle> {
    public static final PoiVideoStyle VIDEO_STYLE_LYNX = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiVideoStyle[] f262669a = null;
    private final int style;

    public static PoiVideoStyle valueOf(String r100) {
        return (PoiVideoStyle) a.a(PoiVideoStyle.class, r100);
    }

    public static PoiVideoStyle[] values() {
        return (PoiVideoStyle[]) f262669a.clone();
    }

    static {
        PoiVideoStyle r100 = new PoiVideoStyle();
        VIDEO_STYLE_LYNX = r100;
        f262669a = new PoiVideoStyle[]{r100};
    }

    public PoiVideoStyle() {
        super("VIDEO_STYLE_LYNX", 0);
        this.style = 0;
    }

    public final int getStyle() {
        return this.style;
    }
}
