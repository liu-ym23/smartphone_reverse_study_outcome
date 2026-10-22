package com.bytedance.kmp.livesdk.gift.platform.aio.model;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import com.tencent.qqmusic.third.api.contract.Keys;
import kc6.d0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b#\u0010$R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0017\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010 \u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u0004\u001a\u0004\b!\u0010\u0006\"\u0004\b\"\u0010\b¨\u0006&"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/PropInfoSerializableObjectImpl;", "Lkc6/d0;", "", "propDefId", "J", "getPropDefId", "()J", "H4", "(J)V", "propDefType", "getPropDefType", "s5", "propSubDefType", "getPropSubDefType", "W3", "", "propCount", "I", "getPropCount", "()I", "d7", "(I)V", "", "expiredDescription", "Ljava/lang/String;", "getExpiredDescription", "()Ljava/lang/String;", "j0", "(Ljava/lang/String;)V", "refId", "getRefId", "setRefId", Keys.API_PARAM_KEY_SDK_EXPIRETIME, "getExpireTime", "setExpireTime", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PropInfoSerializableObjectImpl implements d0 {

    @SerializedName("expire_time")
    private long expireTime;

    @SerializedName("expired_description")
    private String expiredDescription;

    @SerializedName("prop_count")
    private int propCount;

    @SerializedName("prop_def_id")
    private long propDefId;

    @SerializedName("prop_def_type")
    private long propDefType;

    @SerializedName("prop_sub_def_type")
    private long propSubDefType;

    @SerializedName("ref_id")
    private String refId;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/model/PropInfoSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(PropInfoSerializableObjectImpl.class);
        }
    }

    public PropInfoSerializableObjectImpl() {
        this.expiredDescription = "";
        this.refId = "";
    }

    @Override // kc6.d0
    public final void H4(long r100) {
        this.propDefId = r100;
    }

    @Override // kc6.d0
    public final void W3(long r100) {
        this.propSubDefType = r100;
    }

    @Override // kc6.d0
    public final void d7(int r100) {
        this.propCount = r100;
    }

    @Override // kc6.d0
    public final void j0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.expiredDescription = r100;
    }

    @Override // kc6.d0
    public final void s5(long r100) {
        this.propDefType = r100;
    }

    @Override // kc6.d0
    public final void setExpireTime(long r100) {
        this.expireTime = r100;
    }

    @Override // kc6.d0
    public final void setRefId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.refId = r100;
    }
}
