package com.bytedance.ug.sdk.luckycat.service.flower;

import com.obric.miniapp.alarm.AccountType;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"com/bytedance/ug/sdk/luckycat/service/flower/IFlowerSettingsService$Channel", "", "Lcom/bytedance/ug/sdk/luckycat/service/flower/IFlowerSettingsService$Channel;", AccountType.ALL, "STATIC", BannerBizName.DYNAMIC, "POLL", "luckycat-service_release"}, k = 1, mv = {1, 4, 0})
public final enum IFlowerSettingsService$Channel extends Enum<IFlowerSettingsService$Channel> {
    public static final IFlowerSettingsService$Channel ALL = null;
    public static final IFlowerSettingsService$Channel DYNAMIC = null;
    public static final IFlowerSettingsService$Channel POLL = null;
    public static final IFlowerSettingsService$Channel STATIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IFlowerSettingsService$Channel[] f271548a = null;

    static {
        IFlowerSettingsService$Channel r100 = new IFlowerSettingsService$Channel(AccountType.ALL, 0);
        ALL = r100;
        IFlowerSettingsService$Channel r101 = new IFlowerSettingsService$Channel("STATIC", 1);
        STATIC = r101;
        IFlowerSettingsService$Channel r102 = new IFlowerSettingsService$Channel(BannerBizName.DYNAMIC, 2);
        DYNAMIC = r102;
        IFlowerSettingsService$Channel r103 = new IFlowerSettingsService$Channel("POLL", 3);
        POLL = r103;
        f271548a = new IFlowerSettingsService$Channel[]{r100, r101, r102, r103};
    }

    public static IFlowerSettingsService$Channel valueOf(String r100) {
        return (IFlowerSettingsService$Channel) a.a(IFlowerSettingsService$Channel.class, r100);
    }

    public static IFlowerSettingsService$Channel[] values() {
        return (IFlowerSettingsService$Channel[]) f271548a.clone();
    }

    public IFlowerSettingsService$Channel(String r100, int r101) {
        super(r100, r101);
    }
}
