package com.bytedance.android.shopping.sku.common.utils;

import android.content.Context;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.tools.ECToastUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class SkuCommonToast$showToast$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $longLength;
    final /* synthetic */ String $str;

    public SkuCommonToast$showToast$1(Context r1, String r2, boolean r3) {
        this.$context = r1;
        this.$str = r2;
        this.$longLength = r3;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m2812invoke() {
        ECToastUtils r0 = ECToastUtils.INSTANCE;
        Context r1 = this.$context;
        if (r1 != null) goto L5;
        r1 = ECAppInfoService.e.getCurrentActivity();
    L5:
        String r2 = this.$str;
        if (r2 != null) goto L8;
        r2 = "";
    L8:
        r0.showToast(r1, r2, Boolean.valueOf(!this.$longLength));
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m2812invoke();
        return Unit.INSTANCE;
    }
}
