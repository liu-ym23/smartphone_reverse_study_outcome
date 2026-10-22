package com.relax.embedding.module;

import com.relax.embedding.InvokeMethod;
import com.relax.embedding.LLog;
import com.ss.android.lark.chat.core.dependency.ForwardDependency$ForwardLocation;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class PerformanceCollector {
    public PerformanceCollector() {
    }

    @InvokeMethod
    public static void reportTiming(String r100, Object r101, NativeModuleCallback r102) {
        Iterator r103 = ((Map) r101).entrySet().iterator();
        String r104 = null;
        Map r105 = null;
    L4:
        if (r103.hasNext() == false) goto L11;
        Map.Entry r106 = (Map.Entry) r103.next();
        String r107 = (String) r106.getKey();
        if (r107.equals(ForwardDependency$ForwardLocation.FLAG) == true) goto L7;
        if (r107.equals("timing") == false) goto L4;
        r105 = (Map) r106.getValue();
        goto L4
    L7:
        r104 = (String) r106.getValue();
        goto L4
    L11:
        LLog.e("PerformanceCollector, flag:" + r104 + ", timings:" + r105);
    }
}
