package s45;

import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b {
    public Pattern a;
    public final String[] b;

    public b(String[] r5) {
        this.b = r5;
        if (r5 != null) goto L5;
    L18:
        tt5.a.h("BlackList", "mBlackPathList is null or empty");
        return;
    L5:
        if (r5.length == 0) goto L18;
        StringBuilder r6 = new StringBuilder();
        int r1 = 0;
    L8:
        String[] r2 = this.b;
        if (r1 >= r2.length) goto L15;
        if (r1 != 0) goto L12;
        r6.append(r2[r1]);
    L13:
        r1 = r1 + 1;
        goto L8
    L12:
        r6.append("|");
        r6.append(this.b[r1]);
        goto L13
    L15:
        if (TextUtils.isEmpty(r6.toString()) == true) goto L17;
        this.a = PatternProtector.compile(r6.toString());
    L17:
        tt5.a.h("BlackList", "init()...patternStr = " + r6);
    }
}
