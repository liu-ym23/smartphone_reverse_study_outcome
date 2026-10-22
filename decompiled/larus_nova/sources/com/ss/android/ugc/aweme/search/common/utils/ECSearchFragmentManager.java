package com.ss.android.ugc.aweme.search.common.utils;

import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.search.common.base.log.Logger;
import com.ss.android.ugc.aweme.search.common.tab.ECTabMobDataInfo;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/utils/ECSearchFragmentManager;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchFragmentManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, ECTabMobDataInfo> f452251a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LinkedList<WeakReference<Fragment>> f452252b = null;

    private ECSearchFragmentManager() {
    }

    static {
        new ECSearchFragmentManager();
        f452251a = new LinkedHashMap();
        f452252b = new LinkedList();
    }

    @JvmStatic
    public static final Fragment a() {
        LinkedList<WeakReference<Fragment>> r100 = f452252b;
        Object r101 = (WeakReference) r100.peekLast();
        if (r101 != null) goto L5;
        r101 = 0;
    L5:
        Logger.a("TAG", "current top hash code key: " + r101);
        WeakReference<Fragment> r102 = r100.peekLast();
        if (r102 != null) goto L10;
        return null;
    L10:
        return r102.get();
    }
}
