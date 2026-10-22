package com.larus.music;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/music/CommonOperateResult;", "", "<init>", "(Ljava/lang/String;I)V", "SUCCESS", "REJECT", "CANCEL", "music_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CommonOperateResult extends Enum<CommonOperateResult> {
    public static final CommonOperateResult CANCEL = null;
    public static final CommonOperateResult REJECT = null;
    public static final CommonOperateResult SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CommonOperateResult[] f359454a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f359455b = null;

    public static EnumEntries<CommonOperateResult> getEntries() {
        return f359455b;
    }

    static {
        CommonOperateResult r100 = new CommonOperateResult("SUCCESS", 0);
        SUCCESS = r100;
        CommonOperateResult r101 = new CommonOperateResult("REJECT", 1);
        REJECT = r101;
        CommonOperateResult r102 = new CommonOperateResult("CANCEL", 2);
        CANCEL = r102;
        CommonOperateResult[] r103 = {r100, r101, r102};
        f359454a = r103;
        f359455b = EnumEntriesKt.enumEntries(r103);
    }

    public static CommonOperateResult[] values() {
        return (CommonOperateResult[]) f359454a.clone();
    }

    public static CommonOperateResult valueOf(String r100) {
        return (CommonOperateResult) r27.a.a(CommonOperateResult.class, r100);
    }

    public CommonOperateResult(String r100, int r101) {
        super(r100, r101);
    }
}
