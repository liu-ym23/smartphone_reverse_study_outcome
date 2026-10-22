package m2a;

import com.bytedance.android.gamecp.business.instantplay.InstantPlayContext;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import com.larus.bmhome.chat.search.SourceFrom;
import com.larus.platform.uimodel.MediaEntity;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f511680a = 0;

    static {
    }

    public static MediaEntity a(String r310) {
        JSONObject r100 = new JSONObject(r310);
        String r101 = r100.optString(SimilarProductParam.AWEME_ID);
        Intrinsics.checkNotNull(r101);
        if (r101.length() <= 0) goto L5;
        boolean r102 = true;
    L6:
        String r103 = null;
        if (r102 == false) goto L9;
        String r104 = r101;
    L10:
        if (r104 != null) goto L12;
        return null;
    L12:
        JSONObject r105 = r100.optJSONObject("video");
        JSONObject r106 = r100.optJSONObject("author");
        if (r105 == null) goto L15;
        String r110 = r105.toString();
    L16:
        if (r105 == null) goto L22;
        JSONObject r107 = r105.optJSONObject("cover");
        if (r107 == null) goto L22;
        JSONArray r108 = r107.optJSONArray(ScoreTags.STAR_URL_LIST);
        if (r108 == null) goto L22;
        String r111 = r108.optString(0);
    L23:
        if (r105 == null) goto L25;
        Integer r112 = Integer.valueOf(r105.optInt("width", 0));
    L26:
        if (r105 == null) goto L28;
        Integer r113 = Integer.valueOf(r105.optInt("height", 0));
    L29:
        if (r106 == null) goto L31;
        String r210 = r106.optString("uid");
    L32:
        if (r106 == null) goto L35;
        r103 = r106.optString(InstantPlayContext.NICKNAME);
    L35:
        return new MediaEntity(null, r104, null, null, null, null, null, r111, r112, r113, r110, null, Integer.valueOf(SourceFrom.DouYin.value), null, null, null, 0, null, r210, r103, null, null, null, null, 15984765, null);
    L31:
        r210 = null;
        goto L32
    L28:
        r113 = null;
        goto L29
    L25:
        r112 = null;
    L22:
        r111 = null;
        goto L23
    L15:
        r110 = null;
        goto L16
    L9:
        r104 = null;
        goto L10
    L5:
        r102 = false;
        goto L6
    }
}
