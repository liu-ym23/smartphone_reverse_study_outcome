package com.bytedance.locallife.biz.monitor.param;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/biz/monitor/param/KeyPageShowEvent;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "POI_PAGE_SHOW", "PDP_PAGE_SHOW", "CONFIRM_PAGE_SHOW", "locallife-biz-common_release"}, k = 1, mv = {1, 4, 3})
public final enum KeyPageShowEvent extends Enum<KeyPageShowEvent> {
    public static final KeyPageShowEvent CONFIRM_PAGE_SHOW = null;
    public static final KeyPageShowEvent PDP_PAGE_SHOW = null;
    public static final KeyPageShowEvent POI_PAGE_SHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ KeyPageShowEvent[] f256713a = null;
    private final String value;

    public static KeyPageShowEvent valueOf(String r100) {
        return (KeyPageShowEvent) r27.a.a(KeyPageShowEvent.class, r100);
    }

    public static KeyPageShowEvent[] values() {
        return (KeyPageShowEvent[]) f256713a.clone();
    }

    static {
        KeyPageShowEvent r100 = new KeyPageShowEvent("POI_PAGE_SHOW", 0, "enter_poi_detail");
        POI_PAGE_SHOW = r100;
        KeyPageShowEvent r101 = new KeyPageShowEvent("PDP_PAGE_SHOW", 1, "project_detail_show");
        PDP_PAGE_SHOW = r101;
        KeyPageShowEvent r102 = new KeyPageShowEvent("CONFIRM_PAGE_SHOW", 2, "project_confirm_show");
        CONFIRM_PAGE_SHOW = r102;
        f256713a = new KeyPageShowEvent[]{r100, r101, r102};
    }

    public final String getValue() {
        return this.value;
    }

    public KeyPageShowEvent(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
