package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Lkotlin/Unit;"}, k = 3, mv = {2, 1, 0}, xi = 48)
public final class AudioRecordPopupView$dismiss$onAnimEnd$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function0<Unit> $onDismiss;
    final /* synthetic */ AudioRecordPopupView this$0;

    public AudioRecordPopupView$dismiss$onAnimEnd$1(AudioRecordPopupView r100, Function0<Unit> r101) {
        this.this$0 = r100;
        this.$onDismiss = r101;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Unit invoke2() {
        this.this$0.Y5();
        this.this$0.f429964b = false;
        Function0<Unit> r100 = this.$onDismiss;
        if (r100 == null) goto L5;
        r100.invoke();
        return Unit.INSTANCE;
    L5:
        return null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        return invoke2();
    }
}
