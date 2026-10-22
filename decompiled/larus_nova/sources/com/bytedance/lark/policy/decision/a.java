package com.bytedance.lark.policy.decision;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes20.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Map<String, String>> f253794a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f253795b = null;

    static {
        LinkedHashMap r100 = new LinkedHashMap();
        f253794a = r100;
        f253795b = CollectionsKt.listOf(new String[]{"FILE_BLOCK_COMMON", "DLP_CONTENT_DETECTING", "DLP_CONTENT_SENSITIVE", "TT_BLOCK", "FALLBACK_COMMON", "UNIVERSAL_FALLBACK_COMMON"});
        r100.put("FILE_BLOCK_COMMON", MapsKt.mapOf(new Pair[]{TuplesKt.to("entity_operation", "entityOperate"), TuplesKt.to("file_biz_domain", "fileBizDomain")}));
    }
}
