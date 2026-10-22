package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.ProductRefreshMessage.AtmosphereInfo")
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0007\u0010\bR$\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/AtmosphereInfo;", "", "", "", "Lcom/bytedance/android/livesdk/livecommerce/model/ProductAtmosphere;", "atmosphere", "Ljava/util/Map;", "<init>", "()V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AtmosphereInfo {
    public static final a Companion = null;

    @SerializedName("atmosphere")
    public Map<Integer, ProductAtmosphere> atmosphere;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AtmosphereInfo() {
    }
}
