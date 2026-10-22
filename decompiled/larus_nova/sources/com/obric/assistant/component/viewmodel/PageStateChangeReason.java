package com.obric.assistant.component.viewmodel;

import com.larus.dora.api.model.FlowDoraWifiScene;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/component/viewmodel/PageStateChangeReason;", "", "<init>", "(Ljava/lang/String;I)V", FlowDoraWifiScene.OTHER, "PANEL_RESHOW", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PageStateChangeReason extends Enum<PageStateChangeReason> {
    public static final PageStateChangeReason OTHER = null;
    public static final PageStateChangeReason PANEL_RESHOW = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageStateChangeReason[] f388977a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f388978b = null;

    public static EnumEntries<PageStateChangeReason> getEntries() {
        return f388978b;
    }

    static {
        PageStateChangeReason r100 = new PageStateChangeReason(FlowDoraWifiScene.OTHER, 0);
        OTHER = r100;
        PageStateChangeReason r101 = new PageStateChangeReason("PANEL_RESHOW", 1);
        PANEL_RESHOW = r101;
        PageStateChangeReason[] r102 = {r100, r101};
        f388977a = r102;
        f388978b = EnumEntriesKt.enumEntries(r102);
    }

    public static PageStateChangeReason[] values() {
        return (PageStateChangeReason[]) f388977a.clone();
    }

    public static PageStateChangeReason valueOf(String r100) {
        return (PageStateChangeReason) a.a(PageStateChangeReason.class, r100);
    }

    public PageStateChangeReason(String r100, int r101) {
        super(r100, r101);
    }
}
