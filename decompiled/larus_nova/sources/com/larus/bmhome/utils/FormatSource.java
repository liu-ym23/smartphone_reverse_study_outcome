package com.larus.bmhome.utils;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/larus/bmhome/utils/FormatSource;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "TTS", "COPY", "REALTIME_CALL_SUBTITLE", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum FormatSource extends Enum<FormatSource> {
    public static final FormatSource COPY = null;
    public static final FormatSource REALTIME_CALL_SUBTITLE = null;
    public static final FormatSource TTS = null;
    public static final FormatSource UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FormatSource[] f314895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f314896b = null;

    public static EnumEntries<FormatSource> getEntries() {
        return f314896b;
    }

    static {
        FormatSource r100 = new FormatSource("UNKNOWN", 0);
        UNKNOWN = r100;
        FormatSource r101 = new FormatSource("TTS", 1);
        TTS = r101;
        FormatSource r102 = new FormatSource("COPY", 2);
        COPY = r102;
        FormatSource r103 = new FormatSource("REALTIME_CALL_SUBTITLE", 3);
        REALTIME_CALL_SUBTITLE = r103;
        FormatSource[] r104 = {r100, r101, r102, r103};
        f314895a = r104;
        f314896b = EnumEntriesKt.enumEntries(r104);
    }

    public static FormatSource[] values() {
        return (FormatSource[]) f314895a.clone();
    }

    public static FormatSource valueOf(String r100) {
        return (FormatSource) r27.a.a(FormatSource.class, r100);
    }

    public FormatSource(String r100, int r101) {
        super(r100, r101);
    }
}
