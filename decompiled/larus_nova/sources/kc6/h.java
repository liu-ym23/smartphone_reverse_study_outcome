package kc6;

import com.bytedance.kmp.livesdk.gift.platform.aio.model.DefaultDialogIconModelSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(DefaultDialogIconModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkc6/h;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.DefaultDialogIconModel")
public interface h extends vh7.j<h> {

    @JsonAdapter(DefaultDialogIconModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "gift_price_text#setter")
    void Q(String r100);

    @FieldName(name = "center_label#setter")
    void T3(u r100);

    @FieldName(name = "top_left_label#setter")
    void b7(py.k r100);

    @FieldName(name = "gift_icon#setter")
    void setGiftIcon(py.k r100);

    @FieldName(name = "gift_name#setter")
    void setGiftName(String r100);

    @FieldName(name = "lock_status#setter")
    void t8(String r100);
}
