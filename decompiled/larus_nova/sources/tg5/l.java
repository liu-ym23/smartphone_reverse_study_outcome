package tg5;

import android.content.DialogInterface;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class l implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f545880a = null;

    static {
        f545880a = new l();
    }

    public l() {
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r110, int r111) {
        String r112 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        JSONObject r113 = new JSONObject();
        String r100 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
        int r101 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L5;
        String r102 = ThumbGlideUrl.SOURCE_VC;
    L6:
        com.bytedance.ee.bear.middleground.permission.c.a(r113, r100, r101, r102, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        r113.put("click", "cancel");
        r113.put(PickerReporterConstants.KEY.TARGET, "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_organization_authorize_send_notice_click", r113);
        return;
    L5:
        r102 = "none";
        goto L6
    }
}
