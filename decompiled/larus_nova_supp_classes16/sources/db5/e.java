package db5;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.DocViewModel;
import io.reactivex.functions.Function;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class e implements Function<String, String> {
    public e() {
    }

    public final /* bridge */ /* synthetic */ Object apply(Object r1) throws Exception {
        return c((String) r1);
    }

    public final String c(String r7) throws Exception {
        StringBuilder r0 = new StringBuilder();
        tt5.a.b("CommentRemoveBlankLine", "apply before=" + r7);
        if (TextUtils.isEmpty(r7) == true) goto L21;
        Pattern r1 = yu5.c.a;
        String[] r8 = r7.split(DocViewModel.ENTER_CHAR);
        int r2 = r8.length - 1;
        int r3 = 0;
    L5:
        if (r3 > r2) goto L10;
        if (TextUtils.isEmpty(r8[r3].trim()) == false) goto L10;
        r3 = r3 + 1;
    L10:
        if (r2 <= r3) goto L15;
        if (TextUtils.isEmpty(r8[r2].trim()) == false) goto L15;
        r2 = r2 - 1;
    L15:
        int r4 = r3;
    L16:
        if (r4 > r2) goto L21;
        if (r4 <= r3) goto L19;
        r0.append(DocViewModel.ENTER_CHAR);
    L19:
        r0.append(r8[r4]);
        r4 = r4 + 1;
    L21:
        return r0.toString();
    }
}
