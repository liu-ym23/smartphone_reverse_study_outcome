package com.larus.larkfeed.impl.voice;

import android.view.View;
import cbc.d;
import dbc.f;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes30.dex */
public final /* synthetic */ class c implements fbc.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FlowVoiceTouch f355592a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f355593b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Function0 f355594c;

    public /* synthetic */ c(FlowVoiceTouch r100, d r101, Function0 r102) {
        this.f355592a = r100;
        this.f355593b = r101;
        this.f355594c = r102;
    }

    public final void a(View r110, fbc.a.AbstractC5878a r111) {
        FlowVoiceTouch r100 = this.f355592a;
        d r101 = this.f355593b;
        Function0 r102 = this.f355594c;
        Intrinsics.checkNotNullParameter(r110, "source");
        Intrinsics.checkNotNullParameter(r111, "touchEvent");
        r100.getClass();
        if ((r111 instanceof fbc.a.AbstractC5878a.b) == false) goto L5;
        return;
    L5:
        if ((r111 instanceof fbc.a.AbstractC5878a.C5879a) == false) goto L11;
        r100.d();
        f r112 = r100.f355563a;
        if (r112 != null) goto L9;
        r101.cancel();
        return;
    L9:
        r112.j0(new rac.a(((fbc.a.AbstractC5878a.C5879a) r111).f476322a));
        return;
    L11:
        if ((r111 instanceof fbc.a.AbstractC5878a.c) == false) goto L17;
        int r103 = r100.f355572j.addAndGet(1);
        Job r113 = r100.f355571i;
        if (r113 == null) goto L15;
        Job.DefaultImpls.cancel$default(r113, null, 1, null);
    L15:
        r100.f355567e = FlowVoiceTouch.GesturePhase.Preparing;
        r100.f355571i = BuildersKt.launch$default(r100.f355569g, null, null, new FlowVoiceTouch$handleTouchEvent$1(r101, r103, r100, r110, null), 3, null);
        return;
    L17:
        if ((r111 instanceof fbc.a.AbstractC5878a.d) == false) goto L24;
        if (r100.f355567e != FlowVoiceTouch.GesturePhase.Active) goto L41;
        f r114 = r100.f355563a;
        if (r114 == null) goto L42;
        r114.j0(new rac.c(((fbc.a.AbstractC5878a.d) r111).f476325a));
        return;
    L42:
        return;
    L41:
        return;
    L24:
        if ((r111 instanceof fbc.a.AbstractC5878a.e) == false) goto L36;
        r100.d();
        fbc.a.AbstractC5878a.e r115 = (fbc.a.AbstractC5878a.e) r111;
        if (r115.f476327b == false) goto L30;
        if (r102 == null) goto L44;
        r102.invoke();
        return;
    L44:
        return;
    L30:
        if (r100.f355567e != FlowVoiceTouch.GesturePhase.Active) goto L46;
        f r116 = r100.f355563a;
        if (r116 != null) goto L34;
        r101.stop();
        return;
    L34:
        r116.j0(new rac.d(r115.f476326a));
        return;
    L46:
        return;
    L36:
        throw new NoWhenBranchMatchedException();
    }
}
