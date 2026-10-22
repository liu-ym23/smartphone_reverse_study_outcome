package com.bytedance.ee.bear.document.ai.citation;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class i implements Runnable {
    public final /* synthetic */ FragmentActivity a;
    public final /* synthetic */ DocAICitationPlugin b;
    public final /* synthetic */ ShowCitationData c;

    public i(FragmentActivity r1, DocAICitationPlugin r2, ShowCitationData r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        FragmentManager r0 = this.a.getSupportFragmentManager();
        DocAICitationFragment r2 = r0.findFragmentByTag("CitationFragment");
        if ((r2 instanceof DocAICitationFragment) == false) goto L5;
        DocAICitationFragment r3 = r2;
    L7:
        if (r3 != null) goto L11;
        int r4 = DocAICitationFragment.r;
        FragmentActivity r5 = this.b.getHost().getActivity();
        Fragment r6 = this.b.getHost().getHostFragment();
        ShowCitationData r7 = this.c;
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r7, "data");
        DocAICitationFragment r8 = Fragment.instantiate(r5, DocAICitationFragment.class.getName());
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.bytedance.ee.bear.document.ai.citation.DocAICitationFragment");
        r3 = r8;
        Bundle r9 = new Bundle();
        r9.putParcelable("extra_data", r7);
        r3.setArguments(r9);
        if (ForsetiHelper.s(r6) == false) goto L15;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.f.e(r3, r6, null, false, 0, false, 62);
    L15:
        if (r3.isAdded() == false) goto L17;
        return;
    L17:
        if (r3.isVisible() == false) goto L19;
        return;
    L19:
        if (r0.isDestroyed() == false) goto L21;
        return;
    L21:
        if (ForsetiHelper.s(this.b.getHost().getHostFragment()) == true) goto L34;
        LandscapeRestrictionOperation r10 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "CitationFragment", r10);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r3, r10) == true) goto L35;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
    L26:
        r3.show(r0, "CitationFragment");
        return;
    L35:
        return;
    L34:
        return;
    L11:
        ShowCitationData r11 = this.c;
        Intrinsics.checkNotNullParameter(r11, "data");
        r3.q = r11;
        DocAICitationViewModel r12 = r3.k;
        if (r12 == null) goto L15;
        r12.updateData(r11);
        goto L15
    L5:
        r3 = null;
        goto L7
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
