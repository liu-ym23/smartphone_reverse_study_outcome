package com.bytedance.ee.bear.list.sort;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.appsetting.downgrade.DowngradeSettingUtil;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiMutableLiveData;
import com.bytedance.ee.bear.list.cache.FolderSortStrategy;

/* JADX INFO: loaded from: classes18.dex */
public class SortAndFilterViewModel extends ViewModel {
    public static final int STATE_DISMISS = 0;
    public static final int STATE_SHOW = 1;
    private final MutableLiveData<Integer> sortAndFilterMenuState;
    private final MutableLiveData<FolderSortStrategy> sortStrategy;

    public static class a<T> extends ForsetiMutableLiveData<T> {
        public a(int r100) {
        }

        @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiMutableLiveData
        public final boolean a(FragmentActivity r100) {
            if (super.a(r100) == true) goto L5;
        L7:
            return false;
        L5:
            if (DowngradeSettingUtil.a("downgradeSortFilterObserve") == true) goto L7;
            return true;
        }
    }

    public SortAndFilterViewModel() {
        this.sortStrategy = new a(0);
        this.sortAndFilterMenuState = new a(0);
    }

    public LiveData<Integer> getSortAndFilterMenuStateLiveData() {
        return this.sortAndFilterMenuState;
    }

    public LiveData<FolderSortStrategy> getSortStrategyLiveData() {
        return this.sortStrategy;
    }

    public void postSortStrategy(FolderSortStrategy r100) {
        this.sortStrategy.postValue(r100);
    }

    public void setSortAndFilterMenuState(int r100) {
        this.sortAndFilterMenuState.setValue(Integer.valueOf(r100));
    }

    public void setSortStrategy(FolderSortStrategy r100) {
        this.sortStrategy.setValue(r100);
    }
}
