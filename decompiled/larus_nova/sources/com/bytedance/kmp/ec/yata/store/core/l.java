package com.bytedance.kmp.ec.yata.store.core;

import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f251747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<RenderTreeStruct> f251748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<RenderTreeStruct> f251749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<e> f251750d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f251751e;

    public static final class a {
    }

    static {
    }

    public final aa6.b a() {
        k r100 = this.f251747a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f251746b;
    }

    public l(YataStoreWrapper r100, k r101, List r102, List r103, List r104) {
        Intrinsics.checkNotNullParameter(r100, "storeWrapper");
        this.f251747a = r101;
        this.f251748b = r102;
        this.f251749c = r103;
        this.f251750d = r104;
        this.f251751e = LazyKt.lazy(new YataState$renderObjectMap$2(this));
    }
}
