package av4;

import android.text.TextUtils;
import com.bytedance.ee.bear.bitable.c;
import com.bytedance.ee.bear.bitable.statistic.BitableStatisticEventModel$NormalPointModel;
import com.bytedance.ee.bear.bitable.statistic.e;
import com.bytedance.ee.bear.bitable.statistic.i;
import com.bytedance.ee.bear.document.comment.bean.JSEventListener;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends com.bytedance.ee.bear.bitable.statistic.common.a {
    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final List<BitableStatisticEventModel$NormalPointModel> c(e r2, BitableStatisticEventModel$NormalPointModel r3, List<BitableStatisticEventModel$NormalPointModel> r4) {
        Intrinsics.checkNotNullParameter(r2, "trace");
        Intrinsics.checkNotNullParameter(r3, "currPoint");
        Intrinsics.checkNotNullParameter(r4, "allPoints");
        return null;
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.j
    public final String getTag() {
        return "BitableJsbConsumer";
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final String i() {
        return "base_mobile_jsb_call_dev";
    }

    public a() {
    }

    @Override // com.bytedance.ee.bear.bitable.statistic.common.a
    public final boolean k(i r9, e r10, BitableStatisticEventModel$NormalPointModel r11, List<BitableStatisticEventModel$NormalPointModel> r12) {
        Intrinsics.checkNotNullParameter(r9, "logger");
        Intrinsics.checkNotNullParameter(r10, "trace");
        Intrinsics.checkNotNullParameter(r11, "currPoint");
        Intrinsics.checkNotNullParameter(r12, "allPoints");
        if (TextUtils.equals(r11.getName(), "JSB_REPORT_POINT_NAME") == false) goto L43;
        HashMap r13 = new HashMap();
        r13.putAll(this.b);
        HashMap<String, Serializable> r2 = r11.getExtras();
        if (r2 == null) goto L9;
        Serializable r3 = r2.get("jsb_name");
        if (r3 == null) goto L9;
        String r4 = r3.toString();
    L10:
        HashMap<String, Serializable> r14 = r11.getExtras();
        if (r14 == null) goto L41;
        Map r16 = MapsKt.toMap(r14);
        if (r16 == null) goto L41;
        Iterator r17 = r16.entrySet().iterator();
    L16:
        if (r17.hasNext() == false) goto L41;
        Map.Entry r5 = (Map.Entry) r17.next();
        if (TextUtils.equals((CharSequence) r5.getKey(), "msg") == true) goto L19;
        Serializable r6 = (Serializable) r13.put(r5.getKey(), r5.getValue());
        goto L16
    L19:
        if (r4 == null) goto L21;
        boolean r7 = StringsKt.contains$default(r4, "performCardAction", false, 2, null);
    L22:
        if (r7 == true) goto L44;
    L29:
        int r8 = c.a;
        if (com.bytedance.ee.bear.bitable.core.usercomponent.b.c("ccm.bitable.jsb_consumer_oom_fix_enable") == true) goto L31;
        Serializable r18 = (Serializable) r13.put("msg_size", Integer.valueOf(r5.getValue().toString().getBytes(Charsets.UTF_8).length));
        goto L16
    L31:
        Object r19 = r5.getValue();
        if ((r19 instanceof String) == false) goto L34;
        String r20 = (String) r19;
    L35:
        if (r20 == null) goto L37;
        int r21 = r20.length();
    L38:
        Serializable r22 = (Serializable) r13.put("msg_size", Integer.valueOf(r21));
        goto L16
    L37:
        r21 = 0;
        goto L38
    L34:
        r20 = null;
        goto L35
    L44:
        String r23 = new JSONObject(r5.getValue().toString()).optString(JSEventListener.ACTION);     // Catch: Throwable -> L27
        if (TextUtils.isEmpty(r23) == true) goto L29;
        r13.put(JSEventListener.ACTION, r23);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        tt5.a.e("BitableJsbConsumer", "parse json performCardAction error", th, false);
        goto L29
    L21:
        r7 = false;
    L41:
        Unit r110 = Unit.INSTANCE;
        r9.d(r10, "base_mobile_jsb_call_dev", r13);
        return true;
    L9:
        r4 = null;
        goto L10
    L43:
        return false;
    }
}
