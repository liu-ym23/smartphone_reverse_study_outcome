package wm5;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.middleground.permission.export.permsdk.model.PermissionResponse;
import com.bytedance.ee.bear.sheet.inputbar.SheetEditFragment;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetEditorLayout;
import com.bytedance.ee.bear.sheet.inputbar.editor.SheetInputData;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ToolbarItemAdapter;
import com.bytedance.ee.bear.sheet.inputbar.toolbar.ToolbarItemEnum;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k1 implements ToolbarItemAdapter.a {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ PermissionResponse b;
    public final /* synthetic */ gj5.c c;
    public final /* synthetic */ SheetEditFragment d;

    public final void a(ToolbarItemEnum r10) {
        SheetEditFragment r0 = this.d;
        int r1 = SheetEditFragment.F;
        r0.getClass();
        String r2 = r10.name();
        if (TextUtils.equals(r10.name(), "text") == false) goto L5;
    L8:
        r0.f.getFormat().setValue(r2);
    L9:
        r0.g.i(r10);
        ToolbarItemAdapter r3 = r0.u;
        if (r3 != null) goto L12;
    L31:
        ToolbarItemEnum r11 = ToolbarItemEnum.text;
        if (r11.equals(r0.X90()) == false) goto L40;
        r0.m.requestFocus();
        if (com.bytedance.ee.bear.appsetting.c.a.a.g("ccm.mobile.ui_state_fix_enable") == false) goto L36;
        tt5.a.h("SheetEditFragment", "ui state fix enable is on");
        r0.aa0();
    L38:
        if (rcb.b.a(r0.getActivity()) == false) goto L44;
        r0.Z90(0);
    L44:
        if (ToolbarItemEnum.date.equals(r0.X90()) == false) goto L46;
        r0.m.setCursorVisible(false);
        r0.m.setNewLineEnable(false);
        r0.m.g("date", r0.f.getDateKeyboardCurType());
        return;
    L46:
        r0.f.getDateType().setValue("");
        SheetEditorLayout r4 = r0.m;
        ToolbarItemEnum r5 = ToolbarItemEnum.number;
        if (r5.equals(r0.X90()) == false) goto L49;
        String r12 = r5.name();
    L50:
        r4.g(r12, "");
        r0.m.setCursorVisible(!ToolbarItemEnum.insertImage.equals(r0.X90()));
        r0.m.setNewLineEnable(true);
        return;
    L49:
        r12 = r11.name();
        goto L50
    L36:
        rcb.c.g(r0.getContext());
        tt5.a.h("SheetEditFragment", "notifyToolbarSelectedItemChanged showKeyboard");
        goto L38
    L40:
        r0.W90();
        r0.w = r0.m.l();
        rcb.c.c(r0.getContext());
        tt5.a.h("SheetEditFragment", "notifyToolbarSelectedItemChanged hideKeyboard");
        r0.da0();
        r0.m.k();
        if (r0.A == false) goto L44;
        r0.g.g("text", r0.m.E);
        r0.A = false;
        goto L44
    L12:
        if (r3.c == false) goto L31;
        ToolbarItemEnum r6 = ToolbarItemEnum.text;
        if (r6.equals(r10) == false) goto L16;
    L17:
        r0.m.requestFocus();
        SheetEditorLayout r7 = r0.m;
        ToolbarItemEnum r8 = ToolbarItemEnum.number;
        if (r8.equals(r10) == false) goto L20;
        String r9 = r8.name();
    L21:
        r7.g(r9, "");
        r0.m.setCursorVisible(true);
        r0.m.setNewLineEnable(true);
        if (r6.equals(r10) == false) goto L30;
        r0.w = false;
        if (r0.getHost() == null) goto L29;
        FragmentTransaction r13 = r0.getChildFragmentManager().beginTransaction();
        Fragment r14 = r0.y;
        if (r14 == null) goto L29;
        r13.hide(r14).commitAllowingStateLoss();
    L29:
        rcb.c.g(r0.getContext());
        tt5.a.h("SheetEditFragment", "notifyToolbarSelectedItemChanged formula shortcut keep text keyboard");
        return;
    L30:
        r0.w = true;
        rcb.c.c(r0.getContext());
        r0.da0();
        r0.m.k();
        tt5.a.h("SheetEditFragment", "notifyToolbarSelectedItemChanged formula shortcut switch number keyboard");
        return;
    L20:
        r9 = r6.name();
        goto L21
    L16:
        if (ToolbarItemEnum.number.equals(r10) == false) goto L31;
    L5:
        if (TextUtils.equals(r10.name(), SheetInputData.InputData.FormatType.NUMBER) == true) goto L8;
        if (TextUtils.equals(r10.name(), "date") == false) goto L9;
        goto L8
    }

    public k1(SheetEditFragment r1, boolean r2, PermissionResponse r3, gj5.c r4) {
        this.d = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
