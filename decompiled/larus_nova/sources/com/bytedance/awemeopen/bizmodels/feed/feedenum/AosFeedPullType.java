package com.bytedance.awemeopen.bizmodels.feed.feedenum;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/feed/feedenum/AosFeedPullType;", "", "", "pullType", "I", "getPullType", "()I", "INIT_LOADING", "PULL_TO_REFRESH", "LOAD_MORE", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final enum AosFeedPullType extends Enum<AosFeedPullType> {
    public static final AosFeedPullType INIT_LOADING = null;
    public static final AosFeedPullType LOAD_MORE = null;
    public static final AosFeedPullType PULL_TO_REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AosFeedPullType[] f198178a = null;
    private final int pullType;

    public static AosFeedPullType valueOf(String r100) {
        return (AosFeedPullType) a.a(AosFeedPullType.class, r100);
    }

    public static AosFeedPullType[] values() {
        return (AosFeedPullType[]) f198178a.clone();
    }

    static {
        AosFeedPullType r100 = new AosFeedPullType("INIT_LOADING", 0, 0);
        INIT_LOADING = r100;
        AosFeedPullType r101 = new AosFeedPullType("PULL_TO_REFRESH", 1, 1);
        PULL_TO_REFRESH = r101;
        AosFeedPullType r102 = new AosFeedPullType("LOAD_MORE", 2, 2);
        LOAD_MORE = r102;
        f198178a = new AosFeedPullType[]{r100, r101, r102};
    }

    public final int getPullType() {
        return this.pullType;
    }

    public AosFeedPullType(String r100, int r101, int r102) {
        super(r100, r101);
        this.pullType = r102;
    }
}
