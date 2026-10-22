package ey4;

import android.view.View;
import com.bytedance.ee.bear.doc.blockeditpanel.view.panel.BaseBlockEditPanel;
import com.bytedance.ee.bear.widgets.t;

/* JADX INFO: loaded from: classes16.dex */
public final class d extends t {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseBlockEditPanel f474800c;

    public d(BaseBlockEditPanel r100) {
        this.f474800c = r100;
    }

    @Override // com.bytedance.ee.bear.widgets.t
    public final void a(View r100) {
        r100.setClickable(false);
        dy4.c r101 = this.f474800c.f217673d;
        if (r101 == null) goto L6;
        r101.sg();
        return;
    }
}
