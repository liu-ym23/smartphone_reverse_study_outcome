package mu7;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, ConcurrentHashMap<String, Object>> f515781a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Object> f515782b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, Object> f515783c = null;

    static {
        f515781a = new ConcurrentHashMap();
        ConcurrentHashMap<String, Object> r100 = new ConcurrentHashMap();
        f515782b = r100;
        f515783c = r100;
    }

    public static Map a(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "originalMap");
        LinkedHashMap r101 = new LinkedHashMap();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L46;
        Map.Entry r103 = (Map.Entry) r102.next();
        int r104 = lu7.a.f510834a;
        String r105 = (String) r103.getKey();
        Intrinsics.checkNotNullParameter(r105, "key");
        switch(r105.hashCode()) {
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
        boolean r106 = false;
    L44:
        if ((!r106) == false) goto L4;
        r101.put(r103.getKey(), r103.getValue());
        goto L4
    L9:
        if (r105.equals("error_code") == false) goto L42;
    L41:
        r106 = true;
        goto L44
    L12:
        if (r105.equals("minor_name") == true) goto L41;
    L15:
        if (r105.equals("valid_steps_duration") == true) goto L41;
    L18:
        if (r105.equals("custom_event") == true) goto L41;
    L21:
        if (r105.equals("business_type") == true) goto L41;
    L24:
        if (r105.equals("error_msg") == true) goto L41;
    L27:
        if (r105.equals("step") == true) goto L41;
    L30:
        if (r105.equals("major_name") == true) goto L41;
    L33:
        if (r105.equals("valid_duration") == false) goto L42;
    L36:
        if (r105.equals("exclude_duration") == true) goto L41;
    L39:
        if (r105.equals("duration") == true) goto L41;
    L46:
        return r101;
    }
}
