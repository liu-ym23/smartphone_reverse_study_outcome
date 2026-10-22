package com.bytedance.ee.bear.operation.view;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements Runnable {
    public final /* synthetic */ FragmentActivity a;

    public a(FragmentActivity r1) {
        this.a = r1;
    }

    public final void a() {
        Fragment r0 = Fragment.instantiate(this.a, OperationNotPermissionFragment.class.getName());
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.bytedance.ee.bear.operation.view.OperationNotPermissionFragment");
        Fragment r1 = (OperationNotPermissionFragment) r0;
        FragmentManager r2 = this.a.getSupportFragmentManager();
        if ((r1 instanceof Fragment) == false) goto L5;
        Fragment r3 = r1;
    L6:
        LandscapeRestrictionOperation r4 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "OperationNotPermissionFragment", r4);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r3, r4) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r1.show(r2, "OperationNotPermissionFragment");
        return;
    L15:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
