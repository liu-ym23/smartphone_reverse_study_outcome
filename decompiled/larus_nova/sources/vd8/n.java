package vd8;

import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class n implements td8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f554231a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f554232b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f554233c;

    public static final class a {
    }

    static {
    }

    @Override // td8.b
    public final void b() {
    }

    @Override // td8.b
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.DIRECT_ADD;
    }

    public n(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f554231a = r100;
        this.f554232b = LazyKt.lazy(new l(this));
        this.f554233c = LazyKt.lazy(new m(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        List r100 = CollectionsKt.toMutableList(r110.f314033a);
        FLogger.f375446a.i("Pipeline_List_DirectAddStage", "start DirectAddStage, origin version is " + r110.f314034b + ", origin size is " + r110.f314033a.size());
        Iterator r101 = ((List) this.f554233c.getValue()).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        td8.c r102 = (td8.c) r101.next();
        if (td8.c.a.a(r102, 0, null, null, r100, 7) == false) goto L4;
        r100 = td8.c.a.b(r102, 0, r100, 7);
        goto L4
    L9:
        if (td8.c.a.a((k) this.f554232b.getValue(), 0, null, null, null, 15) == false) goto L11;
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r103 = com.larus.bmhome.social.page.datasource.event.c.a(r110, td8.c.a.b((k) this.f554232b.getValue(), 0, r100, 7), -1, CollectionsKt.listOf(new com.larus.bmhome.social.page.datasource.event.b.d(false)), null, 8);
    L12:
        FLogger.f375446a.i("Pipeline_List_DirectAddStage", "end DirectAddStage, end version is " + r103.f314034b + ", end size is " + r103.f314033a.size());
        return r103;
    L11:
        r103 = com.larus.bmhome.social.page.datasource.event.c.a(r110, r100, 0, null, null, 14);
        goto L12
    }
}
