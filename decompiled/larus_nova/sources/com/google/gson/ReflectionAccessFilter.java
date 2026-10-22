package com.google.gson;

/* JADX INFO: loaded from: classes6.dex */
public interface ReflectionAccessFilter {
    public static final ReflectionAccessFilter BLOCK_ALL_ANDROID = null;
    public static final ReflectionAccessFilter BLOCK_ALL_JAVA = null;
    public static final ReflectionAccessFilter BLOCK_ALL_PLATFORM = null;
    public static final ReflectionAccessFilter BLOCK_INACCESSIBLE_JAVA = null;

    /* JADX INFO: loaded from: classes.dex */
    public static final enum FilterResult extends Enum<FilterResult> {
        private static final /* synthetic */ FilterResult[] $VALUES = null;
        public static final FilterResult ALLOW = null;
        public static final FilterResult BLOCK_ALL = null;
        public static final FilterResult BLOCK_INACCESSIBLE = null;
        public static final FilterResult INDECISIVE = null;

        static {
            FilterResult r100 = new FilterResult("ALLOW", 0);
            ALLOW = r100;
            FilterResult r101 = new FilterResult("INDECISIVE", 1);
            INDECISIVE = r101;
            FilterResult r102 = new FilterResult("BLOCK_INACCESSIBLE", 2);
            BLOCK_INACCESSIBLE = r102;
            FilterResult r103 = new FilterResult("BLOCK_ALL", 3);
            BLOCK_ALL = r103;
            $VALUES = new FilterResult[]{r100, r101, r102, r103};
        }

        public static FilterResult[] values() {
            return (FilterResult[]) $VALUES.clone();
        }

        public static FilterResult valueOf(String r100) {
            return (FilterResult) Enum.valueOf(FilterResult.class, r100);
        }

        private FilterResult(String r100, int r101) {
            super(r100, r101);
        }
    }

    FilterResult check(Class<?> r100);

    static {
        BLOCK_INACCESSIBLE_JAVA = new AnonymousClass1();
        BLOCK_ALL_JAVA = new AnonymousClass2();
        BLOCK_ALL_ANDROID = new AnonymousClass3();
        BLOCK_ALL_PLATFORM = new AnonymousClass4();
    }
}
