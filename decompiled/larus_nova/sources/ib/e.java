package ib;

import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import t36.j;

/* JADX INFO: loaded from: classes43.dex */
public final class e {
    public static final String a(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        String r101 = b(r100);
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        boolean r102 = true;
        if (r101.length() != 0) goto L8;
        boolean r103 = true;
    L9:
        if (r103 == false) goto L36;
        String r104 = a36.b.e(r100, "channel");
        String r105 = a36.b.e(r100, "bundle");
        if (r104 != null) goto L13;
    L16:
        boolean r106 = true;
    L17:
        if (r106 == true) goto L28;
        if (r105 != null) goto L20;
    L23:
        boolean r107 = true;
    L24:
        if (r107 == true) goto L28;
        return r104 + '_' + r105;
    L20:
        if (r105.length() == 0) goto L23;
        r107 = false;
    L28:
        if (r101.length() == 0) goto L31;
        r102 = false;
    L31:
        if (r102 == true) goto L33;
        return r101;
    L33:
        return r100.toString();
    L13:
        if (r104.length() == 0) goto L16;
        r106 = false;
        goto L17
    L36:
        return UriProtector.parse(r101).buildUpon().clearQuery().toString();
    L8:
        r103 = false;
        goto L9
    }

    public static final String b(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (Intrinsics.areEqual(r100.getScheme(), "http") == true) goto L13;
        if (Intrinsics.areEqual(r100.getScheme(), "https") == true) goto L13;
        String r101 = a36.b.e(r100, "a_surl");
        if (r101 != null) goto L14;
        String r102 = a36.b.e(r100, "surl");
        if (r102 == null) goto L16;
        return r102;
    L16:
        return a36.b.e(r100, "url");
    L14:
        return r101;
    L13:
        return r100.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean c(j r100) {
        y36.a r101 = null;
        if (r100 == null) goto L5;
        t36.f r102 = r100.f544446d;
    L7:
        if ((r102 instanceof v36.e) == false) goto L9;
        v36.e r103 = (v36.e) r102;
    L10:
        if (r103 == null) goto L19;
        y36.a r104 = r103.f552937s;
        if (r104 == null) goto L14;
        r101 = r104;
    L15:
        if (r101 == null) goto L19;
        Boolean r105 = (Boolean) r101.f565862b;
        if (r105 == null) goto L19;
        return r105.booleanValue();
    L14:
        Intrinsics.throwUninitializedPropertyAccessException("compactMode");
    L19:
        return true;
    L9:
        r103 = null;
        goto L10
    L5:
        r102 = null;
        goto L7
    }
}
