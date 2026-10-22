package com.bytedance.locallife.groupon.struct;

import com.bytedance.ai.api.navi.AppletNaviType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/PicCategory;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "PIC_POI_HEADER", "PIC_POI_BG", "PIC_POI", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum PicCategory extends Enum<PicCategory> {
    public static final PicCategory PIC_POI = null;
    public static final PicCategory PIC_POI_BG = null;
    public static final PicCategory PIC_POI_HEADER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PicCategory[] f258836a = null;
    private final String value;

    public static PicCategory valueOf(String r100) {
        return (PicCategory) r27.a.a(PicCategory.class, r100);
    }

    public static PicCategory[] values() {
        return (PicCategory[]) f258836a.clone();
    }

    static {
        PicCategory r100 = new PicCategory("PIC_POI_HEADER", 0, "header");
        PIC_POI_HEADER = r100;
        PicCategory r101 = new PicCategory("PIC_POI_BG", 1, "bg");
        PIC_POI_BG = r101;
        PicCategory r102 = new PicCategory("PIC_POI", 2, AppletNaviType.POI);
        PIC_POI = r102;
        f258836a = new PicCategory[]{r100, r101, r102};
    }

    public final String getValue() {
        return this.value;
    }

    public PicCategory(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
