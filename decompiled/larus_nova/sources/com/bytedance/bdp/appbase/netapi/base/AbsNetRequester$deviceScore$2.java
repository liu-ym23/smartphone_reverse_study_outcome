package com.bytedance.bdp.appbase.netapi.base;

import com.bytedance.bdp.appbase.base.abtest.BdpAbTestService;
import com.bytedance.bdp.bdpbase.manager.BdpManager;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Double;"}, k = 3, mv = {1, 1, 18})
public final class AbsNetRequester$deviceScore$2 extends Lambda implements Function0<Double> {
    public static final AbsNetRequester$deviceScore$2 INSTANCE = null;

    static {
        INSTANCE = new AbsNetRequester$deviceScore$2();
    }

    public AbsNetRequester$deviceScore$2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Double invoke() {
        JSONObject r100 = ((BdpAbTestService) BdpManager.getInst().getService(BdpAbTestService.class)).C2();
        if (r100 != null) goto L7;
        return null;
    L7:
        return Double.valueOf(r100.optDouble("overall"));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Double invoke() {
        return invoke();
    }
}
