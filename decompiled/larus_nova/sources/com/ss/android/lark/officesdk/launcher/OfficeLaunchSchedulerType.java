package com.ss.android.lark.officesdk.launcher;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/officesdk/launcher/OfficeLaunchSchedulerType;", "", "<init>", "(Ljava/lang/String;I)V", OuterPayLoginWrapper.LOGIN_STYLE_V1, "V2", "officesdk-assemble_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum OfficeLaunchSchedulerType extends Enum<OfficeLaunchSchedulerType> {
    public static final OfficeLaunchSchedulerType V1 = null;
    public static final OfficeLaunchSchedulerType V2 = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OfficeLaunchSchedulerType[] f433418a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f433419b = null;

    public static EnumEntries<OfficeLaunchSchedulerType> getEntries() {
        return f433419b;
    }

    static {
        OfficeLaunchSchedulerType r100 = new OfficeLaunchSchedulerType(OuterPayLoginWrapper.LOGIN_STYLE_V1, 0);
        V1 = r100;
        OfficeLaunchSchedulerType r101 = new OfficeLaunchSchedulerType("V2", 1);
        V2 = r101;
        OfficeLaunchSchedulerType[] r102 = {r100, r101};
        f433418a = r102;
        f433419b = EnumEntriesKt.enumEntries(r102);
    }

    public static OfficeLaunchSchedulerType[] values() {
        return (OfficeLaunchSchedulerType[]) f433418a.clone();
    }

    public static OfficeLaunchSchedulerType valueOf(String r100) {
        return (OfficeLaunchSchedulerType) r27.a.a(OfficeLaunchSchedulerType.class, r100);
    }

    public OfficeLaunchSchedulerType(String r100, int r101) {
        super(r100, r101);
    }
}
