package com.bytedance.creativex.mediaimport.repository.internal.publisher;

import com.bytedance.creativex.mediaimport.repository.api.IFolderItem;
import com.bytedance.creativex.mediaimport.repository.internal.main.DefaultMaterialRepositoryReleaser;
import java.util.Map;
import ki4.a0;
import ki4.e0;
import ki4.m;
import ki4.s;
import ki4.u;
import ki4.v;
import ki4.w;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ni4.z;

/* JADX INFO: loaded from: classes15.dex */
public final class i implements w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final s f203675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<e0, u> f203676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final DefaultMaterialRepositoryReleaser f203677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f203678d;

    @Override // ki4.w
    public final v<IFolderItem, Map<a0, Class<? extends m>>> a() {
        return (v) this.f203678d.getValue();
    }

    public i(z r100, Function1 r101, DefaultMaterialRepositoryReleaser r102) {
        Intrinsics.checkNotNullParameter(r100, "listIterableSource");
        Intrinsics.checkNotNullParameter(r101, "indexerProvider");
        Intrinsics.checkNotNullParameter(r102, "releaser");
        this.f203675a = r100;
        this.f203676b = r101;
        this.f203677c = r102;
        this.f203678d = LazyKt.lazy(new g(this));
    }
}
