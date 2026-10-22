package ea5;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Comparator<String> {
    public b() {
    }

    public static String a(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.isEmpty() == true) goto L12;
        String r101 = r100.get("480p");
        if (TextUtils.isEmpty(r101) == true) goto L9;
        return r101;
    L9:
        return r100.values().iterator().next();
    L12:
        return "";
    }

    @Override // java.util.Comparator
    public final int compare(String r100, String r101) {
        String r102 = r101;
        int r103 = CastIntegerProtector.parseInt(r100.toLowerCase().replace("p", ""));     // Catch: Exception -> L5
        return CastIntegerProtector.parseInt(r102.toLowerCase().replace("p", "")) - r103;
    L5:
        e = move-exception;
        tt5.a.f("DriveComponent", e, false);
        return 0;
    }
}
