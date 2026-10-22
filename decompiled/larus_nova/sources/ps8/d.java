package ps8;

import com.larus.bmhome.video.h;
import com.larus.platform.api.IVideoController;
import com.larus.platform.service.q3;
import com.larus.video.impl.sdk.o;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes26.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f530467a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f530468b = null;

    public d() {
    }

    static {
        f530467a = new d();
        f530468b = LazyKt.lazy(new b());
    }

    public static ConcurrentHashMap d() {
        return (ConcurrentHashMap) f530468b.getValue();
    }

    @Override // ps8.a
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        IVideoController r101 = (IVideoController) d().get(r100);
        if (r101 != null) goto L5;
        return;
    L5:
        ConcurrentHashMap r102 = d();
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L8:
        if (r101.isReleased() == true) goto L10;
        r101.release();     // Catch: Throwable -> L13
    L10:
        IVideoController r103 = (IVideoController) d().remove(r100);     // Catch: Throwable -> L13
        monitor-exit(r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, java.lang.Object] */
    @Override // ps8.a
    public final IVideoController a(final String r100, final String r101, final String r102) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "tag");
        Intrinsics.checkNotNullParameter(r102, "subTag");
        final Ref.ObjectRef r103 = new Ref.ObjectRef();
        ?? r104 = d().get(r100);
        r103.element = r104;
        if (r104 != 0) goto L5;
    L6:
        ConcurrentHashMap r105 = d();
        monitor-enter(r105);
        ?? r106 = d().get(r100);     // Catch: Throwable -> L23
        r103.element = r106;     // Catch: Throwable -> L23
        if (r106 != 0) goto L16;
        T r107 = 0;
        IVideoController r108 = q3.b(r101, null, 6);     // Catch: Throwable -> L23
        if (r108 == null) goto L13;
        ((o) r108).I(true);     // Catch: Throwable -> L23
        r107 = r108;
    L13:
        r103.element = r107;     // Catch: Throwable -> L23
        if (r107 == 0) goto L16;
        d().put(r100, r107);     // Catch: Throwable -> L23
    L16:
        Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L23
        monitor-exit(r105);
    L18:
        IVideoController r110 = (IVideoController) r103.element;
        if (r110 == null) goto L21;
        r110.setSubTag(r102);
    L21:
        h.a("VideoPlayerEngineManager", new c(r100, r101, r102, r103));
        return (IVideoController) r103.element;
    L23:
        th = move-exception;
        throw th;
    L5:
        if (((IVideoController) r104).isReleased() == false) goto L18;
        goto L6
    }

    @Override // ps8.a
    public final IVideoController c(String r100, Integer r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "subTag");
        IVideoController r103 = q3.b(r100, r101, 2);
        if (r103 == null) goto L5;
        o r104 = (o) r103;
        r104.setSubTag(r102);
        r104.I(true);
        return r103;
    L5:
        return null;
    }
}
