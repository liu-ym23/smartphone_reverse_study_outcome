package com.lynx.tasm.navigator;

import android.content.Context;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.jsbridge.LynxMethod;
import com.lynx.jsbridge.LynxModule;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.utils.UIThreadUtils;
import java.util.HashMap;
import x7a.f;
import x7a.g;
import x7a.h;

/* JADX INFO: loaded from: classes32.dex */
public class NavigationModule extends LynxModule {
    public static String NAME = "NavigationModule";

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReadableMap f383501a;

        @Override // java.lang.Runnable
        public final void run() {
            g r100 = g.f562863d;     // Catch: Throwable -> L6
            ReadableMap r101 = this.f383501a;     // Catch: Throwable -> L6
            x7a.d r102 = r100.a();     // Catch: Throwable -> L6
            if (r102 == null) goto L9;
            r102.f562858c = r101.asHashMap();     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public a(ReadableMap r100) {
            this.f383501a = r100;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReadableMap f383502a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f383503b;

        @Override // java.lang.Runnable
        public final void run() {
            HashMap<String, Object> r100 = new HashMap();     // Catch: Throwable -> L7
            ReadableMap r101 = this.f383502a;     // Catch: Throwable -> L7
            if (r101 == null) goto L5;
            r100 = r101.asHashMap();     // Catch: Throwable -> L7
        L5:
            g.f562863d.c(this.f383503b, r100);     // Catch: Throwable -> L7
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public b(ReadableMap r100, String r101) {
            this.f383502a = r100;
            this.f383503b = r101;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ReadableMap f383504a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f383505b;

        public final void a() {
            HashMap<String, Object> r100 = new HashMap();
            ReadableMap r101 = this.f383504a;
            if (r101 == null) goto L5;
            r100 = r101.asHashMap();
        L5:
            g r102 = g.f562863d;
            String r103 = this.f383505b;
            r102.getClass();
            if (TextUtils.isEmpty(r103) == true) goto L19;
            x7a.d r104 = r102.a();
            if (r104 == null) goto L20;
            HashMap<String, Object> r105 = r104.f562858c;
            if (r105 == null) goto L14;
            Object r106 = r105.get(r103);
            if ((r106 instanceof String) == false) goto L14;
            String r107 = (String) r106;
        L15:
            h r108 = new h(r107, r100);
            x7a.b r109 = new x7a.b(r104, r108, r103);
            f r110 = r104.b();
            if (r110 == null) goto L21;
            r110.j(r108, new x7a.c(r104, r108, r109));
            return;
        L21:
            return;
        L14:
            r107 = r103;
            goto L15
        L20:
            return;
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

        public c(ReadableMap r100, String r101) {
            this.f383504a = r100;
            this.f383505b = r101;
        }
    }

    public class d implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            g.f562863d.b();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d() {
        }
    }

    @LynxMethod
    public void goBack() {
        UIThreadUtils.runOnUiThread(new d());
    }

    @LynxMethod
    public String getString() {
        return NAME;
    }

    public NavigationModule(Context r100) {
        super(r100);
    }

    @LynxMethod
    public void registerRoute(ReadableMap r100) {
        UIThreadUtils.runOnUiThread(new a(r100));
    }

    public NavigationModule(Context r100, Object r101) {
        super(r100, r101);
    }

    @LynxMethod
    public void navigateTo(String r100, ReadableMap r101) {
        UIThreadUtils.runOnUiThread(new b(r101, r100));
    }

    @LynxMethod
    public void replace(String r100, ReadableMap r101) {
        UIThreadUtils.runOnUiThread(new c(r101, r100));
    }
}
