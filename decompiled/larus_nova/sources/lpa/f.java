package lpa;

import android.content.Context;
import com.baidu.mapapi.http.HttpClient;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.huawei.hms.framework.common.ContainerUtils;
import com.lynx.base.memory.MemoryPressureCallback;
import com.lynx.clay.embedding.android.FlutterDelegateView;
import com.lynx.clay.embedding.android.FlutterFunctorView;
import com.lynx.clay.embedding.android.FlutterSurfaceView;
import com.lynx.clay.embedding.android.FlutterTextureView;
import com.lynx.clay.embedding.android.FlutterView;
import com.lynx.clay.embedding.android.RenderMode;
import com.lynx.clay.embedding.android.SurfaceSnapshotController;
import com.lynx.clay.embedding.engine.FlutterEngine;
import com.lynx.clay.embedding.engine.memory.MemoryPressureListener;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;
import com.lynx.clay.plugin.platform.PlatformViewsController;
import com.lynx.clay.relax.adaptor.RelaxAdaptor;
import com.relax.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public final class f implements rpa.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static a f510276e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.clay.embedding.android.d f510277a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RelaxAdaptor f510278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f510279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FlutterView f510280d;

    public final void c() {
        FlutterView r100 = this.f510280d;
        if (r100 == null) goto L5;
        r100.setKeyEventListener(null);
        this.f510280d.setResourceUrlInterceptor(null);
        this.f510280d = null;
    L5:
        FlutterEngine r101 = this.f510277a.f380643b;
        if (r101 == null) goto L8;
        r101.getFlutterJNI().setDevtoolsListener(null);
    L8:
        com.lynx.clay.embedding.android.d r102 = this.f510277a;
        r102.b();
        FlutterEngine r103 = r102.f380643b;
        if (r103 == null) goto L11;
        r103.getFlutterJNI().setTimingClient(null);
    L11:
        com.lynx.clay.embedding.android.d r104 = this.f510277a;
        r104.b();
        boolean r105 = false;
        r104.f380646e = false;
        r104.f380647f = false;
        r104.f380648g++;
        FlutterView r106 = r104.f380644c;
        if (r106 == null) goto L27;
        r106.removeCallbacks(r106.f380524k);
        SurfaceSnapshotController r107 = r106.f380519f;
        if (r107 == null) goto L20;
        FlutterSurfaceView r108 = r107.f380592b;
        r107.c();
        if (r108 == null) goto L19;
        r108.setSurfaceSnapshotDelegate(null);
    L19:
        r107.f380592b = null;
        r106.f380519f = null;
    L20:
        FlutterSurfaceView r109 = r106.f380514a;
        if (r109 == null) goto L23;
        r106.removeView(r109);
        r106.f380514a = null;
    L23:
        FlutterFunctorView r110 = r106.f380516c;
        if (r110 == null) goto L26;
        r110.g();
        r106.removeView(r106.f380516c);
        r106.f380516c = null;
    L26:
        r104.f380644c.b();
        FlutterView r111 = r104.f380644c;
        ((HashSet) r111.f380522i).remove(r104.f380651j);
        r104.f380644c = null;
    L27:
        r104.b();
        r104.f380646e = false;
        r104.f380647f = false;
        r104.f380648g++;
        if (r104.f380645d.f380655c == false) goto L45;
        FlutterEngine r112 = r104.f380643b;
        ArrayList r113 = (ArrayList) com.lynx.clay.embedding.android.d.C4545d.f380657a;
        if (r113.size() >= 4) goto L43;
        FlutterRenderer r114 = r112.f380695b;
        r114.f380933a.removeIsDisplayingFlutterUiListener(r114.f380937e);
        r112.f380694a.cleanForRecycle();
        r113.add(r112);
        if (com.lynx.clay.embedding.android.d.C4545d.f380658b == true) goto L42;
        MemoryPressureCallback r115 = new com.lynx.clay.embedding.android.f();
        Object r116 = com.lynx.clay.util.a.f380953a;
        if (MemoryPressureListener.f380749a != null) goto L39;
        MemoryPressureListener.f380749a = new ArrayList();
    L39:
        if (MemoryPressureListener.f380749a.contains(r115) == true) goto L41;
        MemoryPressureListener.f380749a.add(r115);
    L41:
        com.lynx.clay.embedding.android.d.C4545d.f380658b = true;
    L42:
        r105 = true;
    L43:
        if (r105 == true) goto L46;
        r104.f380643b.a();
    L46:
        r104.f380642a = null;
        r104.f380643b = null;
        r104.f380644c = null;
        RelaxAdaptor r117 = this.f510278b;
        if (r117 == null) goto L50;
        r117.b();
        this.f510278b = null;
        return;
    L50:
        return;
    L45:
        r104.f380643b.a();
        goto L46
    }

    public final FlutterView a(Context r100) {
        FlutterView r101 = this.f510280d;
        if (r101 == null) goto L5;
        r101.setKeyEventListener(null);
        this.f510280d.setResourceUrlInterceptor(null);
        this.f510280d = null;
    L5:
        com.lynx.clay.embedding.android.d r102 = this.f510277a;
        r102.b();
        r102.f380646e = false;
        r102.f380647f = false;
        r102.f380648g++;
        RenderMode r103 = r102.f380645d.f380654b;
        if (r103 != RenderMode.surface) goto L9;
        r102.f380644c = new FlutterView(r100, null, new FlutterSurfaceView(r100, null, true));
    L19:
        FlutterView r104 = r102.f380644c;
        ((HashSet) r104.f380522i).add(r102.f380651j);
        r102.f380644c.a(r102.f380643b);
        r102.f380650i.getClass();
        r102.f380650i.getClass();
        if (r102.f380647f == true) goto L23;
        r102.f380647f = true;
        com.lynx.clay.util.a.a().postDelayed(new com.lynx.clay.embedding.android.e(r102, r102.f380648g), 5000);
    L23:
        FlutterView r105 = r102.f380644c;
        this.f510280d = r105;
        if (r105 == null) goto L27;
        r105.setKeyboardEventStartCallback(new d(this));
    L27:
        return this.f510280d;
    L9:
        if (r103 != RenderMode.sync) goto L16;
        FlutterFunctorView r106 = r102.f380649h;
        if (r106 != null) goto L14;
        r106 = new FlutterFunctorView(r100);
    L14:
        r102.f380644c = new FlutterView(r100, r106);
        goto L19
    L16:
        if (r103 != RenderMode.delegate) goto L18;
        r102.f380644c = new FlutterView(r100, new FlutterDelegateView(r100));
        goto L19
    L18:
        r102.f380644c = new FlutterView(r100, new FlutterTextureView(r100));
        goto L19
    }

    public final void b(Context r210) {
        com.lynx.clay.embedding.android.d r100 = this.f510277a;
        r100.b();
        r100.f380642a = r210;
        if (r100.f380643b != null) goto L52;
        ArrayList r101 = new ArrayList();
        r100.f380645d.getClass();
        r100.f380645d.getClass();
        if (r100.f380645d.f380654b != RenderMode.sync) goto L7;
        r101.add("--enable-rendermode-sync");
        boolean r102 = true;
    L8:
        Iterator<Map.Entry<String, String>> r103 = r100.f380645d.f380656d.entrySet().iterator();
    L10:
        if (r103.hasNext() == false) goto L15;
        Map.Entry<String, String> r104 = r103.next();
        String r105 = r104.getKey();
        String r106 = r104.getValue();
        String r107 = HttpClient.ENDFLAG + r105;
        if (r106.isEmpty() == true) goto L14;
        r107 = r107 + ContainerUtils.KEY_VALUE_DELIMITER + r106;
    L14:
        r101.add(r107);
        goto L10
    L15:
        com.lynx.clay.embedding.android.d.c r108 = r100.f380645d;
        FlutterEngine r109 = null;
        if (r108.f380655c == false) goto L31;
        RenderMode r110 = r108.f380654b;
        ArrayList r111 = (ArrayList) com.lynx.clay.embedding.android.d.C4545d.f380657a;
        if (r111.size() == 0) goto L27;
        Iterator r112 = r111.iterator();
    L22:
        if (r112.hasNext() == false) goto L27;
        FlutterEngine r113 = (FlutterEngine) r112.next();
        RenderMode r114 = r113.f380701h;
        if (r114 == null) goto L26;
        if (r114 != r110) goto L22;
    L26:
        ((ArrayList) com.lynx.clay.embedding.android.d.C4545d.f380657a).remove(r113);
        r113.f380694a.prepareForRecycle();
        FlutterRenderer r115 = r113.f380695b;
        r115.f380933a.addIsDisplayingFlutterUiListener(r115.f380937e);
    L28:
        r100.f380643b = r113;
        if (r113 == null) goto L31;
        return;
    L27:
        r113 = null;
    L31:
        Context r116 = r100.f380642a;
        String[] r117 = (String[]) r101.toArray(new String[0]);
        HashMap r118 = (HashMap) com.lynx.clay.embedding.engine.c.f380716b;
        com.lynx.clay.embedding.engine.c r119 = (com.lynx.clay.embedding.engine.c) r118.get("relax_group");
        if (r119 != null) goto L35;
        r119 = new com.lynx.clay.embedding.engine.c(r116, r117);
        r118.put("relax_group", r119);
    L35:
        Context r120 = r100.f380642a;
        String[] r121 = (String[]) r101.toArray(new String[0]);
        boolean r122 = r100.f380645d.f380653a;
        Iterator r123 = ((ArrayList) r119.f380717a).iterator();
    L37:
        if (r123.hasNext() == false) goto L44;
        FlutterEngine r124 = (FlutterEngine) r123.next();
        if (r124.f380701h != RenderMode.sync) goto L41;
        boolean r125 = true;
    L42:
        if (r125 != r102) goto L37;
        r109 = r124;
        goto L37
    L41:
        r125 = false;
        goto L42
    L44:
        if (r109 != null) goto L47;
        FlutterEngine r126 = new FlutterEngine(r120, r121, r122, r102);
    L49:
        ((ArrayList) r119.f380717a).add(r126);
        ((HashSet) r126.f380700g).add(new com.lynx.clay.embedding.engine.b(r119, r126));
        r100.f380643b = r126;
        return;
    L47:
        if (r109.f380694a.isAttached() == false) goto L51;
        r126 = new FlutterEngine(r120, null, r109.f380694a.spawn(c5a.b.a().f22526a.f380722d.f380743a, PullConfiguration.PROCESS_NAME_MAIN), new PlatformViewsController(), null, false, false);
        goto L49
    L51:
        throw new IllegalStateException("Spawn can only be called on a fully constructed FlutterEngine");
    L7:
        r102 = false;
        goto L8
    }

    public f(Context r100, Object r101) {
        RenderMode r102 = RenderMode.sync;
        if ((r101 instanceof Map) == false) goto L14;
        Map r103 = (Map) r101;
        Object r104 = r103.get("renderMode");
        if (r104 != null) goto L7;
    L9:
        Object r105 = r103.get("recycleEngine");
        if (r105 == null) goto L14;
        if ((r105 instanceof Boolean) == false) goto L14;
        boolean r106 = ((Boolean) r105).booleanValue();
    L15:
        this.f510277a = new com.lynx.clay.embedding.android.d(r100, r102, r106);
        return;
    L7:
        if ((r104 instanceof RenderMode) == false) goto L9;
        r102 = (RenderMode) r104;
    L14:
        r106 = true;
        goto L15
    }
}
