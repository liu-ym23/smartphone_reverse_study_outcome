package com.bytedance.locallife.biz.monitor.param;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/biz/monitor/param/KeyPageName;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "POI_PAGE", "PDP_PAGE", "CONFIRM_PAGE", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final enum KeyPageName extends Enum<KeyPageName> {
    public static final KeyPageName CONFIRM_PAGE = null;
    public static final KeyPageName PDP_PAGE = null;
    public static final KeyPageName POI_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyPageName[] f256712a = null;
    private final String value;

    public static KeyPageName valueOf(String r100) {
        return (KeyPageName) r27.a.a(KeyPageName.class, r100);
    }

    public static KeyPageName[] values() {
        return (KeyPageName[]) f256712a.clone();
    }

    static {
        KeyPageName r100 = new KeyPageName("POI_PAGE", 0, "poi_page");
        POI_PAGE = r100;
        KeyPageName r101 = new KeyPageName("PDP_PAGE", 1, "project_detail_page");
        PDP_PAGE = r101;
        KeyPageName r102 = new KeyPageName("CONFIRM_PAGE", 2, "project_confirm_page");
        CONFIRM_PAGE = r102;
        f256712a = new KeyPageName[]{r100, r101, r102};
    }

    public final String getValue() {
        return this.value;
    }

    public KeyPageName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
