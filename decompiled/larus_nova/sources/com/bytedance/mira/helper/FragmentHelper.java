package com.bytedance.mira.helper;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/* JADX INFO: loaded from: classes21.dex */
public class FragmentHelper {
    private static final String FRAGMENT_TAG = "mira_fragment_config_change_tag";

    public FragmentHelper() {
    }

    public static void addCallback(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        FragmentManager r101 = r100.getFragmentManager();
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.findFragmentByTag(FRAGMENT_TAG) == null) goto L10;
        return;
    L10:
        ListenerConfigChangeFragment r102 = new ListenerConfigChangeFragment();
        FragmentTransaction r103 = r101.beginTransaction();
        r103.add(0, r102, FRAGMENT_TAG);
        r103.commitAllowingStateLoss();
    }

    public static void removeCallback(Activity r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        FragmentManager r101 = r100.getFragmentManager();
        if (r101 != null) goto L7;
        return;
    L7:
        Fragment r102 = r101.findFragmentByTag(FRAGMENT_TAG);
        if (r102 != null) goto L10;
        return;
    L10:
        FragmentTransaction r103 = r101.beginTransaction();
        r103.remove(r102);
        r103.commitAllowingStateLoss();
    }
}
