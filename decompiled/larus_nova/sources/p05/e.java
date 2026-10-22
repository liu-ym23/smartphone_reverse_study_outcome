package p05;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.document.customheader.OfficeCustomHeaderFragment;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public final class e<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeCustomHeaderFragment f527292a;

    public e(OfficeCustomHeaderFragment r100) {
        this.f527292a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        if (r101 == null) goto L19;
        View r102 = this.f527292a.getView();
        LinearLayout.LayoutParams r103 = null;
        if (r102 == null) goto L7;
        View r104 = r102.findViewById(R.id.status_bar_diff_height_view);
    L8:
        if (r104 == null) goto L10;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
    L12:
        if ((r105 instanceof LinearLayout.LayoutParams) == false) goto L14;
        r103 = (LinearLayout.LayoutParams) r105;
    L14:
        if (r103 == null) goto L16;
        r103.height = r101.intValue();
    L16:
        if (r104 == null) goto L20;
        r104.setLayoutParams(r103);
        return;
    L20:
        return;
    L10:
        r105 = null;
        goto L12
    L7:
        r104 = null;
        goto L8
    }
}
