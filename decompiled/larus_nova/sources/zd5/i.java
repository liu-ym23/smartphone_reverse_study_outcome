package zd5;

import ae5.b0;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.ee.bear.list.recent.d1;
import com.bytedance.ee.bear.list.share.q3;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import com.ss.android.ugc.aweme.discover.model.ScoreTags;
import id5.w;
import jd5.u;
import uc5.h1;
import uc5.o1;

/* JADX INFO: loaded from: classes18.dex */
public final class i {
    public static a a(String r100, boolean r101, BenefitStore r102) {
        if (TextUtils.equals(r100, "recent") == false) goto L6;
        return new d1(r101);
    L6:
        if (TextUtils.equals(r100, "mine") == false) goto L9;
        return new u(r101);
    L9:
        if (TextUtils.equals(r100, "shared_file") == true) goto L45;
        if (TextUtils.equals(r100, "shared") == true) goto L45;
        if (TextUtils.equals(r100, ScoreTags.SCORE_TYPE_STAR) == false) goto L17;
        return new b0(r101);
    L17:
        if (TextUtils.equals(r100, "manual_offline") == false) goto L20;
        return new w(r101);
    L20:
        if (TextUtils.equals(r100, RootDescription.ROOT_ELEMENT) == true) goto L57;
        if (TextUtils.equals(r100, "shared_folder") == true) goto L57;
        if (TextUtils.equals(r100, ThumbGlideUrl.SOURCE_TEMPLATE) == false) goto L28;
        return new be5.a(r101);
    L28:
        if (TextUtils.equals(r100, "template_v4") == false) goto L31;
        return new be5.b(r101, r102);
    L31:
        if (TextUtils.equals(r100, "template_topic") == false) goto L34;
        return new be5.b(r101, r102);
    L34:
        if (TextUtils.equals(r100, "owned_by_me") == false) goto L37;
        return new hc5.b(r101);
    L37:
        if (TextUtils.equals(r100, "my_involved") == false) goto L40;
        return new hc5.b(r101);
    L40:
        if (TextUtils.equals(r100, "ai_share_with_me") == false) goto L56;
        return new hc5.b(r101);
    L56:
        return new o1(r101);
    L57:
        return new h1(r101);
    L45:
        return new q3(r101);
    }
}
