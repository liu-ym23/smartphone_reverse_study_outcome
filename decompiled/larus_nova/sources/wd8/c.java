package wd8;

import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import td8.d;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements td8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f559309a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f559310b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f559311c;

    public static final class a {
    }

    static {
    }

    @Override // td8.b
    public final void b() {
    }

    @Override // td8.b
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.FINAL_FILTER;
    }

    public c(d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f559309a = r100;
        this.f559310b = LazyKt.lazy(new wd8.a(this));
        this.f559311c = LazyKt.lazy(new b(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        List<xc8.b> r100 = r110.f314033a;
        FLogger.f375446a.i("Pipeline_List_FinalFilterStage", "start FinalFilterStage, origin version is " + r110.f314034b + ", origin size is " + r110.f314033a.size());
        Iterator r101 = ((List) this.f559310b.getValue()).iterator();
        boolean r102 = false;
    L4:
        if (r101.hasNext() == false) goto L8;
        td8.c r103 = (td8.c) r101.next();
        if (td8.c.a.a(r103, 0, null, null, r100, 7) == false) goto L4;
        r100 = td8.c.a.b(r103, 0, CollectionsKt.toMutableList(r100), 7);
        r102 = true;
        goto L4
    L8:
        td8.c r104 = (td8.c) this.f559311c.getValue();
        if (r104 == null) goto L13;
        List<xc8.b> r105 = td8.c.a.b(r104, -1, CollectionsKt.toMutableList(r100), 6);
        if (Intrinsics.areEqual(r105, r100) == true) goto L13;
        r100 = r105;
        r102 = true;
    L13:
        if (r102 == true) goto L16;
        FLogger.f375446a.i("Pipeline_List_FinalFilterStage", "end FinalFilterStage, no filter");
        return r110;
    L16:
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r106 = com.larus.bmhome.social.page.datasource.event.c.a(r110, r100, 0, null, null, 14);
        FLogger.f375446a.i("Pipeline_List_FinalFilterStage", "end FinalFilterStage, end version is " + r106.f314034b + ", end size is " + r106.f314033a.size());
        return r106;
    }
}
