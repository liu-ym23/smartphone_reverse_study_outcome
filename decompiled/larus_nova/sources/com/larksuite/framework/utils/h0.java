package com.larksuite.framework.utils;

import com.ss.android.lark.log.Log;
import java.util.HashMap;

/* JADX INFO: loaded from: classes24.dex */
public final class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, Object> f285997a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h0 f285998a = null;

        static {
            f285998a = new h0();
        }
    }

    public h0() {
        this.f285997a = new HashMap();
    }

    public final Object a(String r100) {
        return this.f285997a.remove(r100);
    }

    public final void b(String r100, Object r101) {
        this.f285997a.put(r100, r101);
        int r102 = this.f285997a.size();
        if (r102 <= 10) goto L6;
        Log.e("TransmitHelper", "Transmit Too Many items: " + r102);
        return;
    L6:
        if (r102 <= 1) goto L10;
        Log.w("TransmitHelper", "Transmit over ONE item: " + r102);
        return;
    }
}
