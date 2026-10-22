package com.bytedance.helios.sdk;

import android.util.Pair;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public class q implements f06.a {
    public q() {
    }

    @Override // f06.a
    public f06.d preInvoke(int r110, String r111, String r112, Object r113, Object[] r114, String r115, f06.b r116) {
        qz5.a r100 = e06.f.a(r110);
        if (r100 != null) goto L5;
    L7:
        int r101 = 2;
    L8:
        r116.getClass();
        Pair<Boolean, Object> r102 = b.b(null, r113, r114, r110, r115, false, r101, r111, r112);
        return new f06.d(((Boolean) r102.first).booleanValue(), r102.second);
    L5:
        if ("around".equals(r100.f535353i) == false) goto L7;
        r101 = 1;
        goto L8
    }

    @Override // f06.a
    public void postInvoke(int r110, String r111, String r112, Object r113, Object[] r114, Object r115, f06.b r116, boolean r117) {
        HashMap<String, Integer> r100 = e06.f.f470645a;
        switch(r110) {
            case 100101: goto L8;
            case 100201: goto L7;
            case 100401: goto L6;
            case 100403: goto L5;
            default: goto L4;
        };
    L4:
        int r101 = r110;
    L9:
        r116.getClass();
        b.b(r115, r113, r114, r101, "", false, 3, r111, r112);
        return;
    L5:
        r101 = 100405;
        goto L9
    L6:
        r101 = 100404;
        goto L9
    L7:
        r101 = 100205;
        goto L9
    L8:
        r101 = 100106;
        goto L9
    }
}
