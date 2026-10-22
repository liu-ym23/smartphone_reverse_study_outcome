package kc8;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
public final class y0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f502678a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f502679b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f502680c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final JSONObject f502681d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof y0) == true) goto L8;
        return false;
    L8:
        y0 r101 = (y0) r100;
        if (Intrinsics.areEqual(this.f502678a, r101.f502678a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f502679b, r101.f502679b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f502680c, r101.f502680c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f502681d, r101.f502681d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        View r100 = this.f502678a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f502679b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f502680c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        JSONObject r110 = this.f502681d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "WidgetMenuInterceptContext(anchorView=" + this.f502678a + ", messageId=" + this.f502679b + ", businessType=" + this.f502680c + ", traceInfo=" + this.f502681d + ')';
    }

    public y0(View r100, String r101, String r102, JSONObject r103) {
        this.f502678a = r100;
        this.f502679b = r101;
        this.f502680c = r102;
        this.f502681d = r103;
    }
}
