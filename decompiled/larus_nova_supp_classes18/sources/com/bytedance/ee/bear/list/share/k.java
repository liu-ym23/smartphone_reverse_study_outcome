package com.bytedance.ee.bear.list.share;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class k extends BaseFragment {
    public ContextWrapper e;
    public boolean f;

    public final void U90() {
        if (this.f == true) goto L6;
        this.f = true;
        w1 r0 = (w1) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent();
        ShareDocumentFragment r1 = (ShareDocumentFragment) UnsafeCasts.unsafeCast(this);
        r0.d1();
        return;
    }

    public k() {
        this.f = false;
    }

    public Context getContext() {
        if (super.getContext() != null) goto L9;
        if (this.e != null) goto L9;
        return null;
    L9:
        if (this.e != null) goto L12;
        this.e = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        return this.e;
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DwarfViewModelFactories.getFragmentFactory(this, super/*androidx.fragment.app.Fragment*/.getDefaultViewModelProviderFactory(), ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent());
    }

    public final void onAttach(Activity r3) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r3);
        ContextWrapper r0 = this.e;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.e != null) goto L12;
        this.e = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        U90();
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
        if (this.e != null) goto L5;
        this.e = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L5:
        U90();
    }
}
