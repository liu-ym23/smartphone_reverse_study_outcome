package com.larus.chat.gallery.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/chat/gallery/api/PreviewSendFailureReason;", "", "<init>", "(Ljava/lang/String;I)V", "NOT_SUPPORTED", "EMPTY_SELECTION", "NOT_SENDABLE", "MATERIALIZE_FAILED", "HOST_UNAVAILABLE", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PreviewSendFailureReason extends Enum<PreviewSendFailureReason> {
    public static final PreviewSendFailureReason EMPTY_SELECTION = null;
    public static final PreviewSendFailureReason HOST_UNAVAILABLE = null;
    public static final PreviewSendFailureReason MATERIALIZE_FAILED = null;
    public static final PreviewSendFailureReason NOT_SENDABLE = null;
    public static final PreviewSendFailureReason NOT_SUPPORTED = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewSendFailureReason[] f324118a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f324119b = null;

    public static EnumEntries<PreviewSendFailureReason> getEntries() {
        return f324119b;
    }

    static {
        PreviewSendFailureReason r100 = new PreviewSendFailureReason("NOT_SUPPORTED", 0);
        NOT_SUPPORTED = r100;
        PreviewSendFailureReason r101 = new PreviewSendFailureReason("EMPTY_SELECTION", 1);
        EMPTY_SELECTION = r101;
        PreviewSendFailureReason r102 = new PreviewSendFailureReason("NOT_SENDABLE", 2);
        NOT_SENDABLE = r102;
        PreviewSendFailureReason r103 = new PreviewSendFailureReason("MATERIALIZE_FAILED", 3);
        MATERIALIZE_FAILED = r103;
        PreviewSendFailureReason r104 = new PreviewSendFailureReason("HOST_UNAVAILABLE", 4);
        HOST_UNAVAILABLE = r104;
        PreviewSendFailureReason[] r105 = {r100, r101, r102, r103, r104};
        f324118a = r105;
        f324119b = EnumEntriesKt.enumEntries(r105);
    }

    public static PreviewSendFailureReason[] values() {
        return (PreviewSendFailureReason[]) f324118a.clone();
    }

    public static PreviewSendFailureReason valueOf(String r100) {
        return (PreviewSendFailureReason) r27.a.a(PreviewSendFailureReason.class, r100);
    }

    public PreviewSendFailureReason(String r100, int r101) {
        super(r100, r101);
    }
}
