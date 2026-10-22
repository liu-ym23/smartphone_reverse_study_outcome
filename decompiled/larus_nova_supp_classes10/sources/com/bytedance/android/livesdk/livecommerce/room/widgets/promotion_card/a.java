package com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card;

import android.content.Context;
import com.bytedance.android.ec.core.frontier.FormatType;
import com.bytedance.android.livesdk.livecommerce.utils.LiveCommerceMessageProvider;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements com.bytedance.android.ec.core.frontier.b {
    public long a;
    public final WeakReference<Context> b;
    public final com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.a$a, reason: collision with other inner class name */
    public static final class C0111a {
    }

    static {
    }

    public final void a(com.bytedance.android.ec.core.frontier.a r8) {
        Intrinsics.checkNotNullParameter(r8, "content");
        if (Intrinsics.areEqual("LivePopMessage", r8.a) == false) goto L43;
        String r0 = r8.c.c();
        boolean r2 = false;
        if (Intrinsics.areEqual(r0, FormatType.JSON.getType()) == false) goto L8;
    L23:
        si2.a0 r1 = null;
    L24:
        String r9 = r8.b;
        if (r9 == null) goto L29;
        Long r10 = StringsKt.toLongOrNull(r9);
        if (r10 == null) goto L29;
        long r5 = r10.longValue();
    L30:
        if (r1 != null) goto L32;
    L38:
        if (r1 != null) goto L40;
        return;
    L40:
        if (r1.msgType != 1) goto L47;
        this.c.k(null, String.valueOf(r1.promotionId), true);
        return;
    L47:
        return;
    L32:
        if (r1.msgType != 0) goto L38;
        if (this.a >= r5) goto L36;
        this.a = r5;
        com.bytedance.android.livesdk.livecommerce.utils.x.c(this.b.get(), "ec_explain_card_promotion_msg_id_v2", r5);
        r2 = true;
    L36:
        if (r2 == false) goto L44;
        com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i.a.a(this.c, null, true, null, 120);
        return;
    L44:
        return;
    L29:
        r5 = 0;
        goto L30
    L8:
        if (Intrinsics.areEqual(r0, FormatType.PROTOBUF.getType()) == false) goto L23;
        String r3 = r8.a;
        if (r3 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L23;
        String r6 = r8.c.b();
        if (r6 == null) goto L23;
        Object r7 = fh.a.a(si2.a0.class, r6);
        if ((r7 instanceof si2.a0) == true) goto L22;
        r7 = null;
    L22:
        r1 = (si2.a0) r7;
        goto L24
    L12:
        if (r3.length() == 0) goto L15;
        r4 = false;
        goto L16
    }

    public a(WeakReference<Context> r2, com.bytedance.android.livesdk.livecommerce.room.widgets.bottom_right.i r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "bottomRightCardLiveManager");
        this.b = r2;
        this.c = r3;
        LiveCommerceMessageProvider r4 = LiveCommerceMessageProvider.a;
        this.a = com.bytedance.android.livesdk.livecommerce.utils.x.a(r2.get(), "ec_explain_card_promotion_msg_id_v2");
    }
}
