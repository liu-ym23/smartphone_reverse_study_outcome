package h9;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.util.Iterator;
import java.util.Map;
import kotlin.text.StringsKt;
import y9.p;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f484308a = 0;

    static {
    }

    public static p.a a(String r100) {
        p r101 = AnnieConfigSettingKeys.ANNIE_PREFETCH_RES_MODE.a();
        int r102 = r101.a();
        if (r100 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        Object r104 = null;
        if (r103 == true) goto L23;
        if (r102 == 1) goto L24;
        Map<String, p.a> r105 = r101.b();
        Iterator<T> r106 = r105.keySet().iterator();
    L14:
        if (r106.hasNext() == false) goto L19;
        Object r107 = r106.next();
        if (StringsKt.contains$default(r100, (String) r107, false, 2, null) == false) goto L14;
        r104 = r107;
    L19:
        return r105.get(r104);
    L24:
        return null;
    L23:
        return null;
    L5:
        if (r100.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
