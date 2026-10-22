package db5;

import android.text.TextUtils;
import io.reactivex.functions.Function;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes16.dex */
public final class e implements Function<String, String> {
    public e() {
    }

    @Override // io.reactivex.functions.Function
    public final /* bridge */ /* synthetic */ String apply(String r100) throws Exception {
        return c(r100);
    }

    public final String c(String r100) throws Exception {
        StringBuilder r101 = new StringBuilder();
        tt5.a.b("CommentRemoveBlankLine", "apply before=" + r100);
        if (TextUtils.isEmpty(r100) == true) goto L21;
        Pattern r102 = yu5.c.f569228a;
        String[] r103 = r100.split("\n");
        int r104 = r103.length - 1;
        int r105 = 0;
    L5:
        if (r105 > r104) goto L10;
        if (TextUtils.isEmpty(r103[r105].trim()) == false) goto L10;
        r105 = r105 + 1;
    L10:
        if (r104 <= r105) goto L15;
        if (TextUtils.isEmpty(r103[r104].trim()) == false) goto L15;
        r104 = r104 - 1;
    L15:
        int r106 = r105;
    L16:
        if (r106 > r104) goto L21;
        if (r106 <= r105) goto L19;
        r101.append("\n");
    L19:
        r101.append(r103[r106]);
        r106 = r106 + 1;
    L21:
        return r101.toString();
    }
}
