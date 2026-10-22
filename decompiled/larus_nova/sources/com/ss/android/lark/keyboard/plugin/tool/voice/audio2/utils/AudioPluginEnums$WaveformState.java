package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$WaveformState;", "", "<init>", "(Ljava/lang/String;I)V", ErrorCode.INIT, State.RECORDING, "DISPLAY", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioPluginEnums$WaveformState extends Enum<AudioPluginEnums$WaveformState> {
    public static final AudioPluginEnums$WaveformState DISPLAY = null;
    public static final AudioPluginEnums$WaveformState INIT = null;
    public static final AudioPluginEnums$WaveformState RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioPluginEnums$WaveformState[] f429995a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f429996b = null;

    public static EnumEntries<AudioPluginEnums$WaveformState> getEntries() {
        return f429996b;
    }

    static {
        AudioPluginEnums$WaveformState r100 = new AudioPluginEnums$WaveformState(ErrorCode.INIT, 0);
        INIT = r100;
        AudioPluginEnums$WaveformState r101 = new AudioPluginEnums$WaveformState(State.RECORDING, 1);
        RECORDING = r101;
        AudioPluginEnums$WaveformState r102 = new AudioPluginEnums$WaveformState("DISPLAY", 2);
        DISPLAY = r102;
        AudioPluginEnums$WaveformState[] r103 = {r100, r101, r102};
        f429995a = r103;
        f429996b = EnumEntriesKt.enumEntries(r103);
    }

    public static AudioPluginEnums$WaveformState[] values() {
        return (AudioPluginEnums$WaveformState[]) f429995a.clone();
    }

    public static AudioPluginEnums$WaveformState valueOf(String r100) {
        return (AudioPluginEnums$WaveformState) r27.a.a(AudioPluginEnums$WaveformState.class, r100);
    }

    public AudioPluginEnums$WaveformState(String r100, int r101) {
        super(r100, r101);
    }
}
