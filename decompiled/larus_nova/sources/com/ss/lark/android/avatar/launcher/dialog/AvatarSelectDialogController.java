package com.ss.lark.android.avatar.launcher.dialog;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.crash.d;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larksuite.component.universe_design.dialog.UDDialogController;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class AvatarSelectDialogController extends UDDialogController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AvatarSelectMenuView.b f456627a;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0002R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0015"}, d2 = {"Lcom/ss/lark/android/avatar/launcher/dialog/AvatarSelectDialogController$AvatarSelectMenuView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "viewDependency", "Lcom/ss/lark/android/avatar/launcher/dialog/AvatarSelectDialogController$AvatarSelectMenuView$IAvatarSelectViewDependency;", "getViewDependency", "()Lcom/ss/lark/android/avatar/launcher/dialog/AvatarSelectDialogController$AvatarSelectMenuView$IAvatarSelectViewDependency;", "setViewDependency", "(Lcom/ss/lark/android/avatar/launcher/dialog/AvatarSelectDialogController$AvatarSelectMenuView$IAvatarSelectViewDependency;)V", "initView", "", "Companion", "IAvatarSelectViewDependency", "IAvatarSelectFunc", "avatar_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class AvatarSelectMenuView extends LinearLayout {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public c f456628a;

        public static final class a {
        }

        public interface b {
            void a(Context r100);

            void b(Context r100);
        }

        public interface c extends b {
            void dismiss();
        }

        static {
        }

        public AvatarSelectMenuView(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            AttributeSet r101 = null;
            this(r100, r101, 6, 0);
        }

        public AvatarSelectMenuView(Context r100, AttributeSet r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            this(r100, r101, 4, 0);
        }

        public final c getViewDependency() {
            return this.f456628a;
        }

        public final void setViewDependency(c r100) {
            this.f456628a = r100;
        }

        public AvatarSelectMenuView(Context r100, AttributeSet r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100, r101, r102);
            LayoutInflater.from(r100).inflate(R.layout.modify_avatar_bottom_popupwindow, this);
            findViewById(R.id.take_picture_tv).setOnClickListener(new com.ss.lark.android.avatar.launcher.dialog.a(this));
            findViewById(R.id.select_from_gallery_tv).setOnClickListener(new com.ss.lark.android.avatar.launcher.dialog.b(this));
            findViewById(R.id.cancel_tv).setOnClickListener(new com.ss.lark.android.avatar.launcher.dialog.c(this));
        }

        public /* synthetic */ AvatarSelectMenuView(Context r100, AttributeSet r101, int r102, int r103) {
            if ((r102 & 2) == 0) goto L5;
            r101 = null;
        L5:
            this(r100, r101, 0);
        }
    }

    public static final class a implements AvatarSelectMenuView.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AvatarSelectDialogController f456629a;

        @Override // com.ss.lark.android.avatar.launcher.dialog.AvatarSelectDialogController.AvatarSelectMenuView.c
        public final void dismiss() {
            UDDialog r100 = this.f456629a.getMDialog();
            if (r100 == null) goto L21;
            Handler r101 = DialogLancet.resolveDialogHandler(r100);
            if (r101 != null) goto L7;
        L9:
            DialogLancet.beforeDialogDismiss(r100);
            r100.dismiss();     // Catch: Throwable -> L12 Exception -> L14
        L18:
            DialogLancet.afterDialogDismiss(r100);
            return;
        L14:
            e = move-exception;
            d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L12
            Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L12
            if (r102 == null) goto L18;
            d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r100);
            throw th;
        L7:
            if (Looper.myLooper() == r101.getLooper()) goto L9;
            r101.post(DialogLancet.createDismissRunnable(r100));
            return;
        }

        public a(AvatarSelectDialogController r100) {
            this.f456629a = r100;
        }

        @Override // com.ss.lark.android.avatar.launcher.dialog.AvatarSelectDialogController.AvatarSelectMenuView.b
        public final void a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            AvatarSelectMenuView.b r101 = this.f456629a.f456627a;
            if (r101 == null) goto L6;
            r101.a(r100);
            return;
        }

        @Override // com.ss.lark.android.avatar.launcher.dialog.AvatarSelectDialogController.AvatarSelectMenuView.b
        public final void b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            AvatarSelectMenuView.b r101 = this.f456629a.f456627a;
            if (r101 == null) goto L6;
            r101.b(r100);
            return;
        }
    }

    @Override // com.larksuite.component.universe_design.dialog.UDDialogController
    public final View createView() {
        View r100 = super.createView();
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof AvatarSelectMenuView) == false) goto L8;
        AvatarSelectMenuView r101 = (AvatarSelectMenuView) r100;
    L9:
        if (r101 != null) goto L11;
        return null;
    L11:
        r101.setViewDependency(new a(this));
        return r100;
    L8:
        r101 = null;
        goto L9
    }

    public AvatarSelectDialogController(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
    }
}
