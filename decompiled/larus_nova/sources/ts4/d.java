package ts4;

import android.view.View;
import android.view.ViewTreeObserver;
import java.util.Map;

/* JADX INFO: loaded from: classes15.dex */
public final class d implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f547393a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f547394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map<Integer, View> f547395c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f547393a.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        a r100 = this.f547394b;
        if (r100.f547379e != null) goto L5;
        return;
    L5:
        r100.f547382h.getParent().requestLayout();
        this.f547394b.a(this.f547395c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public d(View r100, a r101, Map<Integer, ? extends View> r102) {
        this.f547393a = r100;
        this.f547394b = r101;
        this.f547395c = r102;
    }
}
