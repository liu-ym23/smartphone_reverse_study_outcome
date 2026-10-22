package mv8;

import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements ic.a {
    public d() {
    }

    @Override // ic.a
    public final void a(ic.b r100) {
        Intrinsics.checkNotNullParameter(r100, "onResourceObtainCallback");
    }

    @Override // ic.a
    public final JSONObject getDefault() {
        return new JSONObject().put("bcm_in_chain", CollectionsKt.listOf(new String[]{"search_id", "bcm_share_id", "doubao_share_id", "bcm_em_id", "ug_ecom_channel_id", "summary_track_id", "author_id", "group_id", "room_id", "promotion_id", "search_result_id", ILiveRoomPlayFragmentConstant.EXTRA_LIST_ITEM_ID, "search_third_item_id", "cart_id", "video_id", "qrec_join_key", "ads_material_id", "doudian_crm_reach_id", "card_unique_id", "interact_id", "ecom_search_group_id", "mix_session_id", "btm_external_evoke_id", "request_id", "doubao_bcm_id", "creative_id", "ad_id", "sub_request_id", "channel_id", "product_id", "fpa_bcm_id", "doubao_message_id"}));
    }
}
