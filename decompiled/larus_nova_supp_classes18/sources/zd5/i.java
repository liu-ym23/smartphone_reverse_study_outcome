package zd5;

import ae5.b0;
import android.text.TextUtils;
import com.bytedance.ee.bear.list.recent.d1;
import com.bytedance.ee.bear.list.share.q3;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ee.bear.unbundle.BenefitStore;
import id5.w;
import jd5.u;
import uc5.h1;
import uc5.o1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i {
    public static a a(String r1, boolean r2, BenefitStore r3) {
        if (TextUtils.equals(r1, "recent") == false) goto L6;
        return new d1(r2);
    L6:
        if (TextUtils.equals(r1, "mine") == false) goto L9;
        return new u(r2);
    L9:
        if (TextUtils.equals(r1, "shared_file") == true) goto L45;
        if (TextUtils.equals(r1, "shared") == true) goto L45;
        if (TextUtils.equals(r1, "star") == false) goto L17;
        return new b0(r2);
    L17:
        if (TextUtils.equals(r1, "manual_offline") == false) goto L20;
        return new w(r2);
    L20:
        if (TextUtils.equals(r1, "root") == true) goto L57;
        if (TextUtils.equals(r1, "shared_folder") == true) goto L57;
        if (TextUtils.equals(r1, ThumbGlideUrl.SOURCE_TEMPLATE) == false) goto L28;
        return new be5.a(r2);
    L28:
        if (TextUtils.equals(r1, "template_v4") == false) goto L31;
        return new be5.b(r2, r3);
    L31:
        if (TextUtils.equals(r1, "template_topic") == false) goto L34;
        return new be5.b(r2, r3);
    L34:
        if (TextUtils.equals(r1, "owned_by_me") == false) goto L37;
        return new hc5.b(r2);
    L37:
        if (TextUtils.equals(r1, "my_involved") == false) goto L40;
        return new hc5.b(r2);
    L40:
        if (TextUtils.equals(r1, "ai_share_with_me") == false) goto L56;
        return new hc5.b(r2);
    L56:
        return new o1(r2);
    L57:
        return new h1(r2);
    L45:
        return new q3(r2);
    }
}
