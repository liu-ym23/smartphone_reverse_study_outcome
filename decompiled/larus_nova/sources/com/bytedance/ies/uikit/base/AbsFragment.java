package com.bytedance.ies.uikit.base;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.common.utility.collection.WeakContainer;
import java.util.Iterator;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AbsFragment extends Fragment implements b {
    private long mDestoryTime;
    private WeakContainer<c> mMonitors;
    protected boolean mStatusActive;
    protected boolean mStatusDestroyed;
    protected boolean mStatusViewValid;
    protected boolean mUserVisibleHintCompat;

    public AbsFragment() {
        this.mUserVisibleHintCompat = true;
        this.mMonitors = new WeakContainer();
        this.mDestoryTime = 0;
    }

    public boolean getUserVisibleHintCompat() {
        return getUserVisibleHint();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.mDestoryTime = System.currentTimeMillis();
        this.mStatusViewValid = false;
        this.mStatusDestroyed = true;
        if (this.mMonitors.isEmpty() == true) goto L17;
        Iterator<c> r100 = this.mMonitors.iterator();
    L6:
        if (r100.hasNext() == false) goto L10;
        c r101 = r100.next();
        if (r101 == null) goto L6;
        r101.onDestroy();
        goto L6
    L10:
        this.mMonitors.clear();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.mStatusViewValid = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.mMonitors.isEmpty() == true) goto L10;
        Iterator<c> r100 = this.mMonitors.iterator();
    L6:
        if (r100.hasNext() == false) goto L16;
        c r101 = r100.next();
        if (r101 == null) goto L6;
        r101.onPause();
        goto L6
    L16:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mStatusActive = true;
        if (this.mMonitors.isEmpty() == true) goto L10;
        Iterator<c> r100 = this.mMonitors.iterator();
    L6:
        if (r100.hasNext() == false) goto L16;
        c r101 = r100.next();
        if (r101 == null) goto L6;
        r101.onResume();
        goto L6
    L16:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        this.mStatusActive = false;
        if (this.mMonitors.isEmpty() == true) goto L10;
        Iterator<c> r100 = this.mMonitors.iterator();
    L6:
        if (r100.hasNext() == false) goto L16;
        c r101 = r100.next();
        if (r101 == null) goto L6;
        r101.onStop();
        goto L6
    L16:
        return;
    }

    public boolean isActive() {
        return this.mStatusActive;
    }

    public boolean isDestroyed() {
        return this.mStatusDestroyed;
    }

    public boolean isViewValid() {
        return this.mStatusViewValid;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.mStatusActive = false;
        this.mStatusViewValid = false;
        this.mStatusDestroyed = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r100) {
        if (r100 == null) goto L4;
        r100.putBoolean("WORKAROUND_FOR_BUG_19917_KEY", true);
    L4:
        super.onSaveInstanceState(r100);
    }

    public void registerLifeCycleMonitor(c r100) {
        this.mMonitors.add(r100);
    }

    public void setUserVisibleHintCompat(boolean r100) {
        setUserVisibleHint(r100);
    }

    public void unregisterLifeCycleMonitor(c r100) {
        this.mMonitors.remove(r100);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        super.onViewCreated(r100, r101);
        this.mStatusViewValid = true;
    }
}
