package xfb;

import android.graphics.Point;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.lang.ref.WeakReference;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes35.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ g f563563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function1<Point, Unit> f563564b;

    /* JADX WARN: Multi-variable type inference failed */
    public h(g r100, Function1<? super Point, Unit> r101) {
        this.f563563a = r100;
        this.f563564b = r101;
    }

    public final void a() {
        WeakReference<View> r100 = this.f563563a.f563559a;
        if (r100 == null) goto L5;
        View r101 = r100.get();
    L6:
        if (r101 != null) goto L8;
        this.f563563a.a();
    L8:
        WeakReference<View> r102 = this.f563563a.f563559a;
        if (r102 == null) goto L13;
        View r103 = r102.get();
        if (r103 == null) goto L13;
        Log.i("ScreenSizeManager", "viewWidth: " + r103.getWidth() + ", viewHeight: " + r103.getHeight());
        Point r104 = new Point(r103.getWidth(), r103.getHeight());
    L14:
        this.f563564b.invoke(r104);
        return;
    L13:
        Log.i("ScreenSizeManager", "get an empty Point");
        r104 = new Point();
        goto L14
    L5:
        r101 = null;
        goto L6
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
