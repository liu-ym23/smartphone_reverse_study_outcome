package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B1\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$WaveformWidgetTheme;", "", "bgColorRes", "", "waveColorRes", "fadeColorRes", "textColorRes", "<init>", "(Ljava/lang/String;IIIII)V", "getBgColorRes", "()I", "getWaveColorRes", "getFadeColorRes", "getTextColorRes", "BLUE_SIMPLE", "BLUE", "GRAY", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioPluginEnums$WaveformWidgetTheme extends Enum<AudioPluginEnums$WaveformWidgetTheme> {
    public static final AudioPluginEnums$WaveformWidgetTheme BLUE = null;
    public static final AudioPluginEnums$WaveformWidgetTheme BLUE_SIMPLE = null;
    public static final AudioPluginEnums$WaveformWidgetTheme GRAY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioPluginEnums$WaveformWidgetTheme[] f429997a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f429998b = null;
    private final int bgColorRes;
    private final int fadeColorRes;
    private final int textColorRes;
    private final int waveColorRes;

    public static EnumEntries<AudioPluginEnums$WaveformWidgetTheme> getEntries() {
        return f429998b;
    }

    static {
        AudioPluginEnums$WaveformWidgetTheme r100 = new AudioPluginEnums$WaveformWidgetTheme("BLUE_SIMPLE", 0, R.color.transparent, R.color.primary_content_default, R.color.primary_content_loading, R.color.transparent);
        BLUE_SIMPLE = r100;
        AudioPluginEnums$WaveformWidgetTheme r101 = new AudioPluginEnums$WaveformWidgetTheme("BLUE", 1, R.color.imtoken_message_bg_bubbles_blue, R.color.primary_content_default, R.color.primary_content_loading, R.color.text_link_normal);
        BLUE = r101;
        AudioPluginEnums$WaveformWidgetTheme r102 = new AudioPluginEnums$WaveformWidgetTheme("GRAY", 2, R.color.imtoken_message_bg_reaction_grey, R.color.text_caption, R.color.text_link_disable, R.color.text_caption);
        GRAY = r102;
        AudioPluginEnums$WaveformWidgetTheme[] r103 = {r100, r101, r102};
        f429997a = r103;
        f429998b = EnumEntriesKt.enumEntries(r103);
    }

    public static AudioPluginEnums$WaveformWidgetTheme[] values() {
        return (AudioPluginEnums$WaveformWidgetTheme[]) f429997a.clone();
    }

    public final int getBgColorRes() {
        return this.bgColorRes;
    }

    public final int getFadeColorRes() {
        return this.fadeColorRes;
    }

    public final int getTextColorRes() {
        return this.textColorRes;
    }

    public final int getWaveColorRes() {
        return this.waveColorRes;
    }

    public static AudioPluginEnums$WaveformWidgetTheme valueOf(String r100) {
        return (AudioPluginEnums$WaveformWidgetTheme) r27.a.a(AudioPluginEnums$WaveformWidgetTheme.class, r100);
    }

    public AudioPluginEnums$WaveformWidgetTheme(String r100, int r101, int r102, int r103, int r104, int r105) {
        super(r100, r101);
        this.bgColorRes = r102;
        this.waveColorRes = r103;
        this.fadeColorRes = r104;
        this.textColorRes = r105;
    }
}
