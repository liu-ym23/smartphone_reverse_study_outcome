package com.larksuite.component.universe_design.notice.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larksuite/component/universe_design/notice/compose/UDNoticeType;", "", "<init>", "(Ljava/lang/String;I)V", "Info", "Success", "Warning", "Error", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDNoticeType extends Enum<UDNoticeType> {
    public static final UDNoticeType Error = null;
    public static final UDNoticeType Info = null;
    public static final UDNoticeType Success = null;
    public static final UDNoticeType Warning = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDNoticeType[] f285191a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285192b = null;

    public static EnumEntries<UDNoticeType> getEntries() {
        return f285192b;
    }

    static {
        UDNoticeType r100 = new UDNoticeType("Info", 0);
        Info = r100;
        UDNoticeType r101 = new UDNoticeType("Success", 1);
        Success = r101;
        UDNoticeType r102 = new UDNoticeType("Warning", 2);
        Warning = r102;
        UDNoticeType r103 = new UDNoticeType("Error", 3);
        Error = r103;
        UDNoticeType[] r104 = {r100, r101, r102, r103};
        f285191a = r104;
        f285192b = EnumEntriesKt.enumEntries(r104);
    }

    public static UDNoticeType[] values() {
        return (UDNoticeType[]) f285191a.clone();
    }

    public static UDNoticeType valueOf(String r100) {
        return (UDNoticeType) r27.a.a(UDNoticeType.class, r100);
    }

    public UDNoticeType(String r100, int r101) {
        super(r100, r101);
    }
}
