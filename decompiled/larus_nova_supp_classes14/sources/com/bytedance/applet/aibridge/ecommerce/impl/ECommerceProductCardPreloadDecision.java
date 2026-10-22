package com.bytedance.applet.aibridge.ecommerce.impl;

import java.util.List;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface ECommerceProductCardPreloadDecision {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u000f"}, d2 = {"Lcom/bytedance/applet/aibridge/ecommerce/impl/ECommerceProductCardPreloadDecision$Reason;", "", "logValue", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLogValue", "()Ljava/lang/String;", "EXPERIMENT_DISABLED", "INVALID_CONTEXT", "EMPTY_SCHEMA_LIST", "CARD_THROTTLED", "NOT_LATEST_MESSAGE", "NOT_NEW_MESSAGE", "EXPERIMENT_CHANGED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Reason extends Enum<Reason> {
        public static final Reason CARD_THROTTLED = null;
        public static final Reason EMPTY_SCHEMA_LIST = null;
        public static final Reason EXPERIMENT_CHANGED = null;
        public static final Reason EXPERIMENT_DISABLED = null;
        public static final Reason INVALID_CONTEXT = null;
        public static final Reason NOT_LATEST_MESSAGE = null;
        public static final Reason NOT_NEW_MESSAGE = null;
        public static final /* synthetic */ Reason[] a = null;
        public static final /* synthetic */ EnumEntries b = null;
        private final String logValue;

        public static EnumEntries<Reason> getEntries() {
            return b;
        }

        static {
            Reason r0 = new Reason("EXPERIMENT_DISABLED", 0, "experiment_disabled");
            EXPERIMENT_DISABLED = r0;
            Reason r1 = new Reason("INVALID_CONTEXT", 1, "invalid_context");
            INVALID_CONTEXT = r1;
            Reason r2 = new Reason("EMPTY_SCHEMA_LIST", 2, "empty_schema_list");
            EMPTY_SCHEMA_LIST = r2;
            Reason r4 = new Reason("CARD_THROTTLED", 3, "card_throttled");
            CARD_THROTTLED = r4;
            Reason r6 = new Reason("NOT_LATEST_MESSAGE", 4, "not_latest_message");
            NOT_LATEST_MESSAGE = r6;
            Reason r8 = new Reason("NOT_NEW_MESSAGE", 5, "not_new_message");
            NOT_NEW_MESSAGE = r8;
            Reason r10 = new Reason("EXPERIMENT_CHANGED", 6, "experiment_changed");
            EXPERIMENT_CHANGED = r10;
            Reason[] r12 = {r0, r1, r2, r4, r6, r8, r10};
            a = r12;
            b = EnumEntriesKt.enumEntries(r12);
        }

        public static Reason[] values() {
            return (Reason[]) a.clone();
        }

        public final String getLogValue() {
            return this.logValue;
        }

        public static Reason valueOf(String r1) {
            return (Reason) r27.a.a(Reason.class, r1);
        }

        public Reason(String r1, int r2, String r3) {
            super(r1, r2);
            this.logValue = r3;
        }
    }

    public static final class a implements ECommerceProductCardPreloadDecision {
        public final List<String> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Preloaded(schemaList=" + this.a + ')';
        }

        public a(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "schemaList");
            this.a = r2;
        }
    }

    public static final class b implements ECommerceProductCardPreloadDecision {
        public final Reason a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Skipped(reason=" + this.a + ')';
        }

        public b(Reason r2) {
            Intrinsics.checkNotNullParameter(r2, "reason");
            this.a = r2;
        }
    }
}
