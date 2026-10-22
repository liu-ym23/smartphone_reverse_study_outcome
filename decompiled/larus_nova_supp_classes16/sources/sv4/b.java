package sv4;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import com.bytedance.ee.bear.bizwidget.diagram.OfficeDiagramWebView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ OfficeDiagramWebView a;

    public b(OfficeDiagramWebView r1) {
        this.a = r1;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onSingleTapUp(MotionEvent r2) {
        OfficeDiagramWebView r3 = this.a;
        View.OnClickListener r0 = r3.a;
        if (r0 == null) goto L7;
        r0.onClick(r3);
        return false;
    L7:
        return false;
    }
}
