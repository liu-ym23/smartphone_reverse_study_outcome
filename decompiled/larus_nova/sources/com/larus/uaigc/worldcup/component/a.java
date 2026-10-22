package com.larus.uaigc.worldcup.component;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements t1a.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f374261a;

    public a() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.f374261a, ((a) r100).f374261a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        Bundle r100 = this.f374261a;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "WorldCupArgumentData(arguments=" + this.f374261a + ')';
    }

    public final String a() {
        Bundle r100 = this.f374261a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("action_bar_key");
    }

    public final String b() {
        Bundle r100 = this.f374261a;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getString("enter_method");
    }

    public a(Bundle r100) {
        this.f374261a = r100;
    }
}
