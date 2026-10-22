package com.bytedance.ee.bear.doccomponent.api.entity.contentevent;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;
import qz4.d;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final class DCLoadStateChangedEvent implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LoadState f218463a;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ee/bear/doccomponent/api/entity/contentevent/DCLoadStateChangedEvent$LoadState;", "", "<init>", "(Ljava/lang/String;I)V", "Loading", "LoadSuccess", "LoadFail", "LoadFailAndReplaceDocFragment", "docs-document-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum LoadState extends Enum<LoadState> {
        public static final LoadState LoadFail = null;
        public static final LoadState LoadFailAndReplaceDocFragment = null;
        public static final LoadState LoadSuccess = null;
        public static final LoadState Loading = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadState[] f218464a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f218465b = null;

        public static EnumEntries<LoadState> getEntries() {
            return f218465b;
        }

        static {
            LoadState r100 = new LoadState("Loading", 0);
            Loading = r100;
            LoadState r101 = new LoadState("LoadSuccess", 1);
            LoadSuccess = r101;
            LoadState r102 = new LoadState("LoadFail", 2);
            LoadFail = r102;
            LoadState r103 = new LoadState("LoadFailAndReplaceDocFragment", 3);
            LoadFailAndReplaceDocFragment = r103;
            LoadState[] r104 = {r100, r101, r102, r103};
            f218464a = r104;
            f218465b = EnumEntriesKt.enumEntries(r104);
        }

        public static LoadState[] values() {
            return (LoadState[]) f218464a.clone();
        }

        public static LoadState valueOf(String r100) {
            return (LoadState) a.a(LoadState.class, r100);
        }

        public LoadState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final String toString() {
        return "LoadStateChangedEvent{loadState=" + this.f218463a + '}';
    }

    public DCLoadStateChangedEvent(LoadState r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
        this.f218463a = r100;
    }
}
