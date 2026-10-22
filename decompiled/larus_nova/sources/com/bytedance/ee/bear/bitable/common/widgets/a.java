package com.bytedance.ee.bear.bitable.common.widgets;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<SimpleItemModel> f209885a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final gv4.a f209886b;

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
    }

    public a(List<SimpleItemModel> r100, gv4.a r101) {
        Intrinsics.checkNotNullParameter(r100, "simpleItems");
        this.f209885a = r100;
        this.f209886b = r101;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        if (r101 == null) goto L15;
        int r102 = r101.getItemId();
        boolean r103 = false;
        if (r102 >= 0) goto L7;
    L9:
        if (r103 == false) goto L15;
        ActionPayload r104 = ((SimpleItemModel) ListProtector.get(this.f209885a, r102)).getClickActionPayload();
        if (r104 == null) goto L15;
        gv4.a r105 = this.f209886b;
        if (r105 == null) goto L15;
        r105.a(r104);
        goto L15
    L7:
        if (r102 >= this.f209885a.size()) goto L9;
        r103 = true;
    L15:
        if (r100 == null) goto L17;
        r100.finish();
    L17:
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        if (r101 == null) goto L6;
        r101.clear();
        return true;
    L6:
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        int r102 = this.f209885a.size();
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L7;
        if (r101 == null) goto L6;
        r101.add(769711401, r103, r103, ((SimpleItemModel) ListProtector.get(this.f209885a, r103)).getText());
    L6:
        r103 = r103 + 1;
        goto L3
    L7:
        return true;
    }
}
