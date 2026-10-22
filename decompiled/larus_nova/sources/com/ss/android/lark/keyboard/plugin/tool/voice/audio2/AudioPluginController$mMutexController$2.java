package com.ss.android.lark.keyboard.plugin.tool.voice.audio2;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.keyboard.plugin.tool.voice.AudioRecordMutexController;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/ss/android/lark/keyboard/plugin/tool/voice/AudioRecordMutexController;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class AudioPluginController$mMutexController$2 extends Lambda implements Function0<AudioRecordMutexController> {
    public static final AudioPluginController$mMutexController$2 INSTANCE = null;

    static {
        INSTANCE = new AudioPluginController$mMutexController$2();
    }

    public AudioPluginController$mMutexController$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final AudioRecordMutexController invoke() {
        Lazy<AudioRecordMutexController> r100 = AudioRecordMutexController.f429805d;
        return AudioRecordMutexController.a.a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ AudioRecordMutexController invoke() {
        return invoke();
    }
}
