package com.bytedance.android.shopping.new_cart.container;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.shopping.new_cart.params.CartParams;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public float a;
    public final Map<String, Object> b;
    public CartParams c;
    public final Function0<AndroidYaTaInstance> d;
    public final List<v> e;
    public final List<String> f;
    public final List<String> g;
    public final List<String> h;
    public final List<String> i;
    public PageFinder j;
    public final boolean k;
    public final t l;
    public final String m;
    public boolean n;
    public final Map<String, ti.j> o;
    public final boolean p;
    public int q;

    public final Map<String, ?> a() {
        Map r0 = ((AndroidYaTaInstance) this.d.invoke()).j();
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

    public final void b(CartParams r18) {
        if (r18 != null) goto L5;
        return;
    L5:
        this.c = r18;
        this.f.clear();
        this.g.clear();
        String r3 = r18.getShopIds();
        if (r3 == null) goto L10;
        List r4 = StringsKt.split$default(r3, new char[]{','}, false, 0, 6, null);
        if (r4 == null) goto L10;
        this.g.addAll(r4);
    L10:
        String r11 = r18.getCartIds();
        if (r11 == null) goto L16;
        List r1 = StringsKt.split$default(r11, new char[]{','}, false, 0, 6, null);
        if (r1 == null) goto L17;
        this.f.addAll(r1);
        return;
    L17:
        return;
    }

    public b(Function0 r12, String r13, boolean r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        ArrayList r0 = new ArrayList();
    L7:
        if ((r15 & 4) == 0) goto L9;
        ArrayList r2 = new ArrayList();
    L11:
        if ((r15 & 8) == 0) goto L13;
        ArrayList r3 = new ArrayList();
    L15:
        if ((r15 & 16) == 0) goto L17;
        ArrayList r4 = new ArrayList();
    L19:
        if ((r15 & 32) == 0) goto L21;
        ArrayList r5 = new ArrayList();
    L23:
        if ((r15 & 128) == 0) goto L25;
        boolean r6 = true;
    L27:
        if ((r15 & 256) == 0) goto L29;
        t r8 = new t();
    L31:
        if ((r15 & 512) == 0) goto L34;
        r13 = "none";
    L34:
        if ((r15 & 2048) == 0) goto L36;
        LinkedHashMap r9 = new LinkedHashMap();
    L38:
        if ((r15 & 4096) == 0) goto L41;
        r14 = false;
    L41:
        if ((r15 & 8192) == 0) goto L43;
        int r16 = 100;
    L44:
        Intrinsics.checkNotNullParameter(r12, "yataInstance");
        Intrinsics.checkNotNullParameter(r0, "containerCallbacks");
        Intrinsics.checkNotNullParameter(r2, "selectedCartIds");
        Intrinsics.checkNotNullParameter(r3, "selectedShopIds");
        Intrinsics.checkNotNullParameter(r4, "unselectedCartIds");
        Intrinsics.checkNotNullParameter(r5, "unselectedShopIds");
        Intrinsics.checkNotNullParameter(r8, "cartRenderState");
        Intrinsics.checkNotNullParameter(r13, "sessionId");
        Intrinsics.checkNotNullParameter(r9, "subscribeBridgeEvents");
        this.d = r12;
        this.e = r0;
        this.f = r2;
        this.g = r3;
        this.h = r4;
        this.i = r5;
        this.j = null;
        this.k = r6;
        this.l = r8;
        this.m = r13;
        this.n = false;
        this.o = r9;
        this.p = r14;
        this.q = r16;
        this.b = new LinkedHashMap();
        return;
    L43:
        r16 = 0;
        goto L44
    L36:
        r9 = null;
        goto L38
    L29:
        r8 = null;
        goto L31
    L25:
        r6 = false;
        goto L27
    L21:
        r5 = null;
        goto L23
    L17:
        r4 = null;
        goto L19
    L13:
        r3 = null;
        goto L15
    L9:
        r2 = null;
        goto L11
    L5:
        r0 = null;
        goto L7
    }
}
