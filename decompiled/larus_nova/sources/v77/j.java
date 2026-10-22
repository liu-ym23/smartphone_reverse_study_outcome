package v77;

import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public class j {

    @SerializedName("channel_name_show_map")
    public Map<String, String> channelNameShowMap;

    @SerializedName("channel_name_white_list")
    public List<String> channelNameWhiteList;

    @SerializedName("enable_permission_channel_clear")
    public boolean enablePermissionChannelClear;

    @SerializedName("request_code_white_list")
    public List<Integer> requestCodeWhiteList;

    public final String toString() {
        return "PermissionBootChannelModel{enablePermissionChannelClear=" + this.enablePermissionChannelClear + ", requestCodeWhiteList=" + this.requestCodeWhiteList + ", channelNameWhiteList=" + this.channelNameWhiteList + ", channelNameShowMap=" + this.channelNameShowMap + '}';
    }

    public j() {
        this.enablePermissionChannelClear = false;
        this.requestCodeWhiteList = Collections.emptyList();
        this.channelNameWhiteList = Collections.emptyList();
        this.channelNameShowMap = new HashMap();
    }
}
