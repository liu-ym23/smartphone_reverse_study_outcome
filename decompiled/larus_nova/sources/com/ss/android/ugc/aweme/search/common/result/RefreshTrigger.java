package com.ss.android.ugc.aweme.search.common.result;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/RefreshTrigger;", "", "RefreshErrorBtnClick", "SearchBtnClick", "CorrectInfoClick", "SearchPullRefresh", "AIChatRefresh", "LoginRefresh", "LoginRefreshPageBack", "RefreshOthers", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum RefreshTrigger extends Enum<RefreshTrigger> {
    public static final RefreshTrigger AIChatRefresh = null;
    public static final RefreshTrigger CorrectInfoClick = null;
    public static final RefreshTrigger LoginRefresh = null;
    public static final RefreshTrigger LoginRefreshPageBack = null;
    public static final RefreshTrigger RefreshErrorBtnClick = null;
    public static final RefreshTrigger RefreshOthers = null;
    public static final RefreshTrigger SearchBtnClick = null;
    public static final RefreshTrigger SearchPullRefresh = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RefreshTrigger[] f451853a = null;

    static {
        RefreshTrigger r100 = new RefreshTrigger("RefreshErrorBtnClick", 0);
        RefreshErrorBtnClick = r100;
        RefreshTrigger r101 = new RefreshTrigger("SearchBtnClick", 1);
        SearchBtnClick = r101;
        RefreshTrigger r102 = new RefreshTrigger("CorrectInfoClick", 2);
        CorrectInfoClick = r102;
        RefreshTrigger r103 = new RefreshTrigger("SearchPullRefresh", 3);
        SearchPullRefresh = r103;
        RefreshTrigger r104 = new RefreshTrigger("AIChatRefresh", 4);
        AIChatRefresh = r104;
        RefreshTrigger r105 = new RefreshTrigger("LoginRefresh", 5);
        LoginRefresh = r105;
        RefreshTrigger r106 = new RefreshTrigger("LoginRefreshPageBack", 6);
        LoginRefreshPageBack = r106;
        RefreshTrigger r107 = new RefreshTrigger("RefreshOthers", 7);
        RefreshOthers = r107;
        f451853a = new RefreshTrigger[]{r100, r101, r102, r103, r104, r105, r106, r107};
    }

    public static RefreshTrigger valueOf(String r100) {
        return (RefreshTrigger) a.a(RefreshTrigger.class, r100);
    }

    public static RefreshTrigger[] values() {
        return (RefreshTrigger[]) f451853a.clone();
    }

    public RefreshTrigger(String r100, int r101) {
        super(r100, r101);
    }
}
