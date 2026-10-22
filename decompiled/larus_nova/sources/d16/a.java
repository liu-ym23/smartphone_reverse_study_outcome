package d16;

import android.view.View;
import com.bytedance.ies.bullet.container.popup.ui.draggable.BottomSheetBehavior;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f466385a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f466386b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BottomSheetBehavior f466387c;

    @Override // java.lang.Runnable
    public final void run() {
        this.f466387c.settleToState(this.f466385a, this.f466386b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(BottomSheetBehavior r100, View r101, int r102) {
        this.f466387c = r100;
        this.f466385a = r101;
        this.f466386b = r102;
    }
}
