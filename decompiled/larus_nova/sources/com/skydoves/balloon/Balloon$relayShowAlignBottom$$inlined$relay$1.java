package com.skydoves.balloon;

import android.view.View;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/skydoves/balloon/Balloon$relay$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Balloon$relayShowAlignBottom$$inlined$relay$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ View $anchor$inlined;
    final /* synthetic */ Balloon $balloon;
    final /* synthetic */ int $xOff$inlined;
    final /* synthetic */ int $yOff$inlined;
    final /* synthetic */ Balloon this$0;

    public Balloon$relayShowAlignBottom$$inlined$relay$1(Balloon r100, Balloon r101, View r102, int r103, int r104) {
        this.this$0 = r100;
        this.$balloon = r101;
        this.$anchor$inlined = r102;
        this.$xOff$inlined = r103;
        this.$yOff$inlined = r104;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.this$0.f406025h == true) goto L6;
        this.$balloon.s(this.$anchor$inlined, this.$xOff$inlined, this.$yOff$inlined);
        return;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
