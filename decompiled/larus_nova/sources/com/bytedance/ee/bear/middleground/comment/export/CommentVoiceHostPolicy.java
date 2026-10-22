package com.bytedance.ee.bear.middleground.comment.export;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes18.dex */
public final class CommentVoiceHostPolicy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f231338a = 0;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/ee/bear/middleground/comment/export/CommentVoiceHostPolicy$Route;", "", "<init>", "(Ljava/lang/String;I)V", "DISABLED", "LARK_IM", "UNIFIED_COMPONENT", "middleground-comment-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Route extends Enum<Route> {
        public static final Route DISABLED = null;
        public static final Route LARK_IM = null;
        public static final Route UNIFIED_COMPONENT = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Route[] f231339a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f231340b = null;

        public static EnumEntries<Route> getEntries() {
            return f231340b;
        }

        static {
            Route r100 = new Route("DISABLED", 0);
            DISABLED = r100;
            Route r101 = new Route("LARK_IM", 1);
            LARK_IM = r101;
            Route r102 = new Route("UNIFIED_COMPONENT", 2);
            UNIFIED_COMPONENT = r102;
            Route[] r103 = {r100, r101, r102};
            f231339a = r103;
            f231340b = EnumEntriesKt.enumEntries(r103);
        }

        public static Route[] values() {
            return (Route[]) f231339a.clone();
        }

        public static Route valueOf(String r100) {
            return (Route) r27.a.a(Route.class, r100);
        }

        public Route(String r100, int r101) {
            super(r100, r101);
        }
    }

    static {
    }
}
