package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.log.Log;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AudioPluginController$observeSysKeyboard$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ h this$0;

    public AudioPluginController$observeSysKeyboard$1$2(h r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Log.i("AudioPluginController", "observeSysKeyboard / imeHide");
        this.this$0.getClass();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
