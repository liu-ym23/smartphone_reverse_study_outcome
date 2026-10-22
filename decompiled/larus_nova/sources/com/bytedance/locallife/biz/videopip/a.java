package com.bytedance.locallife.biz.videopip;

import com.bytedance.locallife.dito.event.BusMutableLiveData;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f257008a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f257009b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakReference<BusMutableLiveData<Boolean>> f257010c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HashMap<String, String> f257011d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f257012e;

    public a() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f257008a, r101.f257008a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f257009b, r101.f257009b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f257010c, r101.f257010c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f257011d, r101.f257011d) == true) goto L21;
        return false;
    L21:
        if (this.f257012e == r101.f257012e) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f257008a.hashCode() * 31) + this.f257009b.hashCode()) * 31) + this.f257010c.hashCode()) * 31) + this.f257011d.hashCode()) * 31;
        if (this.f257012e == false) goto L5;
        int r101 = 1231;
    L7:
        return r100 + r101;
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "LifePipPage(scene=" + this.f257008a + ", traceSessionId=" + this.f257009b + ", backClickLiveData=" + this.f257010c + ", trackParams=" + this.f257011d + ", hasMobShow=" + this.f257012e + ')';
    }

    public a(String r100, String r101, WeakReference r102, HashMap r103) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "traceSessionId");
        Intrinsics.checkNotNullParameter(r102, "backClickLiveData");
        Intrinsics.checkNotNullParameter(r103, "trackParams");
        this.f257008a = r100;
        this.f257009b = r101;
        this.f257010c = r102;
        this.f257011d = r103;
        this.f257012e = false;
    }
}
