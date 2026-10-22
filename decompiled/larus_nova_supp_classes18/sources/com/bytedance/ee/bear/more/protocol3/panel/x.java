package com.bytedance.ee.bear.more.protocol3.panel;

import android.app.Activity;
import androidx.fragment.app.Fragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface x {

    public static final class a {
        public static Activity getActivity(x r0) {
            return r0.getHostFragment().getActivity();
        }
    }

    void a();

    void d6();

    q e6(String r1);

    z f6();

    Activity getActivity();

    Fragment getHostFragment();
}
