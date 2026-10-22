package kc6;

import com.bytedance.android.live.base.model.message.a5;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.SelectedDialogIconModelSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(SelectedDialogIconModelSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkc6/f0;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.SelectedDialogIconModel")
public interface f0 extends vh7.j<f0> {

    @JsonAdapter(SelectedDialogIconModelSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "gift_price_text#setter")
    void Q(String r100);

    @FieldName(name = "gray#setter")
    void p6(boolean r100);

    @FieldName(name = "gift_icon#setter")
    void setGiftIcon(py.k r100);

    @FieldName(name = "bottom_send_text#setter")
    void x4(a5 r100);
}
