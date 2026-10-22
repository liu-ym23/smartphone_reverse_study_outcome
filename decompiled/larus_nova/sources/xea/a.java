package xea;

import android.os.Bundle;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintState;
import com.larus.applog.api.IApplog;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f563386a = 0;

    static {
    }

    public a() {
    }

    public static void b(String r100, String r101, Integer r102) {
        IApplog.f287053a.b("obric_short_link_request_start", com.larus.utils.f.c(new Pair[]{TuplesKt.to("path", r100), TuplesKt.to("sequence_id", r101), TuplesKt.to("network_status", r102)}));
    }

    public static void a(String r100, String r101, Integer r102, Integer r103, Integer r104, String r105, Map r106) {
        Bundle r107 = com.larus.utils.f.c(new Pair[]{TuplesKt.to("path", r100), TuplesKt.to("sequence_id", r101), TuplesKt.to("network_status", r102), TuplesKt.to("repeat_time", r103), TuplesKt.to(VoicePrintState.EXT_KEY_RESPONSE_CODE, r104), TuplesKt.to("response_description", r105)});
        if (r106 == null) goto L26;
        Iterator r108 = r106.entrySet().iterator();
    L6:
        if (r108.hasNext() == false) goto L26;
        Map.Entry r109 = (Map.Entry) r108.next();
        String r110 = (String) r109.getKey();
        Object r111 = r109.getValue();
        if ((r111 instanceof Long) == true) goto L9;
        if ((r111 instanceof Integer) == true) goto L12;
        if ((r111 instanceof String) == true) goto L15;
        if ((r111 instanceof Float) == true) goto L18;
        if ((r111 instanceof Double) == true) goto L21;
        if (r111 == null) goto L24;
        String r112 = r111.toString();
    L25:
        r107.putString(r110, r112);
        goto L6
    L24:
        r112 = null;
        goto L25
    L21:
        r107.putDouble(r110, ((Number) r111).doubleValue());
        goto L6
    L18:
        r107.putFloat(r110, ((Number) r111).floatValue());
        goto L6
    L15:
        r107.putString(r110, (String) r111);
        goto L6
    L12:
        r107.putInt(r110, ((Number) r111).intValue());
        goto L6
    L9:
        r107.putLong(r110, ((Number) r111).longValue());
    L26:
        IApplog.f287053a.b("obric_short_link_request_end", r107);
    }
}
