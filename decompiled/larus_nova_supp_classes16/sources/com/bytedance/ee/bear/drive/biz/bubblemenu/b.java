package com.bytedance.ee.bear.drive.biz.bubblemenu;

import android.graphics.Rect;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends ActionMode.Callback2 {
    public final /* synthetic */ a.InterfaceActionModeCallbackC0117a a;

    public b(DriveBubbleMenuPlugin.e r1) {
        this.a = r1;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r2) {
        this.a.onDestroyActionMode(r2);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r2, MenuItem r3) {
        return this.a.onActionItemClicked(r2, r3);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r2, Menu r3) {
        return this.a.onCreateActionMode(r2, r3);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r2, Menu r3) {
        return this.a.onPrepareActionMode(r2, r3);
    }

    @Override // android.view.ActionMode.Callback2
    public final void onGetContentRect(ActionMode r2, View r3, Rect r4) {
        Intrinsics.checkNotNullParameter(r2, "mode");
        Intrinsics.checkNotNullParameter(r3, "view");
        Intrinsics.checkNotNullParameter(r4, "outRect");
        this.a.onGetContentRect(r2, r3, r4);
    }
}
