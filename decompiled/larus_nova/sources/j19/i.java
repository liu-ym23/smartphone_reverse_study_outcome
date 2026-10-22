package j19;

import android.os.Handler;
import android.os.Looper;
import com.larus.common_ui.photoviewer.PhotoViewerDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes27.dex */
public final class i implements l19.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PhotoViewerDialog f496874a;

    public i(PhotoViewerDialog r100) {
        this.f496874a = r100;
    }

    @Override // l19.f
    public final void onTransitionBegin(int r100) {
        Iterator<d> r101 = this.f496874a.f327634i.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onTransitionBegin(r100);
        goto L4
    }

    @Override // l19.f
    public final void onTransitionEnd(int r100) {
        if (r100 != 2) goto L5;
        PhotoViewerDialog r101 = this.f496874a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r101);
    L23:
        Iterator<d> r103 = this.f496874a.f327634i.iterator();
    L25:
        if (r103.hasNext() == false) goto L27;
        r103.next().onTransitionEnd(r100);
        goto L25
    L27:
        return;
    L18:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r104 == null) goto L22;
        com.bytedance.crash.d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r101);
        throw th;
    L11:
        if (Looper.myLooper() == r102.getLooper()) goto L13;
        r102.post(DialogLancet.createDismissRunnable(r101));
        goto L23
    L5:
        if (r100 != 3) goto L23;
        PhotoViewerDialog r105 = this.f496874a;
        r105.f327636k = r105.f327635j;
        goto L23
    }

    @Override // l19.f
    public final void onTransitionChanged(int r100, float r101) {
        PhotoViewerDialog r102 = this.f496874a;
        if (r100 != 0) goto L5;
        float r103 = r101;
    L15:
        r102.f327635j = r103;
        this.f496874a.f327628c.getBackground().setAlpha((int) (this.f496874a.f327635j * 255));
        Iterator<d> r104 = this.f496874a.f327634i.iterator();
    L17:
        if (r104.hasNext() == false) goto L19;
        r104.next().onTransitionChanged(r100, r101);
        goto L17
    L19:
        return;
    L5:
        if (r100 != 1) goto L7;
        float r105 = r102.f327636k;
        r103 = r105 + ((1 - r105) * r101);
        goto L15
    L7:
        if (r100 == 2) goto L12;
        r103 = 1.0f;
        if (r100 != 3) goto L15;
        r103 = 1 - Math.min(1.0f, Math.max(r101, 0.0f));
        goto L15
    L12:
        r103 = r102.f327636k * (1 - r101);
        goto L15
    }
}
