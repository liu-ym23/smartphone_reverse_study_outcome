package com.bytedance.ee.bear.sheet.fab;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ew4.e0;

/* JADX INFO: loaded from: classes18.dex */
public class FabViewModel extends ViewModel {
    private static final int KEYBOARD_HANDOFF_IDLE = 0;
    private static final int KEYBOARD_HANDOFF_WAITING_INPUT_OPEN = 2;
    private static final int KEYBOARD_HANDOFF_WAITING_PREVIOUS_DISMISS = 1;
    private a mDelegate;
    private MutableLiveData<Integer> mFabBottomOffset;
    private MutableLiveData<Integer> mFabHideTime;
    private MutableLiveData<FabItem.FabSheetItem[]> mItems;
    private int mKeyboardHandoffState;
    private e0 mSheetFabConfig;
    private final MutableLiveData<Boolean> mVisibleFromNative;

    public interface a {
        void a(String r100, String r101);
    }

    public void cancelKeyboardHandoff() {
        this.mKeyboardHandoffState = 0;
    }

    public boolean isWaitingForPreviousKeyboardDismiss() {
        if (this.mKeyboardHandoffState == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean markPreviousKeyboardDismissed() {
        if (this.mKeyboardHandoffState != 0) goto L6;
        return false;
    L6:
        this.mKeyboardHandoffState = 2;
        return true;
    }

    public FabViewModel() {
        this.mItems = new MutableLiveData();
        this.mFabHideTime = new MutableLiveData();
        this.mFabBottomOffset = new MutableLiveData(0);
        this.mVisibleFromNative = new MutableLiveData(Boolean.TRUE);
        this.mKeyboardHandoffState = 0;
    }

    public MutableLiveData<Integer> getFabBottomOffset() {
        return this.mFabBottomOffset;
    }

    public MutableLiveData<Integer> getFabHideTime() {
        return this.mFabHideTime;
    }

    public e0 getSheetFabConfig() {
        return this.mSheetFabConfig;
    }

    public MutableLiveData<FabItem.FabSheetItem[]> getTopItems() {
        return this.mItems;
    }

    public LiveData<Boolean> getVisibleFromNative() {
        return this.mVisibleFromNative;
    }

    public boolean hasFabItem(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return false;
    L5:
        if (this.mItems.getValue() == null) goto L17;
        FabItem.FabSheetItem[] r101 = this.mItems.getValue();
        int r102 = r101.length;
        int r103 = 0;
    L8:
        if (r103 >= r102) goto L18;
        if (r100.equals(r101[r103].getId()) == true) goto L11;
        r103 = r103 + 1;
        goto L8
    L11:
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    public void setDelegate(a r100) {
        this.mDelegate = r100;
    }

    public void setFabHideTime(Integer r100) {
        this.mFabHideTime.setValue(r100);
    }

    public void setSheetFabConfig(e0 r100) {
        this.mSheetFabConfig = r100;
    }

    public void setVisibleFromNative(boolean r100) {
        this.mVisibleFromNative.setValue(Boolean.valueOf(r100));
    }

    public boolean shouldIgnoreKeyboardDismiss(int r100) {
        int r101 = this.mKeyboardHandoffState;
        if (r101 != 0) goto L6;
        return false;
    L6:
        if (r100 != 0) goto L9;
        this.mKeyboardHandoffState = 2;
        return true;
    L9:
        if (r101 != 2) goto L11;
        this.mKeyboardHandoffState = 0;
    L11:
        return false;
    }

    public void startKeyboardHandoff(boolean r100) {
        this.mKeyboardHandoffState = r100 ? 1 : 0;
    }

    public void updateFabBottomOffset(int r100) {
        this.mFabBottomOffset.setValue(Integer.valueOf(Math.max(r100, 0)));
    }

    public void updateItems(FabItem.FabSheetItem[] r100) {
        this.mItems.setValue(r100);
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L11;
        FabItem.FabSheetItem r103 = r100[r102];
        if (FabItemEnum.operation.name().equals(r103.getId()) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        on5.a.f524352b = r103.getRangeType().toLowerCase();
        return;
    }

    public void clickItem(String r100, String r101) {
        a r102 = this.mDelegate;
        if (r102 == null) goto L8;
        if (r101 != null) goto L6;
        r101 = "";
    L6:
        r102.a(r100, r101);
        return;
    }
}
