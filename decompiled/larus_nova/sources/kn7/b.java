package kn7;

import android.widget.Toast;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;
import com.bytedance.ug.sdk.share.api.panel.ShareChannelType;
import com.bytedance.ug.sdk.share.impl.manager.h;
import oo7.k;
import oo7.o;
import oo7.t;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes22.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f504255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f504256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f504257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ShareChannelType f504258d;

    public b(int r100, ShareChannelType r101) {
        this.f504255a = r100;
        this.f504258d = r101;
    }

    public static void a(int r100, ShareContent r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        b r102 = new b(r100, r101.getShareChanelType());
        if (r101.getEventCallBack() == null) goto L13;
        k.a("ShareResult", "share error code : " + r100);
        String r103 = "error code : " + r100;
        if (o.f524633a == false) goto L9;
        Toast.makeText(h.g.f272345a.f272326a.getApplicationContext(), r103, 0).show();
    L9:
        r101.getEventCallBack().a(r102);
        if (r100 != 10000) goto L12;
        r101.getEventCallBack().b(r101.getShareChanelType());
    L12:
        h.g.f272345a.getClass();
    L13:
        t.a(r102, r101);
        JSONObject r104 = new JSONObject();
        r104.put("panel_id", r101.getPanelId());     // Catch: JSONException -> L16
        r104.put(WsConstants.KEY_CHANNEL_TYPE, ShareChannelType.getShareItemTypeName(r101.getShareChanelType()));     // Catch: JSONException -> L16
        r104.put("code", r100);     // Catch: JSONException -> L16
    L18:
        go7.b.a(r104);
        oo7.c.a("ug_sdk_share_share_reuslt", r104);
        return;
    L16:
        e = move-exception;
        k.b(e.toString());
        goto L18
    }
}
