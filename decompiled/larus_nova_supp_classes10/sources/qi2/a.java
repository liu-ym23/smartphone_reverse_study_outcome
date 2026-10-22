package qi2;

import com.bytedance.android.livesdk.livecommerce.room.j;
import sg2.e0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public abstract class a implements e0 {
    public a() {
    }

    public abstract boolean b(ee.b r1);

    public abstract void c(j r1);

    @Override // sg2.e0
    public final <T> boolean a(e0.a<T> r3) throws Exception {
        T r0 = r3.getMessage();
        if ((r0 instanceof ee.b) == false) goto L5;
        boolean r1 = b((ee.b) r0);
    L6:
        if (r1 == false) goto L9;
        return true;
    L9:
        return r3.a(r3.getMessage());
    L5:
        r1 = false;
        goto L6
    }
}
