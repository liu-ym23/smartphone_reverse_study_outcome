package com.bytedance.ee.bear.document.orientation;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.Stack;

/* JADX INFO: loaded from: classes16.dex */
public class OrientationViewModel extends ViewModel {
    private static final int PANEL_CHANGE_DELAY = 200;
    private static final String TAG = "OrientationViewModel";
    private ContentObserver mContentObserver;
    private ContentResolver mContentResolver;
    private MutableLiveData<Boolean> mEnable;
    private MutableLiveData<Boolean> mLocked;
    private MutableLiveData<Stack<p>> mPanels;
    private int mRequestOrientation;
    private String mSource;

    public class a extends ContentObserver {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OrientationViewModel f220729a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r100) {
            OrientationViewModel.access$100(this.f220729a).setValue(Boolean.valueOf(OrientationViewModel.access$000(this.f220729a)));
        }

        public a(OrientationViewModel r100, Handler r101) {
            this.f220729a = r100;
            super(r101);
        }
    }

    public static /* synthetic */ void yo(OrientationViewModel r100, Stack r101) {
        r100.lambda$onOrientationSupportPanelDismiss$0(r101);
    }

    private Stack<p> getPanelStack() {
        Stack<p> r100 = this.mPanels.getValue();
        if (r100 != null) goto L6;
        Stack<p> r101 = new Stack();
        this.mPanels.setValue(r101);
        return r101;
    L6:
        return r100;
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
        ContentResolver r100 = this.mContentResolver;
        if (r100 == null) goto L6;
        r100.unregisterContentObserver(this.mContentObserver);
        return;
    }

    public OrientationViewModel() {
        this.mPanels = new MutableLiveData();
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

    public MutableLiveData<Stack<p>> getPanels() {
        return this.mPanels;
    }

    public int getRequestOrientation() {
        return this.mRequestOrientation;
    }

    public String getSource() {
        return this.mSource;
    }

    public static /* synthetic */ boolean access$000(OrientationViewModel r100) {
        return r100.isLocked();
    }

    public static /* synthetic */ MutableLiveData access$100(OrientationViewModel r100) {
        return r100.mLocked;
    }

    private /* synthetic */ void lambda$onOrientationSupportPanelDismiss$0(Stack r100) {
        this.mPanels.setValue(r100);
    }

    public void onOrientationSupportPanelDismiss(p r100) {
        final Stack<p> r101 = getPanelStack();
        r101.remove(r100);
        com.bytedance.ee.util.ui.j.d(new q(this, r101), 200);
    }

    public void onOrientationSupportPanelShowing(p r100) {
        Stack<p> r101 = getPanelStack();
        if (r101.isEmpty() == false) goto L5;
    L7:
        r101.push(r100);
        this.mPanels.setValue(r101);
        return;
    L5:
        if (r101.peek() != r100) goto L7;
    }

    public void registerLockObserver(Context r100) {
        this.mContentObserver = new a(this, new Handler());     // Catch: Exception -> L4
        ContentResolver r101 = r100.getContentResolver();     // Catch: Exception -> L4
        this.mContentResolver = r101;     // Catch: Exception -> L4
        r101.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.mContentObserver);     // Catch: Exception -> L4
        this.mLocked.setValue(Boolean.valueOf(isLocked()));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.e(TAG, "registerLockObserver: ", e, false);
    }

    public void setRequestOrientation(int r100) {
        tt5.a.h(TAG, "setRequestOrientation: " + r100);
        this.mRequestOrientation = r100;
    }

    public void setSource(String r100) {
        this.mSource = r100;
    }
}
