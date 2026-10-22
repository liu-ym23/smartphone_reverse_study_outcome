package f83;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.shopping.anchorv3.detail.viewholder.header.TabClickType;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewType;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4HeadIndicator;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i implements m {
    public final /* synthetic */ AnchorV4HeadIndicator a;

    public i(AnchorV4HeadIndicator r1) {
        this.a = r1;
    }

    @Override // f83.m
    public final void a(int r2) {
        p r0 = this.a.getTabLogicInterceptor();
        if (r0 == null) goto L6;
        r0.c(r2);
        return;
    }

    @Override // f83.m
    public final void b(int r8, boolean r9, boolean r10, String r11, boolean r12, String r13) {
        HashMap<Integer, String> r0 = com.bytedance.android.shopping.anchorv4.voavhs.head.c.J;
        if (r11 == null) goto L7;
        Integer r1 = StringsKt.toIntOrNull(r11);
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L8:
        String r3 = r0.get(Integer.valueOf(r2));
        if (r3 != null) goto L11;
        r3 = "";
    L11:
        String r14 = a2.d(r13);
        if (r14 != null) goto L14;
        r14 = r3;
    L14:
        if (r12 == true) goto L57;
        p r15 = this.a.getTabLogicInterceptor();
        if (r15 == null) goto L58;
        Function0<com.bytedance.android.shopping.anchorv4.voavhs.head.base.g> r16 = r15.e;
        if (r16 == null) goto L59;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.g r17 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.g) r16.invoke();
        if (r17 != null) goto L22;
        return;
    L22:
        if (r17.a() == true) goto L61;
        if (r10 == false) goto L25;
        String r18 = TabClickType.TYPE_EXPAND.getType();
    L29:
        if ((!Intrinsics.areEqual(this.a.e, r11)) == false) goto L50;
        c63.d r19 = this.a.getLogAction();
        if (r19 == null) goto L50;
        e83.a.d.getClass();
        Iterator r4 = e83.a.a().iterator();
    L33:
        Integer r5 = null;
        if (r4.hasNext() == false) goto L43;
        Object r6 = r4.next();
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r7 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r6;
        if (Intrinsics.areEqual(r3, com.bytedance.android.shopping.anchorv4.voavhs.head.c.J.get(5)) == true) goto L38;
    L40:
        boolean r20 = false;
    L41:
        if (r20 == false) goto L33;
    L44:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r21 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r6;
        if (r21 == null) goto L49;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r110 = r21.i;
        if (r110 == null) goto L49;
        r5 = r110.h();
    L49:
        r19.k(r18, r14, r5, Integer.valueOf(r8));
        goto L50
    L38:
        if (Intrinsics.areEqual(r7.getType(), HeadViewType.GOOD_COMMENT.getType()) == false) goto L40;
        r20 = true;
        goto L41
    L43:
        r6 = null;
    L50:
        this.a.e = r11;
        return;
    L25:
        if (r9 == false) goto L27;
        r18 = TabClickType.TYPE_CLICK.getType();
        goto L29
    L27:
        r18 = TabClickType.TYPE_DRAW.getType();
        goto L29
    L61:
        return;
    L59:
        return;
    L58:
        return;
    L57:
        return;
    L7:
        r2 = -1;
        goto L8
    }
}
