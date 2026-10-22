package zy4;

import android.view.View;
import com.bytedance.ee.bear.edit.component.toolbar2.HorizontalOverScrollView;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class l implements HorizontalOverScrollView.a {
    public final /* synthetic */ int a;
    public final /* synthetic */ com.bytedance.ee.bear.document.onboarding.c b;
    public final /* synthetic */ View c;
    public final /* synthetic */ HorizontalOverScrollView d;
    public final /* synthetic */ m e;

    @Override // com.bytedance.ee.bear.edit.component.toolbar2.HorizontalOverScrollView.a
    public final void a(int r3) {
        if (this.a != r3) goto L6;
        m r4 = this.e;
        com.bytedance.ee.bear.document.onboarding.c r0 = this.b;
        View r1 = this.c;
        r4.getClass();
        m.d(r0, r1);
        ((ArrayList) this.d.a).remove(this);
        return;
    }

    public l(m r1, int r2, com.bytedance.ee.bear.document.onboarding.c r3, View r4, HorizontalOverScrollView r5) {
        this.e = r1;
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
