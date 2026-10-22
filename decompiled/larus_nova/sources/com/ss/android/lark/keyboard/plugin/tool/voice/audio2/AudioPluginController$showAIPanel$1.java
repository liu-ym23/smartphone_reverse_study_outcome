package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import z5c.e4;
import z5c.r;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AudioPluginController$showAIPanel$1 extends Lambda implements Function1<String, Unit> {
    final /* synthetic */ String $text;
    final /* synthetic */ h this$0;

    public AudioPluginController$showAIPanel$1(h r100, String r101) {
        this.this$0 = r100;
        this.$text = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100) {
        int r101 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.b.f430002a;
        String r102 = this.this$0.f();
        if (this.$text.length() <= 0) goto L5;
        boolean r103 = true;
    L6:
        Intrinsics.checkNotNullParameter(r102, "sourceId");
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.b.a("im_chat_voice_msg_click", new Pair[]{new Pair("click", r.N2.f540772b), new Pair(BytedCertConstant.IntentKey.VIEW_TYPE, e4.f570194d.f540772b), new Pair("source_id", r102), new Pair("is_recognized", Boolean.valueOf(r103))});
        int r104 = com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils.c.f430003a;
        this.this$0.getClass();
        throw null;
    L5:
        r103 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
