package com.bytedance.ee.bear.list.recent;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import com.bytedance.ee.bear.list.folder.MyRootFolderFragment;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class Hilt_SubordinateRecentDocumentFragment extends MyRootFolderFragment {
    public ContextWrapper l;
    public boolean m;

    @Override // uc5.y1
    public final void U90() {
        if (this.m == true) goto L6;
        this.m = true;
        f1 r0 = (f1) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent();
        SubordinateRecentDocumentFragment r1 = (SubordinateRecentDocumentFragment) UnsafeCasts.unsafeCast(this);
        r0.M();
        return;
    }

    public Hilt_SubordinateRecentDocumentFragment() {
        this.m = false;
    }

    @Override // com.bytedance.ee.bear.list.folder.MyRootFolderFragment, uc5.y1
    public Context getContext() {
        if (super.getContext() != null) goto L9;
        if (this.l != null) goto L9;
        return null;
    L9:
        if (this.l != null) goto L12;
        this.l = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        return this.l;
    }

    @Override // uc5.y1
    public final void onAttach(Activity r3) {
        super.onAttach(r3);
        ContextWrapper r0 = this.l;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.l != null) goto L12;
        this.l = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        U90();
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r3) goto L8;
        r4 = false;
        goto L9
    }

    @Override // uc5.y1
    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super.onGetLayoutInflater(r1), this));
    }

    @Override // uc5.y1
    public final void onAttach(Context r1) {
        super.onAttach(r1);
        if (this.l != null) goto L5;
        this.l = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L5:
        U90();
    }
}
