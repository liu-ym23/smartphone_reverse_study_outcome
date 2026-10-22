package com.obric.memorydata.sdk.screencapture.rule;

import com.obric.miniapp.alarm.AlarmSessionType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/SearchNodeEnum;", "", "<init>", "(Ljava/lang/String;I)V", AlarmSessionType.EVENT, "SOURCE", "ROOT_VIEW_TREE", "TOUCH_POSITION", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final enum SearchNodeEnum extends Enum<SearchNodeEnum> {
    public static final SearchNodeEnum EVENT = null;
    public static final SearchNodeEnum ROOT_VIEW_TREE = null;
    public static final SearchNodeEnum SOURCE = null;
    public static final SearchNodeEnum TOUCH_POSITION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SearchNodeEnum[] f397289a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f397290b = null;

    public static EnumEntries<SearchNodeEnum> getEntries() {
        return f397290b;
    }

    static {
        SearchNodeEnum r100 = new SearchNodeEnum(AlarmSessionType.EVENT, 0);
        EVENT = r100;
        SearchNodeEnum r101 = new SearchNodeEnum("SOURCE", 1);
        SOURCE = r101;
        SearchNodeEnum r102 = new SearchNodeEnum("ROOT_VIEW_TREE", 2);
        ROOT_VIEW_TREE = r102;
        SearchNodeEnum r103 = new SearchNodeEnum("TOUCH_POSITION", 3);
        TOUCH_POSITION = r103;
        SearchNodeEnum[] r104 = {r100, r101, r102, r103};
        f397289a = r104;
        f397290b = EnumEntriesKt.enumEntries(r104);
    }

    public static SearchNodeEnum[] values() {
        return (SearchNodeEnum[]) f397289a.clone();
    }

    public static SearchNodeEnum valueOf(String r100) {
        return (SearchNodeEnum) a.a(SearchNodeEnum.class, r100);
    }

    public SearchNodeEnum(String r100, int r101) {
        super(r100, r101);
    }
}
