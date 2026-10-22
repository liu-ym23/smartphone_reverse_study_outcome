package com.bytedance.ee.bear.content.creation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import iw4.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class SelectCreationMenuViewModel extends ViewModel {
    public static final int STATE_DISMISS = 0;
    public static final int STATE_SHOW = 1;
    private final MutableLiveData<b> liveCreationMenuItemClick;
    private final MutableLiveData<Integer> selectCreationMenuState;
    private final MutableLiveData<Integer> selectedCreationType;

    public void clearClickCreationMenuItem() {
        this.liveCreationMenuItemClick.setValue(null);
    }

    public SelectCreationMenuViewModel() {
        this.liveCreationMenuItemClick = new MutableLiveData();
        this.selectedCreationType = new MutableLiveData();
        this.selectCreationMenuState = new MutableLiveData();
    }

    public LiveData<b> getCreationMenuItemClick() {
        return this.liveCreationMenuItemClick;
    }

    public LiveData<Integer> getSelectCreationMenuStateLiveData() {
        return this.selectCreationMenuState;
    }

    public LiveData<Integer> getSelectedCreationTypeLiveData() {
        return this.selectedCreationType;
    }

    public void setOnClickCreationMenuItem(b r2) {
        this.liveCreationMenuItemClick.setValue(r2);
    }

    public void setSelectCreationMenuState(Integer r2) {
        this.selectCreationMenuState.setValue(r2);
    }

    public void setSelectedCreationType(int r2) {
        this.selectedCreationType.setValue(Integer.valueOf(r2));
    }
}
