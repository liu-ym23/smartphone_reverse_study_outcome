package xib;

import com.ss.android.lark.forwardv3.recentforward.RecentForwardAdapterV3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f564007a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f564008b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f564009c;

    public b(RecentForwardAdapterV3.b r100, RecentForwardAdapterV3.a r101) {
        Intrinsics.checkNotNullParameter(r100, "itemClickHandler");
        Intrinsics.checkNotNullParameter(r101, "onItemBusinessConsumeClickListener");
        this.f564007a = new c(r100, r101);
        this.f564008b = new f(r100, r101);
        this.f564009c = new g(r100, r101);
    }
}
