package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.ee.bear.wikiv2.home.api.SpaceBean;
import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class WikiSpacesResp {
    public final WikiSpaceFilterInfo a;
    public final List<SpaceBean> b;
    public final boolean c;
    public final String d;
    public final Origin e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpacesResp$Origin;", "", "<init>", "(Ljava/lang/String;I)V", "Network", "Cache", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Origin extends Enum<Origin> {
        public static final Origin Cache = null;
        public static final Origin Network = null;
        public static final /* synthetic */ Origin[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Origin> getEntries() {
            return b;
        }

        static {
            Origin r0 = new Origin("Network", 0);
            Network = r0;
            Origin r1 = new Origin("Cache", 1);
            Cache = r1;
            Origin[] r3 = {r0, r1};
            a = r3;
            b = EnumEntriesKt.enumEntries(r3);
        }

        public static Origin[] values() {
            return (Origin[]) a.clone();
        }

        public static Origin valueOf(String r1) {
            return (Origin) r27.a.a(Origin.class, r1);
        }

        public Origin(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final int a() {
        List<SpaceBean> r0 = this.b;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WikiSpacesResp(WikiSpaceFilterInfo r2, List<? extends SpaceBean> r3, boolean r4, String r5, Origin r6) {
        Intrinsics.checkNotNullParameter(r2, "filterInfo");
        Intrinsics.checkNotNullParameter(r6, "origin");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
