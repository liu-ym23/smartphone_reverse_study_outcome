package com.bytedance.awemeopen.apps.framework.base.view.refresh;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class t {
    public boolean a;
    public boolean b;
    public Boolean c;

    public abstract void a();

    public t() {
        this.b = true;
    }

    static {
    }

    public final void b(boolean r2) {
        if (this.b != r2) goto L5;
        return;
    L5:
        this.b = r2;
        if (r2 == false) goto L18;
        Boolean r3 = this.c;
        if (r3 == null) goto L19;
        boolean r4 = r3.booleanValue();
        if (this.a != r4) goto L13;
    L16:
        this.c = null;
        return;
    L13:
        if (this.b == true) goto L15;
        this.c = Boolean.valueOf(r4);
        goto L16
    L15:
        this.a = r4;
        a();
        goto L16
    L19:
        return;
    }
}
