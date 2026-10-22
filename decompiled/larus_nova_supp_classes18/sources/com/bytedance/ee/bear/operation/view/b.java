package com.bytedance.ee.bear.operation.view;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements Runnable {
    public final /* synthetic */ String a;
    public final /* synthetic */ FragmentActivity b;

    public b(String r1, FragmentActivity r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Bundle r0 = new Bundle();
        r0.putString("SUITE_TYPE", this.a);
        Fragment r1 = Fragment.instantiate(this.b, OperationSuiteDisableFragment.class.getName(), r0);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.operation.view.OperationSuiteDisableFragment");
        Fragment r2 = (OperationSuiteDisableFragment) r1;
        FragmentManager r3 = this.b.getSupportFragmentManager();
        if ((r2 instanceof Fragment) == false) goto L5;
        Fragment r4 = r2;
    L6:
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "OperationSuiteDisableFragment", r5);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r4, r5) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, "OperationSuiteDisableFragment");
        return;
    L15:
        return;
    L5:
        r4 = null;
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
