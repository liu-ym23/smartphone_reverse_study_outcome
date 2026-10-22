package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kc6.g0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0014"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/SendPropParamsSerializableObjectImpl;", "Lkc6/g0;", "", "isProp", "Ljava/lang/Boolean;", "r1", "()Ljava/lang/Boolean;", "", "refId", "Ljava/lang/String;", "getRefId", "()Ljava/lang/String;", "", "propDefId", "Ljava/lang/Long;", "x8", "()Ljava/lang/Long;", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class SendPropParamsSerializableObjectImpl implements g0 {

    @SerializedName("is_prop")
    private final Boolean isProp;

    @SerializedName("prop_def_id")
    private final Long propDefId;

    @SerializedName("ref_id")
    private final String refId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/SendPropParamsSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(SendPropParamsSerializableObjectImpl.class);
        }
    }

    public SendPropParamsSerializableObjectImpl() {
    }

    @Override // kc6.g0
    public final String getRefId() {
        return this.refId;
    }

    @Override // kc6.g0
    public final Boolean r1() {
        return this.isProp;
    }

    @Override // kc6.g0
    public final Long x8() {
        return this.propDefId;
    }
}
