package com.bytedance.kmp.livesdk.gift.platform.aio.service.asr;

import com.bytedance.tools.kcp.modelx.runtime.internal.decode.SerializableObjectJsonAdapterBase;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import nc6.a;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006\"\u0004\b\u0012\u0010\bR\"\u0010\u0013\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/service/asr/ASRTextResultSerializableObjectImpl;", "Lnc6/a;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "", "statusCode", "J", "getStatusCode", "()J", "A5", "(J)V", "errorMessage", "getErrorMessage", "setErrorMessage", "step", "getStep", "k2", "reqId", "getReqId", "g5", "<init>", "()V", "Adapter", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ASRTextResultSerializableObjectImpl implements a {

    @SerializedName("error_message")
    private String errorMessage;

    @SerializedName("reqId")
    private String reqId;

    @SerializedName("status_code")
    private long statusCode;

    @SerializedName("step")
    private String step;

    @SerializedName("text")
    private String text;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/kmp/livesdk/gift/platform/aio/service/asr/ASRTextResultSerializableObjectImpl$Adapter;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/decode/SerializableObjectJsonAdapterBase;", "()V", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Adapter extends SerializableObjectJsonAdapterBase {
        public Adapter() {
            super(ASRTextResultSerializableObjectImpl.class);
        }
    }

    public ASRTextResultSerializableObjectImpl() {
        this.text = "";
        this.errorMessage = "";
        this.step = "";
        this.reqId = "";
    }

    @Override // nc6.a
    public final void A5(long r100) {
        this.statusCode = r100;
    }

    @Override // nc6.a
    public final void g5(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.reqId = r100;
    }

    @Override // nc6.a
    public final void k2(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.step = r100;
    }

    @Override // nc6.a
    public final void setErrorMessage(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.errorMessage = r100;
    }

    @Override // nc6.a
    public final void setText(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.text = r100;
    }
}
