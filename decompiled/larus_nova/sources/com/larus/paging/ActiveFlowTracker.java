package com.larus.paging;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes29.dex */
public interface ActiveFlowTracker {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/paging/ActiveFlowTracker$FlowType;", "", "PAGED_DATA_FLOW", "PAGE_EVENT_FLOW", "paging-common_release"}, k = 1, mv = {1, 7, 1})
    public static final enum FlowType extends Enum<FlowType> {
        public static final FlowType PAGED_DATA_FLOW = null;
        public static final FlowType PAGE_EVENT_FLOW = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FlowType[] f363636a = null;

        public static FlowType valueOf(String r100) {
            return (FlowType) r27.a.a(FlowType.class, r100);
        }

        public static FlowType[] values() {
            return (FlowType[]) f363636a.clone();
        }

        static {
            FlowType r100 = new FlowType("PAGED_DATA_FLOW", 0);
            PAGED_DATA_FLOW = r100;
            FlowType r101 = new FlowType("PAGE_EVENT_FLOW", 1);
            PAGE_EVENT_FLOW = r101;
            f363636a = new FlowType[]{r100, r101};
        }

        public FlowType(String r100, int r101) {
            super(r100, r101);
        }
    }
}
