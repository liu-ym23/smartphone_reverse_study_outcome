package com.ss.android.ugc.aweme.search.filter.view.good;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/CornerType;", "", "CUSTOM_CORNER", "DEFAULT_CORNER", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CornerType extends Enum<CornerType> {
    public static final CornerType CUSTOM_CORNER = null;
    public static final CornerType DEFAULT_CORNER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CornerType[] f453176a = null;

    static {
        CornerType r100 = new CornerType("CUSTOM_CORNER", 0);
        CUSTOM_CORNER = r100;
        CornerType r101 = new CornerType("DEFAULT_CORNER", 1);
        DEFAULT_CORNER = r101;
        f453176a = new CornerType[]{r100, r101};
    }

    public static CornerType valueOf(String r100) {
        return (CornerType) a.a(CornerType.class, r100);
    }

    public static CornerType[] values() {
        return (CornerType[]) f453176a.clone();
    }

    public CornerType(String r100, int r101) {
        super(r100, r101);
    }
}
