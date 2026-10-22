package com.larus.slides.impl.chat.component;

import com.larus.ui.arch.component.external.delegate.BaseContentWidget;
import ic8.t;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vw9.a;
import vw9.b;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u0007H\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/larus/slides/impl/chat/component/SlidesCotInfoComponent;", "Lcom/larus/ui/arch/component/external/delegate/BaseContentWidget;", "Lcom/larus/slides/api/ISlidesCotInfoAbility;", "<init>", "()V", "listeners", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Lcom/larus/slides/api/ISlidesCotInfoListener;", "setCotInfo", "", "cotInfo", "Lcom/larus/bmhome/chat/bean/HeadTitleInfoSimplify;", "addCotInfoListener", "listener", "removeCotInfoListener", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesCotInfoComponent extends BaseContentWidget implements a {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final CopyOnWriteArraySet<b> f369530m;

    public SlidesCotInfoComponent() {
        this.f369530m = new CopyOnWriteArraySet();
    }

    @Override // vw9.a
    public final void MM(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f369530m.contains(r100) == true) goto L6;
        this.f369530m.add(r100);
        return;
    }

    @Override // vw9.a
    public final void s(t r100) {
        Intrinsics.checkNotNullParameter(r100, "cotInfo");
        Iterator<b> r101 = this.f369530m.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onCotInfoUpdate(r100);
        goto L4
    }

    @Override // vw9.a
    public final void zd(b r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f369530m.remove(r100);
    }
}
