package com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart;

import android.os.Bundle;
import com.bytedance.android.ec.adapter.api.message.model.UpdatedCartInfo;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.livesdk.livecommerce.network.response.ECPromotionList;
import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.room.store.ECContext;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import com.bytedance.live.datacontext.n;
import de.b;
import java.util.Map;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a {
    public static final de.a d = null;
    public static final C0119a e = null;
    public final de.a a;
    public final b b;
    public final b c;

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.livecommerce.room.widgets.shoppingcart.a$a, reason: collision with other inner class name */
    public static final class C0119a {
        public C0119a() {
        }

        @JvmStatic
        public static boolean a(com.bytedance.android.ec.adapter.api.state.a r2) {
            Intrinsics.checkNotNullParameter(r2, "roomState");
            if (r2.c == false) goto L5;
        L22:
            return true;
        L5:
            if (r2.d == true) goto L22;
            int r0 = RoomContextController.h;
            ECContext r1 = RoomContextController.a.b(r2.f, r2.e).r();
            if (r1 == null) goto L21;
            n<a> r3 = r1.getCartConfig();
            if (r3 == null) goto L21;
            a r4 = (a) r3.getValue();
            if (r4 == null) goto L21;
            if (r2.d == false) goto L18;
            b r5 = r4.b;
            if (r5 == null) goto L21;
            return r5.allowShowCart;
        L18:
            b r6 = r4.c;
            if (r6 == null) goto L21;
            return r6.allowShowCart;
        L21:
            return false;
        }

        @JvmStatic
        public static a b(ee.b r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            UpdatedCartInfo r0 = r2.w();
            UpdatedCartInfo.RoomCartStateHorizontal r1 = null;
            if (r0 == null) goto L5;
            UpdatedCartInfo.RoomCartStateVertical r3 = r0.vertical;
        L6:
            UpdatedCartInfo r4 = r2.w();
            if (r4 == null) goto L10;
            r1 = r4.horizontal;
        L10:
            return new a(r3, r1);
        L5:
            r3 = null;
            goto L6
        }

        @JvmStatic
        public static a c(Bundle r2) {
            Intrinsics.checkNotNullParameter(r2, "extra");
            return new a(b.parseFromMap((Map) r2.get("EXTRA_MAP_CART_VERTICAL")), b.parseFromMap((Map) r2.get("EXTRA_MAP_CART_HORIZONTAL")));
        }

        public static boolean e(C0119a r0) {
            r0.getClass();
            int r1 = RoomContextController.h;
            ECContext r2 = RoomContextController.a.a().r();
            if (r2 == null) goto L13;
            n<a> r3 = r2.getCartConfig();
            if (r3 == null) goto L13;
            a r4 = (a) r3.getValue();
            if (r4 == null) goto L13;
            de.a r5 = r4.a;
            if (r5 == null) goto L13;
            String r6 = r5.animatedIconUrl;
            if (r6 == null) goto L13;
            return a2.b(r6);
        L13:
            return false;
        }

        @JvmStatic
        public static String d(com.bytedance.android.ec.adapter.api.state.a r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "roomState");
            int r0 = RoomContextController.h;
            ECContext r1 = RoomContextController.a.b(r4.f, r4.e).r();
            if (r1 == null) goto L19;
            n<a> r2 = r1.getCartConfig();
            if (r2 == null) goto L19;
            a r3 = (a) r2.getValue();
            if (r3 == null) goto L19;
            Boolean r6 = null;
            if (r4.d == false) goto L14;
            StringBuilder r7 = new StringBuilder(" vertical;isShow=");
            r7.append(r5);
            r7.append(";allowShow=");
            b r8 = r3.b;
            if (r8 == null) goto L13;
            r6 = Boolean.valueOf(r8.allowShowCart);
        L13:
            r7.append(r6);
            String r9 = r7.toString();
        L18:
            if (r9 == null) goto L19;
            return r9;
        L14:
            StringBuilder r10 = new StringBuilder(" horizontal;isShow=");
            r10.append(r5);
            r10.append(";allowShow=");
            b r11 = r3.c;
            if (r11 == null) goto L17;
            r6 = Boolean.valueOf(r11.allowShowCart);
        L17:
            r10.append(r6);
            r9 = r10.toString();
        L19:
            return "";
        }

        @JvmStatic
        public static void f(a r1, RoomContextController r2) {
            Intrinsics.checkNotNullParameter(r1, "config");
            Intrinsics.checkNotNullParameter(r2, "roomContextController");
            if (r2.v() == false) goto L7;
            ECContext r3 = r2.r();
            if (r3 == null) goto L11;
            r3.getCartConfig().setValue(r1);
            return;
        L11:
            return;
        L7:
            int r4 = RoomContextController.h;
            ECContext r5 = RoomContextController.a.a().r();
            if (r5 == null) goto L13;
            r5.getCartConfig().setValue(r1);
            return;
        }
    }

    static {
        e = new C0119a();
        ECPromotionList.u r0 = EComABUtils.getRoomCartSetting();
        if (r0 == null) goto L5;
        de.a r1 = r0.roomCartIcons;
    L6:
        d = r1;
        return;
    L5:
        r1 = null;
        goto L6
    }

    public a(b r1, b r2) {
        this.b = r1;
        this.c = r2;
        this.a = d;
    }
}
