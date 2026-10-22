package com.bytedance.ies.xbridge.event;

import android.webkit.WebView;
import com.bytedance.ies.xbridge.IDLXBridgeMethod;
import com.bytedance.ies.xbridge.XBridgeMethod;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f249474a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f249475b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final XBridgeMethod.b f249476c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WebView f249477d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public IDLXBridgeMethod.b f249478e;

    public final int hashCode() {
        return this.f249474a.hashCode();
    }

    public final boolean equals(Object r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f249474a, r101.f249474a) == false) goto L17;
        if (this.f249474a.length() <= 0) goto L13;
        boolean r102 = true;
    L14:
        if (r102 == false) goto L17;
        return true;
    L13:
        r102 = false;
    L17:
        if (Intrinsics.areEqual(this.f249474a, r101.f249474a) == true) goto L19;
    L23:
        return false;
    L19:
        if (Intrinsics.areEqual(this.f249477d, r101.f249477d) == false) goto L23;
        if (this.f249477d == null) goto L23;
        return true;
    }

    public b(String r100, long r101, XBridgeMethod.b r102, WebView r103) {
        Intrinsics.checkNotNullParameter(r100, "containerID");
        this.f249474a = r100;
        this.f249475b = r101;
        this.f249476c = r102;
        this.f249477d = r103;
    }
}
