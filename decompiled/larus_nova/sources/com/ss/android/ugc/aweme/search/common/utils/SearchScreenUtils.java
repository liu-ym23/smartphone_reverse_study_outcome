package com.ss.android.ugc.aweme.search.common.utils;

import android.content.Context;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.ugc.discover.dynamic.d;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/utils/SearchScreenUtils;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SearchScreenUtils {
    private SearchScreenUtils() {
    }

    static {
        new SearchScreenUtils();
    }

    public static int a(Context r100) {
        int r101 = d.f454368a;
        return UIUtils.getScreenWidth(r100);
    }
}
