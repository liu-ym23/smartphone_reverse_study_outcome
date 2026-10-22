package vi2;

import com.bytedance.android.livesdk.livecommerce.room.controller.business.RoomContextController;
import com.bytedance.android.livesdk.livecommerce.utils.EComABUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class t0 {
    public static final List<String> a = null;

    static {
        a = CollectionsKt.listOf(new String[]{si2.g.o, si2.g.p, si2.g.q, si2.g.b, si2.g.e, si2.g.c, si2.g.f, si2.g.d, si2.g.g, si2.g.k, si2.g.h});
    }

    @JvmStatic
    public static final boolean a(String r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r6, "path");
        int r0 = RoomContextController.h;
        com.bytedance.android.ec.adapter.api.state.a r7 = RoomContextController.a.b(r4, r5).L();
        if (r7 == null) goto L5;
        int r8 = r7.v;
    L7:
        if (r8 < 1) goto L19;
        List<String> r9 = EComABUtils.getECNetworkInstantAPICheckList();
        if ((r9 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r10 = r9.iterator();
    L15:
        if (r10.hasNext() == false) goto L39;
        if (StringsKt.endsWith$default(r6, (String) r10.next(), false, 2, null) == false) goto L15;
    L29:
        return true;
    L39:
        return false;
    L11:
        if (r9.isEmpty() == false) goto L13;
        return false;
    L19:
        List<String> r11 = EComABUtils.getECNetworkAPICheckList();
        if ((r11 instanceof Collection) == true) goto L22;
    L24:
        Iterator<T> r12 = r11.iterator();
    L26:
        if (r12.hasNext() == false) goto L40;
        if (StringsKt.endsWith$default(r6, (String) r12.next(), false, 2, null) == false) goto L26;
    L40:
        return false;
    L22:
        if (r11.isEmpty() == false) goto L24;
        return false;
    L5:
        r8 = 0;
        goto L7
    }
}
