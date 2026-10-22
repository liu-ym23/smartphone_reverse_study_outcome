package com.larus.init.task.imsdk;

import com.larus.nova.NovaApplication;

/* JADX INFO: loaded from: classes.dex */
public final class i implements gd9.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f351372a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final gd9.d f351373b = null;

    public i() {
    }

    static {
        f351372a = new i();
        NovaApplication r100 = NovaApplication.f360303e;
        f351373b = new gd9.d(NovaApplication.a.a());
    }

    @Override // gd9.i
    public final NovaApplication getApplication() {
        NovaApplication r100 = NovaApplication.f360303e;
        return NovaApplication.a.a();
    }

    @Override // gd9.i
    public final gd9.d a() {
        return f351373b;
    }
}
