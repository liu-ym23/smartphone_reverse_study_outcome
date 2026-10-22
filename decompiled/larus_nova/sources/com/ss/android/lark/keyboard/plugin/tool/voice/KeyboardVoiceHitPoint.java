package com.ss.android.lark.keyboard.plugin.tool.voice;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
public final class KeyboardVoiceHitPoint {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f429822a = 0;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/KeyboardVoiceHitPoint$ClickNew;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "SPEECH_TO_TEXT", "HOLD_TO_TALK", "HOLD_TO_TEXT", "CLOSE", "SEND", "ONLY_VOICE", "SEND_TEXT", "CANCEL", "CLICK_INPUT", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum ClickNew extends Enum<ClickNew> {
        public static final ClickNew CANCEL = null;
        public static final ClickNew CLICK_INPUT = null;
        public static final ClickNew CLOSE = null;
        public static final ClickNew HOLD_TO_TALK = null;
        public static final ClickNew HOLD_TO_TEXT = null;
        public static final ClickNew ONLY_VOICE = null;
        public static final ClickNew SEND = null;
        public static final ClickNew SEND_TEXT = null;
        public static final ClickNew SPEECH_TO_TEXT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ ClickNew[] f429823a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f429824b = null;
        private final String value;

        public static EnumEntries<ClickNew> getEntries() {
            return f429824b;
        }

        static {
            ClickNew r100 = new ClickNew("SPEECH_TO_TEXT", 0, "speech_to_text");
            SPEECH_TO_TEXT = r100;
            ClickNew r101 = new ClickNew("HOLD_TO_TALK", 1, "hold_to_talk");
            HOLD_TO_TALK = r101;
            ClickNew r102 = new ClickNew("HOLD_TO_TEXT", 2, "hold_to_text");
            HOLD_TO_TEXT = r102;
            ClickNew r103 = new ClickNew("CLOSE", 3, "close");
            CLOSE = r103;
            ClickNew r104 = new ClickNew("SEND", 4, "send");
            SEND = r104;
            ClickNew r105 = new ClickNew("ONLY_VOICE", 5, "only_voice");
            ONLY_VOICE = r105;
            ClickNew r110 = new ClickNew("SEND_TEXT", 6, "send_text");
            SEND_TEXT = r110;
            ClickNew r111 = new ClickNew("CANCEL", 7, "cancel");
            CANCEL = r111;
            ClickNew r112 = new ClickNew("CLICK_INPUT", 8, "click_input");
            CLICK_INPUT = r112;
            ClickNew[] r113 = {r100, r101, r102, r103, r104, r105, r110, r111, r112};
            f429823a = r113;
            f429824b = EnumEntriesKt.enumEntries(r113);
        }

        public static ClickNew[] values() {
            return (ClickNew[]) f429823a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static ClickNew valueOf(String r100) {
            return (ClickNew) r27.a.a(ClickNew.class, r100);
        }

        public ClickNew(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/KeyboardVoiceHitPoint$FromSource;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "CHAT", "VOICE", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum FromSource extends Enum<FromSource> {
        public static final FromSource CHAT = null;
        public static final FromSource VOICE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FromSource[] f429825a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f429826b = null;
        private final String value;

        public static EnumEntries<FromSource> getEntries() {
            return f429826b;
        }

        static {
            FromSource r100 = new FromSource("CHAT", 0, "chat_menu");
            CHAT = r100;
            FromSource r101 = new FromSource("VOICE", 1, "voice_menu");
            VOICE = r101;
            FromSource[] r102 = {r100, r101};
            f429825a = r102;
            f429826b = EnumEntriesKt.enumEntries(r102);
        }

        public static FromSource[] values() {
            return (FromSource[]) f429825a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static FromSource valueOf(String r100) {
            return (FromSource) r27.a.a(FromSource.class, r100);
        }

        public FromSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
    }
}
