package com.bytedance.android.shopping.store.tabkit.container;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements DialogInterface.OnShowListener {
    public final /* synthetic */ ABSTabkitBottomSheetFragment a;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.store.tabkit.container.a$a, reason: collision with other inner class name */
    public static final class C0020a implements TabKitBottomSheetBehavior.a {
        public final /* synthetic */ a a;

        public C0020a(a r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void a(View r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, "bottomSheet");
            this.a.a.getClass();
            if (r5 != 5) goto L24;
            Dialog r6 = this.a.a.getDialog();
            if (r6 == null) goto L24;
            Handler r0 = DialogLancet.resolveDialogHandler(r6);
            if (r0 != null) goto L9;
        L11:
            DialogLancet.beforeDialogDismiss(r6);
            r6.dismiss();     // Catch: Throwable -> L14 Exception -> L16
        L20:
            DialogLancet.afterDialogDismiss(r6);
            goto L24
        L16:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L14
            Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L14
            if (r1 == null) goto L20;
            com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L14
        L14:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r6);
            throw th;
        L9:
            if (Looper.myLooper() == r0.getLooper()) goto L11;
            r0.post(DialogLancet.createDismissRunnable(r6));
        L24:
            if (r5 != 3) goto L30;
            this.a.a.V90(true);
            Iterator<T> r7 = this.a.a.g.iterator();
        L27:
            if (r7.hasNext() == false) goto L30;
            ((ABSTabkitBottomSheetFragment.b) r7.next()).a();
        L30:
            if (r5 != 4) goto L35;
            this.a.a.V90(false);
            Iterator<T> r8 = this.a.a.g.iterator();
        L33:
            if (r8.hasNext() == false) goto L41;
            ((ABSTabkitBottomSheetFragment.b) r8.next()).a();
            goto L33
        L41:
            return;
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void b(View r2, float r3) {
            Intrinsics.checkNotNullParameter(r2, "bottomSheet");
            this.a.a.W90(r3);
        }

        @Override // com.bytedance.android.shopping.store.tabkit.container.TabKitBottomSheetBehavior.a
        public final void c(View r1, float r2, int r3, int r4, int r5) {
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
            Intrinsics.checkNotNullParameter(r1, "bottomSheet");
        }
    }

    public a(ABSTabkitBottomSheetFragment r1) {
        this.a = r1;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r3) {
        ABSTabkitBottomSheetFragment r4 = this.a;
        View r0 = r4.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r4.j == false) goto L7;
        ViewGroup.LayoutParams r5 = r0.getLayoutParams();
        r5.width = -1;
        r5.height = -1;
    L8:
        TabKitBottomSheetBehavior<View> r6 = this.a.d;
        if (r6 == null) goto L11;
        C0020a r1 = new C0020a(this);
        Intrinsics.checkNotNullParameter(r1, "callback");
        r6.E.add(r1);
    L11:
        ABSTabkitBottomSheetFragment r7 = this.a;
        TabKitBottomSheetBehavior<View> r2 = r7.d;
        if (r2 == null) goto L14;
        r2.setHideable(r7.i);
    L14:
        ABSTabkitBottomSheetFragment r8 = this.a;
        TabKitBottomSheetBehavior<View> r9 = r8.d;
        if (r9 == null) goto L17;
        r9.setPeekHeight(r8.T90());
    L17:
        ABSTabkitBottomSheetFragment r10 = this.a;
        TabKitBottomSheetBehavior<View> r11 = r10.d;
        if (r11 == null) goto L20;
        r11.e = r10.j;
    L20:
        if (r11 != null) goto L22;
        return;
    L22:
        if (r10.h == 1) goto L24;
        int r12 = 3;
    L25:
        r11.setState(r12);
        return;
    L24:
        r12 = 4;
        goto L25
    L7:
        ViewGroup.LayoutParams r13 = r0.getLayoutParams();
        r13.width = -1;
        r13.height = this.a.T90();
        goto L8
    }
}
