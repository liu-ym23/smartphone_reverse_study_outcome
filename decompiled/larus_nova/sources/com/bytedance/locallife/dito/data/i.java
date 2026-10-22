package com.bytedance.locallife.dito.data;

import com.bytedance.locallife.dito.core.manager.DitoUpdateData;
import com.bytedance.locallife.dito.model.BaseDitoModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DitoPage f258199a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f258200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<DitoUpdateData> f258201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<BaseDitoModel<?>> f258202d;

    public i() {
        throw null;
    }

    public i(DitoPage r100, boolean r101, List r102) {
        ArrayList r103 = new ArrayList();
        Intrinsics.checkNotNullParameter(r100, "ditoPage");
        Intrinsics.checkNotNullParameter(r102, "updateDataList");
        Intrinsics.checkNotNullParameter(r103, "originBodyList");
        this.f258199a = r100;
        this.f258200b = r101;
        this.f258201c = r102;
        this.f258202d = r103;
    }
}
