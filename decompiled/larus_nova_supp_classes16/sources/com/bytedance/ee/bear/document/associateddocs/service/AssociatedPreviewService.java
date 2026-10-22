package com.bytedance.ee.bear.document.associateddocs.service;

import android.content.Context;
import com.bytedance.ee.bear.document.associateddocs.AssociatedAppUrlListViewModel;
import com.bytedance.ee.bear.document.associateddocs.bean.DocAssociatedAppUrlInfos;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class AssociatedPreviewService {
    public static final Lazy<AssociatedPreviewService> c = null;
    public AssociatedAppUrlListViewModel.a a;
    public final HashMap<String, String> b;

    public static final class a {
    }

    static {
        c = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, AssociatedPreviewService$Companion$instance$2.INSTANCE);
    }

    public AssociatedPreviewService() {
        this.b = new HashMap();
    }

    public final void a(DocAssociatedAppUrlInfos r11, Context r12, AssociatedAppUrlListViewModel.d r13) {
        Intrinsics.checkNotNullParameter(r11, "urlsResult");
        Intrinsics.checkNotNullParameter(r12, "context");
        this.a = r13;
        ArrayList r3 = new ArrayList();
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getMain(), null, new AssociatedPreviewService$requestUrlPreview$1(r11, r3, this, r12, null), 2, null);
    }
}
