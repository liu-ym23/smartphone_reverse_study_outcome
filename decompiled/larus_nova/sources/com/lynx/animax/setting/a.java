package com.lynx.animax.setting;

import com.lynx.animax.util.AnimaXLog;
import com.lynx.tasm.service.ILynxTrailService;
import i8a.n;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import w4a.c;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, AnimaXSettingValue> f380428a;

    public a() {
        this.f380428a = new ConcurrentHashMap();
    }

    public static AnimaXSettingValue c(Collection r100) {
        if (r100.isEmpty() == false) goto L10;
        List r101 = Collections.emptyList();
        if (r101 != null) goto L9;
        r101 = Collections.emptyList();
    L9:
        return new AnimaXSettingValue(r101);
    L10:
        ArrayList r102 = new ArrayList(r100.size());
        Iterator r103 = r100.iterator();
    L12:
        if (r103.hasNext() == false) goto L27;
        Object r104 = r103.next();
        if ((r104 instanceof String) == false) goto L17;
        r102.add((String) r104);
        goto L12
    L17:
        if (r104 == null) goto L19;
        String r105 = r104.getClass().getName();
    L20:
        AnimaXLog.d("LynxAnimaXSettingService", "Collection contains non-string element: ".concat(r105));
        List r106 = Collections.emptyList();
        if (r106 != null) goto L25;
        r106 = Collections.emptyList();
    L25:
        return new AnimaXSettingValue(r106);
    L19:
        r105 = "null";
        goto L20
    L27:
        return new AnimaXSettingValue(r102);
    }

    @Override // w4a.c
    public final AnimaXSettingValue a(String r100) {
        if (r100 == null) goto L5;
        AnimaXSettingValue r101 = this.f380428a.get(r100);
        if (r101 == null) goto L9;
        return r101;
    L9:
        ILynxTrailService r102 = (ILynxTrailService) n.c().a(ILynxTrailService.class);
        if (r102 != null) goto L30;
        AnimaXLog.d("LynxAnimaXSettingService", "Trail service not available");
        AnimaXSettingValue r103 = new AnimaXSettingValue("");
    L26:
        AnimaXSettingValue r104 = this.f380428a.putIfAbsent(r100, r103);
        if (r104 != null) goto L29;
        return r103;
    L29:
        return r104;
    L30:
        Object r105 = r102.objectValueForTrailKey(r100);     // Catch: Throwable -> L23
        if (r105 != null) goto L16;
        r103 = new AnimaXSettingValue("");     // Catch: Throwable -> L23
        goto L26
    L16:
        if ((r105 instanceof String) == false) goto L19;
        r103 = new AnimaXSettingValue((String) r105);     // Catch: Throwable -> L23
        goto L26
    L19:
        if ((r105 instanceof Collection) == false) goto L21;
        r103 = c((Collection) r105);     // Catch: Throwable -> L23
        goto L26
    L21:
        AnimaXLog.d("LynxAnimaXSettingService", "Unsupported value type: ".concat(r105.getClass().getName()));     // Catch: Throwable -> L23
    L25:
        r103 = new AnimaXSettingValue("");
    L23:
        th = move-exception;
        AnimaXLog.a("LynxAnimaXSettingService", "Failed to get value for key: " + r100 + ", message: " + th.getMessage());
        goto L25
    L5:
        return new AnimaXSettingValue("");
    }
}
