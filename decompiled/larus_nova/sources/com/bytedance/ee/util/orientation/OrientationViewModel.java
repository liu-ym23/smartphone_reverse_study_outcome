package com.bytedance.ee.util.orientation;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/* JADX INFO: loaded from: classes19.dex */
public class OrientationViewModel extends ViewModel {
    private static final int PANEL_CHANGE_DELAY = 200;
    private static final String TAG = "OrientationViewModel";
    private ContentObserver mContentObserver;
    private ContentResolver mContentResolver;
    private MutableLiveData<Boolean> mEnable;
    private MutableLiveData<Boolean> mLocked;
    private int mRequestOrientation;
    private String mSource;
    private boolean mSwitchOrientationTemporarily;

    public class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrientationViewModel f243150a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            OrientationViewModel.access$100(this.f243150a).setValue(Boolean.valueOf(OrientationViewModel.access$000(this.f243150a)));
        }

        public a(OrientationViewModel r100, Handler r101) {
            this.f243150a = r100;
            super(r101);
        }
    }

    private boolean isLocked() {
        ContentResolver r100 = this.mContentResolver;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (Settings.System.getInt(r100, "accelerometer_rotation", 0) != 0) goto L9;
        return true;
    L9:
        return false;
    }

    public void disable() {
        if (Boolean.TRUE.equals(this.mEnable.getValue()) == false) goto L6;
        this.mEnable.setValue(Boolean.FALSE);
        return;
    }

    public void enable() {
        if (Boolean.FALSE.equals(this.mEnable.getValue()) == false) goto L6;
        this.mEnable.setValue(Boolean.TRUE);
        return;
    }

    public boolean isLock() {
        return Boolean.TRUE.equals(this.mLocked.getValue());
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        if (this.mContentResolver == null) goto L6;
        tt5.a.h(TAG, "onCleared() called mContentResolver: " + this.mContentResolver + " mContentObserver:" + this.mContentObserver);
        this.mContentResolver.unregisterContentObserver(this.mContentObserver);
        return;
    }

    public OrientationViewModel() {
        this.mEnable = new MutableLiveData();
        this.mLocked = new MutableLiveData();
        this.mRequestOrientation = -1;
        this.mEnable.setValue(Boolean.TRUE);
    }

    public MutableLiveData<Boolean> getEnable() {
        return this.mEnable;
    }

    public MutableLiveData<Boolean> getLocked() {
        return this.mLocked;
    }

    public int getRequestOrientation() {
        return this.mRequestOrientation;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean isSwitchOrientationTemporarily() {
        return this.mSwitchOrientationTemporarily;
    }

    public static /* synthetic */ boolean access$000(OrientationViewModel r100) {
        return r100.isLocked();
    }

    public static /* synthetic */ MutableLiveData access$100(OrientationViewModel r100) {
        return r100.mLocked;
    }

    public void registerLockObserver(Context r100) {
        this.mContentObserver = new a(this, new Handler());
        ContentResolver r101 = r100.getContentResolver();
        this.mContentResolver = r101;
        r101.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.mContentObserver);
        this.mLocked.setValue(Boolean.valueOf(isLocked()));
        tt5.a.h(TAG, "registerLockObserver() called with: context = [" + r100 + "] mContentResolver:" + this.mContentResolver + " mContentObserver:" + this.mContentObserver);
    }

    public void setRequestOrientation(int r100) {
        tt5.a.h(TAG, "setRequestOrientation: " + r100);
        this.mRequestOrientation = r100;
    }

    public void setSource(String r100) {
        this.mSource = r100;
    }

    public void setSwitchOrientationTemporarily(boolean r100) {
        this.mSwitchOrientationTemporarily = r100;
    }
}
