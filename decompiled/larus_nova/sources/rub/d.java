package rub;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmPanelHeightConfig;
import com.ss.android.lark.officesdk.minutes.api.recording.common.depend.ui.entity.MmPanelHostMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f539317a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f539318b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<Context, View> f539319c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Bundle f539320d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f539321e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Function0<Unit> f539322f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<Unit> f539323g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MmPanelHeightConfig f539324h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final MmRecordingUILaunchMode f539325i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final c f539326j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final MmPanelHostMode f539327k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f539328l;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f539317a, r101.f539317a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f539318b, r101.f539318b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f539319c, r101.f539319c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f539320d, r101.f539320d) == true) goto L21;
        return false;
    L21:
        if (this.f539321e == r101.f539321e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f539322f, r101.f539322f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f539323g, r101.f539323g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f539324h, r101.f539324h) == true) goto L33;
        return false;
    L33:
        if (this.f539325i == r101.f539325i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f539326j, r101.f539326j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(null, null) == true) goto L42;
        return false;
    L42:
        if (this.f539327k == r101.f539327k) goto L45;
        return false;
    L45:
        if (this.f539328l == r101.f539328l) goto L47;
        return false;
    L47:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((this.f539317a.hashCode() * 31) + this.f539318b.hashCode()) * 31) + this.f539319c.hashCode()) * 31;
        Bundle r101 = this.f539320d;
        if (r101 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = (r100 + r102) * 31;
        int r104 = 1231;
        if (this.f539321e == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r103 + r105) * 31;
        Function0<Unit> r107 = this.f539322f;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Function0<Unit> r110 = this.f539323g;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        MmPanelHeightConfig r113 = this.f539324h;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (((((((((r112 + r114) * 31) + this.f539325i.hashCode()) * 31) + this.f539326j.hashCode()) * 31) + 0) * 31) + this.f539327k.hashCode()) * 31;
        if (this.f539328l == true) goto L27;
        r104 = 1237;
    L27:
        return r115 + r104;
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
        r105 = 1237;
        goto L10
    L5:
        r102 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "MmPanelConfig(tag=" + this.f539317a + ", id=" + this.f539318b + ", contentViewProvider=" + this.f539319c + ", args=" + this.f539320d + ", isCancelable=" + this.f539321e + ", onDismiss=" + this.f539322f + ", onShow=" + this.f539323g + ", heightConfig=" + this.f539324h + ", uiLaunchMode=" + this.f539325i + ", backgroundConfig=" + this.f539326j + ", dismissConfig=null, hostMode=" + this.f539327k + ", drawBehindNavigationBar=" + this.f539328l + ')';
    }

    public /* synthetic */ d(String r110, Function1 r111, MmPanelHeightConfig r112, MmRecordingUILaunchMode r210, c r211, boolean r212, int r213) {
        MmPanelHostMode r100 = null;
        if ((r213 & 2) == 0) goto L5;
        String r101 = r110;
    L7:
        if ((r213 & 16) == 0) goto L9;
        boolean r102 = true;
    L11:
        if ((r213 & 128) == 0) goto L13;
        MmPanelHeightConfig r113 = null;
    L15:
        if ((r213 & 256) == 0) goto L17;
        MmRecordingUILaunchMode r114 = MmRecordingUILaunchMode.UNKNOWN;
    L19:
        if ((r213 & 512) == 0) goto L21;
        c r115 = c.b.f539315a;
    L23:
        if ((r213 & 2048) == 0) goto L25;
        r100 = MmPanelHostMode.DEFAULT;
    L25:
        MmPanelHostMode r116 = r100;
        if ((r213 & 4096) == 0) goto L28;
        boolean r117 = false;
    L29:
        this(r110, r101, r111, null, r102, null, null, r113, r114, r115, r116, r117);
        return;
    L28:
        r117 = r212;
        goto L29
    L21:
        r115 = r211;
        goto L23
    L17:
        r114 = r210;
        goto L19
    L13:
        r113 = r112;
        goto L15
    L9:
        r102 = false;
        goto L11
    L5:
        r101 = null;
        goto L7
    }

    public d(String r100, String r101, Function1 r102, Bundle r103, boolean r104, Function0 r105, Function0 r106, MmPanelHeightConfig r107, MmRecordingUILaunchMode r110, c r111, MmPanelHostMode r112, boolean r113) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "id");
        Intrinsics.checkNotNullParameter(r102, "contentViewProvider");
        Intrinsics.checkNotNullParameter(r110, "uiLaunchMode");
        Intrinsics.checkNotNullParameter(r111, "backgroundConfig");
        Intrinsics.checkNotNullParameter(r112, "hostMode");
        this.f539317a = r100;
        this.f539318b = r101;
        this.f539319c = r102;
        this.f539320d = r103;
        this.f539321e = r104;
        this.f539322f = r105;
        this.f539323g = r106;
        this.f539324h = r107;
        this.f539325i = r110;
        this.f539326j = r111;
        this.f539327k = r112;
        this.f539328l = r113;
    }
}
