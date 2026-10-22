package com.bytedance.locallife.poi.newdetail.component.feed.coi;

import com.bytedance.ee.bear.middleground.comment.adapter.CardAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/locallife/poi/newdetail/component/feed/coi/CoiUIType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", CardAdapter.TEXT, "ICON", "RANK", "locallife-poi-impl_release"}, k = 1, mv = {1, 4, 3})
public final enum CoiUIType extends Enum<CoiUIType> {
    public static final CoiUIType ICON = null;
    public static final CoiUIType RANK = null;
    public static final CoiUIType TEXT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CoiUIType[] f263157a = null;
    private final String type;

    public static CoiUIType valueOf(String r100) {
        return (CoiUIType) r27.a.a(CoiUIType.class, r100);
    }

    public static CoiUIType[] values() {
        return (CoiUIType[]) f263157a.clone();
    }

    static {
        CoiUIType r100 = new CoiUIType(CardAdapter.TEXT, 0, "text");
        TEXT = r100;
        CoiUIType r101 = new CoiUIType("ICON", 1, "icon");
        ICON = r101;
        CoiUIType r102 = new CoiUIType("RANK", 2, "rank");
        RANK = r102;
        f263157a = new CoiUIType[]{r100, r101, r102};
    }

    public final String getType() {
        return this.type;
    }

    public CoiUIType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
