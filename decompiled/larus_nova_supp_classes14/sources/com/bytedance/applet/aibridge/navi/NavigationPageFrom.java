package com.bytedance.applet.aibridge.navi;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/applet/aibridge/navi/NavigationPageFrom;", "", "<init>", "(Ljava/lang/String;I)V", "TOOL", "TASK", "POPUP", "OTHERS", "NOTIFICATION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum NavigationPageFrom extends Enum<NavigationPageFrom> {

    @SerializedName("from_island")
    public static final NavigationPageFrom NOTIFICATION = null;

    @SerializedName("from_others")
    public static final NavigationPageFrom OTHERS = null;

    @SerializedName("from_popup")
    public static final NavigationPageFrom POPUP = null;

    @SerializedName("from_task")
    public static final NavigationPageFrom TASK = null;

    @SerializedName("from_tool")
    public static final NavigationPageFrom TOOL = null;
    public static final /* synthetic */ NavigationPageFrom[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<NavigationPageFrom> getEntries() {
        return b;
    }

    static {
        NavigationPageFrom r0 = new NavigationPageFrom("TOOL", 0);
        TOOL = r0;
        NavigationPageFrom r1 = new NavigationPageFrom("TASK", 1);
        TASK = r1;
        NavigationPageFrom r3 = new NavigationPageFrom("POPUP", 2);
        POPUP = r3;
        NavigationPageFrom r5 = new NavigationPageFrom("OTHERS", 3);
        OTHERS = r5;
        NavigationPageFrom r7 = new NavigationPageFrom("NOTIFICATION", 4);
        NOTIFICATION = r7;
        NavigationPageFrom[] r9 = {r0, r1, r3, r5, r7};
        a = r9;
        b = EnumEntriesKt.enumEntries(r9);
    }

    public static NavigationPageFrom[] values() {
        return (NavigationPageFrom[]) a.clone();
    }

    public static NavigationPageFrom valueOf(String r1) {
        return (NavigationPageFrom) r27.a.a(NavigationPageFrom.class, r1);
    }

    public NavigationPageFrom(String r1, int r2) {
        super(r1, r2);
    }
}
