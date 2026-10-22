package com.bytedance.ee.bear.bitable.card.viewmodel.fetch;

/* JADX INFO: loaded from: classes15.dex */
public interface ICardFetcher {

    public static final enum FetchMode extends Enum<FetchMode> {
        public static final FetchMode FETCH_LEFT = null;
        public static final FetchMode FETCH_ONE = null;
        public static final FetchMode FETCH_RIGHT = null;
        public static final FetchMode FETCH_UPDATE = null;
        public static final FetchMode FETCH_UPDATE_WITHOUTOPT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FetchMode[] f209035a = null;

        static {
            FetchMode r100 = new FetchMode("FETCH_LEFT", 0);
            FETCH_LEFT = r100;
            FetchMode r101 = new FetchMode("FETCH_RIGHT", 1);
            FETCH_RIGHT = r101;
            FetchMode r102 = new FetchMode("FETCH_UPDATE", 2);
            FETCH_UPDATE = r102;
            FetchMode r103 = new FetchMode("FETCH_UPDATE_WITHOUTOPT", 3);
            FETCH_UPDATE_WITHOUTOPT = r103;
            FetchMode r104 = new FetchMode("FETCH_ONE", 4);
            FETCH_ONE = r104;
            f209035a = new FetchMode[]{r100, r101, r102, r103, r104};
        }

        public static FetchMode[] values() {
            return (FetchMode[]) f209035a.clone();
        }

        public static FetchMode valueOf(String r100) {
            return (FetchMode) r27.a.a(FetchMode.class, r100);
        }

        public FetchMode(String r100, int r101) {
            super(r100, r101);
        }
    }
}
