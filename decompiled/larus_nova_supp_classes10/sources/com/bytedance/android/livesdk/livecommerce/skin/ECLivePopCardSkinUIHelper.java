package com.bytedance.android.livesdk.livecommerce.skin;

import android.graphics.drawable.Drawable;
import com.bytedance.android.livesdk.livecommerce.skin.model.AbsECLiveSkinBaseUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBackgroundElement;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBaseViewUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinBtnUIConfig;
import com.bytedance.android.livesdk.livecommerce.skin.model.ECLiveSkinImageElement;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class ECLivePopCardSkinUIHelper implements g {
    public final Map<String, AbsECLiveSkinBaseUIConfig> a;
    public final Lazy b;
    public final Lazy c;
    public final List<String> d;

    @Override // com.bytedance.android.livesdk.livecommerce.skin.g
    public final Pair a() {
        Map<String, AbsECLiveSkinBaseUIConfig> r0 = this.a;
        ECLiveSkinBackgroundElement r1 = null;
        if (r0 == null) goto L5;
        AbsECLiveSkinBaseUIConfig r2 = r0.get("buy_btn");
    L7:
        if ((r2 instanceof ECLiveSkinBtnUIConfig) == true) goto L9;
        r2 = null;
    L9:
        ECLiveSkinBtnUIConfig r3 = (ECLiveSkinBtnUIConfig) r2;
        if (r3 != null) goto L12;
        return null;
    L12:
        ECLiveSkinBaseViewUIConfig r4 = r3.getEnabled();
        if (r4 == null) goto L16;
        r1 = r4.getBackground();
    L16:
        return TuplesKt.to(r1, r3.getRadius());
    L5:
        r2 = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.g
    public final int[] e() {
        return (int[]) this.b.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.g
    public final int[] f() {
        return (int[]) this.c.getValue();
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.g
    public final Pair c() {
        Pair r0 = a();
        Drawable r1 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        ECLiveSkinBackgroundElement r2 = (ECLiveSkinBackgroundElement) r0.component1();
        List r3 = (List) r0.component2();
        if (r2 == null) goto L9;
        ECLiveSkinBackgroundElement.Companion.getClass();
        r1 = ECLiveSkinBackgroundElement.a.a(r2, null, r3, null);
    L9:
        return new Pair(r1, r3);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.g
    public final List<String> b() {
        return this.d;
    }

    public ECLivePopCardSkinUIHelper(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "themes");
        this.d = r2;
        ECLiveSkinUtil.l.getClass();
        this.a = ECLiveSkinUtil.f("pop_card", r2);
        this.b = LazyKt.lazy(ECLivePopCardSkinUIHelper$buttonOptStyleV1$2.INSTANCE);
        this.c = LazyKt.lazy(ECLivePopCardSkinUIHelper$buttonOptStyleV2$2.INSTANCE);
    }

    @Override // com.bytedance.android.livesdk.livecommerce.skin.g
    public final String d(boolean r3) {
        if (r3 == false) goto L7;
        Map<String, AbsECLiveSkinBaseUIConfig> r4 = this.a;
        if (r4 == null) goto L11;
        String r1 = "buy_btn_placeholder_nobg";
    L10:
        AbsECLiveSkinBaseUIConfig r5 = r4.get(r1);
    L13:
        if ((r5 instanceof ECLiveSkinBtnUIConfig) == true) goto L15;
        r5 = null;
    L15:
        ECLiveSkinBtnUIConfig r6 = (ECLiveSkinBtnUIConfig) r5;
        if (r6 != null) goto L18;
        return null;
    L18:
        ECLiveSkinBaseViewUIConfig r7 = r6.getEnabled();
        if (r7 == null) goto L28;
        ECLiveSkinImageElement r8 = r7.getImage();
        if (r8 == null) goto L29;
        String r9 = r8.getResourceName();
        if (r9 == null) goto L30;
        ECLiveSkinUtil.l.getClass();
        String r0 = ECLiveSkinUtil.b.get(r9);
        if (r0 == null) goto L27;
        return r0;
    L27:
        return r9;
    L30:
        return null;
    L29:
        return null;
    L28:
        return null;
    L11:
        r5 = null;
        goto L13
    L7:
        r4 = this.a;
        if (r4 == null) goto L11;
        r1 = "buy_btn_placeholder";
        goto L10
    }
}
