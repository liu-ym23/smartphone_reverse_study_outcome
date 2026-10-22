package com.larus.uaigc.createpage.component.instruction;

import android.app.Activity;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.larus.common.apphost.AppHost;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.uaigc.applet.IAICreationAppletHostService;
import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class d extends vp8.g {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final BaseContentWidget f371791h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final String f371792i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final String f371793j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public com.larus.bmhome.instruction.helper.f f371794k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.z0 f371795l;

    @Override // vp8.g
    public final void d() {
        com.larus.bmhome.instruction.helper.f r100 = IAIChatUgcAIGCService.f365905a.H0(this.f556664g);
        this.f371794k = r100;
        if (r100 == null) goto L6;
        r100.b(new b(this));
        return;
    }

    @Override // vp8.g
    public final void p() {
        com.larus.bmhome.instruction.helper.f r100 = this.f371794k;
        if (r100 == null) goto L6;
        r100.onDestroy();
        return;
    }

    public final boolean v() {
        int r100 = com.larus.uaigc.applet.a.f370285a;
        FragmentActivity r101 = s1a.a.getActivity(this.f371791h);
        if (IAICreationAppletHostService.f370273a.s(r101) == true) goto L5;
        return false;
    L5:
        ny9.s r102 = (ny9.s) s1a.d.a(this.f371791h).a(ny9.s.class);
        if (r102 == null) goto L8;
        Bundle r103 = r102.f521269a;
    L10:
        if (cy9.a.f465949a.c(r103) == null) goto L13;
        return true;
    L13:
        return false;
    L8:
        r103 = null;
        goto L10
    }

    @Override // vp8.g
    public final boolean f(final com.larus.bmhome.actionbar.model.z0 r100) {
        if (r100 == null) goto L12;
        com.larus.bmhome.actionbar.model.r r101 = r100.f295621q;
        if (r101 == null) goto L12;
        Integer r102 = r101.f295408a;
        if (r102 == null) goto L12;
        if (r102.intValue() != 16) goto L12;
        boolean r103 = true;
    L13:
        if (r103 == true) goto L25;
        if (r100 == null) goto L23;
        com.larus.bmhome.actionbar.model.r r104 = r100.f295621q;
        if (r104 == null) goto L23;
        Integer r105 = r104.f295408a;
        if (r105 == null) goto L23;
        if (r105.intValue() != 24) goto L23;
        boolean r106 = true;
    L24:
        if (r106 == true) goto L25;
    L32:
        return false;
    L23:
        r106 = false;
    L25:
        Activity r107 = AppHost.f326268a.a().getCurrentActivity();
        if ((r107 instanceof FragmentActivity) == false) goto L28;
        final FragmentActivity r108 = (FragmentActivity) r107;
    L29:
        if (r108 == null) goto L32;
        com.obric.assistant.spi.keyguard.a.b(false, new a(this, r108, r100), 3);
        return true;
    L28:
        r108 = null;
    L12:
        r103 = false;
        goto L13
    }

    public d(BaseContentWidget r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "component");
        super(r100);
        this.f371791h = r100;
        this.f371792i = r101;
        this.f371793j = r102;
    }
}
