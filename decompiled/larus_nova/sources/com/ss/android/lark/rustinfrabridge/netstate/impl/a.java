package com.ss.android.lark.rustinfrabridge.netstate.impl;

import android.content.Context;
import com.ss.android.lark.rustinfrabridge.netstate.api.NetworkLevelListener;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements com.ss.android.lark.rustinfrabridge.netstate.api.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f439706c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NetworkLevelListener.NetworkLevel f439707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<NetworkLevelListener, Object> f439708b;

    /* JADX INFO: renamed from: com.ss.android.lark.rustinfrabridge.netstate.impl.a$a, reason: collision with other inner class name */
    public static class C5277a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f439709a = null;

        static {
            f439709a = new a();
        }
    }

    @Override // com.ss.android.lark.rustinfrabridge.netstate.api.a
    public final void v0(Context r100) {
    }

    static {
        f439706c = new Object();
    }

    public a() {
        this.f439708b = new ConcurrentHashMap();
        this.f439707a = NetworkLevelListener.NetworkLevel.EXCELLENT;
    }

    @Override // com.ss.android.lark.rustinfrabridge.netstate.api.a
    public final NetworkLevelListener.NetworkLevel getCurNetWorkLevel() {
        return this.f439707a;
    }

    @Override // com.ss.android.lark.rustinfrabridge.netstate.api.a
    public final void w0(NetworkLevelListener r100) {
        if (r100 == null) goto L5;
        Map<NetworkLevelListener, Object> r101 = this.f439708b;
        ConcurrentHashMap r102 = (ConcurrentHashMap) r101;
        r102.put(r100, f439706c);
        return;
    }

    @Override // com.ss.android.lark.rustinfrabridge.netstate.api.a
    public final void x0(NetworkLevelListener r100) {
        if (r100 == null) goto L5;
        ((ConcurrentHashMap) this.f439708b).remove(r100);
        return;
    }
}
