package com.larus.kmp.voice_setting.voice.screen.doubletab;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/kmp/voice_setting/voice/screen/doubletab/VoiceDoubleTabTextKey;", "", "<init>", "(Ljava/lang/String;I)V", "MY_TAB_TITLE", "RECOMMEND_TAB_TITLE", "CREATE_VOICE_HINT", "BOT_VOICE_NOT_AVAILABLE", "SCROLL_FAIL", "BOT_VOICE_EMPTY", "flow-voice-setting-impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum VoiceDoubleTabTextKey extends Enum<VoiceDoubleTabTextKey> {
    public static final VoiceDoubleTabTextKey BOT_VOICE_EMPTY = null;
    public static final VoiceDoubleTabTextKey BOT_VOICE_NOT_AVAILABLE = null;
    public static final VoiceDoubleTabTextKey CREATE_VOICE_HINT = null;
    public static final VoiceDoubleTabTextKey MY_TAB_TITLE = null;
    public static final VoiceDoubleTabTextKey RECOMMEND_TAB_TITLE = null;
    public static final VoiceDoubleTabTextKey SCROLL_FAIL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ VoiceDoubleTabTextKey[] f354169a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f354170b = null;

    public static EnumEntries<VoiceDoubleTabTextKey> getEntries() {
        return f354170b;
    }

    static {
        VoiceDoubleTabTextKey r100 = new VoiceDoubleTabTextKey("MY_TAB_TITLE", 0);
        MY_TAB_TITLE = r100;
        VoiceDoubleTabTextKey r101 = new VoiceDoubleTabTextKey("RECOMMEND_TAB_TITLE", 1);
        RECOMMEND_TAB_TITLE = r101;
        VoiceDoubleTabTextKey r102 = new VoiceDoubleTabTextKey("CREATE_VOICE_HINT", 2);
        CREATE_VOICE_HINT = r102;
        VoiceDoubleTabTextKey r103 = new VoiceDoubleTabTextKey("BOT_VOICE_NOT_AVAILABLE", 3);
        BOT_VOICE_NOT_AVAILABLE = r103;
        VoiceDoubleTabTextKey r104 = new VoiceDoubleTabTextKey("SCROLL_FAIL", 4);
        SCROLL_FAIL = r104;
        VoiceDoubleTabTextKey r105 = new VoiceDoubleTabTextKey("BOT_VOICE_EMPTY", 5);
        BOT_VOICE_EMPTY = r105;
        VoiceDoubleTabTextKey[] r110 = {r100, r101, r102, r103, r104, r105};
        f354169a = r110;
        f354170b = EnumEntriesKt.enumEntries(r110);
    }

    public static VoiceDoubleTabTextKey[] values() {
        return (VoiceDoubleTabTextKey[]) f354169a.clone();
    }

    public static VoiceDoubleTabTextKey valueOf(String r100) {
        return (VoiceDoubleTabTextKey) r27.a.a(VoiceDoubleTabTextKey.class, r100);
    }

    public VoiceDoubleTabTextKey(String r100, int r101) {
        super(r100, r101);
    }
}
