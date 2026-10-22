package ok5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.formpreload.FormExeEvn;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.WeakHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class j implements gk5.c {

    public static final class a {
    }

    static {
    }

    public j() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r5, JSONObject r6, p r7) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r7, "callback");
        String r8 = r6.optString("attachmentID");
        String r1 = null;
        if ((!StringsKt.isBlank(r8)) == true) goto L6;
        r8 = null;
    L6:
        String r0 = r6.optString("shareToken");
        if ((!StringsKt.isBlank(r0)) == true) goto L10;
        r0 = null;
    L10:
        if (r8 == null) goto L33;
        if (r0 == null) goto L33;
        if (r6.has("mountPoint") == true) goto L16;
    L37:
        k r9 = new k(r7);     // Catch: Throwable -> L30
        if (is4.a.b() == false) goto L28;
        WeakHashMap r2 = is4.c.a;     // Catch: Throwable -> L30
        is4.c.a(r8, r0, FormExeEvn.Web, is4.a.a(r1), r9);     // Catch: Throwable -> L30
        return;
    L28:
        com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().b.n(r8, r0, is4.a.a(r1), r9);     // Catch: Throwable -> L30
        return;
    L30:
        th = move-exception;
        nk5.b.c(r7, th);
        return;
    L16:
        if (r6.isNull("mountPoint") == true) goto L37;
        r1 = JSONObjectProtectorUtils.getString(r6, "mountPoint");     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        String r10 = th.getMessage();
        if (r10 != null) goto L23;
        r10 = "invalid mountPoint";
    L23:
        nk5.b.d(r7, r10);
        return;
    L33:
        nk5.b.d(r7, "attachmentID and shareToken must not be empty");
    }
}
