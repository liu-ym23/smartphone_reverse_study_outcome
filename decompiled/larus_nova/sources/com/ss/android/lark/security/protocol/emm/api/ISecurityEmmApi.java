package com.ss.android.lark.security.protocol.emm.api;

import com.ss.android.lark.plugin.annotation.ScopeType;
import com.ss.android.lark.plugin.annotation.TrimisScope;

/* JADX INFO: loaded from: classes38.dex */
@TrimisScope(ScopeType.GLOBAL)
public interface ISecurityEmmApi {
    void requestExemptionAction(SecurityBizType r100, SecurityActionType r101) throws Exception;
}
