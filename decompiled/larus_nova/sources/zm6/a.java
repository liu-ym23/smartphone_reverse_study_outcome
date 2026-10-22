package zm6;

import android.content.res.Resources;
import android.text.TextUtils;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.locallife.common.utils.d;
import com.google.gson.Gson;
import com.ss.android.ugc.aweme.poi.event.PoiClickHeaderInfoEvent;
import com.ss.android.ugc.aweme.poi.model.AlbumTabListModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import vn6.b;

/* JADX INFO: loaded from: classes20.dex */
public final class a implements hu6.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Gson f572876a;

    @Override // hu6.a
    public final void C() {
    }

    @Override // ns6.a
    public final List<String> a() {
        return null;
    }

    @Override // hu6.a
    public final void e(Resources r100) {
        Intrinsics.checkNotNullParameter(r100, "resources");
    }

    @Override // hu6.a
    public final void getDensity() {
    }

    public a() {
        this.f572876a = d.b();
    }

    @Override // hu6.a
    public final Gson o() {
        return this.f572876a;
    }

    @Override // hu6.a
    public final void z(JSONObject r100) {
        Intrinsics.checkNotNullParameter("notification", "eventName");
        Intrinsics.checkNotNullParameter(r100, "params");
        J("notification", r100);
    }

    @Override // hu6.a
    public final void J(String r210, JSONObject r211) {
        Intrinsics.checkNotNullParameter(r210, "eventName");
        Intrinsics.checkNotNullParameter(r211, "params");
        boolean r100 = false;
        if (TextUtils.equals(r211.optString("eventName"), "click_header_info") == false) goto L12;
        JSONObject r101 = r211.optJSONObject("data");
        if (r101 == null) goto L11;
        String r102 = r101.optString("session_id", "");
        int r103 = r101.optInt("jump_mode", 0);
        int r104 = r101.optInt("index", 0);
        boolean r110 = r101.optBoolean("need_anchor", false);
        JSONObject r111 = r101.optJSONObject(ILiveRoomPlayFragmentConstant.EXTRA_REPLAY_LOG_PARAMS);
        JSONObject r112 = r101.optJSONObject("album_bottom_bar_params");
        boolean r105 = r101.optBoolean("show_share_icon", false);
        String r113 = r101.optString("anchor_pager_type", "photo");
        boolean r106 = r101.optBoolean("show_more_icon_only", false);
        String r114 = r101.optString("anchor_tab_id", null);
        String r115 = r101.optString("photo_page_tab_list", "");
        String r212 = r101.optString("top_video_item_id", "");
        List r116 = d.d(r115, AlbumTabListModel[].class);     // Catch: Exception -> L9
    L10:
        boolean r107 = r101.optBoolean("show_single_line_filter_only", false);
        boolean r117 = r101.optBoolean("is_home_poi_style", false);
        boolean r108 = r101.optBoolean("use_new_style", false);
        b.a(new PoiClickHeaderInfoEvent(r104, r102, r103, r111, r110, r112, Boolean.valueOf(r106), r113, Boolean.valueOf(r105), r114, r116, Boolean.valueOf(r107), Boolean.valueOf(r117), Boolean.valueOf(r108), r212));
    L9:
        r116 = null;
    L11:
        r100 = true;
    L12:
        if (r100 == false) goto L14;
        return;
    L14:
        b.a(new ln6.a(r210, r211));
    }
}
