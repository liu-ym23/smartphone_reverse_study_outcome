package com.bytedance.ee.bear.drive.view.preview.ttreader.pdf.tron.structure;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/drive/view/preview/ttreader/pdf/tron/structure/ScrollState;", "", "<init>", "(Ljava/lang/String;I)V", "STOPPED", "STARTED", "SCROLLING", "contentmanager-drive-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ScrollState extends Enum<ScrollState> {
    public static final ScrollState SCROLLING = null;
    public static final ScrollState STARTED = null;
    public static final ScrollState STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ScrollState[] f225411a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f225412b = null;

    public static EnumEntries<ScrollState> getEntries() {
        return f225412b;
    }

    static {
        ScrollState r100 = new ScrollState("STOPPED", 0);
        STOPPED = r100;
        ScrollState r101 = new ScrollState("STARTED", 1);
        STARTED = r101;
        ScrollState r102 = new ScrollState("SCROLLING", 2);
        SCROLLING = r102;
        ScrollState[] r103 = {r100, r101, r102};
        f225411a = r103;
        f225412b = EnumEntriesKt.enumEntries(r103);
    }

    public static ScrollState[] values() {
        return (ScrollState[]) f225411a.clone();
    }

    public static ScrollState valueOf(String r100) {
        return (ScrollState) a.a(ScrollState.class, r100);
    }

    public ScrollState(String r100, int r101) {
        super(r100, r101);
    }
}
