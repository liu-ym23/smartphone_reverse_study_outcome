package si2;

import com.bytedance.android.livesdk.livecommerce.model.ECV2FilterSwitchChangeData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2GMVData;
import com.bytedance.android.livesdk.livecommerce.model.ECV2RoomTagOfflineInfo;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.LiveCommonMessage")
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0018\u0010\t\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0018\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lsi2/v;", "Lsg2/a;", "", "msgType", "I", "", "screenshotTimestamp", "J", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2RoomTagOfflineInfo;", "roomTagOfflineInfo", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2RoomTagOfflineInfo;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2FilterSwitchChangeData;", "filterSwitchChangeData", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2FilterSwitchChangeData;", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2GMVData;", "gmvData", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2GMVData;", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class v extends sg2.a {

    @SerializedName("filter_switch_change_data")
    public ECV2FilterSwitchChangeData filterSwitchChangeData;

    @SerializedName("gmv_data")
    public ECV2GMVData gmvData;

    @SerializedName("msg_type")
    public int msgType;

    @SerializedName("room_tag_offline_info")
    public ECV2RoomTagOfflineInfo roomTagOfflineInfo;

    @SerializedName("screenshot_timestamp")
    public long screenshotTimestamp;

    @Override // sg2.a
    public final String toJsonString() {
        return new Gson().toJson(this);
    L5:
        return toString();
    }

    public v() {
    }
}
