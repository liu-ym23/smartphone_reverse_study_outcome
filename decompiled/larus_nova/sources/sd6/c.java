package sd6;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import faceverify.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f541461a;

    public c(String r100) {
        Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
        this.f541461a = r100;
    }

    @Override // sd6.a
    public final void a(Stack r100, re6.c r101, rd6.d r102) {
        Intrinsics.checkNotNullParameter(r100, "stack");
        Intrinsics.checkNotNullParameter(r101, "env");
        Intrinsics.checkNotNullParameter(r102, w.BLOB_ELEM_IMAGE_RUNTIMEINFO);
        System.nanoTime();
        if (Intrinsics.areEqual("null", this.f541461a) == false) goto L6;
        r100.push(new f(0));
    L6:
        if (r101.b(this.f541461a) == false) goto L10;
        Object r103 = r101.a(this.f541461a);
        if (r103 != null) goto L12;
        r103 = new f(0);
    L12:
        if ((r103 instanceof Integer) == false) goto L15;
        r103 = Long.valueOf(((Number) r103).intValue());
    L15:
        if ((r103 instanceof Collection) == false) goto L24;
        Iterable r104 = (Iterable) r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator r106 = r104.iterator();
    L18:
        if (r106.hasNext() == false) goto L23;
        Object r107 = r106.next();
        if ((r107 instanceof Integer) == false) goto L22;
        r107 = Long.valueOf(((Number) r107).intValue());
    L22:
        r105.add(r107);
        goto L18
    L23:
        r103 = r105;
    L24:
        System.nanoTime();
        r100.push(r103);
        return;
    L10:
        r103 = new e(0);
        goto L12
    }
}
