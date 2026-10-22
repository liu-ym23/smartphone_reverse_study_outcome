package com.bytedance.ies.bullet.kit.web;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes19.dex */
public final class j extends ActionMode.Callback2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SSWebView.a.InterfaceC3530a f247040a;

    public j(SSWebView.a.b r100) {
        this.f247040a = r100;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
        this.f247040a.onDestroyActionMode(r100);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        return this.f247040a.onActionItemClicked(r100, r101);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        return this.f247040a.onCreateActionMode(r100, r101);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        return this.f247040a.onPrepareActionMode(r100, r101);
    }

    @Override // android.view.ActionMode.Callback2
    public final void onGetContentRect(ActionMode r100, View r101, Rect r102) {
        if (this.f247040a.onGetContentRect(r100, r101, r102) == true) goto L6;
        super.onGetContentRect(r100, r101, r102);
        return;
    }
}
