package com.bytedance.ies.bullet.kit.web;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes19.dex */
public final class k implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SSWebView.a.InterfaceC3530a f247068a;

    public k(SSWebView.a.b r100) {
        this.f247068a = r100;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
        this.f247068a.onDestroyActionMode(r100);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        return this.f247068a.onActionItemClicked(r100, r101);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        return this.f247068a.onCreateActionMode(r100, r101);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        return this.f247068a.onPrepareActionMode(r100, r101);
    }
}
