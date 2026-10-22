package com.larus.bmhome.chat.api;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f297208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final by7.e f297209b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f297210c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f297211d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f297212e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<View> f297213f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<View> f297214g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Function1<wh8.a, String> f297215h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Function0<Unit> f297216i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Function2<ConversationFeedActionType, wh8.a, Unit> f297217j;

    public i() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
        return false;
    L8:
        i r101 = (i) r100;
        if (Intrinsics.areEqual(this.f297208a, r101.f297208a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f297209b, r101.f297209b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f297210c, r101.f297210c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f297211d, r101.f297211d) == true) goto L21;
        return false;
    L21:
        if (this.f297212e == r101.f297212e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f297213f, r101.f297213f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f297214g, r101.f297214g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f297215h, r101.f297215h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f297216i, r101.f297216i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f297217j, r101.f297217j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f297208a.hashCode() * 31;
        by7.e r101 = this.f297209b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f297210c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f297211d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        if (this.f297212e == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r110 + r111) * 31;
        Function0<View> r113 = this.f297213f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Function0<View> r116 = this.f297214g;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        Function1<wh8.a, String> r119 = this.f297215h;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Function0<Unit> r122 = this.f297216i;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        Function2<ConversationFeedActionType, wh8.a, Unit> r125 = this.f297217j;
        if (r125 == null) goto L39;
        r102 = r125.hashCode();
    L39:
        return r124 + r102;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = 1237;
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "ConversationFeedActionContext(fragment=" + this.f297208a + ", trackNode=" + this.f297209b + ", currentPage=" + this.f297210c + ", clickFrom=" + this.f297211d + ", isNavigationSideBar=" + this.f297212e + ", actionAnchorProvider=" + this.f297213f + ", primaryMenuViewProvider=" + this.f297214g + ", recommendFromProvider=" + this.f297215h + ", onCloseMenu=" + this.f297216i + ", onActionFinished=" + this.f297217j + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(Fragment r100, by7.e r101, String r102, String r103, boolean r104, Function0 r105, Function0 r106, Function1 r110, Function0 r111, int r112) {
        if ((r112 & 2) == 0) goto L9;
        if ((r100 instanceof by7.e) == false) goto L7;
        r101 = (by7.e) r100;
        goto L9
    L7:
        r101 = null;
    L9:
        if ((r112 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r112 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r112 & 16) == 0) goto L18;
        r104 = false;
    L18:
        if ((r112 & 32) == 0) goto L21;
        r105 = null;
    L21:
        if ((r112 & 64) == 0) goto L24;
        r106 = null;
    L24:
        if ((r112 & 128) == 0) goto L27;
        r110 = null;
    L27:
        if ((r112 & 256) == 0) goto L29;
        r111 = null;
    L29:
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        this.f297208a = r100;
        this.f297209b = r101;
        this.f297210c = r102;
        this.f297211d = r103;
        this.f297212e = r104;
        this.f297213f = r105;
        this.f297214g = r106;
        this.f297215h = r110;
        this.f297216i = r111;
        this.f297217j = null;
    }
}
