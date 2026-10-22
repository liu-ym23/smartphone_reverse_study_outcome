package lf5;

import com.bytedance.ee.bear.middleground.comment.export.reaction.ReactionFlowCacheEntity;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f509057b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile b f509058c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, Set<ReactionFlowCacheEntity>> f509059a;

    public static final class a {
        public a() {
        }
    }

    /* JADX INFO: renamed from: lf5.b$b, reason: collision with other inner class name */
    public /* synthetic */ class C6689b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f509060a = null;

        static {
            int[] r100 = new int[ReactionFlowCacheEntity.STATUS.values().length];
            r100[ReactionFlowCacheEntity.STATUS.ADD.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[ReactionFlowCacheEntity.STATUS.DELETE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f509060a = r100;
        }
    }

    static {
        f509057b = new a();
    }

    public b() {
        this.f509059a = new LinkedHashMap();
    }

    public static String a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        Intrinsics.checkNotNullParameter(r101, "replyId");
        return r100 + ':' + r101;
    }
}
