package n89;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.router.c;
import com.larus.e_commerce.api.IECommerceService;
import java.util.Iterator;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements q97.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f518332a;

    public b() {
        this.f518332a = LazyKt.lazy(new a());
    }

    @Override // q97.a
    public final boolean b(c r100) {
        StringBuilder r101 = new StringBuilder();
        if (r100 == null) goto L7;
        Uri r102 = r100.f267530d;
        if (r102 == null) goto L7;
        String r103 = r102.getHost();
    L8:
        r101.append(r103);
        if (r100 == null) goto L13;
        Uri r104 = r100.f267530d;
        if (r104 == null) goto L13;
        String r105 = r104.getPath();
    L14:
        r101.append(r105);
        if (TextUtils.equals(r101.toString(), "search/photo") == true) goto L30;
        StringBuilder r106 = new StringBuilder();
        if (r100 == null) goto L21;
        Uri r107 = r100.f267530d;
        if (r107 == null) goto L21;
        String r108 = r107.getHost();
    L22:
        r106.append(r108);
        if (r100 == null) goto L27;
        Uri r109 = r100.f267530d;
        if (r109 == null) goto L27;
        String r110 = r109.getPath();
    L28:
        r106.append(r110);
        if (StringsKt.contains$default(r106.toString(), "search/photo", false, 2, null) == true) goto L30;
        return false;
    L27:
        r110 = null;
    L21:
        r108 = null;
    L30:
        return true;
    L13:
        r105 = null;
    L7:
        r103 = null;
        goto L8
    }

    @Override // q97.a
    public final boolean a(Context r100, c r101) {
        Intent r102 = null;
        if (r101 == null) goto L26;
        Uri r103 = r101.f267530d;
        if (r103 == null) goto L26;
        Intent r104 = r101.f267528b;
        if (r104 == null) goto L9;
        Bundle r105 = r104.getExtras();
    L10:
        Intent r106 = r101.f267528b;
        if (r106 == null) goto L15;
        Bundle r107 = r106.getExtras();
        if (r107 == null) goto L15;
        Set<String> r108 = r107.keySet();
    L16:
        if (r105 == null) goto L26;
        if (r108 == null) goto L26;
        Uri.Builder r109 = r103.buildUpon();
        Iterator<T> r110 = r108.iterator();
    L20:
        if (r110.hasNext() == false) goto L25;
        String r111 = (String) r110.next();
        Object r112 = r105.get(r111);
        if (r112 != null) goto L24;
        r112 = "";
    L24:
        r109.appendQueryParameter(r111, String.valueOf(r112));
        goto L20
    L25:
        r109.build();
    L15:
        r108 = null;
        goto L16
    L9:
        r105 = null;
    L26:
        if (r101 == null) goto L28;
        r102 = r101.f267528b;
    L28:
        IECommerceService r113 = (IECommerceService) this.f518332a.getValue();
        if (r113 == null) goto L36;
        r113.v(r100, r102);
        return true;
    L36:
        return true;
    }
}
