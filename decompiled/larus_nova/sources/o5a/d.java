package o5a;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.EditText;
import java.util.HashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class d extends EditText {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f522131a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f522132b;

    public interface a {
        void a();
    }

    public interface b {
    }

    public d(Context r100) {
        super(r100);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r100) {
        super.onDraw(r100);
        a r101 = this.f522132b;
        if (r101 == null) goto L6;
        r101.a();
        return;
    }

    public void setOnAfterDrawListener(a r100) {
        this.f522132b = r100;
    }

    public void setOnSelectionChangeListener(b r100) {
        this.f522131a = r100;
    }

    @Override // android.widget.TextView
    public final void onSelectionChanged(int r100, int r101) {
        super.onSelectionChanged(r100, r101);
        b r102 = this.f522131a;
        if (r102 == null) goto L8;
        o5a.a.e r103 = (o5a.a.e) r102;
        if (r103.f522125a.c("selectionchange") == false) goto L9;
        HashMap r104 = new HashMap();
        r104.put("start", Integer.valueOf(r100));
        r104.put("end", Integer.valueOf(r101));
        r104.put("direction", "forward");
        r103.f522125a.q("selectionchange", r104);
        return;
    L9:
        return;
    }
}
