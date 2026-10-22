package com.bytedance.ee.bear.drive.view.widget;

import android.R;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/* JADX INFO: loaded from: classes16.dex */
public final class h extends ActionMode.Callback2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ActionMode.Callback f225976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DriveWebView f225977b;

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
        this.f225976a.onDestroyActionMode(r100);
    }

    public h(DriveWebView r100, ActionMode.Callback r101) {
        this.f225977b = r100;
        this.f225976a = r101;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r110, MenuItem r111) {
        DriveWebView r100 = this.f225977b;
        int r101 = DriveWebView.H;
        boolean r102 = false;
        if (r100.f225925y.getAllow() == true) goto L5;
    L7:
        boolean r103 = false;
    L8:
        if (r103 == true) goto L23;
        DriveWebView r104 = this.f225977b;
        r104.getClass();
        if (r111 == null) goto L19;
        CharSequence r105 = r111.getTitle();
        if (r111.getItemId() != 16908321) goto L15;
    L18:
        r102 = true;
        goto L19
    L15:
        if (TextUtils.equals(r105, r104.getResources().getString(R.string.copy)) == true) goto L18;
        if (TextUtils.equals(r105, r104.getResources().getString(com.larus.nova.R.string.Drive_Drive_Action_Copy)) == true) goto L18;
    L19:
        if (r102 == false) goto L23;
        a55.b r112 = DriveWebView.e(this.f225977b);
        DriveWebView r106 = this.f225977b;
        int r107 = r106.E;
        Context r108 = r106.getContext();
        DriveWebView r109 = this.f225977b;
        a55.a r113 = (a55.a) r112;
        r113.b(R.id.copy, false, r107, r108, r109.D, r109.f225925y);
        r110.finish();
        return true;
    L23:
        return this.f225976a.onActionItemClicked(r110, r111);
    L5:
        if (r100.E != 0) goto L7;
        r103 = true;
        goto L8
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        return this.f225976a.onCreateActionMode(r100, r101);
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        return this.f225976a.onPrepareActionMode(r100, r101);
    }

    @Override // android.view.ActionMode.Callback2
    public final void onGetContentRect(ActionMode r100, View r101, Rect r102) {
        ActionMode.Callback r103 = this.f225976a;
        if ((r103 instanceof ActionMode.Callback2) == false) goto L5;
        ((ActionMode.Callback2) r103).onGetContentRect(r100, r101, r102);
        return;
    L5:
        super.onGetContentRect(r100, r101, r102);
    }
}
