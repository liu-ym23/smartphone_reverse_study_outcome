package oo;

import com.bytedance.android.ec.window.base.dynamicview.common.e;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<com.bytedance.android.ec.window.base.dynamicview.virtualview.a> f524505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.android.ec.window.base.dynamicview.virtualview.c f524506b;

    public c(List<com.bytedance.android.ec.window.base.dynamicview.virtualview.a> r100, com.bytedance.android.ec.window.base.dynamicview.virtualview.c r101) {
        Intrinsics.checkNotNullParameter(r100, "constraints");
        Intrinsics.checkNotNullParameter(r101, "constraintOptions");
        this.f524505a = r100;
        this.f524506b = r101;
    }
}
