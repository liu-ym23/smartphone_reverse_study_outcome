package com.bytedance.ee.bear.bitable.card.view.cell.link;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class o0 implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f207768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f207769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ LinkRecordAdapter f207770c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f207771d;

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        this.f207769b.setVisibility(8);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        LinkRecordAdapter r102 = this.f207770c;
        ActionMode r103 = r102.f207725h;
        if (r103 == null) goto L5;
        r103.finish();
    L5:
        r102.f207725h = null;
        LinkRecordAdapter.b r104 = this.f207770c.f207724g;
        if (r104 == null) goto L8;
        String r105 = this.f207771d;
        u r106 = (u) r104;
        LinkCellViewHolder r107 = r106.f207810a;
        gp4.h r108 = r106.f207811b;
        int r109 = LinkCellViewHolder.f207716k0;
        r107.getClass();
        r107.X3(new String[]{r105}, "delete", r107.Q);
        r108.q0().v("delete", r107.P.f478257d);
    L8:
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        Intrinsics.checkNotNullParameter(r101, TplType.MENU);
        eu5.h.a(this.f207768a.getContext(), 10, 50);
        this.f207769b.setVisibility(0);
        r101.add(769711401, 0, 0, R.string.Doc_Facade_Delete);
        return true;
    }

    public o0(View r100, View r101, LinkRecordAdapter r102, String r103) {
        this.f207768a = r100;
        this.f207769b = r101;
        this.f207770c = r102;
        this.f207771d = r103;
    }
}
