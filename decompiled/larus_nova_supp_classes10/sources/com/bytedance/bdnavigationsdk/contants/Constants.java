package com.bytedance.bdnavigationsdk.contants;

import com.bytedance.bdlocation.client.LocationInfoConst;
import juc.d;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0019\b\u0087\u0081\u0002\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u001bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001a¨\u0006\u001c"}, d2 = {"Lcom/bytedance/bdnavigationsdk/contants/Constants;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "Unknown", "Unspecified", "BDNavigationSDK", "BDNAConfiguration", "Ok", "Error", LocationInfoConst.SYSTEM, "IOS", "HarmonyOS", "Apple", "Huawei", "Auto", "Manual", "PublicKey", "ContentTypeValue", "ContentType", "EventRoutePlanApi", "EventReportApi", "EventConfigureApi", "Companion", "BDNavigationSDK_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@Serializable
public final enum Constants extends Enum<Constants> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ Constants[] $VALUES = null;
    private static final Lazy<d<Object>> $cachedSerializer$delegate = null;

    @SerialName(LocationInfoConst.SYSTEM)
    public static final Constants Android = null;

    @SerialName("Apple")
    public static final Constants Apple = null;

    @SerialName("Auto")
    public static final Constants Auto = null;

    @SerialName("BDNAConfiguration")
    public static final Constants BDNAConfiguration = null;

    @SerialName("BDNavigationSDK")
    public static final Constants BDNavigationSDK = null;
    public static final a Companion = null;

    @SerialName("Content-Type")
    public static final Constants ContentType = null;

    @SerialName("ContentTypeValue")
    public static final Constants ContentTypeValue = null;

    @SerialName("Error")
    public static final Constants Error = null;

    @SerialName("EventConfigureApi")
    public static final Constants EventConfigureApi = null;

    @SerialName("EventReportApi")
    public static final Constants EventReportApi = null;

    @SerialName("EventRoutePlanApi")
    public static final Constants EventRoutePlanApi = null;

    @SerialName("HarmonyOS")
    public static final Constants HarmonyOS = null;

    @SerialName("Huawei")
    public static final Constants Huawei = null;

    @SerialName("IOS")
    public static final Constants IOS = null;

    @SerialName("Manual")
    public static final Constants Manual = null;

    @SerialName("Ok")
    public static final Constants Ok = null;

    @SerialName("PublicKey")
    public static final Constants PublicKey = null;

    @SerialName("Unknown")
    public static final Constants Unknown = null;

    @SerialName("unspecified")
    public static final Constants Unspecified = null;
    private final String value;

    public static EnumEntries<Constants> getEntries() {
        return $ENTRIES;
    }

    /* JADX WARN: Type inference failed for: r0v20, types: [com.bytedance.bdnavigationsdk.contants.Constants$a] */
    static {
        Constants r0 = new Constants("Unknown", 0, "Unknown");
        Unknown = r0;
        Constants r1 = new Constants("Unspecified", 1, "unspecified");
        Unspecified = r1;
        Constants r3 = new Constants("BDNavigationSDK", 2, "BDNavigationSDK");
        BDNavigationSDK = r3;
        Constants r4 = new Constants("BDNAConfiguration", 3, "BDNAConfiguration");
        BDNAConfiguration = r4;
        Constants r7 = new Constants("Ok", 4, "Ok");
        Ok = r7;
        Constants r9 = new Constants("Error", 5, "Error");
        Error = r9;
        Constants r11 = new Constants(LocationInfoConst.SYSTEM, 6, LocationInfoConst.SYSTEM);
        Android = r11;
        Constants r13 = new Constants("IOS", 7, "iOS");
        IOS = r13;
        Constants r14 = new Constants("HarmonyOS", 8, "HarmonyOS");
        HarmonyOS = r14;
        Constants r15 = new Constants("Apple", 9, "Apple");
        Apple = r15;
        Constants r12 = new Constants("Huawei", 10, "Huawei");
        Huawei = r12;
        Constants r10 = new Constants("Auto", 11, "auto");
        Auto = r10;
        Constants r6 = new Constants("Manual", 12, "manual");
        Manual = r6;
        Constants r5 = new Constants("PublicKey", 13, "LS0tLS1CRUdJTiBQVUJMSUMgS0VZLS0tLS0KTUlJQklqQU5CZ2txaGtpRzl3MEJBUUVGQUFPQ0FROEFNSUlCQ2dLQ0FRRUE3WWpFZFpjZE5ITnRRcXlIVGNSUwpDS1JLODE5MVU3QTBYZWlrT2kxc1YwdzVZSHc1YVpUT0VyaWl2a0xoNXlwbWpoK0FBVUNEdHJFRTErUUw3aDBlCkVXM0hYb2tIU2pTUUVNeE8rYUQxRU9nM1JHK3FzNmJVeFppZ3RnT1ExNVM4NkdWdG5oZ3FNS3hFMlJsNEcrVHIKN3ZxOStmL04xZU9CV3hEV1FUd2ZtOGZLanNkZFMvK09zR0JIMVRXTnZWaDZmbm0vRG9GK2RDV01MWjVOT1pOSwpUazYva1dwcTJLYjZncjRDYVJMdmpQTEx2T0JCN1RZcElGV2RHbzlvQ0QyOXpTUW5WT1FKNnpuWGRxT3owZGc4CkdMT3ZydWM3U3E4cXc0Q0VJSG5OenBodUI4cUZvdGo1dndOSFVZVWpmVWJsT09GWjV0citRaHZUVm4zWGx6QTMKcVFJREFRQUIKLS0tLS1FTkQgUFVCTElDIEtFWS0tLS0tCg==");
        PublicKey = r5;
        Constants r2 = new Constants("ContentTypeValue", 14, "application/json");
        ContentTypeValue = r2;
        Constants r8 = new Constants("ContentType", 15, "Content-Type");
        ContentType = r8;
        Constants r16 = new Constants("EventRoutePlanApi", 16, "bd_nav_sdk_kmp_route_plan_api");
        EventRoutePlanApi = r16;
        Constants r17 = new Constants("EventReportApi", 17, "bd_nav_sdk_kmp_report_api");
        EventReportApi = r17;
        Constants r18 = new Constants("EventConfigureApi", 18, "bd_nav_sdk_kmp_configure_api");
        EventConfigureApi = r18;
        Constants[] r19 = {r0, r1, r3, r4, r7, r9, r11, r13, r14, r15, r12, r10, r6, r5, r2, r8, r16, r17, r18};
        $VALUES = r19;
        $ENTRIES = EnumEntriesKt.enumEntries(r19);
        Companion = new a();
        $cachedSerializer$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new p84.a());
    }

    public static Constants[] values() {
        return (Constants[]) $VALUES.clone();
    }

    public static final /* synthetic */ Lazy access$get$cachedSerializer$delegate$cp() {
        return $cachedSerializer$delegate;
    }

    public final String getValue() {
        return this.value;
    }

    public static Constants valueOf(String r1) {
        return (Constants) r27.a.a(Constants.class, r1);
    }

    public Constants(String r1, int r2, String r3) {
        super(r1, r2);
        this.value = r3;
    }
}
