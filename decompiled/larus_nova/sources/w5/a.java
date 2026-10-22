package w5;

import android.view.View;
import com.bytedance.ai.view.popup.anim.BottomSheetBehavior;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f558287a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f558288b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f558289c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f558290d;

    @Override // java.lang.Runnable
    public final void run() {
        this.f558290d.c(this.f558287a, this.f558288b, this.f558289c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(BottomSheetBehavior r100, View r101, int r102, boolean r103) {
        this.f558290d = r100;
        this.f558287a = r101;
        this.f558288b = r102;
        this.f558289c = r103;
    }
}
