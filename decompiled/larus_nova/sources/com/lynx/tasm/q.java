package com.lynx.tasm;

import com.lynx.jsbridge.LynxModule;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes32.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Boolean f383550a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f383551b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LynxGroup f383552c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<com.lynx.jsbridge.f> f383553d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, d8a.k> f383554e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public TemplateData f383555f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TemplateData f383556g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f8a.a f383557h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public g8a.a f383558i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public h8a.a f383559j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public LynxBooleanOption f383560k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public Boolean f383561l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public LynxModule.a f383562m;

    public static int c(int r100, boolean r101, int r102) {
        if (r101 == false) goto L5;
        return r100 | r102;
    L5:
        return r100 & (~r102);
    }

    public q() {
        this.f383560k = LynxBooleanOption.UNSET;
        this.f383554e = new HashMap();
        this.f383553d = new ArrayList();
    }

    public q(q r100) {
        this.f383560k = LynxBooleanOption.UNSET;
        this.f383550a = r100.f383550a;
        this.f383551b = r100.f383551b;
        this.f383552c = r100.f383552c;
        this.f383553d = new ArrayList(r100.f383553d);
        this.f383554e = new HashMap(r100.f383554e);
        this.f383555f = r100.f383555f;
        this.f383556g = r100.f383556g;
        this.f383557h = r100.f383557h;
        this.f383558i = r100.f383558i;
        this.f383559j = r100.f383559j;
        this.f383560k = r100.f383560k;
        this.f383561l = r100.f383561l;
        this.f383562m = r100.f383562m;
    }

    public final int a(boolean r100) {
        boolean r101 = false;
        int r102 = c(0, false, 4);
        LynxGroup r103 = this.f383552c;
        if (r103 != null) goto L5;
    L6:
        r101 = true;
    L7:
        int r104 = c(c(r102, r101, 8), r100, 32);
        Boolean r105 = Boolean.TRUE;
        int r106 = c(r104, r105.equals(this.f383550a), 1);
        LynxGroup r107 = this.f383552c;
        if (r107 == null) goto L11;
        r106 = c(r106, r107.enableJSGroupThread(), 2);
    L11:
        return c(r106, r105.equals(this.f383561l), 16);
    L5:
        if (r103.enableV8() == true) goto L7;
        goto L6
    }

    public final void b(q r100) {
        if (r100 != this) goto L4;
        return;
    L4:
        this.f383552c = r100.f383552c;
        Boolean r101 = r100.f383550a;
        if (r101 != null) goto L8;
        r101 = Boolean.FALSE;
    L8:
        this.f383550a = r101;
        this.f383551b = r100.f383551b;
        this.f383561l = Boolean.FALSE;
        this.f383553d.addAll(r100.f383553d);
        if (this.f383560k != LynxBooleanOption.UNSET) goto L11;
        this.f383560k = r100.f383560k;
    L11:
        f8a.a r102 = this.f383557h;
        if (r102 != null) goto L15;
        r102 = r100.f383557h;
    L15:
        this.f383557h = r102;
        g8a.a r103 = this.f383558i;
        if (r103 != null) goto L19;
        r103 = r100.f383558i;
    L19:
        this.f383558i = r103;
        h8a.a r104 = this.f383559j;
        if (r104 != null) goto L23;
        r104 = r100.f383559j;
    L23:
        this.f383559j = r104;
        Iterator<Map.Entry<String, d8a.k>> r105 = r100.f383554e.entrySet().iterator();
    L25:
        if (r105.hasNext() == false) goto L29;
        Map.Entry<String, d8a.k> r106 = r105.next();
        if (this.f383554e.containsKey(r106.getKey()) == true) goto L25;
        this.f383554e.put(r106.getKey(), r106.getValue());
        goto L25
    }
}
