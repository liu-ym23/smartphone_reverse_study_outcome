package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "COMPLETE", "SIMPLE", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioPluginEnums$DisplayMode extends Enum<AudioPluginEnums$DisplayMode> {
    public static final AudioPluginEnums$DisplayMode COMPLETE = null;
    public static final AudioPluginEnums$DisplayMode SIMPLE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioPluginEnums$DisplayMode[] f429993a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f429994b = null;

    public static EnumEntries<AudioPluginEnums$DisplayMode> getEntries() {
        return f429994b;
    }

    static {
        AudioPluginEnums$DisplayMode r100 = new AudioPluginEnums$DisplayMode("COMPLETE", 0);
        COMPLETE = r100;
        AudioPluginEnums$DisplayMode r101 = new AudioPluginEnums$DisplayMode("SIMPLE", 1);
        SIMPLE = r101;
        AudioPluginEnums$DisplayMode[] r102 = {r100, r101};
        f429993a = r102;
        f429994b = EnumEntriesKt.enumEntries(r102);
    }

    public static AudioPluginEnums$DisplayMode[] values() {
        return (AudioPluginEnums$DisplayMode[]) f429993a.clone();
    }

    public static AudioPluginEnums$DisplayMode valueOf(String r100) {
        return (AudioPluginEnums$DisplayMode) r27.a.a(AudioPluginEnums$DisplayMode.class, r100);
    }

    public AudioPluginEnums$DisplayMode(String r100, int r101) {
        super(r100, r101);
    }
}
