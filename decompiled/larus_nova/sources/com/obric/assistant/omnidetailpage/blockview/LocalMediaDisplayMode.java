package com.obric.assistant.omnidetailpage.blockview;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/obric/assistant/omnidetailpage/blockview/LocalMediaDisplayMode;", "", "<init>", "(Ljava/lang/String;I)V", "HORIZONTAL", "VERTICAL", "card_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final enum LocalMediaDisplayMode extends Enum<LocalMediaDisplayMode> {
    public static final LocalMediaDisplayMode HORIZONTAL = null;
    public static final LocalMediaDisplayMode VERTICAL = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LocalMediaDisplayMode[] f390556a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f390557b = null;

    public static EnumEntries<LocalMediaDisplayMode> getEntries() {
        return f390557b;
    }

    static {
        LocalMediaDisplayMode r100 = new LocalMediaDisplayMode("HORIZONTAL", 0);
        HORIZONTAL = r100;
        LocalMediaDisplayMode r101 = new LocalMediaDisplayMode("VERTICAL", 1);
        VERTICAL = r101;
        LocalMediaDisplayMode[] r102 = {r100, r101};
        f390556a = r102;
        f390557b = EnumEntriesKt.enumEntries(r102);
    }

    public static LocalMediaDisplayMode[] values() {
        return (LocalMediaDisplayMode[]) f390556a.clone();
    }

    public static LocalMediaDisplayMode valueOf(String r100) {
        return (LocalMediaDisplayMode) r27.a.a(LocalMediaDisplayMode.class, r100);
    }

    public LocalMediaDisplayMode(String r100, int r101) {
        super(r100, r101);
    }
}
