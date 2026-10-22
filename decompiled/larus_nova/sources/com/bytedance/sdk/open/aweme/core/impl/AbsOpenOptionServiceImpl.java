package com.bytedance.sdk.open.aweme.core.impl;

import com.bytedance.sdk.open.aweme.core.OpenOptionService;
import java.util.HashMap;

/* JADX INFO: loaded from: classes22.dex */
public abstract class AbsOpenOptionServiceImpl implements OpenOptionService {
    public AbsOpenOptionServiceImpl() {
    }

    @Override // com.bytedance.sdk.open.aweme.core.OpenOptionService
    public abstract HashMap<String, String> getCommonParams();
}
