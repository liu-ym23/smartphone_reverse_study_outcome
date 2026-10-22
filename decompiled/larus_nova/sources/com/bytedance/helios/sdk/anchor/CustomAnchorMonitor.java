package com.bytedance.helios.sdk.anchor;

import com.bytedance.helios.api.consumer.PrivacyEvent;
import hz5.c;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class CustomAnchorMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<Integer, Map<String, c>> f245484a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Integer, List<PrivacyEvent>> f245485b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<Integer, Integer> f245486c = null;

    /* JADX INFO: loaded from: classes19.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/helios/sdk/anchor/CustomAnchorMonitor$DeviceType;", "", "sdk_release"}, k = 1, mv = {1, 1, 16})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface DeviceType {
    }

    static {
        f245484a = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(1, new LinkedHashMap()), TuplesKt.to(2, new LinkedHashMap())});
        f245485b = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(1, new ArrayList()), TuplesKt.to(2, new ArrayList())});
        f245486c = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to(1, 0), TuplesKt.to(2, 0)});
    }
}
