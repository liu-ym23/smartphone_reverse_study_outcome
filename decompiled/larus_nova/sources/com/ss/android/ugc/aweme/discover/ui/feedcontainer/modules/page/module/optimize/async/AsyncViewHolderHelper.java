package com.ss.android.ugc.aweme.discover.ui.feedcontainer.modules.page.module.optimize.async;

import androidx.recyclerview.widget.RecyclerView;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zkc.b;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/ui/feedcontainer/modules/page/module/optimize/async/AsyncViewHolderHelper;", "", "<init>", "()V", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AsyncViewHolderHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, Boolean> f450654a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<Integer> f450655b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final HashMap<RecyclerView, HashMap<Integer, b>> f450656c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AsyncViewHolderHelper f450657d = null;

    private AsyncViewHolderHelper() {
    }

    static {
        f450657d = new AsyncViewHolderHelper();
        f450654a = new ConcurrentHashMap();
        f450655b = new LinkedHashSet();
        f450656c = new HashMap();
    }

    public static HashMap a(RecyclerView r100) {
        Intrinsics.checkNotNullParameter(r100, "recyclerView");
        HashMap<RecyclerView, HashMap<Integer, b>> r101 = f450656c;
        HashMap<Integer, b> r102 = r101.get(r100);
        if (r102 != null) goto L6;
        r102 = new HashMap();
        r101.put(r100, r102);
    L6:
        return r102;
    }

    public static void b(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Set<Integer> r101 = f450655b;
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.itemView.hashCode());
        r102.append('@');
        r102.append(r100.getPosition());
        r101.add(Integer.valueOf(r102.toString().hashCode()));
    }

    public static void c(RecyclerView.ViewHolder r100) {
        Intrinsics.checkNotNullParameter(r100, "viewHolder");
        Set<Integer> r101 = f450655b;
        StringBuilder r102 = new StringBuilder();
        r102.append(r100.itemView.hashCode());
        r102.append('@');
        r102.append(r100.getPosition());
        r101.remove(Integer.valueOf(r102.toString().hashCode()));
    }
}
