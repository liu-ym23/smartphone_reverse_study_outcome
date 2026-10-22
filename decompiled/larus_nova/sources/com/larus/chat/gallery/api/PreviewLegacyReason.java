package com.larus.chat.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/chat/gallery/api/PreviewLegacyReason;", "", "<init>", "(Ljava/lang/String;I)V", "CONFIG_DISABLED", "ENTRY_EXCLUDED", "SOURCE_NODE_MISSING", "HOST_UNAVAILABLE", "EMPTY_ITEMS", "INVALID_ITEMS", "INVALID_POSITION", "CAPABILITY_MISMATCH", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewLegacyReason extends Enum<PreviewLegacyReason> {
    public static final PreviewLegacyReason CAPABILITY_MISMATCH = null;
    public static final PreviewLegacyReason CONFIG_DISABLED = null;
    public static final PreviewLegacyReason EMPTY_ITEMS = null;
    public static final PreviewLegacyReason ENTRY_EXCLUDED = null;
    public static final PreviewLegacyReason HOST_UNAVAILABLE = null;
    public static final PreviewLegacyReason INVALID_ITEMS = null;
    public static final PreviewLegacyReason INVALID_POSITION = null;
    public static final PreviewLegacyReason SOURCE_NODE_MISSING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewLegacyReason[] f324108a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324109b = null;

    public static EnumEntries<PreviewLegacyReason> getEntries() {
        return f324109b;
    }

    static {
        PreviewLegacyReason r100 = new PreviewLegacyReason("CONFIG_DISABLED", 0);
        CONFIG_DISABLED = r100;
        PreviewLegacyReason r101 = new PreviewLegacyReason("ENTRY_EXCLUDED", 1);
        ENTRY_EXCLUDED = r101;
        PreviewLegacyReason r102 = new PreviewLegacyReason("SOURCE_NODE_MISSING", 2);
        SOURCE_NODE_MISSING = r102;
        PreviewLegacyReason r103 = new PreviewLegacyReason("HOST_UNAVAILABLE", 3);
        HOST_UNAVAILABLE = r103;
        PreviewLegacyReason r104 = new PreviewLegacyReason("EMPTY_ITEMS", 4);
        EMPTY_ITEMS = r104;
        PreviewLegacyReason r105 = new PreviewLegacyReason("INVALID_ITEMS", 5);
        INVALID_ITEMS = r105;
        PreviewLegacyReason r110 = new PreviewLegacyReason("INVALID_POSITION", 6);
        INVALID_POSITION = r110;
        PreviewLegacyReason r111 = new PreviewLegacyReason("CAPABILITY_MISMATCH", 7);
        CAPABILITY_MISMATCH = r111;
        PreviewLegacyReason[] r112 = {r100, r101, r102, r103, r104, r105, r110, r111};
        f324108a = r112;
        f324109b = EnumEntriesKt.enumEntries(r112);
    }

    public static PreviewLegacyReason[] values() {
        return (PreviewLegacyReason[]) f324108a.clone();
    }

    public static PreviewLegacyReason valueOf(String r100) {
        return (PreviewLegacyReason) r27.a.a(PreviewLegacyReason.class, r100);
    }

    public PreviewLegacyReason(String r100, int r101) {
        super(r100, r101);
    }
}
