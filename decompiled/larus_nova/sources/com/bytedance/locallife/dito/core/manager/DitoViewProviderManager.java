package com.bytedance.locallife.dito.core.manager;

import com.bytedance.locallife.dito.provider.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes21.dex */
public final class DitoViewProviderManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<h> f257959a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f257960b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f257961c;

    public DitoViewProviderManager() {
        this.f257959a = new ArrayList();
        this.f257960b = LazyKt.lazy(DitoViewProviderManager$innerProviderList$2.INSTANCE);
        this.f257961c = LazyKt.lazy(new DitoViewProviderManager$fullProviderList$2(this));
    }
}
