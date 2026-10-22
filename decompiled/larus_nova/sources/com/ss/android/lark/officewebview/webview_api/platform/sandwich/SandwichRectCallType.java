package com.ss.android.lark.officewebview.webview_api.platform.sandwich;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/officewebview/webview_api/platform/sandwich/SandwichRectCallType;", "", "<init>", "(Ljava/lang/String;I)V", "Show", "UpdateBounds", "UpdateScroll", "webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SandwichRectCallType extends Enum<SandwichRectCallType> {
    public static final SandwichRectCallType Show = null;
    public static final SandwichRectCallType UpdateBounds = null;
    public static final SandwichRectCallType UpdateScroll = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SandwichRectCallType[] f437581a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f437582b = null;

    public static EnumEntries<SandwichRectCallType> getEntries() {
        return f437582b;
    }

    static {
        SandwichRectCallType r100 = new SandwichRectCallType("Show", 0);
        Show = r100;
        SandwichRectCallType r101 = new SandwichRectCallType("UpdateBounds", 1);
        UpdateBounds = r101;
        SandwichRectCallType r102 = new SandwichRectCallType("UpdateScroll", 2);
        UpdateScroll = r102;
        SandwichRectCallType[] r103 = {r100, r101, r102};
        f437581a = r103;
        f437582b = EnumEntriesKt.enumEntries(r103);
    }

    public static SandwichRectCallType[] values() {
        return (SandwichRectCallType[]) f437581a.clone();
    }

    public static SandwichRectCallType valueOf(String r100) {
        return (SandwichRectCallType) a.a(SandwichRectCallType.class, r100);
    }

    public SandwichRectCallType(String r100, int r101) {
        super(r100, r101);
    }
}
