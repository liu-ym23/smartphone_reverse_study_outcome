package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/structure/ScrollState;", "", "<init>", "(Ljava/lang/String;I)V", "STOPPED", "STARTED", "SCROLLING", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScrollState extends Enum<ScrollState> {
    public static final ScrollState SCROLLING = null;
    public static final ScrollState STARTED = null;
    public static final ScrollState STOPPED = null;
    public static final /* synthetic */ ScrollState[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<ScrollState> getEntries() {
        return b;
    }

    static {
        ScrollState r0 = new ScrollState("STOPPED", 0);
        STOPPED = r0;
        ScrollState r1 = new ScrollState("STARTED", 1);
        STARTED = r1;
        ScrollState r3 = new ScrollState("SCROLLING", 2);
        SCROLLING = r3;
        ScrollState[] r5 = {r0, r1, r3};
        a = r5;
        b = EnumEntriesKt.enumEntries(r5);
    }

    public static ScrollState[] values() {
        return (ScrollState[]) a.clone();
    }

    public static ScrollState valueOf(String r1) {
        return (ScrollState) a.a(ScrollState.class, r1);
    }

    public ScrollState(String r1, int r2) {
        super(r1, r2);
    }
}
