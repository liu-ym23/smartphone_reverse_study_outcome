package jd5;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import android.view.LayoutInflater;
import androidx.lifecycle.ViewModelProvider;
import com.bytedance.ee.bear.list.homepage.BaseHomeFragment;
import com.bytedance.ee.bear.list.mine.HomeMySpaceFragment;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.internal.lifecycle.DwarfViewModelFactories;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.internal.Preconditions;
import dagger.hilt.internal.UnsafeCasts;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class f extends BaseHomeFragment {
    public ContextWrapper v;
    public boolean w;

    public final void fa0() {
        if (this.w == true) goto L6;
        this.w = true;
        i r0 = (i) ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent();
        HomeMySpaceFragment r1 = (HomeMySpaceFragment) UnsafeCasts.unsafeCast(this);
        r0.p0();
        return;
    }

    public f() {
        this.w = false;
    }

    public Context getContext() {
        if (super/*com.bytedance.ee.bear.facade.common.BaseFragment*/.getContext() != null) goto L9;
        if (this.v != null) goto L9;
        return null;
    L9:
        if (this.v != null) goto L12;
        this.v = FragmentComponentManager.createContextWrapper(super/*com.bytedance.ee.bear.facade.common.BaseFragment*/.getContext(), this);
    L12:
        return this.v;
    }

    public final ViewModelProvider.Factory getDefaultViewModelProviderFactory() {
        return DwarfViewModelFactories.getFragmentFactory(this, super/*androidx.fragment.app.Fragment*/.getDefaultViewModelProviderFactory(), ((DwarfComponentProvider) UnsafeCasts.unsafeCast(this)).provideComponent());
    }

    public final void onAttach(Activity r3) {
        super/*androidx.fragment.app.Fragment*/.onAttach(r3);
        ContextWrapper r0 = this.v;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        Preconditions.checkState(r4, "onAttach called multiple times with different Context! Hilt Fragments should not be retained.", new Object[0]);
        if (this.v != null) goto L12;
        this.v = FragmentComponentManager.createContextWrapper(super/*com.bytedance.ee.bear.facade.common.BaseFragment*/.getContext(), this);
    L12:
        fa0();
        return;
    L5:
        if (FragmentComponentManager.findActivity(r0) == r3) goto L8;
        r4 = false;
        goto L9
    }

    public final LayoutInflater onGetLayoutInflater(Bundle r1) {
        return LayoutInflater.from(FragmentComponentManager.createContextWrapper(super/*androidx.fragment.app.Fragment*/.onGetLayoutInflater(r1), this));
    }

    @Override // com.bytedance.ee.bear.list.homepage.BaseHomeFragment
    public final void onAttach(Context r1) {
        super.onAttach(r1);
        if (this.v != null) goto L5;
        this.v = FragmentComponentManager.createContextWrapper(super/*com.bytedance.ee.bear.facade.common.BaseFragment*/.getContext(), this);
    L5:
        fa0();
    }
}
