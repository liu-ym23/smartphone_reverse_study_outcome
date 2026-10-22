package lf5;

import com.bytedance.ee.bear.middleground.comment.export.reaction.ReactionFlowCacheEntity;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public static final a b = null;
    public static volatile b c;
    public final Map<String, Set<ReactionFlowCacheEntity>> a;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: lf5.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C0259b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ReactionFlowCacheEntity.STATUS.values().length];
            r0[ReactionFlowCacheEntity.STATUS.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[ReactionFlowCacheEntity.STATUS.DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
        b = new a();
    }

    public b() {
        this.a = new LinkedHashMap();
    }

    public static String a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "commentId");
        Intrinsics.checkNotNullParameter(r2, "replyId");
        return r1 + ':' + r2;
    }
}
