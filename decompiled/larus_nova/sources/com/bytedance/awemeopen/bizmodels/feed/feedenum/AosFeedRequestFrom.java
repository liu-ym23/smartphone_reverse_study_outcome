package com.bytedance.awemeopen.bizmodels.feed.feedenum;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/feedenum/AosFeedRequestFrom;", "", "", "requestFrom", "Ljava/lang/String;", "getRequestFrom", "()Ljava/lang/String;", "LOAD_MORE_DRAW", "PREFETCH_FEED", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum AosFeedRequestFrom extends Enum<AosFeedRequestFrom> {
    public static final AosFeedRequestFrom LOAD_MORE_DRAW = null;
    public static final AosFeedRequestFrom PREFETCH_FEED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AosFeedRequestFrom[] f198179a = null;
    private final String requestFrom;

    public static AosFeedRequestFrom valueOf(String r100) {
        return (AosFeedRequestFrom) a.a(AosFeedRequestFrom.class, r100);
    }

    public static AosFeedRequestFrom[] values() {
        return (AosFeedRequestFrom[]) f198179a.clone();
    }

    static {
        AosFeedRequestFrom r100 = new AosFeedRequestFrom("LOAD_MORE_DRAW", 0, "load_more_draw");
        LOAD_MORE_DRAW = r100;
        AosFeedRequestFrom r101 = new AosFeedRequestFrom("PREFETCH_FEED", 1, "prefetch_feed");
        PREFETCH_FEED = r101;
        f198179a = new AosFeedRequestFrom[]{r100, r101};
    }

    public final String getRequestFrom() {
        return this.requestFrom;
    }

    public AosFeedRequestFrom(String r100, int r101, String r102) {
        super(r100, r101);
        this.requestFrom = r102;
    }
}
