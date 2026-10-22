package ok5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements gk5.c {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r4, JSONObject r5, p r6) {
        Intrinsics.checkNotNullParameter(r4, "activity");
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r6, "callback");
        CommonAttachmentPanel.PreviewAttachmentRequest r0 = new CommonAttachmentPanel.PreviewAttachmentRequest(ok5.a.b(r5), JSONObjectProtectorUtils.getInt(r5, "index"));     // Catch: Throwable -> L9
        com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().b.k(r4, r0, true);     // Catch: Throwable -> L6
        r6.onSuccess(new JSONObject());     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        nk5.b.c(r6, th);
        return;
    L9:
        th = move-exception;
        String r7 = th.getMessage();
        if (r7 != null) goto L13;
        r7 = "invalid previewAttachment parameters";
    L13:
        nk5.b.d(r6, r7);
    }
}
