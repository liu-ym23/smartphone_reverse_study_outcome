package com.bytedance.locallife.poi.newdetail.mob;

import com.ss.android.ugc.aweme.poi.model.PoiBundle;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class DouPlusStayEventHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PoiBundle f263281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f263282b;

    public DouPlusStayEventHelper(PoiBundle r100) {
        Intrinsics.checkNotNullParameter(r100, "poiBundle");
        this.f263281a = r100;
        this.f263282b = LazyKt.lazy(DouPlusStayEventHelper$handler$2.INSTANCE);
    }
}
