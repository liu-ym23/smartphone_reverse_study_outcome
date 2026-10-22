package com.bytedance.ee.bear.lynx.impl.xbridge.method.network;

import com.bytedance.ee.bear.contract.Result;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/lynx/impl/xbridge/method/network/ResponseJsonResult;", "Lcom/bytedance/ee/bear/contract/Result;", "Ljava/io/Serializable;", "responseJson", "Lorg/json/JSONObject;", "<init>", "(Lorg/json/JSONObject;)V", "getResponseJson", "()Lorg/json/JSONObject;", "Companion", "features-lynx-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ResponseJsonResult extends Result<Serializable> {
    public static final a Companion = null;
    private final JSONObject responseJson;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final JSONObject getResponseJson() {
        return this.responseJson;
    }

    public ResponseJsonResult(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "responseJson");
        this.responseJson = r100;
    }
}
