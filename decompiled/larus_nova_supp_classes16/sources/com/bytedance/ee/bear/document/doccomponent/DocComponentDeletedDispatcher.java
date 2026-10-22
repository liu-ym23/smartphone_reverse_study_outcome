package com.bytedance.ee.bear.document.doccomponent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DocComponentDeletedDispatcher {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/doccomponent/DocComponentDeletedDispatcher$DispatchResult;", "", "<init>", "(Ljava/lang/String;I)V", "LegacyDispatched", "V3Terminated", "Ignored", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DispatchResult extends Enum<DispatchResult> {
        public static final DispatchResult Ignored = null;
        public static final DispatchResult LegacyDispatched = null;
        public static final DispatchResult V3Terminated = null;
        public static final /* synthetic */ DispatchResult[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<DispatchResult> getEntries() {
            return b;
        }

        static {
            DispatchResult r0 = new DispatchResult("LegacyDispatched", 0);
            LegacyDispatched = r0;
            DispatchResult r1 = new DispatchResult("V3Terminated", 1);
            V3Terminated = r1;
            DispatchResult r3 = new DispatchResult("Ignored", 2);
            Ignored = r3;
            DispatchResult[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static DispatchResult[] values() {
            return (DispatchResult[]) a.clone();
        }

        public static DispatchResult valueOf(String r1) {
            return (DispatchResult) a.a(DispatchResult.class, r1);
        }

        public DispatchResult(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
    }
}
