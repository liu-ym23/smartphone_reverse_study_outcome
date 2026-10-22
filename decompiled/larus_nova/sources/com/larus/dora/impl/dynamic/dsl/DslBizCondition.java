package com.larus.dora.impl.dynamic.dsl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/dora/impl/dynamic/dsl/DslBizCondition;", "", "<init>", "(Ljava/lang/String;I)V", "SUPPORT_INTERPRETATION", "SUPPORT_NOTIFICATION_BROADCAST", "SUPPORT_OWEN_WAKEUP", "SUPPORT_MEETING_MINUTES", "SUPPORT_QUICK_NOTES", "SUPPORT_QUICK_NOTE", "SUPPORT_WIFI_SETTINGS", "SUPPORT_CASE_VERSION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DslBizCondition extends Enum<DslBizCondition> {

    @SerializedName("support_case_version")
    public static final DslBizCondition SUPPORT_CASE_VERSION = null;

    @SerializedName("support_interpretation")
    public static final DslBizCondition SUPPORT_INTERPRETATION = null;

    @SerializedName("support_meeting_minutes")
    public static final DslBizCondition SUPPORT_MEETING_MINUTES = null;

    @SerializedName("support_notification_broadcast")
    public static final DslBizCondition SUPPORT_NOTIFICATION_BROADCAST = null;

    @SerializedName("support_owen_wakeup")
    public static final DslBizCondition SUPPORT_OWEN_WAKEUP = null;

    @SerializedName("support_quick_note")
    public static final DslBizCondition SUPPORT_QUICK_NOTE = null;

    @SerializedName("support_quick_notes")
    public static final DslBizCondition SUPPORT_QUICK_NOTES = null;

    @SerializedName("support_wifi_settings")
    public static final DslBizCondition SUPPORT_WIFI_SETTINGS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DslBizCondition[] f335161a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335162b = null;

    public static EnumEntries<DslBizCondition> getEntries() {
        return f335162b;
    }

    static {
        DslBizCondition r100 = new DslBizCondition("SUPPORT_INTERPRETATION", 0);
        SUPPORT_INTERPRETATION = r100;
        DslBizCondition r101 = new DslBizCondition("SUPPORT_NOTIFICATION_BROADCAST", 1);
        SUPPORT_NOTIFICATION_BROADCAST = r101;
        DslBizCondition r102 = new DslBizCondition("SUPPORT_OWEN_WAKEUP", 2);
        SUPPORT_OWEN_WAKEUP = r102;
        DslBizCondition r103 = new DslBizCondition("SUPPORT_MEETING_MINUTES", 3);
        SUPPORT_MEETING_MINUTES = r103;
        DslBizCondition r104 = new DslBizCondition("SUPPORT_QUICK_NOTES", 4);
        SUPPORT_QUICK_NOTES = r104;
        DslBizCondition r105 = new DslBizCondition("SUPPORT_QUICK_NOTE", 5);
        SUPPORT_QUICK_NOTE = r105;
        DslBizCondition r110 = new DslBizCondition("SUPPORT_WIFI_SETTINGS", 6);
        SUPPORT_WIFI_SETTINGS = r110;
        DslBizCondition r111 = new DslBizCondition("SUPPORT_CASE_VERSION", 7);
        SUPPORT_CASE_VERSION = r111;
        DslBizCondition[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f335161a = r112;
        f335162b = EnumEntriesKt.enumEntries(r112);
    }

    public static DslBizCondition[] values() {
        return (DslBizCondition[]) f335161a.clone();
    }

    public static DslBizCondition valueOf(String r100) {
        return (DslBizCondition) r27.a.a(DslBizCondition.class, r100);
    }

    public DslBizCondition(String r100, int r101) {
        super(r100, r101);
    }
}
