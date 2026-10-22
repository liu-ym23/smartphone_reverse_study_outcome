package bd5;

import android.content.Context;
import android.util.SparseArray;
import android.widget.FrameLayout;
import android.widget.ImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b {
    public final Context a;
    public final SparseArray<a> b;

    public final a b() {
        a r0 = this.b.get(1);
        if (r0 != null) goto L6;
        a r1 = new a();
        FrameLayout r2 = a(2131253557);
        r2.setId(2131378152);
        r1.a = r2;
        this.b.put(1, r1);
        return r1;
    L6:
        return r0;
    }

    public final a c() {
        a r0 = this.b.get(2);
        if (r0 != null) goto L6;
        a r1 = new a();
        r1.a = a(2131255147);
        this.b.put(2, r1);
        return r1;
    L6:
        return r0;
    }

    public final a d() {
        a r0 = this.b.get(0);
        if (r0 != null) goto L6;
        a r1 = new a();
        r1.a = a(2131255617);
        this.b.put(0, r1);
        return r1;
    L6:
        return r0;
    }

    public b(Context r2) {
        this.b = new SparseArray();
        this.a = r2;
    }

    public final FrameLayout a(int r4) {
        FrameLayout r0 = new FrameLayout(this.a);
        ImageView r1 = new ImageView(this.a);
        r1.setId(2131378105);
        r1.setImageDrawable(this.a.getResources().getDrawable(r4));
        r0.addView(r1, -2, -2);
        return r0;
    }
}
