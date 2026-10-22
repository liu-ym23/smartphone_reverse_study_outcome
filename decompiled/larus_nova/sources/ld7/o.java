package ld7;

import androidx.camera.video.AudioStats;
import com.bytedance.sdk.xbridge.cn.auth.bean.RequestCheckAction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes22.dex */
public final class o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f508759d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RequestCheckAction f508760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashMap<String, ArrayList<String>> f508761b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashMap<String, ArrayList<String>> f508762c;

    public static final class a {
    }

    static {
    }

    public o() {
        throw null;
    }

    public o(Map r110) {
        this.f508760a = RequestCheckAction.DISABLE;
        this.f508761b = new HashMap();
        this.f508762c = new HashMap();
        Object r100 = r110.get("action");
        Map r101 = null;
        if ((r100 instanceof Double) == false) goto L5;
        Double r102 = (Double) r100;
    L6:
        if (r102 == null) goto L8;
        double r103 = r102.doubleValue();
    L9:
        RequestCheckAction[] r104 = RequestCheckAction.values();
        int r105 = r104.length;
        int r106 = 0;
    L11:
        if (r106 >= r105) goto L19;
        RequestCheckAction r107 = r104[r106];
        if (r107.getValue() != ((int) r103)) goto L15;
        boolean r108 = true;
    L16:
        if (r108 == true) goto L20;
        r106 = r106 + 1;
    L20:
        if (r107 == null) goto L22;
        this.f508760a = r107;
    L22:
        Map r109 = od7.a.f522857e;
        if (r109 != null) goto L25;
        r109 = new HashMap();
    L25:
        Object r111 = r110.get("settings");
        if ((r111 instanceof Map) == false) goto L28;
        r101 = (Map) r111;
    L28:
        if (r101 == null) goto L48;
        Iterator r112 = r101.entrySet().iterator();
    L31:
        if (r112.hasNext() == false) goto L64;
        Map.Entry r113 = (Map.Entry) r112.next();
        Object r114 = r113.getKey();
        Object r115 = r113.getValue();
        if ((r114 instanceof String) == false) goto L31;
        ArrayList<String> r116 = new ArrayList();
        ArrayList<String> r117 = new ArrayList();
        if ((r115 instanceof String) == true) goto L37;
        if ((r115 instanceof List) == false) goto L31;
        Iterator r118 = ((List) r115).iterator();
    L42:
        if (r118.hasNext() == false) goto L47;
        Object r119 = r118.next();
        if ((r119 instanceof String) == false) goto L42;
        String r120 = (String) r119;
        r116.addAll(a(true, r120, r109));
        r117.addAll(a(false, r120, r109));
    L47:
        this.f508761b.put((String) r114, r116);
        this.f508762c.put((String) r114, r117);
        goto L31
    L37:
        String r121 = (String) r115;
        r116.addAll(a(true, r121, r109));
        r117.addAll(a(false, r121, r109));
        goto L47
    L64:
        return;
    L48:
        return;
    L15:
        r108 = false;
        goto L16
    L19:
        r107 = null;
        goto L20
    L8:
        r103 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public static List a(boolean r100, String r101, Map r102) {
        if (r102.isEmpty() == true) goto L53;
        boolean r103 = false;
        if (r101.length() != 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L53;
        Object r105 = r102.get(r101);
        List r106 = null;
        if ((r105 instanceof Map) == false) goto L13;
        Map r107 = (Map) r105;
    L14:
        if (r107 == null) goto L51;
        if (r100 == false) goto L17;
        String r108 = "match_reg";
    L18:
        Object r109 = r107.get(r108);
        if ((r109 instanceof String) == false) goto L21;
        String r110 = (String) r109;
    L22:
        if (r110 != null) goto L24;
        Object r111 = r107.get(r108);
        if ((r111 instanceof List) == false) goto L33;
        r106 = (List) r111;
    L33:
        if (r106 == null) goto L51;
        ArrayList r112 = new ArrayList();
        Iterator r113 = r106.iterator();
    L36:
        if (r113.hasNext() == false) goto L40;
        Object r114 = r113.next();
        if ((r114 instanceof String) == false) goto L36;
        r112.add(r114);
        goto L36
    L40:
        ArrayList r115 = new ArrayList();
        Iterator r116 = r112.iterator();
    L42:
        if (r116.hasNext() == false) goto L49;
        Object r117 = r116.next();
        if (((String) r117).length() <= 0) goto L46;
        boolean r118 = true;
    L47:
        if (r118 == false) goto L42;
        r115.add(r117);
        goto L42
    L46:
        r118 = false;
        goto L47
    L49:
        return r115;
    L24:
        if (r110.length() <= 0) goto L26;
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        return CollectionsKt.listOf(r110);
    L29:
        return CollectionsKt.emptyList();
    L21:
        r110 = null;
        goto L22
    L17:
        r108 = "exclude_reg";
    L51:
        return CollectionsKt.emptyList();
    L13:
        r107 = null;
        goto L14
    L7:
        r104 = false;
    L53:
        return CollectionsKt.emptyList();
    }
}
