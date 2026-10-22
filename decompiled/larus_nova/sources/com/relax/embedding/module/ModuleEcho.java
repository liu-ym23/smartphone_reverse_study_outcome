package com.relax.embedding.module;

import com.relax.embedding.InvokeMethod;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public class ModuleEcho {
    public ModuleEcho() {
    }

    @InvokeMethod
    public static void echo(String r100, Object r101, NativeModuleCallback r102) {
        r102.onSucceeded(r101);
    }

    @InvokeMethod
    public static void repeat(String r100, Object r101, NativeModuleCallback r102) {
        r101.getClass().toString();
        r101.toString();
        if ((r101 instanceof Map) == true) goto L6;
        r102.onFailed(100, "input not an object");
        return;
    L6:
        Iterator r103 = ((Map) r101).entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L13;
        Map.Entry r104 = (Map.Entry) r103.next();
        if (((String) r104.getKey()).equals("content") == false) goto L8;
        r102.onSucceeded(r104.getValue() + " " + r104.getValue());
        return;
    L13:
        r102.onFailed(102, "content empty");
    }
}
