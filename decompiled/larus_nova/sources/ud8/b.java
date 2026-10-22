package ud8;

import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import td8.d;

/* JADX INFO: loaded from: classes25.dex */
public final class b implements td8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f549749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f549750b;

    public static final class a {
    }

    static {
    }

    @Override // td8.b
    public final void b() {
    }

    @Override // td8.b
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.DELETE;
    }

    public b(d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f549749a = r100;
        this.f549750b = LazyKt.lazy(new ud8.a(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        List<xc8.b> r100 = r110.f314033a;
        FLogger.f375446a.i("Pipeline_List_DeleteStage", "start DeleteStage, start input version is " + r110.f314034b + ", start input size is " + r110.f314033a.size());
        Iterator r101 = ((List) this.f549750b.getValue()).iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L8;
        td8.c r103 = (td8.c) r101.next();
        if (td8.c.a.a(r103, 0, null, null, r100, 7) == false) goto L4;
        r100 = td8.c.a.b(r103, 0, CollectionsKt.toMutableList(r100), 7);
        r102 = true;
        goto L4
    L8:
        if (r102 == false) goto L10;
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r104 = com.larus.bmhome.social.page.datasource.event.c.a(r110, new ArrayList(r100), -1, CollectionsKt.listOf(new com.larus.bmhome.social.page.datasource.event.b.d(false)), null, 8);
        FLogger.f375446a.i("Pipeline_List_DeleteStage", "end DeleteStage, end result version is " + r104.f314034b + ", end result size is " + r104.f314033a.size());
        return r104;
    L10:
        FLogger.f375446a.i("Pipeline_List_DeleteStage", "end DeleteStage, no any cut ");
        return r110;
    }
}
