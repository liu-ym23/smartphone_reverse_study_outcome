package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/SwitchActionItemId;", "", "itemId", "", "<init>", "(Ljava/lang/String;II)V", "PolishVoiceInput", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SwitchActionItemId extends Enum<SwitchActionItemId> {
    public static final SwitchActionItemId PolishVoiceInput = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SwitchActionItemId[] f430180a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f430181b = null;
    private final int itemId;

    public static EnumEntries<SwitchActionItemId> getEntries() {
        return f430181b;
    }

    static {
        SwitchActionItemId r100 = new SwitchActionItemId();
        PolishVoiceInput = r100;
        SwitchActionItemId[] r101 = {r100};
        f430180a = r101;
        f430181b = EnumEntriesKt.enumEntries(r101);
    }

    public SwitchActionItemId() {
        super("PolishVoiceInput", 0);
        this.itemId = 0;
    }

    public static SwitchActionItemId[] values() {
        return (SwitchActionItemId[]) f430180a.clone();
    }

    public static SwitchActionItemId valueOf(String r100) {
        return (SwitchActionItemId) a.a(SwitchActionItemId.class, r100);
    }
}
