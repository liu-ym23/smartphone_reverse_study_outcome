package com.skydoves.balloon;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/skydoves/balloon/Balloon$relay$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Balloon$relayShowAlign$$inlined$relay$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BalloonAlign $align$inlined;
    final /* synthetic */ View $anchor$inlined;
    final /* synthetic */ Balloon $balloon;
    final /* synthetic */ int $xOff$inlined;
    final /* synthetic */ int $yOff$inlined;
    final /* synthetic */ Balloon this$0;
    final /* synthetic */ Balloon this$0$inline_fun;

    public Balloon$relayShowAlign$$inlined$relay$1(Balloon r100, Balloon r101, BalloonAlign r102, Balloon r103, View r104, int r105, int r106) {
        this.this$0$inline_fun = r100;
        this.$balloon = r101;
        this.$align$inlined = r102;
        this.this$0 = r103;
        this.$anchor$inlined = r104;
        this.$xOff$inlined = r105;
        this.$yOff$inlined = r106;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.this$0$inline_fun.f406025h == true) goto L26;
        Balloon r100 = this.$balloon;
        BalloonAlign.a r101 = BalloonAlign.Companion;
        BalloonAlign r102 = this.$align$inlined;
        boolean r103 = this.this$0.f406019b.f406040e0;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<this>");
        if (r103 == false) goto L13;
        int r104 = BalloonAlign.a.C4699a.f406125a[r102.ordinal()];
        if (r104 == 1) goto L12;
        if (r104 != 2) goto L13;
        r102 = BalloonAlign.START;
        goto L13
    L12:
        r102 = BalloonAlign.END;
    L13:
        int r105 = Balloon.c.f406072g[r102.ordinal()];
        if (r105 == 1) goto L24;
        if (r105 != 2) goto L17;
        r100.s(this.$anchor$inlined, this.$xOff$inlined, this.$yOff$inlined);
        return;
    L17:
        if (r105 != 3) goto L19;
        r100.u(this.$anchor$inlined, this.$xOff$inlined, this.$yOff$inlined);
        return;
    L19:
        if (r105 != 4) goto L30;
        r100.t(this.$anchor$inlined, this.$xOff$inlined, this.$yOff$inlined);
        return;
    L30:
        return;
    L24:
        r100.v(this.$anchor$inlined, this.$xOff$inlined, this.$yOff$inlined);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
