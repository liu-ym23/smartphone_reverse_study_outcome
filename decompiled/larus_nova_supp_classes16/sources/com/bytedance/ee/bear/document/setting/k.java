package com.bytedance.ee.bear.document.setting;

import com.bytedance.ee.bear.contract.net.SimpleRequestResult;
import com.bytedance.ee.bear.document.tips.TipCallBackData;
import io.reactivex.functions.Function;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class k<T, R> implements Function {
    public static final k<T, R> a = null;

    static {
        a = new k();
    }

    public k() {
    }

    public final Object apply(Object r2) {
        SimpleRequestResult r3 = (SimpleRequestResult) r2;
        Intrinsics.checkNotNullParameter(r3, TipCallBackData.RESULT);
        return new JSONObject(r3.data.toString()).optString("im_share_leader");
    L5:
        return "";
    }
}
