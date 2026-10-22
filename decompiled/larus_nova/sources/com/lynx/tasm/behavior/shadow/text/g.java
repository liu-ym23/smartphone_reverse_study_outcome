package com.lynx.tasm.behavior.shadow.text;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.text.TextUtils;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.fontface.FontFaceManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, Typeface[]> f382310a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Typeface, Typeface[]> f382311b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String[] f382312c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final String[] f382313d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f382314e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final List<b> f382315f = null;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Typeface f382316a;

        public a(Typeface r100) {
            this.f382316a = r100;
        }
    }

    public interface b {
        Typeface a(String r100, int r101);
    }

    public interface c {
        void a(Typeface r100, int r101);
    }

    public g() {
    }

    static {
        f382310a = new HashMap();
        f382311b = new HashMap();
        f382312c = new String[]{"", "_bold", "_italic", "_bold_italic"};
        f382313d = new String[]{".ttf", ".otf"};
        f382314e = new ConcurrentHashMap();
        f382315f = new ArrayList();
    }

    public static synchronized void a(b r100) {
        monitor-enter(g.class);
        ((ArrayList) f382315f).add(r100);     // Catch: Throwable -> L7
        monitor-exit(g.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized Typeface c(String r100, int r101) {
        monitor-enter(g.class);
        Typeface[] r102 = (Typeface[]) ((HashMap) f382310a).get(r100);     // Catch: Throwable -> L24
        if (r102 == null) goto L10;
        Typeface r103 = r102[r101];     // Catch: Throwable -> L24
        if (r103 == null) goto L10;
        monitor-exit(g.class);
        return r103;
    L10:
        Iterator r104 = ((ArrayList) f382315f).iterator();     // Catch: Throwable -> L24
    L12:
        if (r104.hasNext() == false) goto L21;
        b r105 = (b) r104.next();     // Catch: Throwable -> L24
        if (r105 == null) goto L12;
        Typeface r106 = r105.a(r100, r101);     // Catch: Throwable -> L24
        if (r106 == null) goto L12;
        b(r100, r101, r106);     // Catch: Throwable -> L24
        monitor-exit(g.class);
        return r106;
    L21:
        monitor-exit(g.class);
        return null;
    L24:
        th = move-exception;
        throw th;
    }

    public static synchronized void b(String r100, int r101, Typeface r102) {
        monitor-enter(g.class);
        Map<String, Typeface[]> r103 = f382310a;     // Catch: Throwable -> L10
        Typeface[] r104 = (Typeface[]) ((HashMap) r103).get(r100);     // Catch: Throwable -> L10
        if (r104 != null) goto L7;
        r104 = new Typeface[4];     // Catch: Throwable -> L10
        ((HashMap) r103).put(r100, r104);     // Catch: Throwable -> L10
    L7:
        r104[r101] = r102;     // Catch: Throwable -> L10
        ((HashMap) f382311b).put(r102, r104);     // Catch: Throwable -> L10
        monitor-exit(g.class);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public static synchronized Typeface d(LynxContext r100, String r101, int r102) {
        monitor-enter(g.class);
        String[] r103 = r101.split(",");     // Catch: Throwable -> L21
        int r104 = r103.length;     // Catch: Throwable -> L21
        int r105 = 0;
    L6:
        if (r105 >= r104) goto L18;
        String r106 = com.lynx.tasm.utils.c.d(r103[r105]);     // Catch: Throwable -> L21
        if (TextUtils.isEmpty(r106) == true) goto L17;
        Typeface r107 = c(r106, r102);     // Catch: Throwable -> L21
        if (r107 != null) goto L11;
        Typeface r108 = FontFaceManager.g.f383410a.g(r100, r106, r102, null);     // Catch: Throwable -> L21
        if (r108 == null) goto L17;
        monitor-exit(g.class);
        return r108;
    L11:
        monitor-exit(g.class);
        return r107;
    L17:
        r105 = r105 + 1;
        goto L6
    L18:
        LLog.v("TypefaceCache", "Can't not find typeface for fontFamily: " + r101 + " in lynx.");     // Catch: Throwable -> L21
        monitor-exit(g.class);
        return null;
    L21:
        th = move-exception;
        throw th;
    }

    public static Typeface e(AssetManager r100, String r101, int r102, String r103) {
        String r104 = r101 + r103 + r102;
        ConcurrentHashMap<String, a> r105 = f382314e;
        if (r105.containsKey(r104) == true) goto L5;
        String r106 = f382312c[r102];
        StringBuilder r107 = new StringBuilder(32);
        r107.append(r103);
        String r108 = HTTP.URL_DEFAULT;
        if (r103.endsWith(HTTP.URL_DEFAULT) == false) goto L9;
    L10:
        r108 = "";
    L11:
        r107.append(r108);
        r107.append(r101);
        r107.append(r106);
        int r109 = r107.length();
        String[] r110 = f382313d;
        int r111 = r110.length;
        int r112 = 0;
    L12:
        if (r112 >= r111) goto L20;
        String r113 = r110[r112];
        String r114 = r107.toString();
        if (r114.endsWith(r113) == true) goto L22;
        r107.append(r113);
        r114 = r107.toString();
    L22:
        Typeface r115 = Typeface.createFromAsset(r100, r114);     // Catch: RuntimeException -> L18
        f382314e.put(r104, new a(r115));     // Catch: RuntimeException -> L18
        return r115;
    L18:
        e = move-exception;
        LLog.w("TypefaceCache", "Exception happens whe cacheTypefaceFromAssets with message " + e.getMessage());
        r107.setLength(r109);
        r112 = r112 + 1;
        goto L12
    L20:
        f382314e.put(r104, new a(null));
        return null;
    L9:
        if (r103.equals("") == false) goto L11;
    L5:
        return r105.get(r104).f382316a;
    }
}
