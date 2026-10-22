package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.adapter;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/adapter/IconWithTitleItemId;", "", "itemId", "", "<init>", "(Ljava/lang/String;II)V", "SubmitFeedback", "RollBackAudio", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum IconWithTitleItemId extends Enum<IconWithTitleItemId> {
    public static final IconWithTitleItemId RollBackAudio = null;
    public static final IconWithTitleItemId SubmitFeedback = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ IconWithTitleItemId[] f430174a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f430175b = null;
    private final int itemId;

    public static EnumEntries<IconWithTitleItemId> getEntries() {
        return f430175b;
    }

    static {
        IconWithTitleItemId r100 = new IconWithTitleItemId("SubmitFeedback", 0, 0);
        SubmitFeedback = r100;
        IconWithTitleItemId r101 = new IconWithTitleItemId("RollBackAudio", 1, 1);
        RollBackAudio = r101;
        IconWithTitleItemId[] r102 = {r100, r101};
        f430174a = r102;
        f430175b = EnumEntriesKt.enumEntries(r102);
    }

    public static IconWithTitleItemId[] values() {
        return (IconWithTitleItemId[]) f430174a.clone();
    }

    public static IconWithTitleItemId valueOf(String r100) {
        return (IconWithTitleItemId) a.a(IconWithTitleItemId.class, r100);
    }

    public IconWithTitleItemId(String r100, int r101, int r102) {
        super(r100, r101);
        this.itemId = r102;
    }
}
