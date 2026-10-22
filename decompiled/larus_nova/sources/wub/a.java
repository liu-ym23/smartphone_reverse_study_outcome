package wub;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.h;
import java.util.LinkedHashMap;
import kotlin.text.CharsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LinkedHashMap<Long, h> f561485a = null;

    static {
        f561485a = new LinkedHashMap();
    }

    public static String a(String r100) {
        if (r100.length() != 0) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L9;
        return "";
    L9:
        StringBuilder r102 = new StringBuilder(r100.length());
        int r103 = 0;
    L11:
        if (r103 >= r100.length()) goto L21;
        char r104 = r100.charAt(r103);
        if (CharsKt.isWhitespace(r104) == true) goto L19;
        switch(r104) {
            case 33: goto L16;
            case 34: goto L16;
            case 39: goto L16;
            case 40: goto L16;
            case 41: goto L16;
            case 44: goto L16;
            case 46: goto L16;
            case 58: goto L16;
            case 59: goto L16;
            case 63: goto L16;
            case 91: goto L16;
            case 93: goto L16;
            case 8216: goto L16;
            case 8217: goto L16;
            case 8220: goto L16;
            case 8221: goto L16;
            case 12289: goto L16;
            case 12290: goto L16;
            case 12304: goto L16;
            case 12305: goto L16;
            case 65281: goto L16;
            case 65288: goto L16;
            case 65289: goto L16;
            case 65292: goto L16;
            case 65306: goto L16;
            case 65307: goto L16;
            case 65311: goto L16;
            default: goto L15;
        };
    L15:
        boolean r105 = false;
    L17:
        if (r105 == true) goto L19;
        r102.append(r104);
        goto L19
    L16:
        r105 = true;
    L19:
        r103 = r103 + 1;
        goto L11
    L21:
        return r102.toString();
    L5:
        r101 = false;
        goto L6
    }
}
