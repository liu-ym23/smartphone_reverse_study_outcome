package xwb;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.ss.android.lark.chameleon.bridge.Bridge;
import com.ss.android.lark.officewebview.bridge.Status;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class d implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f565306a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f565307b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f565308c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f565309d;

    @Override // xwb.j
    public final void a(Status r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "status");
        String r102 = this.f565306a;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        int r104 = h.f565310a;
        h.b(this.f565307b.f565287a, 10005, this.f565308c + " 's callbackId isNullOrEmpty!", this.f565308c);
        return;
    L11:
        this.f565307b.f565295i.getClass();
        e r105 = this.f565307b.f565295i;
        String r106 = this.f565306a;
        String r107 = this.f565309d;
        r105.getClass();
        Intrinsics.checkNotNullParameter(r100, "status");
        Intrinsics.checkNotNullParameter(r106, "callbackId");
        Intrinsics.checkNotNullParameter(r107, "extraStr");
        HashMap r108 = new HashMap();
        r108.put("callbackID", this.f565306a);
        r108.put("data", r101);
        r108.put("callbackType", r100.getStatus());
        this.f565307b.getClass();
        JSONObject r109 = new JSONObject();     // Catch: JSONException -> L14
    L17:
        if ((r101 instanceof JSONObject) == false) goto L23;
        JSONObject r110 = (JSONObject) ((ConcurrentHashMap) this.f565307b.f565294h).get(this.f565308c);
        if (r110 == null) goto L22;
        r109 = r110;
    L22:
        r108.put("extra", r109);
        StringCompanionObject r111 = StringCompanionObject.INSTANCE;
        String r112 = String.format(Bridge.CALLBACK_FUN, Arrays.copyOf(new Object[]{new JSONObject(r108).toString()}, 1));
    L39:
        com.ss.android.lark.officesdk.utils.di.j.a("CML_TAG_JSBridge", "evaluateJavascript for jsapi callback, script = " + r112);
        this.f565307b.f565287a.evaluateJavascript(r112, null);
        return;
    L23:
        Object r113 = (JSONObject) ((ConcurrentHashMap) this.f565307b.f565294h).get(this.f565308c);
        if (r113 != null) goto L29;
        String r114 = r109.toString();
        if (r114 != null) goto L28;
        r114 = "";
    L28:
        r113 = JSON.parseObject(r114);
    L29:
        r108.put("extra", r113);
        String r115 = new com.alibaba.fastjson.JSONObject(r108).toJSONString();
        g r116 = this.f565307b.f565291e;
        Intrinsics.checkNotNull(r115);
        r116.getClass();
        Intrinsics.checkNotNullParameter(r108, "params");
        Intrinsics.checkNotNullParameter(r115, "result");
    L36:
        th = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("BridgeInfoPrinter", "Failed to printLengthInfo, ", th);
    L38:
        StringCompanionObject r117 = StringCompanionObject.INSTANCE;
        r112 = String.format(Bridge.CALLBACK_FUN, Arrays.copyOf(new Object[]{r115}, 1));
        goto L39
    L31:
        if (TextUtils.isEmpty(r115) == true) goto L38;
        if (r115.length() <= 2097152) goto L38;
        g.a(r108, "param before serialize ");     // Catch: Throwable -> L36
        g.a(r115, "param after serialize ");     // Catch: Throwable -> L36
    L14:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.d("CML_TAG_JSBridge", e);
        r109 = new JSONObject();
        goto L17
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    public d(String r100, a r101, String r102, String r103) {
        this.f565306a = r100;
        this.f565307b = r101;
        this.f565308c = r102;
        this.f565309d = r103;
        System.currentTimeMillis();
    }
}
