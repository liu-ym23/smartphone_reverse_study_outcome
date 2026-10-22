package com.bytedance.ee.bear.basesdk.api;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/basesdk/api/IQuoto$ExceedQuotaType;", "", "<init>", "(Ljava/lang/String;I)V", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "DEPARTMENT", "TENANT", "UNKNOW", "basesdk-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IQuoto$ExceedQuotaType extends Enum<IQuoto$ExceedQuotaType> {
    public static final IQuoto$ExceedQuotaType DEPARTMENT = null;
    public static final IQuoto$ExceedQuotaType TENANT = null;
    public static final IQuoto$ExceedQuotaType UNKNOW = null;
    public static final IQuoto$ExceedQuotaType USER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IQuoto$ExceedQuotaType[] f206492a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206493b = null;

    public static EnumEntries<IQuoto$ExceedQuotaType> getEntries() {
        return f206493b;
    }

    static {
        IQuoto$ExceedQuotaType r100 = new IQuoto$ExceedQuotaType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0);
        USER = r100;
        IQuoto$ExceedQuotaType r101 = new IQuoto$ExceedQuotaType("DEPARTMENT", 1);
        DEPARTMENT = r101;
        IQuoto$ExceedQuotaType r102 = new IQuoto$ExceedQuotaType("TENANT", 2);
        TENANT = r102;
        IQuoto$ExceedQuotaType r103 = new IQuoto$ExceedQuotaType("UNKNOW", 3);
        UNKNOW = r103;
        IQuoto$ExceedQuotaType[] r104 = {r100, r101, r102, r103};
        f206492a = r104;
        f206493b = EnumEntriesKt.enumEntries(r104);
    }

    public static IQuoto$ExceedQuotaType[] values() {
        return (IQuoto$ExceedQuotaType[]) f206492a.clone();
    }

    public static IQuoto$ExceedQuotaType valueOf(String r100) {
        return (IQuoto$ExceedQuotaType) a.a(IQuoto$ExceedQuotaType.class, r100);
    }

    public IQuoto$ExceedQuotaType(String r100, int r101) {
        super(r100, r101);
    }
}
