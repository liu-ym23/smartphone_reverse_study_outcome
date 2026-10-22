package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a implements ActionMode.Callback {
    public final /* synthetic */ BitableDefaultMemberAdapter a;

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r1) {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r1, Menu r2) {
        return false;
    }

    public a(BitableDefaultMemberAdapter r1) {
        this.a = r1;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r1, MenuItem r2) {
        BitableDefaultMemberAdapter r3 = this.a;
        ActionMode r4 = r3.a;
        if (r4 == null) goto L5;
        r4.finish();
    L5:
        r3.a = null;
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r3, Menu r4) {
        if (r4 == null) goto L6;
        r4.add(769711401, 0, 0, 2131886217);
        return true;
    L6:
        return true;
    }
}
