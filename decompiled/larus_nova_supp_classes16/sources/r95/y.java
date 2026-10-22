package r95;

import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class y implements com.bytedance.ee.bear.bizwidget.magicshare.cursor.a {
    public final /* synthetic */ d a;

    @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.a
    public final View o0() {
        return (View) this.a;
    }

    @Override // com.bytedance.ee.bear.bizwidget.magicshare.cursor.a
    public final RectF p0() {
        return this.a.getDisplayRect();
    }

    public y(d r1) {
        this.a = r1;
    }
}
