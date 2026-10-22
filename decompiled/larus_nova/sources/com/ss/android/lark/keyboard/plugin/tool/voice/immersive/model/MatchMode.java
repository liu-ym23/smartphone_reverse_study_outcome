package com.ss.android.lark.keyboard.plugin.tool.voice.immersive.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/keyboard/plugin/tool/voice/immersive/model/MatchMode;", "", "mode", "", "<init>", "(Ljava/lang/String;II)V", "ClientMode", "ServerMode", "ServerWithClientMode", "toString", "", "keyboard-biz-voice_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MatchMode extends Enum<MatchMode> {
    public static final MatchMode ClientMode = null;
    public static final MatchMode ServerMode = null;
    public static final MatchMode ServerWithClientMode = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MatchMode[] f430307a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f430308b = null;
    private final int mode;

    public static EnumEntries<MatchMode> getEntries() {
        return f430308b;
    }

    static {
        MatchMode r100 = new MatchMode("ClientMode", 0, 0);
        ClientMode = r100;
        MatchMode r101 = new MatchMode("ServerMode", 1, 1);
        ServerMode = r101;
        MatchMode r102 = new MatchMode("ServerWithClientMode", 2, 2);
        ServerWithClientMode = r102;
        MatchMode[] r103 = {r100, r101, r102};
        f430307a = r103;
        f430308b = EnumEntriesKt.enumEntries(r103);
    }

    public static MatchMode[] values() {
        return (MatchMode[]) f430307a.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        int r100 = this.mode;
        if (r100 != 0) goto L5;
        return "ClientMode";
    L5:
        if (r100 != 1) goto L7;
        return "ServerMode";
    L7:
        if (r100 != 2) goto L14;
        return "ServerWithClientMode";
    L14:
        return "ClientMode";
    }

    public static MatchMode valueOf(String r100) {
        return (MatchMode) r27.a.a(MatchMode.class, r100);
    }

    public MatchMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.mode = r102;
    }
}
