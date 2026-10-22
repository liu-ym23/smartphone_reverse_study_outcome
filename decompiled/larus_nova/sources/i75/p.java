package i75;

import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes16.dex */
public final class p {
    public static int a(String r100) {
        Matcher r101 = PatternProtector.compile("code = [0-9]+").matcher(r100);     // Catch: Exception -> L7
        if (r101.find() == false) goto L13;
        return CastIntegerProtector.parseInt(r101.group(0).substring(7));
    L13:
        return -1;
    L7:
        e = move-exception;
        tt5.a.f("ServerErrorExceptionUtil", e, false);
        return -1;
    }
}
