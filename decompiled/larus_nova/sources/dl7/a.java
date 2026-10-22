package dl7;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.ug.sdk.luckydog.api.task.pendant.CounterPendantState;
import com.bytedance.ug.sdk.luckydog.api.task.pendant.PendantStyle;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d f469131a;

    public abstract void a(CounterPendantState r100, int r101);

    public abstract PendantStyle getPendantStyle();

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        d r100 = this.f469131a;
        if (r100 == null) goto L6;
        r100.onAttach();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d r100 = this.f469131a;
        if (r100 == null) goto L6;
        r100.a(this);
        return;
    }

    public a(Context r100) {
        super(r100);
    }
}
