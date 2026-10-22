package ih7;

import android.content.Context;
import android.net.Uri;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class f implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489885a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f489886b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final f f489887c = null;

    public f() {
    }

    @Override // ih7.a
    public final boolean d(Object[] r100, Map r101) {
        return false;
    }

    @Override // ih7.a
    public final String tag() {
        return "content_client";
    }

    static {
        f489887c = new f();
        f489885a = CollectionsKt.listOf(240016);
        f489886b = CollectionsKt.listOf(new String[]{"media", "call_log", "sms", "mms", "mms-sms", "browser", "com.android.chrome.browser", "com.android.calendar", "com.android.contacts", "com.meizu.flyme.openidsdk", "com.vivo.vms.IdProvider"});
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489885a;
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
        if ((r103 instanceof Uri) == false) goto L18;
        String r104 = ((Uri) r103).getAuthority();
    L21:
        if (r104 != null) goto L23;
    L26:
        boolean r105 = true;
    L27:
        if (r105 == true) goto L29;
        r101.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_authority", r104)}));
    L29:
        return r101;
    L23:
        if (r104.length() == 0) goto L26;
        r105 = false;
        goto L27
    L18:
        if ((r103 instanceof String) == false) goto L20;
        r104 = (String) r103;
        goto L21
    L20:
        r104 = null;
        goto L21
    L5:
        if (r100.length != 0) goto L7;
        boolean r106 = true;
    L8:
        if (r106 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r106 = false;
        goto L8
    }

    @Override // ih7.a
    public final boolean c(Context r100, Map<String, ?> r101) {
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
    L12:
        return true;
    L11:
        if (CollectionsKt.contains(f489886b, r101.get("extra_parameter_authority")) == false) goto L12;
        return false;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
