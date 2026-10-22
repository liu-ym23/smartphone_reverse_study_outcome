package com.bytedance.ee.bear.bitable.card.viewmodel.fetch.async.emit;

import com.alibaba.fastjson.JSONObject;
import io.reactivex.functions.Action;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class a implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f209088a;

    public a(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        this.f209088a = r100;
    }
}
