package kc6;

import com.bytedance.kmp.livesdk.gift.platform.aio.model.GiftDialogInfoSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(GiftDialogInfoSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkc6/o;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.GiftDialogInfo")
public interface o extends vh7.j<o> {

    @JsonAdapter(GiftDialogInfoSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "gift_request_ready#setter")
    void E1(Boolean r100);

    @FieldName(name = "page_list#setter")
    void Q5(List<? extends r> r100);

    @FieldName(name = "page_list")
    List<r> getPageList();

    @FieldName(name = "gift_request_ready")
    Boolean i9();

    @FieldName(name = "log_extra#setter")
    void j6(Map<String, String> r100);

    @FieldName(name = "local_version#setter")
    void z3(Integer r100);
}
