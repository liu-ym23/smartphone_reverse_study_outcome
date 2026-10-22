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

/* JADX INFO: loaded from: classes18.dex */
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

        void b(String r100);

        void onCancel();
    }

    public interface b {
    }

    @Override // g45.a
    public String getPanelName() {
        return "dropdown";
    }

    @Override // g45.a
    public void requestNotFocus(Context r100) {
    }

    public void cancelDropdown() {
        a r100 = this.delegate;
        if (r100 == null) goto L6;
        r100.onCancel();
        return;
    }

    @Override // g45.a
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
        a r100 = this.delegate;
        if (r100 == null) goto L6;
        r100.a();
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

    @Override // g45.a
    public KeyboardShowingStatusMode getKeyboardShowingStatusMode() {
        return KeyboardShowingStatusMode.ALWAYS_SHOW;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.OrientationSwitchMode getOrientationSwitchMode() {
        return VcKeyboardChangeEventProducer.OrientationSwitchMode.ADJUST_BY_KEYBOARD_EVENT;
    }

    public MutableLiveData<Boolean> getShowDropdown() {
        return this.showDropdown;
    }

    public String getTextColor() {
        return this.textColor;
    }

    @Override // com.bytedance.ee.bear.doc.follow.event.VcKeyboardChangeEventProducer
    public VcKeyboardChangeEventProducer.VcBottomBarPolicy getVcBottomBarPolicy() {
        return VcKeyboardChangeEventProducer.VcBottomBarPolicy.ADJUST_BY_KEYBOARD;
    }

    @Override // g45.a
    public int getPanelHeight(Context r100) {
        b r101 = this.panelHeightDelegate;
        if (r101 == null) goto L9;
        DropdownPopupFragment r102 = ((d) r101).f529841a;
        if (r102.f237459j.getMeasuredHeight() != 0) goto L8;
        r102.aa0();
    L8:
        return r102.f237459j.getMeasuredHeight();
    L9:
        tt5.a.d(TAG, "panelHeightDelegate not set!");
        return 0;
    }

    public void selectOption(String r100) {
        a r101 = this.delegate;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    public void setActive(Boolean r100) {
        Boolean r101 = getActive().getValue();
        if (r101 != null) goto L5;
    L6:
        this.active.setValue(r100);
        return;
    L5:
        if (r101.equals(r100) == false) goto L6;
    }

    public void setData(DropdownData.a[] r100) {
        DropdownData.a[] r101 = getData().getValue();
        if (r101 != null) goto L5;
    L6:
        this.data.setValue(r100);
        return;
    L5:
        if (Arrays.deepEquals(r101, r100) == false) goto L6;
    }

    public void setDelegate(a r100) {
        this.delegate = r100;
    }

    public void setIsMultiple(boolean r100) {
        this.isMultiple.setValue(Boolean.valueOf(r100));
    }

    public void setPanelHeightDelegate(b r100) {
        this.panelHeightDelegate = r100;
    }

    public void setShowDropdown(boolean r100) {
        this.showDropdown.setValue(Boolean.valueOf(r100));
    }

    public void setTextColor(String r100) {
        if (TextUtils.equals(getTextColor(), r100) == true) goto L6;
        this.textColor = r100;
        return;
    }

    @Override // g45.a
    public void onBecomeActive(g45.d r100, g45.a r101) {
        r100.requestUpdateWebContentHeight();
    }

    @Override // g45.a
    public void onBecomeInactive(g45.d r100, g45.a r101) {
        this.active.setValue(Boolean.FALSE);
    }
}
