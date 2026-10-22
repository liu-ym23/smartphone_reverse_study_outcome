package com.larus.bmhome.chat.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/bmhome/chat/bean/WidgetEvent;", "", "<init>", "(Ljava/lang/String;I)V", "SCROLL_TO_BOTTOM", "PAGE_UPDATE", "TIMING_SETUP", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WidgetEvent extends Enum<WidgetEvent> {
    public static final WidgetEvent PAGE_UPDATE = null;
    public static final WidgetEvent SCROLL_TO_BOTTOM = null;
    public static final WidgetEvent TIMING_SETUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WidgetEvent[] f297442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f297443b = null;

    public static EnumEntries<WidgetEvent> getEntries() {
        return f297443b;
    }

    static {
        WidgetEvent r100 = new WidgetEvent("SCROLL_TO_BOTTOM", 0);
        SCROLL_TO_BOTTOM = r100;
        WidgetEvent r101 = new WidgetEvent("PAGE_UPDATE", 1);
        PAGE_UPDATE = r101;
        WidgetEvent r102 = new WidgetEvent("TIMING_SETUP", 2);
        TIMING_SETUP = r102;
        WidgetEvent[] r103 = {r100, r101, r102};
        f297442a = r103;
        f297443b = EnumEntriesKt.enumEntries(r103);
    }

    public static WidgetEvent[] values() {
        return (WidgetEvent[]) f297442a.clone();
    }

    public static WidgetEvent valueOf(String r100) {
        return (WidgetEvent) r27.a.a(WidgetEvent.class, r100);
    }

    public WidgetEvent(String r100, int r101) {
        super(r100, r101);
    }
}
