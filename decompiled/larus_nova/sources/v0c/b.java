package v0c;

import android.content.Context;
import android.os.Bundle;
import com.ss.android.lark.player.widget.SuperContainer;

/* JADX INFO: loaded from: classes37.dex */
public abstract class b implements o, t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f552349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public q f552350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public t f552351c;

    @Override // v0c.o
    public void a(int r100, Bundle r101) {
    }

    @Override // v0c.o
    public void d(int r100) {
    }

    @Override // v0c.o
    public void h(int r100, Bundle r101) {
    }

    @Override // v0c.t
    public final r i() {
        t r100 = this.f552351c;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.i();
    }

    public final Context getContext() {
        return this.f552349a;
    }

    public b(Context r100) {
        this.f552349a = r100;
    }

    @Override // v0c.o
    public final void b(SuperContainer.a r100) {
        this.f552350b = r100;
    }

    @Override // v0c.o
    public final void c(t r100) {
        this.f552351c = r100;
    }

    public final void j(int r100, Bundle r101) {
        q r102 = this.f552350b;
        if (r102 == null) goto L6;
        r102.a(r100, r101);
        return;
    }
}
