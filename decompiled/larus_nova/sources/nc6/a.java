package nc6;

import com.bytedance.kmp.livesdk.gift.platform.aio.service.asr.ASRTextResultSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import vh7.j;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(ASRTextResultSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lnc6/a;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.effect.ASRTextResult")
public interface a extends j<a> {

    /* JADX INFO: renamed from: nc6.a$a, reason: collision with other inner class name */
    @JsonAdapter(ASRTextResultSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class C6913a {
    }

    @FieldName(name = "status_code#setter")
    void A5(long r100);

    @FieldName(name = "reqId#setter")
    void g5(String r100);

    @FieldName(name = "step#setter")
    void k2(String r100);

    @FieldName(name = "error_message#setter")
    void setErrorMessage(String r100);

    @FieldName(name = "text#setter")
    void setText(String r100);
}
