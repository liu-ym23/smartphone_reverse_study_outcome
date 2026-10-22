package com.bytedance.ee.bear.atfinder;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.at.AtObject;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public class AtFinderViewModel extends ViewModel {
    private static final String TAG = "AtFinderViewModel";
    private ArrayList<String> authorIds;
    private boolean isOwner;
    private f mSearchDelegate;
    private Map<String, MutableLiveData<AtFinderResult>> mSearchResultMap;
    private String ownerId;
    private Disposable searchDisposable;

    public class a implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f206342a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ AtFinderViewModel f206343b;

        @Override // com.bytedance.ee.bear.atfinder.g
        public final void a() {
            tt5.a.h(AtFinderViewModel.TAG, "onSearchStart: ");
        }

        @Override // com.bytedance.ee.bear.atfinder.g
        public final void b(AtFinderResult r100) {
            if (r100 == null) goto L8;
            List<AtObject> r101 = r100.list;
            if (r101 == null) goto L8;
            if (r101.isEmpty() == true) goto L8;
            boolean r102 = true;
        L9:
            tt5.a.h(AtFinderViewModel.TAG, "onSearchResult: hasResult:" + r102);
            this.f206343b.getSearchResultList(this.f206342a).setValue(r100);
            return;
        L8:
            r102 = false;
            goto L9
        }

        public a(AtFinderViewModel r100, String r101) {
            this.f206343b = r100;
            this.f206342a = r101;
        }
    }

    public AtFinderViewModel() {
        this.mSearchResultMap = new HashMap();
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        Disposable r100 = this.searchDisposable;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDisposed() == true) goto L9;
        this.searchDisposable.dispose();
        this.searchDisposable = null;
        return;
    }

    public MutableLiveData<AtFinderResult> getSearchResultList(String r100) {
        if (this.mSearchResultMap.containsKey(r100) == true) goto L5;
        MutableLiveData<AtFinderResult> r101 = new MutableLiveData();
        this.mSearchResultMap.put(r100, r101);
        return r101;
    L5:
        return this.mSearchResultMap.get(r100);
    }

    public void setSearchDelegate(f r100) {
        this.mSearchDelegate = r100;
    }

    public void onSearchResult(String r100, AtFinderResult r101) {
        getSearchResultList(r100).setValue(r101);
    }

    public void setOwnerAndAuthors(String r100, boolean r101, ArrayList<String> r102) {
        this.ownerId = r100;
        this.isOwner = r101;
        this.authorIds = r102;
    }

    public void search(String r100, String r101, String r102, int r103, String r104) {
        tt5.a.h(TAG, "search: ");
        if (this.mSearchDelegate != null) goto L7;
        tt5.a.d(TAG, "search(): SearchDelegate is null");
        return;
    L7:
        if (this.mSearchResultMap.get(r102) != null) goto L9;
        MutableLiveData<AtFinderResult> r105 = new MutableLiveData();
        this.mSearchResultMap.put(r102, r105);
    L9:
        Disposable r106 = this.searchDisposable;
        if (r106 != null) goto L12;
    L14:
        MentionModel r107 = new MentionModel(r101, r100, r103, "");
        r107.setOwnerId(this.ownerId);
        r107.setOwner(this.isOwner);
        r107.setAuthorIds(this.authorIds);
        this.searchDisposable = this.mSearchDelegate.a(r107, r102, new a(this, r102));
        return;
    L12:
        if (r106.isDisposed() == true) goto L14;
        this.searchDisposable.dispose();
        goto L14
    }
}
