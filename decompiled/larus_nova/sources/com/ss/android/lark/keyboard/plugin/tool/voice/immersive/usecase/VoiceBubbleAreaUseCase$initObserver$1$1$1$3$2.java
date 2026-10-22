package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.usecase;

import android.content.Context;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class VoiceBubbleAreaUseCase$initObserver$1$1$1$3$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $isAsrDefaultEnable;
    final /* synthetic */ AppCompatTextView $tipsReleaseSend;
    final /* synthetic */ VoiceBubbleAreaUseCase this$0;

    public VoiceBubbleAreaUseCase$initObserver$1$1$1$3$2(boolean r100, AppCompatTextView r101, Context r102, VoiceBubbleAreaUseCase r103) {
        this.$isAsrDefaultEnable = r100;
        this.$tipsReleaseSend = r101;
        this.$context = r102;
        this.this$0 = r103;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        if (this.$isAsrDefaultEnable == false) goto L5;
        this.$tipsReleaseSend.setText(this.$context.getString(R.string.Lark_IM_AudioMsg_ReleaseToCancel_Text));
        AppCompatTextView r100 = this.$tipsReleaseSend;
        Intrinsics.checkNotNull(r100);
        r100.setVisibility(0);
        this.this$0.f430447d.n().setVisibility(8);
        return;
    L5:
        this.this$0.f430447d.n().setVisibility(8);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
