package com.bytedance.ee.bear.document.doccomponent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final class DocComponentDeletedDispatcher {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f219518a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/document/doccomponent/DocComponentDeletedDispatcher$DispatchResult;", "", "<init>", "(Ljava/lang/String;I)V", "LegacyDispatched", "V3Terminated", "Ignored", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum DispatchResult extends Enum<DispatchResult> {
        public static final DispatchResult Ignored = null;
        public static final DispatchResult LegacyDispatched = null;
        public static final DispatchResult V3Terminated = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ DispatchResult[] f219519a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f219520b = null;

        public static EnumEntries<DispatchResult> getEntries() {
            return f219520b;
        }

        static {
            DispatchResult r100 = new DispatchResult("LegacyDispatched", 0);
            LegacyDispatched = r100;
            DispatchResult r101 = new DispatchResult("V3Terminated", 1);
            V3Terminated = r101;
            DispatchResult r102 = new DispatchResult("Ignored", 2);
            Ignored = r102;
            DispatchResult[] r103 = {r100, r101, r102};
            f219519a = r103;
            f219520b = EnumEntriesKt.enumEntries(r103);
        }

        public static DispatchResult[] values() {
            return (DispatchResult[]) f219519a.clone();
        }

        public static DispatchResult valueOf(String r100) {
            return (DispatchResult) a.a(DispatchResult.class, r100);
        }

        public DispatchResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }
}
