package nd9;

import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<c> f518812a;

    public e() {
        this.f518812a = new CopyOnWriteArrayList();
    }

    public final <T extends c> T a(Class<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        if (this.f518812a.isEmpty() == true) goto L5;
        Iterator<c> r101 = this.f518812a.iterator();
    L11:
        if (r101.hasNext() == false) goto L15;
        c r102 = r101.next();
        if (r100.isAssignableFrom(r102.getClass()) == false) goto L11;
    L16:
        T r103 = (T) r102;
        if (r103 == null) goto L19;
        return r103;
    L19:
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L22;
        return null;
    L22:
        throw new IllegalStateException("no provider found");
    L15:
        r102 = null;
        goto L16
    L5:
        if (com.larus.im.internal.delegate.c.f348197a.isDebug() == true) goto L8;
        return null;
    L8:
        throw new IllegalStateException("no provider found");
    }

    public final <T> T b(T r100, Function1<? super c, ? extends b> r101, Function2<? super b, ? super T, ? extends T> r102) {
        Intrinsics.checkNotNullParameter(r101, MonitorConstants.CONNECT_TYPE_GET);
        Intrinsics.checkNotNullParameter(r102, "action");
        if (this.f518812a.isEmpty() == false) goto L5;
        return r100;
    L5:
        Iterator<c> r103 = this.f518812a.iterator();
    L7:
        if (r103.hasNext() == false) goto L12;
        c r104 = r103.next();
        Intrinsics.checkNotNull(r104);
        b r105 = r101.invoke(r104);
        if (r105 == null) goto L7;
        r100 = r102.invoke(r105, r100);
        goto L7
    L12:
        return r100;
    }
}
