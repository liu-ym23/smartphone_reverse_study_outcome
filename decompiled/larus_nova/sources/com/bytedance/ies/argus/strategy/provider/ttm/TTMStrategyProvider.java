package com.bytedance.ies.argus.strategy.provider.ttm;

import com.bytedance.ies.argus.api.params.BaseAspectParams;
import com.bytedance.ies.argus.bean.ArgusCommonVerifyReason;
import com.bytedance.ies.argus.bean.ArgusStrategyProviderType;
import com.bytedance.ies.argus.bean.AspectConfigItem;
import com.bytedance.ies.argus.bean.AspectContext;
import com.bytedance.ies.argus.bean.i;
import com.bytedance.ies.argus.bean.x;
import com.bytedance.ies.argus.strategy.ArgusTTMStrategyManagerWrapper;
import com.bytedance.ies.argus.strategy.GlobalStrategyManager;
import com.heytap.mcssdk.constant.b;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.tiktok.ttm.TTMCore;
import com.tiktok.ttm.TTMInput;
import com.tiktok.ttm.TTMOutput;
import com.tiktok.ttm.TTMParamData;
import com.tiktok.ttm.ttmparam.ITTMParamData;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import t06.d;

/* JADX INFO: loaded from: classes19.dex */
public final class TTMStrategyProvider extends u06.a {

    public static final class a {
    }

    static {
    }

    public TTMStrategyProvider() {
    }

    @Override // u06.a
    public final ArgusStrategyProviderType b() {
        return ArgusStrategyProviderType.TTMACHINE;
    }

    public static ITTMParamData c(final String r100, final AspectContext.a r101) {
        return new TTMStrategyProvider$initTTMData$1(r101, r100);
    }

    @Override // u06.a
    public final void a(AspectConfigItem.a r100, d r101, AspectContext<? extends BaseAspectParams<?>, ? extends com.bytedance.ies.argus.strategy.a>.a r110) {
        Intrinsics.checkNotNullParameter(r100, b.f276366p);
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        i<REWRITE_PAYLOAD> r102 = r110.f246003b;
        String r103 = r100.f245984a;
        String r104 = r100.e();
        GlobalStrategyManager.f246150a.getClass();
        ITTMStrategyManager r105 = ArgusTTMStrategyManagerWrapper.f246142c.getValue().f246145b;
        if (r104 == null) goto L6;
        r110.f246003b.a("ttm_rule_version", r104);
    L6:
        if (r105 != null) goto L8;
        i.g(r102, ArgusCommonVerifyReason.TTM_IS_NOT_ENABLED, null, 6);
        return;
    L8:
        if (r103 != null) goto L10;
        i.g(r102, ArgusCommonVerifyReason.TTM_RULE_NAME_IS_NULL, null, 6);
        return;
    L10:
        if (r104 != null) goto L12;
        i.g(r102, ArgusCommonVerifyReason.TTM_RULE_VERSION_IS_NULL, null, 6);
        return;
    L12:
        Intrinsics.checkNotNullParameter(r103, "name");
        Intrinsics.checkNotNullParameter(r104, "version");
        Map r106 = (Map) ((LinkedHashMap) GlobalStrategyManager.f246151b).get(r103);
        if (r106 == null) goto L15;
        x r107 = (x) r106.get(r104);
    L17:
        if (r107 != null) goto L19;
        i.g(r102, ArgusCommonVerifyReason.TTM_RULE_INFO_IS_NULL, "v=".concat(r104), 4);
        return;
    L19:
        Long r108 = r107.f246064f;
        if (r108 != null) goto L22;
        GlobalStrategyManager.e(r107);
        r108 = r107.f246064f;
    L22:
        if (r108 != null) goto L24;
        i.g(r102, ArgusCommonVerifyReason.TTM_RULE_ADDRESS_IS_NULL, "v=".concat(r104), 4);
        return;
    L24:
        TTMInput r109 = new TTMInput();
        r109.machineCodeAddress = r108.longValue();
        r109.paramType = TTMInput.ParamType.TYPE_MAP;
        r109.paramData = new TTMParamData(c(r103, r110));
        TTMOutput r111 = TTMCore.getInstance().execute(r109);
        int r112 = com.bytedance.ies.argus.base.d.f245942a;
        com.bytedance.ies.argus.base.d.a("TTMStrategyProvider", "ttm_output: " + r111.getMsg() + ' ' + r111.getData());
        if (r111.getType() != TTMOutput.ReturnType.ERROR) goto L33;
        String r113 = "run " + r103 + '#' + r104 + " got " + r111.getMsg() + ' ' + r111.getData();
        i.g(r102, ArgusCommonVerifyReason.RUN_TTM_ERROR, r113, 4);
        com.bytedance.ies.argus.base.d.b("TTMStrategyProvider", r113, null, 12);
        return;
    L33:
        return;
    L15:
        r107 = null;
        goto L17
    }
}
