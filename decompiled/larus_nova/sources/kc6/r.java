package kc6;

import com.bytedance.android.livesdk.gift.model.b3;
import com.bytedance.android.livesdk.gift.model.x2;
import com.bytedance.kmp.livesdk.gift.platform.aio.model.GiftPageListSerializableObjectImpl;
import com.bytedance.tools.kcp.aio.runtime.RpcMessage;
import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@JsonAdapter(GiftPageListSerializableObjectImpl.Adapter.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001¨\u0006\u0002"}, d2 = {"Lkc6/r;", "Lvh7/j;", "livegift-kmp-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
@RpcMessage(messageName = "webcast.revenue.biz.gift.kmp.dialog.GiftPageList")
public interface r extends vh7.j<r> {

    @JsonAdapter(GiftPageListSerializableObjectImpl.Adapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @FieldName(name = "receiver_background_img#setter")
    void G5(py.k r100);

    @FieldName(name = "gift_list#setter")
    void Q3(List<? extends i> r100);

    @FieldName(name = "gift_list")
    List<i> getGiftList();

    @FieldName(name = "page_type")
    int getPageType();

    @FieldName(name = com.bytedance.android.ec.core.event.a.KEY_TAB_NAME)
    String getTabName();

    @FieldName(name = "background_image#setter")
    void setBackgroundImage(py.k r100);

    @FieldName(name = "page_info#setter")
    void setPageInfo(x2 r100);

    @FieldName(name = "page_name_style_info#setter")
    void setPageNameStyleInfo(b3 r100);

    @FieldName(name = "sort_strategy#setter")
    void setPageSortStrategy(int r100);

    @FieldName(name = "page_type#setter")
    void setPageType(int r100);

    @FieldName(name = "tab_name#setter")
    void setTabName(String r100);
}
