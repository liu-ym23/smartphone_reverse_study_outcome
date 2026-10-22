package com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea;

import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ToolVO;
import java.util.ArrayList;
import java.util.List;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public final List<C0099a> a;
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.a b;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.toolarea.a$a, reason: collision with other inner class name */
    public static final class C0099a {
        public final int a;
        public ToolVO.Corner b;
        public final Integer c;

        public C0099a(int r1, ToolVO.Corner r2, Integer r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class b {
    }

    static {
    }

    public a(com.bytedance.android.shopping.mall.homepage.card.headercard.a r2) {
        Intrinsics.checkNotNullParameter(r2, "mallContext");
        this.b = r2;
        this.a = new ArrayList();
    }

    public final void a(boolean r11) {
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("search_cart_corner_send_event", System.currentTimeMillis(), this.b.i, false, MapsKt.mapOf(TuplesKt.to("data", Boolean.valueOf(r11))), false, 40));
    }
}
