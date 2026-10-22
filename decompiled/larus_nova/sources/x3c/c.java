package x3c;

import com.ss.android.lark.search.dto.constant.FilterInTabConstants;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f562418a;

    public static final class a extends c {
        public a() {
            new ArrayList();
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public List<? extends SearchBaseInfo> f562419b;

        public b() {
            new ArrayList();
        }
    }

    /* JADX INFO: renamed from: x3c.c$c, reason: collision with other inner class name */
    public static final class C8193c extends c {
        public C8193c() {
        }
    }

    public c() {
        FilterInTabConstants.RecommendFilterStrategyInfo r100 = FilterInTabConstants.RecommendFilterStrategyInfo.UnknownStrategy;
    }

    public final int getType() {
        return this.f562418a;
    }
}
