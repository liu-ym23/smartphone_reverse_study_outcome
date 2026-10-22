package wm5;

import android.text.TextUtils;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.sheet.inputbar.OfficeSheetEditFragment;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.OfficeToolbarItemAdapter;
import com.bytedance.ee.bear.sheet_core.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.sheet_core.inputbar.toolbar.ToolbarItemEnum;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 implements OfficeToolbarItemAdapter.a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ PermissionResponse b;
    public final /* synthetic */ gj5.c c;
    public final /* synthetic */ OfficeSheetEditFragment d;

    public final void a(ToolbarItemEnum r11) {
        final OfficeSheetEditFragment r0 = this.d;
        int r1 = OfficeSheetEditFragment.F;
        r0.getClass();
        String r2 = r11.name();
        if (TextUtils.equals(r11.name(), "text") == false) goto L5;
    L8:
        r0.f.getFormat().setValue(r2);
    L9:
        hn5.c r3 = r0.g;
        String r4 = r11.name();
        r3.getClass();
        if (r4 != null) goto L12;
        r4 = "";
    L12:
        ToolbarItemEnum r5 = ToolbarItemEnum.getToolbarItemEnumByName(r4);
        on5.a r6 = r3.a;
        r6.getClass();
        int r7 = on5.a.C0283a.a[r5.ordinal()];
        if (r7 != 1) goto L15;
        r6.b("switch_text_tab");
    L22:
        OfficeToolbarItemAdapter r8 = r0.o;
        if (r8 != null) goto L25;
    L44:
        ToolbarItemEnum r12 = ToolbarItemEnum.text;
        if (r12.equals(r0.X90()) == true) goto L47;
        r0.W90();
        r0.q = r0.m.l();
        rcb.c.c(r0.getContext());
        tt5.a.h("SheetEditFragment", "notifyToolbarSelectedItemChanged hideKeyboard");
        r0.da0();
        r0.m.k();
        if (r0.w == false) goto L73;
        hn5.c r9 = r0.g;
        r9.a.e("text", r0.m.B);
        r0.w = false;
    L73:
        if (ToolbarItemEnum.date.equals(r0.X90()) == false) goto L75;
        r0.m.setCursorVisible(false);
        r0.m.setNewLineEnable(false);
        r0.m.g("date", r0.f.getDateKeyboardCurType());
        return;
    L75:
        r0.f.getDateType().setValue("");
        SheetEditorLayout r10 = r0.m;
        ToolbarItemEnum r13 = ToolbarItemEnum.number;
        if (r13.equals(r0.X90()) == false) goto L78;
        String r14 = r13.name();
    L79:
        r10.g(r14, "");
        r0.m.setCursorVisible(!ToolbarItemEnum.insertImage.equals(r0.X90()));
        r0.m.setNewLineEnable(true);
        return;
    L78:
        r14 = r12.name();
        goto L79
    L47:
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ui_state_fix_enable") == false) goto L58;
        tt5.a.h("SheetEditFragment", "ui state fix enable is on");
        DialogFragment r15 = r0.s;
        if ((r15 instanceof DialogFragment) == true) goto L83;
    L57:
        r0.aa0();
        goto L73
    L83:
        r15.dismissAllowingStateLoss();     // Catch: Exception -> L53
    L53:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r16 = DialogFragmentLancet.sLastShowStack;
        if (r16 == null) goto L57;
        com.bytedance.crash.d.d(r16, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L57
    L58:
        Runnable r17 = new m(r0);
        DialogFragment r18 = r0.s;
        if ((r18 instanceof DialogFragment) == true) goto L81;
        r17.run();
        goto L73
    L81:
        r18.dismissAllowingStateLoss();     // Catch: Exception -> L63
    L67:
        com.bytedance.ee.util.ui.j.d(r17, 100);
    L63:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r19 = DialogFragmentLancet.sLastShowStack;
        if (r19 == null) goto L67;
        com.bytedance.crash.d.d(r19, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L67
    L25:
        if (r8.c == false) goto L44;
        ToolbarItemEnum r20 = ToolbarItemEnum.text;
        if (r20.equals(r11) == false) goto L29;
    L30:
        r0.m.requestFocus();
        SheetEditorLayout r21 = r0.m;
        ToolbarItemEnum r22 = ToolbarItemEnum.number;
        if (r22.equals(r11) == false) goto L33;
        String r23 = r22.name();
    L34:
        r21.g(r23, "");
        r0.m.setCursorVisible(true);
        r0.m.setNewLineEnable(true);
        if (r20.equals(r11) == false) goto L43;
        r0.q = false;
        if (r0.getHost() == null) goto L42;
        FragmentTransaction r110 = r0.getChildFragmentManager().beginTransaction();
        Fragment r24 = r0.s;
        if (r24 == null) goto L42;
        r110.hide(r24).commitAllowingStateLoss();
    L42:
        rcb.c.g(r0.getContext());
        tt5.a.h("SheetEditFragment", "notifyToolbarSelectedItemChanged formula shortcut keep text keyboard");
        return;
    L43:
        r0.q = true;
        rcb.c.c(r0.getContext());
        r0.da0();
        r0.m.k();
        tt5.a.h("SheetEditFragment", "notifyToolbarSelectedItemChanged formula shortcut switch number keyboard");
        return;
    L33:
        r23 = r20.name();
        goto L34
    L29:
        if (ToolbarItemEnum.number.equals(r11) == false) goto L44;
    L15:
        if (r7 != 2) goto L17;
        r6.b("switch_number_tab");
        goto L22
    L17:
        if (r7 != 3) goto L22;
        r6.b("switch_date_tab");
        goto L22
    L5:
        if (TextUtils.equals(r11.name(), SheetInputData.InputData.FormatType.NUMBER) == true) goto L8;
        if (TextUtils.equals(r11.name(), "date") == false) goto L9;
        goto L8
    }

    public d0(OfficeSheetEditFragment r1, boolean r2, PermissionResponse r3, gj5.c r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
