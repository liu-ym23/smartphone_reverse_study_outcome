package com.bytedance.ee.bear.doc.follow.event;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public class LoadStateChangedEvent implements ContentEvent {
    public final LoadState loadState;

    public static final enum LoadState extends Enum<LoadState> {
        public static final LoadState LoadFail = null;
        public static final LoadState LoadFailAndReplaceDocFragment = null;
        public static final LoadState LoadSuccess = null;
        public static final LoadState LoadWikiToReplaceDoc = null;
        public static final LoadState Loading = null;
        public static final /* synthetic */ LoadState[] a = null;

        static {
            LoadState r0 = new LoadState("Loading", 0);
            Loading = r0;
            LoadState r1 = new LoadState("LoadSuccess", 1);
            LoadSuccess = r1;
            LoadState r3 = new LoadState("LoadFail", 2);
            LoadFail = r3;
            LoadState r5 = new LoadState("LoadFailAndReplaceDocFragment", 3);
            LoadFailAndReplaceDocFragment = r5;
            LoadState r7 = new LoadState("LoadWikiToReplaceDoc", 4);
            LoadWikiToReplaceDoc = r7;
            a = new LoadState[]{r0, r1, r3, r5, r7};
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

    public String toString() {
        return "LoadStateChangedEvent{loadState=" + this.loadState + '}';
    }

    public LoadState getLoadState() {
        return this.loadState;
    }

    public LoadStateChangedEvent(LoadState r1) {
        this.loadState = r1;
    }
}
