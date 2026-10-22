package com.ss.android.ugc.aweme.search.common.result.optimize;

import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.bean.ECSearchParam;
import com.ss.android.ugc.aweme.search.model.SearchResultParam;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/result/optimize/ECSearchParamHelper;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchParamHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ECSearchParamHelper f451865a = null;

    private ECSearchParamHelper() {
    }

    static {
        f451865a = new ECSearchParamHelper();
    }

    public static String a(SearchResultParam r100) {
        if (r100 == null) goto L5;
        String r101 = r100.getEnterMethod();
    L6:
        if (r101 != null) goto L8;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == true) goto L15;
        if (r100 != null) goto L19;
        return null;
    L19:
        return r100.getEnterMethod();
    L15:
        if (r100 != null) goto L17;
        return null;
    L17:
        return r100.getSearchFrom();
    L8:
        if (r101.length() == 0) goto L11;
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public static String b(ECSearchParam r100) {
        if (r100 == null) goto L7;
        SearchResultParam r101 = r100.getSearchResultParam();
        if (r101 == null) goto L7;
        String r102 = r101.getEnterMethod();
    L8:
        if (r102 != null) goto L10;
    L13:
        boolean r103 = true;
    L15:
        if (r103 == true) goto L27;
        StringBuilder r104 = new StringBuilder("getSearchSource return enterMethod = ");
        if (r100 == null) goto L21;
        SearchResultParam r105 = r100.getSearchResultParam();
        if (r105 == null) goto L21;
        String r106 = r105.getEnterMethod();
    L22:
        r104.append(r106);
        Logger.a("ParamDebug", r104.toString());
        if (r100 == null) goto L39;
        SearchResultParam r107 = r100.getSearchResultParam();
        if (r107 != null) goto L41;
        return null;
    L41:
        return r107.getEnterMethod();
    L39:
        return null;
    L21:
        r106 = null;
        goto L22
    L27:
        StringBuilder r108 = new StringBuilder("getSearchSource return searchFrom = ");
        if (r100 == null) goto L32;
        SearchResultParam r109 = r100.getSearchResultParam();
        if (r109 == null) goto L32;
        String r110 = r109.getSearchFrom();
    L33:
        r108.append(r110);
        Logger.a("ParamDebug", r108.toString());
        if (r100 == null) goto L42;
        SearchResultParam r111 = r100.getSearchResultParam();
        if (r111 != null) goto L38;
        return null;
    L38:
        return r111.getSearchFrom();
    L42:
        return null;
    L32:
        r110 = null;
        goto L33
    L10:
        if (r102.length() == 0) goto L13;
        r103 = false;
    L7:
        r102 = null;
        goto L8
    }
}
