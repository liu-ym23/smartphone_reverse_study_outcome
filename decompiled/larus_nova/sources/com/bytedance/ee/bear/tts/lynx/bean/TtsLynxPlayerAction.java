package com.bytedance.ee.bear.tts.lynx.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\b\u0080\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/tts/lynx/bean/TtsLynxPlayerAction;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "START_PLAYING", "RESUME", "PAUSE", "CHANGE_SPEED", "CHANGE_SPEAKER", "REMOVE_ITEM", "ON_CLICK_FLOAT_VIEW", "TERMINATE", "PLAY_PREVIOUS", "PLAY_NEXT", "OPEN_CONTENT", "OPEN_PLAYLIST", "Companion", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TtsLynxPlayerAction extends Enum<TtsLynxPlayerAction> {
    public static final TtsLynxPlayerAction CHANGE_SPEAKER = null;
    public static final TtsLynxPlayerAction CHANGE_SPEED = null;
    public static final a Companion = null;
    public static final TtsLynxPlayerAction ON_CLICK_FLOAT_VIEW = null;
    public static final TtsLynxPlayerAction OPEN_CONTENT = null;
    public static final TtsLynxPlayerAction OPEN_PLAYLIST = null;
    public static final TtsLynxPlayerAction PAUSE = null;
    public static final TtsLynxPlayerAction PLAY_NEXT = null;
    public static final TtsLynxPlayerAction PLAY_PREVIOUS = null;
    public static final TtsLynxPlayerAction REMOVE_ITEM = null;
    public static final TtsLynxPlayerAction RESUME = null;
    public static final TtsLynxPlayerAction START_PLAYING = null;
    public static final TtsLynxPlayerAction TERMINATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TtsLynxPlayerAction[] f239625a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f239626b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<TtsLynxPlayerAction> getEntries() {
        return f239626b;
    }

    static {
        TtsLynxPlayerAction r100 = new TtsLynxPlayerAction("START_PLAYING", 0, 0);
        START_PLAYING = r100;
        TtsLynxPlayerAction r101 = new TtsLynxPlayerAction("RESUME", 1, 1);
        RESUME = r101;
        TtsLynxPlayerAction r102 = new TtsLynxPlayerAction("PAUSE", 2, 2);
        PAUSE = r102;
        TtsLynxPlayerAction r103 = new TtsLynxPlayerAction("CHANGE_SPEED", 3, 3);
        CHANGE_SPEED = r103;
        TtsLynxPlayerAction r104 = new TtsLynxPlayerAction("CHANGE_SPEAKER", 4, 4);
        CHANGE_SPEAKER = r104;
        TtsLynxPlayerAction r105 = new TtsLynxPlayerAction("REMOVE_ITEM", 5, 5);
        REMOVE_ITEM = r105;
        TtsLynxPlayerAction r110 = new TtsLynxPlayerAction("ON_CLICK_FLOAT_VIEW", 6, 6);
        ON_CLICK_FLOAT_VIEW = r110;
        TtsLynxPlayerAction r111 = new TtsLynxPlayerAction("TERMINATE", 7, 7);
        TERMINATE = r111;
        TtsLynxPlayerAction r112 = new TtsLynxPlayerAction("PLAY_PREVIOUS", 8, 8);
        PLAY_PREVIOUS = r112;
        TtsLynxPlayerAction r113 = new TtsLynxPlayerAction("PLAY_NEXT", 9, 9);
        PLAY_NEXT = r113;
        TtsLynxPlayerAction r114 = new TtsLynxPlayerAction("OPEN_CONTENT", 10, 10);
        OPEN_CONTENT = r114;
        TtsLynxPlayerAction r115 = new TtsLynxPlayerAction("OPEN_PLAYLIST", 11, 11);
        OPEN_PLAYLIST = r115;
        TtsLynxPlayerAction[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        f239625a = r106;
        f239626b = EnumEntriesKt.enumEntries(r106);
        Companion = new a();
    }

    public static TtsLynxPlayerAction[] values() {
        return (TtsLynxPlayerAction[]) f239625a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final TtsLynxPlayerAction from(int r100) {
        Companion.getClass();
        TtsLynxPlayerAction[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        TtsLynxPlayerAction r104 = r101[r103];
        if (r104.getValue() != r100) goto L7;
        boolean r105 = true;
    L8:
        if (r105 == true) goto L15;
        r103 = r103 + 1;
        goto L3
    L15:
        return r104;
    L7:
        r105 = false;
        goto L8
    L11:
        return null;
    }

    public static TtsLynxPlayerAction valueOf(String r100) {
        return (TtsLynxPlayerAction) r27.a.a(TtsLynxPlayerAction.class, r100);
    }

    public TtsLynxPlayerAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
