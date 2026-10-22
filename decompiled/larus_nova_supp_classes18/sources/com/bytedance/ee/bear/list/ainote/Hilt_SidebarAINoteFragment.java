package com.bytedance.ee.bear.list.ainote;

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
import gc5.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class Hilt_SidebarAINoteFragment extends AINoteFragment {
    public ContextWrapper q;
    public boolean r;

    public final void ca0() {
        if (this.r == true) goto L6;
        this.r = true;
        w r0 = (w) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent();
        SidebarAINoteFragment r1 = (SidebarAINoteFragment) UnsafeCasts.unsafeCast(this);
        r0.s0();
        return;
    }

    public Hilt_SidebarAINoteFragment() {
        this.r = false;
    }

    public Context getContext() {
        if (super/*com.bytedance.ee.bear.facade.common.BaseFragment*/.getContext() != null) goto L9;
        if (this.q != null) goto L9;
        return null;
    L9:
        if (this.q != null) goto L12;
        this.q = FragmentComponentManager.createContextWrapper(super/*com.bytedance.ee.bear.facade.common.BaseFragment*/.getContext(), this);
    L12:
        return this.q;
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DwarfViewModelFactories.getFragmentFactory(this, super/*androidx.fragment.app.Fragment*/.getDefaultViewModelProviderFactory(), ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent());
    }

    public final void onAttach(Activity r3) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r3);
        ContextWrapper r0 = this.q;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.q != null) goto L12;
        this.q = FragmentComponentManager.createContextWrapper(super/*com.bytedance.ee.bear.facade.common.BaseFragment*/.getContext(), this);
    L12:
        ca0();
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r3) goto L8;
        r4 = false;
        goto L9
    }

    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super/*androidx.fragment.app.Fragment*/.onGetLayoutInflater(r1), this));
    }

    public final void onAttach(Context r1) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r1);
        if (this.q != null) goto L5;
        this.q = FragmentComponentManager.createContextWrapper(super/*com.bytedance.ee.bear.facade.common.BaseFragment*/.getContext(), this);
    L5:
        ca0();
    }
}
