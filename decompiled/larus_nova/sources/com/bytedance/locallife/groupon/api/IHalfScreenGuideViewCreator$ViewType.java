package com.bytedance.locallife.groupon.api;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001R\u0017\u0010\u0004\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007j\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/locallife/groupon/api/IHalfScreenGuideViewCreator$ViewType", "", "Lcom/bytedance/locallife/groupon/api/IHalfScreenGuideViewCreator$ViewType;", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "clz", "getClz", "COLLECT_PAGE", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final enum IHalfScreenGuideViewCreator$ViewType extends Enum<IHalfScreenGuideViewCreator$ViewType> {
    public static final IHalfScreenGuideViewCreator$ViewType COLLECT_PAGE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IHalfScreenGuideViewCreator$ViewType[] f258783a = null;
    private final String clz;
    private final String type;

    public static IHalfScreenGuideViewCreator$ViewType valueOf(String r100) {
        return (IHalfScreenGuideViewCreator$ViewType) a.a(IHalfScreenGuideViewCreator$ViewType.class, r100);
    }

    public static IHalfScreenGuideViewCreator$ViewType[] values() {
        return (IHalfScreenGuideViewCreator$ViewType[]) f258783a.clone();
    }

    static {
        IHalfScreenGuideViewCreator$ViewType r100 = new IHalfScreenGuideViewCreator$ViewType();
        COLLECT_PAGE = r100;
        f258783a = new IHalfScreenGuideViewCreator$ViewType[]{r100};
    }

    public IHalfScreenGuideViewCreator$ViewType() {
        super("COLLECT_PAGE", 0);
        this.type = "COLLECT_PAGE";
        this.clz = "com.ss.android.ugc.aweme.collect.halfscreen.PoiCollectViewCreator";
    }

    public final String getClz() {
        return this.clz;
    }

    public final String getType() {
        return this.type;
    }
}
