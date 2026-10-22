package com.bytedance.crash;

import java.util.concurrent.Callable;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes3.dex */
public final class g implements Callable<JSONArray> {
    public g() {
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ JSONArray call() throws Exception {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public JSONArray call2() {
        return bi4.a.c();
    }
}
