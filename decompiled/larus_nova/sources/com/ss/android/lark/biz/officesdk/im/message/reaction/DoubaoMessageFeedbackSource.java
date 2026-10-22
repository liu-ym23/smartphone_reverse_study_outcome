package com.ss.android.lark.biz.officesdk.im.message.reaction;

import com.bytedance.ee.bear.sheet.fab.FabItem;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/biz/officesdk/im/message/reaction/DoubaoMessageFeedbackSource;", "", "<init>", "(Ljava/lang/String;I)V", FabItem.FabSheetItem.CellType.CELL, "MENU", "officesdk-im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoubaoMessageFeedbackSource extends Enum<DoubaoMessageFeedbackSource> {
    public static final DoubaoMessageFeedbackSource CELL = null;
    public static final DoubaoMessageFeedbackSource MENU = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoubaoMessageFeedbackSource[] f410609a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410610b = null;

    public static EnumEntries<DoubaoMessageFeedbackSource> getEntries() {
        return f410610b;
    }

    static {
        DoubaoMessageFeedbackSource r100 = new DoubaoMessageFeedbackSource(FabItem.FabSheetItem.CellType.CELL, 0);
        CELL = r100;
        DoubaoMessageFeedbackSource r101 = new DoubaoMessageFeedbackSource("MENU", 1);
        MENU = r101;
        DoubaoMessageFeedbackSource[] r102 = {r100, r101};
        f410609a = r102;
        f410610b = EnumEntriesKt.enumEntries(r102);
    }

    public static DoubaoMessageFeedbackSource[] values() {
        return (DoubaoMessageFeedbackSource[]) f410609a.clone();
    }

    public static DoubaoMessageFeedbackSource valueOf(String r100) {
        return (DoubaoMessageFeedbackSource) a.a(DoubaoMessageFeedbackSource.class, r100);
    }

    public DoubaoMessageFeedbackSource(String r100, int r101) {
        super(r100, r101);
    }
}
