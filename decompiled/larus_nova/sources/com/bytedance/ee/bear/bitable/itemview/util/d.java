package com.bytedance.ee.bear.bitable.itemview.util;

import android.R;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements ActionMode.Callback {
    public d() {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        if (r101 == null) goto L4;
        r101.removeItem(R.id.cut);
    L4:
        if (r101 == null) goto L8;
        r101.removeItem(R.id.paste);
        return true;
    L8:
        return true;
    }
}
