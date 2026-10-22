package sx1;

import android.view.MotionEvent;
import android.view.View;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class b implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f543794a;

    public b(c r100) {
        this.f543794a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 != 0) goto L5;
        c r103 = this.f543794a;
        r103.f543797c.setTextColor(r103.getContext().getResources().getColor(R.color.ttlive_I_know_color_click));
        return false;
    L5:
        if (r102 != 1) goto L7;
    L9:
        c r104 = this.f543794a;
        r104.f543797c.setTextColor(r104.getContext().getResources().getColor(R.color.ttlive_I_know_color));
        return false;
    L7:
        if (r102 == 3) goto L9;
        return false;
    }
}
