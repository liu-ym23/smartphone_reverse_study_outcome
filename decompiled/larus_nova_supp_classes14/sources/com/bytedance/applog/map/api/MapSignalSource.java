package com.bytedance.applog.map.api;

import com.bytedance.apm.constant.UploadTypeInf;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applog/map/api/MapSignalSource;", "", "", "getSource", "source", "Ljava/lang/String;", "CLICK_BEFORE", "CLICK_AFTER", "PAGE_ENTERED", "TIMER", "TIMER_UPDATE", "MORE_DELAY", "DIALOG_SHOW", "DIALOG_HIDDEN", "ROOT_VIEW_ADDED", "ROOT_VIEW_REMOVED", "COLD_START", "CUSTOM", "PLACEHOLDER", "map-api_release"}, k = 1, mv = {1, 6, 0})
public final enum MapSignalSource extends Enum<MapSignalSource> {
    public static final MapSignalSource CLICK_AFTER = null;
    public static final MapSignalSource CLICK_BEFORE = null;
    public static final MapSignalSource COLD_START = null;
    public static final MapSignalSource CUSTOM = null;
    public static final MapSignalSource DIALOG_HIDDEN = null;
    public static final MapSignalSource DIALOG_SHOW = null;
    public static final MapSignalSource MORE_DELAY = null;
    public static final MapSignalSource PAGE_ENTERED = null;
    public static final MapSignalSource PLACEHOLDER = null;
    public static final MapSignalSource ROOT_VIEW_ADDED = null;
    public static final MapSignalSource ROOT_VIEW_REMOVED = null;
    public static final MapSignalSource TIMER = null;
    public static final MapSignalSource TIMER_UPDATE = null;
    public static final /* synthetic */ MapSignalSource[] a = null;
    private final String source;

    public static MapSignalSource valueOf(String r1) {
        return (MapSignalSource) r27.a.a(MapSignalSource.class, r1);
    }

    public static MapSignalSource[] values() {
        return (MapSignalSource[]) a.clone();
    }

    static {
        MapSignalSource r0 = new MapSignalSource("CLICK_BEFORE", 0, "click_before");
        CLICK_BEFORE = r0;
        MapSignalSource r1 = new MapSignalSource("CLICK_AFTER", 1, "click_after");
        CLICK_AFTER = r1;
        MapSignalSource r2 = new MapSignalSource("PAGE_ENTERED", 2, "page_entered");
        PAGE_ENTERED = r2;
        MapSignalSource r4 = new MapSignalSource("TIMER", 3, UploadTypeInf.TIMER);
        TIMER = r4;
        MapSignalSource r6 = new MapSignalSource("TIMER_UPDATE", 4, "timer_update");
        TIMER_UPDATE = r6;
        MapSignalSource r8 = new MapSignalSource("MORE_DELAY", 5, "more_delay");
        MORE_DELAY = r8;
        MapSignalSource r10 = new MapSignalSource("DIALOG_SHOW", 6, "dialog_show");
        DIALOG_SHOW = r10;
        MapSignalSource r12 = new MapSignalSource("DIALOG_HIDDEN", 7, "dialog_hidden");
        DIALOG_HIDDEN = r12;
        MapSignalSource r14 = new MapSignalSource("ROOT_VIEW_ADDED", 8, "root_view_added");
        ROOT_VIEW_ADDED = r14;
        MapSignalSource r13 = new MapSignalSource("ROOT_VIEW_REMOVED", 9, "root_view_removed");
        ROOT_VIEW_REMOVED = r13;
        MapSignalSource r11 = new MapSignalSource("COLD_START", 10, "cold_start");
        COLD_START = r11;
        MapSignalSource r9 = new MapSignalSource("CUSTOM", 11, "custom");
        CUSTOM = r9;
        MapSignalSource r7 = new MapSignalSource("PLACEHOLDER", 12, "placeholder");
        PLACEHOLDER = r7;
        a = new MapSignalSource[]{r0, r1, r2, r4, r6, r8, r10, r12, r14, r13, r11, r9, r7};
    }

    public final String getSource() {
        return this.source;
    }

    public MapSignalSource(String r1, int r2, String r3) {
        super(r1, r2);
        this.source = r3;
    }
}
