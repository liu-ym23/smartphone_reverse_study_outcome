package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\t"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/SendType;", "", "type", "", "<init>", "(Ljava/lang/String;II)V", "OnlyText", "VoiceWithAsr", "value", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SendType extends Enum<SendType> {
    public static final SendType OnlyText = null;
    public static final SendType VoiceWithAsr = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SendType[] f430178a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f430179b = null;
    private final int type;

    public static EnumEntries<SendType> getEntries() {
        return f430179b;
    }

    static {
        SendType r100 = new SendType("OnlyText", 0, 0);
        OnlyText = r100;
        SendType r101 = new SendType("VoiceWithAsr", 1, 1);
        VoiceWithAsr = r101;
        SendType[] r102 = {r100, r101};
        f430178a = r102;
        f430179b = EnumEntriesKt.enumEntries(r102);
    }

    public static SendType[] values() {
        return (SendType[]) f430178a.clone();
    }

    public final int value() {
        return this.type;
    }

    public static SendType valueOf(String r100) {
        return (SendType) a.a(SendType.class, r100);
    }

    public SendType(String r100, int r101, int r102) {
        super(r100, r101);
        this.type = r102;
    }
}
