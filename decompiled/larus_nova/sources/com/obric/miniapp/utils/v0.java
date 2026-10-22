package com.obric.miniapp.utils;

import com.larus.nova.R;

/* JADX INFO: loaded from: classes33.dex */
public final class v0 implements p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v0 f398544a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final g1 f398545b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g1 f398546c = null;

    public v0() {
    }

    @Override // com.obric.miniapp.utils.p0
    public final long a() {
        return 1;
    }

    static {
        f398544a = new v0();
        f398545b = new g1(R.anim.mini_modal_open_enter, R.anim.mini_modal_open_exit);
        f398546c = new g1(R.anim.mini_modal_close_enter, R.anim.mini_modal_close_exit);
    }

    @Override // com.obric.miniapp.utils.p0
    public final g1 b() {
        return f398545b;
    }

    @Override // com.obric.miniapp.utils.p0
    public final g1 c() {
        return f398546c;
    }
}
