package com.bytedance.ee.bear.document.container;

import com.ss.android.lark.chameleon.IWebService;
import java.util.List;
import kotlin.collections.CollectionsKt;
import vv4.m;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements IWebService {
    public c() {
    }

    @Override // com.ss.android.lark.chameleon.IWebService
    public final List<m> getWebService() {
        return CollectionsKt.listOf(new v35.a());
    }
}
