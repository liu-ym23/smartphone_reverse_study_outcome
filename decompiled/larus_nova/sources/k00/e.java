package k00;

import com.bytedance.android.live.broadcast.api.model.k1;
import com.bytedance.android.live.broadcast.api.model.l1;
import com.bytedance.android.live.broadcast.api.model.m1;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.business.IHostShare;
import com.bytedance.android.livehostapi.business.depend.share.LiveFansContactData;
import com.bytedance.android.livehostapi.business.depend.share.LiveFansDataSource;
import com.bytedance.android.livehostapi.business.depend.share.LiveFansDataSourceKt;
import com.bytedance.android.livesdk.share.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jc1.k;

/* JADX INFO: loaded from: classes45.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<String> f501240a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final com.bytedance.android.livesdk.sharedpref.e<String> f501241b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Map<String, Map<String, Object>> f501242c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f501243d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f501244e = null;

    public e() {
    }

    static {
        f501244e = new e();
        f501240a = new com.bytedance.android.livesdk.sharedpref.e("share_fans_list", "");
        f501241b = new com.bytedance.android.livesdk.sharedpref.e("share_fans_list_uid", "");
    }

    public static final void a(e r110, l1 r111) {
        r110.getClass();
        ArrayList r100 = new ArrayList();
        Map<String, Map<String, Object>> r101 = f501242c;
        if (r101 == null) goto L5;
        ((LinkedHashMap) r101).clear();
    L6:
        ArrayList r102 = new ArrayList();
        ArrayList r103 = new ArrayList();
        List<m1> r104 = r111.b();
        long r105 = 0;
        if (r104 == null) goto L32;
        Iterator<T> r106 = r104.iterator();
    L10:
        if (r106.hasNext() == false) goto L32;
        m1 r107 = (m1) r106.next();
        if (r107.f() <= r105) goto L30;
        if (r107.c().length() <= 0) goto L16;
        boolean r108 = true;
    L17:
        if (r108 == false) goto L30;
        LinkedHashMap r109 = new LinkedHashMap();
        r109.put(LiveFansDataSourceKt.MAP_KEY_SCORE, Float.valueOf(r107.d()));
        r109.put(LiveFansDataSourceKt.MAP_KEY_RELATION, Integer.valueOf(r107.b()));
        if (r107.b() != 1) goto L25;
        r109.put(LiveFansDataSourceKt.MAP_KEY_TEXT, r107.a());
        if (r107.e() <= 0) goto L23;
        r109.put(LiveFansDataSourceKt.MAP_KEY_FANS_LABEL, Integer.valueOf(r107.e()));
    L23:
        r102.add(new LiveFansContactData(r109, r107.f(), r107.c(), 0));
    L27:
        Map<String, Map<String, Object>> r112 = f501242c;
        if (r112 == null) goto L30;
        Map<String, Object> r113 = r112.put(String.valueOf(r107.f()), r109);
        goto L30
    L25:
        if (r107.b() != 2) goto L27;
        r103.add(new LiveFansContactData(r109, r107.f(), r107.c(), 0));
        goto L27
    L16:
        r108 = false;
    L30:
        r105 = 0;
    L32:
        if ((!r103.isEmpty()) == false) goto L34;
    L35:
        r100.add(new LiveFansDataSource(1, r103, r102));
    L36:
        List<k1> r114 = r111.a();
        if (r114 == null) goto L53;
        ArrayList r115 = new ArrayList();
        Iterator<T> r116 = r114.iterator();
    L40:
        if (r116.hasNext() == false) goto L51;
        k1 r117 = (k1) r116.next();
        if (r117.a() <= 0) goto L47;
        LinkedHashMap r118 = new LinkedHashMap();
        r118.put(LiveFansDataSourceKt.MAP_KEY_SCORE, Float.valueOf(r117.b()));
        Map<String, Map<String, Object>> r119 = f501242c;
        if (r119 == null) goto L46;
        Map<String, Object> r120 = r119.put(String.valueOf(r117.a()), r118);
    L46:
        LiveFansContactData r121 = new LiveFansContactData(r118, 0, "", r117.a());
    L48:
        if (r121 == null) goto L40;
        r115.add(r121);
        goto L40
    L47:
        r121 = null;
        goto L48
    L51:
        if ((!r115.isEmpty()) == false) goto L53;
        r100.add(new LiveFansDataSource(2, r115, null, 4, null));
    L53:
        com.bytedance.android.livesdk.share.a r122 = ((IMiddlewareRoomService) k.n(IMiddlewareRoomService.class)).share();
        if (r122 == null) goto L69;
        IHostShare r123 = ((h) r122).f158093a;
        if (r123 == null) goto L70;
        r123.addExternalDataSource(r100);
        return;
    L70:
        return;
    L69:
        return;
    L34:
        if ((!r102.isEmpty()) == false) goto L36;
    L5:
        f501242c = new LinkedHashMap();
        goto L6
    }
}
