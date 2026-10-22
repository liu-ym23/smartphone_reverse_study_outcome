package com.bytedance.locallife.model.album;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/locallife/model/album/PageType;", "", "", "value", "I", "getValue", "()I", "PoiAlbum", "PoiVideo", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PageType extends Enum<PageType> {
    public static final PageType PoiAlbum = null;
    public static final PageType PoiVideo = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageType[] f260849a = null;
    private final int value;

    public static PageType valueOf(String r100) {
        return (PageType) a.a(PageType.class, r100);
    }

    public static PageType[] values() {
        return (PageType[]) f260849a.clone();
    }

    static {
        PageType r100 = new PageType("PoiAlbum", 0, 0);
        PoiAlbum = r100;
        PageType r101 = new PageType("PoiVideo", 1, 1);
        PoiVideo = r101;
        f260849a = new PageType[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public PageType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
