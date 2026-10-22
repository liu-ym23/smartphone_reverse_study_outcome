package com.bytedance.timon_monitor_impl.fuse;

import com.bytedance.timon.pipeline.TimonSystem;
import com.ss.android.lark.search.dto.constant.SearchCommonConstants;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements TimonSystem {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, String> f270754a = null;

    public static final class a {
    }

    static {
        f270754a = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.valueOf(SearchCommonConstants.SearchResultType.FILE), "importanceReasonComponent"), TuplesKt.to(Integer.valueOf(SearchCommonConstants.SearchResultType.SHOW_MORE), "importanceReasonPid")});
    }
}
