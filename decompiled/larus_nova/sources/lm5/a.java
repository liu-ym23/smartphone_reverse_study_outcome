package lm5;

import android.view.View;
import com.bytedance.ee.bear.share.newshare.a0;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.f0;
import com.bytedance.ee.bear.share.newshare.g0;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mm5.b;
import mm5.e;
import mm5.f;

/* JADX INFO: loaded from: classes18.dex */
public final class a implements f0 {
    public a() {
    }

    @Override // com.bytedance.ee.bear.share.newshare.f0
    public final b buildHeader() {
        return new b();
    }

    @Override // com.bytedance.ee.bear.share.newshare.f0
    public final e0 a(b0 r100, a0 r110, List<? extends com.bytedance.ee.bear.share.newshare.a> r111, List<? extends g0> r112, View.OnClickListener r113, View r114) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r110, "style");
        if (r112 == null) goto L11;
        Iterator<? extends g0> r115 = r112.iterator();
    L6:
        if (r115.hasNext() == false) goto L11;
        if (r115.next().isVisible() == true) goto L6;
        return null;
    L11:
        if ((r110 instanceof a0.a) == false) goto L14;
        a0.a r116 = (a0.a) r110;
        return new e(r100.f237188a, r116.f237182a, r116.f237184c, r116.f237185d, r116.f237186e);
    L14:
        if (r111 == null) goto L21;
        Iterator<? extends com.bytedance.ee.bear.share.newshare.a> r117 = r111.iterator();
    L17:
        if (r117.hasNext() == false) goto L21;
        com.bytedance.ee.bear.share.newshare.a r118 = r117.next();
        if (r118.isEnable() == true) goto L17;
        r118.a();
        String r101 = r118.b();
        boolean r102 = false;
    L23:
        if (r114 != null) goto L25;
        return null;
    L25:
        return new f(r100.f237188a, r114, r102, null, r113, r101);
    L21:
        r101 = "";
        r102 = true;
        goto L23
    }
}
