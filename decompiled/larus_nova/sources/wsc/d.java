package wsc;

import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes41.dex */
public final class d implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f561130a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
    }

    public d(TextView r100) {
        this.f561130a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        e.b(this.f561130a);
        r100.removeOnAttachStateChangeListener(this);
        r100.setTag(R.id.markwon_drawables_scheduler, null);
    }
}
