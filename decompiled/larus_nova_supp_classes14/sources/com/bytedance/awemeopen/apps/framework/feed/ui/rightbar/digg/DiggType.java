package com.bytedance.awemeopen.apps.framework.feed.ui.rightbar.digg;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/feed/ui/rightbar/digg/DiggType;", "", "from_click_right_bar", "from_double_click_video", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final enum DiggType extends Enum<DiggType> {
    public static final /* synthetic */ DiggType[] a = null;
    public static final DiggType from_click_right_bar = null;
    public static final DiggType from_double_click_video = null;

    public static DiggType valueOf(String r1) {
        return (DiggType) a.a(DiggType.class, r1);
    }

    public static DiggType[] values() {
        return (DiggType[]) a.clone();
    }

    static {
        DiggType r0 = new DiggType("from_click_right_bar", 0);
        from_click_right_bar = r0;
        DiggType r1 = new DiggType("from_double_click_video", 1);
        from_double_click_video = r1;
        a = new DiggType[]{r0, r1};
    }

    public DiggType(String r1, int r2) {
        super(r1, r2);
    }
}
