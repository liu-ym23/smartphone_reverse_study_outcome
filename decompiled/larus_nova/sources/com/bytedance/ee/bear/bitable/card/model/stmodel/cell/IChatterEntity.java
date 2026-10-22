package com.bytedance.ee.bear.bitable.card.model.stmodel.cell;

import com.ss.videoarch.strategy.dataCenter.config.model.FeatureConfigInfo;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public interface IChatterEntity {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/model/stmodel/cell/IChatterEntity$ChatterSubType;", "", "<init>", "(Ljava/lang/String;I)V", FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, "GROUP", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ChatterSubType extends Enum<ChatterSubType> {
        public static final ChatterSubType GROUP = null;
        public static final ChatterSubType USER = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ChatterSubType[] f207128a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f207129b = null;

        public static EnumEntries<ChatterSubType> getEntries() {
            return f207129b;
        }

        static {
            ChatterSubType r100 = new ChatterSubType(FeatureConfigInfo.USER_PROFILE_FEATURE_TYPE_ID, 0);
            USER = r100;
            ChatterSubType r101 = new ChatterSubType("GROUP", 1);
            GROUP = r101;
            ChatterSubType[] r102 = {r100, r101};
            f207128a = r102;
            f207129b = EnumEntriesKt.enumEntries(r102);
        }

        public static ChatterSubType[] values() {
            return (ChatterSubType[]) f207128a.clone();
        }

        public static ChatterSubType valueOf(String r100) {
            return (ChatterSubType) a.a(ChatterSubType.class, r100);
        }

        public ChatterSubType(String r100, int r101) {
            super(r100, r101);
        }
    }

    String getAvatarKey();

    String getAvatarUrl();

    String getDescription();

    String getId();

    String getLocalName(String r100);

    boolean isCurrentUser();
}
