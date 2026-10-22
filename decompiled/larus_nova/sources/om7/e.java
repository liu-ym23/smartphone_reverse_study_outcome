package om7;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.HashSet;

/* JADX INFO: loaded from: classes22.dex */
public final class e {
    public static String b(String r100) {
        pm7.b r101 = pm7.b.a.f529854a;
        um7.e.b("getUnionValueByLocal() on call; mInit = " + r101.f529853b);
        if (r101.f529853b == true) goto L7;
        return null;
    L7:
        return com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.e.a(r101.f529852a).b(r100);
    }

    public static void a(String r100, nm7.a r101) {
        pm7.b r102 = pm7.b.a.f529854a;
        um7.e.b("getUnionValue() on call; key = " + r100 + "; mInit = " + r102.f529853b);
        if (r102.f529853b == false) goto L22;
        d r103 = d.b.f524309a;
        r103.getClass();
        um7.e.b("getUnionValue() on call; key = " + r100 + "; finishSet: " + d.c(r103.f524303a) + "; runningSet : " + d.c(r103.f524304b));
        if (TextUtils.isEmpty(r100) == true) goto L19;
        if (r101 == null) goto L23;
        String r104 = com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils.e.a(r102.getContext()).b(r100);
        if (TextUtils.isEmpty(r104) == true) goto L12;
    L17:
        r101.a(r100, r104);
        um7.e.b("getUnionValue() value is not null or is Finish return ; value = " + r104);
        return;
    L12:
        if (((HashSet) r103.f524303a).contains(r100) == true) goto L17;
        r103.f524305c.add(new WeakReference(r101));
        if (((HashSet) r103.f524304b).contains(r100) == true) goto L20;
        ((HashSet) r103.f524304b).add(r100);
        rm7.c.a.f538587a.b(new a(r103, r100));
        return;
    L20:
        return;
    L23:
        return;
    L19:
        return;
    }
}
