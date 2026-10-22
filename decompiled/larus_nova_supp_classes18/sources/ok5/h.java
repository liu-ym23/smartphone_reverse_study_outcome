package ok5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class h implements gk5.c {
    public h() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r2, JSONObject r3, p r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r4, "callback");
        ArrayList r5 = a.b(r3);     // Catch: Throwable -> L12
    L9:
        th = move-exception;
        nk5.b.c(r4, th);
        return;
    L5:
        if (is4.a.b() == false) goto L7;
        is4.c.c(r5);     // Catch: Throwable -> L9
    L7:
        com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().b.e(r5);     // Catch: Throwable -> L9
        r4.onSuccess(new JSONObject());     // Catch: Throwable -> L9
        return;
    L12:
        th = move-exception;
        String r6 = th.getMessage();
        if (r6 != null) goto L16;
        r6 = "invalid attachmentIDs";
    L16:
        nk5.b.d(r4, r6);
    }
}
