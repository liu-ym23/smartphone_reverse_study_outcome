package gf9;

import com.larus.im.internal.trace.legacy.RTCEstablishReportScene;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f481074a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<b> f481075b = null;

    public a() {
    }

    static {
        f481074a = new a();
        f481075b = new ArrayList();
    }

    @Override // gf9.b
    public final lf9.a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Iterator r101 = CollectionsKt.toList(f481075b).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        lf9.a r102 = ((b) r101.next()).a(r100);
        if (r102 == null) goto L4;
        return r102;
    L8:
        return null;
    }

    @Override // gf9.b
    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Iterator r101 = CollectionsKt.toList(f481075b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).c(r100);
        goto L4
    }

    @Override // gf9.b
    public final void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Iterator r101 = CollectionsKt.toList(f481075b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((b) r101.next()).d(r100);
        goto L4
    }

    @Override // gf9.b
    public final void b(String r100, RTCEstablishReportScene r101, long r102) {
        Intrinsics.checkNotNullParameter(r100, "traceId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        List<b> r103 = f481075b;
        if (((ArrayList) r103).isEmpty() == false) goto L5;
        return;
    L5:
        Iterator r104 = CollectionsKt.toList(r103).iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((b) r104.next()).b(r100, r101, r102);
        goto L7
    }
}
