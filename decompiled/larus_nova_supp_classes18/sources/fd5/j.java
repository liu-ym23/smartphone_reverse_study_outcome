package fd5;

import android.content.Context;
import android.widget.ImageView;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j extends i {
    @Override // fd5.i
    public final void a() {
        Document r0 = this.b;
        int r1 = r0.y1;
        String r2 = r0.a;
        if (m.a() == false) goto L5;
        int r3 = ua5.a.l(r1, r2);
    L6:
        this.c.setImageResource(r3);
        return;
    L5:
        r3 = ua5.a.j(r1, r2);
        goto L6
    }

    public j(Context r1, Document r2, ImageView r3) {
        super(r1, r2, r3);
    }
}
