package com.larus.media;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/media/MediaOccupyStrategy;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "PAUSE", "INTERRUPT", "REJECT", "media_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MediaOccupyStrategy extends Enum<MediaOccupyStrategy> {
    public static final MediaOccupyStrategy INTERRUPT = null;
    public static final MediaOccupyStrategy PAUSE = null;
    public static final MediaOccupyStrategy REJECT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaOccupyStrategy[] f358948a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358949b = null;

    public static EnumEntries<MediaOccupyStrategy> getEntries() {
        return f358949b;
    }

    static {
        MediaOccupyStrategy r100 = new MediaOccupyStrategy("PAUSE", 0);
        PAUSE = r100;
        MediaOccupyStrategy r101 = new MediaOccupyStrategy("INTERRUPT", 1);
        INTERRUPT = r101;
        MediaOccupyStrategy r102 = new MediaOccupyStrategy("REJECT", 2);
        REJECT = r102;
        MediaOccupyStrategy[] r103 = {r100, r101, r102};
        f358948a = r103;
        f358949b = EnumEntriesKt.enumEntries(r103);
    }

    public static MediaOccupyStrategy[] values() {
        return (MediaOccupyStrategy[]) f358948a.clone();
    }

    public static MediaOccupyStrategy valueOf(String r100) {
        return (MediaOccupyStrategy) r27.a.a(MediaOccupyStrategy.class, r100);
    }

    public MediaOccupyStrategy(String r100, int r101) {
        super(r100, r101);
    }
}
