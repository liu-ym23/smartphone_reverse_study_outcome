package com.bytedance.creativex.mediaimport.repository.internal.main;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import oi4.r;
import oi4.s;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0000¢\u0006\u0002\b\u0010J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/bytedance/creativex/mediaimport/repository/internal/main/DefaultMaterialRepositoryReleaser;", "Landroidx/lifecycle/LifecycleEventObserver;", "Lcom/bytedance/creativex/mediaimport/repository/internal/main/IMaterialRepositoryReleaser;", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "<init>", "(Landroidx/lifecycle/LifecycleOwner;)V", "releasers", "", "getReleasers", "()Ljava/util/List;", "releasers$delegate", "Lkotlin/Lazy;", "add", "", "releaser", "add$feature_media_import_repository_mainlandRelease", "changeLifecycleOwner", "release", "onStateChanged", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", "feature-media-import-repository_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DefaultMaterialRepositoryReleaser implements LifecycleEventObserver, s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f203631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f203632b;

    @Override // oi4.s
    public final void release() {
        if (((List) this.f203632b.getValue()).isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r100 = ((List) this.f203632b.getValue()).iterator();
    L7:
        if (r100.hasNext() == false) goto L9;
        ((s) r100.next()).release();
        goto L7
    L9:
        ((List) this.f203632b.getValue()).clear();
    }

    public DefaultMaterialRepositoryReleaser(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleOwner");
        this.f203631a = r100;
        r100.getLifecycle().addObserver(this);
        this.f203632b = LazyKt.lazy(new r());
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner r100, Lifecycle.Event r101) {
        Intrinsics.checkNotNullParameter(r100, "source");
        Intrinsics.checkNotNullParameter(r101, "event");
        if (r101 != Lifecycle.Event.ON_DESTROY) goto L6;
        release();
        return;
    }
}
