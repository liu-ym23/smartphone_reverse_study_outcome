package qi2;

import com.bytedance.android.livesdk.livecommerce.room.j;
import sg2.e0;

/* JADX INFO: loaded from: classes10.dex */
public abstract class a implements e0 {
    public a() {
    }

    public abstract boolean b(ee.b r100);

    public abstract void c(j r100);

    @Override // sg2.e0
    public final <T> boolean a(e0.a<T> r100) throws Exception {
        T r101 = r100.getMessage();
        if ((r101 instanceof ee.b) == false) goto L5;
        boolean r102 = b((ee.b) r101);
    L6:
        if (r102 == false) goto L9;
        return true;
    L9:
        return r100.a(r100.getMessage());
    L5:
        r102 = false;
        goto L6
    }
}
