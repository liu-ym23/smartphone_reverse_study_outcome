package com.larus.dora.impl.ota.g2;

import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes27.dex */
public final class f0 {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r100 = new int[InstallOwnerKind.values().length];
            r100[InstallOwnerKind.G1_MANUAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            r100[InstallOwnerKind.G2_MANUAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L42:
            r100[InstallOwnerKind.G2_SILENT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L8:
            $EnumSwitchMapping$0 = r100;
            int[] r101 = new int[DownloadPhase.values().length];
            r101[DownloadPhase.CHECKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L34:
            r101[DownloadPhase.QUEUED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            r101[DownloadPhase.PREPARING.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L28:
            r101[DownloadPhase.RUNNING.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L36:
            r101[DownloadPhase.PAUSING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L30:
            r101[DownloadPhase.PAUSED.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L38:
            r101[DownloadPhase.FAILED.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L16:
            $EnumSwitchMapping$1 = r101;
        }
    }

    public static final i5 a(boolean r100, int r101, String r102, int r103, t4 r104) {
        boolean r105 = false;
        if (o59.a.m(Integer.valueOf(r101)) == true) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == true) goto L10;
        return null;
    L10:
        if (r100 == false) goto L48;
        if (r104 == null) goto L46;
        InstallOwnerKind r107 = r104.d();
        Integer r108 = Integer.valueOf(r104.c().a());
        if (o59.a.m(Integer.valueOf(r101)) == true) goto L16;
    L18:
        boolean r109 = false;
    L19:
        if (r109 == true) goto L21;
    L43:
        if (r105 == false) goto L46;
        return new i5.c(r104);
    L21:
        if (r107 != null) goto L23;
        int r110 = -1;
    L24:
        if (r110 == (-1)) goto L40;
        if (r110 != 1) goto L27;
        if (r103 != 0) goto L40;
    L39:
        boolean r111 = true;
    L41:
        if (r111 == false) goto L43;
        r105 = true;
        goto L43
    L27:
        if (r110 != 2) goto L29;
    L33:
        if (r108 == null) goto L40;
        if (r108.intValue() != r101) goto L40;
    L29:
        if (r110 == 3) goto L33;
        throw new NoWhenBranchMatchedException();
    L40:
        r111 = false;
        goto L41
    L23:
        r110 = a.$EnumSwitchMapping$0[r107.ordinal()];
        goto L24
    L16:
        if (j0.c(r102) == true) goto L18;
        r109 = true;
    L46:
        return i5.b.INSTANCE;
    L48:
        return i5.a.INSTANCE;
    L5:
        if (j0.c(r102) == true) goto L7;
        r106 = true;
        goto L8
    }
}
