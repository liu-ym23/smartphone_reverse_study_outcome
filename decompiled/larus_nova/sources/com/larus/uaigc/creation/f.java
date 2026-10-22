package com.larus.uaigc.creation;

import android.view.View;
import com.larus.bmhome.share.panel.h;
import com.larus.bmhome.utils.c4;
import com.larus.common_ui.dialog.l0;
import com.larus.im.bean.message.Message;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import nr9.g;

/* JADX INFO: loaded from: classes31.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f372851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CoroutineScope f372852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final l0 f372853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f372854d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c4 f372855e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f372856f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Message f372857g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.larus.bmhome.share.panel.d f372858h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f372851a, r101.f372851a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f372852b, r101.f372852b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f372853c, r101.f372853c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f372854d, r101.f372854d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f372855e, r101.f372855e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f372856f, r101.f372856f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f372857g, r101.f372857g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f372858h, r101.f372858h) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        h r100 = this.f372851a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f372852b.hashCode()) * 31;
        l0 r104 = this.f372853c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        g r107 = this.f372854d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        c4 r110 = this.f372855e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        View r113 = this.f372856f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Message r116 = this.f372857g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        com.larus.bmhome.share.panel.d r119 = this.f372858h;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "VideoSharePanelParams(sharePanelEventParam=" + this.f372851a + ", scope=" + this.f372852b + ", loadingDialog=" + this.f372853c + ", videoPlayData=" + this.f372854d + ", videoEventParams=" + this.f372855e + ", rootView=" + this.f372856f + ", message=" + this.f372857g + ", clickInterceptor=" + this.f372858h + ')';
    }

    public /* synthetic */ f(h r100, CoroutineScope r110, g r111, c4 r112, View r113, Message r114) {
        this(r100, r110, r111, r112, r113, r114, null);
    }

    public f(h r100, CoroutineScope r101, g r102, c4 r103, View r104, Message r105, com.larus.bmhome.share.panel.d r106) {
        Intrinsics.checkNotNullParameter(r101, "scope");
        this.f372851a = r100;
        this.f372852b = r101;
        this.f372853c = null;
        this.f372854d = r102;
        this.f372855e = r103;
        this.f372856f = r104;
        this.f372857g = r105;
        this.f372858h = r106;
    }
}
