package ih;

import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.ec.core.apt.ActionType;
import com.bytedance.android.ec.core.monitor.attribution.UserActionCacheMap;
import com.bytedance.android.ec.core.utils.BtmUtilsKt;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import lg.d;
import lg.i;
import lg.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements i {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f489759b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicBoolean f489760c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final C6264a f489761d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, b> f489762a;

    /* JADX INFO: renamed from: ih.a$a, reason: collision with other inner class name */
    public static final class C6264a {
        public C6264a() {
        }
    }

    static {
        f489761d = new C6264a();
        f489759b = new a();
        f489760c = new AtomicBoolean(false);
    }

    public static JSONObject b() {
        return BtmUtilsKt.f(BtmSDK.getBcmChainByToken$default(BtmSDK.INSTANCE, null, 0, false, 6, null));
    }

    public a() {
        this.f489762a = new LinkedHashMap();
    }

    @Override // lg.i
    public final void a(lg.a r100) {
        Intrinsics.checkNotNullParameter(r100, "actionNode");
        if ((r100 instanceof d) == false) goto L31;
        Map<String, b> r101 = this.f489762a;
        d r102 = (d) r100;
        String r103 = r102.a();
        String r104 = "";
        if (r103 != null) goto L7;
        r103 = "";
    L7:
        LinkedHashMap r105 = (LinkedHashMap) r101;
        Object r106 = r105.get(r103);
        if (r106 != null) goto L13;
        String r107 = r102.a();
        if (r107 != null) goto L12;
        r107 = "";
    L12:
        r106 = new b("ec_action_tracker_plugin__".concat(r107));
        r105.put(r103, r106);
    L13:
        b r108 = (b) r106;
        List<String> r109 = r108.f489763a;
        String r110 = r102.b();
        if (r110 != null) goto L16;
        r110 = "";
    L16:
        ((ArrayList) r109).add(r110);
        if (((ArrayList) r108.f489763a).size() <= 1000) goto L20;
        ListProtector.remove(r108.f489763a, 0);
    L20:
        if ((r100 instanceof j) == false) goto L26;
        UserActionCacheMap<String> r111 = r108.f489765c;
        String r112 = r102.b();
        if (r112 == null) goto L25;
        r104 = r112;
    L25:
        r111.put(r104, r100);
        return;
    L26:
        UserActionCacheMap<ActionType> r113 = r108.f489764b;
        ActionType r114 = r102.getType();
        if (r114 != null) goto L29;
        r114 = ActionType.Empty;
    L29:
        r113.put(r114, r100);
        return;
    }
}
