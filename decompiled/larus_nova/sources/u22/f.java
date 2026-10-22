package u22;

import com.bytedance.android.livesdk.event.d0;
import com.bytedance.android.livesdk.t4;
import com.tencent.connect.common.Constants;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final HashMap<String, List<String>> f548418a = null;

    static {
        f548418a = (HashMap) t4.f158507a.getValue();
    }

    public static int a(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if (c(r100) == false) goto L6;
        return 8;
    L6:
        if (f(r100) == false) goto L9;
        return 4;
    L9:
        if (d(r100) == false) goto L12;
        return 9;
    L12:
        if (e(r100) == false) goto L15;
        return 10;
    L15:
        if (b(r100) == false) goto L17;
        return 11;
    L17:
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r101 = r100.f123339c.get("request_source");
        Object r102 = null;
        if ((r101 instanceof String) == true) goto L20;
        r101 = null;
    L20:
        String r103 = (String) r101;
        boolean r104 = true;
        if (r103 != null) goto L23;
    L24:
        Object r105 = r100.f123339c.get("request_source");
        if ((r105 instanceof String) == true) goto L27;
        r105 = null;
    L27:
        String r106 = (String) r105;
        if (r106 != null) goto L30;
    L31:
        Object r107 = r100.f123339c.get("request_source");
        if ((r107 instanceof String) == true) goto L34;
        r107 = null;
    L34:
        String r108 = (String) r107;
        if (r108 != null) goto L37;
    L38:
        Object r109 = r100.f123339c.get("request_source");
        if ((r109 instanceof String) == true) goto L41;
        r109 = null;
    L41:
        String r110 = (String) r109;
        if (r110 != null) goto L44;
    L46:
        boolean r111 = false;
    L47:
        if (r111 == false) goto L49;
        return 13;
    L49:
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r112 = r100.f123339c.get("input_comment_type");
        if ((r112 instanceof Integer) == true) goto L52;
        r112 = null;
    L52:
        Integer r113 = (Integer) r112;
        if (r113 != null) goto L56;
    L58:
        boolean r114 = false;
    L59:
        if (r114 == false) goto L61;
        return 15;
    L61:
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r115 = r100.f123339c.get("input_comment_type");
        if ((r115 instanceof Integer) == false) goto L65;
        r102 = r115;
    L65:
        Integer r116 = (Integer) r102;
        if (r116 != null) goto L69;
    L71:
        r104 = false;
    L72:
        if (r104 == true) goto L83;
        return 0;
    L83:
        return 14;
    L69:
        if (r116.intValue() != 14) goto L71;
    L56:
        if (r113.intValue() != 15) goto L58;
        r114 = true;
        goto L59
    L44:
        if (r110.equals("anchor_custom_topic_btn") != true) goto L46;
    L45:
        r111 = true;
        goto L47
    L37:
        if (r108.equals("comment_topic_btn") == true) goto L45;
    L30:
        if (r106.equals("anchor_custom_topic") == true) goto L45;
    L23:
        if (r103.equals("comment_topic") == true) goto L45;
        goto L24
    }

    public static boolean b(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r101 = r100.f123339c.get("input_comment_type");
        if ((r101 instanceof Integer) == true) goto L5;
        r101 = null;
    L5:
        Integer r102 = (Integer) r101;
        if (r102 != null) goto L9;
    L11:
        return false;
    L9:
        if (r102.intValue() != 11) goto L11;
        return true;
    }

    public static boolean c(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r101 = r100.f123339c.get("is_from_comment_operate_copy");
        if ((r101 instanceof Boolean) == true) goto L5;
        r101 = null;
    L5:
        Boolean r102 = (Boolean) r101;
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.booleanValue();
    }

    public static boolean d(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r101 = r100.f123339c.get("request_source");
        Object r102 = null;
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        String r103 = (String) r101;
        if (r103 != null) goto L8;
        return false;
    L8:
        Iterator<Map.Entry<String, List<String>>> r104 = f548418a.entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L17;
        Map.Entry<String, List<String>> r105 = r104.next();
        if (Intrinsics.areEqual(Constants.VIA_SHARE_TYPE_MINI_PROGRAM, r105.getKey()) == false) goto L10;
        if (r105.getValue().contains(r103) == false) goto L10;
        return true;
    L17:
        Object r106 = r100.f123339c.get("request_source");
        if ((r106 instanceof String) == false) goto L21;
        r102 = r106;
    L21:
        String r107 = (String) r102;
        if (r107 != null) goto L24;
        return false;
    L24:
        return r107.equals("lottery");
    }

    public static boolean e(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r101 = r100.f123339c.get("request_source");
        Object r102 = null;
        if ((r101 instanceof String) == true) goto L5;
        r101 = null;
    L5:
        String r103 = (String) r101;
        if (r103 != null) goto L8;
        return false;
    L8:
        Iterator<Map.Entry<String, List<String>>> r104 = f548418a.entrySet().iterator();
    L10:
        if (r104.hasNext() == false) goto L17;
        Map.Entry<String, List<String>> r105 = r104.next();
        if (Intrinsics.areEqual(Constants.VIA_REPORT_TYPE_SHARE_TO_QQ, r105.getKey()) == false) goto L10;
        if (r105.getValue().contains(r103) == false) goto L10;
        return true;
    L17:
        Object r106 = r100.f123339c.get("request_source");
        if ((r106 instanceof String) == false) goto L21;
        r102 = r106;
    L21:
        String r107 = (String) r102;
        if (r107 != null) goto L24;
        return false;
    L24:
        return r107.equals("super_lottery");
    }

    public static boolean f(d0 r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        Object r101 = r100.f123339c.get("from_voice_panel");
        if ((r101 instanceof Boolean) == true) goto L5;
        r101 = null;
    L5:
        Boolean r102 = (Boolean) r101;
        if (r102 != null) goto L10;
        return false;
    L10:
        return r102.booleanValue();
    }
}
