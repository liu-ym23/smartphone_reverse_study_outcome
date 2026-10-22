package com.bytedance.ee.bear.bitable.card.view.cell.attachment.view;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.live.core.monitor.NewBroadcastMonitor;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.fileselector.api.FileSelectConfig;
import com.larksuite.component.universe_design.dialog.UDDialogBuilder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import hp4.u;
import io.reactivex.disposables.CompositeDisposable;
import java.lang.ref.WeakReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class AttachmentMediaPickerPanel implements u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f207427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final BitableAnalytic f207428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lifecycle f207429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f207430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Dialog f207431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public WeakReference<View> f207432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Animation f207433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AttachmentMediaPickerPanel$cancelProcessUri$1 f207434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final b f207435i;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AttachmentMediaPickerPanel f207436a;

        public static final class a implements DialogInterface.OnClickListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f207437a = null;

            static {
                f207437a = new a();
            }

            public a() {
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface r100, int r101) {
                r100.dismiss();
            }
        }

        /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentMediaPickerPanel$b$b, reason: collision with other inner class name */
        public static final class DialogInterfaceOnDismissListenerC2993b implements DialogInterface.OnDismissListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ AttachmentMediaPickerPanel f207438a;

            public DialogInterfaceOnDismissListenerC2993b(AttachmentMediaPickerPanel r100) {
                this.f207438a = r100;
            }

            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface r100) {
                WeakReference<View> r101 = this.f207438a.f207432f;
                if (r101 == null) goto L7;
                View r102 = r101.get();
                if (r102 == null) goto L7;
                r102.clearAnimation();
            L7:
                ((CompositeDisposable) this.f207438a.f207430d.getValue()).clear();
            }
        }

        public b(AttachmentMediaPickerPanel r100) {
            this.f207436a = r100;
        }

        public final void a() {
            if (com.bytedance.ee.bear.bitable.c.m() == false) goto L6;
            Toast.showLoading(this.f207436a.getContext(), com.bytedance.ee.util.ui.n.x(this.f207436a.getContext(), R.string.Bitable_Common_Loading_Mobile));
            return;
        L6:
            AttachmentMediaPickerPanel r100 = this.f207436a;
            Dialog r101 = r100.f207431e;
            boolean r102 = false;
            if (r101 != null) goto L9;
            View r103 = LayoutInflater.from(r100.getContext()).inflate(R.layout.bitable_attacment_processsing_dialog, null);
            AttachmentMediaPickerPanel r104 = this.f207436a;
            r104.f207432f = new WeakReference(r103.findViewById(R.id.loading_view));
            AttachmentMediaPickerPanel r105 = this.f207436a;
            r105.f207433g = AnimationUtils.loadAnimation(r105.getContext(), R.anim.uploading_anim);
            AttachmentMediaPickerPanel r106 = this.f207436a;
            Context r107 = this.f207436a.getContext();
            Intrinsics.checkNotNull(r107);
            r106.f207431e = new UDDialogBuilder(r107).contentLayout(r103).addActionButton(R.id.ud_dialog_btn_primary, R.string.Bitable_BTModule_Cancel, a.f207437a).cancelOnTouchOutside(false).autoDismiss(false).onDismissListener(new DialogInterfaceOnDismissListenerC2993b(this.f207436a)).build();
        L15:
            AttachmentMediaPickerPanel r108 = this.f207436a;
            WeakReference<View> r109 = r108.f207432f;
            if (r109 == null) goto L20;
            View r110 = r109.get();
            if (r110 == null) goto L20;
            r110.startAnimation(r108.f207433g);
        L20:
            Dialog r111 = this.f207436a.f207431e;
            if (r111 != null) goto L23;
            return;
        L23:
            if (DialogLancet.shouldBlockDialogShow(r111) == false) goto L29;
            DialogLancet.handleBlockedDialogShow(r111);
            return;
        L29:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L28
        L26:
            DialogLancet.beforeDialogShow(r111);
            r111.show();
            DialogLancet.afterDialogShow(r111);
            return;
        L9:
            if (r101 != null) goto L11;
        L13:
            if (r102 == false) goto L15;
            return;
        L11:
            if (r101.isShowing() != true) goto L13;
            r102 = true;
            goto L13
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

    static {
    }

    @Override // hp4.u
    public final int getPanelHeight(Context r100) {
        return 0;
    }

    @Override // hp4.u
    public final boolean r2() {
        return false;
    }

    public final void a() {
        if (com.bytedance.ee.bear.bitable.c.m() == false) goto L5;
        Toast.cancelLoading();
    L24:
        com.bytedance.ee.util.ui.j.e(this.f207435i);
        return;
    L5:
        Dialog r100 = this.f207431e;
        if (r100 == null) goto L24;
        Handler r101 = DialogLancet.resolveDialogHandler(r100);
        if (r101 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r100);
        r100.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r100);
        goto L24
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r102 == null) goto L21;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r100);
        throw th;
    L10:
        if (Looper.myLooper() == r101.getLooper()) goto L12;
        r101.post(DialogLancet.createDismissRunnable(r100));
        goto L24
    }

    public final Context getContext() {
        return this.f207427a;
    }

    public final void b(za5.b r100, Runnable r101) {
        if (r101 == null) goto L5;
        r101.run();
        return;
    L5:
        Context r102 = this.f207427a;
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity");
        FragmentActivity r103 = (FragmentActivity) r102;
        FileSelectConfig.h r104 = FileSelectConfig.larkCamaraBuilder();
        FileSelectConfig r105 = r104.f226780a;
        r105.fileSelectListener = r100;
        r105.showTakeVideo = true;
        r105.camaraUse1080P = true;
        r105.maxImageCompressSize = 2097152;
        FileSelectConfig r106 = r104.a();
        int r107 = com.bytedance.ee.bear.fileselector.d.f226786a;
        FragmentManager r108 = r103.getSupportFragmentManager();
        Intrinsics.checkNotNull(r106);
        com.bytedance.ee.bear.fileselector.d.a.c(r103, r108, r106, "AttachmentMediaPickerPanel");
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.bytedance.ee.bear.bitable.card.view.cell.attachment.view.AttachmentMediaPickerPanel$cancelProcessUri$1] */
    public AttachmentMediaPickerPanel(Context r100, BitableAnalytic r101, Lifecycle r102) {
        Intrinsics.checkNotNullParameter(r101, "analytic");
        Intrinsics.checkNotNullParameter(r102, NewBroadcastMonitor.STAGE.LIFECYCLE);
        this.f207427a = r100;
        this.f207428b = r101;
        this.f207429c = r102;
        this.f207430d = LazyKt.lazy(AttachmentMediaPickerPanel$compositeDisposable$2.INSTANCE);
        this.f207434h = new AttachmentMediaPickerPanel$cancelProcessUri$1(this);
        this.f207435i = new b(this);
    }
}
