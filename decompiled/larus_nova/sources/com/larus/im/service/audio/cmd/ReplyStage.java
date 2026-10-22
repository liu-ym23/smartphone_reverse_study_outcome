package com.larus.im.service.audio.cmd;

import com.bytedance.android.livehostapi.platform.depend.user.UserChangedCallback;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/im/service/audio/cmd/ReplyStage;", "", "<init>", "(Ljava/lang/String;I)V", "Begin", UserChangedCallback.CHANGE_TYPE_UPDATE, "End", "flow-avsdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ReplyStage extends Enum<ReplyStage> {
    public static final ReplyStage Begin = null;
    public static final ReplyStage End = null;
    public static final ReplyStage Update = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ReplyStage[] f350721a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f350722b = null;

    public static EnumEntries<ReplyStage> getEntries() {
        return f350722b;
    }

    static {
        ReplyStage r100 = new ReplyStage("Begin", 0);
        Begin = r100;
        ReplyStage r101 = new ReplyStage(UserChangedCallback.CHANGE_TYPE_UPDATE, 1);
        Update = r101;
        ReplyStage r102 = new ReplyStage("End", 2);
        End = r102;
        ReplyStage[] r103 = {r100, r101, r102};
        f350721a = r103;
        f350722b = EnumEntriesKt.enumEntries(r103);
    }

    public static ReplyStage[] values() {
        return (ReplyStage[]) f350721a.clone();
    }

    public static ReplyStage valueOf(String r100) {
        return (ReplyStage) a.a(ReplyStage.class, r100);
    }

    public ReplyStage(String r100, int r101) {
        super(r100, r101);
    }
}
