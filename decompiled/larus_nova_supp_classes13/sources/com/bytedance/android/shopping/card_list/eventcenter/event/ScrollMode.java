package com.bytedance.android.shopping.card_list.eventcenter.event;

import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/card_list/eventcenter/event/ScrollMode;", "", "TOP", "CENTER", "BOTTOM", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ScrollMode extends Enum<ScrollMode> {
    public static final ScrollMode BOTTOM = null;
    public static final ScrollMode CENTER = null;
    public static final ScrollMode TOP = null;
    public static final /* synthetic */ ScrollMode[] a = null;

    static {
        ScrollMode r1 = new ScrollMode("TOP", 0);
        TOP = r1;
        ScrollMode r2 = new ScrollMode("CENTER", 1);
        CENTER = r2;
        ScrollMode r3 = new ScrollMode("BOTTOM", 2);
        BOTTOM = r3;
        a = new ScrollMode[]{r1, r2, r3};
    }

    public static ScrollMode valueOf(String r1) {
        return (ScrollMode) r27.a.a(ScrollMode.class, r1);
    }

    public static ScrollMode[] values() {
        return (ScrollMode[]) a.clone();
    }

    public ScrollMode(String r1, int r2) {
        super(r1, r2);
    }
}
