package com.bytedance.android.shopping.card_list.common_params;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.card_list.container.b;
import com.bytedance.android.shopping.card_list.container.init.e;
import com.bytedance.android.shopping.card_list.params.CardPassThroughData;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import ti.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public CardPassThroughData a;
    public final Map<String, Object> b;
    public final Function0<AndroidYaTaInstance> c;
    public final List<e> d;
    public final List<String> e;
    public final List<String> f;
    public PageFinder g;
    public final b h;
    public final String i;
    public boolean j;
    public final Map<String, j> k;
    public final hb3.a l;
    public final boolean m;
    public int n;

    public final Map<String, ?> a() {
        Map r0 = ((AndroidYaTaInstance) this.c.invoke()).j();
        Object r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.get("feature_conf");
    L7:
        if ((r2 instanceof Map) == false) goto L11;
        r1 = r2;
    L11:
        return (Map) r1;
    L5:
        r2 = null;
        goto L7
    }

    public a(Function0 r8, String r9, boolean r10) {
        ArrayList r0 = new ArrayList();
        ArrayList r1 = new ArrayList();
        ArrayList r2 = new ArrayList();
        b r3 = new b();
        LinkedHashMap r4 = new LinkedHashMap();
        hb3.a r5 = new hb3.a();
        Intrinsics.checkNotNullParameter(r8, "yataInstance");
        Intrinsics.checkNotNullParameter(r0, "containerCallbacks");
        Intrinsics.checkNotNullParameter(r1, "selectedCartIds");
        Intrinsics.checkNotNullParameter(r2, "selectedShopIds");
        Intrinsics.checkNotNullParameter(r3, "renderState");
        Intrinsics.checkNotNullParameter(r9, "sessionId");
        Intrinsics.checkNotNullParameter(r4, "subscribeBridgeEvents");
        Intrinsics.checkNotNullParameter(r5, "customDataCenter");
        this.c = r8;
        this.d = r0;
        this.e = r1;
        this.f = r2;
        this.g = null;
        this.h = r3;
        this.i = r9;
        this.j = false;
        this.k = r4;
        this.l = r5;
        this.m = r10;
        this.n = 100;
        this.b = new LinkedHashMap();
    }
}
