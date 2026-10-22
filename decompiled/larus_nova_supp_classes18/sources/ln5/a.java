package ln5;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import com.bytedance.ee.util.ui.n;
import jn5.b;
import jn5.c;
import mn5.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final c a;
    public b b;
    public boolean c;
    public boolean d;
    public final boolean e;
    public final boolean f;
    public boolean g;

    public final void a(Configuration r5) {
        boolean r0 = false;
        if (r5 != null) goto L5;
    L9:
        boolean r6 = false;
    L10:
        this.c = r6;
        b r7 = this.b;
        if (r7 != null) goto L13;
    L17:
        boolean r8 = false;
    L18:
        this.a.f(r8);
        this.a.a(r8);
        Context r9 = this.a.getContext();
        if ((r9 instanceof Activity) == false) goto L21;
        boolean r10 = n.D((Activity) r9);
    L22:
        c r2 = this.a;
        if (this.c == false) goto L28;
        if (r10 == true) goto L28;
        if (this.f == true) goto L28;
        boolean r11 = true;
    L29:
        r2.h(r11);
        c r12 = this.a;
        if (this.c == false) goto L32;
    L36:
        r12.setDraggable(r0);
        return;
    L32:
        if (this.d == false) goto L36;
        if (this.g == false) goto L36;
        r0 = true;
    L28:
        r11 = false;
        goto L29
    L21:
        r10 = false;
        goto L22
    L13:
        if (r7.canEdit() == false) goto L17;
        if (this.c == true) goto L17;
        r8 = true;
        goto L18
    L5:
        if (2 != r5.orientation) goto L9;
        if (this.e == true) goto L9;
        r6 = true;
        goto L10
    }

    public final void b(boolean r3) {
        if (this.d == r3) goto L13;
        this.d = r3;
        c r0 = this.a;
        if (this.c == true) goto L10;
        if (r3 == false) goto L10;
        if (this.g == false) goto L10;
        boolean r4 = true;
    L11:
        r0.setDraggable(r4);
        return;
    L10:
        r4 = false;
        goto L11
    }

    public a(j r2, boolean r3, boolean r4, boolean r5) {
        this.g = true;
        this.a = r2;
        this.c = r3;
        this.e = r4;
        this.f = r5;
    }
}
