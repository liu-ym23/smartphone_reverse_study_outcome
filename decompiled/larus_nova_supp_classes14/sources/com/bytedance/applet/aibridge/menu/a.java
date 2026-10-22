package com.bytedance.applet.aibridge.menu;

import android.content.Context;
import android.graphics.Color;
import androidx.core.content.ContextCompat;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import com.google.gson.JsonObject;
import com.larus.bmhome.chat.api.ILegacyChatUiServiceDelegate;
import com.larus.bmhome.view.screenmenu.f1;
import com.larus.bmhome.view.screenmenu.i0;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static final ot8.a b(WidgetMenuItem r17) {
        Intrinsics.checkNotNullParameter(r17, "<this>");
        boolean r0 = v19.h.a;
        Object r2 = null;
        boolean r1 = v19.h.a(null);
        int r4 = 0;
        if (Intrinsics.areEqual(r17.getItemStyle(), "switch") == false) goto L40;
        String r3 = r17.getId();
        if (r3 == null) goto L7;
        int r6 = r3.hashCode();
    L8:
        String r8 = r17.getText();
        if (r1 == false) goto L11;
        String r5 = r17.getIconDark();
    L12:
        String r9 = r5;
        if (r1 == false) goto L15;
        String r7 = r17.getTextColorDark();
    L16:
        if (r7 != null) goto L94;
    L26:
        Integer r11 = r2;
        Function1<Boolean, Unit> r16 = r17.getOnTap();
        Boolean r10 = r17.getSwitchStatus();
        if (r10 == null) goto L29;
        boolean r14 = r10.booleanValue();
    L30:
        Boolean r12 = r17.getForbiddenDismissAfterClick();
        if (r12 == null) goto L33;
        boolean r13 = r12.booleanValue();
    L34:
        Boolean r15 = r17.getDisableClick();
        if (r15 == null) goto L37;
        boolean r18 = r15.booleanValue();
    L103:
        return new f1(r6, false, r8, r9, null, r11, false, r13, r14, r18, r16);
    L37:
        r18 = false;
        goto L103
    L33:
        r13 = false;
        goto L34
    L29:
        r14 = false;
        goto L30
    L94:
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L19
        Object r20 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r7)));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r20) == true) goto L25;
        r2 = r20;
    L25:
        r2 = (Integer) r2;
    L19:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r20 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L15:
        r7 = r17.getTextColorLight();
        goto L16
    L11:
        r5 = r17.getIconLight();
        goto L12
    L7:
        r6 = 0;
        goto L8
    L40:
        if (Intrinsics.areEqual(r17.getItemStyle(), "double") == false) goto L57;
        ArrayList r22 = new ArrayList();
        List<WidgetMenuItem> r23 = r17.getLineItems();
        if (r23 == null) goto L52;
        Iterator<T> r24 = r23.iterator();
    L45:
        if (r24.hasNext() == false) goto L52;
        pt8.b r25 = b((WidgetMenuItem) r24.next());
        if ((r25 instanceof pt8.b) == false) goto L49;
        pt8.b r26 = r25;
    L50:
        if (r26 == null) goto L45;
        r22.add(r26);
        goto L45
    L49:
        r26 = null;
    L52:
        String r27 = r17.getId();
        if (r27 == null) goto L104;
        r4 = r27.hashCode();
    L104:
        return new pt8.g(r4, r22);
    L57:
        if (Intrinsics.areEqual(r17.getItemStyle(), "divider") == false) goto L62;
        AppHost.Companion r28 = AppHost.a;
        Context r29 = r28.a().getCurrentActivity();
        if (r29 != null) goto L61;
        r29 = r28.getApplication();
    L61:
        Intrinsics.checkNotNullParameter(r29, "context");
        return new i0(0, ContextCompat.getColor(r29, v19.c.b(2130972086, null, 2131103159)));
    L62:
        String r30 = r17.getId();
        if (r30 == null) goto L65;
        int r31 = r30.hashCode();
    L66:
        String r32 = r17.getText();
        if (r1 == false) goto L69;
        String r33 = r17.getIconDark();
    L70:
        String r34 = r33;
        if (r1 == false) goto L73;
        String r35 = r17.getTextColorDark();
    L74:
        if (r35 != null) goto L96;
    L84:
        Integer r36 = r2;
        Function1<Boolean, Unit> r110 = r17.getOnTap();
        Boolean r37 = r17.getForbiddenDismissAfterClick();
        if (r37 == null) goto L87;
        boolean r111 = r37.booleanValue();
    L88:
        Boolean r38 = r17.getDisableClick();
        if (r38 == null) goto L91;
        boolean r112 = r38.booleanValue();
    L93:
        return new pt8.b(r31, r32, r34, r36, r111, r112, r110);
    L91:
        r112 = false;
        goto L93
    L87:
        r111 = false;
        goto L88
    L96:
        Result.Companion r39 = Result.Companion;     // Catch: Throwable -> L77
        Object r40 = Result.constructor-impl(Integer.valueOf(Color.parseColor(r35)));     // Catch: Throwable -> L77
    L80:
        if (Result.isFailure-impl(r40) == true) goto L83;
        r2 = r40;
    L83:
        r2 = (Integer) r2;
    L77:
        th = move-exception;
        Result.Companion r41 = Result.Companion;
        r40 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L80
    L73:
        r35 = r17.getTextColorLight();
        goto L74
    L69:
        r33 = r17.getIconLight();
        goto L70
    L65:
        r31 = 0;
        goto L66
    }

    public static final void a(WidgetContainer r2, WidgetMenuItem r3, Boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "widgetContainer");
        Intrinsics.checkNotNullParameter(r3, "menuItem");
        JsonObject r0 = new JsonObject();
        r0.addProperty("id", r3.getId());
        cf8.c r5 = ILegacyChatUiServiceDelegate.b.H8();
        if (r5 == null) goto L5;
        String r6 = r5.f();
    L6:
        r0.addProperty("menuId", r6);
        if (r4 == null) goto L9;
        r0.addProperty("switchStatus", Boolean.valueOf(r4.booleanValue()));
    L9:
        Unit r7 = Unit.INSTANCE;
        r2.onMessageToAIBridge("flow.menuItemClicked", r0);
        return;
    L5:
        r6 = null;
        goto L6
    }
}
