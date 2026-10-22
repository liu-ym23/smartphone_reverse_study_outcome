package com.bytedance.ee.bear.bitable.pro;

import android.content.Context;
import android.widget.CompoundButton;
import com.bytedance.ee.bear.widgets.dialog.BearUDDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDBaseDialogBuilder;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class j implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ BitableProFragment a;

    public j(BitableProFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton r10, boolean r11) {
        this.a.ga0().toggle();
        final BitableProFragment r12 = this.a;
        BitableProViewModel r13 = r12.D;
        BitableProViewModel r0 = null;
        if (r13 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r13 = null;
    L5:
        Boolean r14 = (Boolean) r13.getIsPro().getValue();
        if (r14 != null) goto L9;
        tt5.a.d(r12.v, "curIsPro is null");
        return;
    L9:
        if (r14.booleanValue() == false) goto L18;
        int r16 = d.a;
        JSONObject r17 = new JSONObject();
        r17.put("click", "turn_off");
        r17.put("target", "ccm_bitable_premium_permission_delete_view");
        r17.put("is_template", "false");
        d.b("ccm_bitable_premium_permission_setting_click", r17);
        Function0<Unit> r18 = new BitableProFragment$clickUpdatePro$1(r12);
        Function0<Unit> r1 = new BitableProFragment$clickUpdatePro$2(r12);
        Context r2 = r12.getContext();
        if (r2 != null) goto L13;
        tt5.a.d(r12.v, "context is null");
        return;
    L13:
        hp5.a r19 = new hp5.a(r2).title(2131886149).titleSize(17).message(2131886147).messageGravity(8388611).messageTextSize(16);
        String r3 = r2.getString(2131886148);
        r19.getClass();
        Intrinsics.checkNotNullParameter(r3, "value");
        r19.b = r3;
        r19.d = 2131106607;
        r19.e = true;
        r19.a = false;
        UDDialog r110 = r19.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131886351).onClickListener(new s(r18))).addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391778).text(2131886350).onClickListener(new t(r1)).textColorRes(2131106622)).cancelOnTouchOutside(false).build();
        if (DialogLancet.shouldBlockDialogShow(r110) == false) goto L50;
        DialogLancet.handleBlockedDialogShow(r110);
        return;
    L50:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L48
    L17:
        DialogLancet.beforeDialogShow(r110);
        r110.show();
        DialogLancet.afterDialogShow(r110);
        return;
    L18:
        BitableProViewModel r111 = r12.D;
        if (r111 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L22:
        ArrayList r112 = (ArrayList) r0.getRoleListLiveData().getValue();
        if (r112 == null) goto L32;
        Iterator r113 = r112.iterator();
    L26:
        if (r113.hasNext() == false) goto L32;
        Role r4 = (Role) r113.next();
        if (r4.isFaType() == true) goto L26;
        if (r4.hasMembers() == false) goto L26;
        boolean r114 = true;
    L33:
        if (r114 == true) goto L35;
        r12.ja0(true);
        return;
    L35:
        Function1<Boolean, Unit> r115 = new BitableProFragment$clickUpdatePro$3(r12);
        Function0<Unit> r5 = new BitableProFragment$clickUpdatePro$4(r12);
        Context r6 = r12.getContext();
        if (r6 != null) goto L38;
        tt5.a.d(r12.v, "context is null");
        return;
    L38:
        Intrinsics.checkNotNullParameter(r6, "context");
        UDDialogBuilder r116 = new UDDialogBuilder(r6);
        r116.autoDismiss(true);
        r116.cancelOnTouchOutside(false);
        r116.title(2131886158);
        r116.titleBold(true);
        BearUDDialogBuilder.ActionBottomOrientation r7 = BearUDDialogBuilder.ActionBottomOrientation.VERTICAL;
        Intrinsics.checkNotNullParameter(r7, "value");
        if (r7 != BearUDDialogBuilder.ActionBottomOrientation.HORIZONTAL) goto L41;
        UDBaseDialogBuilder.ActionBottomOrientation r8 = UDBaseDialogBuilder.ActionBottomOrientation.HORIZONTAL;
    L42:
        r116.actionButtonOrientation(r8);
        r116.addActionButton(new UDBaseDialogBuilder.ActionBuilder().actionResId(2131391777).text(2131886160).textColorRes(2131101111).onClickListener(new u(r115)));
        r116.addActionButton(2131391778, 2131886159, new v(r115));
        r116.addActionButton(2131391779, 2131886350, new w(r5));
        r116.cancelOnTouchOutside(false);
        UDDialog r117 = r116.build();
        if (DialogLancet.shouldBlockDialogShow(r117) == false) goto L52;
        DialogLancet.handleBlockedDialogShow(r117);
        return;
    L52:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L49
    L46:
        DialogLancet.beforeDialogShow(r117);
        r117.show();
        DialogLancet.afterDialogShow(r117);
        return;
    L41:
        r8 = UDBaseDialogBuilder.ActionBottomOrientation.VERTICAL;
    L32:
        r114 = false;
        goto L33
    L21:
        r0 = r111;
        goto L22
    }
}
