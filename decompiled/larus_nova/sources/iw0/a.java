package iw0;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import com.bytedance.android.live.revenue.common.v;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.live.revenue.core.util.j;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import java.util.HashMap;
import java.util.Map;
import yz0.k;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f496137a = null;

    public a() {
    }

    static {
        f496137a = new a();
    }

    public static void b(Map r100) {
        k r101 = (k) f.d(j.C0.a(), k.class);
        String r102 = null;
        if (r101 == null) goto L5;
        IRoom r103 = r101.getRoom();
    L6:
        if (r103 == null) goto L8;
        Long r104 = Long.valueOf(r103.getId());
    L9:
        HashMap r105 = (HashMap) r100;
        r105.put("room_id", String.valueOf(r104));
        if (r103 == null) goto L14;
        IBaseUser r106 = r103.getOwner();
        if (r106 == null) goto L14;
        r102 = r106.getIdString();
    L14:
        r105.put("anchor_id", String.valueOf(r102));
        return;
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }

    public final void a(Throwable r100) {
        HashMap r101 = new HashMap();
        b(r101);
        if (r100 != null) goto L5;
    L7:
        LiveSlardarMonitor.monitorStatus("ttlive_income_exchange_error", 11, r101);
        int r102 = v.f91009a;
        v.d("ttlive_exchange", r101);
        return;
    L5:
        if ((r100 instanceof ApiException) == false) goto L7;
        r101.put("error_code", String.valueOf(((ApiException) r100).getErrorCode()));
        r101.put("error_message", String.valueOf(r100.getMessage()));
        goto L7
    }
}
