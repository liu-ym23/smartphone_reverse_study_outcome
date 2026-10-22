package com.bytedance.locallife.host.growth;

import com.ttnet.org.chromium.base.BaseSwitches;
import java.util.Map;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
public interface ILifeUserGrowthService {

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/locallife/host/growth/ILifeUserGrowthService$SaaSTraceBizTag;", "", "", BaseSwitches.V, "Ljava/lang/String;", "getV", "()Ljava/lang/String;", "POI_DETAIL", "PRODUCT_DETAIL", "LIVE_SHELF", "LIVE_EXPLAIN_CARD", "LIVE_SHARE", "LIVE_COLLECT", "LIVE_AUTO_DRAW", "MALL_DIAMOND", "MALL_FEED", "NEARBY_FEED", "MALL_HOME_PAGE", "locallife-host-api_release"}, k = 1, mv = {1, 4, 3})
    public static final enum SaaSTraceBizTag extends Enum<SaaSTraceBizTag> {
        public static final SaaSTraceBizTag LIVE_AUTO_DRAW = null;
        public static final SaaSTraceBizTag LIVE_COLLECT = null;
        public static final SaaSTraceBizTag LIVE_EXPLAIN_CARD = null;
        public static final SaaSTraceBizTag LIVE_SHARE = null;
        public static final SaaSTraceBizTag LIVE_SHELF = null;
        public static final SaaSTraceBizTag MALL_DIAMOND = null;
        public static final SaaSTraceBizTag MALL_FEED = null;
        public static final SaaSTraceBizTag MALL_HOME_PAGE = null;
        public static final SaaSTraceBizTag NEARBY_FEED = null;
        public static final SaaSTraceBizTag POI_DETAIL = null;
        public static final SaaSTraceBizTag PRODUCT_DETAIL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ SaaSTraceBizTag[] f258905a = null;

        /* JADX INFO: renamed from: v, reason: collision with root package name */
        private final String f258906v;

        public static SaaSTraceBizTag valueOf(String r100) {
            return (SaaSTraceBizTag) a.a(SaaSTraceBizTag.class, r100);
        }

        public static SaaSTraceBizTag[] values() {
            return (SaaSTraceBizTag[]) f258905a.clone();
        }

        static {
            SaaSTraceBizTag r100 = new SaaSTraceBizTag("POI_DETAIL", 0, "poi_detail");
            POI_DETAIL = r100;
            SaaSTraceBizTag r101 = new SaaSTraceBizTag("PRODUCT_DETAIL", 1, com.bytedance.android.ec.core.event.a.VALUE_PRODUCT_DETAIL);
            PRODUCT_DETAIL = r101;
            SaaSTraceBizTag r102 = new SaaSTraceBizTag("LIVE_SHELF", 2, "live_shelf");
            LIVE_SHELF = r102;
            SaaSTraceBizTag r103 = new SaaSTraceBizTag("LIVE_EXPLAIN_CARD", 3, "live_explanation_card");
            LIVE_EXPLAIN_CARD = r103;
            SaaSTraceBizTag r104 = new SaaSTraceBizTag("LIVE_SHARE", 4, "live_share_get");
            LIVE_SHARE = r104;
            SaaSTraceBizTag r105 = new SaaSTraceBizTag("LIVE_COLLECT", 5, "live_collect_return");
            LIVE_COLLECT = r105;
            SaaSTraceBizTag r110 = new SaaSTraceBizTag("LIVE_AUTO_DRAW", 6, "live_auto_draw");
            LIVE_AUTO_DRAW = r110;
            SaaSTraceBizTag r111 = new SaaSTraceBizTag("MALL_DIAMOND", 7, "mall_diamond_position");
            MALL_DIAMOND = r111;
            SaaSTraceBizTag r112 = new SaaSTraceBizTag("MALL_FEED", 8, "mall_feed");
            MALL_FEED = r112;
            SaaSTraceBizTag r113 = new SaaSTraceBizTag("NEARBY_FEED", 9, "nearby_feed");
            NEARBY_FEED = r113;
            SaaSTraceBizTag r114 = new SaaSTraceBizTag("MALL_HOME_PAGE", 10, "mall_home_page");
            MALL_HOME_PAGE = r114;
            f258905a = new SaaSTraceBizTag[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        }

        public final String getV() {
            return this.f258906v;
        }

        public SaaSTraceBizTag(String r100, int r101, String r102) {
            super(r100, r101);
            this.f258906v = r102;
        }
    }

    Map<String, String> a(SaaSTraceBizTag r100);
}
