package com.bytedance.ee.bear.drive.biz.bubblemenu;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class b extends ActionMode.Callback2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a.InterfaceActionModeCallbackC3173a f222604a;

    public b(DriveBubbleMenuPlugin.e r100) {
        this.f222604a = r100;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
        this.f222604a.onDestroyActionMode(r100);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        return this.f222604a.onActionItemClicked(r100, r101);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        return this.f222604a.onCreateActionMode(r100, r101);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        return this.f222604a.onPrepareActionMode(r100, r101);
    }

    @Override // android.view.ActionMode.Callback2
    public final void onGetContentRect(ActionMode r100, View r101, Rect r102) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r102, "outRect");
        this.f222604a.onGetContentRect(r100, r101, r102);
    }
}
