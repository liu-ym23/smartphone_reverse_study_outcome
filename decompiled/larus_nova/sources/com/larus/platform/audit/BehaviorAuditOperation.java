package com.larus.platform.audit;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/platform/audit/BehaviorAuditOperation;", "", "<init>", "(Ljava/lang/String;I)V", "COPY", HttpMethod.DOWNLOAD, "SHARE_TO_THIRD_PARTY", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum BehaviorAuditOperation extends Enum<BehaviorAuditOperation> {
    public static final BehaviorAuditOperation COPY = null;
    public static final BehaviorAuditOperation DOWNLOAD = null;
    public static final BehaviorAuditOperation SHARE_TO_THIRD_PARTY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BehaviorAuditOperation[] f365318a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f365319b = null;

    public static EnumEntries<BehaviorAuditOperation> getEntries() {
        return f365319b;
    }

    static {
        BehaviorAuditOperation r100 = new BehaviorAuditOperation("COPY", 0);
        COPY = r100;
        BehaviorAuditOperation r101 = new BehaviorAuditOperation(HttpMethod.DOWNLOAD, 1);
        DOWNLOAD = r101;
        BehaviorAuditOperation r102 = new BehaviorAuditOperation("SHARE_TO_THIRD_PARTY", 2);
        SHARE_TO_THIRD_PARTY = r102;
        BehaviorAuditOperation[] r103 = {r100, r101, r102};
        f365318a = r103;
        f365319b = EnumEntriesKt.enumEntries(r103);
    }

    public static BehaviorAuditOperation[] values() {
        return (BehaviorAuditOperation[]) f365318a.clone();
    }

    public static BehaviorAuditOperation valueOf(String r100) {
        return (BehaviorAuditOperation) r27.a.a(BehaviorAuditOperation.class, r100);
    }

    public BehaviorAuditOperation(String r100, int r101) {
        super(r100, r101);
    }
}
