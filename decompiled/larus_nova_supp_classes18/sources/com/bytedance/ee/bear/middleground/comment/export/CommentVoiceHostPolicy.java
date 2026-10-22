package com.bytedance.ee.bear.middleground.comment.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class CommentVoiceHostPolicy {
    public static final /* synthetic */ int a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/CommentVoiceHostPolicy$Route;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "LARK_IM", "UNIFIED_COMPONENT", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Route extends Enum<Route> {
        public static final Route DISABLED = null;
        public static final Route LARK_IM = null;
        public static final Route UNIFIED_COMPONENT = null;
        public static final /* synthetic */ Route[] a = null;
        public static final /* synthetic */ EnumEntries b = null;

        public static EnumEntries<Route> getEntries() {
            return b;
        }

        static {
            Route r0 = new Route("DISABLED", 0);
            DISABLED = r0;
            Route r1 = new Route("LARK_IM", 1);
            LARK_IM = r1;
            Route r3 = new Route("UNIFIED_COMPONENT", 2);
            UNIFIED_COMPONENT = r3;
            Route[] r5 = {r0, r1, r3};
            a = r5;
            b = EnumEntriesKt.enumEntries(r5);
        }

        public static Route[] values() {
            return (Route[]) a.clone();
        }

        public static Route valueOf(String r1) {
            return (Route) r27.a.a(Route.class, r1);
        }

        public Route(String r1, int r2) {
            super(r1, r2);
        }
    }

    static {
    }
}
