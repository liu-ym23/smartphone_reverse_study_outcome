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
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final List<Integer> f489879a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f489880b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final d f489881c = null;

    public d() {
    }

    @Override // ih7.a
    public final boolean d(Object[] r100, Map r101) {
        return false;
    }

    @Override // ih7.a
    public final String tag() {
        return "content_authority";
    }

    static {
        f489881c = new d();
        f489879a = CollectionsKt.listOf(new Integer[]{240004, 240017, 240018, 240019});
        f489880b = CollectionsKt.listOf(new String[]{"media", "call_log", "sms", "mms", "mms-sms", "browser", "com.android.chrome.browser", "com.android.calendar", "com.android.contacts", "com.meizu.flyme.openidsdk", "com.vivo.vms.IdProvider"});
    }

    @Override // ih7.a
    public final List<Integer> a() {
        return f489879a;
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
        if ((r103 instanceof Uri) == false) goto L17;
        r101.add(MapsKt.hashMapOf(new Pair[]{TuplesKt.to("extra_parameter_authority", ((Uri) r103).getAuthority())}));
    L17:
        return r101;
    L5:
        if (r100.length != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r102 = false;
        goto L12
    L7:
        r104 = false;
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
        if (CollectionsKt.contains(f489880b, r101.get("extra_parameter_authority")) == false) goto L12;
        return false;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }
}
