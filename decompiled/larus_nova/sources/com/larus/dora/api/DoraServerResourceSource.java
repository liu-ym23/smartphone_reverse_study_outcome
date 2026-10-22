package com.larus.dora.api;

import com.obric.miniapp.alarm.AccountType;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/api/DoraServerResourceSource;", "", "<init>", "(Ljava/lang/String;I)V", "APK", AccountType.LOCAL, FeatureConfigInfo.CLOUD_CONFIG_FEATURE_TYPE_ID, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraServerResourceSource extends Enum<DoraServerResourceSource> {
    public static final DoraServerResourceSource APK = null;
    public static final DoraServerResourceSource CLOUD = null;
    public static final DoraServerResourceSource LOCAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraServerResourceSource[] f331716a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f331717b = null;

    public static EnumEntries<DoraServerResourceSource> getEntries() {
        return f331717b;
    }

    static {
        DoraServerResourceSource r100 = new DoraServerResourceSource("APK", 0);
        APK = r100;
        DoraServerResourceSource r101 = new DoraServerResourceSource(AccountType.LOCAL, 1);
        LOCAL = r101;
        DoraServerResourceSource r102 = new DoraServerResourceSource(FeatureConfigInfo.CLOUD_CONFIG_FEATURE_TYPE_ID, 2);
        CLOUD = r102;
        DoraServerResourceSource[] r103 = {r100, r101, r102};
        f331716a = r103;
        f331717b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraServerResourceSource[] values() {
        return (DoraServerResourceSource[]) f331716a.clone();
    }

    public static DoraServerResourceSource valueOf(String r100) {
        return (DoraServerResourceSource) a.a(DoraServerResourceSource.class, r100);
    }

    public DoraServerResourceSource(String r100, int r101) {
        super(r100, r101);
    }
}
