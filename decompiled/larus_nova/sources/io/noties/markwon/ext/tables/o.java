package io.noties.markwon.ext.tables;

import android.view.View;
import android.widget.TextView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes41.dex */
public final class o implements View.OnAttachStateChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TextView f492542a;

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View r100) {
    }

    public o(TextView r100) {
        this.f492542a = r100;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View r100) {
        a[] r101 = q.a(this.f492542a);
        if (r101 != null) goto L5;
    L9:
        this.f492542a.removeOnAttachStateChangeListener(this);
        this.f492542a.setTag(R.id.markwon_tables_scheduler, null);
        return;
    L5:
        if (r101.length <= 0) goto L9;
        int r102 = r101.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L9;
        r101[r103].f492506a = null;
        r103 = r103 + 1;
        goto L7
    }
}
