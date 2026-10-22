package com.bytedance.ee.bear.document.orientation;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.Stack;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
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
        public final /* synthetic */ OrientationViewModel a;

        @Override // android.database.ContentObserver
        public final void onChange(boolean r2) {
            OrientationViewModel.access$100(this.a).setValue(Boolean.valueOf(OrientationViewModel.access$000(this.a)));
        }

        public a(OrientationViewModel r1, Handler r2) {
            this.a = r1;
            super(r2);
        }
    }

    public static /* synthetic */ void yo(OrientationViewModel r0, Stack r1) {
        r0.lambda$onOrientationSupportPanelDismiss$0(r1);
    }

    private Stack<p> getPanelStack() {
        Stack<p> r0 = (Stack) this.mPanels.getValue();
        if (r0 != null) goto L6;
        Stack<p> r1 = new Stack();
        this.mPanels.setValue(r1);
        return r1;
    L6:
        return r0;
    }

    private boolean isLocked() {
        ContentResolver r0 = this.mContentResolver;
        if (r0 != null) goto L5;
        return false;
    L5:
        if (Settings.System.getInt(r0, "accelerometer_rotation", 0) != 0) goto L9;
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

    public void onCleared() {
        ContentResolver r0 = this.mContentResolver;
        if (r0 == null) goto L6;
        r0.unregisterContentObserver(this.mContentObserver);
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

    public static /* synthetic */ boolean access$000(OrientationViewModel r0) {
        return r0.isLocked();
    }

    public static /* synthetic */ MutableLiveData access$100(OrientationViewModel r0) {
        return r0.mLocked;
    }

    private /* synthetic */ void lambda$onOrientationSupportPanelDismiss$0(Stack r2) {
        this.mPanels.setValue(r2);
    }

    public void onOrientationSupportPanelDismiss(p r3) {
        final Stack<p> r0 = getPanelStack();
        r0.remove(r3);
        com.bytedance.ee.util.ui.j.d(new q(this, r0), 200);
    }

    public void onOrientationSupportPanelShowing(p r3) {
        Stack<p> r0 = getPanelStack();
        if (r0.isEmpty() == false) goto L5;
    L7:
        r0.push(r3);
        this.mPanels.setValue(r0);
        return;
    L5:
        if (r0.peek() != r3) goto L7;
    }

    public void registerLockObserver(Context r4) {
        this.mContentObserver = new a(this, new Handler());     // Catch: Exception -> L4
        ContentResolver r5 = r4.getContentResolver();     // Catch: Exception -> L4
        this.mContentResolver = r5;     // Catch: Exception -> L4
        r5.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.mContentObserver);     // Catch: Exception -> L4
        this.mLocked.setValue(Boolean.valueOf(isLocked()));     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        tt5.a.e(TAG, "registerLockObserver: ", e, false);
    }

    public void setRequestOrientation(int r3) {
        tt5.a.h(TAG, "setRequestOrientation: " + r3);
        this.mRequestOrientation = r3;
    }

    public void setSource(String r1) {
        this.mSource = r1;
    }
}
