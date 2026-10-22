package com.bytedance.ee.bear.document.ai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/DocAIAvailabilityStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PRECHECK_DISABLED", "WAITING_FRONTEND", "ENABLED", "DISABLED", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocAIAvailabilityStatus extends Enum<DocAIAvailabilityStatus> {
    public static final DocAIAvailabilityStatus DISABLED = null;
    public static final DocAIAvailabilityStatus ENABLED = null;
    public static final DocAIAvailabilityStatus PRECHECK_DISABLED = null;
    public static final DocAIAvailabilityStatus WAITING_FRONTEND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DocAIAvailabilityStatus[] f218719a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f218720b = null;

    public static EnumEntries<DocAIAvailabilityStatus> getEntries() {
        return f218720b;
    }

    static {
        DocAIAvailabilityStatus r100 = new DocAIAvailabilityStatus("PRECHECK_DISABLED", 0);
        PRECHECK_DISABLED = r100;
        DocAIAvailabilityStatus r101 = new DocAIAvailabilityStatus("WAITING_FRONTEND", 1);
        WAITING_FRONTEND = r101;
        DocAIAvailabilityStatus r102 = new DocAIAvailabilityStatus("ENABLED", 2);
        ENABLED = r102;
        DocAIAvailabilityStatus r103 = new DocAIAvailabilityStatus("DISABLED", 3);
        DISABLED = r103;
        DocAIAvailabilityStatus[] r104 = {r100, r101, r102, r103};
        f218719a = r104;
        f218720b = EnumEntriesKt.enumEntries(r104);
    }

    public static DocAIAvailabilityStatus[] values() {
        return (DocAIAvailabilityStatus[]) f218719a.clone();
    }

    public static DocAIAvailabilityStatus valueOf(String r100) {
        return (DocAIAvailabilityStatus) a.a(DocAIAvailabilityStatus.class, r100);
    }

    public DocAIAvailabilityStatus(String r100, int r101) {
        super(r100, r101);
    }
}
