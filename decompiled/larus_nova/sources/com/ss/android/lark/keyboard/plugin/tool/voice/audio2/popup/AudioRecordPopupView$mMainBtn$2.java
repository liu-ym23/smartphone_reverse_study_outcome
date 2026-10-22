package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/larksuite/component/universe_design/button/UDButton;", "kotlin.jvm.PlatformType", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AudioRecordPopupView$mMainBtn$2 extends Lambda implements Function0<UDButton> {
    final /* synthetic */ AudioRecordPopupView this$0;

    public AudioRecordPopupView$mMainBtn$2(AudioRecordPopupView r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final UDButton invoke() {
        return (UDButton) this.this$0.findViewById(R.id.audio_record_popup_view_main_button);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ UDButton invoke() {
        return invoke();
    }
}
