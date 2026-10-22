package com.larus.dora.impl.resource;

import com.obric.miniapp.alarm.AccountType;
import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/dora/impl/resource/DoraResourceSource;", "", "<init>", "(Ljava/lang/String;I)V", "APK", AccountType.LOCAL, FeatureConfigInfo.CLOUD_CONFIG_FEATURE_TYPE_ID, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DoraResourceSource extends Enum<DoraResourceSource> {
    public static final DoraResourceSource APK = null;
    public static final DoraResourceSource CLOUD = null;
    public static final DoraResourceSource LOCAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DoraResourceSource[] f337820a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f337821b = null;

    public static EnumEntries<DoraResourceSource> getEntries() {
        return f337821b;
    }

    static {
        DoraResourceSource r100 = new DoraResourceSource("APK", 0);
        APK = r100;
        DoraResourceSource r101 = new DoraResourceSource(AccountType.LOCAL, 1);
        LOCAL = r101;
        DoraResourceSource r102 = new DoraResourceSource(FeatureConfigInfo.CLOUD_CONFIG_FEATURE_TYPE_ID, 2);
        CLOUD = r102;
        DoraResourceSource[] r103 = {r100, r101, r102};
        f337820a = r103;
        f337821b = EnumEntriesKt.enumEntries(r103);
    }

    public static DoraResourceSource[] values() {
        return (DoraResourceSource[]) f337820a.clone();
    }

    public static DoraResourceSource valueOf(String r100) {
        return (DoraResourceSource) r27.a.a(DoraResourceSource.class, r100);
    }

    public DoraResourceSource(String r100, int r101) {
        super(r100, r101);
    }
}
