package com.ss.android.ugc.aweme.discover.viewmodel;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;
import com.ss.android.ugc.aweme.search.model.SearchEnterParam;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u001a\u0010\f\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\u0004R\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/viewmodel/ECSearchEnterViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "<set-?>", "Lcom/ss/android/ugc/aweme/search/model/SearchEnterParam;", "enterParam", "getEnterParam", "()Lcom/ss/android/ugc/aweme/search/model/SearchEnterParam;", "clear", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "init", "searchEnterParam", "Companion", "trade-search-api_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class ECSearchEnterViewModel extends ViewModel {
    public static final Companion Companion = null;
    private static WeakReference<Activity> currentActivityRef;
    private static final Map<Integer, SearchEnterParam> searchEnterParamMap = null;
    private SearchEnterParam enterParam;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/viewmodel/ECSearchEnterViewModel$Companion;", "", "<init>", "()V", "trade-search-api_release"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }

        @JvmStatic
        public static ECSearchEnterViewModel a(FragmentActivity r100) {
            if (r100 == null) goto L4;
            ECSearchEnterViewModel r101 = (ECSearchEnterViewModel) ViewModelProviders.of(r100).get(ECSearchEnterViewModel.class);
            if (r101.getEnterParam() != null) goto L8;
            ECSearchEnterViewModel.access$setEnterParam$p(r101, c(r100));
        L8:
            return r101;
        L4:
            return new ECSearchEnterViewModel();
        }

        @JvmStatic
        public static SearchEnterParam b(Context r100) {
            if ((r100 instanceof FragmentActivity) == false) goto L5;
            FragmentActivity r101 = (FragmentActivity) r100;
        L6:
            if (r101 != null) goto L9;
            return null;
        L9:
            return ((ECSearchEnterViewModel) ViewModelProviders.of(r101).get(ECSearchEnterViewModel.class)).getEnterParam();
        L5:
            r101 = null;
            goto L6
        }

        @JvmStatic
        public static SearchEnterParam c(FragmentActivity r100) {
            if (r100 != null) goto L5;
            return null;
        L5:
            SearchEnterParam r101 = (SearchEnterParam) ECSearchEnterViewModel.access$getSearchEnterParamMap$cp().get(Integer.valueOf(r100.hashCode()));
            if (r101 == null) goto L9;
            return r101;
        L9:
            return ((ECSearchEnterViewModel) ViewModelProviders.of(r100).get(ECSearchEnterViewModel.class)).getEnterParam();
        }
    }

    @JvmStatic
    public static final ECSearchEnterViewModel get(FragmentActivity r100) {
        Companion.getClass();
        return Companion.a(r100);
    }

    @JvmStatic
    public static final SearchEnterParam getEnterParam(Context r100) {
        Companion.getClass();
        return Companion.b(r100);
    }

    @JvmStatic
    public static final SearchEnterParam getEnterParam(FragmentActivity r100) {
        Companion.getClass();
        return Companion.c(r100);
    }

    static {
        Companion = new Companion(0);
        searchEnterParamMap = new LinkedHashMap();
    }

    @JvmStatic
    public static final SearchEnterParam getCurSearchEnterParam() {
        Companion.getClass();
        WeakReference r100 = access$getCurrentActivityRef$cp();
        SearchEnterParam r101 = null;
        if (r100 == null) goto L5;
        Activity r102 = (Activity) r100.get();
    L6:
        if (r102 != null) goto L8;
    L12:
        return r101;
    L8:
        if ((r102 instanceof FragmentActivity) == false) goto L12;
        r101 = Companion.c((FragmentActivity) r102);
        if (r101 == null) goto L12;
        r101.getEnterSearchFrom();
        goto L12
    L5:
        r102 = null;
        goto L6
    }

    public ECSearchEnterViewModel() {
    }

    public static final /* synthetic */ WeakReference access$getCurrentActivityRef$cp() {
        return currentActivityRef;
    }

    public static final /* synthetic */ Map access$getSearchEnterParamMap$cp() {
        return searchEnterParamMap;
    }

    public final SearchEnterParam getEnterParam() {
        return this.enterParam;
    }

    public static final /* synthetic */ void access$setCurrentActivityRef$cp(WeakReference r100) {
        currentActivityRef = r100;
    }

    public final void clear(FragmentActivity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        searchEnterParamMap.remove(Integer.valueOf(r100.hashCode()));
    }

    public static final /* synthetic */ void access$setEnterParam$p(ECSearchEnterViewModel r100, SearchEnterParam r101) {
        r100.enterParam = r101;
    }

    public final void init(FragmentActivity r100, SearchEnterParam r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r100 != null) goto L6;
        return;
    L6:
        this.enterParam = r101;
        searchEnterParamMap.put(Integer.valueOf(r100.hashCode()), r101);
    }
}
