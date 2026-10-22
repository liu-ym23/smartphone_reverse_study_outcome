package com.bytedance.locallife.biz.pendant.datacenter;

import android.net.Uri;
import bo6.e;
import bo6.f;
import bo6.g;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class PendantViewModel {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Lazy<e> f256781i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f256782a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f256783b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<String> f256784c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<String> f256785d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<g> f256786e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, g> f256787f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<g> f256788g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f256789h;

    public static final class a {
        public static boolean a() {
            Lazy<e> r100 = PendantViewModel.f256781i;
            if (r100.getValue() == null) goto L11;
            e r101 = r100.getValue();
            if (r101 == null) goto L7;
            boolean r102 = Intrinsics.areEqual(r101.b(), Boolean.TRUE);
        L8:
            if (r102 == false) goto L12;
            return true;
        L12:
            return false;
        L7:
            r102 = false;
            goto L8
        L11:
            return false;
        }
    }

    public final void a() {
        this.f256782a = null;
        ((ArrayList) this.f256783b).clear();
        ((ArrayList) this.f256784c).clear();
        ((ArrayList) this.f256785d).clear();
        ((ArrayList) this.f256786e).clear();
        ((LinkedHashMap) this.f256787f).clear();
        this.f256788g = null;
    }

    static {
        f256781i = LazyKt.lazy(PendantViewModel$Companion$lifePendantAllowedPages$2.INSTANCE);
    }

    public PendantViewModel(com.bytedance.locallife.biz.pendant.c.a r100) {
        this.f256782a = r100;
        this.f256783b = new ArrayList();
        this.f256784c = new ArrayList();
        this.f256785d = new ArrayList();
        this.f256786e = new ArrayList();
        this.f256787f = new LinkedHashMap();
    }

    public final boolean b(Uri r110) {
        List<g> r100 = this.f256788g;
        if (r100 != null) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == false) goto L11;
        return false;
    L11:
        List<g> r102 = this.f256788g;
        if (r102 == null) goto L59;
        Iterator<T> r103 = r102.iterator();
    L15:
        if (r103.hasNext() == false) goto L59;
        g r104 = (g) r103.next();
        if (r104.d() != 4) goto L15;
        String r105 = "";
        if (r110 == null) goto L22;
        String r106 = r110.getHost();
        if (r106 == null) goto L22;
    L23:
        if (r110 == null) goto L28;
        String r107 = r110.getPath();
        if (r107 == null) goto L28;
        String r108 = StringsKt.removeSuffix(r107, HTTP.URL_DEFAULT);
        if (r108 == null) goto L28;
    L30:
        if (Intrinsics.areEqual(r104.c(), r106) == true) goto L33;
        if (Intrinsics.areEqual(r104.c(), r106.concat(r108)) == false) goto L15;
    L33:
        if (r110 == null) goto L36;
        String r109 = r110.toString();
        if (r109 == null) goto L36;
    L37:
        String r111 = Uri.decode(r109);
        String r112 = r104.b();
        if (r112 != null) goto L41;
        r112 = "";
    L41:
        if (StringsKt.contains$default(r109, r112, false, 2, null) == false) goto L47;
        String r113 = r104.a();
        if (r113 != null) goto L46;
        r113 = "";
    L46:
        if (StringsKt.contains$default(r109, r113, false, 2, null) == false) goto L47;
    L58:
        return true;
    L47:
        String r114 = r104.b();
        if (r114 != null) goto L51;
        r114 = "";
    L51:
        if (StringsKt.contains$default(r111, r114, false, 2, null) == false) goto L15;
        String r115 = r104.a();
        if (r115 == null) goto L57;
        r105 = r115;
    L57:
        if (StringsKt.contains$default(r111, r105, false, 2, null) == false) goto L15;
    L36:
        r109 = "";
    L28:
        r108 = "";
    L22:
        r106 = "";
    L59:
        return false;
    L5:
        if (r100.isEmpty() == true) goto L8;
        r101 = false;
        goto L9
    }
}
