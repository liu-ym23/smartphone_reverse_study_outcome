package com.bytedance.common.jato.gc;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/* JADX INFO: loaded from: classes15.dex */
public class FragmentLeakCheck extends FragmentManager.FragmentLifecycleCallbacks implements LightLeakObject.LeakChecker {
    private int sampleRate;

    public FragmentLeakCheck() {
        this.sampleRate = 0;
    }

    @Override // androidx.fragment.app.FragmentManager.FragmentLifecycleCallbacks
    public void onFragmentDestroyed(FragmentManager r100, Fragment r101) {
        LightLeakObject.getInstance().addLeakObject(r101, null, this);
    }
}
