package com.bytedance.ee.bear.document.ai;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/document/ai/DocAIAvailabilityStatus;", "", "<init>", "(Ljava/lang/String;I)V", "PRECHECK_DISABLED", "WAITING_FRONTEND", "ENABLED", "DISABLED", "docs-document-sdk-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DocAIAvailabilityStatus extends Enum<DocAIAvailabilityStatus> {
    public static final DocAIAvailabilityStatus DISABLED = null;
    public static final DocAIAvailabilityStatus ENABLED = null;
    public static final DocAIAvailabilityStatus PRECHECK_DISABLED = null;
    public static final DocAIAvailabilityStatus WAITING_FRONTEND = null;
    public static final /* synthetic */ DocAIAvailabilityStatus[] a = null;
    public static final /* synthetic */ EnumEntries b = null;

    public static EnumEntries<DocAIAvailabilityStatus> getEntries() {
        return b;
    }

    static {
        DocAIAvailabilityStatus r0 = new DocAIAvailabilityStatus("PRECHECK_DISABLED", 0);
        PRECHECK_DISABLED = r0;
        DocAIAvailabilityStatus r1 = new DocAIAvailabilityStatus("WAITING_FRONTEND", 1);
        WAITING_FRONTEND = r1;
        DocAIAvailabilityStatus r3 = new DocAIAvailabilityStatus("ENABLED", 2);
        ENABLED = r3;
        DocAIAvailabilityStatus r5 = new DocAIAvailabilityStatus("DISABLED", 3);
        DISABLED = r5;
        DocAIAvailabilityStatus[] r7 = {r0, r1, r3, r5};
        a = r7;
        b = EnumEntriesKt.enumEntries(r7);
    }

    public static DocAIAvailabilityStatus[] values() {
        return (DocAIAvailabilityStatus[]) a.clone();
    }

    public static DocAIAvailabilityStatus valueOf(String r1) {
        return (DocAIAvailabilityStatus) a.a(DocAIAvailabilityStatus.class, r1);
    }

    public DocAIAvailabilityStatus(String r1, int r2) {
        super(r1, r2);
    }
}
