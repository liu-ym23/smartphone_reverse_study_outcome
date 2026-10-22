package yd8;

import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class g implements td8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f567353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f567354b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f567355c;

    public static final class a {
    }

    static {
    }

    @Override // td8.b
    public final void b() {
    }

    @Override // td8.b
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.UPDATE;
    }

    public g(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f567353a = r100;
        this.f567354b = LazyKt.lazy(new e(this));
        this.f567355c = LazyKt.lazy(new f(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r110) {
        Intrinsics.checkNotNullParameter(r110, "input");
        List r100 = CollectionsKt.toMutableList(r110.f314033a);
        FLogger.f375446a.i("Pipeline_List_UpdateStage", "start UpdateStage, origin version is " + r110.f314034b + ", origin size is " + r110.f314033a.size());
        Iterator r101 = ((List) this.f567354b.getValue()).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r100 = td8.c.a.b((td8.c) r101.next(), 0, r100, 7);
        goto L4
    L6:
        Iterator r102 = ((List) this.f567355c.getValue()).iterator();
    L8:
        if (r102.hasNext() == false) goto L12;
        Object r103 = r102.next();
        if (td8.c.a.a((td8.c) r103, 0, null, null, r100, 7) == false) goto L8;
    L13:
        td8.c r104 = (td8.c) r103;
        if (r104 == null) goto L16;
        r100 = td8.c.a.b(r104, 0, r100, 7);
    L16:
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r111 = com.larus.bmhome.social.page.datasource.event.c.a(r110, r100, 0, null, null, 14);
        FLogger.f375446a.i("Pipeline_List_UpdateStage", "end UpdateStage, end version is " + r111.f314034b + ", end size is " + r111.f314033a.size());
        return r111;
    L12:
        r103 = null;
        goto L13
    }
}
