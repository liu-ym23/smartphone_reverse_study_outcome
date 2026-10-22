package com.bytedance.ee.bear.list.more.more3;

import android.os.Bundle;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.list.dto.Document;
import com.bytedance.ee.bear.list.t0;
import com.bytedance.ee.bear.more.protocol3.extension.BaseMoreProvider;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class SpaceBitableLandingMoreProvider extends BaseMoreProvider {
    public final Document m;
    public final String n;
    public final SpaceMoreItemFactory o;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.ee.bear.more.protocol3.h
    public final com.bytedance.ee.bear.more.protocol3.c b() {
        return com.bytedance.ee.bear.more.protocol3.extension.t.c(this, new SpaceBitableLandingMoreProvider$buildMoreItems$1(this));
    }

    @Override // com.bytedance.ee.bear.more.protocol3.extension.v, com.bytedance.ee.bear.more.protocol3.h
    public final void d() {
        super.d();
        oj5.a r0 = t0.h(this.m, this.n, this.o.j);
        int r2 = t.a;
        BearUrl r3 = t.b(this.m);
        Intrinsics.checkNotNull(r0);
        k(new wj5.a(r3, r0));
    }

    public SpaceBitableLandingMoreProvider(Document r2, String r3, SpaceMoreItemFactory r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "document");
        Intrinsics.checkNotNullParameter(r4, "factory");
        this.m = r2;
        this.n = r3;
        this.o = r4;
        Bundle r6 = new Bundle();
        r6.putString("event_name", "ccm_base_homepage_right_click_menu_click");
        r6.putString("current_sub_view", r5);
        this.c = r6;
    }
}
