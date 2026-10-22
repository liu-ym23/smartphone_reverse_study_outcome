package com.bytedance.applet.impl;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.ai.bridge.method.system.AbsOpenMapAppMethodIDL;
import com.bytedance.ai.bridge.service.IHostMapDepend;
import com.bytedance.ai.bridge.service.Location;
import com.bytedance.ai.bridge.service.NavigateMode;
import com.bytedance.ai.bridge.service.UserAction;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class x implements IHostMapDepend {
    public x() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void openMapApp(final Context r11, final NavigateMode r12, final Location r13, final Location r14, final Function1<? super AbsOpenMapAppMethodIDL.b, Unit> r15) {
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "mode");
        Intrinsics.checkNotNullParameter(r13, "dest");
        Intrinsics.checkNotNullParameter(r15, "callback");
        xv3.h.a.getClass();
        Intrinsics.checkNotNullParameter(r11, "context");
        Intrinsics.checkNotNullParameter(r12, "mode");
        Intrinsics.checkNotNullParameter(r13, "dest");
        Intrinsics.checkNotNullParameter(r15, "callback");
        if ((r11 instanceof Activity) == false) goto L9;
        Activity r0 = (Activity) r11;
        if (r0.isDestroyed() == false) goto L7;
        return;
    L7:
        if (r0.isFinishing() == false) goto L9;
        return;
    L9:
        ArrayList r1 = (ArrayList) xv3.h.g;
        r1.clear();
        xv3.h.c = xv3.h.b(r11, "com.autonavi.minimap");
        xv3.h.d = xv3.h.b(r11, "com.tencent.map");
        xv3.h.e = xv3.h.b(r11, "com.baidu.BaiduMap");
        if (xv3.h.c == false) goto L13;
        r1.add(new Pair(r11.getString(2131907253), new xv3.d(r11, r13, r12, r14)));
    L13:
        if (xv3.h.d == false) goto L16;
        r1.add(new Pair(r11.getString(2131907255), new xv3.e(r11, r13, r12, r14)));
    L16:
        if (xv3.h.e == false) goto L19;
        r1.add(new Pair(r11.getString(2131907254), new xv3.f(r11, r13, r12, r14)));
    L19:
        if (r1.isEmpty() == false) goto L25;
        StringBuilder r2 = new StringBuilder();
        r2.append(r11.getString(2131906157));
        if (xv3.h.c == false) goto L23;
        String r8 = "";
    L24:
        r2.append(r8);
        r1.add(new Pair(r2.toString(), new xv3.g(r11, r13, r12, r14)));
        goto L25
    L23:
        r8 = r11.getString(2131908172);
    L25:
        String[] r16 = new String[r1.size()];
        int r17 = r1.size();
        int r18 = 0;
    L26:
        if (r18 >= r17) goto L28;
        r16[r18] = ((Pair) ListProtector.get(xv3.h.g, r18)).getFirst();
        r18 = r18 + 1;
        goto L26
    L28:
        AlertDialog r19 = xv3.h.f;
        if (r19 == null) goto L47;
        Handler r110 = DialogLancet.resolveDialogHandler(r19);
        if (r110 != null) goto L33;
    L35:
        DialogLancet.beforeDialogDismiss(r19);
        r19.dismiss();     // Catch: Throwable -> L38 Exception -> L40
    L44:
        DialogLancet.afterDialogDismiss(r19);
        goto L47
    L40:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L38
        Throwable r111 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L38
        if (r111 == null) goto L44;
        com.bytedance.crash.d.d(r111, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r19);
        throw th;
    L33:
        if (Looper.myLooper() == r110.getLooper()) goto L35;
        r110.post(DialogLancet.createDismissRunnable(r19));
    L47:
        List<Pair<String, Function0<Unit>>> r112 = xv3.h.g;
        final ArrayList r113 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r114 = ((ArrayList) r112).iterator();
    L49:
        if (r114.hasNext() == false) goto L67;
        Pair r3 = (Pair) r114.next();
        xv3.h r9 = xv3.h.a;
        String r4 = (String) r3.getFirst();
        r9.getClass();
        if (Intrinsics.areEqual(r4, r11.getString(2131909187)) == false) goto L54;
        String r5 = UserAction.SELECT_MAP.getValue();
    L66:
        r113.add(r5);
        goto L49
    L54:
        if (Intrinsics.areEqual(r4, r11.getString(2131907253)) == false) goto L57;
        r5 = UserAction.AUTONAVI.getValue();
        goto L66
    L57:
        if (Intrinsics.areEqual(r4, r11.getString(2131907255)) == false) goto L60;
        r5 = UserAction.TENCENT.getValue();
        goto L66
    L60:
        if (Intrinsics.areEqual(r4, r11.getString(2131907254)) == false) goto L63;
        r5 = UserAction.BAIDU.getValue();
        goto L66
    L63:
        if (Intrinsics.areEqual(r4, r11.getString(2131906157) + r11.getString(2131908172)) == false) goto L65;
        r5 = UserAction.INSTALL_AUTONAVI.getValue();
        goto L66
    L65:
        r5 = "";
        goto L66
    L67:
        AlertDialog r115 = new AlertDialog.Builder(r11).setTitle(r11.getString(2131909187)).setItems(r16, new xv3.a(r15, r113)).setOnCancelListener(new xv3.b(r15, r113)).setOnDismissListener(new xv3.c()).create();
        xv3.h.f = r115;
        if (r115 != null) goto L70;
        return;
    L70:
        if (DialogLancet.shouldBlockDialogShow(r115) == false) goto L79;
        DialogLancet.handleBlockedDialogShow(r115);
        return;
    L79:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L75
    L73:
        DialogLancet.beforeDialogShow(r115);
        r115.show();
        DialogLancet.afterDialogShow(r115);
    }
}
