package oo5;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public String a;
    public final ArrayList<b> b;

    public static final class a {
    }

    static {
    }

    public final HashMap<String, Serializable> a() {
        HashMap r0 = new HashMap();
        String r1 = this.a;
        if (r1 != null) goto L5;
        r1 = "";
    L5:
        r0.put(ResourceData.KEY_TOKEN, r1);
        ArrayList r2 = new ArrayList();
        Iterator<T> r4 = this.b.iterator();
    L7:
        if (r4.hasNext() == false) goto L26;
        b r5 = (b) r4.next();
        r5.getClass();
        HashMap r8 = new HashMap();
        String r9 = r5.a;     // Catch: Exception -> L23
        if (r9 != null) goto L12;
        r9 = "";
    L12:
        r8.put(ResourceData.KEY_TOKEN, r9);     // Catch: Exception -> L23
        String r10 = r5.b;     // Catch: Exception -> L23
        if (r10 != null) goto L15;
        r10 = "";
    L15:
        r8.put("title", r10);     // Catch: Exception -> L23
        String r11 = r5.c;     // Catch: Exception -> L23
        if (r11 != null) goto L18;
        r11 = "";
    L18:
        r8.put("owner", r11);     // Catch: Exception -> L23
        String r12 = r5.d;     // Catch: Exception -> L23
        if (r12 != null) goto L21;
        r12 = "";
    L21:
        r8.put("iconInfo", r12);     // Catch: Exception -> L23
        r8.put("totalSeconds", Float.valueOf(r5.e));     // Catch: Exception -> L23
        r8.put("currentSeconds", Float.valueOf(r5.f));     // Catch: Exception -> L23
        r8.put("enable", Boolean.valueOf(r5.g));     // Catch: Exception -> L23
        r8.put("highlight", Boolean.valueOf(r5.h));     // Catch: Exception -> L23
        r8.put("playing", Boolean.valueOf(r5.i));     // Catch: Exception -> L23
    L25:
        r2.add(r8);
    L23:
        e = move-exception;
        tt5.a.e("TtsLynxPlayListItemParams", "TtsLynxPlayListItemParams-toMap, error:", e, false);
        goto L25
    L26:
        HashMap<String, Serializable> r3 = new HashMap();
        r3.put("playingItem", r0);     // Catch: Exception -> L29
        r3.put("items", r2);     // Catch: Exception -> L29
    L31:
        return r3;
    L29:
        e = move-exception;
        tt5.a.e("TtsLynxPlayListItemParams", "TtsLynxPlaylistParams-toMap, error:", e, false);
        goto L31
    }

    public e() {
        this.b = new ArrayList();
    }
}
