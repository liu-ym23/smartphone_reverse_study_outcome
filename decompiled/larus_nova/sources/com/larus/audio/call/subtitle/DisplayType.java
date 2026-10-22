package com.larus.audio.call.subtitle;

import com.android.ttcjpaysdk.bdpay.counter.outer.bean.ConfirmNextAction;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/call/subtitle/DisplayType;", "", "<init>", "(Ljava/lang/String;I)V", "SCENE_MODE", "REPLY", "REPLY_TXT", "REPLY_BLOCK", "TTS_WAITING", "DEEP_THINKING", ConfirmNextAction.ACTION_TYPE_QUERY, "QUERY_IMAGE", "avkit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DisplayType extends Enum<DisplayType> {
    public static final DisplayType DEEP_THINKING = null;
    public static final DisplayType QUERY = null;
    public static final DisplayType QUERY_IMAGE = null;
    public static final DisplayType REPLY = null;
    public static final DisplayType REPLY_BLOCK = null;
    public static final DisplayType REPLY_TXT = null;
    public static final DisplayType SCENE_MODE = null;
    public static final DisplayType TTS_WAITING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DisplayType[] f289613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289614b = null;

    public static EnumEntries<DisplayType> getEntries() {
        return f289614b;
    }

    static {
        DisplayType r100 = new DisplayType("SCENE_MODE", 0);
        SCENE_MODE = r100;
        DisplayType r101 = new DisplayType("REPLY", 1);
        REPLY = r101;
        DisplayType r102 = new DisplayType("REPLY_TXT", 2);
        REPLY_TXT = r102;
        DisplayType r103 = new DisplayType("REPLY_BLOCK", 3);
        REPLY_BLOCK = r103;
        DisplayType r104 = new DisplayType("TTS_WAITING", 4);
        TTS_WAITING = r104;
        DisplayType r105 = new DisplayType("DEEP_THINKING", 5);
        DEEP_THINKING = r105;
        DisplayType r110 = new DisplayType(ConfirmNextAction.ACTION_TYPE_QUERY, 6);
        QUERY = r110;
        DisplayType r111 = new DisplayType("QUERY_IMAGE", 7);
        QUERY_IMAGE = r111;
        DisplayType[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f289613a = r112;
        f289614b = EnumEntriesKt.enumEntries(r112);
    }

    public static DisplayType[] values() {
        return (DisplayType[]) f289613a.clone();
    }

    public static DisplayType valueOf(String r100) {
        return (DisplayType) a.a(DisplayType.class, r100);
    }

    public DisplayType(String r100, int r101) {
        super(r100, r101);
    }
}
