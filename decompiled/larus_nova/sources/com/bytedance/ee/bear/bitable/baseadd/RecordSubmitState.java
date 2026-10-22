package com.bytedance.ee.bear.bitable.baseadd;

import com.ss.android.ugc.effectmanager.common.EffectConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/bitable/baseadd/RecordSubmitState;", "", "<init>", "(Ljava/lang/String;I)V", EffectConstants.NORMAL, "LOADING", "SUCCESS", "FAIL", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum RecordSubmitState extends Enum<RecordSubmitState> {
    public static final RecordSubmitState FAIL = null;
    public static final RecordSubmitState LOADING = null;
    public static final RecordSubmitState NORMAL = null;
    public static final RecordSubmitState SUCCESS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ RecordSubmitState[] f206976a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f206977b = null;

    public static EnumEntries<RecordSubmitState> getEntries() {
        return f206977b;
    }

    static {
        RecordSubmitState r100 = new RecordSubmitState(EffectConstants.NORMAL, 0);
        NORMAL = r100;
        RecordSubmitState r101 = new RecordSubmitState("LOADING", 1);
        LOADING = r101;
        RecordSubmitState r102 = new RecordSubmitState("SUCCESS", 2);
        SUCCESS = r102;
        RecordSubmitState r103 = new RecordSubmitState("FAIL", 3);
        FAIL = r103;
        RecordSubmitState[] r104 = {r100, r101, r102, r103};
        f206976a = r104;
        f206977b = EnumEntriesKt.enumEntries(r104);
    }

    public static RecordSubmitState[] values() {
        return (RecordSubmitState[]) f206976a.clone();
    }

    public static RecordSubmitState valueOf(String r100) {
        return (RecordSubmitState) a.a(RecordSubmitState.class, r100);
    }

    public RecordSubmitState(String r100, int r101) {
        super(r100, r101);
    }
}
