package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AsrInputVoiceViewV2$preparingHint$2 extends Lambda implements Function0<String> {
    final /* synthetic */ AsrInputVoiceViewV2 this$0;

    public AsrInputVoiceViewV2$preparingHint$2(AsrInputVoiceViewV2 r100) {
        this.this$0 = r100;
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        int r100 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
        return com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f(this.this$0, R.string.Lark_IM_AudioMsg_PreparingRecord_Text);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }
}
