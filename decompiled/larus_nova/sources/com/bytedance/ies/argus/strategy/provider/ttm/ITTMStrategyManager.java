package com.bytedance.ies.argus.strategy.provider.ttm;

import com.lynx.tasm.LynxTemplateRender;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b`\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0005H&J\u0018\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH&J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH&¨\u0006\u000f"}, d2 = {"Lcom/bytedance/ies/argus/strategy/provider/ttm/ITTMStrategyManager;", "", "", "hasInit", LynxTemplateRender.RENDER_PHASE_SETUP, "Lu06/a;", "getStrategyProvider", "", "codeString", "", "nativeExtendFuncAddress", "processTTMRuleByteCodeLong", "", "code", "parseTTMRuleByteCode", "anniex_release"}, k = 1, mv = {1, 4, 3})
public interface ITTMStrategyManager {
    u06.a getStrategyProvider();

    boolean hasInit();

    long parseTTMRuleByteCode(byte[] r100, long r101);

    long processTTMRuleByteCodeLong(String r100, long r101);

    boolean setup();
}
