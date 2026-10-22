package com.larus.im.internal.audio.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/larus/im/internal/audio/ability/SessionReleaseReason;", "", "reasonName", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getReasonName", "()Ljava/lang/String;", "Normal", "ConnectingTimeLimit", "InterviewHangup", "ForceRelease", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum SessionReleaseReason extends Enum<SessionReleaseReason> {
    public static final SessionReleaseReason ConnectingTimeLimit = null;
    public static final SessionReleaseReason ForceRelease = null;
    public static final SessionReleaseReason InterviewHangup = null;
    public static final SessionReleaseReason Normal = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ SessionReleaseReason[] f347173a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f347174b = null;
    private final String reasonName;

    public static EnumEntries<SessionReleaseReason> getEntries() {
        return f347174b;
    }

    static {
        SessionReleaseReason r100 = new SessionReleaseReason("Normal", 0, "normal");
        Normal = r100;
        SessionReleaseReason r101 = new SessionReleaseReason("ConnectingTimeLimit", 1, "connecting_timeout");
        ConnectingTimeLimit = r101;
        SessionReleaseReason r102 = new SessionReleaseReason("InterviewHangup", 2, "interview_hangup");
        InterviewHangup = r102;
        SessionReleaseReason r103 = new SessionReleaseReason("ForceRelease", 3, "force_release");
        ForceRelease = r103;
        SessionReleaseReason[] r104 = {r100, r101, r102, r103};
        f347173a = r104;
        f347174b = EnumEntriesKt.enumEntries(r104);
    }

    public static SessionReleaseReason[] values() {
        return (SessionReleaseReason[]) f347173a.clone();
    }

    public final String getReasonName() {
        return this.reasonName;
    }

    public static SessionReleaseReason valueOf(String r100) {
        return (SessionReleaseReason) a.a(SessionReleaseReason.class, r100);
    }

    public SessionReleaseReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.reasonName = r102;
    }
}
