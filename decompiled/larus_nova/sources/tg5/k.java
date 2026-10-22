package tg5;

import android.content.DialogInterface;
import com.bytedance.ee.bear.share.export.UserInfo;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes18.dex */
public final class k implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f545879a;

    public k(b r100) {
        this.f545879a = r100;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface r110, int r111) {
        p.a r112 = this.f545879a.f545854d;
        if (r112 == null) goto L5;
        r112.W2();
    L5:
        ArrayList<UserInfo> r113 = this.f545879a.e();
        if (this.f545879a.getNotes().length() <= 0) goto L8;
        boolean r114 = true;
    L9:
        String r100 = com.bytedance.ee.bear.middleground.permission.c.f233147a;
        Intrinsics.checkNotNullParameter(r113, "userInfoList");
        JSONObject r101 = new JSONObject();
        String r102 = com.bytedance.ee.bear.middleground.permission.c.f233152f;
        int r103 = com.bytedance.ee.bear.middleground.permission.c.f233153g;
        if (com.bytedance.ee.bear.middleground.permission.c.f233149c == false) goto L12;
        String r104 = ThumbGlideUrl.SOURCE_VC;
    L13:
        com.bytedance.ee.bear.middleground.permission.c.a(r101, r102, r103, r104, com.bytedance.ee.bear.middleground.permission.c.f233154h, com.bytedance.ee.bear.middleground.permission.c.f233150d, com.bytedance.ee.bear.middleground.permission.c.f233151e, com.bytedance.ee.bear.middleground.permission.c.f233147a, com.bytedance.ee.bear.middleground.permission.c.f233148b, com.bytedance.ee.bear.middleground.permission.c.f233155i);
        r101.put("click", "send");
        r101.put("is_add_notes", String.valueOf(r114));
        JSONArray r115 = new JSONArray();
        Iterator<UserInfo> r116 = r113.iterator();
    L15:
        if (r116.hasNext() == false) goto L17;
        UserInfo r105 = r116.next();
        JSONObject r106 = new JSONObject();
        r106.put("collaborate_type", r105.getOwnerType());
        r106.put("object_uid", du5.b.g(r105.getId()));
        r106.put("list_type", com.bytedance.ee.bear.middleground.permission.c.d(com.bytedance.ee.bear.middleground.permission.c.f233153g, r105.getPermission()));
        r115.put(r106);
        goto L15
    L17:
        r101.put("user_list", r115.toString());
        r101.put(PickerReporterConstants.KEY.TARGET, "none");
        com.bytedance.ee.bear.middleground.permission.c.c("ccm_permission_organization_authorize_send_notice_click", r101);
        return;
    L12:
        r104 = "none";
        goto L13
    L8:
        r114 = false;
        goto L9
    }
}
