package com.bytedance.ee.bear.facade.common;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import sa5.r;

/* JADX INFO: loaded from: classes16.dex */
public class LifeCycleFragment extends Fragment implements r {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f226403d;

    public LifeCycleFragment() {
        this.f226403d = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f226403d = false;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f226403d = true;
    }
}
