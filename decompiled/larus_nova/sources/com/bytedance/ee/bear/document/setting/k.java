package com.bytedance.ee.bear.document.setting;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes16.dex */
public final class k<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k<T, R> f221759a = null;

    static {
        f221759a = new k();
    }

    public k() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        SimpleRequestResult r101 = (SimpleRequestResult) r100;
        Intrinsics.checkNotNullParameter(r101, "result");
        return new JSONObject(r101.data.toString()).optString("im_share_leader");
    L5:
        return "";
    }
}
