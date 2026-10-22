package ke1;

import com.bytedance.android.live.core.utils.v;
import kotlin.ExceptionsKt;

/* JADX INFO: loaded from: classes7.dex */
public final class b {
    public static final String a(Throwable r100) {
        if (r100 == null) goto L12;
        String r101 = ExceptionsKt.stackTraceToString(r100);
        if (r101 == null) goto L12;
        if (v.a() == false) goto L9;
    L11:
        if (r101 == null) goto L12;
        return r101;
    L9:
        if (r101.length() <= 1024) goto L11;
        r101 = r101.substring(0, 1024);
    L12:
        return "";
    }
}
