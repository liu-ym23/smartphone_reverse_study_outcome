package com.bytedance.android.shopping.hybrid.bridges;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.host.api.hybrid.ECBaseBridgeMethod;
import com.bytedance.android.shopping.utils.gallery.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/shopping/hybrid/bridges/ECGalleryMethod;", "Lcom/bytedance/android/ec/host/api/hybrid/ECBaseBridgeMethod;", "<init>", "()V", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECGalleryMethod extends ECBaseBridgeMethod {
    public final String e;

    public static final class a {
    }

    static {
    }

    public ECGalleryMethod() {
        this.e = "ecGallery";
    }

    public final String getName() {
        return this.e;
    }

    public final void c(JSONObject r11, ECBaseBridgeMethod.a r12) {
        Intrinsics.checkNotNullParameter(r11, "params");
        Intrinsics.checkNotNullParameter(r12, "iReturn");
        JSONObject r0 = r11.optJSONObject("data");
        if (r0 == null) goto L6;
        r11 = r0;
    L6:
        boolean r1 = false;
        int r2 = r11.optInt("index", 0);
        ArrayList r4 = new ArrayList();
        JSONArray r3 = r11.optJSONArray("images");     // Catch: JSONException -> L16
        if (r3 == null) goto L18;
        Iterator r5 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r3)).iterator();     // Catch: JSONException -> L16
    L11:
        if (r5.hasNext() == false) goto L18;
        Object r6 = r5.next();     // Catch: JSONException -> L16
        if ((r6 instanceof String) == false) goto L11;
        r4.add(r6);     // Catch: JSONException -> L16
    L18:
        ArrayList r7 = new ArrayList();
        JSONArray r8 = r11.optJSONArray("videos");     // Catch: JSONException -> L31
        if (r8 == null) goto L33;
        Iterator r9 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r8)).iterator();     // Catch: JSONException -> L31
    L23:
        if (r9.hasNext() == false) goto L33;
        Object r10 = r9.next();     // Catch: JSONException -> L31
        fj.d.a r13 = fj.d.s;     // Catch: JSONException -> L31
        if ((r10 instanceof HashMap) == true) goto L27;
        r10 = null;
    L27:
        r13.getClass();     // Catch: JSONException -> L31
        fj.d r14 = fj.d.a.a((HashMap) r10);     // Catch: JSONException -> L31
        if (r14 == null) goto L23;
        r7.add(r14);     // Catch: JSONException -> L31
    L33:
        ArrayList r15 = new ArrayList();
        JSONArray r16 = r11.optJSONArray("titles");
        if (r16 == null) goto L41;
        Iterator r17 = ((ArrayList) com.bytedance.android.shopping.hybrid.a.a(r16)).iterator();
    L37:
        if (r17.hasNext() == false) goto L41;
        Object r18 = r17.next();
        if ((r18 instanceof String) == false) goto L37;
        r15.add(r18);
    L41:
        r11.optBoolean("drag", true);
        r11.optBoolean("download", false);
        Context r19 = getContext();
        int r110 = -1;
        String r20 = "";
        if (r19 != null) goto L44;
    L54:
        JSONObject r21 = new JSONObject();
        r21.put("code", r110);
        if (r20.length() <= 0) goto L57;
        r1 = true;
    L57:
        if (r1 == false) goto L59;
        r21.put("error_msg", r20);
    L59:
        Unit r111 = Unit.INSTANCE;
        r12.a(r21);
        return;
    L44:
        if ((r7.size() + r4.size()) != 0) goto L47;
        int r22 = -1;
    L51:
        if (r22 >= 0) goto L53;
        r20 = "empty_source";
        goto L54
    L53:
        k.a(r19, r7, r4, r15, r22, false);
        r110 = 1;
        goto L54
    L47:
        if (r7.isEmpty() == false) goto L49;
        int r23 = Math.min(r2, r4.size() - 1);
    L50:
        r22 = r23;
        goto L51
    L49:
        r23 = Math.min(r2 + 1, r4.size());
    L31:
        e = move-exception;
        ECExceptionMonitor.f(e, "ECGalleryMethod video url parse error");
    L16:
        e = move-exception;
        ECExceptionMonitor.f(e, "ECGalleryMethod image url parse error");
        goto L18
    }
}
