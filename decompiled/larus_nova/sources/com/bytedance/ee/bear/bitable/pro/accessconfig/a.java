package com.bytedance.ee.bear.bitable.pro.accessconfig;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableDefaultMemberAdapter f215118a;

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        return false;
    }

    public a(BitableDefaultMemberAdapter r100) {
        this.f215118a = r100;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        BitableDefaultMemberAdapter r102 = this.f215118a;
        ActionMode r103 = r102.f215111a;
        if (r103 == null) goto L5;
        r103.finish();
    L5:
        r102.f215111a = null;
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        if (r101 == null) goto L6;
        r101.add(769711401, 0, 0, R.string.Bitable_AdvancedPermissionsInherit_NotAssignedRoles_OtherWaysToGainRoles_NewCollaboratorsViaLink_Text);
        return true;
    L6:
        return true;
    }
}
