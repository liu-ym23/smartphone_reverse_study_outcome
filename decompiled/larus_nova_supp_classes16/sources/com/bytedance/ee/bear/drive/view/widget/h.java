package com.bytedance.ee.bear.drive.view.widget;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class h extends ActionMode.Callback2 {
    public final /* synthetic */ ActionMode.Callback a;
    public final /* synthetic */ DriveWebView b;

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r2) {
        this.a.onDestroyActionMode(r2);
    }

    public h(DriveWebView r1, ActionMode.Callback r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r12, MenuItem r13) {
        DriveWebView r0 = this.b;
        int r1 = DriveWebView.H;
        boolean r2 = false;
        if (r0.y.getAllow() == true) goto L5;
    L7:
        boolean r3 = false;
    L8:
        if (r3 == true) goto L23;
        DriveWebView r4 = this.b;
        r4.getClass();
        if (r13 == null) goto L19;
        CharSequence r5 = r13.getTitle();
        if (r13.getItemId() != 16908321) goto L15;
    L18:
        r2 = true;
        goto L19
    L15:
        if (TextUtils.equals(r5, r4.getResources().getString(R.string.copy)) == true) goto L18;
        if (TextUtils.equals(r5, r4.getResources().getString(2131888362)) == true) goto L18;
    L19:
        if (r2 == false) goto L23;
        a55.b r14 = DriveWebView.e(this.b);
        DriveWebView r6 = this.b;
        int r7 = r6.E;
        Context r8 = r6.getContext();
        DriveWebView r9 = this.b;
        a55.a r10 = (a55.a) r14;
        r10.b(R.id.copy, false, r7, r8, r9.D, r9.y);
        r12.finish();
        return true;
    L23:
        return this.a.onActionItemClicked(r12, r13);
    L5:
        if (r0.E != 0) goto L7;
        r3 = true;
        goto L8
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
    public final void onGetContentRect(ActionMode r3, View r4, Rect r5) {
        ActionMode.Callback r0 = this.a;
        if ((r0 instanceof ActionMode.Callback2) == false) goto L5;
        ((ActionMode.Callback2) r0).onGetContentRect(r3, r4, r5);
        return;
    L5:
        super.onGetContentRect(r3, r4, r5);
    }
}
