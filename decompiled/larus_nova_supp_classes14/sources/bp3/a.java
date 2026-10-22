package bp3;

import android.net.Uri;
import com.bytedance.android.ec.model.ECAdLogExtra;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.window.shop.home.ECWindowParam;
import com.bytedance.android.window.shop.repository.dto.WindowHeaderResponseDTO;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends com.bytedance.android.ec.core.event.a {
    public final ECWindowParam a;
    public final WindowHeaderResponseDTO b;
    public final Uri c;

    public final void buildParams() {
        a(this, "statusCode", String.valueOf(this.b.getStatusCode()));
        a(this, "statusMsg", this.b.getStatusMsg());
        a(this, "com.bytedance.android.ec.adapter.api.message", this.b.getMessage());
        a(this, "page_name", this.a.getPageName());
        a(this, "author_id", this.a.getAuthorId());
        a(this, "entrance_location", this.a.getEntranceLocation());
        a(this, "enter_from", this.a.getEnterFrom());
        a(this, "enter_method", this.a.getEnterMethod());
        ECAdLogExtra r0 = this.a.getAdLogExtra();
        String r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getCreativeId();
    L6:
        a(this, "creative_id", String.valueOf(r2));
        ECAdLogExtra r3 = this.a.getAdLogExtra();
        if (r3 == null) goto L9;
        String r4 = r3.getGroupId();
    L10:
        a(this, "item_id", String.valueOf(r4));
        ECAdLogExtra r5 = this.a.getAdLogExtra();
        if (r5 == null) goto L13;
        String r6 = r5.getLogExtra();
    L14:
        a(this, "log_extra", r6);
        ECAdLogExtra r7 = this.a.getAdLogExtra();
        if (r7 == null) goto L17;
        String r8 = r7.getAdExtraData();
    L18:
        a(this, "ad_extra_data", r8);
        Uri r9 = this.c;
        String[] r10 = {"entrance_location", "enter_from", "enter_method", "uid", "sec_uid", "is_search"};
        if (r9 == null) goto L33;
        int r11 = 0;
    L23:
        if (r11 >= 6) goto L33;
        String r12 = r10[r11];
        String r13 = UriProtector.getQueryParameter(r9, r12);
        if (r13 == null) goto L32;
        if (k.c(r13) == true) goto L30;
        r13 = null;
    L30:
        if (r13 == null) goto L32;
        a(this, r12, r13);
    L32:
        r11 = r11 + 1;
    L33:
        Uri r14 = this.c;
        if (r14 == null) goto L36;
        r1 = r14.toString();
    L36:
        a(this, "schema_url", r1);
        return;
    L17:
        r8 = null;
        goto L18
    L13:
        r6 = null;
        goto L14
    L9:
        r4 = null;
        goto L10
    L5:
        r2 = null;
        goto L6
    }

    public a(ECWindowParam r2, WindowHeaderResponseDTO r3, Uri r4) {
        Intrinsics.checkNotNullParameter(r2, "shopParam");
        Intrinsics.checkNotNullParameter(r3, "responseDTO");
        super("ec_shop_enter_failed");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public static void a(a r1, String r2, String r3) {
        com.bytedance.android.ec.core.event.a.b.a.getClass();
        r1.appendParam(r2, r3, com.bytedance.android.ec.core.event.a.b.a.a);
    }
}
