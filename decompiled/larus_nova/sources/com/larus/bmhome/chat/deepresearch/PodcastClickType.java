package com.larus.bmhome.chat.deepresearch;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/bmhome/chat/deepresearch/PodcastClickType;", "", "<init>", "(Ljava/lang/String;I)V", "BUTTON", "ROOT", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PodcastClickType extends Enum<PodcastClickType> {
    public static final PodcastClickType BUTTON = null;
    public static final PodcastClickType ROOT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PodcastClickType[] f302147a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f302148b = null;

    public static EnumEntries<PodcastClickType> getEntries() {
        return f302148b;
    }

    static {
        PodcastClickType r100 = new PodcastClickType("BUTTON", 0);
        BUTTON = r100;
        PodcastClickType r101 = new PodcastClickType("ROOT", 1);
        ROOT = r101;
        PodcastClickType[] r102 = {r100, r101};
        f302147a = r102;
        f302148b = EnumEntriesKt.enumEntries(r102);
    }

    public static PodcastClickType[] values() {
        return (PodcastClickType[]) f302147a.clone();
    }

    public static PodcastClickType valueOf(String r100) {
        return (PodcastClickType) a.a(PodcastClickType.class, r100);
    }

    public PodcastClickType(String r100, int r101) {
        super(r100, r101);
    }
}
