package k6b;

import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes35.dex */
public final class c {
    static {
    }

    @JvmStatic
    public static final String a(String r100, String r101, Long r102) {
        String r103 = r100 + r101 + UrlPreViewEntries.UrlPreViewSourceType.PERSONAL_SIG.getValue();
        if (r102 != null) goto L5;
        return r103;
    L5:
        if (r102.longValue() > 0) goto L7;
        return r103;
    L7:
        return r103 + '_' + r102;
    }
}
