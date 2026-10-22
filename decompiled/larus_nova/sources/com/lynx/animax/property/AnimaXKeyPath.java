package com.lynx.animax.property;

import com.alipay.sdk.m.u.i;
import com.lynx.animax.base.bridge.JavaOnlyArray;
import com.lynx.animax.util.AnimaXLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes32.dex */
public class AnimaXKeyPath {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JavaOnlyArray f380393a;

    public final List<String> a() {
        ArrayList r100 = new ArrayList();
        Iterator<Object> r101 = this.f380393a.iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if ((r102 instanceof String) == false) goto L4;
        r100.add((String) r102);
        goto L4
    L8:
        return r100;
    }

    public final String toString() {
        return "KeyPath{keys=" + a().toString() + i.f25855d;
    }

    public JavaOnlyArray getKeys() {
        return this.f380393a;
    }

    public AnimaXKeyPath(String... r100) {
        this.f380393a = new JavaOnlyArray();
        int r101 = r100.length;
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L12;
        String r103 = r100[r102];
        if (r103 != null) goto L7;
    L10:
        AnimaXLog.b("AnimaXKeyPath", "AnimaXKeyPath received a null or empty key, which will be ignored.");
    L11:
        r102 = r102 + 1;
        goto L3
    L7:
        if (r103.isEmpty() == true) goto L10;
        this.f380393a.pushString(r103);
        goto L11
    }

    public AnimaXKeyPath(JavaOnlyArray r100) {
        this.f380393a = r100;
    }
}
