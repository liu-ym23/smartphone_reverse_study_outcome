package com.ss.android.lark.security.protocol.clipboard.api;

import com.ss.android.lark.plugin.annotation.ScopeType;
import com.ss.android.lark.plugin.annotation.TrimisScope;

/* JADX INFO: loaded from: classes38.dex */
@TrimisScope(ScopeType.GLOBAL)
public interface IClipboardProtectionApi {
    boolean canPaste(String r100, String r101, String r102);
}
