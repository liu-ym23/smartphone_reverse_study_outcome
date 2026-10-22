package u75;

import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.drive.loader.model.ErrCode;
import com.bytedance.ee.bear.drive.loader.model.InfoCode;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class a implements b {
    public final CopyOnWriteArrayList<b.a> a;
    public final v75.a b;

    @Override // u75.b
    public final void b() {
        this.b.a(InfoCode.ShowCommitted, null);
    }

    @Override // u75.b
    public final void f() {
        this.a.clear();
    }

    @Override // u75.b
    public void load() {
        tt5.a.h("DriveComponent", "load() start->".concat(getClass().getName()));
        this.b.a(InfoCode.LoadStart, null);
    }

    @Override // u75.b
    public final void onAttach() {
        this.b.a(InfoCode.OnAttach, null);
    }

    public a(PluginHost r2) {
        Intrinsics.checkNotNullParameter(r2, "host");
        CopyOnWriteArrayList<b.a> r3 = new CopyOnWriteArrayList();
        this.a = r3;
        this.b = new v75.a(r3);
    }

    @Override // u75.b
    public final void c(b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        if (this.a.contains(r2) == true) goto L6;
        this.a.add(r2);
        return;
    }

    @Override // u75.b
    public final void d(ErrCode r2) {
        Intrinsics.checkNotNullParameter(r2, "reason");
        this.b.c(r2);
    }

    @Override // u75.b
    public final void e(boolean r2) {
        this.b.b = r2;
    }

    @Override // u75.b
    public final void g(b.a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.a.remove(r2);
    }
}
