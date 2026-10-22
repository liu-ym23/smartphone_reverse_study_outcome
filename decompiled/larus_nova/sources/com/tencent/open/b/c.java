package com.tencent.open.b;

import android.os.Bundle;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes31.dex */
public class c implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<String, String> f461721a;

    public String toString() {
        return "BaseData{time=" + this.f461721a.get("time") + ", name=" + this.f461721a.get("interface_name") + '}';
    }

    public c(Bundle r100) {
        this.f461721a = new HashMap();
        if (r100 == null) goto L8;
        Iterator<String> r101 = r100.keySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L10;
        String r102 = r101.next();
        this.f461721a.put(r102, r100.getString(r102));
        goto L6
    L10:
        return;
    }

    public c(HashMap<String, String> r100) {
        this.f461721a = new HashMap(r100);
    }
}
