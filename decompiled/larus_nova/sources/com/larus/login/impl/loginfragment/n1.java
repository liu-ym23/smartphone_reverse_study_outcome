package com.larus.login.impl.loginfragment;

import com.larus.platform.model.TriggerLoginScene;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class n1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TriggerLoginScene f357997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f357998b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f357999c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f358000d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f358001e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n1) == true) goto L8;
        return false;
    L8:
        n1 r101 = (n1) r100;
        if (this.f357997a == r101.f357997a) goto L12;
        return false;
    L12:
        if (this.f357998b == r101.f357998b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f357999c, r101.f357999c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f358000d, r101.f358000d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f358001e, r101.f358001e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f357997a.hashCode() * 31) + this.f357998b) * 31) + this.f357999c.hashCode()) * 31;
        List<String> r101 = this.f358000d;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f358001e;
        if (r105 == null) goto L11;
        r102 = r105.hashCode();
    L11:
        return r104 + r102;
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TriggerLoginSceneData(scene=" + this.f357997a + ", halfLoginWelcomeTextId=" + this.f357998b + ", traceEnterMethodParam=" + this.f357999c + ", loginMethods=" + this.f358000d + ", autoTriggerLoginMethod=" + this.f358001e + ')';
    }

    public /* synthetic */ n1(TriggerLoginScene r100, int r101, String r102) {
        this(r100, r101, r102, null, null);
    }

    public n1(TriggerLoginScene r100, int r101, String r102, List<String> r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r102, "traceEnterMethodParam");
        this.f357997a = r100;
        this.f357998b = r101;
        this.f357999c = r102;
        this.f358000d = r103;
        this.f358001e = r104;
    }
}
