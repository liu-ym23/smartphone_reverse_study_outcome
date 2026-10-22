package com.bytedance.ee.bear.quoto;

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
public final class z implements Runnable {
    public final /* synthetic */ long a;
    public final /* synthetic */ SingleFileQuotaConfig b;
    public final /* synthetic */ FragmentActivity c;

    public z(long r1, SingleFileQuotaConfig r3, FragmentActivity r4) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
    }

    public final void a() {
        Bundle r0 = new Bundle();
        r0.putLong("key_file_size", this.a);
        r0.putParcelable("key_quota_config", this.b);
        Fragment r1 = Fragment.instantiate(this.c, SingleFileExceedQuotaFragment.class.getName(), r0);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.ee.bear.quoto.SingleFileExceedQuotaFragment");
        Fragment r2 = (SingleFileExceedQuotaFragment) r1;
        FragmentManager r3 = this.c.getSupportFragmentManager();
        if ((r2 instanceof Fragment) == false) goto L5;
        Fragment r4 = r2;
    L6:
        LandscapeRestrictionOperation r5 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "SingleFileExceedQuotaFragment", r5);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r4, r5) == true) goto L15;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        r2.show(r3, "SingleFileExceedQuotaFragment");
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
