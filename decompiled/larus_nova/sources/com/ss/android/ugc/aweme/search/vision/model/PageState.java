package com.ss.android.ugc.aweme.search.vision.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/PageState;", "", "DEFAULT", "FULL", "FRAME", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PageState extends Enum<PageState> {
    public static final PageState DEFAULT = null;
    public static final PageState FRAME = null;
    public static final PageState FULL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PageState[] f453594a = null;

    static {
        PageState r100 = new PageState("DEFAULT", 0);
        DEFAULT = r100;
        PageState r101 = new PageState("FULL", 1);
        FULL = r101;
        PageState r102 = new PageState("FRAME", 2);
        FRAME = r102;
        f453594a = new PageState[]{r100, r101, r102};
    }

    public static PageState valueOf(String r100) {
        return (PageState) a.a(PageState.class, r100);
    }

    public static PageState[] values() {
        return (PageState[]) f453594a.clone();
    }

    public PageState(String r100, int r101) {
        super(r100, r101);
    }
}
