package com.ss.android.ugc.aweme.poi.bean;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/bean/PoiUgcSearchSortBy;", "", "", "value", "I", "getValue", "()I", "SERVER_DEFAULT", "PUBLISHED_TIME_DESC", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final enum PoiUgcSearchSortBy extends Enum<PoiUgcSearchSortBy> {
    public static final PoiUgcSearchSortBy PUBLISHED_TIME_DESC = null;
    public static final PoiUgcSearchSortBy SERVER_DEFAULT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PoiUgcSearchSortBy[] f451316a = null;
    private final int value;

    public static PoiUgcSearchSortBy valueOf(String r100) {
        return (PoiUgcSearchSortBy) a.a(PoiUgcSearchSortBy.class, r100);
    }

    public static PoiUgcSearchSortBy[] values() {
        return (PoiUgcSearchSortBy[]) f451316a.clone();
    }

    static {
        PoiUgcSearchSortBy r100 = new PoiUgcSearchSortBy("SERVER_DEFAULT", 0, 1);
        SERVER_DEFAULT = r100;
        PoiUgcSearchSortBy r101 = new PoiUgcSearchSortBy("PUBLISHED_TIME_DESC", 1, 2);
        PUBLISHED_TIME_DESC = r101;
        f451316a = new PoiUgcSearchSortBy[]{r100, r101};
    }

    public final int getValue() {
        return this.value;
    }

    public PoiUgcSearchSortBy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
