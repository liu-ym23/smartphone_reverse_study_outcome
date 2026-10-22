package com.bytedance.ee.bear.middleground.permission.secret;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u0012\u0010\u0017\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/bytedance/ee/bear/middleground/permission/secret/ReSubmitApplyDialogFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/antiscreenshots/BaseAntiScreenshotsDialogFragment;", "<init>", "()V", "confirmListener", "Landroid/content/DialogInterface$OnClickListener;", "getConfirmListener", "()Landroid/content/DialogInterface$OnClickListener;", "setConfirmListener", "(Landroid/content/DialogInterface$OnClickListener;)V", "cancelListener", "getCancelListener", "setCancelListener", WikiFolderPushPlugin.DATA, "Lcom/bytedance/ee/bear/middleground/permission/secret/SecretReviewModel;", "hasMe", "", ResourceData.KEY_TYPE, "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onStart", "Companion", "middleground-permission_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReSubmitApplyDialogFragment extends BaseAntiScreenshotsDialogFragment {
    public DialogInterface.OnClickListener h;
    public DialogInterface.OnClickListener i;
    public SecretReviewModel j;
    public boolean k;
    public int l;

    public static final class a {
    }

    public static final class b implements DialogInterface.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public final void onClick(DialogInterface r1, int r2) {
        }
    }

    static {
    }

    public ReSubmitApplyDialogFragment() {
        this.l = sbb.e.g.b;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        int r0 = ReSubmitApplyDialog.a;
        ReSubmitApplyDialog.e(getDialog(), this.j);
    }

    public final void onCreate(Bundle r7) {
        super.onCreate(r7);
        Bundle r8 = getArguments();
        if (r8 == null) goto L24;
        Object r1 = null;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L11
        Object r0 = r8.getSerializable("extra_data");     // Catch: Throwable -> L11
        if ((r0 instanceof SecretReviewModel) == false) goto L8;
        SecretReviewModel r3 = (SecretReviewModel) r0;     // Catch: Throwable -> L11
    L9:
        Object r4 = Result.constructor-impl(r3);     // Catch: Throwable -> L11
    L13:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L17;
        tt5.a.e("ReSubmitApplyDialogFragment", "deserialize extra_data failed", r5, false);
    L17:
        if (Result.isFailure-impl(r4) == true) goto L20;
        r1 = r4;
    L20:
        this.j = (SecretReviewModel) r1;
        this.k = r8.getBoolean("extra_has_me", false);
        this.l = r8.getInt("extra_type", sbb.e.g.b);
        return;
    L8:
        r3 = null;
    L11:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final Dialog onCreateDialog(Bundle r8) {
        int r9 = ReSubmitApplyDialog.a;
        FragmentActivity r0 = requireActivity();
        DialogInterface.OnClickListener r10 = this.h;
        if (r10 != null) goto L5;
        r10 = b.a;
    L5:
        UDDialog r11 = ReSubmitApplyDialog.a(r0, r10, this.i, this.j, this.k, this.l, new ReSubmitApplyDialogFragment$onCreateDialog$dialog$2(this));
        com.bytedance.ee.bear.middleground.permission.c.J(ReSubmitApplyDialog.b(this.j), this.k);
        return r11;
    }
}
