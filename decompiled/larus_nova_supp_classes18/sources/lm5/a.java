package lm5;

import android.view.View;
import com.bytedance.ee.bear.share.newshare.a0;
import com.bytedance.ee.bear.share.newshare.b0;
import com.bytedance.ee.bear.share.newshare.e0;
import com.bytedance.ee.bear.share.newshare.f0;
import com.bytedance.ee.bear.share.newshare.g0;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import mm5.b;
import mm5.e;
import mm5.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements f0 {
    public a() {
    }

    @Override // com.bytedance.ee.bear.share.newshare.f0
    public final b buildHeader() {
        return new b();
    }

    @Override // com.bytedance.ee.bear.share.newshare.f0
    public final e0 a(b0 r9, a0 r10, List<? extends com.bytedance.ee.bear.share.newshare.a> r11, List<? extends g0> r12, View.OnClickListener r13, View r14) {
        Intrinsics.checkNotNullParameter(r9, ResourceData.KEY_TYPE);
        Intrinsics.checkNotNullParameter(r10, "style");
        if (r12 == null) goto L11;
        Iterator<? extends g0> r15 = r12.iterator();
    L6:
        if (r15.hasNext() == false) goto L11;
        if (r15.next().isVisible() == true) goto L6;
        return null;
    L11:
        if ((r10 instanceof a0.a) == false) goto L14;
        a0.a r16 = (a0.a) r10;
        return new e(r9.a, r16.a, r16.c, r16.d, r16.e);
    L14:
        if (r11 == null) goto L21;
        Iterator<? extends com.bytedance.ee.bear.share.newshare.a> r17 = r11.iterator();
    L17:
        if (r17.hasNext() == false) goto L21;
        com.bytedance.ee.bear.share.newshare.a r18 = r17.next();
        if (r18.isEnable() == true) goto L17;
        r18.a();
        String r7 = r18.b();
        boolean r4 = false;
    L23:
        if (r14 != null) goto L25;
        return null;
    L25:
        return new f(r9.a, r14, r4, null, r13, r7);
    L21:
        r7 = "";
        r4 = true;
        goto L23
    }
}
