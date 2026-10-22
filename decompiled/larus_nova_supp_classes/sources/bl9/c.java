package bl9;

import android.util.Pair;
import com.larus.common.apphost.AppHost;
import dl9.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static final HashMap<String, String> a = null;
    public static final Map<String, List<String>> b = null;
    public static final Map<String, List<String>> c = null;
    public static final Map<String, List<Pair<String, List<String>>>> d = null;
    public static final Map<String, List<String>> e = null;

    static {
        a = new HashMap();
        b = new HashMap();
        c = new HashMap();
        d = new HashMap();
        e = new HashMap();
        AppHost.a.getApplication().getPackageName();
        HashMap r0 = new HashMap();
        int r1 = a.a;
        Iterator r2 = MapsKt.emptyMap().entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        Map.Entry r3 = (Map.Entry) r2.next();
        String r4 = (String) r3.getKey();
        Map r5 = (Map) r3.getValue();
        ((HashMap) c).put(r4, CollectionsKt.toList(r5.keySet()));
        Iterator r6 = r5.entrySet().iterator();
    L7:
        if (r6.hasNext() == false) goto L4;
        Map.Entry r7 = (Map.Entry) r6.next();
        String r8 = (String) r7.getKey();
        List r9 = (List) r7.getValue();
        a.put(r8, r4);
        r0.put(r8, r9);
        goto L7
    L9:
        Iterator r10 = ((HashMap) c).entrySet().iterator();
    L11:
        if (r10.hasNext() == false) goto L45;
        Map.Entry r11 = (Map.Entry) r10.next();
        String r12 = (String) r11.getKey();
        List r13 = (List) r11.getValue();
        LinkedHashSet r14 = new LinkedHashSet();
        Iterator r15 = r13.iterator();
    L14:
        if (r15.hasNext() == false) goto L29;
        String r16 = (String) r15.next();
        List r17 = (List) r0.get(r16);
        if (r17 == null) goto L18;
        r14.addAll(r17);
    L18:
        a(r16, r0);
        Set r18 = SetsKt.mutableSetOf(new String[]{r12});
        List r19 = (List) ((HashMap) e).get(r16);
        if (r19 == null) goto L28;
        Iterator r20 = r19.iterator();
    L22:
        if (r20.hasNext() == false) goto L28;
        String r21 = a.get((String) r20.next());
        if (r21 == null) goto L27;
        r18.add(r21);
        goto L22
    L27:
        throw new NotImplementedError("An operation is not implemented: 找不到Owner");
    L28:
        ((HashMap) b).put(r16, CollectionsKt.toList(r18));
        goto L14
    L29:
        Map<String, List<Pair<String, List<String>>>> r22 = d;
        LinkedHashMap r23 = new LinkedHashMap();
        Iterator r24 = r14.iterator();
    L31:
        if (r24.hasNext() == false) goto L40;
        Object r25 = r24.next();
        String r26 = a.get((String) r25);
        if (r26 == null) goto L39;
        Object r28 = r23.get(r26);
        if (r28 != null) goto L37;
        r28 = new ArrayList();
        r23.put(r26, r28);
    L37:
        ((List) r28).add(r25);
        goto L31
    L39:
        throw new NotImplementedError("An operation is not implemented: 找不到Owner");
    L40:
        ArrayList r29 = new ArrayList(r23.size());
        Iterator r30 = r23.entrySet().iterator();
    L42:
        if (r30.hasNext() == false) goto L44;
        Map.Entry r31 = (Map.Entry) r30.next();
        r29.add(new Pair(r31.getKey(), r31.getValue()));
        goto L42
    L44:
        ((HashMap) r22).put(r12, r29);
        goto L11
    }

    public static void a(String r4, Map r5) {
        if (((HashMap) e).get(r4) != null) goto L29;
        HashMap r0 = (HashMap) r5;
        Collection r1 = (Collection) r0.get(r4);
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L30;
        LinkedHashSet r3 = new LinkedHashSet();
        List r6 = (List) r0.get(r4);
        if (r6 == null) goto L22;
        Iterator r7 = r6.iterator();
    L17:
        if (r7.hasNext() == false) goto L22;
        String r8 = (String) r7.next();
        r3.add(r8);
        a(r8, r5);
        List r9 = (List) ((HashMap) e).get(r8);
        if (r9 == null) goto L17;
        r3.addAll(r9);
    L22:
        Map<String, List<String>> r10 = e;
        HashMap r11 = (HashMap) r10;
        r11.put(r4, CollectionsKt.toList(r3));
        return;
    L30:
        return;
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
        goto L11
    }
}
