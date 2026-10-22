package ih7;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.text.TextUtils;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489877a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f489878b = null;

    public c() {
    }

    @Override // ih7.a
    public final String tag() {
        return "bind_service";
    }

    static {
        f489878b = new c();
        f489877a = CollectionsKt.listOf(101401);
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489877a;
    }

    @Override // ih7.a
    public final Set<Map<String, ?>> b(Object[] r100) {
        LinkedHashSet r101 = new LinkedHashSet();
        if (r100 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return r101;
    L14:
        Object r103 = r100[0];
        if ((r103 instanceof Intent) == true) goto L17;
        return r101;
    L17:
        Intent r104 = (Intent) r103;
        String r105 = r104.getPackage();
        if (r105 != null) goto L25;
        ComponentName r106 = r104.getComponent();
        if (r106 == null) goto L23;
        r105 = r106.getPackageName();
        goto L25
    L23:
        r105 = null;
    L25:
        if (TextUtils.isEmpty(r105) == false) goto L27;
        return r101;
    L27:
        Pair[] r107 = new Pair[3];
        r107[0] = TuplesKt.to("extra_parameter_package_name", r105);
        ComponentName r108 = r104.getComponent();
        String r109 = "";
        if (r108 == null) goto L32;
        String r110 = r108.getClassName();
        if (r110 == null) goto L32;
    L33:
        r107[1] = TuplesKt.to("extra_parameter_class_name", r110);
        String r111 = r104.getAction();
        if (r111 == null) goto L36;
        r109 = r111;
    L36:
        r107[2] = TuplesKt.to("extra_parameter_action", r109);
        r101.add(MapsKt.hashMapOf(r107));
        return r101;
    L32:
        r110 = "";
        goto L33
    L5:
        if (r100.length != 0) goto L7;
        boolean r112 = true;
    L8:
        if (r112 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r112 = false;
        goto L8
    }

    @Override // ih7.a
    public final boolean c(Context r100, Map<String, ?> r101) {
        Object r102 = null;
        if (r101 == null) goto L5;
        Object r103 = r101.get("extra_parameter_package_name");
    L7:
        if ((r103 instanceof String) == false) goto L10;
        r102 = r103;
    L10:
        String r104 = (String) r102;
        if (r104 != null) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L19;
    L20:
        return true;
    L19:
        if (Intrinsics.areEqual(r104, r100.getPackageName()) == true) goto L20;
        return false;
    L13:
        if (r104.length() == 0) goto L16;
        r105 = false;
        goto L17
    L5:
        r103 = null;
        goto L7
    }

    @Override // ih7.a
    public final boolean d(Object[] r100, Map r101) {
        if (r100 != null) goto L5;
    L11:
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
        return true;
    L14:
        LinkedHashMap r103 = (LinkedHashMap) r101;
        Object r104 = r103.get("extra_parameter_package_name");
        Object r105 = r103.get("extra_parameter_class_name");
        if ((r104 instanceof String) == true) goto L17;
    L35:
        return true;
    L17:
        if ((r105 instanceof String) == false) goto L35;
        int r106 = r100.length;
        int r107 = 0;
    L20:
        Object r108 = null;
        if (r107 >= r106) goto L26;
        Object r109 = r100[r107];
        if ((r109 instanceof ServiceConnection) == true) goto L28;
        r107 = r107 + 1;
    L28:
        if ((r109 instanceof ServiceConnection) == false) goto L31;
        r108 = r109;
    L31:
        ServiceConnection r110 = (ServiceConnection) r108;
        if (r110 == null) goto L34;
        r110.onServiceDisconnected(new ComponentName((String) r104, (String) r105));
    L34:
        return false;
    L26:
        r109 = null;
        goto L28
    L5:
        if (r100.length != 0) goto L7;
        boolean r111 = true;
    L8:
        if (r111 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r111 = false;
        goto L8
    }
}
