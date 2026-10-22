package com.larus.business.floatchat.impl.component;

import android.view.View;
import com.larus.business.floatchat.api.AIChatInputConfig;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final /* synthetic */ class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AIChatInputConfigComponent f320364a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AIChatInputConfig f320365b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f320366c;

    public /* synthetic */ g(AIChatInputConfigComponent r100, AIChatInputConfig r101, View r102) {
        this.f320364a = r100;
        this.f320365b = r101;
        this.f320366c = r102;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AIChatInputConfigComponent r100 = this.f320364a;
        AIChatInputConfig r101 = this.f320365b;
        View r102 = this.f320366c;
        if (Intrinsics.areEqual(r100.f320161s, r101) == true) goto L5;
        FLogger.f375446a.i("AIChatInputConfigComponent", "[applyActionBar] skip stale config, enable=" + r101.f320093h);
        return;
    L5:
        View r103 = r102.findViewById(R.id.action_bar_container);
        com.larus.bmhome.instruction.g r104 = (com.larus.bmhome.instruction.g) r100.f320159q.getValue();
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("[applyActionBar] enable=");
        r106.append(r100.E2());
        r106.append(", hasInstructionAbility=");
        int r107 = 0;
        if (r104 == null) goto L8;
        boolean r108 = true;
    L9:
        r106.append(r108);
        r106.append(", containerVisibility=");
        Integer r109 = null;
        if (r103 == null) goto L12;
        Integer r110 = Integer.valueOf(r103.getVisibility());
    L13:
        r106.append(r110);
        r106.append(", containerHeight=");
        if (r103 == null) goto L16;
        r109 = Integer.valueOf(r103.getHeight());
    L16:
        r106.append(r109);
        r105.i("AIChatInputConfigComponent", r106.toString());
        if (r104 == null) goto L19;
        r104.SF();
    L25:
        if (r103 == null) goto L27;
        r103.requestLayout();
    L27:
        r102.requestLayout();
        return;
    L19:
        if (r103 == null) goto L25;
        if (r100.E2() == true) goto L24;
        r107 = 8;
    L24:
        r103.setVisibility(r107);
        goto L25
    L12:
        r110 = null;
        goto L13
    L8:
        r108 = false;
        goto L9
    }
}
