package oo5;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f524611a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f524612b;

    public static final class a {
    }

    static {
    }

    public final HashMap<String, Serializable> a() {
        HashMap r100 = new HashMap();
        String r101 = this.f524611a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.put("token", r101);
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = this.f524612b.iterator();
    L7:
        if (r103.hasNext() == false) goto L26;
        b r104 = (b) r103.next();
        r104.getClass();
        HashMap r105 = new HashMap();
        String r106 = r104.f524586a;     // Catch: Exception -> L23
        if (r106 != null) goto L12;
        r106 = "";
    L12:
        r105.put("token", r106);     // Catch: Exception -> L23
        String r110 = r104.f524587b;     // Catch: Exception -> L23
        if (r110 != null) goto L15;
        r110 = "";
    L15:
        r105.put("title", r110);     // Catch: Exception -> L23
        String r111 = r104.f524588c;     // Catch: Exception -> L23
        if (r111 != null) goto L18;
        r111 = "";
    L18:
        r105.put("owner", r111);     // Catch: Exception -> L23
        String r112 = r104.f524589d;     // Catch: Exception -> L23
        if (r112 != null) goto L21;
        r112 = "";
    L21:
        r105.put("iconInfo", r112);     // Catch: Exception -> L23
        r105.put("totalSeconds", Float.valueOf(r104.f524590e));     // Catch: Exception -> L23
        r105.put("currentSeconds", Float.valueOf(r104.f524591f));     // Catch: Exception -> L23
        r105.put("enable", Boolean.valueOf(r104.f524592g));     // Catch: Exception -> L23
        r105.put("highlight", Boolean.valueOf(r104.f524593h));     // Catch: Exception -> L23
        r105.put("playing", Boolean.valueOf(r104.f524594i));     // Catch: Exception -> L23
    L25:
        r102.add(r105);
    L23:
        e = move-exception;
        tt5.a.e("TtsLynxPlayListItemParams", "TtsLynxPlayListItemParams-toMap, error:", e, false);
        goto L25
    L26:
        HashMap<String, Serializable> r107 = new HashMap();
        r107.put("playingItem", r100);     // Catch: Exception -> L29
        r107.put("items", r102);     // Catch: Exception -> L29
    L31:
        return r107;
    L29:
        e = move-exception;
        tt5.a.e("TtsLynxPlayListItemParams", "TtsLynxPlaylistParams-toMap, error:", e, false);
        goto L31
    }

    public e() {
        this.f524612b = new ArrayList();
    }
}
