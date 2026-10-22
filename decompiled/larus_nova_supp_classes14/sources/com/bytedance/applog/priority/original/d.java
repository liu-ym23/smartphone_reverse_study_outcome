package com.bytedance.applog.priority.original;

import java.util.HashMap;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public interface d {
    int a(int r1);

    void b(Iterable<j> r1);

    Pair<HashMap<j, JSONObject>, Boolean> c(int r1, long r2, int r4, long r5, Function1<? super JSONObject, Boolean> r7);

    Set<Integer> d();

    void destroy();

    boolean e(int r1);

    j insert(j r1, String r2);
}
