package com.bytedance.ee.bear.middleground.comment.input;

import android.text.Editable;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.middleground.comment.audio.RecordPanelBottomSheetDialog;
import com.bytedance.ee.bear.middleground.comment.audio.RecordPanelView;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements Runnable {
    public final /* synthetic */ AsideInputComment a;

    public n(AsideInputComment r1) {
        this.a = r1;
    }

    public final void a() {
        final AsideInputComment r0 = this.a;
        if (ForsetiHelper.s(r0.a.b) == false) goto L9;
        Fragment r1 = r0.a.b;
        if (r1 == null) goto L9;
        View r2 = r1.getView();
        if (r2 == null) goto L9;
        int r3 = r2.getWidth();
    L10:
        RecordPanelBottomSheetDialog r4 = new RecordPanelBottomSheetDialog(r0.a.getActivity(), r3, new AsideInputComment$createRecordPanelDialog$1(r0), new AsideInputComment$createRecordPanelDialog$2(r0));
        AsideInputComment r5 = this.a;
        r5.e().requestFocus();
        FragmentManager r6 = r5.a.d();
        LandscapeRestrictionOperation r7 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r4, "RecordPanelBottomSheetDialog", r7);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r6, r4, r7) == false) goto L26;
    L15:
        com.bytedance.ee.bear.middleground.comment.uitls.h r8 = r5.a.d0;
        r4.k.setCommentAnalytic(r8);
        r4.k.setViewModel(r5.Q);
        RecordPanelView r9 = r4.k;
        CommentEditText r10 = r5.e();
        r9.getClass();
        Intrinsics.checkNotNullParameter(r10, "editText");
        r9.i = r10;
        RecordPanelView r11 = r4.k;
        Editable r12 = r5.e().getText();
        boolean r13 = false;
        if (r12 != null) goto L18;
    L23:
        r11.h(r13);
        r4.k.setRecordPanelOperationCallback(new m(r5));
        r4.k.f();
        r0.k0 = r4;
        return;
    L18:
        if (r12.length() <= 0) goto L20;
        boolean r14 = true;
    L21:
        if (r14 != true) goto L23;
        r13 = true;
        goto L23
    L20:
        r14 = false;
        goto L21
    L26:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L14:
        r4.show(r6, "RecordPanelBottomSheetDialog");
    L9:
        r3 = -1;
        goto L10
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
