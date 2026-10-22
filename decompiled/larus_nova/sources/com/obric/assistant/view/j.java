package com.obric.assistant.view;

import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: classes33.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static PopupWindow f394295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static int f394296b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static int f394297c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static int f394298d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static int f394299e;

    static {
    }

    public static void a() {
        PopupWindow r100 = f394295a;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isShowing() == false) goto L7;
        PopupWindowLancet.handleDismissBeforeOrigin(r100);
        r100.dismiss();
    L7:
        f394295a = null;
    }

    public static boolean b() {
        PopupWindow r100 = f394295a;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.isShowing();
    }
}
