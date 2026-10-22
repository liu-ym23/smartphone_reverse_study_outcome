package com.bytedance.ee.bear.doc.follow.event;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public class LoadStateChangedEvent implements ContentEvent {
    public final LoadState loadState;

    public static final enum LoadState extends Enum<LoadState> {
        public static final LoadState LoadFail = null;
        public static final LoadState LoadFailAndReplaceDocFragment = null;
        public static final LoadState LoadSuccess = null;
        public static final LoadState LoadWikiToReplaceDoc = null;
        public static final LoadState Loading = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ LoadState[] f217895a = null;

        static {
            LoadState r100 = new LoadState("Loading", 0);
            Loading = r100;
            LoadState r101 = new LoadState("LoadSuccess", 1);
            LoadSuccess = r101;
            LoadState r102 = new LoadState("LoadFail", 2);
            LoadFail = r102;
            LoadState r103 = new LoadState("LoadFailAndReplaceDocFragment", 3);
            LoadFailAndReplaceDocFragment = r103;
            LoadState r104 = new LoadState("LoadWikiToReplaceDoc", 4);
            LoadWikiToReplaceDoc = r104;
            f217895a = new LoadState[]{r100, r101, r102, r103, r104};
        }

        public static LoadState[] values() {
            return (LoadState[]) f217895a.clone();
        }

        public static LoadState valueOf(String r100) {
            return (LoadState) a.a(LoadState.class, r100);
        }

        public LoadState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public String toString() {
        return "LoadStateChangedEvent{loadState=" + this.loadState + '}';
    }

    public LoadState getLoadState() {
        return this.loadState;
    }

    public LoadStateChangedEvent(LoadState r100) {
        this.loadState = r100;
    }
}
