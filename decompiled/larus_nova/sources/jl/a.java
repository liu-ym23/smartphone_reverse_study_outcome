package jl;

import com.bytedance.android.ec.model.sku.SkuRestoreState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SkuRestoreState f499520a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f499521b;

    public a(String r100, SkuRestoreState r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "eventSessionId");
        Intrinsics.checkNotNullParameter(r102, "skuSessionId");
        this.f499520a = r101;
        this.f499521b = r102;
    }
}
