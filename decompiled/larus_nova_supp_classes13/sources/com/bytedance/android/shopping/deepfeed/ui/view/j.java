package com.bytedance.android.shopping.deepfeed.ui.view;

import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements View.OnClickListener {
    public final /* synthetic */ DeepFeedTopBarManager a;
    public final /* synthetic */ Fragment b;

    public j(DeepFeedTopBarManager r1, Fragment r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        DeepFeedTopBarManager r3 = this.a;
        r3.g = true;
        DeepFeedTopBarManager.a(r3);
        FragmentActivity r4 = this.b.getActivity();
        if (r4 == null) goto L6;
        r4.finish();
        return;
    }
}
