package com.larus.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/media/MediaState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "DEFAULT", "PAUSED", "INVALID", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MediaState extends Enum<MediaState> {
    public static final MediaState DEFAULT = null;
    public static final MediaState INVALID = null;
    public static final MediaState PAUSED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaState[] f358961a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358962b = null;

    public static EnumEntries<MediaState> getEntries() {
        return f358962b;
    }

    static {
        MediaState r100 = new MediaState("DEFAULT", 0);
        DEFAULT = r100;
        MediaState r101 = new MediaState("PAUSED", 1);
        PAUSED = r101;
        MediaState r102 = new MediaState("INVALID", 2);
        INVALID = r102;
        MediaState[] r103 = {r100, r101, r102};
        f358961a = r103;
        f358962b = EnumEntriesKt.enumEntries(r103);
    }

    public static MediaState[] values() {
        return (MediaState[]) f358961a.clone();
    }

    public static MediaState valueOf(String r100) {
        return (MediaState) r27.a.a(MediaState.class, r100);
    }

    public MediaState(String r100, int r101) {
        super(r100, r101);
    }
}
