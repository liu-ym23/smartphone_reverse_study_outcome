package fmc;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c<T> extends com.ss.ugc.live.sdk.msg.utils.task.a<T, List<? extends tlc.d>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final cmc.d<T> f477895c;

    public c(cmc.d<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        super(b.f477894a);
        this.f477895c = r100;
    }

    @Override // com.ss.ugc.live.sdk.msg.utils.task.a
    public final void c(T r100) {
        List<tlc.d> r101 = this.f477895c.a(r100);
        if (r101 != null) goto L6;
        r101 = CollectionsKt.emptyList();
    L6:
        int r102 = com.ss.ugc.live.sdk.msg.utils.g.f458477a;
        b(new com.ss.ugc.live.sdk.msg.utils.g.c(r101));
    }
}
