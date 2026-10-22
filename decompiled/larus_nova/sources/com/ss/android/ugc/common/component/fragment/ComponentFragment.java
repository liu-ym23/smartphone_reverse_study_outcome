package com.ss.android.ugc.common.component.fragment;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import bhc.a;
import com.bytedance.ies.uikit.base.AbsFragment;

/* JADX INFO: loaded from: classes40.dex */
public abstract class ComponentFragment extends AbsFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public SparseArray<a> f454362d;

    public abstract SparseArray<a> S90();

    @Override // com.bytedance.ies.uikit.base.AbsFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        if (this.f454362d == null) goto L8;
        int r100 = 0;
    L6:
        if (r100 >= this.f454362d.size()) goto L8;
        this.f454362d.valueAt(r100).onDestroy();
        r100 = r100 + 1;
    L8:
        super.onDestroy();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDetach() {
        if (this.f454362d == null) goto L9;
        int r100 = 0;
    L6:
        if (r100 >= this.f454362d.size()) goto L8;
        this.f454362d.valueAt(r100).onDetach();
        r100 = r100 + 1;
        goto L6
    L8:
        this.f454362d.clear();
        this.f454362d = null;
    L9:
        super.onDetach();
    }

    @Override // com.bytedance.ies.uikit.base.AbsFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        super.onPause();
        if (this.f454362d == null) goto L8;
        int r100 = 0;
    L6:
        if (r100 >= this.f454362d.size()) goto L10;
        this.f454362d.valueAt(r100).onPause();
        r100 = r100 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.ies.uikit.base.AbsFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.f454362d == null) goto L8;
        int r100 = 0;
    L6:
        if (r100 >= this.f454362d.size()) goto L10;
        this.f454362d.valueAt(r100).onResume();
        r100 = r100 + 1;
        goto L6
    L10:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (this.f454362d == null) goto L8;
        int r100 = 0;
    L6:
        if (r100 >= this.f454362d.size()) goto L10;
        this.f454362d.valueAt(r100).onStart();
        r100 = r100 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.ies.uikit.base.AbsFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        super.onStop();
        if (this.f454362d == null) goto L8;
        int r100 = 0;
    L6:
        if (r100 >= this.f454362d.size()) goto L10;
        this.f454362d.valueAt(r100).onStop();
        r100 = r100 + 1;
        goto L6
    L10:
        return;
    }

    public ComponentFragment() {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Activity r100) {
        this.f454362d = S90();
        int r101 = 0;
    L4:
        if (r101 >= this.f454362d.size()) goto L6;
        this.f454362d.valueAt(r101).onAttach();
        r101 = r101 + 1;
        goto L4
    L6:
        super.onAttach(r100);
    }

    @Override // androidx.fragment.app.Fragment, android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        if (this.f454362d == null) goto L8;
        int r101 = 0;
    L6:
        if (r101 >= this.f454362d.size()) goto L10;
        this.f454362d.valueAt(r101).b();
        r101 = r101 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.ies.uikit.base.AbsFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f454362d == null) goto L8;
        int r101 = 0;
    L6:
        if (r101 >= this.f454362d.size()) goto L10;
        this.f454362d.valueAt(r101).onCreate();
        r101 = r101 + 1;
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.ies.uikit.base.AbsFragment, androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle r100) {
        super.onSaveInstanceState(r100);
        if (this.f454362d == null) goto L8;
        int r101 = 0;
    L6:
        if (r101 >= this.f454362d.size()) goto L10;
        this.f454362d.valueAt(r101).onSaveInstanceState();
        r101 = r101 + 1;
        goto L6
    L10:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewStateRestored(Bundle r100) {
        super.onViewStateRestored(r100);
        if (this.f454362d == null) goto L8;
        int r101 = 0;
    L6:
        if (r101 >= this.f454362d.size()) goto L10;
        this.f454362d.valueAt(r101).c();
        r101 = r101 + 1;
        goto L6
    L10:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return super.onCreateView(r100, r101, r102);
    }
}
