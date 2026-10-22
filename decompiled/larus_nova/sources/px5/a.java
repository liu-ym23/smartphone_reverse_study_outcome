package px5;

import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Matcher;

/* JADX INFO: loaded from: classes19.dex */
public final class a {
    public static String a(String r100, String r101) {
        Matcher r102 = PatternProtector.compile(".*(((" + r101 + "=[^;]*)|(" + r101 + "=\"[\";]*))|(" + r101 + "=.*$)).*").matcher(r100);     // Catch: IllegalArgumentException -> L7
        if (r102.matches() == false) goto L10;
        return r102.group(1);
    L10:
        return null;
    L11:
        return null;
    }
}
