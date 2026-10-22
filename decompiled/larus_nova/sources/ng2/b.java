package ng2;

import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes10.dex */
public class b {

    @SerializedName("show_challenge")
    public boolean showChallenge;

    @SerializedName("live_room_challenge_tips")
    public String tipsLiveRoom;

    @SerializedName("broadcast_has_challenge_tips")
    public String tipsWithChallege;

    @SerializedName("broadcast_without_challenge_tips")
    public String tipsWithOutChallege;

    public b() {
        this.showChallenge = true;
        this.tipsWithChallege = "可以更改话题哦";
        this.tipsWithOutChallege = "添加合适的话题，更有人气";
        this.tipsLiveRoom = "在这里找到话题哦";
    }
}
