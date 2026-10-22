package dl7;

import android.content.Context;
import android.widget.FrameLayout;
import com.bytedance.ug.sdk.luckydog.api.task.pendant.PendantState;

/* JADX INFO: loaded from: classes22.dex */
public abstract class b extends FrameLayout {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f469132b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f469133a;

    public abstract void a(PendantState r100, int r101);

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        c r100 = this.f469133a;
        if (r100 == null) goto L6;
        r100.onAttach();
        return;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        c r100 = this.f469133a;
        if (r100 == null) goto L6;
        r100.a(this);
        return;
    }

    public b(Context r100) {
        super(r100);
    }
}
