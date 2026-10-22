package com.ss.android.ainote.list;

import android.view.View;
import android.view.Window;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Window f407069a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f407070b;

    public static final class a {
    }

    static {
    }

    public c0() {
    }

    public static String a(View r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100.getClass().getSimpleName());
        r101.append('@');
        r101.append(System.identityHashCode(r100));
        r101.append("(id=");
        r101.append(r100.getId());
        r101.append(",attached=");
        r101.append(r100.isAttachedToWindow());
        r101.append(",focused=");
        if (r100.isFocused() == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        r101.append(r102);
        r101.append(')');
        return r101.toString();
    L5:
        if (r100.hasFocus() == true) goto L8;
        r102 = false;
        goto L9
    }

    public static String c(int r100) {
        int r101 = r100 & 240;
        if (r101 != 0) goto L5;
        String r102 = "adjustUnspecified";
    L15:
        int r103 = r100 & 15;
        if (r103 != 0) goto L18;
        String r104 = "stateUnspecified";
    L35:
        if ((r100 & 256) == 0) goto L37;
        String r105 = "|forwardNavigation";
    L39:
        return r102 + '|' + r104 + r105;
    L37:
        r105 = "";
        goto L39
    L18:
        if (r103 != 1) goto L20;
        r104 = "stateUnchanged";
        goto L35
    L20:
        if (r103 != 2) goto L22;
        r104 = "stateHidden";
        goto L35
    L22:
        if (r103 != 3) goto L24;
        r104 = "stateAlwaysHidden";
        goto L35
    L24:
        if (r103 != 4) goto L26;
        r104 = "stateVisible";
        goto L35
    L26:
        if (r103 == 5) goto L28;
        r104 = "state(" + r103 + ')';
        goto L35
    L28:
        r104 = "stateAlwaysVisible";
        goto L35
    L5:
        if (r101 != 16) goto L7;
        r102 = "adjustResize";
        goto L15
    L7:
        if (r101 != 32) goto L9;
        r102 = "adjustPan";
        goto L15
    L9:
        if (r101 == 48) goto L11;
        r102 = "adjust(" + r101 + ')';
        goto L15
    L11:
        r102 = "adjustNothing";
        goto L15
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Window r101 = this.f407069a;
        Integer r102 = this.f407070b;
        if (r101 == null) goto L11;
        if (r102 == null) goto L11;
        int r103 = r101.getAttributes().softInputMode;
        if (r103 == r102.intValue()) goto L9;
        r101.setSoftInputMode(r102.intValue());
    L9:
        int r104 = com.ss.android.ainote.t.f407207a;
        com.ss.android.ainote.t.d("AINoteWindowInputMode", "restore, reason=" + r100 + ", current=" + c(r103) + ", restoreTo=" + c(r102.intValue()));
        this.f407069a = null;
        this.f407070b = null;
        return;
    L11:
        this.f407069a = null;
        this.f407070b = null;
    }
}
