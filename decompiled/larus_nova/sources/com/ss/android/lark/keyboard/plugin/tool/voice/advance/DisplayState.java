package com.ss.android.lark.keyboard.plugin.tool.voice.advance;

import com.byted.cast.common.bean.State;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/advance/DisplayState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "PREPARING", State.RECORDING, "RECOGNIZING", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DisplayState extends Enum<DisplayState> {
    public static final DisplayState IDLE = null;
    public static final DisplayState PREPARING = null;
    public static final DisplayState RECOGNIZING = null;
    public static final DisplayState RECORDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisplayState[] f429839a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f429840b = null;

    public static EnumEntries<DisplayState> getEntries() {
        return f429840b;
    }

    static {
        DisplayState r100 = new DisplayState("IDLE", 0);
        IDLE = r100;
        DisplayState r101 = new DisplayState("PREPARING", 1);
        PREPARING = r101;
        DisplayState r102 = new DisplayState(State.RECORDING, 2);
        RECORDING = r102;
        DisplayState r103 = new DisplayState("RECOGNIZING", 3);
        RECOGNIZING = r103;
        DisplayState[] r104 = {r100, r101, r102, r103};
        f429839a = r104;
        f429840b = EnumEntriesKt.enumEntries(r104);
    }

    public static DisplayState[] values() {
        return (DisplayState[]) f429839a.clone();
    }

    public static DisplayState valueOf(String r100) {
        return (DisplayState) r27.a.a(DisplayState.class, r100);
    }

    public DisplayState(String r100, int r101) {
        super(r100, r101);
    }
}
