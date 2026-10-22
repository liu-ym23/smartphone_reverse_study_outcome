package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.pushstream.IPushStreamService;
import com.bytedance.android.live.pushstream.d;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.ktvimpl.base.c;
import com.bytedance.android.livesdk.ktvimpl.base.tuningpanel.util.KSongTuningPanelHelperKt;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.sharedpref.e;
import com.bytedance.android.livesdk.sharedpref.f;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.n;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import oe2.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements b {
    public String a;
    public String b;
    public d c;
    public final String d;
    public final be2.a e;

    @Override // oe2.b
    public final int i() {
        return 5;
    }

    @Override // oe2.b
    public final boolean j() {
        return true;
    }

    @Override // oe2.b
    public final boolean l() {
        return true;
    }

    @Override // oe2.b
    public final String c() {
        return ke2.a.g(this.d);
    }

    @Override // oe2.b
    public final Boolean e() {
        KtvComponentContext r0 = KtvComponentContext.Companion.getContext();
        if (r0 == null) goto L11;
        n<KtvComponentUIContext> r1 = r0.getKtvComponentUIContext();
        if (r1 == null) goto L11;
        KtvComponentUIContext r2 = (KtvComponentUIContext) r1.getValue();
        if (r2 == null) goto L11;
        MutableLiveData<Boolean> r3 = r2.getScoreOpen();
        if (r3 == null) goto L11;
        return (Boolean) r3.getValue();
    L11:
        return null;
    }

    @Override // oe2.b
    public final int k() {
        int r0 = k.n(IInteractService.class).getCurrentScene();
        KtvComponentContext r1 = KtvComponentContext.Companion.getContext();
        if (r1 == null) goto L9;
        n<Boolean> r2 = r1.isAudienceEnableSing();
        if (r2 == null) goto L9;
        Boolean r3 = (Boolean) r2.getValue();
        if (r3 == null) goto L9;
        boolean r4 = r3.booleanValue();
    L10:
        if (r4 == true) goto L12;
        return 0;
    L12:
        if (r0 != 8) goto L14;
    L18:
        return 3;
    L14:
        if (r0 == 12) goto L18;
        if (r0 == 16) goto L18;
        return 0;
    L9:
        r4 = false;
        goto L10
    }

    @Override // oe2.b
    public final boolean m() {
        if (k.n(IInteractService.class).getCurrentScene() == 0) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // oe2.b
    public final int b() {
        com.bytedance.android.live.ktv.common.tuningpanel.ability.a r0 = KSongTuningPanelHelperKt.d();
        if (r0 == null) goto L5;
        boolean r1 = r0.R();
    L6:
        KtvComponentContext r2 = KtvComponentContext.Companion.getContext();
        if (r2 == null) goto L16;
        n<KtvComponentUIContext> r3 = r2.getKtvComponentUIContext();
        if (r3 == null) goto L16;
        KtvComponentUIContext r4 = (KtvComponentUIContext) r3.getValue();
        if (r4 == null) goto L16;
        MutableLiveData<Boolean> r5 = r4.getScoreOpen();
        if (r5 == null) goto L16;
        Boolean r6 = (Boolean) r5.getValue();
        if (r6 == null) goto L16;
    L17:
        boolean r7 = r6.booleanValue();
        if (r1 == true) goto L23;
        if (r7 == true) goto L24;
        return 1;
    L24:
        return 0;
    L23:
        return 0;
    L16:
        r6 = Boolean.FALSE;
        goto L17
    L5:
        r1 = false;
        goto L6
    }

    @Override // oe2.b
    public final int d() {
        return c.a();
    }

    @Override // oe2.b
    public final d g() {
        if (KtvUtilsKt.v() == true) goto L12;
        o r0 = o3.f();
        if (r0 == null) goto L10;
        j r1 = r0.getLiveStream();
        if (r1 == null) goto L10;
        return (d) r1.getValue();
    L10:
        return null;
    L12:
        return k.n(IPushStreamService.class).getPushLiveStream();
    }

    @Override // oe2.b
    public final String a() {
        return this.b;
    }

    @Override // oe2.b
    public final String getEnterFrom() {
        return this.a;
    }

    @Override // oe2.b
    public final void f(boolean r2) {
        if (r2 == false) goto L4;
        int r3 = 1;
    L6:
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L8;
        e r0 = com.bytedance.android.livesdk.sharedpref.c.F;
        Integer r4 = Integer.valueOf(r3);
        r0.getClass();
        f.d(r0, r4);
        return;
    L8:
        e r1 = com.bytedance.android.livesdk.sharedpref.c.G;
        Integer r5 = Integer.valueOf(r3);
        r1.getClass();
        f.d(r1, r5);
        return;
    L4:
        r3 = 2;
        goto L6
    }

    @Override // oe2.b
    public final <T extends dn0.b> T getScopeServiceOrNullInMultiLinkRoom(Class<T> r2) {
        Intrinsics.checkNotNullParameter(r2, "serviceCls");
        be2.a r0 = this.e;
        if (r0 != null) goto L7;
        return null;
    L7:
        return (T) r0.getScopeServiceOrNullInMultiLinkRoom(r2);
    }

    @Override // oe2.b
    public final d h(boolean r1) {
        if (r1 == true) goto L11;
        IInteractService r2 = k.f(IInteractService.class);
        if (r2 == null) goto L9;
        rj0.d r3 = r2.getCommonService();
        if (r3 == null) goto L9;
        return r3.getLiveStream();
    L9:
        return null;
    L11:
        return g();
    }

    public a(String r1, be2.a r2) {
        this.d = r1;
        this.e = r2;
    }
}
