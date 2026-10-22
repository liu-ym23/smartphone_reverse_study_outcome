package mk6;

import com.bytedance.live.richcontent.engine.SpanRendClient;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class d extends e implements ak6.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SpanRendClient f514314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.live.richcontent.utils.c f514315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ik6.d f514316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ak6.e f514317e;

    @Override // ak6.a
    public final void dispose() {
        if (this.f514318a.compareAndSet(0, 2) == false) goto L5;
    L6:
        this.f514317e = null;
        return;
    L5:
        if (this.f514318a.compareAndSet(1, 2) == true) goto L6;
    }

    public d(SpanRendClient r100, com.bytedance.live.richcontent.utils.c r101, ik6.d r102, ak6.e r103) {
        Intrinsics.checkNotNullParameter(r100, "client");
        Intrinsics.checkNotNullParameter(r101, "monitor");
        Intrinsics.checkNotNullParameter(r102, "rendItem");
        this.f514314b = r100;
        this.f514315c = r101;
        this.f514316d = r102;
        this.f514317e = r103;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "rendItem");
        r101.f255805a.a();
    }
}
