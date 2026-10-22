package sjb;

import android.text.TextUtils;
import android.view.View;
import android.widget.PopupWindow;
import com.larksuite.framework.ui.BasePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes36.dex */
public final class a extends BasePopupWindow {
    @Override // com.larksuite.framework.ui.BasePopupWindow, android.widget.PopupWindow
    public final void dismiss() {
        if (isOutsideTouchable() == true) goto L29;
        StackTraceElement[] r100 = ThreadMethodProxy.currentThread().getStackTrace();
        Intrinsics.checkNotNull(r100);
        boolean r101 = true;
        if (r100.length != 0) goto L7;
        boolean r102 = true;
    L9:
        if ((!r102) == false) goto L29;
        if (r100.length <= 3) goto L29;
        StackTraceElement r103 = r100[3];
        String r104 = r103.getClassName();
        String r105 = r103.getMethodName();
        String r106 = PopupWindow.class.getName();
        if (TextUtils.equals(r106.concat("$PopupDecorView"), r104) == true) goto L22;
        Intrinsics.checkNotNull(r104);
        if (r104.length() > 0) goto L18;
        r101 = false;
    L18:
        if (r101 == false) goto L29;
        Intrinsics.checkNotNull(r106);
        if (StringsKt.contains$default(r104, r106, false, 2, null) == false) goto L29;
    L22:
        if ("dispatchKeyEvent".equals(r105) == true) goto L29;
        if ("onTouchEvent".equals(r105) == false) goto L29;
        if (isOutsideTouchable() == true) goto L29;
        return;
    L7:
        r102 = false;
    L29:
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
    }

    public a(View r100, int r101, int r102) {
        super(r100, r101, r102);
    }
}
