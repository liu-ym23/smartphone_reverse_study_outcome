package com.bytedance.ee.bear.sheet.celldropdown;

import android.content.Context;
import android.text.TextUtils;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer;
import com.bytedance.ee.bear.document.toolbar.editpanels.KeyboardShowingStatusMode;
import java.util.Arrays;
import pm5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class DropdownViewModel extends ViewModel implements g45.a, VcKeyboardChangeEventProducer {
    private static final String TAG = "DropdownViewModel";
    private MutableLiveData<Boolean> active;
    private MutableLiveData<DropdownData.a[]> data;
    private a delegate;
    private MutableLiveData<Boolean> isMultiple;
    private b panelHeightDelegate;
    private MutableLiveData<Boolean> showDropdown;
    private String textColor;

    public interface a {
        void a();

        void b(String r1);

        void onCancel();
    }

    public interface b {
    }

    public String getPanelName() {
        return "dropdown";
    }

    public void requestNotFocus(Context r1) {
    }

    public void cancelDropdown() {
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.onCancel();
        return;
    }

    public LiveData<Boolean> getActive() {
        if (this.active != null) goto L6;
        this.active = new MutableLiveData();
    L6:
        return this.active;
    }

    public MutableLiveData<DropdownData.a[]> getData() {
        if (this.data != null) goto L6;
        this.data = new MutableLiveData();
    L6:
        return this.data;
    }

    public void switchToKeyboard() {
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public DropdownViewModel() {
        this.showDropdown = new MutableLiveData();
        this.textColor = null;
        this.isMultiple = new MutableLiveData();
    }

    public MutableLiveData<Boolean> getIsMultiple() {
        return this.isMultiple;
    }

    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    public MutableLiveData<Boolean> getShowDropdown() {
        return this.showDropdown;
    }

    public String getTextColor() {
        return this.textColor;
    }

    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    public int getPanelHeight(Context r2) {
        b r3 = this.panelHeightDelegate;
        if (r3 == null) goto L9;
        DropdownPopupFragment r4 = ((d) r3).a;
        if (r4.j.getMeasuredHeight() != 0) goto L8;
        r4.aa0();
    L8:
        return r4.j.getMeasuredHeight();
    L9:
        tt5.a.d(TAG, "panelHeightDelegate not set!");
        return 0;
    }

    public void selectOption(String r2) {
        a r0 = this.delegate;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }

    public void setActive(Boolean r2) {
        Boolean r0 = (Boolean) getActive().getValue();
        if (r0 != null) goto L5;
    L6:
        this.active.setValue(r2);
        return;
    L5:
        if (r0.equals(r2) == false) goto L6;
    }

    public void setData(DropdownData.a[] r2) {
        DropdownData.a[] r0 = (DropdownData.a[]) getData().getValue();
        if (r0 != null) goto L5;
    L6:
        this.data.setValue(r2);
        return;
    L5:
        if (Arrays.deepEquals(r0, r2) == false) goto L6;
    }

    public void setDelegate(a r1) {
        this.delegate = r1;
    }

    public void setIsMultiple(boolean r2) {
        this.isMultiple.setValue(Boolean.valueOf(r2));
    }

    public void setPanelHeightDelegate(b r1) {
        this.panelHeightDelegate = r1;
    }

    public void setShowDropdown(boolean r2) {
        this.showDropdown.setValue(Boolean.valueOf(r2));
    }

    public void setTextColor(String r2) {
        if (TextUtils.equals(getTextColor(), r2) == true) goto L6;
        this.textColor = r2;
        return;
    }

    public void onBecomeActive(g45.d r1, g45.a r2) {
        r1.requestUpdateWebContentHeight();
    }

    public void onBecomeInactive(g45.d r1, g45.a r2) {
        this.active.setValue(Boolean.FALSE);
    }
}
