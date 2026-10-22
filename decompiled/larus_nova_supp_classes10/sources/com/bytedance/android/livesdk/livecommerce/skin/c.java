package com.bytedance.android.livesdk.livecommerce.skin;

import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveLayoutConfig;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements h {
    public Map<String, ECLiveLayoutConfig> a;
    public boolean b;
    public boolean c;
    public List<String> d;

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Boolean a() {
        Map<String, ECLiveLayoutConfig> r0 = this.a;
        if (r0 == null) goto L7;
        ECLiveLayoutConfig r1 = r0.get("button_area");
        if (r1 == null) goto L7;
        return r1.getWidthSelfAdapt();
    L7:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Pair<Integer, Integer> b() {
        return l("cover");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Pair<Integer, Integer> c() {
        Pair<Integer, Integer> r1 = l("add_cart_button");
        if (this.b == false) goto L23;
        if (this.c == false) goto L7;
        int r0 = 24;
    L8:
        if (r1 == null) goto L11;
        Pair<Integer, Integer> r2 = Pair.copy$default(r1, Integer.valueOf(r0), null, 2, null);
        if (r2 == null) goto L11;
        return r2;
    L11:
        Pair<Integer, Integer> r3 = j();
        if (r3 == null) goto L17;
        Integer r4 = (Integer) r3.getSecond();
        if (r4 == null) goto L17;
        int r5 = r4.intValue();
    L21:
        return TuplesKt.to(Integer.valueOf(r0), Integer.valueOf(r5));
    L17:
        if (this.c == false) goto L19;
        r5 = 26;
        goto L21
    L19:
        r5 = 40;
        goto L21
    L7:
        r0 = 34;
        goto L8
    L23:
        return l("add_cart_button");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final hl2.b d() {
        Map<String, ECLiveLayoutConfig> r0 = this.a;
        if (r0 == null) goto L8;
        ECLiveLayoutConfig r1 = r0.get("parent");
        if (r1 != null) goto L7;
        return null;
    L7:
        return new hl2.b(r1.getTopPadding(), r1.getBottomPadding(), r1.getLeftPadding(), r1.getRightPadding());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final hl2.b e() {
        Map<String, ECLiveLayoutConfig> r0 = this.a;
        if (r0 == null) goto L8;
        ECLiveLayoutConfig r1 = r0.get("price");
        if (r1 != null) goto L7;
        return null;
    L7:
        return new hl2.b(r1.getTopPadding(), r1.getBottomPadding(), r1.getLeftPadding(), r1.getRightPadding());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final hl2.a f() {
        Map<String, ECLiveLayoutConfig> r0 = this.a;
        if (r0 == null) goto L8;
        ECLiveLayoutConfig r1 = r0.get("parent");
        if (r1 != null) goto L7;
        return null;
    L7:
        return new hl2.a(r1.getTopMargin(), r1.getBottomMargin(), r1.getLeftMargin(), r1.getRightMargin());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final hl2.a g() {
        Map<String, ECLiveLayoutConfig> r0 = this.a;
        if (r0 == null) goto L8;
        ECLiveLayoutConfig r1 = r0.get("title");
        if (r1 != null) goto L7;
        return null;
    L7:
        return new hl2.a(r1.getTopMargin(), r1.getBottomMargin(), r1.getLeftMargin(), r1.getRightMargin());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final hl2.a h() {
        Map<String, ECLiveLayoutConfig> r0 = this.a;
        if (r0 == null) goto L8;
        ECLiveLayoutConfig r1 = r0.get("cover");
        if (r1 != null) goto L7;
        return null;
    L7:
        return new hl2.a(r1.getTopMargin(), r1.getBottomMargin(), r1.getLeftMargin(), r1.getRightMargin());
    L8:
        return null;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Pair<Integer, Integer> i() {
        return l("button_area");
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Pair<Integer, Integer> j() {
        Pair<Integer, Integer> r0 = l("button");
        if (this.b == true) goto L5;
        return r0;
    L5:
        if (this.c == false) goto L7;
        int r1 = 42;
    L9:
        if (r0 != null) goto L11;
        return null;
    L11:
        return Pair.copy$default(r0, Integer.valueOf(r1), null, 2, null);
    L7:
        r1 = 63;
        goto L9
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.h
    public final Pair<Integer, Integer> k() {
        return l("stepper_icon");
    }

    public c(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "layoutTypes");
        this.d = r2;
        ECLiveSkinUtil.l.getClass();
        this.a = ECLiveSkinUtil.e("promotion_card", r2);
    }

    public final Pair<Integer, Integer> l(String r4) {
        Map<String, ECLiveLayoutConfig> r0 = this.a;
        boolean r1 = false;
        if (r0 == null) goto L9;
        ECLiveLayoutConfig r2 = r0.get(r4);
        if (r2 == null) goto L9;
        Integer r3 = r2.getWidth();
        if (r3 == null) goto L9;
        int r5 = r3.intValue();
    L10:
        Map<String, ECLiveLayoutConfig> r6 = this.a;
        if (r6 == null) goto L17;
        ECLiveLayoutConfig r7 = r6.get(r4);
        if (r7 == null) goto L17;
        Integer r8 = r7.getHeight();
        if (r8 == null) goto L17;
        int r9 = r8.intValue();
    L18:
        if (r5 <= 0) goto L22;
        if (r9 <= 0) goto L22;
        r1 = true;
    L22:
        if (r1 == false) goto L24;
        c r10 = this;
    L25:
        if (r10 != null) goto L27;
        return null;
    L27:
        return new Pair(Integer.valueOf(r5), Integer.valueOf(r9));
    L24:
        r10 = null;
    L17:
        r9 = 0;
    L9:
        r5 = 0;
        goto L10
    }
}
