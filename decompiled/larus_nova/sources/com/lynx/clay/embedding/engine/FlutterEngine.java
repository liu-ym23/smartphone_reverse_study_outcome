package com.lynx.clay.embedding.engine;

import android.content.ClipboardManager;
import android.content.Context;
import com.bytedance.bpea.entry.common.DataType;
import com.lynx.clay.embedding.android.RenderMode;
import com.lynx.clay.embedding.engine.loader.FlutterLoader;
import com.lynx.clay.embedding.engine.loader.ImageLoader;
import com.lynx.clay.embedding.engine.plugins.ClayPluginContext;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import com.lynx.clay.plugin.platform.PlatformViewsController;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes32.dex */
public class FlutterEngine {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static ClipboardManager f380693i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FlutterJNI f380694a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlutterRenderer f380695b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ClayPluginContext f380696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.lynx.clay.embedding.engine.a f380697d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.lynx.clay.embedding.engine.accessibility.a f380698e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PlatformViewsController f380699f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Set<a> f380700g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RenderMode f380701h;

    public interface a {
        void a();

        void b();
    }

    public final void a() {
        c5a.c.e();
        Iterator r100 = ((HashSet) this.f380700g).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((a) r100.next()).a();
        goto L4
    L6:
        com.lynx.clay.embedding.engine.a r101 = this.f380697d;
        r101.getClass();
        c5a.c.e();
        Iterator r102 = new HashSet(((HashMap) r101.f380707a).keySet()).iterator();
    L8:
        if (r102.hasNext() == false) goto L24;
        Class r103 = (Class) r102.next();
        f5a.a r104 = (f5a.a) ((HashMap) r101.f380707a).get(r103);
        if (r104 == null) goto L8;
        r104.toString();
        c5a.c.e();
        if ((r104 instanceof g5a.a) == false) goto L15;
        ((HashMap) r101.f380708b).remove(r103);
    L15:
        if ((r104 instanceof q5a.a) == false) goto L18;
        ((HashMap) r101.f380709c).remove(r103);
    L18:
        if ((r104 instanceof i5a.a) == false) goto L21;
        ((HashMap) r101.f380710d).remove(r103);
    L21:
        if ((r104 instanceof j5a.a) == false) goto L23;
        ((HashMap) r101.f380711e).remove(r103);
    L23:
        r104.a();
        ((HashMap) r101.f380707a).remove(r103);
        goto L8
    L24:
        ((HashMap) r101.f380707a).clear();
        this.f380699f.onDetachedFromJNI();
        this.f380694a.detachFromNativeAndReleaseResources();
    }

    public FlutterJNI getFlutterJNI() {
        return this.f380694a;
    }

    public FlutterEngine(Context r110, String[] r111, boolean r112, boolean r113) {
        this(r110, c5a.b.a().f22526a, new FlutterJNI(), new PlatformViewsController(), r111, r112, r113);
    }

    public FlutterEngine(Context r100, FlutterLoader r101, FlutterJNI r102, PlatformViewsController r103, String[] r104, boolean r105, boolean r106) {
        this.f380700g = new HashSet();
        this.f380701h = null;
        this.f380698e = new com.lynx.clay.embedding.engine.accessibility.a();
        this.f380694a = r102;
        ClayPluginContext r107 = new ClayPluginContext();
        this.f380696c = r107;
        r102.setClayPluginContext(r107);
        if (f380693i != null) goto L5;
        f380693i = (ClipboardManager) r100.getApplicationContext().getSystemService(DataType.CLIPBOARD);
    L5:
        r102.setClipboardManager(f380693i);
        if (r101 != null) goto L9;
        r101 = c5a.b.a().f22526a;
    L9:
        if (r102.isAttached() == true) goto L11;
        Context r108 = r100.getApplicationContext();
        r101.getClass();
        r101.e(r108, new FlutterLoader.c());
        r101.a(r100, r104);
    L11:
        r102.setPlatformViewsController(r103);
        if (r102.isAttached() == true) goto L18;
        r102.attachToNative(false, r105, r106);
        if (r102.isAttached() == true) goto L18;
        throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
    L18:
        this.f380695b = new FlutterRenderer(r102);
        this.f380699f = r103;
        r103.onAttachedToJNI();
        r100.getApplicationContext();
        this.f380697d = new com.lynx.clay.embedding.engine.a(this);
        ImageLoader.Initialize(r100);
    }
}
