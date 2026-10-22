package com.bytedance.ee.bear.document.associateddocs.service;

import android.content.Context;
import com.bytedance.ee.bear.document.associateddocs.AssociatedAppUrlListViewModel;
import com.bytedance.ee.bear.document.associateddocs.bean.DocAssociatedAppUrlInfos;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes16.dex */
public final class AssociatedPreviewService {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy<AssociatedPreviewService> f219010c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AssociatedAppUrlListViewModel.a f219011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, String> f219012b;

    public static final class a {
    }

    static {
        f219010c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AssociatedPreviewService$Companion$instance$2.INSTANCE);
    }

    public AssociatedPreviewService() {
        this.f219012b = new HashMap();
    }

    public final void a(DocAssociatedAppUrlInfos r110, Context r111, AssociatedAppUrlListViewModel.d r112) {
        Intrinsics.checkNotNullParameter(r110, "urlsResult");
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f219011a = r112;
        ArrayList r100 = new ArrayList();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new AssociatedPreviewService$requestUrlPreview$1(r110, r100, this, r111, null), 2, null);
    }
}
