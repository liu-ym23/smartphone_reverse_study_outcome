package com.bytedance.android.livesdk.link.model.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"com/bytedance/android/livesdk/link/model/api/IBaseLogPb$LogIdType", "", "Lcom/bytedance/android/livesdk/link/model/api/IBaseLogPb$LogIdType;", "TYPE_UNDEFINED", "TYPE_FOLLOWED", "TYPE_RECOMMEND", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum IBaseLogPb$LogIdType extends Enum<IBaseLogPb$LogIdType> {
    public static final IBaseLogPb$LogIdType TYPE_FOLLOWED = null;
    public static final IBaseLogPb$LogIdType TYPE_RECOMMEND = null;
    public static final IBaseLogPb$LogIdType TYPE_UNDEFINED = null;
    public static final /* synthetic */ IBaseLogPb$LogIdType[] a = null;

    static {
        IBaseLogPb$LogIdType r1 = new IBaseLogPb$LogIdType("TYPE_UNDEFINED", 0);
        TYPE_UNDEFINED = r1;
        IBaseLogPb$LogIdType r2 = new IBaseLogPb$LogIdType("TYPE_FOLLOWED", 1);
        TYPE_FOLLOWED = r2;
        IBaseLogPb$LogIdType r3 = new IBaseLogPb$LogIdType("TYPE_RECOMMEND", 2);
        TYPE_RECOMMEND = r3;
        a = new IBaseLogPb$LogIdType[]{r1, r2, r3};
    }

    public static IBaseLogPb$LogIdType valueOf(String r1) {
        return (IBaseLogPb$LogIdType) a.a(IBaseLogPb$LogIdType.class, r1);
    }

    public static IBaseLogPb$LogIdType[] values() {
        return (IBaseLogPb$LogIdType[]) a.clone();
    }

    public IBaseLogPb$LogIdType(String r1, int r2) {
        super(r1, r2);
    }
}
