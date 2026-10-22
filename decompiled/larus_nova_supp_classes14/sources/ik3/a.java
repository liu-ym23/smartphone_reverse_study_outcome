package ik3;

import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.shopping.store.tabkit.container.TabKitDialogFragment;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(TabKitDialogFragment r3, TabKitRouterParams r4) {
        if (r3 != null) goto L4;
        return;
    L4:
        Integer r0 = null;
        if (r4 == null) goto L7;
        String r5 = r4.getPageExitAnim();
    L8:
        if (r5 != null) goto L11;
    L16:
        int r6 = 2131953519;
    L17:
        Dialog r1 = r3.getDialog();
        if (r1 == null) goto L24;
        Window r2 = r1.getWindow();
        if (r2 == null) goto L24;
        WindowManager.LayoutParams r7 = r2.getAttributes();
        if (r7 == null) goto L24;
        r0 = Integer.valueOf(r7.windowAnimations);
    L24:
        if (r0 != null) goto L27;
    L28:
        Dialog r8 = r3.getDialog();
        if (r8 == null) goto L35;
        Window r9 = r8.getWindow();
        if (r9 == null) goto L36;
        r9.setWindowAnimations(r6);
        return;
    L36:
        return;
    L35:
        return;
    L27:
        if (r0.intValue() != r6) goto L28;
        return;
    L11:
        if (r5.hashCode() != 3135100) goto L16;
        if (r5.equals("fade") == false) goto L16;
        r6 = 2131953521;
        goto L17
    L7:
        r5 = null;
        goto L8
    }
}
