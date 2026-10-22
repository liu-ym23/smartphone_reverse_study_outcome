package com.larus.init.task.imsdk;

import com.larus.nova.NovaApplication;
import gd9.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class i implements gd9.i {
    public static final i a = null;
    public static final d b = null;

    public i() {
    }

    static {
        a = new i();
        NovaApplication r1 = NovaApplication.e;
        b = new d(NovaApplication.a.a());
    }

    @Override // gd9.i
    public final NovaApplication getApplication() {
        NovaApplication r0 = NovaApplication.e;
        return NovaApplication.a.a();
    }

    @Override // gd9.i
    public final d a() {
        return b;
    }
}
