package ln5;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import com.bytedance.ee.util.ui.n;
import jn5.b;
import jn5.c;
import mn5.j;

/* JADX INFO: loaded from: classes18.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f510030a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f510031b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f510032c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f510033d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f510034e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f510035f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f510036g;

    public final void a(Configuration r100) {
        boolean r101 = false;
        if (r100 != null) goto L5;
    L9:
        boolean r102 = false;
    L10:
        this.f510032c = r102;
        b r103 = this.f510031b;
        if (r103 != null) goto L13;
    L17:
        boolean r104 = false;
    L18:
        this.f510030a.f(r104);
        this.f510030a.a(r104);
        Context r105 = this.f510030a.getContext();
        if ((r105 instanceof Activity) == false) goto L21;
        boolean r106 = n.D((Activity) r105);
    L22:
        c r107 = this.f510030a;
        if (this.f510032c == false) goto L28;
        if (r106 == true) goto L28;
        if (this.f510035f == true) goto L28;
        boolean r108 = true;
    L29:
        r107.h(r108);
        c r109 = this.f510030a;
        if (this.f510032c == false) goto L32;
    L36:
        r109.setDraggable(r101);
        return;
    L32:
        if (this.f510033d == false) goto L36;
        if (this.f510036g == false) goto L36;
        r101 = true;
    L28:
        r108 = false;
        goto L29
    L21:
        r106 = false;
        goto L22
    L13:
        if (r103.canEdit() == false) goto L17;
        if (this.f510032c == true) goto L17;
        r104 = true;
        goto L18
    L5:
        if (2 != r100.orientation) goto L9;
        if (this.f510034e == true) goto L9;
        r102 = true;
        goto L10
    }

    public final void b(boolean r100) {
        if (this.f510033d == r100) goto L13;
        this.f510033d = r100;
        c r101 = this.f510030a;
        if (this.f510032c == true) goto L10;
        if (r100 == false) goto L10;
        if (this.f510036g == false) goto L10;
        boolean r102 = true;
    L11:
        r101.setDraggable(r102);
        return;
    L10:
        r102 = false;
        goto L11
    }

    public a(j r100, boolean r101, boolean r102, boolean r103) {
        this.f510036g = true;
        this.f510030a = r100;
        this.f510032c = r101;
        this.f510034e = r102;
        this.f510035f = r103;
    }
}
