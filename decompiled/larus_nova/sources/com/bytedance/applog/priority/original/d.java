package com.bytedance.applog.priority.original;

import java.util.HashMap;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public interface d {
    int a(int r100);

    void b(Iterable<j> r100);

    Pair<HashMap<j, JSONObject>, Boolean> c(int r100, long r101, int r102, long r103, Function1<? super JSONObject, Boolean> r104);

    Set<Integer> d();

    void destroy();

    boolean e(int r100);

    j insert(j r100, String r101);
}
