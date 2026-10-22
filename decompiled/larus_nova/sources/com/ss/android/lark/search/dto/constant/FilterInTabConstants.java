package com.ss.android.lark.search.dto.constant;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public final class FilterInTabConstants {

    @Retention(RetentionPolicy.SOURCE)
    public @interface FilterInTabType {
        public static final int DOC_CHAT = 33;
        public static final int DOC_FORMAT = 35;
        public static final int DOC_FROM = 39;
        public static final int DOC_MATCH_SCOPE = 37;
        public static final int DOC_MINE = 30;
        public static final int DOC_OWNER = 31;
        public static final int DOC_SHARER = 32;
        public static final int DOC_SORT = 38;
        public static final int DOC_TYPE = 34;
        public static final int DOC_VIEW_TIME = 36;
        public static final int GROUP_MEMBER = 51;
        public static final int GROUP_SORT = 52;
        public static final int GROUP_TYPE = 50;
        public static final int MSG_AT_ME = 14;
        public static final int MSG_CHAT = 11;
        public static final int MSG_HIDE_BOT = 15;
        public static final int MSG_SENDER = 10;
        public static final int MSG_SEND_TIME = 13;
        public static final int MSG_TYPE = 12;
        public static final int SMART_CHAT = 2;
        public static final int SMART_MAIL_USER = 4;
        public static final int SMART_TIME = 3;
        public static final int SMART_USER = 1;
        public static final int UNKNOW = 0;
    }

    public static final enum RecommendFilterStrategyInfo extends Enum<RecommendFilterStrategyInfo> {
        public static final RecommendFilterStrategyInfo BasedOnQuery = null;
        public static final RecommendFilterStrategyInfo BasedOnSearchResults = null;
        public static final RecommendFilterStrategyInfo UnknownStrategy = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RecommendFilterStrategyInfo[] f440133a = null;
        private final int value;

        static {
            RecommendFilterStrategyInfo r100 = new RecommendFilterStrategyInfo("UnknownStrategy", 0, 0);
            UnknownStrategy = r100;
            RecommendFilterStrategyInfo r101 = new RecommendFilterStrategyInfo("BasedOnQuery", 1, 1);
            BasedOnQuery = r101;
            RecommendFilterStrategyInfo r102 = new RecommendFilterStrategyInfo("BasedOnSearchResults", 2, 2);
            BasedOnSearchResults = r102;
            f440133a = new RecommendFilterStrategyInfo[]{r100, r101, r102};
        }

        public static RecommendFilterStrategyInfo[] values() {
            return (RecommendFilterStrategyInfo[]) f440133a.clone();
        }

        public int getNumber() {
            return this.value;
        }

        public static RecommendFilterStrategyInfo forNumber(int r100) {
            if (r100 == 1) goto L11;
            if (r100 == 2) goto L9;
            return UnknownStrategy;
        L9:
            return BasedOnSearchResults;
        L11:
            return BasedOnQuery;
        }

        public static RecommendFilterStrategyInfo valueOf(String r100) {
            return (RecommendFilterStrategyInfo) a.a(RecommendFilterStrategyInfo.class, r100);
        }

        public static RecommendFilterStrategyInfo valueOf(int r100) {
            return forNumber(r100);
        }

        public RecommendFilterStrategyInfo(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public static int a(int r100) {
        int r101 = 1;
        if (r100 == 1) goto L53;
        r101 = 2;
        if (r100 == 2) goto L53;
        r101 = 3;
        if (r100 == 3) goto L53;
        r101 = 4;
        if (r100 == 4) goto L53;
        switch(r100) {
            case 10: goto L51;
            case 11: goto L49;
            case 12: goto L47;
            case 13: goto L45;
            case 14: goto L43;
            case 15: goto L41;
            default: goto L11;
        };
    L11:
        switch(r100) {
            case 30: goto L39;
            case 31: goto L37;
            case 32: goto L35;
            case 33: goto L33;
            case 34: goto L31;
            case 35: goto L29;
            case 36: goto L27;
            case 37: goto L25;
            case 38: goto L23;
            case 39: goto L21;
            default: goto L12;
        };
    L12:
        switch(r100) {
            case 50: goto L19;
            case 51: goto L17;
            case 52: goto L15;
            default: goto L13;
        };
    L13:
        return 0;
    L15:
        return 52;
    L17:
        return 51;
    L19:
        return 50;
    L21:
        return 39;
    L23:
        return 38;
    L25:
        return 37;
    L27:
        return 36;
    L29:
        return 35;
    L31:
        return 34;
    L33:
        return 33;
    L35:
        return 32;
    L37:
        return 31;
    L39:
        return 30;
    L41:
        return 15;
    L43:
        return 14;
    L45:
        return 13;
    L47:
        return 12;
    L49:
        return 11;
    L51:
        return 10;
    L53:
        return r101;
    }
}
