package com.bytedance.ee.bear.document.synced.block.references.doc;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class Hilt_SyncedSourceDocReferencesFragment extends Fragment {
    public ContextWrapper d;
    public boolean e;

    public final void S90() {
        if (this.e == true) goto L6;
        this.e = true;
        ((z35.a) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent()).P0((SyncedSourceDocReferencesFragment) UnsafeCasts.unsafeCast(this));
        return;
    }

    public Hilt_SyncedSourceDocReferencesFragment() {
        this.e = false;
    }

    public Context getContext() {
        if (super.getContext() != null) goto L9;
        if (this.d != null) goto L9;
        return null;
    L9:
        if (this.d != null) goto L12;
        this.d = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        return this.d;
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DwarfViewModelFactories.getFragmentFactory(this, super.getDefaultViewModelProviderFactory(), ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent());
    }

    public final void onAttach(Activity r3) {
        super.onAttach(r3);
        ContextWrapper r0 = this.d;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.d != null) goto L12;
        this.d = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L12:
        S90();
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r3) goto L8;
        r4 = false;
        goto L9
    }

    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super.onGetLayoutInflater(r1), this));
    }

    public final void onAttach(Context r1) {
        super.onAttach(r1);
        if (this.d != null) goto L5;
        this.d = FragmentComponentManager.createContextWrapper(super.getContext(), this);
    L5:
        S90();
    }
}
