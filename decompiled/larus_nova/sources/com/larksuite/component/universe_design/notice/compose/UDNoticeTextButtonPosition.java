package com.larksuite.component.universe_design.notice.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larksuite/component/universe_design/notice/compose/UDNoticeTextButtonPosition;", "", "<init>", "(Ljava/lang/String;I)V", "Right", "Bottom", "Auto", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDNoticeTextButtonPosition extends Enum<UDNoticeTextButtonPosition> {
    public static final UDNoticeTextButtonPosition Auto = null;
    public static final UDNoticeTextButtonPosition Bottom = null;
    public static final UDNoticeTextButtonPosition Right = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDNoticeTextButtonPosition[] f285189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285190b = null;

    public static EnumEntries<UDNoticeTextButtonPosition> getEntries() {
        return f285190b;
    }

    static {
        UDNoticeTextButtonPosition r100 = new UDNoticeTextButtonPosition("Right", 0);
        Right = r100;
        UDNoticeTextButtonPosition r101 = new UDNoticeTextButtonPosition("Bottom", 1);
        Bottom = r101;
        UDNoticeTextButtonPosition r102 = new UDNoticeTextButtonPosition("Auto", 2);
        Auto = r102;
        UDNoticeTextButtonPosition[] r103 = {r100, r101, r102};
        f285189a = r103;
        f285190b = EnumEntriesKt.enumEntries(r103);
    }

    public static UDNoticeTextButtonPosition[] values() {
        return (UDNoticeTextButtonPosition[]) f285189a.clone();
    }

    public static UDNoticeTextButtonPosition valueOf(String r100) {
        return (UDNoticeTextButtonPosition) r27.a.a(UDNoticeTextButtonPosition.class, r100);
    }

    public UDNoticeTextButtonPosition(String r100, int r101) {
        super(r100, r101);
    }
}
