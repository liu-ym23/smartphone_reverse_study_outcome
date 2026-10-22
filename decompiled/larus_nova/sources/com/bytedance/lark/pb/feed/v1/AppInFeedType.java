package com.bytedance.lark.pb.feed.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum AppInFeedType extends Enum<AppInFeedType> implements WireEnum {
    private static final /* synthetic */ AppInFeedType[] $VALUES = null;
    public static final ProtoAdapter<AppInFeedType> ADAPTER = null;
    public static final AppInFeedType Calendar = null;
    public static final AppInFeedType Meeting = null;
    public static final AppInFeedType Unkonwn = null;
    private final int value;

    static {
        AppInFeedType r100 = new AppInFeedType("Unkonwn", 0, 0);
        Unkonwn = r100;
        AppInFeedType r101 = new AppInFeedType("Meeting", 1, 1);
        Meeting = r101;
        AppInFeedType r102 = new AppInFeedType("Calendar", 2, 2);
        Calendar = r102;
        $VALUES = new AppInFeedType[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(AppInFeedType.class);
    }

    public static AppInFeedType[] values() {
        return (AppInFeedType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AppInFeedType fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return Calendar;
    L12:
        return Meeting;
    L14:
        return Unkonwn;
    }

    public static AppInFeedType valueOf(String r100) {
        return (AppInFeedType) a.a(AppInFeedType.class, r100);
    }

    private AppInFeedType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
