package com.bytedance.android.shopping.slice.action;

import com.bytedance.android.ecom.arch.slice.action.ActionContext;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.ecom.arch.slice.action.c;
import com.bytedance.android.ecom.arch.slice.action.d;
import com.bytedance.android.ecom.arch.slice.action.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011JH\u0010\u000b\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J:\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u00052\u0016\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/shopping/slice/action/PDPDrillHandler;", "Lcom/bytedance/android/ecom/arch/slice/action/e;", "", "", "", "Lcom/bytedance/android/ecom/arch/slice/action/SlcCommonAction;", "action", "actionParams", "Lcom/bytedance/android/ecom/arch/slice/action/c;", "actionUIContext", "Lcom/bytedance/android/ecom/arch/slice/action/d;", "checkParam", "Lcom/bytedance/android/ecom/arch/slice/action/ActionContext;", "actionContext", "", "onHandle", "<init>", "()V", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PDPDrillHandler extends e<Map<String, ? extends Object>> {
    public void onHandle(ActionContext r1, SlcCommonAction r2, Map<String, ? extends Object> r3, c r4) {
        Intrinsics.checkNotNullParameter(r1, "actionContext");
        Intrinsics.checkNotNullParameter(r2, "action");
    }

    public PDPDrillHandler() {
    }

    public d<Map<String, Object>> checkParam(SlcCommonAction r1, Map<String, ? extends Object> r2, c r3) {
        Intrinsics.checkNotNullParameter(r1, "action");
        int r4 = d.d;
        return d.a.b(r2);
    }

    public /* bridge */ /* synthetic */ void onHandle(ActionContext r1, SlcCommonAction r2, Object r3, c r4) {
        onHandle(r1, r2, (Map) r3, r4);
    }
}
