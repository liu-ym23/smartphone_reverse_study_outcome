package xd8;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.component.list.pipeline.PipelineTaskStageEnum;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements td8.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final td8.d f563287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f563288b;

    public static final class a {
    }

    static {
    }

    @Override // td8.b
    public final void b() {
    }

    @Override // td8.b
    public final PipelineTaskStageEnum stage() {
        return PipelineTaskStageEnum.NEED_TRAVERSAL;
    }

    public c(td8.d r100) {
        Intrinsics.checkNotNullParameter(r100, "taskContext");
        this.f563287a = r100;
        this.f563288b = LazyKt.lazy(new b(this));
    }

    @Override // td8.b
    public final com.larus.bmhome.social.page.datasource.event.c<xc8.b> a(com.larus.bmhome.social.page.datasource.event.c<xc8.b> r210) {
        Intrinsics.checkNotNullParameter(r210, "input");
        ArrayList r100 = new ArrayList();
        FLogger.f375446a.i("Pipeline_List_NeedTraversalStage", "start NeedTraversalStage, origin version is " + r210.f314034b + ", origin size is " + r210.f314033a.size());
        if (this.f563287a.E8() == false) goto L24;
        List r101 = (List) this.f563288b.getValue();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        Object r104 = r103.next();
        if ((r104 instanceof g) == false) goto L6;
        r102.add(r104);
        goto L6
    L10:
        g r105 = (g) CollectionsKt.firstOrNull(r102);
        if (r105 == null) goto L24;
        List<xc8.b> r106 = r210.f314033a;
        Intrinsics.checkNotNullParameter(r106, "messages");
        if (r106.isEmpty() == false) goto L15;
        Set<Integer> r107 = SetsKt.emptySet();
    L23:
        r105.f563292d = r107;
        goto L24
    L15:
        vi8.c.f555352a.getClass();
        long r108 = ((vi8.a) vi8.c.f555353b.getValue()).f555347a;
        Set<Integer> r109 = SetsKt.mutableSetOf(new Integer[]{Integer.valueOf(CollectionsKt.getLastIndex(r106))});
        long r110 = ((xc8.b) CollectionsKt.last(r106)).getMessage().getCreateTime();
        int r111 = CollectionsKt.getLastIndex(r106) - 1;
    L17:
        if ((-1) >= r111) goto L22;
        long r112 = ((xc8.b) ListProtector.get(r106, r111)).getMessage().getCreateTime();
        if ((r112 - r110) < r108) goto L21;
        r109.add(Integer.valueOf(r111));
        r110 = r112;
    L21:
        r111 = r111 - 1;
        goto L17
    L22:
        r107 = r109;
    L24:
        Iterator<T> r113 = r210.f314033a.iterator();
        int r114 = 0;
    L26:
        if (r113.hasNext() == false) goto L47;
        Object r115 = r113.next();
        int r116 = r114 + 1;
        if (r114 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        xc8.b r117 = (xc8.b) r115;
        xc8.b r118 = (xc8.b) CollectionsKt.getOrNull(r210.f314033a, r114 - 1);
        Iterator r119 = ((List) this.f563288b.getValue()).iterator();
    L32:
        if (r119.hasNext() == false) goto L46;
        td8.c r120 = (td8.c) r119.next();
        if (r120 == null) goto L38;
        td8.c r121 = r120;
        xc8.b r122 = r118;
        if (td8.c.a.a(r120, r114, r118, r117, null, 8) != true) goto L39;
        boolean r123 = true;
    L40:
        if (r123 == true) goto L41;
        r118 = r122;
        goto L32
    L41:
        if (r121 == null) goto L43;
        r100.addAll(r121.b(r114, r122, r117, r100));
    L43:
        r114 = r116;
    L39:
        r123 = false;
        goto L40
    L38:
        r121 = r120;
        r122 = r118;
        goto L39
    L46:
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    L47:
        com.larus.bmhome.social.page.datasource.event.c<xc8.b> r124 = com.larus.bmhome.social.page.datasource.event.c.a(r210, r100, 0, null, null, 14);
        FLogger.f375446a.i("Pipeline_List_NeedTraversalStage", "end NeedTraversalStage, result version is " + r124.f314034b + ", result size is " + r124.f314033a.size());
        return r124;
    }
}
