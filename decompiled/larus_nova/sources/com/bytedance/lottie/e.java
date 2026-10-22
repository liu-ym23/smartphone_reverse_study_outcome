package com.bytedance.lottie;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.JsonReader;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.android.livesdkapi.depend.model.live.RoomIntroLabel;
import com.ss.android.lark.inv.export.router.InvRouter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, q<d>> f264439a = null;

    public static class a implements Callable<o<d>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ d f264440a;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public o<d> call() {
            return new o(this.f264440a);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ o<d> call() throws Exception {
            return call();
        }

        public a(d r100) {
            this.f264440a = r100;
        }
    }

    public static class b implements l<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f264441a;

        public b(String r100) {
            this.f264441a = r100;
        }

        @Override // com.bytedance.lottie.l
        public final void onResult(d r100) {
            d r101 = r100;
            String r102 = this.f264441a;
            if (r102 == null) goto L5;
            qz6.g.f535377b.f535378a.put(r102, r101);
        L5:
            Map<String, q<d>> r103 = e.f264439a;
            HashMap r104 = (HashMap) r103;
            r104.remove(this.f264441a);
        }
    }

    public static class c implements l<Throwable> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f264442a;

        public c(String r100) {
            this.f264442a = r100;
        }

        @Override // com.bytedance.lottie.l
        public final void onResult(Throwable r100) {
            Map<String, q<d>> r101 = e.f264439a;
            HashMap r102 = (HashMap) r101;
            r102.remove(this.f264442a);
        }
    }

    static {
        f264439a = new HashMap();
    }

    public static q<d> a(String r100, Callable<o<d>> r101) {
        qz6.g r102 = qz6.g.f535377b;
        if (r100 != null) goto L5;
        r102.getClass();
        d r103 = null;
    L6:
        if (r103 != null) goto L8;
        HashMap r104 = (HashMap) f264439a;
        if (r104.containsKey(r100) == true) goto L12;
        q<d> r105 = new q(r101);
        r105.c(new b(r100));
        r105.b(new c(r100));
        r104.put(r100, r105);
        return r105;
    L12:
        return (q) r104.get(r100);
    L8:
        return new q(new a(r103));
    L5:
        r103 = r102.f535378a.get(r100);
        goto L6
    }

    public static o<d> d(ZipInputStream r100, String r101) {
        HashMap r102 = new HashMap();
        ZipEntry r103 = r100.getNextEntry();     // Catch: IOException -> L45
        d r104 = null;
    L4:
        if (r103 == null) goto L17;
        if (r103.getName().contains("__MACOSX") == false) goto L9;
        r100.closeEntry();     // Catch: IOException -> L45
    L15:
        r103 = r100.getNextEntry();     // Catch: IOException -> L45
        goto L4
    L9:
        if (r103.getName().contains(InvRouter.FLOW_SUFFIX) == false) goto L12;
        r104 = b(r100, r101, false).f264578a;     // Catch: IOException -> L45
        goto L15
    L12:
        if (r103.getName().contains(RoomIntroLabel.ICON_URL_SUFFIX_DEFAULT) == false) goto L14;
        String[] r105 = r103.getName().split(HTTP.URL_DEFAULT);     // Catch: IOException -> L45
        r102.put(r105[r105.length - 1], BitmapFactory.decodeStream(r100));     // Catch: IOException -> L45
        goto L15
    L14:
        r100.closeEntry();     // Catch: IOException -> L45
        goto L15
    L17:
        if (r104 == null) goto L19;
        Iterator r106 = r102.entrySet().iterator();
    L22:
        if (r106.hasNext() == false) goto L32;
        Map.Entry r107 = (Map.Entry) r106.next();
        String r108 = (String) r107.getKey();
        Iterator<k> r109 = r104.f264427d.values().iterator();
    L25:
        if (r109.hasNext() == false) goto L29;
        k r110 = r109.next();
        if (r110.f264453a.equals(r108) == false) goto L25;
    L30:
        if (r110 == null) goto L22;
        r110.f264454b = (Bitmap) r107.getValue();
        goto L22
    L29:
        r110 = null;
        goto L30
    L32:
        Iterator<Map.Entry<String, k>> r111 = r104.f264427d.entrySet().iterator();
    L34:
        if (r111.hasNext() == false) goto L39;
        Map.Entry<String, k> r112 = r111.next();
        if (r112.getValue().f264454b != null) goto L34;
        return new o(new IllegalStateException("There is no image for " + r112.getValue().f264453a));
    L39:
        qz6.g r113 = qz6.g.f535377b;
        if (r101 != null) goto L42;
        r113.getClass();
    L44:
        return new o(r104);
    L42:
        r113.f535378a.put(r101, r104);
        goto L44
    L19:
        return new o(new IllegalArgumentException("Unable to parse composition"));
    L45:
        e = move-exception;
        return new o(e);
    }

    public static o<d> b(InputStream r100, String r101, boolean r102) {
        o<d> r103 = c(new JsonReader(new InputStreamReader(r100)), r101, false);     // Catch: Throwable -> L6
        if (r102 == false) goto L5;
        wz6.h.c(r100);
    L5:
        return r103;
    L6:
        th = move-exception;
        if (r102 == false) goto L9;
        wz6.h.c(r100);
    L9:
        throw th;
    }

    public static o<d> c(JsonReader r100, String r101, boolean r102) {
        d r103 = vz6.n.a(r100);     // Catch: Throwable -> L5
        qz6.g r104 = qz6.g.f535377b;     // Catch: Throwable -> L5
        if (r101 != null) goto L7;
        r104.getClass();     // Catch: Throwable -> L5
    L8:
        o<d> r105 = new o(r103);     // Catch: Throwable -> L5
        if (r102 == false) goto L11;
        wz6.h.c(r100);
    L11:
        return r105;
    L7:
        r104.f535378a.put(r101, r103);     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        o<d> r106 = new o(th);     // Catch: Throwable -> L16
        if (r102 == false) goto L15;
        wz6.h.c(r100);
    L15:
        return r106;
    L16:
        th = move-exception;
        if (r102 == false) goto L19;
        wz6.h.c(r100);
    L19:
        throw th;
    }
}
