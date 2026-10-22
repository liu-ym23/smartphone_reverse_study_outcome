package com.bytedance.locallife.poi.media.entity;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/locallife/poi/media/entity/PoiMediaStyle;", "", "", "style", "I", "getStyle", "()I", "POI_MEDIA_STYLE_VIDEO", "POI_MEDIA_STYLE_PHOTOS", "POI_MEDIA_STYLE_INTERACT", "POI_MEDIA_VR_MODEL", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiMediaStyle extends Enum<PoiMediaStyle> {
    public static final PoiMediaStyle POI_MEDIA_STYLE_INTERACT = null;
    public static final PoiMediaStyle POI_MEDIA_STYLE_PHOTOS = null;
    public static final PoiMediaStyle POI_MEDIA_STYLE_VIDEO = null;
    public static final PoiMediaStyle POI_MEDIA_VR_MODEL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiMediaStyle[] f262667a = null;
    private final int style;

    public static PoiMediaStyle valueOf(String r100) {
        return (PoiMediaStyle) a.a(PoiMediaStyle.class, r100);
    }

    public static PoiMediaStyle[] values() {
        return (PoiMediaStyle[]) f262667a.clone();
    }

    static {
        PoiMediaStyle r100 = new PoiMediaStyle("POI_MEDIA_STYLE_VIDEO", 0, 1);
        POI_MEDIA_STYLE_VIDEO = r100;
        PoiMediaStyle r101 = new PoiMediaStyle("POI_MEDIA_STYLE_PHOTOS", 1, 2);
        POI_MEDIA_STYLE_PHOTOS = r101;
        PoiMediaStyle r102 = new PoiMediaStyle("POI_MEDIA_STYLE_INTERACT", 2, 3);
        POI_MEDIA_STYLE_INTERACT = r102;
        PoiMediaStyle r103 = new PoiMediaStyle("POI_MEDIA_VR_MODEL", 3, 4);
        POI_MEDIA_VR_MODEL = r103;
        f262667a = new PoiMediaStyle[]{r100, r101, r102, r103};
    }

    public final int getStyle() {
        return this.style;
    }

    public PoiMediaStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.style = r102;
    }
}
