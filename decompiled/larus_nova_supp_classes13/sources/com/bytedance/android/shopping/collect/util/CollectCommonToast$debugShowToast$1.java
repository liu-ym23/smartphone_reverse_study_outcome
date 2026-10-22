package com.bytedance.android.shopping.collect.util;

import android.app.Activity;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.ui.ec.widget.tools.ECToastUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class CollectCommonToast$debugShowToast$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $str;

    public CollectCommonToast$debugShowToast$1(String r1) {
        this.$str = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m696invoke() {
        ECAppInfoService r0 = ECAppInfoService.e;
        if (r0.i() == false) goto L9;
        ECToastUtils r1 = ECToastUtils.INSTANCE;
        Activity r2 = r0.getCurrentActivity();
        String r3 = this.$str;
        if (r3 != null) goto L7;
        r3 = "";
    L7:
        r1.showToast(r2, r3, Boolean.TRUE);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m696invoke();
        return Unit.INSTANCE;
    }
}
