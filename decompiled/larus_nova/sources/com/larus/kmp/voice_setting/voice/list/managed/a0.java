package com.larus.kmp.voice_setting.voice.list.managed;

import com.larus.kmp.voice_setting.voice.component.o4;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public final class a0 implements t1a.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<c> f353451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ManagedVoiceListOverlayState f353452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f353453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a f353454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ManagedVoiceListFooterState f353455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f353456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f353457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f353458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f353459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final o4 f353460j;

    public a0() {
        this(null, null, null, null, null, null, 0, 0, null, 1023);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a0) == true) goto L8;
        return false;
    L8:
        a0 r101 = (a0) r100;
        if (Intrinsics.areEqual(this.f353451a, r101.f353451a) == true) goto L12;
        return false;
    L12:
        if (this.f353452b == r101.f353452b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f353453c, r101.f353453c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f353454d, r101.f353454d) == true) goto L21;
        return false;
    L21:
        if (this.f353455e == r101.f353455e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f353456f, r101.f353456f) == true) goto L27;
        return false;
    L27:
        if (this.f353457g == r101.f353457g) goto L30;
        return false;
    L30:
        if (this.f353458h == r101.f353458h) goto L33;
        return false;
    L33:
        if (this.f353459i == r101.f353459i) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.f353460j, r101.f353460j) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((((((this.f353451a.hashCode() * 31) + this.f353452b.hashCode()) * 31) + this.f353453c.hashCode()) * 31) + this.f353454d.hashCode()) * 31) + this.f353455e.hashCode()) * 31) + this.f353456f.hashCode()) * 31) + this.f353457g) * 31) + this.f353458h) * 31) + this.f353459i) * 31) + this.f353460j.hashCode();
    }

    public final String toString() {
        return "ManagedVoiceListScreenUiState(rows=" + this.f353451a + ", overlayState=" + this.f353452b + ", emptyState=" + this.f353453c + ", errorState=" + this.f353454d + ", footerState=" + this.f353455e + ", footerText=" + this.f353456f + ", footerSpacerHeightDp=" + this.f353457g + ", scrollRequestKey=" + this.f353458h + ", scrollTargetIndex=" + this.f353459i + ", dropdownMenuState=" + this.f353460j + ')';
    }

    public a0(List r100, ManagedVoiceListOverlayState r101, a r102, a r103, ManagedVoiceListFooterState r104, String r105, int r110, int r111, o4 r112, int r113) {
        if ((r113 & 1) == 0) goto L6;
        r100 = CollectionsKt.emptyList();
    L6:
        if ((r113 & 2) == 0) goto L9;
        r101 = ManagedVoiceListOverlayState.NONE;
    L9:
        if ((r113 & 4) == 0) goto L12;
        r102 = new a(null, 3);
    L12:
        if ((r113 & 8) == 0) goto L15;
        r103 = new a(null, 3);
    L15:
        if ((r113 & 16) == 0) goto L18;
        r104 = ManagedVoiceListFooterState.HIDDEN;
    L18:
        if ((r113 & 32) == 0) goto L20;
        r105 = "";
    L20:
        int r106 = 0;
        if ((r113 & 128) == 0) goto L24;
        r110 = 0;
    L24:
        if ((r113 & 256) == 0) goto L27;
        r111 = 0;
    L27:
        if ((r113 & 512) == 0) goto L29;
        r112 = new o4(r106);
    L29:
        Intrinsics.checkNotNullParameter(r100, "rows");
        Intrinsics.checkNotNullParameter(r101, "overlayState");
        Intrinsics.checkNotNullParameter(r102, "emptyState");
        Intrinsics.checkNotNullParameter(r103, "errorState");
        Intrinsics.checkNotNullParameter(r104, "footerState");
        Intrinsics.checkNotNullParameter(r105, "footerText");
        Intrinsics.checkNotNullParameter(r112, "dropdownMenuState");
        this.f353451a = r100;
        this.f353452b = r101;
        this.f353453c = r102;
        this.f353454d = r103;
        this.f353455e = r104;
        this.f353456f = r105;
        this.f353457g = 0;
        this.f353458h = r110;
        this.f353459i = r111;
        this.f353460j = r112;
    }
}
