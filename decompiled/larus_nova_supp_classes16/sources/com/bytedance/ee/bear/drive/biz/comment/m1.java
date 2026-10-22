package com.bytedance.ee.bear.drive.biz.comment;

import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.drive.core.DrivePluginHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface m1 {
    DrivePluginHost S();

    <T extends ViewModel> T a(Class<T> r1);

    FragmentActivity getActivity();
}
