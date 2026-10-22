package com.bytedance.ee.bear.facade.common;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import sa5.r;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LifeCycleFragment extends Fragment implements r {
    public boolean d;

    public LifeCycleFragment() {
        this.d = false;
    }

    public void onDestroy() {
        super.onDestroy();
        this.d = false;
    }

    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.d = true;
    }
}
