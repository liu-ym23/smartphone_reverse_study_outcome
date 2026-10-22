package com.larus.dora.obric.device_management.device_home;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b2 {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f339190a = null;

        static {
            int[] r100 = new int[DoraObricGlassesMode.values().length];
            r100[DoraObricGlassesMode.ASSISTANT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[DoraObricGlassesMode.HEADPHONE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[DoraObricGlassesMode.UNKNOWN.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f339190a = r100;
        }
    }

    static {
    }

    public static z1 a(DoraObricDeviceModeEntryProduct r100, h3 r101) {
        Intrinsics.checkNotNullParameter(r100, "product");
        Intrinsics.checkNotNullParameter(r101, "state");
        if (a2.a(r100) == true) goto L5;
        return null;
    L5:
        if (r101.f339246a == false) goto L41;
        int r102 = a.f339190a[r101.f339249d.ordinal()];
        boolean r103 = true;
        if (r102 != 1) goto L10;
        DoraObricDeviceModeEntryLabel r104 = DoraObricDeviceModeEntryLabel.ASSISTANT;
    L18:
        DoraObricDeviceModeEntryLabel r105 = r104;
        boolean r106 = r101.f339251f;
        if (r101.f339250e == false) goto L22;
        if (r106 == true) goto L22;
    L23:
        boolean r107 = !r103;
        if (r101.f339248c == false) goto L26;
        float r108 = 0.3f;
    L30:
        if (r101.f339249d != DoraObricGlassesMode.HEADPHONE) goto L34;
        DoraObricDeviceModeIndicator r109 = DoraObricDeviceModeIndicator.HEADPHONE;
    L38:
        return new z1(r105, r107, r106, r106, r108, r109);
    L34:
        if (r101.f339254i != DoraObricEnvironmentMemoryState.WORKING) goto L36;
        r109 = DoraObricDeviceModeIndicator.ASSISTANT_MEMORY_ON;
        goto L38
    L36:
        r109 = DoraObricDeviceModeIndicator.ASSISTANT_MEMORY_OFF;
        goto L38
    L26:
        if (r103 == false) goto L28;
        r108 = 0.9f;
        goto L30
    L28:
        r108 = 1.0f;
    L22:
        r103 = false;
        goto L23
    L10:
        if (r102 != 2) goto L12;
        r104 = DoraObricDeviceModeEntryLabel.HEADPHONE;
        goto L18
    L12:
        if (r102 != 3) goto L15;
        r104 = DoraObricDeviceModeEntryLabel.ASSISTANT;
        goto L18
    L15:
        throw new NoWhenBranchMatchedException();
    L41:
        return null;
    }
}
