package com.larus.platform.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/model/LarkSocialSnapshotState;", "", "<init>", "(Ljava/lang/String;I)V", "UNKNOWN", "READY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LarkSocialSnapshotState extends Enum<LarkSocialSnapshotState> {
    public static final LarkSocialSnapshotState READY = null;
    public static final LarkSocialSnapshotState UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LarkSocialSnapshotState[] f365460a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365461b = null;

    public static EnumEntries<LarkSocialSnapshotState> getEntries() {
        return f365461b;
    }

    static {
        LarkSocialSnapshotState r100 = new LarkSocialSnapshotState("UNKNOWN", 0);
        UNKNOWN = r100;
        LarkSocialSnapshotState r101 = new LarkSocialSnapshotState("READY", 1);
        READY = r101;
        LarkSocialSnapshotState[] r102 = {r100, r101};
        f365460a = r102;
        f365461b = EnumEntriesKt.enumEntries(r102);
    }

    public static LarkSocialSnapshotState[] values() {
        return (LarkSocialSnapshotState[]) f365460a.clone();
    }

    public static LarkSocialSnapshotState valueOf(String r100) {
        return (LarkSocialSnapshotState) a.a(LarkSocialSnapshotState.class, r100);
    }

    public LarkSocialSnapshotState(String r100, int r101) {
        super(r100, r101);
    }
}
