package kc6;

import com.bytedance.kmp.livesdk.gift.platform.aio.model.PropInfoSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(PropInfoSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkc6/d0;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.PropInfo")
public interface d0 extends vh7.j<d0> {

    @JsonAdapter(PropInfoSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "prop_def_id#setter")
    void H4(long r100);

    @FieldName(name = "prop_sub_def_type#setter")
    void W3(long r100);

    @FieldName(name = "prop_count#setter")
    void d7(int r100);

    @FieldName(name = "expired_description#setter")
    void j0(String r100);

    @FieldName(name = "prop_def_type#setter")
    void s5(long r100);

    @FieldName(name = "expire_time#setter")
    void setExpireTime(long r100);

    @FieldName(name = "ref_id#setter")
    void setRefId(String r100);
}
