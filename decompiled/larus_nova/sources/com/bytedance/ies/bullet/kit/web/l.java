package com.bytedance.ies.bullet.kit.web;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes19.dex */
public final class l implements ActionMode.Callback {
    public l() {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        if (r100 == null) goto L6;
        r100.setTitle(null);
        r100.setSubtitle(null);
        r100.getMenu().clear();
        return true;
    L6:
        return true;
    }
}
