package com.ss.android.bytedcert.video.fragment.base;

import android.content.Context;
import androidx.fragment.app.Fragment;
import tsa.a;

/* JADX INFO: loaded from: classes34.dex */
public abstract class RootFragment extends Fragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public a f407706d;

    public RootFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        super.onAttach(r100);
        a r101 = this.f407706d;
        if (r101 != null) goto L5;
    L6:
        this.f407706d = new a(r100, this);
        return;
    L5:
        if (r101.getBaseContext() != r100) goto L6;
    }
}
