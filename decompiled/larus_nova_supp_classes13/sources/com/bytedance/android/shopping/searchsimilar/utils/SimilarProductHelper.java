package com.bytedance.android.shopping.searchsimilar.utils;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.n;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.searchsimilar.SimilarProductFragment;
import com.bytedance.android.shopping.searchsimilar.model.SimilarProductParam;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SimilarProductHelper {
    public Activity a;
    public String b;

    public SimilarProductHelper() {
        this.b = "";
    }

    public final void a(Context r8, final Uri r9, final boolean r10) {
        Intrinsics.checkNotNullParameter(r9, "uri");
        if (r8 == null) goto L20;
        n.b(r8, r10, null, new SimilarProductHelper$startFromSchema$$inlined$let$lambda$1(this, r10, r9), SimilarProductHelper$startFromSchema$1$2.INSTANCE);
        String r11 = com.bytedance.android.shopping.monitor.d.c("ec_similar_product_page_duration");
        this.b = r11;
        com.bytedance.android.shopping.monitor.d.f(r11).a("duration");
        com.bytedance.android.shopping.monitor.d.f(this.b).a("api_duration");
        FragmentActivity r12 = this.a;
        if (r12 == null) goto L21;
        SimilarProductParam.a r13 = SimilarProductParam.Companion;
        String r6 = this.b;
        r13.getClass();
        Intrinsics.checkNotNullParameter(r9, "uri");
        Intrinsics.checkNotNullParameter(r6, "mCurMonitorName");
        String r14 = j1.c(r9, SimilarProductParam.AWEME_ID);
        if (r14 != null) goto L9;
        String r2 = "";
    L10:
        String r15 = j1.c(r9, SimilarProductParam.ENTER_FROM);
        if (r15 != null) goto L13;
        String r3 = "";
    L14:
        String r16 = j1.c(r9, "author_id");
        if (r16 != null) goto L17;
        String r4 = "";
    L18:
        SimilarProductParam r17 = new SimilarProductParam(r2, r3, r4, Integer.valueOf(k.r(j1.c(r9, SimilarProductParam.TOTAL_PANEL_HEIGHT), 0)), r6);
        int r18 = SimilarProductFragment.M;
        FragmentManager r19 = r12.getSupportFragmentManager();
        Intrinsics.checkNotNullParameter(r17, "param");
        SimilarProductFragment r0 = new SimilarProductFragment();
        Bundle r1 = new Bundle();
        r1.putSerializable("param_key", r17);
        Unit r110 = Unit.INSTANCE;
        r0.setArguments(r1);
        r0.X90(r12, r19);
        return;
    L17:
        r4 = r16;
        goto L18
    L13:
        r3 = r15;
        goto L14
    L9:
        r2 = r14;
        goto L10
    L21:
        return;
    }
}
