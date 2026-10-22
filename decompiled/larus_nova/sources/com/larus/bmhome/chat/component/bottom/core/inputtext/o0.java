package com.larus.bmhome.chat.component.bottom.core.inputtext;

import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes25.dex */
public final class o0 implements ActionMode.Callback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1<Boolean, Boolean> f299011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function0<Boolean> f299012b;

    @Override // android.view.ActionMode.Callback
    public final boolean onCreateActionMode(ActionMode r100, Menu r101) {
        return true;
    }

    @Override // android.view.ActionMode.Callback
    public final void onDestroyActionMode(ActionMode r100) {
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o0(Function1<? super Boolean, Boolean> r100, Function0<Boolean> r101) {
        this.f299011a = r100;
        this.f299012b = r101;
    }

    @Override // android.view.ActionMode.Callback
    public final boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        if (r101 == null) goto L4;
        Integer r102 = Integer.valueOf(r101.getItemId());
    L6:
        if (r102 != null) goto L9;
    L16:
        if (r102 != null) goto L19;
    L25:
        if (r102 != null) goto L28;
    L15:
        boolean r103 = false;
    L34:
        if (r103 == true) goto L36;
        return false;
    L36:
        if (r100 == null) goto L38;
        r100.finish();
    L38:
        return true;
    L28:
        if (r102.intValue() != 16908322) goto L15;
        Function0<Boolean> r104 = this.f299012b;
        if (r104 == null) goto L15;
        if (r104.invoke().booleanValue() != true) goto L15;
    L14:
        r103 = true;
        goto L34
    L19:
        if (r102.intValue() != 16908320) goto L25;
        Function1<Boolean, Boolean> r105 = this.f299011a;
        if (r105 == null) goto L15;
        if (r105.invoke(Boolean.TRUE).booleanValue() != true) goto L15;
    L9:
        if (r102.intValue() != 16908321) goto L16;
        Function1<Boolean, Boolean> r106 = this.f299011a;
        if (r106 == null) goto L15;
        if (r106.invoke(Boolean.FALSE).booleanValue() != true) goto L15;
    L4:
        r102 = null;
        goto L6
    }
}
