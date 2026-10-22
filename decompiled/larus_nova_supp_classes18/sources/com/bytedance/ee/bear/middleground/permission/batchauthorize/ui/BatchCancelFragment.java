package com.bytedance.ee.bear.middleground.permission.batchauthorize.ui;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.lifecycle.ViewModelProviders;
import com.bytedance.crash.d;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.middleground.feed.export.bean.DocFeed$Value$Result;
import com.bytedance.ee.bear.middleground.permission.batchauthorize.model.BatchAuthorizeViewModel;
import com.bytedance.ee.bear.middleground.permission.c;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BatchCancelFragment extends BaseAntiScreenshotsDialogFragment {
    public static final /* synthetic */ int h = 0;

    public class a implements View.OnClickListener {
        public final /* synthetic */ BatchCancelFragment a;

        public a(BatchCancelFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            int r3 = BatchCancelFragment.h;
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            c.m();
            return;
        L5:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L9;
            d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public class b implements View.OnClickListener {
        public final /* synthetic */ BatchCancelFragment a;

        public b(BatchCancelFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r12) {
            String r13 = c.a;
            JSONObject r14 = new JSONObject();
            String r1 = c.f;
            int r2 = c.g;
            if (c.c == false) goto L5;
            String r3 = ThumbGlideUrl.SOURCE_VC;
        L6:
            c.a(r14, r1, r2, r3, c.h, c.d, c.e, c.a, c.b, c.i);
            r14.put("click", DocFeed$Value$Result.CANCEL);
            r14.put("target", "none");
            c.c("ccm_permission_cited_doc_authorize_click", r14);
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r15 = DialogFragmentLancet.sLastShowStack;
            if (r15 == null) goto L16;
            d.d(r15, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L16:
            return;
        L5:
            r3 = "none";
            goto L6
        }
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 != null) goto L5;
        Window r1 = null;
    L6:
        if (r1 == null) goto L8;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        r2.width = -1;
        r2.gravity = 80;
        r2.height = -1;
        r1.clearFlags(2);
        r2.windowAnimations = 2131951623;
        r1.setAttributes(r2);
        r1.setBackgroundDrawable(new ColorDrawable(getResources().getColor(2131100562)));
    L8:
        setCancelable(true);
        return;
    L5:
        r1 = r0.getWindow();
        goto L6
    }

    public BatchCancelFragment() {
    }

    public final void onViewCreated(View r2, Bundle r3) {
        super/*com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment*/.onViewCreated(r2, r3);
        r2.findViewById(2131365122).setOnClickListener(new a(this));
        r2.findViewById(2131365123).setOnClickListener(new b(this));
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        BatchAuthorizeViewModel r5 = (BatchAuthorizeViewModel) ViewModelProviders.of(this).get(BatchAuthorizeViewModel.class);
        return r2.inflate(2131558772, r3, false);
    }
}
