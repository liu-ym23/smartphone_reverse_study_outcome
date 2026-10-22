package tc0;

import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.livesdk.link.model.bridge.g2;
import com.bytedance.android.livesdk.link.model.bridge.k;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f545372a = 0;

    static {
    }

    public static Map.Entry a(String r100, Map r101) {
        if (r101 == null) goto L23;
        Set r102 = r101.entrySet();
        if (r102 == null) goto L23;
        Iterator r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L23;
        Map.Entry r104 = (Map.Entry) r103.next();
        g2 r105 = (g2) r104.getValue();
        if (r105 == null) goto L8;
        List<k> r106 = r105.getLinkedUsers();
        if (r106 == null) goto L8;
        Iterator<T> r107 = r106.iterator();
    L15:
        if (r107.hasNext() == false) goto L19;
        Object r108 = r107.next();
        if (Intrinsics.areEqual(((k) r108).getInteractId(), r100) == false) goto L15;
    L21:
        if (((k) r108) == null) goto L8;
        return r104;
    L19:
        r108 = null;
    L23:
        return null;
    }

    public static void b(ILinkPlayerInfoBridge r100, Map r101) {
        Intrinsics.checkNotNullParameter(r100, "linkPlayerInfo");
        Map.Entry r102 = a(r100.getInteractId(), r101);
        if (r102 == null) goto L6;
        r100.setLinkRoomUser(true);
        r100.setLinkRoomId(((Number) r102.getKey()).longValue());
        r100.setRoomLinkSilenceStatus(((g2) r102.getValue()).getRoomLinkSilenceStatus());
        return;
    }
}
