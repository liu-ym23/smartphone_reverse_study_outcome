package nt1;

import android.view.MotionEvent;
import android.view.View;
import com.bytedance.android.livesdk.dislike.layout.IMContactLayoutV2;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ IMContactLayoutV2 f520463a;

    public a(IMContactLayoutV2 r100) {
        this.f520463a = r100;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        int r102 = r101.getAction();
        if (r102 == 0) goto L9;
        if (r102 != 1) goto L6;
    L8:
        IMContactLayoutV2.a(this.f520463a, false, r100);
    L10:
        return false;
    L6:
        if (r102 == 3) goto L8;
    L9:
        IMContactLayoutV2.a(this.f520463a, true, r100);
        goto L10
    }
}
