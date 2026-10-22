package ea5;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b implements Comparator<String> {
    public b() {
    }

    public static String a(Map<String, String> r2) {
        if (r2 != null) goto L4;
        return "";
    L4:
        if (r2.isEmpty() == true) goto L12;
        String r0 = r2.get("480p");
        if (TextUtils.isEmpty(r0) == true) goto L9;
        return r0;
    L9:
        return r2.values().iterator().next();
    L12:
        return "";
    }

    @Override // java.util.Comparator
    public final int compare(String r3, String r4) {
        String r5 = r4;
        int r6 = CastIntegerProtector.parseInt(r3.toLowerCase().replace("p", ""));     // Catch: Exception -> L5
        return CastIntegerProtector.parseInt(r5.toLowerCase().replace("p", "")) - r6;
    L5:
        e = move-exception;
        tt5.a.f("DriveComponent", e, false);
        return 0;
    }
}
