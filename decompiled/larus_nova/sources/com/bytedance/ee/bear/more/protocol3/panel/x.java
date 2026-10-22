package com.bytedance.ee.bear.more.protocol3.panel;

import android.app.Activity;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: classes18.dex */
public interface x {

    public static final class a {
        public static Activity getActivity(x r100) {
            return r100.getHostFragment().getActivity();
        }
    }

    void a();

    void d6();

    q e6(String r100);

    z f6();

    Activity getActivity();

    Fragment getHostFragment();
}
