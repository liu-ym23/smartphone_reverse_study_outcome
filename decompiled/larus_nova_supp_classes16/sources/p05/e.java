package p05;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.customheader.OfficeCustomHeaderFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ OfficeCustomHeaderFragment a;

    public e(OfficeCustomHeaderFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r5) {
        Integer r6 = (Integer) r5;
        if (r6 == null) goto L19;
        View r0 = this.a.getView();
        LinearLayout.LayoutParams r1 = null;
        if (r0 == null) goto L7;
        View r2 = r0.findViewById(2131387284);
    L8:
        if (r2 == null) goto L10;
        ViewGroup.LayoutParams r3 = r2.getLayoutParams();
    L12:
        if ((r3 instanceof LinearLayout.LayoutParams) == false) goto L14;
        r1 = (LinearLayout.LayoutParams) r3;
    L14:
        if (r1 == null) goto L16;
        r1.height = r6.intValue();
    L16:
        if (r2 == null) goto L20;
        r2.setLayoutParams(r1);
        return;
    L20:
        return;
    L10:
        r3 = null;
        goto L12
    L7:
        r2 = null;
        goto L8
    }
}
