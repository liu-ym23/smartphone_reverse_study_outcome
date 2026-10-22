package com.bytedance.kmp.ec.yata.view.render.screenmanager.popup;

import java.util.Map;
import kotlin.Deprecated;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class f implements ga6.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f252063a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f252064b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ba6.c f252065c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, Object> f252066d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f252067e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f252063a, r101.f252063a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f252064b, r101.f252064b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f252065c, r101.f252065c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f252066d, r101.f252066d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f252067e, r101.f252067e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f252063a.hashCode() * 31) + this.f252064b.hashCode()) * 31) + this.f252065c.hashCode()) * 31) + this.f252066d.hashCode()) * 31;
        Object r101 = this.f252067e;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "PopupConfig(popupCode=" + this.f252063a + ", nodeKey=" + this.f252064b + ", node=" + this.f252065c + ", params=" + this.f252066d + ", initData=" + this.f252067e + ')';
    }

    @Override // ga6.c
    public final <T> T getData() {
        T r100 = (T) this.f252067e;
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100;
    }

    @Override // ga6.c
    public final String a() {
        return this.f252064b;
    }

    @Override // ga6.c
    public final String f() {
        return this.f252063a;
    }

    @Override // ga6.c
    public final ba6.c getNode() {
        return this.f252065c;
    }

    @Override // ga6.c
    public final Object d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f252066d.get(r100);
    }

    @Override // ga6.c
    public final void e(h r100) {
        this.f252067e = r100;
    }

    @Override // ga6.c
    @Deprecated(message = "废弃，有Crash风险", replaceWith = @ReplaceWith(expression = "getParamValue(key)", imports = {}))
    public final <ParamType> ParamType b(String r100, ParamType r101) {
        Object r102 = this.f252066d.get(r100);
        if (r102 != null) goto L5;
        r102 = null;
    L5:
        if (r102 != null) goto L8;
        return r101;
    L8:
        return (ParamType) r102;
    }

    @Override // ga6.c
    public final void c(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f252066d.put(r100, r101);
    }

    public f(String r100, String r101, ba6.c r102, Map r103, h r104) {
        Intrinsics.checkNotNullParameter(r100, "popupCode");
        Intrinsics.checkNotNullParameter(r101, "nodeKey");
        Intrinsics.checkNotNullParameter(r102, "node");
        Intrinsics.checkNotNullParameter(r103, "params");
        this.f252063a = r100;
        this.f252064b = r101;
        this.f252065c = r102;
        this.f252066d = r103;
        this.f252067e = r104;
    }
}
