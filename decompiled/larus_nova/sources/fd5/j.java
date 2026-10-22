package fd5;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: classes18.dex */
public final class j extends i {
    @Override // fd5.i
    public final void a() {
        Document r100 = this.f476528b;
        int r101 = r100.f227908y1;
        String r102 = r100.f227868a;
        if (m.a() == false) goto L5;
        int r103 = ua5.a.l(r101, r102);
    L6:
        this.f476529c.setImageResource(r103);
        return;
    L5:
        r103 = ua5.a.j(r101, r102);
        goto L6
    }

    public j(Context r100, Document r101, ImageView r102) {
        super(r100, r101, r102);
    }
}
