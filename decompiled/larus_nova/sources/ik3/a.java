package ik3;

import android.app.Dialog;
import android.view.Window;
import android.view.WindowManager;
import com.bytedance.android.shopping.store.tabkit.container.TabKitDialogFragment;
import com.bytedance.android.shopping.store.tabkit.router.TabKitRouterParams;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes14.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f490268a = 0;

    static {
    }

    public static void a(TabKitDialogFragment r100, TabKitRouterParams r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        Integer r102 = null;
        if (r101 == null) goto L7;
        String r103 = r101.getPageExitAnim();
    L8:
        if (r103 != null) goto L11;
    L16:
        int r104 = R.style.TabKitDialogAnimationExit;
    L17:
        Dialog r105 = r100.getDialog();
        if (r105 == null) goto L24;
        Window r106 = r105.getWindow();
        if (r106 == null) goto L24;
        WindowManager.LayoutParams r107 = r106.getAttributes();
        if (r107 == null) goto L24;
        r102 = Integer.valueOf(r107.windowAnimations);
    L24:
        if (r102 != null) goto L27;
    L28:
        Dialog r108 = r100.getDialog();
        if (r108 == null) goto L35;
        Window r109 = r108.getWindow();
        if (r109 == null) goto L36;
        r109.setWindowAnimations(r104);
        return;
    L36:
        return;
    L35:
        return;
    L27:
        if (r102.intValue() != r104) goto L28;
        return;
    L11:
        if (r103.hashCode() != 3135100) goto L16;
        if (r103.equals("fade") == false) goto L16;
        r104 = R.style.TabKitDialogAnimationFadeExit;
        goto L17
    L7:
        r103 = null;
        goto L8
    }
}
