package com.larus.dora.obric.device_management.device_home;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f339192a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f339193a = null;

        static {
            int[] r100 = new int[DoraObricGlassesBusinessState.values().length];
            r100[DoraObricGlassesBusinessState.INTERPRETING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[DoraObricGlassesBusinessState.VIDEO_CALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[DoraObricGlassesBusinessState.RECORDING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[DoraObricGlassesBusinessState.VIDEO_RECORDING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[DoraObricGlassesBusinessState.IDLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f339193a = r100;
        }
    }

    static {
    }

    public static b a(DoraObricDeviceModeEntryProduct r110, h3 r111) {
        Intrinsics.checkNotNullParameter(r110, "product");
        Intrinsics.checkNotNullParameter(r111, "glassesMode");
        boolean r100 = a2.a(r110);
        boolean r101 = false;
        if (r100 == true) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r100 == true) goto L10;
    L12:
        boolean r103 = false;
    L13:
        DoraObricGlassesMode r104 = r111.f339249d;
        DoraObricGlassesMode r105 = DoraObricGlassesMode.HEADPHONE;
        if (r104 == r105) goto L16;
    L18:
        boolean r106 = false;
    L20:
        if (r111.f339257l == DoraObricGlassesBusinessState.IDLE) goto L22;
        boolean r107 = true;
    L23:
        if (r100 == true) goto L25;
    L31:
        boolean r112 = false;
    L32:
        if (r102 == true) goto L34;
    L36:
        boolean r113 = false;
    L38:
        if (r100 == true) goto L40;
    L42:
        boolean r114 = !r100;
        if (r106 == true) goto L50;
        if (r107 == true) goto L50;
        if (r111.f339254i != DoraObricEnvironmentMemoryState.WORKING) goto L49;
        DoraObricEnvironmentMemoryLabel r108 = DoraObricEnvironmentMemoryLabel.ON;
    L51:
        DoraObricEnvironmentMemoryLabel r115 = r108;
        if (r113 == false) goto L54;
        DoraObricEnvironmentMemoryIcon r109 = DoraObricEnvironmentMemoryIcon.RUNNING;
    L55:
        DoraObricEnvironmentMemoryIcon r116 = r109;
        if (r112 == true) goto L60;
        DoraObricEnvironmentMemoryTextStyle r117 = DoraObricEnvironmentMemoryTextStyle.DISABLED;
    L58:
        DoraObricEnvironmentMemoryTextStyle r118 = r117;
        if (r102 == false) goto L83;
        int r119 = a.f339193a[r111.f339257l.ordinal()];
        if (r119 != 1) goto L69;
        DoraObricDeviceBusinessStatus r120 = DoraObricDeviceBusinessStatus.INTERPRETATION;
    L85:
        return new b(r100, r101, r114, r100, r114, r103, r112, r112, r113, r115, r116, r118, r120);
    L69:
        if (r119 != 2) goto L71;
        r120 = DoraObricDeviceBusinessStatus.VIDEO_CALL;
        goto L85
    L71:
        if (r119 != 3) goto L73;
        r120 = DoraObricDeviceBusinessStatus.RECORDING_MINUTES;
        goto L85
    L73:
        if (r119 != 4) goto L75;
        r120 = DoraObricDeviceBusinessStatus.VIDEO_RECORDING;
        goto L85
    L75:
        if (r119 == 5) goto L83;
        throw new NoWhenBranchMatchedException();
    L83:
        r120 = null;
        goto L85
    L60:
        if (r111.f339249d != r105) goto L62;
        r117 = DoraObricEnvironmentMemoryTextStyle.HEADPHONE;
        goto L58
    L62:
        if (r113 == false) goto L64;
        r117 = DoraObricEnvironmentMemoryTextStyle.RUNNING;
        goto L58
    L64:
        r117 = DoraObricEnvironmentMemoryTextStyle.PAUSED;
        goto L58
    L54:
        r109 = DoraObricEnvironmentMemoryIcon.PAUSED;
        goto L55
    L49:
        r108 = DoraObricEnvironmentMemoryLabel.OFF;
    L50:
        r108 = DoraObricEnvironmentMemoryLabel.UNAVAILABLE;
        goto L51
    L40:
        if (b2.a(r110, r111) == null) goto L42;
        r101 = true;
        goto L42
    L34:
        if (r111.f339254i != DoraObricEnvironmentMemoryState.WORKING) goto L36;
        r113 = true;
        goto L38
    L25:
        if (r111.f339254i == DoraObricEnvironmentMemoryState.UNKNOWN) goto L31;
        if (r111.f339255j == null) goto L31;
        if (r106 == true) goto L31;
        if (r107 == true) goto L31;
        r112 = true;
        goto L32
    L22:
        r107 = false;
        goto L23
    L16:
        if (r111.f339254i != DoraObricEnvironmentMemoryState.UNAVAILABLE) goto L18;
        r106 = true;
        goto L20
    L10:
        if (r111.f339249d == DoraObricGlassesMode.UNKNOWN) goto L12;
        r103 = true;
        goto L13
    L5:
        if (r111.f339249d != DoraObricGlassesMode.ASSISTANT) goto L7;
        r102 = true;
        goto L8
    }
}
