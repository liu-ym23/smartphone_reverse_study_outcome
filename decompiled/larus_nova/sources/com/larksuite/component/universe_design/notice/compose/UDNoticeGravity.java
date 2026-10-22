package com.larksuite.component.universe_design.notice.compose;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larksuite/component/universe_design/notice/compose/UDNoticeGravity;", "", "<init>", "(Ljava/lang/String;I)V", "Left", "Center", "universe-ui-notice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UDNoticeGravity extends Enum<UDNoticeGravity> {
    public static final UDNoticeGravity Center = null;
    public static final UDNoticeGravity Left = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UDNoticeGravity[] f285187a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f285188b = null;

    public static EnumEntries<UDNoticeGravity> getEntries() {
        return f285188b;
    }

    static {
        UDNoticeGravity r100 = new UDNoticeGravity("Left", 0);
        Left = r100;
        UDNoticeGravity r101 = new UDNoticeGravity("Center", 1);
        Center = r101;
        UDNoticeGravity[] r102 = {r100, r101};
        f285187a = r102;
        f285188b = EnumEntriesKt.enumEntries(r102);
    }

    public static UDNoticeGravity[] values() {
        return (UDNoticeGravity[]) f285187a.clone();
    }

    public static UDNoticeGravity valueOf(String r100) {
        return (UDNoticeGravity) r27.a.a(UDNoticeGravity.class, r100);
    }

    public UDNoticeGravity(String r100, int r101) {
        super(r100, r101);
    }
}
