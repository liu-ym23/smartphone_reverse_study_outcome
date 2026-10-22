package com.larus.dora.impl.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.impl.settings.d1;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public class DoraLinkReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f332146a = 0;

    public DoraLinkReceiver() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(final Context r100, final Intent r101) {
        g49.d.d("DoraLinkReceiver", "onReceive " + r101.getAction());
        Function0 r102 = new j0(this, r100, r101);
        DoraSetting r103 = DoraSetting.f338023a;
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (DoraSetting.f338024b == false) goto L5;
        r102.invoke();
        return;
    L5:
        new d1(r102).start();
    }
}
