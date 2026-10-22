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

/* JADX INFO: loaded from: classes10.dex */
public final class t0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<String> f555262a = null;

    static {
        f555262a = CollectionsKt.listOf(new String[]{si2.g.f542165o, si2.g.f542166p, si2.g.f542167q, si2.g.f542151b, si2.g.f542155e, si2.g.f542153c, si2.g.f542156f, si2.g.f542154d, si2.g.f542157g, si2.g.f542161k, si2.g.f542158h});
    }

    @JvmStatic
    public static final boolean a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "path");
        int r103 = RoomContextController.f151593h;
        com.bytedance.android.ec.adapter.api.state.a r104 = RoomContextController.a.b(r100, r101).L();
        if (r104 == null) goto L5;
        int r105 = r104.f42707v;
    L7:
        if (r105 < 1) goto L19;
        List<String> r106 = EComABUtils.getECNetworkInstantAPICheckList();
        if ((r106 instanceof Collection) == true) goto L11;
    L13:
        Iterator<T> r107 = r106.iterator();
    L15:
        if (r107.hasNext() == false) goto L39;
        if (StringsKt.endsWith$default(r102, (String) r107.next(), false, 2, null) == false) goto L15;
    L29:
        return true;
    L39:
        return false;
    L11:
        if (r106.isEmpty() == false) goto L13;
        return false;
    L19:
        List<String> r108 = EComABUtils.getECNetworkAPICheckList();
        if ((r108 instanceof Collection) == true) goto L22;
    L24:
        Iterator<T> r109 = r108.iterator();
    L26:
        if (r109.hasNext() == false) goto L40;
        if (StringsKt.endsWith$default(r102, (String) r109.next(), false, 2, null) == false) goto L26;
    L40:
        return false;
    L22:
        if (r108.isEmpty() == false) goto L24;
        return false;
    L5:
        r105 = 0;
        goto L7
    }
}
