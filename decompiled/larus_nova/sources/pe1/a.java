package pe1;

import com.google.gson.annotations.SerializedName;
import tb1.c;

/* JADX INFO: loaded from: classes7.dex */
public class a {

    @SerializedName("live_broadcast_task_resource_id")
    public long anchorTaskFinishAnimAssetId;

    @SerializedName("live_broadcast_first_task_resource_id")
    public long anchorTaskFirstFinishAnimAssetId;

    @SerializedName("cny_bowl_asset_id")
    private long cnyTreasureAssetId;

    @SerializedName("cny_tree_asset_id")
    private long cnyTreeAssetId;

    @SerializedName("interact_ic_calling_id")
    public long interactIcCallingId;

    @SerializedName("interact_ic_waiting_id")
    public long interactIcWaitingId;

    @SerializedName("pk_anim_asset_id")
    private long pkAnimAssetId;

    @SerializedName("pk_animation_new_draw")
    private long pkAnimationDraw;

    @SerializedName("pk_animation_new_lose")
    private long pkAnimationLose;

    @SerializedName("pk_animation_new_win")
    private long pkAnimationWin;

    @SerializedName("pk_in_room_anim_asset_id")
    private long pkInRoomAnimAssetId;

    @SerializedName("pk_match_icon_id")
    private long pkMatchIconId;

    @SerializedName("pk_match_random_id")
    private long pkMatchRandomId;

    @SerializedName("pk_wait_icon_id")
    private long pkWaitIconId;

    public a() {
        this.pkAnimAssetId = 667;
        this.pkInRoomAnimAssetId = 0;
        this.pkWaitIconId = 607;
        this.pkMatchIconId = 606;
        this.pkMatchRandomId = 605;
        boolean r100 = c.f545229a;
        if (r100 == false) goto L5;
        long r101 = 675;
    L6:
        this.interactIcCallingId = r101;
        if (c.f545230b == false) goto L9;
        long r102 = 572;
    L10:
        this.anchorTaskFinishAnimAssetId = r102;
        this.anchorTaskFirstFinishAnimAssetId = 902;
        this.cnyTreasureAssetId = 592;
        this.cnyTreeAssetId = 593;
        this.pkAnimationWin = 629;
        this.pkAnimationLose = 628;
        this.pkAnimationDraw = 627;
        if (r100 == false) goto L13;
        long r103 = 676;
    L14:
        this.interactIcWaitingId = r103;
        return;
    L13:
        r103 = 851;
        goto L14
    L9:
        r102 = 522;
        goto L10
    L5:
        r101 = 843;
        goto L6
    }
}
