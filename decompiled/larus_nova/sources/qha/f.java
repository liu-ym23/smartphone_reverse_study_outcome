package qha;

import com.larus.bmhome.actionbar.model.z0;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class f {
    public static final String a(z0 r100) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Map<String, String> r101 = r100.H;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.get("KEY_FILE_OR_WEB_ADDRESS");
    }
}
