package wg1;

import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    @SerializedName("endRoom")
    public IRoom endRoom;

    @SerializedName("targetEpisode")
    public Episode episode;

    @SerializedName("isRoomInList")
    public boolean isRoomInList;

    @SerializedName("recommendRoom")
    public IRoom recommendRoom;

    public a() {
    }
}
