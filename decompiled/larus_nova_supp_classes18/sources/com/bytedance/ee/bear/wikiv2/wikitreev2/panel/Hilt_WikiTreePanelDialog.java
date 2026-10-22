package com.bytedance.ee.bear.wikiv2.wikitreev2.panel;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.bizwidget.dialogfragment.FullBottomSheetFragment;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;
import uq5.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class Hilt_WikiTreePanelDialog extends FullBottomSheetFragment {
    public ContextWrapper j;
    public boolean k;

    public final void aa0() {
        if (this.k == true) goto L6;
        this.k = true;
        ((g) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent()).X((WikiTreePanelDialog) UnsafeCasts.unsafeCast(this));
        return;
    }

    public Hilt_WikiTreePanelDialog() {
        this.k = false;
    }

    public Context getContext() {
        if (super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment*/.getContext() != null) goto L9;
        if (this.j != null) goto L9;
        return null;
    L9:
        if (this.j != null) goto L12;
        this.j = FragmentComponentManager.createContextWrapper(super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment*/.getContext(), this);
    L12:
        return this.j;
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DwarfViewModelFactories.getFragmentFactory(this, super/*androidx.fragment.app.Fragment*/.getDefaultViewModelProviderFactory(), ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent());
    }

    public final void onAttach(Activity r3) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r3);
        ContextWrapper r0 = this.j;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.j != null) goto L12;
        this.j = FragmentComponentManager.createContextWrapper(super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment*/.getContext(), this);
    L12:
        aa0();
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r3) goto L8;
        r4 = false;
        goto L9
    }

    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super/*androidx.fragment.app.DialogFragment*/.onGetLayoutInflater(r1), this));
    }

    public final void onAttach(Context r1) {
        super/*androidx.fragment.app.DialogFragment*/.onAttach(r1);
        if (this.j != null) goto L5;
        this.j = FragmentComponentManager.createContextWrapper(super/*com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsSheetDialogFragment*/.getContext(), this);
    L5:
        aa0();
    }
}
