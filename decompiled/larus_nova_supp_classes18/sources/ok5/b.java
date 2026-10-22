package ok5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements gk5.c {

    public static final class a {
    }

    static {
    }

    public b() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r5, JSONObject r6, p r7) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        Intrinsics.checkNotNullParameter(r6, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r7, "callback");
        ArrayList r8 = ok5.a.b(r6);     // Catch: Throwable -> L13
        JSONArray r9 = new JSONArray();     // Catch: Throwable -> L10
        Iterator r10 = ((ArrayList) com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().b.a(r8)).iterator();     // Catch: Throwable -> L10
    L6:
        if (r10.hasNext() == false) goto L8;
        CommonAttachmentPanel.AttachmentCheckedInfo r0 = (CommonAttachmentPanel.AttachmentCheckedInfo) r10.next();     // Catch: Throwable -> L10
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L10
        r1.put("attachmentID", r0.getAttachmentID());     // Catch: Throwable -> L10
        r1.put("valid", r0.getValid());     // Catch: Throwable -> L10
        r9.put(r1);     // Catch: Throwable -> L10
        goto L6
    L8:
        r7.onSuccess(new JSONObject().put("checkedInfo", r9));     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        nk5.b.c(r7, th);
        return;
    L13:
        th = move-exception;
        String r11 = th.getMessage();
        if (r11 != null) goto L17;
        r11 = "invalid attachmentIDs";
    L17:
        nk5.b.d(r7, r11);
    }
}
