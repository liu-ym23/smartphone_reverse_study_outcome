package com.bytedance.ies.argus.strategy.provider.ttm;

import android.app.Application;
import com.bytedance.ies.argus.base.ArgusEnv;
import com.bytedance.ies.argus.base.d;
import com.lynx.tasm.LynxTemplateRender;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.tiktok.ttm.TTMCore;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0016R\u0014\u0010\u0010\u001a\u00020\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/ttm/TTMStrategyManager;", "Lcom/bytedance/ies/argus/strategy/provider/ttm/ITTMStrategyManager;", "", "hasInit", LynxTemplateRender.RENDER_PHASE_SETUP, "Lu06/a;", "getStrategyProvider", "", "codeString", "", "nativeExtendFuncAddress", "processTTMRuleByteCodeLong", "", "code", "parseTTMRuleByteCode", "Lcom/bytedance/ies/argus/strategy/provider/ttm/TTMStrategyProvider;", "strategyProvider", "Lcom/bytedance/ies/argus/strategy/provider/ttm/TTMStrategyProvider;", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "anniex_release"}, k = 1, mv = {1, 4, 3})
public final class TTMStrategyManager implements ITTMStrategyManager {
    public static final a Companion = null;
    public static final String TAG = "TTMStrategyManager";
    private final TTMStrategyProvider strategyProvider;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements TTMCore.MetricReporter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f246239a = null;

        static {
            f246239a = new b();
        }

        public b() {
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public boolean setup() {
        Lazy<ArgusEnv> r100 = ArgusEnv.f245917d;
        r06.a r101 = ArgusEnv.b.a().f245918a;
        if (r101 == null) goto L5;
        Application r102 = r101.f535465d;
    L7:
        if (r102 == null) goto L9;
        TTMCore.Config r103 = new TTMCore.Config();
        r103.globalEnable = true;
        r103.reportEnable = true;
        r103.crashDumpEnable = true;
        r103.multiInstCacheEnable = true;
        r103.multiInstCacheMaxSize = 30;
        r103.multiInstCacheDefaultSize = 20;
        r103.timeStaticConfig = 0;
        r103.coreBuriedSamplingRate = 100000;
        r103.generalBuriedSamplingRate = 100000;
        r103.openJniCallOptimize = true;
        r103.metricReporter = b.f246239a;
        r103.machineWorkDir = r102.getFilesDir().getAbsolutePath();
        TTMCore.getInstance().initTTM(r103);
    L10:
        boolean r104 = hasInit();
        if (r104 == true) goto L13;
        d.b(TAG, "ttm init failed", null, 12);
    L13:
        return r104;
    L9:
        d.b(TAG, "init ttm error: application is null", null, 12);
        goto L10
    L5:
        r102 = null;
        goto L7
    }

    public TTMStrategyManager() {
        this.strategyProvider = new TTMStrategyProvider();
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public boolean hasInit() {
        return TTMCore.getInstance().isInit();
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public u06.a getStrategyProvider() {
        return this.strategyProvider;
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public long parseTTMRuleByteCode(byte[] r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "code");
        return TTMCore.getInstance().parseTTMRuleByteCode(r100, r101);
    }

    @Override // com.bytedance.ies.argus.strategy.provider.ttm.ITTMStrategyManager
    public long processTTMRuleByteCodeLong(String r100, long r101) {
        Intrinsics.checkNotNullParameter(r100, "codeString");
        return TTMCore.getInstance().parseTTMRuleByteCode(r100, r101);
    }
}
