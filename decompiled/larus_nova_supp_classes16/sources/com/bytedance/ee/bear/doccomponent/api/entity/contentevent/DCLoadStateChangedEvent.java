package com.bytedance.ee.bear.doccomponent.api.entity.contentevent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import qz4.d;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class DCLoadStateChangedEvent implements d {
    public final LoadState a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/doccomponent/api/entity/contentevent/DCLoadStateChangedEvent$LoadState;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "LoadSuccess", "LoadFail", "LoadFailAndReplaceDocFragment", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadState extends Enum<LoadState> {
        public static final LoadState LoadFail = null;
        public static final LoadState LoadFailAndReplaceDocFragment = null;
        public static final LoadState LoadSuccess = null;
        public static final LoadState Loading = null;
        public static final /* synthetic */ LoadState[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<LoadState> getEntries() {
            return b;
        }

        static {
            LoadState r0 = new LoadState("Loading", 0);
            Loading = r0;
            LoadState r1 = new LoadState("LoadSuccess", 1);
            LoadSuccess = r1;
            LoadState r3 = new LoadState("LoadFail", 2);
            LoadFail = r3;
            LoadState r5 = new LoadState("LoadFailAndReplaceDocFragment", 3);
            LoadFailAndReplaceDocFragment = r5;
            LoadState[] r7 = {r0, r1, r3, r5};
            a = r7;
            b = EnumEntriesKt.enumEntries(r7);
        }

        public static LoadState[] values() {
            return (LoadState[]) a.clone();
        }

        public static LoadState valueOf(String r1) {
            return (LoadState) a.a(LoadState.class, r1);
        }

        public LoadState(String r1, int r2) {
            super(r1, r2);
        }
    }

    public final String toString() {
        return "LoadStateChangedEvent{loadState=" + this.a + '}';
    }

    public DCLoadStateChangedEvent(LoadState r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
        this.a = r2;
    }
}
