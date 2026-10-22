package f83;

import com.bytedance.android.shopping.anchorv3.detail.viewholder.header.TabClickType;
import com.bytedance.android.shopping.anchorv4.voavhs.head.base.HeadViewType;
import com.bytedance.android.shopping.anchorv4.voavhs.head.indicator.AnchorV4DownTabIndicator;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements m {
    public final /* synthetic */ AnchorV4DownTabIndicator a;

    public a(AnchorV4DownTabIndicator r1) {
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
    public final void b(int r6, boolean r7, boolean r8, String r9, boolean r10, String r11) {
        HashMap<Integer, String> r12 = com.bytedance.android.shopping.anchorv4.voavhs.head.c.J;
        if (r9 != null) goto L5;
        Object r13 = -1;
    L6:
        String r14 = r12.get(r13);
        if (r14 != null) goto L9;
        r14 = "";
    L9:
        if (r10 == true) goto L52;
        p r15 = this.a.getTabLogicInterceptor();
        if (r15 == null) goto L53;
        Function0<com.bytedance.android.shopping.anchorv4.voavhs.head.base.g> r16 = r15.e;
        if (r16 == null) goto L54;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.g r17 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.g) r16.invoke();
        if (r17 != null) goto L17;
        return;
    L17:
        if (r17.a() == true) goto L56;
        if (r8 == false) goto L20;
        String r18 = TabClickType.TYPE_EXPAND.getType();
    L24:
        if ((!Intrinsics.areEqual(this.a.d, r9)) == false) goto L45;
        c63.d r19 = this.a.getLogAction();
        if (r19 == null) goto L45;
        e83.a.d.getClass();
        Iterator r110 = e83.a.a().iterator();
    L28:
        Integer r1 = null;
        if (r110.hasNext() == false) goto L38;
        Object r0 = r110.next();
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r2 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r0;
        if (Intrinsics.areEqual(r14, com.bytedance.android.shopping.anchorv4.voavhs.head.c.J.get(5)) == true) goto L33;
    L35:
        boolean r3 = false;
    L36:
        if (r3 == false) goto L28;
    L39:
        com.bytedance.android.shopping.anchorv4.voavhs.head.c r4 = (com.bytedance.android.shopping.anchorv4.voavhs.head.c) r0;
        if (r4 == null) goto L44;
        com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.b r111 = r4.i;
        if (r111 == null) goto L44;
        r1 = r111.h();
    L44:
        c63.d.a.a(r19, r18, r14, r1, 8);
        goto L45
    L33:
        if (Intrinsics.areEqual(r2.getType(), HeadViewType.GOOD_COMMENT.getType()) == false) goto L35;
        r3 = true;
        goto L36
    L38:
        r0 = null;
    L45:
        this.a.d = r9;
        return;
    L20:
        if (r7 == false) goto L22;
        r18 = TabClickType.TYPE_CLICK.getType();
        goto L24
    L22:
        r18 = TabClickType.TYPE_DRAW.getType();
        goto L24
    L56:
        return;
    L54:
        return;
    L53:
        return;
    L52:
        return;
    L5:
        r13 = r9;
        goto L6
    }
}
