package u75;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public abstract class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<b.a> f549034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final v75.a f549035b;

    @Override // u75.b
    public final void b() {
        this.f549035b.a(InfoCode.ShowCommitted, null);
    }

    @Override // u75.b
    public final void f() {
        this.f549034a.clear();
    }

    @Override // u75.b
    public void load() {
        tt5.a.h("DriveComponent", "load() start->".concat(getClass().getName()));
        this.f549035b.a(InfoCode.LoadStart, null);
    }

    @Override // u75.b
    public final void onAttach() {
        this.f549035b.a(InfoCode.OnAttach, null);
    }

    public a(PluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        CopyOnWriteArrayList<b.a> r101 = new CopyOnWriteArrayList();
        this.f549034a = r101;
        this.f549035b = new v75.a(r101);
    }

    @Override // u75.b
    public final void c(b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        if (this.f549034a.contains(r100) == true) goto L6;
        this.f549034a.add(r100);
        return;
    }

    @Override // u75.b
    public final void d(ErrCode r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        this.f549035b.c(r100);
    }

    @Override // u75.b
    public final void e(boolean r100) {
        this.f549035b.f553485b = r100;
    }

    @Override // u75.b
    public final void g(b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f549034a.remove(r100);
    }
}
