package sh;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.ec.core.photodraweeview.commentpagespecialuse.CommentPagePhotoViewerDialog;
import com.bytedance.android.ui.ec.widget.photodraweeview.IIndicatorView;
import com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener;
import com.bytedance.crash.d;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements TransitionListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CommentPagePhotoViewerDialog f541896a;

    public a(CommentPagePhotoViewerDialog r100) {
        this.f541896a = r100;
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionBegin(int r100) {
        Iterator<T> r101 = this.f541896a.f45295j.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((IIndicatorView) r101.next()).onTransitionBegin(r100);
        goto L4
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionEnd(int r100) {
        if (r100 != 2) goto L5;
        CommentPagePhotoViewerDialog r101 = this.f541896a;
        Handler r102 = DialogLancet.resolveDialogHandler(r101);
        if (r102 != null) goto L11;
    L13:
        DialogLancet.beforeDialogDismiss(r101);
        r101.dismiss();     // Catch: Throwable -> L16 Exception -> L18
    L22:
        DialogLancet.afterDialogDismiss(r101);
    L23:
        Iterator<T> r103 = this.f541896a.f45295j.iterator();
    L25:
        if (r103.hasNext() == false) goto L27;
        ((IIndicatorView) r103.next()).onTransitionEnd(r100);
        goto L25
    L27:
        return;
    L18:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L16
        Throwable r104 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L16
        if (r104 == null) goto L22;
        d.d(r104, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L16
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
        CommentPagePhotoViewerDialog r105 = this.f541896a;
        r105.f45297l = r105.f45296k;
        goto L23
    }

    @Override // com.bytedance.android.ui.ec.widget.photodraweeview.transition.TransitionListener
    public final void onTransitionChanged(int r100, float r101) {
        CommentPagePhotoViewerDialog r102 = this.f541896a;
        if (r100 != 0) goto L5;
        float r103 = r101;
    L15:
        r102.f45296k = r103;
        CommentPagePhotoViewerDialog r104 = this.f541896a;
        if (r104.f45296k <= 1.0f) goto L19;
        r104.f45296k = 1.0f;
    L19:
        if (r104.f45296k >= 0.0f) goto L21;
        r104.f45296k = 0.0f;
    L21:
        r104.f45287b.getBackground().setAlpha((int) (this.f541896a.f45296k * 255));
        Iterator<T> r105 = this.f541896a.f45295j.iterator();
    L23:
        if (r105.hasNext() == false) goto L25;
        ((IIndicatorView) r105.next()).onTransitionChanged(r100, r101);
        goto L23
    L25:
        return;
    L5:
        if (r100 != 1) goto L7;
        float r106 = r102.f45297l;
        r103 = ((1 - r106) * r101) + r106;
        goto L15
    L7:
        if (r100 != 2) goto L9;
        r103 = (1 - r101) * r102.f45297l;
        goto L15
    L9:
        if (r100 == 3) goto L11;
        r103 = 1.0f;
        goto L15
    L11:
        r103 = 1 - Math.max(r101, 0.0f);
        goto L15
    }
}
