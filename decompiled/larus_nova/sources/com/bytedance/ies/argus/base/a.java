package com.bytedance.ies.argus.base;

import com.bytedance.ies.argus.bean.m;
import com.bytedance.ies.argus.repository.ArgusConfigManager;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f245937a = 0;

    static {
    }

    public static List a() {
        Lazy<ArgusConfigManager> r100 = ArgusConfigManager.f246083j;
        com.bytedance.ies.argus.bean.a r101 = ArgusConfigManager.a.a().b();
        if (r101 == null) goto L9;
        m r102 = r101.b();
        if (r102 == null) goto L9;
        List<String> r103 = r102.a();
        if (r103 == null) goto L9;
        return r103;
    L9:
        return CollectionsKt.emptyList();
    }
}
