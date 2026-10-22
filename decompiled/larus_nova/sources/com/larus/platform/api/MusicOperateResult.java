package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/api/MusicOperateResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "REJECT", "CANCEL", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MusicOperateResult extends Enum<MusicOperateResult> {
    public static final MusicOperateResult CANCEL = null;
    public static final MusicOperateResult REJECT = null;
    public static final MusicOperateResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MusicOperateResult[] f364828a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364829b = null;

    public static EnumEntries<MusicOperateResult> getEntries() {
        return f364829b;
    }

    static {
        MusicOperateResult r100 = new MusicOperateResult("SUCCESS", 0);
        SUCCESS = r100;
        MusicOperateResult r101 = new MusicOperateResult("REJECT", 1);
        REJECT = r101;
        MusicOperateResult r102 = new MusicOperateResult("CANCEL", 2);
        CANCEL = r102;
        MusicOperateResult[] r103 = {r100, r101, r102};
        f364828a = r103;
        f364829b = EnumEntriesKt.enumEntries(r103);
    }

    public static MusicOperateResult[] values() {
        return (MusicOperateResult[]) f364828a.clone();
    }

    public static MusicOperateResult valueOf(String r100) {
        return (MusicOperateResult) r27.a.a(MusicOperateResult.class, r100);
    }

    public MusicOperateResult(String r100, int r101) {
        super(r100, r101);
    }
}
