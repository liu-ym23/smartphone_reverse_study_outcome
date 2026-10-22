package com.volcengine.zeus.fragment;

import android.app.Application;
import android.app.Fragment;
import android.content.Context;
import com.volcengine.zeus.Zeus;

/* JADX INFO: loaded from: classes.dex */
public class ReportBaseFragment extends Fragment {
    Application.ActivityLifecycleCallbacks callbacks;

    public ReportBaseFragment() {
        this.callbacks = null;
    }

    @Override // android.app.Fragment
    public void onDetach() {
        super.onDetach();
        if (this.callbacks == null) goto L6;
        Zeus.getAppApplication().unregisterActivityLifecycleCallbacks(this.callbacks);
        return;
    }

    @Override // android.app.Fragment
    public void onAttach(Context r100) {
        super.onAttach(r100);
        if (this.callbacks != null) goto L5;
        this.callbacks = new c(this);
    L5:
        Zeus.getAppApplication().registerActivityLifecycleCallbacks(this.callbacks);
    }
}
