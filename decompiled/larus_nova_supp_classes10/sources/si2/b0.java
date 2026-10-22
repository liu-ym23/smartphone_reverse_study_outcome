package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2AuthorListRoomStatsData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2AuthorOrderLimitInfo;
import com.bytedance.android.livesdk.livecommerce.model.ECV2PopupInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.LiveSellerMessage")
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u000bR\u0018\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lsi2/b0;", "Lsg2/a;", "", "msgType", "I", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuthorOrderLimitInfo;", "authorOrderLimitInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuthorOrderLimitInfo;", "", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2AuthorListRoomStatsData;", "listRoomStatsData", "Ljava/util/List;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;", "flashPopupInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2PopupInfo;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b0 extends sg2.a {

    @SerializedName("author_order_limit_info")
    public ECV2AuthorOrderLimitInfo authorOrderLimitInfo;

    @SerializedName("flash_popup_info")
    public ECV2PopupInfo flashPopupInfo;

    @SerializedName("list_room_stats_data")
    public List<ECV2AuthorListRoomStatsData> listRoomStatsData;

    @SerializedName("msg_type")
    public int msgType;

    @Override // sg2.a
    public final String toJsonString() {
        return new Gson().toJson(this);
    L5:
        return toString();
    }

    public b0() {
    }
}
