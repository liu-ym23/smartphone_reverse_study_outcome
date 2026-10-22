package com.lynx.tasm.fontface;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.bytedance.sysoptimizer.TypeFaceLancet;
import com.bytedance.sysoptimizer.TypeFaceOptimizer;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxError;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.TraceEvent;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.core.LynxThreadPool;
import com.lynx.tasm.provider.LynxResourceRequest;
import com.lynx.tasm.utils.CallStackUtil;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.tasm.utils.m;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import d8a.k;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes32.dex */
public final class FontFaceManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, h> f383380a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f383381b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, com.lynx.tasm.fontface.a> f383382c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<com.lynx.tasm.fontface.g, Typeface> f383383d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ h f383384a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f383385b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Handler f383386c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.lynx.tasm.behavior.shadow.text.g.c f383387d;

        /* JADX INFO: renamed from: com.lynx.tasm.fontface.FontFaceManager$a$a, reason: collision with other inner class name */
        public class RunnableC4574a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Typeface f383388a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final /* synthetic */ a f383389b;

            @Override // java.lang.Runnable
            public final void run() {
                LLog.i("FontFaceManager", "Lynx load font success.");     // Catch: Throwable -> L4
                a r100 = this.f383389b;     // Catch: Throwable -> L4
                r100.f383387d.a(this.f383388a, r100.f383385b);     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }

            public RunnableC4574a(a r100, Typeface r101) {
                this.f383389b = r100;
                this.f383388a = r101;
            }
        }

        @Override // java.lang.Runnable
        public final void run() {
            Typeface r100 = this.f383384a.a(this.f383385b);     // Catch: Throwable -> L4
            this.f383386c.post(new RunnableC4574a(this, r100));     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(h r100, int r101, Handler r102, com.lynx.tasm.behavior.shadow.text.g.c r103) {
            this.f383384a = r100;
            this.f383385b = r101;
            this.f383386c = r102;
            this.f383387d = r103;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f383390a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f383391b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ com.lynx.tasm.behavior.shadow.text.g.c f383392c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h f383393d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Handler f383394e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FontFaceManager f383395f;

        public final void a() {
            LLog.i("Lynx", "load font success " + this.f383390a + this.f383391b);
            if (Build.VERSION.SDK_INT < 28) goto L5;
            this.f383392c.a(this.f383393d.a(this.f383391b), this.f383391b);
            return;
        L5:
            FontFaceManager r100 = this.f383395f;
            Handler r101 = this.f383394e;
            com.lynx.tasm.behavior.shadow.text.g.c r102 = this.f383392c;
            h r103 = this.f383393d;
            int r104 = this.f383391b;
            r100.getClass();
            FontFaceManager.h(r101, r102, r103, r104);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(FontFaceManager r100, String r101, int r102, com.lynx.tasm.behavior.shadow.text.g.c r103, h r104, Handler r105) {
            this.f383395f = r100;
            this.f383390a = r101;
            this.f383391b = r102;
            this.f383392c = r103;
            this.f383393d = r104;
            this.f383394e = r105;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxContext f383396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ FontFace f383397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ int f383398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.lynx.tasm.behavior.shadow.text.g.c f383399d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Handler f383400e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ FontFaceManager f383401f;

        public final void a() {
            FontFaceManager r100 = this.f383401f;
            LynxContext r101 = this.f383396a;
            FontFace r102 = this.f383397b;
            int r103 = this.f383398c;
            com.lynx.tasm.behavior.shadow.text.g.c r104 = this.f383399d;
            Handler r105 = this.f383400e;
            h r106 = r100.f(r102);
            if (r106 == null) goto L11;
            r102.f383378b = r106;
            r100.c(r102, r106);
            if (r104 != null) goto L8;
            return;
        L8:
            if (Build.VERSION.SDK_INT < 28) goto L10;
            r105.post(new com.lynx.tasm.fontface.d(r104, r106.a(r103), r103));
            return;
        L10:
            FontFaceManager.h(r105, r104, r106, r103);
            return;
        L11:
            Object r107 = r100.f383381b;
            monitor-enter(r107);
            h r108 = r100.f(r102);     // Catch: Throwable -> L25
            if (r108 == null) goto L27;
            r102.f383378b = r108;     // Catch: Throwable -> L25
            r100.c(r102, r108);     // Catch: Throwable -> L25
            if (r104 != null) goto L20;
            monitor-exit(r107);     // Catch: Throwable -> L25
            return;
        L20:
            if (Build.VERSION.SDK_INT < 28) goto L22;
            r105.post(new com.lynx.tasm.fontface.e(r104, r108.a(r103), r103));     // Catch: Throwable -> L25
        L23:
            monitor-exit(r107);     // Catch: Throwable -> L25
            return;
        L22:
            FontFaceManager.h(r105, r104, r108, r103);     // Catch: Throwable -> L25
            goto L23
        L27:
            com.lynx.tasm.fontface.a r109 = r100.e(r102);     // Catch: Throwable -> L25
            if (r109 == null) goto L32;
            r109.f383412b.add(r102);     // Catch: Throwable -> L25
            Pair<com.lynx.tasm.behavior.shadow.text.g.c, Integer> r110 = new Pair(r104, Integer.valueOf(r103));     // Catch: Throwable -> L25
            r109.f383411a.offer(r110);     // Catch: Throwable -> L25
            monitor-exit(r107);     // Catch: Throwable -> L25
            return;
        L32:
            com.lynx.tasm.fontface.a r111 = new com.lynx.tasm.fontface.a();     // Catch: Throwable -> L25
            Pair<com.lynx.tasm.behavior.shadow.text.g.c, Integer> r112 = new Pair(r104, Integer.valueOf(r103));     // Catch: Throwable -> L25
            r111.f383411a.offer(r112);     // Catch: Throwable -> L25
            r111.f383412b.add(r102);     // Catch: Throwable -> L25
            Iterator r113 = ((ArrayList) r102.f383377a).iterator();     // Catch: Throwable -> L25
        L34:
            if (r113.hasNext() == false) goto L43;
            Pair r114 = (Pair) r113.next();     // Catch: Throwable -> L25
            if (r114 == null) goto L34;
            Object r115 = r114.first;     // Catch: Throwable -> L25
            if (r115 == null) goto L34;
            Object r116 = r114.second;     // Catch: Throwable -> L25
            if (r116 == null) goto L34;
            Map<String, com.lynx.tasm.fontface.a> r117 = r100.f383382c;     // Catch: Throwable -> L25
            HashMap r118 = (HashMap) r117;     // Catch: Throwable -> L25
            r118.put(FontFaceManager.o((FontFace.TYPE) r115, (String) r116), r111);     // Catch: Throwable -> L25
            goto L34
        L43:
            monitor-exit(r107);     // Catch: Throwable -> L25
            Iterator<Pair<FontFace.TYPE, String>> r119 = ((ArrayList) r102.f383377a).iterator();
            Iterator<Pair<FontFace.TYPE, String>> r120 = ((ArrayList) r102.f383377a).iterator();
            if (r101.getGenericResourceFetcher() == null) goto L47;
            TraceEvent.beginSection("FontFaceManager.loadTypefaceWithGenericLynxResourceFetcher");
            LLog.i("FontFaceManager", "Try to loadTypeface with GenericLynxResourceFetcher.");
            r100.k(r101, r111, r119, r120, r105);
            TraceEvent.endSection("FontFaceManager.loadTypefaceWithGenericLynxResourceFetcher");
            return;
        L47:
            TraceEvent.beginSection("FontFaceManager.loadTypeface");
            r100.j(r101, r111, r119, r105);
            TraceEvent.endSection("FontFaceManager.loadTypeface");
            return;
        L25:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(FontFaceManager r100, LynxContext r101, FontFace r102, int r103, com.lynx.tasm.behavior.shadow.text.g.c r104, Handler r105) {
            this.f383401f = r100;
            this.f383396a = r101;
            this.f383397b = r102;
            this.f383398c = r103;
            this.f383399d = r104;
            this.f383400e = r105;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.lynx.tasm.fontface.a f383402a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ h f383403b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Handler f383404c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FontFaceManager f383405d;

        public final void a() {
            com.lynx.tasm.fontface.a r100 = this.f383402a;
            r100.getClass();
            ArrayList r101 = new ArrayList();
        L3:
            Pair<com.lynx.tasm.behavior.shadow.text.g.c, Integer> r102 = r100.f383411a.poll();
            if (r102 == null) goto L6;
            r101.add(r102);
            goto L3
        L6:
            Iterator r103 = r101.iterator();
        L8:
            if (r103.hasNext() == false) goto L16;
            Pair r104 = (Pair) r103.next();
            Object r105 = r104.first;
            if (r105 == null) goto L8;
            if (Build.VERSION.SDK_INT >= 28) goto L14;
            FontFaceManager r106 = this.f383405d;
            h r107 = this.f383403b;
            int r108 = ((Integer) r104.second).intValue();
            r106.getClass();
            FontFaceManager.h(this.f383404c, (com.lynx.tasm.behavior.shadow.text.g.c) r105, r107, r108);
            goto L8
        L14:
            LLog.i("Lynx", "load font success");
            ((com.lynx.tasm.behavior.shadow.text.g.c) r104.first).a(this.f383403b.a(((Integer) r104.second).intValue()), ((Integer) r104.second).intValue());
            goto L8
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(FontFaceManager r100, com.lynx.tasm.fontface.a r101, h r102, Handler r103) {
            this.f383405d = r100;
            this.f383402a = r101;
            this.f383403b = r102;
            this.f383404c = r103;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ com.lynx.tasm.fontface.a f383406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Handler f383407b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ h f383408c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ FontFaceManager f383409d;

        public final void a() {
            com.lynx.tasm.fontface.a r100 = this.f383406a;
            r100.getClass();
            ArrayList r101 = new ArrayList();
        L3:
            Pair<com.lynx.tasm.behavior.shadow.text.g.c, Integer> r102 = r100.f383411a.poll();
            if (r102 == null) goto L6;
            r101.add(r102);
            goto L3
        L6:
            Iterator r103 = r101.iterator();
        L8:
            if (r103.hasNext() == false) goto L20;
            Pair r104 = (Pair) r103.next();
            Object r105 = r104.first;
            if (r105 == null) goto L8;
            FontFaceManager r106 = this.f383409d;
            Handler r107 = this.f383407b;
            com.lynx.tasm.behavior.shadow.text.g.c r108 = (com.lynx.tasm.behavior.shadow.text.g.c) r105;
            h r109 = this.f383408c;
            Integer r110 = (Integer) r104.second;
            r106.getClass();
            if (r110 != null) goto L15;
            int r111 = 0;
        L17:
            if (Build.VERSION.SDK_INT >= 28) goto L18;
            FontFaceManager.h(r107, r108, r109, r111);
            goto L8
        L18:
            LLog.i("FontFaceManager", "Lynx load font success.");
            r108.a(r109.a(r111), r111);
            goto L8
        L15:
            r111 = r110.intValue();
            goto L17
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(FontFaceManager r100, com.lynx.tasm.fontface.a r101, Handler r102, h r103) {
            this.f383409d = r100;
            this.f383406a = r101;
            this.f383407b = r102;
            this.f383408c = r103;
        }
    }

    public interface f {
    }

    public static class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final FontFaceManager f383410a = null;

        static {
            f383410a = new FontFaceManager();
        }
    }

    public FontFaceManager() {
        this.f383380a = new ConcurrentHashMap();
        this.f383381b = new Object();
        this.f383382c = new HashMap();
        final float r100 = 0.75f;
        final boolean r101 = true;
        final int r102 = 16;
        this.f383383d = Collections.synchronizedMap(new AnonymousClass1(this, r102, r100, r101));
    }

    public final com.lynx.tasm.fontface.a e(FontFace r100) {
        Iterator r101 = ((ArrayList) r100.f383377a).iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        Pair r102 = (Pair) r101.next();
        if (r102 == null) goto L4;
        Object r103 = r102.first;
        if (r103 == null) goto L4;
        Object r104 = r102.second;
        if (r104 == null) goto L4;
        Map<String, com.lynx.tasm.fontface.a> r105 = this.f383382c;
        HashMap r106 = (HashMap) r105;
        com.lynx.tasm.fontface.a r107 = (com.lynx.tasm.fontface.a) r106.get(o((FontFace.TYPE) r103, (String) r104));
        if (r107 == null) goto L4;
        return r107;
    L15:
        return null;
    }

    public final h f(FontFace r100) {
        Iterator r101 = ((ArrayList) r100.f383377a).iterator();
    L4:
        if (r101.hasNext() == false) goto L15;
        Pair r102 = (Pair) r101.next();
        if (r102 == null) goto L4;
        Object r103 = r102.first;
        if (r103 == null) goto L4;
        Object r104 = r102.second;
        if (r104 == null) goto L4;
        Map<String, h> r105 = this.f383380a;
        ConcurrentHashMap r106 = (ConcurrentHashMap) r105;
        h r107 = (h) r106.get(o((FontFace.TYPE) r103, (String) r104));
        if (r107 == null) goto L4;
        return r107;
    L15:
        return null;
    }

    public final void l(com.lynx.tasm.fontface.a r100) {
        Object r101 = this.f383381b;
        monitor-enter(r101);
        p(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void p(com.lynx.tasm.fontface.a r100) {
        Iterator r101 = ((HashMap) this.f383382c).entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        if (((Map.Entry) r101.next()).getValue() != r100) goto L4;
        r101.remove();
        goto L4
    }

    public static Typeface d(String r100, LynxContext r101) {
    L13:
        e = move-exception;
        n(30205, "Create typeface from local path failed", r100, e, r101);
        return null;
    L3:
        if (TypeFaceOptimizer.getSwitch() == false) goto L11;
        if (r100 == null) goto L11;
        if (TypeFaceLancet.cache.contains(r100) == false) goto L8;
        Typeface r102 = (Typeface) TypeFaceLancet.cache.get(r100);     // Catch: RuntimeException -> L13
    L16:
        return r102;
    L8:
        r102 = Typeface.createFromFile(r100);     // Catch: RuntimeException -> L13
        if (r102 == null) goto L11;
        TypeFaceLancet.cache.put(r100, r102);     // Catch: RuntimeException -> L13
    L11:
        r102 = Typeface.createFromFile(r100);     // Catch: RuntimeException -> L13
        goto L16
    }

    public static String o(FontFace.TYPE r100, String r101) {
        return r100.name() + r101;
    }

    public final void b(String r100, Typeface r101) {
        h r102 = new h(r101);
        ((ConcurrentHashMap) this.f383380a).put(o(FontFace.TYPE.URL, r100), r102);
        LLog.i("FontFaceManager", "prefetchFont success: " + r100);
    }

    public final void c(FontFace r100, h r101) {
        Iterator r102 = ((ArrayList) r100.f383377a).iterator();
    L4:
        if (r102.hasNext() == false) goto L13;
        Pair r103 = (Pair) r102.next();
        if (r103 == null) goto L4;
        Object r104 = r103.first;
        if (r104 == null) goto L4;
        Object r105 = r103.second;
        if (r105 == null) goto L4;
        Map<String, h> r106 = this.f383380a;
        ConcurrentHashMap r107 = (ConcurrentHashMap) r106;
        r107.put(o((FontFace.TYPE) r104, (String) r105), r101);
        goto L4
    }

    public static Typeface i(LynxContext r100, FontFace.TYPE r101, String r102) {
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return null;
    L5:
        if (r101 == FontFace.TYPE.LOCAL) goto L23;
        int r103 = r102.indexOf("base64,");
        if (r102.startsWith(fyb.a.KEY_DATA) == true) goto L10;
        return null;
    L10:
        if (r103 != (-1)) goto L19;
        return null;
    L19:
        return m.c(r100, Base64.decode(r102.substring(r103 + 7), 0));
    L15:
        e = move-exception;
        n(30203, "Error when parsing base64 resource", r102, e, r100);
        return null;
    L23:
        return null;
    }

    public final void m(LynxContext r100, String r101, LynxResourceModule.e r102) {
        if (TextUtils.isEmpty(r101) == false) goto L7;
        if (r102 == null) goto L9;
        ((LynxResourceModule.c) r102.f381341a).a(32101, "url is empty");
        return;
    L9:
        return;
    L7:
        LynxThreadPool.b().execute(new com.lynx.tasm.fontface.c(this, r101, r100, r102));
    }

    public static void a(FontFaceManager r100, LynxContext r101, String r102, f r103) {
        r100.getClass();
        int r104 = 32101;
        Typeface r105 = w7a.a.a(r101).a(r101, FontFace.TYPE.URL, r102);     // Catch: Exception -> L9
        if (r105 == null) goto L7;
        r100.b(r102, r105);     // Catch: Exception -> L9
        String r106 = "";
        r104 = 0;
    L11:
        if (r103 == null) goto L16;
        ((LynxResourceModule.c) ((LynxResourceModule.e) r103).f381341a).a(r104, r106);
        return;
    L16:
        return;
    L7:
        r106 = "loadFontFace failed";
    L9:
        e = move-exception;
        r106 = "prefetchFont with loader failed: " + e.getMessage();
        LLog.e("FontFaceManager", r106);
        goto L11
    }

    public static void h(Handler r100, com.lynx.tasm.behavior.shadow.text.g.c r101, h r102, int r103) {
        UIThreadUtils.runOnUiThreadImmediately(new a(r102, r103, r100, r101));
    }

    public final Typeface g(LynxContext r110, String r111, int r112, com.lynx.tasm.behavior.shadow.text.g.c r113) {
        FontFace r100 = r110.getFontFace(r111);
        if (r100 != null) goto L5;
        return null;
    L5:
        h r101 = f(r100);
        if (r101 != null) goto L8;
    L14:
        h r102 = r100.f383378b;
        Handler r103 = new Handler(Looper.myLooper());
        if (r102 == null) goto L24;
        if (r113 == null) goto L19;
        r103.post(new b(this, r111, r112, r113, r102, r103));
    L19:
        if (Build.VERSION.SDK_INT < 28) goto L23;
        return r102.a(r112);
    L23:
        return r102.a(0);
    L24:
        LynxThreadPool.b().execute(new c(this, r110, r100, r112, r113, r103));
        return null;
    L8:
        if (r101.f383438b[r112] == null) goto L10;
        boolean r104 = true;
    L11:
        if (r104 == false) goto L14;
        return r101.a(r112);
    L10:
        r104 = false;
        goto L11
    }

    public final void j(LynxContext r100, com.lynx.tasm.fontface.a r110, Iterator<Pair<FontFace.TYPE, String>> r111, Handler r112) {
        if (r111.hasNext() == true) goto L6;
        l(r110);
        return;
    L6:
        Pair<FontFace.TYPE, String> r101 = r111.next();
        d8a.f r102 = r100.getProviderRegistry();
        r102.getClass();
        Typeface r103 = null;
        if (TextUtils.isEmpty("FONT") == false) goto L9;
        k r104 = null;
    L10:
        if (r104 != null) goto L12;
    L27:
        if (r103 != null) goto L29;
        r103 = w7a.a.a(r100).a(r100, (FontFace.TYPE) r101.first, (String) r101.second);
    L29:
        if (r103 != null) goto L32;
        j(r100, r110, r111, r112);
        return;
    L32:
        h r105 = new h(r103);
        Object r113 = this.f383381b;
        monitor-enter(r113);
        Iterator<FontFace> r106 = r110.f383412b.iterator();     // Catch: Throwable -> L48
    L36:
        if (r106.hasNext() == false) goto L38;
        FontFace r107 = r106.next();     // Catch: Throwable -> L48
        r107.f383378b = r105;     // Catch: Throwable -> L48
        c(r107, r105);     // Catch: Throwable -> L48
        goto L36
    L38:
        p(r110);     // Catch: Throwable -> L48
        monitor-exit(r113);     // Catch: Throwable -> L48
        if (Build.VERSION.SDK_INT < 28) goto L46;
        Iterator r114 = new ArrayList(r110.f383411a).iterator();
    L44:
        if (r114.hasNext() == false) goto L46;
        r105.a(((Integer) ((Pair) r114.next()).second).intValue());
    L46:
        r112.post(new d(this, r110, r105, r112));
        return;
    L48:
        th = move-exception;
        throw th;
    L12:
        if (((String) r101.second).startsWith(fyb.a.KEY_DATA) == true) goto L27;
        FontFace.TYPE r108 = (FontFace.TYPE) r101.first;
        String r109 = (String) r101.second;
        String[] r115 = new String[1];
        Bundle r116 = new Bundle();
        r116.putString("type", r108.toString());
        r104.request(new LynxResourceRequest(r109, r116), new com.lynx.tasm.fontface.f(this, r115, r109, r100));
        String r117 = r115[0];
        if (r117 == null) goto L27;
        if (r117.startsWith("https") == false) goto L19;
        r103 = w7a.a.a(r100).a(r100, FontFace.TYPE.URL, r117);
        goto L27
    L19:
        if (r117.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == false) goto L22;
        r103 = d(r117.substring(7), r100);
        goto L27
    L22:
        if (r117.startsWith("asset:///") == false) goto L27;
        r103 = Typeface.createFromAsset(LynxEnv.inst().getAppContext().getAssets(), r117.substring(9));     // Catch: RuntimeException -> L25
    L25:
        e = move-exception;
        n(30205, "Create typeface from local asset failed", r117, e, r100);
        goto L27
    L9:
        r104 = (k) ((HashMap) r102.f467438a).get("FONT");
        goto L10
    }

    public static void n(int r100, String r101, String r102, Exception r103, LynxContext r104) {
        LynxError r105 = new LynxError(r100, r101);
        if (r103 == null) goto L5;
        r105.setCallStack(CallStackUtil.a(r103));
        LLog.e("FontFaceManager", r103.getMessage());
    L6:
        r104.reportResourceError(r102, LynxResourceModule.FONT_TYPE, r105);
        return;
    L5:
        LLog.e("FontFaceManager", r101 + ",src:" + r102);
        goto L6
    }

    public final void k(LynxContext r110, com.lynx.tasm.fontface.a r111, Iterator<Pair<FontFace.TYPE, String>> r210, Iterator<Pair<FontFace.TYPE, String>> r211, Handler r212) {
        if (r210.hasNext() == true) goto L6;
        LLog.w("FontFaceManager", "load typeface with GenericLynxResourceFetcher failed, try loadTypeface.");
        j(r110, r111, r211, r212);
        return;
    L6:
        Pair<FontFace.TYPE, String> r100 = r210.next();
        String r112 = (String) r100.second;
        if (TextUtils.isEmpty(r112) == false) goto L9;
    L38:
        Typeface r101 = null;
    L39:
        Typeface r113 = r101;
    L40:
        if (r113 != null) goto L43;
        k(r110, r111, r210, r211, r212);
        return;
    L43:
        LLog.i("FontFaceManager", "Lynx load typeface with GenericLynxResourceFetcher success.");
        h r102 = new h(r113);
        Object r103 = this.f383381b;
        monitor-enter(r103);
        Iterator<FontFace> r104 = r111.f383412b.iterator();     // Catch: Throwable -> L59
    L47:
        if (r104.hasNext() == false) goto L49;
        FontFace r105 = r104.next();     // Catch: Throwable -> L59
        r105.f383378b = r102;     // Catch: Throwable -> L59
        c(r105, r102);     // Catch: Throwable -> L59
        goto L47
    L49:
        p(r111);     // Catch: Throwable -> L59
        monitor-exit(r103);     // Catch: Throwable -> L59
        if (Build.VERSION.SDK_INT < 28) goto L57;
        Iterator r106 = new ArrayList(r111.f383411a).iterator();
    L55:
        if (r106.hasNext() == false) goto L57;
        r102.a(((Integer) ((Pair) r106.next()).second).intValue());
    L57:
        r212.post(new e(this, r111, r212, r102));
        return;
    L59:
        th = move-exception;
        throw th;
    L9:
        if (FontFace.TYPE.LOCAL != r100.first) goto L14;
        if (r112.startsWith(MSkiaImageRegionDecoder.FILE_PREFIX) == false) goto L38;
        r113 = d(r112.substring(7), r110);
        goto L40
    L14:
        if (r112.startsWith(fyb.a.KEY_DATA) == false) goto L19;
        if (r112.contains("base64,") == false) goto L19;
        r113 = i(r110, (FontFace.TYPE) r100.first, r112);
    L19:
        if (r112.startsWith("http") == false) goto L37;
        com.lynx.tasm.resourceprovider.LynxResourceRequest r107 = new com.lynx.tasm.resourceprovider.LynxResourceRequest(r112, com.lynx.tasm.resourceprovider.LynxResourceRequest.LynxResourceType.LynxResourceTypeFont);
        com.lynx.tasm.resourceprovider.LynxResourceRequest.AsyncMode r108 = com.lynx.tasm.resourceprovider.LynxResourceRequest.AsyncMode.EXACTLY_ASYNC;
        f8a.a r114 = r110.getGenericResourceFetcher();
        AtomicReference r115 = new AtomicReference();
        CountDownLatch r109 = new CountDownLatch(1);
        if (r114 == null) goto L62;
        r114.a(r107, new com.lynx.tasm.fontface.b(this, r115, r112, r110, r109));
    L62:
    L35:
        e = move-exception;
        ThreadMethodProxy.currentThread().interrupt();
        n(30202, "Load font with genericResourceFetcher failed", r112, e, r110);
        goto L38
    L26:
        if (r109.await(30, TimeUnit.SECONDS) == true) goto L29;
        n(30202, "Load font with genericResourceFetcher failed:request timeout", r112, null, r110);     // Catch: InterruptedException -> L35
        goto L38
    L29:
        byte[] r116 = (byte[]) r115.get();
        if (r116 == null) goto L38;
        if (r116.length == 0) goto L38;
        r113 = m.c(r110, r116);
        goto L40
    L37:
        r101 = null;
        n(30201, "Src format is incorrect", r112, null, r110);
        goto L39
    }
}
