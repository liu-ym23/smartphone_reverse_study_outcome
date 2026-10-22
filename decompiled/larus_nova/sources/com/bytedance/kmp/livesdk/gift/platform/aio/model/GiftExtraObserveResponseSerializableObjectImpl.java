package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.android.livesdk.gift.model.g0;
import com.bytedance.revenue.platform.api.core.JsonOrBytesJvm;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kc6.q;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/GiftExtraObserveResponseSerializableObjectImpl;", "Lkc6/q;", "Lcom/bytedance/android/livesdk/gift/model/g0;", "extra", "Lcom/bytedance/android/livesdk/gift/model/g0;", "getExtra", "()Lcom/bytedance/android/livesdk/gift/model/g0;", "M1", "(Lcom/bytedance/android/livesdk/gift/model/g0;)V", "Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;", "extraObject", "Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;", "getExtraObject", "()Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;", "m", "(Lcom/bytedance/revenue/platform/api/core/JsonOrBytesJvm;)V", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class GiftExtraObserveResponseSerializableObjectImpl implements q {

    @SerializedName("extra")
    private g0 extra;

    @SerializedName("extra_object")
    private JsonOrBytesJvm extraObject;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/GiftExtraObserveResponseSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(GiftExtraObserveResponseSerializableObjectImpl.class);
        }
    }

    public GiftExtraObserveResponseSerializableObjectImpl() {
    }

    @Override // kc6.q
    public final g0 getExtra() {
        return this.extra;
    }

    @Override // kc6.q
    public final void M1(g0 r100) {
        this.extra = r100;
    }

    @Override // kc6.q
    public final void m(JsonOrBytesJvm r100) {
        this.extraObject = r100;
    }
}
