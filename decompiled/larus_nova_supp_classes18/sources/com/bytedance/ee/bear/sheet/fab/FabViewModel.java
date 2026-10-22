package com.bytedance.ee.bear.sheet.fab;

import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import ew4.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
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
        void a(String r1, String r2);
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

    public boolean hasFabItem(String r6) {
        if (TextUtils.isEmpty(r6) == false) goto L5;
        return false;
    L5:
        if (this.mItems.getValue() == null) goto L17;
        FabItem.FabSheetItem[] r0 = (FabItem.FabSheetItem[]) this.mItems.getValue();
        int r2 = r0.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L18;
        if (r6.equals(r0[r3].getId()) == true) goto L11;
        r3 = r3 + 1;
        goto L8
    L11:
        return true;
    L18:
        return false;
    L17:
        return false;
    }

    public void setDelegate(a r1) {
        this.mDelegate = r1;
    }

    public void setFabHideTime(Integer r2) {
        this.mFabHideTime.setValue(r2);
    }

    public void setSheetFabConfig(e0 r1) {
        this.mSheetFabConfig = r1;
    }

    public void setVisibleFromNative(boolean r2) {
        this.mVisibleFromNative.setValue(Boolean.valueOf(r2));
    }

    public boolean shouldIgnoreKeyboardDismiss(int r4) {
        int r0 = this.mKeyboardHandoffState;
        if (r0 != 0) goto L6;
        return false;
    L6:
        if (r4 != 0) goto L9;
        this.mKeyboardHandoffState = 2;
        return true;
    L9:
        if (r0 != 2) goto L11;
        this.mKeyboardHandoffState = 0;
    L11:
        return false;
    }

    public void startKeyboardHandoff(boolean r1) {
        this.mKeyboardHandoffState = r1 ? 1 : 0;
    }

    public void updateFabBottomOffset(int r3) {
        this.mFabBottomOffset.setValue(Integer.valueOf(Math.max(r3, 0)));
    }

    public void updateItems(FabItem.FabSheetItem[] r6) {
        this.mItems.setValue(r6);
        int r0 = r6.length;
        int r1 = 0;
    L3:
        if (r1 >= r0) goto L11;
        FabItem.FabSheetItem r2 = r6[r1];
        if (FabItemEnum.operation.name().equals(r2.getId()) == true) goto L6;
        r1 = r1 + 1;
        goto L3
    L6:
        on5.a.b = r2.getRangeType().toLowerCase();
        return;
    }

    public void clickItem(String r2, String r3) {
        a r0 = this.mDelegate;
        if (r0 == null) goto L8;
        if (r3 != null) goto L6;
        r3 = "";
    L6:
        r0.a(r2, r3);
        return;
    }
}
