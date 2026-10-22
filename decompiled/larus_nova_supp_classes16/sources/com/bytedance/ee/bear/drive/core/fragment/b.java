package com.bytedance.ee.bear.drive.core.fragment;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.widgets.BaseTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements la5.i.b {
    public final /* synthetic */ BaseTitleBar a;
    public final /* synthetic */ AbsLazyLoadFragment b;

    @Override // la5.i.b
    public FragmentActivity getActivity() {
        return this.b.requireActivity();
    }

    public b(AbsLazyLoadFragment r1, BaseTitleBar r2) {
        this.b = r1;
        this.a = r2;
    }
}
