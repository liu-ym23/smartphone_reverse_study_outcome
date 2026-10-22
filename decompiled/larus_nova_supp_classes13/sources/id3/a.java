package id3;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.shopping.anchorv4.event_chain.AbsCommonChainEventImpl;
import com.bytedance.android.shopping.anchorv4.event_chain.b;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import fi3.j;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends AbsCommonChainEventImpl<j> {
    public final Function2<Integer, String, Unit> e;

    public final b<j> c(Map<String, ? extends Object> r4) {
        int r0 = j.c;
        j r1 = null;
        String r2 = null;
        if (r4 == null) goto L18;
        Object r3 = r4.get("index");
        if ((r3 instanceof Integer) == true) goto L8;
        r3 = null;
    L8:
        Integer r5 = (Integer) r3;
        if (r5 == null) goto L11;
        int r6 = r5.intValue();
    L12:
        Object r7 = r4.get("spec_id");
        if (r7 == null) goto L15;
        r2 = r7.toString();
    L15:
        if (r2 != null) goto L17;
        r2 = "";
    L17:
        r1 = new j(r6, r2);
        goto L18
    L11:
        r6 = -1;
    L18:
        if (r1 == null) goto L20;
        int r8 = b.d;
        return b.a.b(r1);
    L20:
        int r9 = b.d;
        return b.a.a("index and spec_id are not correct");
    }

    public a(com.bytedance.android.ecom.arch.slice.action.j r3, FragmentActivity r4, Function2 r5) {
        Intrinsics.checkNotNullParameter("PdpGallerySelectItem", "name");
        Intrinsics.checkNotNullParameter(r3, "pdpCommonEventService");
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "updateSKUSpecCallback");
        super("PdpGallerySelectItem", r3, r4);
        this.e = r5;
    }

    public final void e(EventContext r7, Object r8, Function1 r9) {
        j r10 = (j) r8;
        Intrinsics.checkNotNullParameter(r7, "eventContext");
        Intrinsics.checkNotNullParameter(r9, "completion");
        if (r10 == null) goto L5;
        this.e.invoke(Integer.valueOf(r10.a), r10.b);
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r9.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L5:
        int r12 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r9.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "parse param failed", null, null, 57));
    }
}
