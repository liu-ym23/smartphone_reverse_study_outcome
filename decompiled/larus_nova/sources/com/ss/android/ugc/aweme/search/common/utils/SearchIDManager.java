package com.ss.android.ugc.aweme.search.common.utils;

import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/utils/SearchIDManager;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchIDManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f452270a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, String> f452271b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Integer, String> f452272c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Map<Integer, String> f452273d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f452274e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f452275f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final SearchIDManager f452276g = null;

    private SearchIDManager() {
    }

    static {
        f452276g = new SearchIDManager();
        f452271b = new LinkedHashMap();
        f452272c = new LinkedHashMap();
        f452273d = new LinkedHashMap();
        f452274e = "";
        f452275f = "";
    }

    public static String a(SearchIDManager r100) {
        r100.getClass();
        Map<Integer, String> r101 = f452272c;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        String r103 = (String) r102.get(Integer.valueOf(f452270a));
        if (r103 != null) goto L6;
        return "";
    L6:
        return r103;
    }

    public static String b(int r100) {
        if (r100 != 0) goto L7;
        String r101 = (String) ((LinkedHashMap) f452271b).get(Integer.valueOf(f452270a));
        if (r101 != null) goto L13;
    L11:
        return "";
    L13:
        return r101;
    L7:
        if (r100 == f452270a) goto L9;
        Logger.b("SearchIdDebug", "getSearchId ERROR: targetPage = " + r100 + ", currentPage = " + f452270a);
    L9:
        String r102 = (String) ((LinkedHashMap) f452271b).get(Integer.valueOf(r100));
        if (r102 == null) goto L11;
        return r102;
    }

    public static /* synthetic */ String c(SearchIDManager r100) {
        r100.getClass();
        return b(0);
    }
}
