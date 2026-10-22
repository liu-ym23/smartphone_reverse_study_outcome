package com.larus.suggest.impl.wcb.render;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.bmhome.chat.bean.WcbRenderStatus;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class WcbInitialRenderDecorator$begin$1 implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q f370027a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f370028b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ WcbInitialRenderDecorator f370029c;

    @Override // com.larus.suggest.impl.wcb.render.q
    public final Object b(Continuation<? super Unit> r100) {
        return this.f370027a.b(r100);
    }

    @Override // com.larus.suggest.impl.wcb.render.q
    public final void c() {
        this.f370027a.c();
    }

    @Override // com.larus.suggest.impl.wcb.render.q
    public final boolean isActive() {
        return this.f370027a.isActive();
    }

    @Override // com.larus.suggest.impl.wcb.render.q
    public final void cancel() {
        this.f370029c.f370025b.f370045b = null;
        this.f370028b.cancel();
    }

    public WcbInitialRenderDecorator$begin$1(q r100, WcbInitialRenderDecorator r101) {
        this.f370028b = r100;
        this.f370029c = r101;
        this.f370027a = r100;
    }

    @Override // com.larus.suggest.impl.wcb.render.q
    public final Object a(l r100, Continuation<? super n> r110) {
        if ((r110 instanceof WcbInitialRenderDecorator$begin$1$render$1) == false) goto L7;
        WcbInitialRenderDecorator$begin$1$render$1 r101 = (WcbInitialRenderDecorator$begin$1$render$1) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
    L25:
        n r112 = (n) r111;
        if (this.f370028b.isActive() == true) goto L28;
    L37:
        return r112;
    L28:
        if ((r112 instanceof n.b) == false) goto L37;
        n.b r106 = (n.b) r112;
        if (Intrinsics.areEqual(r106.f370064b.get("wcb_render_status"), WcbRenderStatus.DEPRECATED) == true) goto L37;
        g r107 = this.f370029c.f370025b;
        r107.getClass();
        Intrinsics.checkNotNullParameter(r106, "submission");
        if (r107.f370044a == false) goto L34;
        r105 = false;
    L35:
        if (r105 == false) goto L37;
        this.f370029c.f370026c.x4();
        goto L37
    L34:
        r107.f370045b = r106;
        goto L35
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        q r113 = this.f370028b;
        if (this.f370029c.f370025b.f370044a == false) goto L17;
    L22:
        r101.label = 1;
        r111 = r113.a(r100, r101);
        if (r111 != r103) goto L25;
        return r103;
    L17:
        if ((r100 instanceof l.c) == false) goto L22;
        l.c r108 = (l.c) r100;
        if (Intrinsics.areEqual(r108.f370060b.f370051c, WcbRenderStatus.UPDATED) == false) goto L22;
        i r109 = r108.f370060b;
        int r114 = r109.f370049a;
        NexPulseResponseData r115 = r109.f370050b;
        boolean r116 = r109.f370052d;
        Intrinsics.checkNotNullParameter(r115, "response");
        i r117 = new i(r114, r115, "DEFAULT", r116);
        p r118 = r108.f370059a;
        Intrinsics.checkNotNullParameter(r118, PickerReporterConstants.KEY.TARGET);
        Intrinsics.checkNotNullParameter(r117, "presentation");
        r100 = new l.c(r118, r117);
    L7:
        r101 = new WcbInitialRenderDecorator$begin$1$render$1(this, r110);
        goto L8
    }
}
