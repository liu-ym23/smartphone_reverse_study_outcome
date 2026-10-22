package com.larus.audio.controller;

import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/audio/controller/GlobalAudioStateEnum;", "", "num", "", "<init>", "(Ljava/lang/String;II)V", "getNum", "()I", UserProfileEvent.POSITION_NONE, "STOPPED", "PAUSED", "PLAYING", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum GlobalAudioStateEnum extends Enum<GlobalAudioStateEnum> {
    public static final GlobalAudioStateEnum NONE = null;
    public static final GlobalAudioStateEnum PAUSED = null;
    public static final GlobalAudioStateEnum PLAYING = null;
    public static final GlobalAudioStateEnum STOPPED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ GlobalAudioStateEnum[] f289660a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f289661b = null;
    private final int num;

    public static EnumEntries<GlobalAudioStateEnum> getEntries() {
        return f289661b;
    }

    static {
        GlobalAudioStateEnum r100 = new GlobalAudioStateEnum(UserProfileEvent.POSITION_NONE, 0, 0);
        NONE = r100;
        GlobalAudioStateEnum r101 = new GlobalAudioStateEnum("STOPPED", 1, 1);
        STOPPED = r101;
        GlobalAudioStateEnum r102 = new GlobalAudioStateEnum("PAUSED", 2, 2);
        PAUSED = r102;
        GlobalAudioStateEnum r103 = new GlobalAudioStateEnum("PLAYING", 3, 3);
        PLAYING = r103;
        GlobalAudioStateEnum[] r104 = {r100, r101, r102, r103};
        f289660a = r104;
        f289661b = EnumEntriesKt.enumEntries(r104);
    }

    public static GlobalAudioStateEnum[] values() {
        return (GlobalAudioStateEnum[]) f289660a.clone();
    }

    public final int getNum() {
        return this.num;
    }

    public static GlobalAudioStateEnum valueOf(String r100) {
        return (GlobalAudioStateEnum) a.a(GlobalAudioStateEnum.class, r100);
    }

    public GlobalAudioStateEnum(String r100, int r101, int r102) {
        super(r100, r101);
        this.num = r102;
    }
}
