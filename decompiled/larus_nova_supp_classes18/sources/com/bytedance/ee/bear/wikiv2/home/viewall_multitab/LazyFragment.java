package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import android.os.Bundle;
import android.view.View;
import com.bytedance.ee.bear.facade.common.BaseFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class LazyFragment extends BaseFragment {
    public boolean e;
    public boolean f;
    public boolean g;

    public void U90() {
    }

    public void V90() {
    }

    public final boolean getUserVisibleHint() {
        return super/*androidx.fragment.app.Fragment*/.getUserVisibleHint();
    L4:
        e = move-exception;
        tt5.a.f("AbsDrivePreviewFragment", e, false);
        return true;
    }

    public final void onDestroy() {
        super.onDestroy();
        this.f = false;
    }

    public void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        if (this.g == false) goto L6;
        V90();
        return;
    }

    public LazyFragment() {
    }

    public final void setUserVisibleHint(boolean r2) {
        super/*androidx.fragment.app.Fragment*/.setUserVisibleHint(r2);
        if (getUserVisibleHint() == false) goto L9;
        this.e = true;
        if (this.f == true) goto L7;
        return;
    L7:
        if (this.g == true) goto L16;
        this.g = true;
        U90();
        return;
    L16:
        return;
    L9:
        this.e = false;
        if (this.f == true) goto L12;
        return;
    L12:
        if (this.g == false) goto L19;
        this.g = false;
        V90();
        return;
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.f = true;
        if (this.g == false) goto L5;
        return;
    L5:
        if (this.e == false) goto L9;
        this.g = true;
        U90();
        return;
    }
}
