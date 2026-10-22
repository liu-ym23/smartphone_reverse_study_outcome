package hp;

import android.view.View;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.android.ec.window.base.search.history.ECWindowHistoryChip;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes44.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ECWindowHistoryChip f486353a;

    public c(ECWindowHistoryChip r100) {
        this.f486353a = r100;
    }

    public final void a() {
        LinearLayout.LayoutParams r100 = new LinearLayout.LayoutParams(-2, -2);
        r100.gravity = 17;
        ECWindowHistoryChip r101 = this.f486353a;
        r101.addView(r101.f49529a, r100);
        ViewParent r102 = this.f486353a.getParent();
        Object r103 = null;
        if (r102 == null) goto L5;
        ViewParent r104 = r102.getParent();
    L7:
        if ((r104 instanceof View) == false) goto L10;
        r103 = r104;
    L10:
        View r105 = (View) r103;
        if (r105 == null) goto L16;
        TextView r106 = this.f486353a.f49529a;
        if (r106 == null) goto L17;
        r106.setMaxWidth(r105.getWidth() - (ECWindowHistoryChip.f49524d * 2));
        return;
    L17:
        return;
    L16:
        return;
    L5:
        r104 = null;
        goto L7
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
