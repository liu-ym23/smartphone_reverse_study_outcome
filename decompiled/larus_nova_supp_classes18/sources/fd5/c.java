package fd5;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;
import com.bytedance.ee.bear.list.dto.Document;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c extends i {
    public final boolean d;

    @Override // fd5.i
    public final void a() {
        int r0 = this.b.getType();
        if (m.a() == false) goto L5;
        int r1 = rbb.b.c(r0, null);
    L6:
        int r4 = r1;
        if (this.d == false) goto L13;
        Document.DocumentIcon r2 = this.b.k1;
        if (r2.b == (-1)) goto L13;
        if (TextUtils.isEmpty(r2.a) == true) goto L13;
        uz4.a r3 = (uz4.a) org.koin.java.a.a(uz4.a.class);
        Document.DocumentIcon r5 = this.b.k1;
        r3.d(r5.a, r5.c, r4, this.c, this.d);
        return;
    L13:
        this.c.setImageResource(r4);
        return;
    L5:
        r1 = ua5.a.i(r0);
        goto L6
    }

    public c(Context r1, Document r2, ImageView r3, boolean r4) {
        super(r1, r2, r3);
        this.d = r4;
    }
}
