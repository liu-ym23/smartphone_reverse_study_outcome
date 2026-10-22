package com.ss.android.ugc.discover.dynamic;

import android.content.Context;
import android.util.SparseArray;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProviders;
import com.ss.android.ugc.aweme.discover.viewmodel.ECSearchEnterViewModel;
import com.ss.android.ugc.aweme.search.components.dynamic.SearchLynxDataCenter;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f454368a = 0;

    static {
    }

    public static void a(int r100) {
        SearchLynxDataCenter r101 = SearchLynxDataCenter.f452578a;
        monitor-enter(r101);
        SparseArray<List<Integer>> r102 = SearchLynxDataCenter.f452581d;     // Catch: Throwable -> L15
        List<Integer> r103 = r102.get(r100);     // Catch: Throwable -> L15
        r102.remove(r100);     // Catch: Throwable -> L15
        if (r103 == null) goto L11;
        Iterator<T> r104 = r103.iterator();     // Catch: Throwable -> L15
    L8:
        if (r104.hasNext() == false) goto L11;
        int r105 = ((Number) r104.next()).intValue();     // Catch: Throwable -> L15
        SearchLynxDataCenter.f452580c.remove(r105);     // Catch: Throwable -> L15
    L11:
        if (SearchLynxDataCenter.f452581d.size() != 0) goto L13;
        SearchLynxDataCenter.f452580c.clear();     // Catch: Throwable -> L15
        SearchLynxDataCenter.f452579b = 0;     // Catch: Throwable -> L15
    L13:
        monitor-exit(r101);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public static String b(Context r100) {
        String r101 = null;
        if ((r100 instanceof FragmentActivity) == true) goto L5;
        Context r102 = null;
    L7:
        if (((FragmentActivity) r102) == null) goto L12;
        SearchEnterParam r103 = ((ECSearchEnterViewModel) ViewModelProviders.of((FragmentActivity) r100).get(ECSearchEnterViewModel.class)).getEnterParam();
        if (r103 == null) goto L11;
        r101 = r103.getEnterSearchFrom();
    L11:
        if (r101 == null) goto L12;
        return r101;
    L12:
        return "";
    L5:
        r102 = r100;
        goto L7
    }
}
