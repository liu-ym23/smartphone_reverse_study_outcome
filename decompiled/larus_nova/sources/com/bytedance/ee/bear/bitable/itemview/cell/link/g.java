package com.bytedance.ee.bear.bitable.itemview.cell.link;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import eu5.h;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkTagAllAdapter.ViewHolder f213946a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f213947b;

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        View r101 = this.f213946a.f213908a;
        if (r101 == null) goto L6;
        r101.setVisibility(8);
        return;
    }

    public g(LinkTagAllAdapter.ViewHolder r100, Function0<Unit> r101) {
        this.f213946a = r100;
        this.f213947b = r101;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        this.f213947b.invoke();
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        h.a(this.f213946a.itemView.getContext(), 10, 50);
        View r102 = this.f213946a.f213908a;
        if (r102 == null) goto L5;
        r102.setVisibility(0);
    L5:
        r101.add(769711401, 0, 0, R.string.Doc_Facade_Delete);
        return true;
    }
}
