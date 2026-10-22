package com.ss.android.lark.officesdk.minutes.ui.record;

import com.byted.cast.common.bean.State;
import com.larus.media.MediaScene;
import com.ss.android.lark.banner.export.entity.BannerBizName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001c¨\u0006\u001d"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/MmUiLogScene;", "", "tag", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getTag", "()Ljava/lang/String;", "ENTRY", "ROUTER", State.RECORDING, "StandaloneAIInterpretation", "TOOLBAR", "CONTENT", "SUBTITLE", "SUMMARY", MediaScene.AI_NOTE, "LANGUAGE", "SPEAKER", "AUDIO_SAVE", "OVERLAY", "FLOAT", "END_WINDOW", "WEB", BannerBizName.NOTIFICATION, "STYLE", "FOUNDATION", "HARDWARE", "HW_WALLPAPER", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MmUiLogScene extends Enum<MmUiLogScene> {
    public static final MmUiLogScene AI_NOTE = null;
    public static final MmUiLogScene AUDIO_SAVE = null;
    public static final MmUiLogScene CONTENT = null;
    public static final MmUiLogScene END_WINDOW = null;
    public static final MmUiLogScene ENTRY = null;
    public static final MmUiLogScene FLOAT = null;
    public static final MmUiLogScene FOUNDATION = null;
    public static final MmUiLogScene HARDWARE = null;
    public static final MmUiLogScene HW_WALLPAPER = null;
    public static final MmUiLogScene LANGUAGE = null;
    public static final MmUiLogScene NOTIFICATION = null;
    public static final MmUiLogScene OVERLAY = null;
    public static final MmUiLogScene RECORDING = null;
    public static final MmUiLogScene ROUTER = null;
    public static final MmUiLogScene SPEAKER = null;
    public static final MmUiLogScene STYLE = null;
    public static final MmUiLogScene SUBTITLE = null;
    public static final MmUiLogScene SUMMARY = null;
    public static final MmUiLogScene StandaloneAIInterpretation = null;
    public static final MmUiLogScene TOOLBAR = null;
    public static final MmUiLogScene WEB = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MmUiLogScene[] f435809a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f435810b = null;
    private final String tag;

    public static EnumEntries<MmUiLogScene> getEntries() {
        return f435810b;
    }

    static {
        MmUiLogScene r100 = new MmUiLogScene("ENTRY", 0, "UI_ENTRY");
        ENTRY = r100;
        MmUiLogScene r101 = new MmUiLogScene("ROUTER", 1, "UI_ROUTER");
        ROUTER = r101;
        MmUiLogScene r102 = new MmUiLogScene(State.RECORDING, 2, "UI_RECORDING");
        RECORDING = r102;
        MmUiLogScene r103 = new MmUiLogScene("StandaloneAIInterpretation", 3, "UI_STANDALONE_AI_INTERPRETATION");
        StandaloneAIInterpretation = r103;
        MmUiLogScene r104 = new MmUiLogScene("TOOLBAR", 4, "UI_TOOLBAR");
        TOOLBAR = r104;
        MmUiLogScene r105 = new MmUiLogScene("CONTENT", 5, "UI_CONTENT");
        CONTENT = r105;
        MmUiLogScene r110 = new MmUiLogScene("SUBTITLE", 6, "UI_SUBTITLE");
        SUBTITLE = r110;
        MmUiLogScene r111 = new MmUiLogScene("SUMMARY", 7, "UI_SUMMARY");
        SUMMARY = r111;
        MmUiLogScene r112 = new MmUiLogScene(MediaScene.AI_NOTE, 8, "UI_AINOTE");
        AI_NOTE = r112;
        MmUiLogScene r113 = new MmUiLogScene("LANGUAGE", 9, "UI_LANGUAGE");
        LANGUAGE = r113;
        MmUiLogScene r114 = new MmUiLogScene("SPEAKER", 10, "UI_SPEAKER");
        SPEAKER = r114;
        MmUiLogScene r106 = new MmUiLogScene("AUDIO_SAVE", 11, "UI_AUDIO_SAVE");
        AUDIO_SAVE = r106;
        MmUiLogScene r107 = new MmUiLogScene("OVERLAY", 12, "UI_OVERLAY");
        OVERLAY = r107;
        MmUiLogScene r108 = new MmUiLogScene("FLOAT", 13, "UI_FLOAT");
        FLOAT = r108;
        MmUiLogScene r109 = new MmUiLogScene("END_WINDOW", 14, "UI_END");
        END_WINDOW = r109;
        MmUiLogScene r115 = new MmUiLogScene("WEB", 15, "UI_WEB");
        WEB = r115;
        MmUiLogScene r116 = new MmUiLogScene(BannerBizName.NOTIFICATION, 16, "UI_NOTIFY");
        NOTIFICATION = r116;
        MmUiLogScene r117 = new MmUiLogScene("STYLE", 17, "UI_STYLE");
        STYLE = r117;
        MmUiLogScene r118 = new MmUiLogScene("FOUNDATION", 18, "UI_FOUNDATION");
        FOUNDATION = r118;
        MmUiLogScene r119 = new MmUiLogScene("HARDWARE", 19, "UI_HARDWARE");
        HARDWARE = r119;
        MmUiLogScene r120 = new MmUiLogScene("HW_WALLPAPER", 20, "UI_HW_WALLPAPER");
        HW_WALLPAPER = r120;
        MmUiLogScene[] r121 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117, r118, r119, r120};
        f435809a = r121;
        f435810b = EnumEntriesKt.enumEntries(r121);
    }

    public static MmUiLogScene[] values() {
        return (MmUiLogScene[]) f435809a.clone();
    }

    public final String getTag() {
        return this.tag;
    }

    public static MmUiLogScene valueOf(String r100) {
        return (MmUiLogScene) a.a(MmUiLogScene.class, r100);
    }

    public MmUiLogScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.tag = r102;
    }
}
