package com.bytedance.scene;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

/* JADX INFO: loaded from: classes19.dex */
public class ScopeHolderFragment extends Fragment implements n.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f268617a;

    public ScopeHolderFragment() {
        this.f268617a = n.f268740e.N80();
    }

    @Override // com.bytedance.scene.n.b
    public final n N80() {
        return this.f268617a;
    }

    @Override // android.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        setRetainInstance(true);
    }

    public static ScopeHolderFragment a(Activity r100, boolean r101) {
        FragmentManager r102 = r100.getFragmentManager();
        ScopeHolderFragment r103 = (ScopeHolderFragment) r102.findFragmentByTag("LifeCycleFragment_ScopeHolderFragment");
        if (r103 == null) goto L6;
        if (r101 == false) goto L6;
        FragmentTransaction r104 = r102.beginTransaction();
        r104.remove(r103);
        qa7.g.a(r102, r104, true);
        r103 = null;
    L6:
        if (r103 != null) goto L9;
        ScopeHolderFragment r105 = new ScopeHolderFragment();
        FragmentTransaction r106 = r102.beginTransaction();
        r106.add(r105, "LifeCycleFragment_ScopeHolderFragment");
        qa7.g.a(r102, r106, true);
        return r105;
    L9:
        return r103;
    }
}
