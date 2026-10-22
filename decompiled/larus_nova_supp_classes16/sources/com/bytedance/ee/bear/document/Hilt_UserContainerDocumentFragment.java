package com.bytedance.ee.bear.document;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class Hilt_UserContainerDocumentFragment extends DocumentFragment {
    public ContextWrapper s;
    public boolean t;

    public final void ma0() {
        if (this.t == true) goto L6;
        this.t = true;
        b7 r0 = (b7) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent();
        UserContainerDocumentFragment r1 = (UserContainerDocumentFragment) UnsafeCasts.unsafeCast(this);
        r0.w();
        return;
    }

    public Hilt_UserContainerDocumentFragment() {
        this.t = false;
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public Context getContext() {
        if (super.getContext() != null) goto L9;
        if (this.s != null) goto L9;
        return null;
    L9:
        if (this.s != null) goto L12;
        this.s = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        return this.s;
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DwarfViewModelFactories.getFragmentFactory(this, super.getDefaultViewModelProviderFactory(), ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent());
    }

    public final void onAttach(Activity r3) {
        super.onAttach(r3);
        ContextWrapper r0 = this.s;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.s != null) goto L12;
        this.s = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        ma0();
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r3) goto L8;
        r4 = false;
        goto L9
    }

    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super.onGetLayoutInflater(r1), this));
    }

    @Override // com.bytedance.ee.bear.document.WebViewFragment
    public void onAttach(Context r1) {
        super.onAttach(r1);
        if (this.s != null) goto L5;
        this.s = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L5:
        ma0();
    }
}
