package ok5;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel;
import com.bytedance.ee.bear.sheet.exportimage.exportshare.ExportShareModel;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import na8.p;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c implements gk5.c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public c() {
    }

    @Override // gk5.c
    public final void a(FragmentActivity r11, JSONObject r12, p r13) {
        Intrinsics.checkNotNullParameter(r11, "activity");
        Intrinsics.checkNotNullParameter(r12, WikiFolderPushPlugin.DATA);
        Intrinsics.checkNotNullParameter(r13, "callback");
    L27:
        th = move-exception;
        String r14 = th.getMessage();
        if (r14 != null) goto L31;
        r14 = "invalid chooseAttachment parameters";
    L31:
        nk5.b.d(r13, r14);
        return;
    L4:
        if (r12.has("mode") == true) goto L6;
    L8:
        String r1 = "defalut";
    L9:
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L27
        if (r12.has("count") == true) goto L12;
    L14:
        int r0 = 9;
    L15:
        Integer r2 = Integer.valueOf(r0);     // Catch: Throwable -> L27
        String[] r3 = ok5.a.a(r12, "mediaType");     // Catch: Throwable -> L27
        if (r3 != null) goto L18;
        r3 = new String[]{ExportShareModel.EXPORT_SHARE_TYPE_IMAGE, "video"};     // Catch: Throwable -> L27
    L18:
        String[] r15 = ok5.a.a(r12, "acceptFileTypes");     // Catch: Throwable -> L27
        if (r15 != null) goto L21;
        r15 = new String[0];     // Catch: Throwable -> L27
    L21:
        CommonAttachmentPanel.ChooseAttachmentRequest r5 = new CommonAttachmentPanel.ChooseAttachmentRequest(r1, r2, r3, r15);     // Catch: Throwable -> L27
        com.bytedance.ee.bear.bitable.core.usercomponent.compat.a.a().b.b(r11, r5, new e(r13), new f(r11, r13), new g(), new d(r13, this));     // Catch: Throwable -> L24
        return;
    L24:
        th = move-exception;
        nk5.b.c(r13, th);
        return;
    L12:
        if (r12.isNull("count") == true) goto L14;
        r0 = JSONObjectProtectorUtils.getInt(r12, "count");     // Catch: Throwable -> L27
        goto L15
    L6:
        if (r12.isNull("mode") == true) goto L8;
        r1 = JSONObjectProtectorUtils.getString(r12, "mode");     // Catch: Throwable -> L27
        goto L9
    }
}
