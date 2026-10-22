package com.larus.audioplayer.api.news;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/audioplayer/api/news/UrlAudioLoadState;", "", "<init>", "(Ljava/lang/String;I)V", "PLAYABLE", "STALLED", "ERROR", "UNKNOWN", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UrlAudioLoadState extends Enum<UrlAudioLoadState> {
    public static final UrlAudioLoadState ERROR = null;
    public static final UrlAudioLoadState PLAYABLE = null;
    public static final UrlAudioLoadState STALLED = null;
    public static final UrlAudioLoadState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UrlAudioLoadState[] f290185a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f290186b = null;

    public static EnumEntries<UrlAudioLoadState> getEntries() {
        return f290186b;
    }

    static {
        UrlAudioLoadState r100 = new UrlAudioLoadState("PLAYABLE", 0);
        PLAYABLE = r100;
        UrlAudioLoadState r101 = new UrlAudioLoadState("STALLED", 1);
        STALLED = r101;
        UrlAudioLoadState r102 = new UrlAudioLoadState("ERROR", 2);
        ERROR = r102;
        UrlAudioLoadState r103 = new UrlAudioLoadState("UNKNOWN", 3);
        UNKNOWN = r103;
        UrlAudioLoadState[] r104 = {r100, r101, r102, r103};
        f290185a = r104;
        f290186b = EnumEntriesKt.enumEntries(r104);
    }

    public static UrlAudioLoadState[] values() {
        return (UrlAudioLoadState[]) f290185a.clone();
    }

    public static UrlAudioLoadState valueOf(String r100) {
        return (UrlAudioLoadState) a.a(UrlAudioLoadState.class, r100);
    }

    public UrlAudioLoadState(String r100, int r101) {
        super(r100, r101);
    }
}
