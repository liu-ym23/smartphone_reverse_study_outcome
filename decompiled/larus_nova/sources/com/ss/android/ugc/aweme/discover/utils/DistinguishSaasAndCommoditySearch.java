package com.ss.android.ugc.aweme.discover.utils;

import androidx.fragment.app.Fragment;
import com.bytedance.common.utility.Logger;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/utils/DistinguishSaasAndCommoditySearch;", "", "<init>", "()V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DistinguishSaasAndCommoditySearch {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedList<WeakReference<Fragment>> f450785a = null;

    private DistinguishSaasAndCommoditySearch() {
    }

    static {
        new DistinguishSaasAndCommoditySearch();
        f450785a = new LinkedList();
    }

    @JvmStatic
    public static final Fragment a() {
        LinkedList<WeakReference<Fragment>> r100 = f450785a;
        Object r101 = (WeakReference) r100.peekLast();
        if (r101 != null) goto L5;
        r101 = 0;
    L5:
        Logger.d("TAG", "current top hash code key: " + r101);
        WeakReference<Fragment> r102 = r100.peekLast();
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.get();
    }
}
