package org.jsoup.select;

/* JADX INFO: loaded from: classes42.dex */
public interface NodeFilter {

    public static final enum FilterResult extends Enum<FilterResult> {
        public static final FilterResult CONTINUE = null;
        public static final FilterResult REMOVE = null;
        public static final FilterResult SKIP_CHILDREN = null;
        public static final FilterResult SKIP_ENTIRELY = null;
        public static final FilterResult STOP = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FilterResult[] f526078a = null;

        static {
            FilterResult r100 = new FilterResult("CONTINUE", 0);
            CONTINUE = r100;
            FilterResult r101 = new FilterResult("SKIP_CHILDREN", 1);
            SKIP_CHILDREN = r101;
            FilterResult r102 = new FilterResult("SKIP_ENTIRELY", 2);
            SKIP_ENTIRELY = r102;
            FilterResult r103 = new FilterResult("REMOVE", 3);
            REMOVE = r103;
            FilterResult r104 = new FilterResult("STOP", 4);
            STOP = r104;
            f526078a = new FilterResult[]{r100, r101, r102, r103, r104};
        }

        public static FilterResult[] values() {
            return (FilterResult[]) f526078a.clone();
        }

        public static FilterResult valueOf(String r100) {
            return (FilterResult) r27.a.a(FilterResult.class, r100);
        }

        public FilterResult(String r100, int r101) {
            super(r100, r101);
        }
    }
}
