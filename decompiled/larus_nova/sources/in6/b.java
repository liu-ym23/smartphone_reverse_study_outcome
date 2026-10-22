package in6;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.ss.android.ugc.aweme.etkit.TrackModel;
import hn6.e;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes21.dex */
public final class b implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, fn6.d> f490611a;

    public b() {
        fn6.c r100 = fn6.b.f477930a;
        if (r100 == null) goto L6;
        Map<String, fn6.d> r101 = r100.g();
        if (r101 == null) goto L6;
    L7:
        this.f490611a = r101;
        return;
    L6:
        r101 = new LinkedHashMap();
        goto L7
    }

    @Override // hn6.e
    public final boolean a(TrackModel r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        if (this.f490611a.containsKey(r100.f450807a) == true) goto L5;
        return true;
    L5:
        fn6.d r101 = this.f490611a.get(r100.f450807a);
        List<String> r102 = null;
        if (r101 == null) goto L8;
        String r103 = r101.a();
    L10:
        if (r103 != null) goto L12;
    L15:
        boolean r104 = true;
    L16:
        if (r104 == false) goto L28;
        if (r101 == null) goto L19;
        r102 = r101.b();
    L19:
        List<String> r105 = r102;
        if (r105 != null) goto L22;
    L25:
        boolean r106 = true;
    L26:
        if (r106 == false) goto L28;
        return true;
    L22:
        if (r105.isEmpty() == true) goto L25;
        r106 = false;
    L28:
        Object r107 = r100.f450808b.b();
        if (r101 == null) goto L48;
        Map<String, Object> r108 = r101.f477931a;
        if (r108 == null) goto L48;
        if ((r107 instanceof JSONObject) == false) goto L42;
        Iterator<Map.Entry<String, Object>> r109 = r108.entrySet().iterator();
    L37:
        if (r109.hasNext() == false) goto L57;
        Map.Entry<String, Object> r110 = r109.next();
        if (Intrinsics.areEqual(((JSONObject) r107).opt(r110.getKey()), r110.getValue()) == true) goto L37;
    L57:
        return true;
    L42:
        if ((r107 instanceof Map) == false) goto L56;
        Iterator<Map.Entry<String, Object>> r111 = r108.entrySet().iterator();
    L45:
        if (r111.hasNext() == false) goto L58;
        Map.Entry<String, Object> r112 = r111.next();
        if (Intrinsics.areEqual(((Map) r107).get(r112.getKey()), r112.getValue()) == true) goto L45;
    L58:
        return true;
    L56:
        return true;
    L48:
        return false;
    L12:
        if (r103.length() == 0) goto L15;
        r104 = false;
        goto L16
    L8:
        r103 = null;
        goto L10
    }
}
