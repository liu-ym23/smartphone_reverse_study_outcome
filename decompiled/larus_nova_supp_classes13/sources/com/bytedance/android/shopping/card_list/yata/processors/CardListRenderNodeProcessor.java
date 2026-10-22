package com.bytedance.android.shopping.card_list.yata.processors;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.host.api.split.ECFoldScene;
import com.bytedance.android.ec.hybrid.ECHybridExtensionsKt;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.android.shopping.card_list.params.CartPassThroughData;
import com.bytedance.android.shopping.card_list.utils.CardListCommonLog;
import com.bytedance.android.shopping.extensions.b;
import com.bytedance.kmp.ec.yata.store.core.a;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class CardListRenderNodeProcessor extends a {
    public final Integer a;
    public final CardListObjectContainer b;

    public final void d() {
        this.b.e.e.clear();
    }

    public final void e() {
        this.b.e.f.clear();
        this.b.e.e.clear();
    }

    public final int f() {
        CardPassThroughData r0 = this.b.e.a;
        Insets r1 = null;
        if (r0 == null) goto L5;
        String r2 = r0.getSplitActivityScene();
    L6:
        Activity r3 = l0.b(this.b.getContext());
        if (r3 == null) goto L15;
        Window r4 = r3.getWindow();
        if (r4 == null) goto L15;
        View r5 = r4.getDecorView();
        if (c.e == false) goto L16;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r6 = ThreadMethodProxy.currentThread();
        if (r6 == c.a) goto L16;
        c.a(r6, "getDecorView");
    L16:
        if (r5 == null) goto L18;
        WindowInsetsCompat r7 = ViewCompat.getRootWindowInsets(r5);
    L19:
        if (r7 == null) goto L22;
        r1 = r7.getInsets(WindowInsetsCompat.Type.systemBars());
    L22:
        if (r1 == null) goto L28;
        Object r8 = b.f(Integer.valueOf(r1.bottom));
        if (r8 == null) goto L28;
        Integer r9 = ECHybridExtensionsKt.i(r8);
        if (r9 == null) goto L28;
        int r10 = r9.intValue();
    L29:
        if (r10 != 0) goto L38;
        if (Intrinsics.areEqual(r2, ECFoldScene.MALL.name()) == false) goto L34;
    L44:
        return 5;
    L34:
        if (Intrinsics.areEqual(r2, ECFoldScene.LIVE.name()) == true) goto L47;
        return 12;
    L47:
        return 13;
    L38:
        if (1 <= r10) goto L41;
        return 0;
    L41:
        if (34 >= r10) goto L43;
        return 0;
    L43:
        if (Intrinsics.areEqual(r2, ECFoldScene.MALL.name()) == true) goto L44;
        if (Intrinsics.areEqual(r2, ECFoldScene.LIVE.name()) == true) goto L47;
        return 34 - r10;
    L28:
        r10 = 0;
        goto L29
    L18:
        r7 = null;
    L15:
        r5 = null;
        goto L16
    L5:
        r2 = null;
        goto L6
    }

    public final Integer g() {
        Integer r0 = this.a;
        String r1 = null;
        if (r0 == null) goto L13;
        int r2 = r0.intValue();
        CardPassThroughData r3 = this.b.e.a;
        if (r3 == null) goto L8;
        r1 = r3.getSplitActivityScene();
    L8:
        if (Intrinsics.areEqual(r1, ECFoldScene.LIVE.name()) == false) goto L10;
        int r4 = 7;
    L12:
        return Integer.valueOf(r2 + r4);
    L10:
        r4 = 0;
        goto L12
    L13:
        return null;
    }

    public CardListRenderNodeProcessor(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.b = r2;
        this.a = ECHybridExtensionsKt.i(b.f(Integer.valueOf(eh.b.b(r2.getContext()))));
    }

    public final void b(a.a r4) {
        Intrinsics.checkNotNullParameter(r4, "modifier");
        String r0 = r4.c();
        if (r0 != null) goto L6;
        return;
    L6:
        switch(r0.hashCode()) {
            case -1665880638: goto L37;
            case -891535336: goto L34;
            case -397099026: goto L31;
            case 6871542: goto L24;
            case 287836899: goto L15;
            case 1014047840: goto L12;
            case 2109560828: goto L9;
            default: goto L57;
        };
    L57:
        return;
    L9:
        if (r0.equals("mix_cart_product_card") == true) goto L38;
        return;
    L38:
        hb3.a r1 = this.b.e.l;
        String r2 = r4.b();
        Map r3 = (Map) ((LinkedHashMap) r1.a).get(r2);
        if (r3 == null) goto L55;
        Iterator r5 = r3.entrySet().iterator();
    L42:
        if (r5.hasNext() == false) goto L58;
        Map.Entry r6 = (Map.Entry) r5.next();
        r4.e((String) r6.getKey(), r6.getValue());
        goto L42
    L58:
        return;
    L55:
        return;
    L12:
        if (r0.equals("product_card") == true) goto L38;
        return;
    L15:
        if (r0.equals("cart_header_card") == false) goto L47;
        Lazy r7 = CardListCommonLog.a;
        CardListCommonLog.a("CardListRenderNodeProcessor", new CardListRenderNodeProcessor$doProcessModify$1(this));
        r4.e("padding_top", g());
        CardPassThroughData r8 = this.b.e.a;
        if (r8 == null) goto L21;
        CartPassThroughData r9 = r8.getCartSchemaData();
        if (r9 == null) goto L21;
        String r10 = r9.getNewSourceType();
    L22:
        r4.e("is_xtab", Boolean.valueOf(Intrinsics.areEqual(r10, "homepage_bottom_tab")));
        return;
    L21:
        r10 = null;
        goto L22
    L47:
        return;
    L24:
        if (r0.equals("cart_tab") == true) goto L26;
        return;
    L26:
        if (this.b.e.n != 100) goto L28;
        boolean r11 = true;
    L29:
        r4.e("show", Boolean.valueOf(r11));
        return;
    L28:
        r11 = false;
        goto L29
    L31:
        if (r0.equals("srp_product_card") == true) goto L38;
        return;
    L34:
        if (r0.equals("submit") == false) goto L52;
        Lazy r12 = CardListCommonLog.a;
        CardListCommonLog.a("CardListRenderNodeProcessor", new CardListRenderNodeProcessor$doProcessModify$2(this));
        r4.e("padding_bottom", Integer.valueOf(f()));
        return;
    L52:
        return;
    L37:
        if (r0.equals("product_card_ext") == true) goto L38;
    }

    public final void c(a.a r4) {
        Intrinsics.checkNotNullParameter(r4, "modifier");
        String r0 = r4.b();
        Map r5 = r4.a();
        if (r0 == null) goto L7;
        if (r5 == null) goto L8;
        hb3.a r1 = this.b.e.l;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "nodeKey");
        Intrinsics.checkNotNullParameter(r5, "map");
        r1.a.put(r0, MapsKt.toMutableMap(r5));
        return;
    L8:
        return;
    }
}
