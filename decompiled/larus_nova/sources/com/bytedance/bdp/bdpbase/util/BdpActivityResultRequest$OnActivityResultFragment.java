package com.bytedance.bdp.bdpbase.util;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes11.dex */
public class BdpActivityResultRequest$OnActivityResultFragment extends Fragment {
    public BdpActivityResultRequest$OnActivityResultFragment() {
        new AtomicBoolean(false);
    }

    @Override // android.app.Fragment
    public final void onAttach(Activity r100) {
        super.onAttach(r100);
        Activity r101 = getActivity();
        if (r101 == null) goto L7;
        r101.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        return;
    }

    @Override // android.app.Fragment
    public final void onActivityResult(int r100, int r101, Intent r102) {
        Activity r103 = getActivity();
        if (r103 == null) goto L7;
        r103.getFragmentManager().beginTransaction().remove(this).commitAllowingStateLoss();
        return;
    }
}
