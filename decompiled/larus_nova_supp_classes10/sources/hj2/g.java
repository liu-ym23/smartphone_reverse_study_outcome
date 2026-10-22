package hj2;

import android.content.Context;
import android.util.LruCache;
import com.bytedance.android.livesdk.livecommerce.promotion.card.widget.ECUserRightsTagWidget;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class g implements ij2.c {
    public g() {
    }

    @Override // ij2.c
    public String getType() {
        return "user_right_tag_widget";
    }

    @Override // ij2.c
    public final boolean b(com.bytedance.android.ec.common.api.jump.model.e r3) {
        Intrinsics.checkNotNullParameter(r3, "data");
        Map r4 = r3.a.getRitTag();
        if (r4 == null) goto L9;
        List r5 = (List) r4.get("live_room_good_list_user_right");
        if (r5 == null) goto L9;
        if ((!r5.isEmpty()) == false) goto L9;
    L10:
        if (r5 != null) goto L14;
        return false;
    L14:
        return true;
    L9:
        r5 = null;
        goto L10
    }

    @Override // ij2.c
    public final ij2.a c(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        return new ECUserRightsTagWidget(r5, null, 6, 0);
    }

    @Override // ij2.c
    public final ij2.a a(Context r2, LruCache<String, ij2.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return ij2.c.a.a(this, r2, r3);
    }
}
