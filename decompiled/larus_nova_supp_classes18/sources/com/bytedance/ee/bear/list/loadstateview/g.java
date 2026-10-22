package com.bytedance.ee.bear.list.loadstateview;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.bitable.homepage.list.workspace.BitableWorkSpaceFragment;
import com.bytedance.ee.bear.facade.common.LifeCycleFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final /* synthetic */ class g implements Runnable {
    public final /* synthetic */ h a;
    public final /* synthetic */ LifecycleOwner b;
    public final /* synthetic */ Observer c;

    public /* synthetic */ g(h r1, LifeCycleFragment r2, BitableWorkSpaceFragment.BitableWorkspaceView.a r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        h r0 = this.a;
        LifecycleOwner r1 = this.b;
        Observer r2 = this.c;
        r0.e.observe(r1, r2);
    }
}
