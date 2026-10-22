package ux6;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.crash.d;
import com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements com.bytedance.locallife.photo.internal.photodraweeview.transition.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f552002a;

    public b(c r100) {
        this.f552002a = r100;
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.transition.a
    public final void onTransitionBegin(int r100) {
        Iterator<IIndicatorView> r101 = this.f552002a.f552009f.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().onTransitionBegin(r100);
        goto L4
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.transition.a
    public final void onTransitionEnd(int r100) {
        if (r100 != 1) goto L5;
        c r101 = this.f552002a;
        float r102 = r101.f552011h;
        r101.getClass();
    L25:
        Iterator<IIndicatorView> r103 = this.f552002a.f552009f.iterator();
    L27:
        if (r103.hasNext() == false) goto L29;
        r103.next().onTransitionEnd(r100);
        goto L27
    L29:
        return;
    L5:
        if (r100 != 3) goto L25;
        c r104 = this.f552002a;
        Handler r105 = DialogLancet.resolveDialogHandler(r104);
        if (r105 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r104);
        r104.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r104);
        goto L25
    L17:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r106 == null) goto L21;
        d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r104);
        throw th;
    L10:
        if (Looper.myLooper() == r105.getLooper()) goto L12;
        r105.post(DialogLancet.createDismissRunnable(r104));
        goto L25
    }

    @Override // com.bytedance.locallife.photo.internal.photodraweeview.transition.a
    public final void onTransitionChanged(int r100, float r101) {
        c r102 = this.f552002a;
        r102.f552011h = 1.0f - RangesKt.coerceAtLeast(r101, 0.0f);
        Drawable r103 = this.f552002a.f552006c.getBackground();
        if (r103 == null) goto L6;
        r103.setAlpha(RangesKt.coerceIn((int) (this.f552002a.f552011h * 255.0f), 0, 255));
    L6:
        Iterator<IIndicatorView> r104 = this.f552002a.f552009f.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        r104.next().onTransitionChanged(1, r101);
        goto L8
    }
}
