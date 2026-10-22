package com.bytedance.locallife.pdp.container;

import com.bytedance.locallife.pdp.view.GoodsDetailDialogFragment;
import com.vivo.push.PushClientConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class c<T extends GoodsDetailDialogFragment> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f261133a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f261134b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<T> f261135c;

    /* JADX WARN: Multi-variable type inference failed */
    public c(String r100, String r101, Function0<? extends T> r102) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "simpleName");
        Intrinsics.checkNotNullParameter(r102, "getIns");
        this.f261133a = r100;
        this.f261134b = r101;
        this.f261135c = r102;
    }
}
