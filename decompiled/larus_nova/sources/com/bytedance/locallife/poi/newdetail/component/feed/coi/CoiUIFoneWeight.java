package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import com.ss.android.ugc.aweme.discover.model.CommodityText;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/CoiUIFoneWeight;", "", "", "weight", "Ljava/lang/String;", "getWeight", "()Ljava/lang/String;", "BOLD", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum CoiUIFoneWeight extends Enum<CoiUIFoneWeight> {
    public static final CoiUIFoneWeight BOLD = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CoiUIFoneWeight[] f263155a = null;
    private final String weight;

    public static CoiUIFoneWeight valueOf(String r100) {
        return (CoiUIFoneWeight) r27.a.a(CoiUIFoneWeight.class, r100);
    }

    public static CoiUIFoneWeight[] values() {
        return (CoiUIFoneWeight[]) f263155a.clone();
    }

    static {
        CoiUIFoneWeight r100 = new CoiUIFoneWeight();
        BOLD = r100;
        f263155a = new CoiUIFoneWeight[]{r100};
    }

    public CoiUIFoneWeight() {
        super("BOLD", 0);
        this.weight = CommodityText.BOLD;
    }

    public final String getWeight() {
        return this.weight;
    }
}
