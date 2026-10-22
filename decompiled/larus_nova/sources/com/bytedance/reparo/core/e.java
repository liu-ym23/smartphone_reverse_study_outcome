package com.bytedance.reparo.core;

import android.app.Application;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public final class e extends WandTrick.a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e97.a f267357c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ List f267358d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ ArrayList f267359e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f267360f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ Map f267361g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ List f267362h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final /* synthetic */ List f267363i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final /* synthetic */ d97.b f267364j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final /* synthetic */ ArrayList f267365k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final /* synthetic */ f f267366l;

    @Override // com.bytedance.reparo.core.WandTrick.a
    public final boolean b(int r100) {
        if (r100 != 0) goto L4;
        return true;
    L4:
        return false;
    }

    @Override // com.bytedance.reparo.core.WandTrick.a
    public final int a() throws Exception {
        ArrayList r100 = new ArrayList();
        r100.addAll(this.f267358d);
        r100.addAll(this.f267359e);
        r100.addAll(this.f267360f);
        int r101 = this.f267366l.c(this.f267361g, this.f267362h, this.f267363i, r100, this.f267364j);
        if (r101 == 0) goto L9;
        e97.a r102 = this.f267357c;
        if (e97.a.f471512g == true) goto L7;
        r102.getClass();
    L8:
        return r101;
    L7:
        r102.a();
        goto L8
    L9:
        this.f267364j.b("replaceSuper");
        ArrayList r103 = this.f267365k;
        ((HashMap) PatchInvokeSuperHelper.f267314a).clear();
        Iterator r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L15;
        Class r105 = (Class) r104.next();
        if (r105 == null) goto L11;
        ((HashMap) PatchInvokeSuperHelper.f267314a).put(r105.getName(), r105);
        goto L11
    L15:
        Iterator r106 = this.f267365k.iterator();
    L17:
        if (r106.hasNext() == false) goto L19;
        PatchInvokeSuperHelper.a((Class) r106.next(), null);
        goto L17
    L19:
        this.f267364j.a("replaceSuper");
        this.f267364j.b("replaceMethodNative");
        String[] r107 = new String[10];
        f r108 = this.f267366l;
        Object[] r109 = this.f267359e.toArray();
        Object[] r110 = this.f267360f.toArray();
        f r111 = this.f267366l;
        Object[] r112 = this.f267360f.toArray();
        r111.getClass();
        int[] r113 = WandTrick.g(r112);
        String[] r114 = new String[100];
        this.f267364j.f467627e.add(r114);
        long[] r115 = new long[100];
        this.f267364j.f467628f.add(r115);
        int r116 = r108.replaceMethodNative(r109, r110, r113, r107, r114, r115);
        k.d("replace", r107);
        this.f267364j.a("replaceMethodNative");
        if (r116 != (-9)) goto L26;
        e97.a r117 = this.f267357c;
        if (e97.a.f471512g == true) goto L24;
        r117.getClass();
    L25:
        return -9;
    L24:
        r117.a();
        goto L25
    L26:
        if (r116 != 0) goto L41;
        e97.a r118 = this.f267357c;
        if (e97.a.f471512g == true) goto L30;
        r118.getClass();
    L39:
        return 0;
    L30:
        if (r118.f471513f.f467633c.f22892l == false) goto L39;
        if (r118.c() < r118.f471530b) goto L34;
        boolean r119 = true;
    L35:
        if (r119 == true) goto L39;
        r118.b();
        goto L39
    L34:
        r119 = false;
        goto L35
    L41:
        throw new Exception("Failure in replacement, ret:." + r116);
    }

    public e(f r100, d97.d r101, List r102, ArrayList r103, ArrayList r104, Application r105, boolean r106, Map r107, List r108, List r110, d97.b r111, ArrayList r112) {
        this.f267366l = r100;
        this.f267358d = r102;
        this.f267359e = r103;
        this.f267360f = r104;
        this.f267361g = r107;
        this.f267362h = r108;
        this.f267363i = r110;
        this.f267364j = r111;
        this.f267365k = r112;
        this.f267357c = new e97.a(r101, e97.f.b(r100.f267319c));
    }
}
