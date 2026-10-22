package com.larus.ugc.feed.api.ability;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/ugc/feed/api/ability/AvatarStatus;", "", "rawValue", "", "<init>", "(Ljava/lang/String;II)V", "getRawValue", "()I", "Unknown", "NotCreated", "Creating", "Created", "Companion", "feed_kmp_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AvatarStatus extends Enum<AvatarStatus> {
    public static final a Companion = null;
    public static final AvatarStatus Created = null;
    public static final AvatarStatus Creating = null;
    public static final AvatarStatus NotCreated = null;
    public static final AvatarStatus Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AvatarStatus[] f374300a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f374301b = null;
    private final int rawValue;

    public static EnumEntries<AvatarStatus> getEntries() {
        return f374301b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.ugc.feed.api.ability.AvatarStatus$a] */
    static {
        AvatarStatus r100 = new AvatarStatus("Unknown", 0, -1);
        Unknown = r100;
        AvatarStatus r101 = new AvatarStatus("NotCreated", 1, 0);
        NotCreated = r101;
        AvatarStatus r102 = new AvatarStatus("Creating", 2, 1);
        Creating = r102;
        AvatarStatus r103 = new AvatarStatus("Created", 3, 2);
        Created = r103;
        AvatarStatus[] r104 = {r100, r101, r102, r103};
        f374300a = r104;
        f374301b = EnumEntriesKt.enumEntries(r104);
        Companion = new a();
    }

    public static AvatarStatus[] values() {
        return (AvatarStatus[]) f374300a.clone();
    }

    public final int getRawValue() {
        return this.rawValue;
    }

    public static AvatarStatus valueOf(String r100) {
        return (AvatarStatus) r27.a.a(AvatarStatus.class, r100);
    }

    public AvatarStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.rawValue = r102;
    }
}
