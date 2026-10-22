package com.bytedance.android.shopping.mall.homepage.card.headercard;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.api.mall.model.SkinConfig;
import com.bytedance.android.shopping.api.mall.model.SkinConfigStyle;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends ef3.a {
    public BtmData j;
    public final String k;
    public HeaderCardData l;
    public View m;
    public SkinConfig n;
    public CoroutineScope o;

    public final SkinConfigStyle b() {
        if (this.c == false) goto L7;
        SkinConfig r0 = this.n;
        if (r0 != null) goto L12;
        return null;
    L12:
        return r0.getDark();
    L7:
        SkinConfig r1 = this.n;
        if (r1 != null) goto L10;
        return null;
    L10:
        return r1.getLight();
    }

    @Override // ef3.a, ef3.b
    public final void onRelease() {
        super.onRelease();
        CoroutineScope r0 = this.o;
        if (r0 == null) goto L6;
        CoroutineScopeKt.cancel$default(r0, null, 1, null);
        return;
    }

    @Override // ef3.a, ef3.b
    public final void N2(View r4) {
        Intrinsics.checkNotNullParameter(r4, "cardView");
        this.m = r4;
        this.o = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault().plus(JobKt.Job$default(null, 1, null)));
        super.N2(r4);
    }

    public a(Context r2, ECMallFeed r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "mallFeed");
        Intrinsics.checkNotNullParameter(r4, "sceneID");
        super(r2, r3, r4);
        this.k = "ec_na_mall_header";
    }
}
