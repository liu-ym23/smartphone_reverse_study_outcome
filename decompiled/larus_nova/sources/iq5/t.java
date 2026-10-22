package iq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.selector.RootSelectAdapter;

/* JADX INFO: loaded from: classes18.dex */
public final class t extends com.bytedance.ee.bear.widgets.t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ p f495377c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ RootSelectAdapter f495378d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f495379e;

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        p r101 = this.f495377c;
        if ((r101 instanceof q) == false) goto L8;
        r r102 = this.f495378d.f241113b;
        if (r102 == null) goto L23;
        r102.c(this.f495379e);
        return;
    L23:
        return;
    L8:
        if ((r101 instanceof d0) == false) goto L13;
        r r103 = this.f495378d.f241113b;
        if (r103 == null) goto L25;
        r103.d(this.f495379e);
        return;
    L25:
        return;
    L13:
        if ((r101 instanceof e0) == false) goto L18;
        r r104 = this.f495378d.f241113b;
        if (r104 == null) goto L27;
        r104.b(this.f495379e);
        return;
    L27:
        return;
    L18:
        if ((r101 instanceof com.bytedance.ee.bear.wikiv2.selector.o) == false) goto L29;
        r r105 = this.f495378d.f241113b;
        if (r105 == null) goto L30;
        r105.a();
        return;
    L30:
        return;
    }

    public t(p r100, RootSelectAdapter r101, int r102) {
        this.f495377c = r100;
        this.f495378d = r101;
        this.f495379e = r102;
    }
}
