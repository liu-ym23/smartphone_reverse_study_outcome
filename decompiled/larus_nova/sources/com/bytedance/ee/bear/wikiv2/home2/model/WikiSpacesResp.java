package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class WikiSpacesResp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WikiSpaceFilterInfo f240917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<SpaceBean> f240918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f240919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f240920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Origin f240921e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpacesResp$Origin;", "", "<init>", "(Ljava/lang/String;I)V", "Network", "Cache", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Origin extends Enum<Origin> {
        public static final Origin Cache = null;
        public static final Origin Network = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Origin[] f240922a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f240923b = null;

        public static EnumEntries<Origin> getEntries() {
            return f240923b;
        }

        static {
            Origin r100 = new Origin("Network", 0);
            Network = r100;
            Origin r101 = new Origin("Cache", 1);
            Cache = r101;
            Origin[] r102 = {r100, r101};
            f240922a = r102;
            f240923b = EnumEntriesKt.enumEntries(r102);
        }

        public static Origin[] values() {
            return (Origin[]) f240922a.clone();
        }

        public static Origin valueOf(String r100) {
            return (Origin) r27.a.a(Origin.class, r100);
        }

        public Origin(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final int a() {
        List<SpaceBean> r100 = this.f240918b;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WikiSpacesResp(WikiSpaceFilterInfo r100, List<? extends SpaceBean> r101, boolean r102, String r103, Origin r104) {
        Intrinsics.checkNotNullParameter(r100, "filterInfo");
        Intrinsics.checkNotNullParameter(r104, PlayerResolution.SDKKEY.ORIGIN);
        this.f240917a = r100;
        this.f240918b = r101;
        this.f240919c = r102;
        this.f240920d = r103;
        this.f240921e = r104;
    }
}
