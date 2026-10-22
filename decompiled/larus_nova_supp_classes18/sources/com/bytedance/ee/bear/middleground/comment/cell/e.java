package com.bytedance.ee.bear.middleground.comment.cell;

import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.graphics.ColorUtils;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.larksuite.component.ui.dialog.LKUIDialog;
import com.larksuite.framework.utils.UIUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.StatusBarUtil;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public e() {
    }

    public static void b(LKUIDialog r1, Function0 r2, com.bytedance.ee.bear.middleground.comment.uitls.p r3, String r4, String r5) {
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L10;
        DialogLancet.handleBlockedDialogShow(r1);
    L7:
        r1.setOnDismissListener(new d(r2, r3));
        r3.N.a(new ef5.l(r4, r5, 1));
        return;
    L10:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L9
    L6:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        goto L7
    }

    public static LKUIDialog a(final com.bytedance.ee.bear.middleground.comment.uitls.p r17, com.bytedance.ee.bear.middleground.comment.control.t r18, CommentBean.CommentDetail r19, String r20, View r21, int r22) {
        final Function0 r8 = null;
        if ((r22 & 16) == 0) goto L5;
        View r9 = null;
    L6:
        Intrinsics.checkNotNullParameter(r17, "config");
        Intrinsics.checkNotNullParameter(r18, "dataControl");
        Intrinsics.checkNotNullParameter(r19, "commentDetail");
        Intrinsics.checkNotNullParameter(r20, "replyId");
        String r1 = r19.getComment_id();
        if (r1 != null) goto L9;
        r1 = "";
    L9:
        String r10 = r1;
        int r12 = 0;
        if (r17.n.isAside() == false) goto L13;
        if (r9 == null) goto L13;
        boolean r13 = true;
    L14:
        if (r13 == false) goto L16;
        com.bytedance.ee.bear.widgets.a r2 = new com.bytedance.ee.bear.widgets.a(r17.getActivity());
    L17:
        com.bytedance.ee.bear.widgets.a r14 = r2;
        CharSequence r15 = r17.getActivity().getText(2131887615);
        a r5 = new a(r17, r18, r19, r10, r20);
        cp5.b r3 = new cp5.b();
        r3.a = r15;
        r3.d = false;
        r3.e = null;
        r3.f = r5;
        r3.c = false;
        r3.b = -1;
        r3.g = true;
        r3.h = 1.0f;
        r3.i = !r13;
        r14.f(r3);
        if (r13 == false) goto L21;
        CharSequence r4 = r17.getActivity().getText(2131888309);
        cp5.b r6 = new cp5.b();
        r6.a = r4;
        r6.d = false;
        r6.e = null;
        r6.f = null;
        r6.c = false;
        r6.b = -1;
        r6.g = true;
        r6.h = 1.0f;
        r6.i = false;
        r14.f(r6);
    L21:
        if (ColorUtils.calculateContrast(-1, UIUtils.getColor(r17.getActivity(), 2131100548)) > 3.0d) goto L23;
        float r7 = -1.0f;
    L24:
        LKUIDialog r11 = r14.m(r7);
        if (r13 == true) goto L27;
        b(r11, null, r17, r10, r20);
    L56:
        return r11;
    L27:
        int r16 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l.a;
        final com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.k r23 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l.c(r17.getActivity(), r11);
        r17.getActivity().registerComponentCallbacks(r23);
        b(r11, new DeleteCell$showDelete$1(r8, r17, r23), r17, r10, r20);
        if (r9 == null) goto L56;
        Object r0 = r9.getParent();     // Catch: Exception -> L48
        if ((r0 instanceof View) == false) goto L33;
        View r24 = (View) r0;     // Catch: Exception -> L48
    L35:
        if (r24 == null) goto L45;
        if (r12 >= 20) goto L45;
        if (r24.getId() == 2131384813) goto L39;
        Object r25 = r24.getParent();     // Catch: Exception -> L48
        if ((r25 instanceof View) == false) goto L43;
        r24 = (View) r25;     // Catch: Exception -> L48
    L44:
        r12 = r12 + 1;     // Catch: Exception -> L48
        goto L35
    L43:
        r24 = null;
        goto L44
    L39:
        r9 = r24;
    L50:
        Rect r26 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.m.b(r9);
        int r27 = UIUtils.dp2px(r17.getActivity(), 320.0f);
        UIUtils.dp2px(r17.getActivity(), 105.0f);
        Window r28 = r11.getWindow();
        if (r28 == null) goto L56;
        WindowManager.LayoutParams r29 = r28.getAttributes();
        if (r29 != null) goto L55;
        r29 = new WindowManager.LayoutParams();
    L55:
        r29.gravity = 8388659;
        r29.width = r27;
        r29.height = -2;
        r29.x = r26.left;
        r29.y = r26.top - StatusBarUtil.getStatusBarHeight(r17.getActivity());
        r28.setAttributes(r29);
        int r30 = com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l.a;
        com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.l.b(r17.getActivity(), r11);
    L45:
        if (r12 < 20) goto L50;
        tt5.a.d("Comment#DeleteCell", "findRootParent: depth:" + r12);     // Catch: Exception -> L48
        goto L50
    L33:
        r24 = null;
    L48:
        e = move-exception;
        tt5.a.d("Comment#DeleteCell", "findRootParent: " + e);
        goto L50
    L23:
        r7 = 0.4f;
        goto L24
    L16:
        r2 = new com.bytedance.ee.bear.widgets.a(r17.getActivity());
        r2.a();
    L13:
        r13 = false;
        goto L14
    L5:
        r9 = r21;
        goto L6
    }
}
