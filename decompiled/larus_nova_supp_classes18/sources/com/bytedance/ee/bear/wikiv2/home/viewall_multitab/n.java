package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n extends t {
    public final /* synthetic */ WikiSpaceTabFragment c;

    public n(WikiSpaceTabFragment r1) {
        this.c = r1;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r1) {
        FragmentActivity r2 = this.c.getActivity();
        if (r2 == null) goto L6;
        r2.onBackPressed();
        return;
    }
}
