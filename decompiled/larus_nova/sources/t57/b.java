package t57;

import android.app.Application;
import com.bytedance.platform.godzilla.plugin.PluginState;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public abstract class b extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<a> f544640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public d f544641b;

    public abstract List<a> f();

    @Override // t57.a
    public final void d() {
        PluginState r100 = PluginState.INITIALIZED;
        Iterator<a> r101 = this.f544640a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().d();
        goto L4
    }

    public b() {
    }

    @Override // t57.a
    public final void c(Application r100) {
        PluginState r101 = PluginState.INITIALIZED;
        List<a> r102 = f();
        this.f544640a = r102;
        Iterator<a> r103 = r102.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        r103.next().c(r100);
        goto L4
    }
}
