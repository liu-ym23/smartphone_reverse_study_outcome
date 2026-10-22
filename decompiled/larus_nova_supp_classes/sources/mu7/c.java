package mu7;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static final ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> a = null;
    public static final ConcurrentHashMap<String, Object> b = null;
    public static final Map<String, Object> c = null;

    static {
        a = new ConcurrentHashMap();
        ConcurrentHashMap<String, Object> r0 = new ConcurrentHashMap();
        b = r0;
        c = r0;
    }

    public static Map a(Map r5) {
        Intrinsics.checkNotNullParameter(r5, "originalMap");
        LinkedHashMap r0 = new LinkedHashMap();
        Iterator r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L46;
        Map.Entry r1 = (Map.Entry) r6.next();
        int r2 = lu7.a.a;
        String r3 = (String) r1.getKey();
        Intrinsics.checkNotNullParameter(r3, "key");
        switch(r3.hashCode()) {
            case -1992012396: goto L39;
            case -1298426279: goto L36;
            case -939971977: goto L33;
            case -331732655: goto L30;
            case 3540684: goto L27;
            case 329868490: goto L24;
            case 630087769: goto L21;
            case 717572172: goto L18;
            case 764587599: goto L15;
            case 769807573: goto L12;
            case 1635686852: goto L9;
            default: goto L42;
        };
    L42:
        boolean r4 = false;
    L44:
        if ((!r4) == false) goto L4;
        r0.put(r1.getKey(), r1.getValue());
        goto L4
    L9:
        if (r3.equals("error_code") == false) goto L42;
    L41:
        r4 = true;
        goto L44
    L12:
        if (r3.equals("minor_name") == true) goto L41;
    L15:
        if (r3.equals("valid_steps_duration") == true) goto L41;
    L18:
        if (r3.equals("custom_event") == true) goto L41;
    L21:
        if (r3.equals("business_type") == true) goto L41;
    L24:
        if (r3.equals("error_msg") == true) goto L41;
    L27:
        if (r3.equals("step") == true) goto L41;
    L30:
        if (r3.equals("major_name") == true) goto L41;
    L33:
        if (r3.equals("valid_duration") == false) goto L42;
    L36:
        if (r3.equals("exclude_duration") == true) goto L41;
    L39:
        if (r3.equals("duration") == true) goto L41;
    L46:
        return r0;
    }
}
