package com.bytedance.live.livelink.kmp.impl.base.statistic;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
final class InteractLogStatics$addVideoFramesReport$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isAudio;
    final /* synthetic */ boolean $isNormal;
    final /* synthetic */ InteractLogStatics this$0;

    public InteractLogStatics$addVideoFramesReport$1(InteractLogStatics r100, boolean r101, boolean r102) {
        this.this$0 = r100;
        this.$isAudio = r101;
        this.$isNormal = r102;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$isAudio == false) goto L9;
        if (this.$isNormal == false) goto L7;
        this.this$0.getClass();
        return;
    L7:
        this.this$0.getClass();
        return;
    L9:
        if (this.$isNormal == false) goto L11;
        this.this$0.getClass();
        return;
    L11:
        this.this$0.getClass();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
