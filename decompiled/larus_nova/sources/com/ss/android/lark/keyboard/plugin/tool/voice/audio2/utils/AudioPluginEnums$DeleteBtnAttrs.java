package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.utils;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/audio2/utils/AudioPluginEnums$DeleteBtnAttrs;", "", "bias", "", GXTemplateKey.FLEXBOX_PADDING, "", "<init>", "(Ljava/lang/String;IFI)V", "getBias", "()F", "getPadding", "()I", ErrorCode.INIT, "FINAL", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioPluginEnums$DeleteBtnAttrs extends Enum<AudioPluginEnums$DeleteBtnAttrs> {
    public static final AudioPluginEnums$DeleteBtnAttrs FINAL = null;
    public static final AudioPluginEnums$DeleteBtnAttrs INIT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioPluginEnums$DeleteBtnAttrs[] f429991a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f429992b = null;
    private final float bias;
    private final int padding;

    public static EnumEntries<AudioPluginEnums$DeleteBtnAttrs> getEntries() {
        return f429992b;
    }

    static {
        AudioPluginEnums$DeleteBtnAttrs r100 = new AudioPluginEnums$DeleteBtnAttrs(ErrorCode.INIT, 0, 0.9f, 12);
        INIT = r100;
        AudioPluginEnums$DeleteBtnAttrs r101 = new AudioPluginEnums$DeleteBtnAttrs("FINAL", 1, 0.2f, 0);
        FINAL = r101;
        AudioPluginEnums$DeleteBtnAttrs[] r102 = {r100, r101};
        f429991a = r102;
        f429992b = EnumEntriesKt.enumEntries(r102);
    }

    public static AudioPluginEnums$DeleteBtnAttrs[] values() {
        return (AudioPluginEnums$DeleteBtnAttrs[]) f429991a.clone();
    }

    public final float getBias() {
        return this.bias;
    }

    public final int getPadding() {
        return this.padding;
    }

    public static AudioPluginEnums$DeleteBtnAttrs valueOf(String r100) {
        return (AudioPluginEnums$DeleteBtnAttrs) r27.a.a(AudioPluginEnums$DeleteBtnAttrs.class, r100);
    }

    public AudioPluginEnums$DeleteBtnAttrs(String r100, int r101, float r102, int r103) {
        super(r100, r101);
        this.bias = r102;
        this.padding = r103;
    }
}
