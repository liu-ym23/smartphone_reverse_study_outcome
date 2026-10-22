package com.bytedance.ee.bear.document;

import android.content.Context;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.bitable.toast.ToastModel;
import com.bytedance.ee.bear.bizwidget.sharepermissiondialog.BottomPopupData;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.lark.utils.LarkContext;
import io.reactivex.Flowable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r2 implements com.bytedance.ee.bear.contract.n {
    public com.bytedance.ee.bear.rn.f a;
    public com.bytedance.ee.bear.rn.j b;
    public final Context c;

    @Override // com.bytedance.ee.bear.contract.n
    public final void o() {
        Context r0 = this.c;
        Map<String, Queue<View>> r1 = v05.e.a;
        tt5.a.h("DocumentViewCache", "clearViewCache");
        ((ConcurrentHashMap) v05.e.a).clear();
        v05.e.d(r0);
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final Flowable<Boolean> w() {
        tt5.a.h("DocsDataServiceImpl", "clearMemUserData()...");
        return Flowable.just(Boolean.TRUE).map(new n2()).map(new o2());
    }

    public final com.bytedance.ee.bear.rn.j x() {
        if (this.b != null) goto L6;
        this.b = (com.bytedance.ee.bear.rn.j) org.koin.java.a.a(com.bytedance.ee.bear.rn.j.class);
    L6:
        return this.b;
    }

    public r2() {
        this.c = LarkContext.getApplication();
        a35.y.e();
        com.bytedance.ee.util.ui.m.b(new j2(this), ToastModel.DEFAULT_DURATION);
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final List<String> f() {
        k25.e0 r0 = k25.e0.m();
        r0.getClass();
        return r0.q().e().c();
    L5:
        e = move-exception;
        iu5.d.c(e);
        return new ArrayList();
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final Flowable t() {
        return a35.y.e().d(10485760);
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final Flowable<Boolean> u() {
        final k25.e0 r0 = k25.e0.m();
        r0.getClass();
        return ((k25.a) LarkContext.spiByDwarf(k25.a.class)).m().observeOn(fo5.d.b()).map(new k25.e()).map(new k25.k(r0)).map(new k25.l(r0)).doOnError(new m2());
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void a(final long r4) {
        final k25.e0 r0 = k25.e0.m();
        r0.getClass();
        tt5.a.h("OfflineDataManager", "cleanUpTimeMills start. ");
        ((k25.a) LarkContext.spiByDwarf(k25.a.class)).m().observeOn(fo5.d.b()).map(new k25.e()).map(new k25.p(r0)).subscribe(new k25.w(r0, r4), new k25.x());
        tt5.a.h("DocsDataServiceImpl", "DocsDataServiceImpl.clearUpTimeMills, upTimeMills: " + r4 + ", cleanSize: 0");
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void b(kd5.c2.g r2) {
        if (x().h() == false) goto L5;
        r2.a();
    L5:
        x().b(r2);
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void c(List r2) {
        if (this.a != null) goto L5;
        this.a = (com.bytedance.ee.bear.rn.f) org.koin.java.a.a(com.bytedance.ee.bear.rn.f.class);
    L5:
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.isEmpty() == true) goto L12;
        this.a.c(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void d(String r2) {
        k25.e0.m().j(r2);
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void e(z45.j0.c r2) {
        x().e(r2);
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void g(List<OfflineDoc> r3) {
        y(r3, false, -1);
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void h(List r2) {
        if (this.a != null) goto L5;
        this.a = (com.bytedance.ee.bear.rn.f) org.koin.java.a.a(com.bytedance.ee.bear.rn.f.class);
    L5:
        if (r2 != null) goto L7;
        return;
    L7:
        if (r2.isEmpty() == true) goto L12;
        this.a.h(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void i(com.bytedance.ee.bear.contract.n.d r2) {
        x().i(r2);
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void k(com.bytedance.ee.bear.contract.n.a r3) {
        a35.y r0 = a35.y.e();
        if (r3 != null) goto L5;
        r0.getClass();
        return;
    L5:
        if (((ArrayList) r0.m).contains(r3) == true) goto L9;
        ((ArrayList) r0.m).add(r3);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void l(List<OfflineDoc> r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if (r2.isEmpty() == true) goto L9;
        a35.y.e().i(r2);
        return;
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void m(List<String> r2) {
        k25.e0.m().k(r2);
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void n(List<OfflineDoc> r3) {
        y(r3, true, -1);
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void p(com.bytedance.ee.bear.list.list.b.f r3) {
        a35.y r0 = a35.y.e();
        if (r3 != null) goto L5;
    L7:
        LiveData<List<String>> r1 = r0.h;
        if (r1 == null) goto L12;
        if (r3 == null) goto L13;
        r3.a((List) r1.getValue());
        return;
    L13:
        return;
    L12:
        return;
    L5:
        if (((ArrayList) r0.l).contains(r3) == true) goto L7;
        ((ArrayList) r0.l).add(r3);
        goto L7
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void r(final List<OfflineDoc> r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        if (r4.isEmpty() == true) goto L16;
        Long r0 = com.bytedance.ee.bear.document.offline.sync.h0.j;
        com.bytedance.ee.bear.document.offline.sync.h0 r1 = com.bytedance.ee.bear.document.offline.sync.h0.b.a;
        if (r1.g == false) goto L9;
        tt5.a.h("PreloadManager", "preloadClientVar disablePreload");
        return;
    L9:
        final com.bytedance.ee.bear.document.offline.sync.b0 r2 = r1.d;
        if (r2 == null) goto L15;
        Flowable.just(Boolean.TRUE).observeOn(fo5.d.a()).subscribe(new com.bytedance.ee.bear.document.offline.sync.v(r2, r4), new com.bytedance.ee.bear.document.offline.sync.w());
        return;
    L15:
        return;
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void s(com.bytedance.ee.bear.list.list.b.b r2) {
        a35.y r0 = a35.y.e();
        if (r2 == null) goto L5;
        ((ArrayList) r0.m).remove(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void v(com.bytedance.ee.bear.list.list.b.f r2) {
        a35.y r0 = a35.y.e();
        if (r2 == null) goto L5;
        ((ArrayList) r0.l).remove(r2);
        return;
    L5:
        r0.getClass();
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void j(final OfflineDoc r4, final kd5.f2 r5) {
        Flowable.just("").observeOn(fo5.d.e()).subscribe(new p2(this, r5, r4), new q2(r5, r4));
    }

    @Override // com.bytedance.ee.bear.contract.n
    public final void q(List<OfflineDoc> r2, int r3) {
        y(r2, false, r3);
    }

    public static void y(List r13, final boolean r14, final int r16) {
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;
        if (r0.g("ccm.mobile.preload_hit_optimization_enable") == false) goto L82;
        HashMap<String, HashMap<String, Integer>> r1 = j35.l.a;
        List r2 = r13;
        if (r2 != null) goto L7;
    L10:
        boolean r3 = true;
    L11:
        if (r3 == true) goto L82;
        HashMap<String, HashMap<String, Integer>> r4 = j35.l.a;
        if (r4 != null) goto L16;
    L19:
        boolean r5 = true;
    L20:
        if (r5 == true) goto L92;
    L45:
        HashMap<String, HashMap<String, Integer>> r6 = j35.l.a;
        if (r6.isEmpty() == true) goto L82;
        ArrayList r7 = new ArrayList();
        HashMap r8 = new HashMap();
        Iterator<Map.Entry<String, HashMap<String, Integer>>> r9 = r6.entrySet().iterator();
    L50:
        if (r9.hasNext() == false) goto L57;
        Map.Entry<String, HashMap<String, Integer>> r10 = r9.next();
        r8.put(r10.getKey(), new HashMap());
        Iterator<Map.Entry<String, Integer>> r11 = r10.getValue().entrySet().iterator();
    L53:
        if (r11.hasNext() == false) goto L50;
        Map.Entry<String, Integer> r12 = r11.next();
        HashMap r17 = (HashMap) r8.get(r10.getKey());
        if (r17 == null) goto L53;
        Integer r18 = (Integer) r17.put(r12.getKey(), r12.getValue());
        goto L53
    L57:
        Iterator r19 = r13.iterator();
    L59:
        if (r19.hasNext() == false) goto L81;
        OfflineDoc r20 = (OfflineDoc) r19.next();
        if (r8.containsKey(String.valueOf(r20.getType())) == false) goto L63;
        HashMap r21 = (HashMap) r8.get(String.valueOf(r20.getType()));
    L64:
        if (r21 != null) goto L66;
    L69:
        boolean r22 = true;
    L70:
        if (r22 == true) goto L59;
        Integer r23 = (Integer) r21.get(r20.getFrom_source());
        if (r23 == null) goto L74;
        int r24 = r23.intValue();
    L75:
        if (r24 <= 0) goto L59;
        r7.add(r20);
        String r26 = r20.getFrom_source();
        Integer r27 = (Integer) r21.get(r20.getFrom_source());
        if (r27 == null) goto L79;
        int r28 = r27.intValue();
    L80:
        r21.put(r26, Integer.valueOf(r28 - 1));
        goto L59
    L79:
        r28 = 0;
        goto L80
    L74:
        r24 = 0;
        goto L75
    L66:
        if (r21.isEmpty() == true) goto L69;
        r22 = false;
        goto L70
    L63:
        r21 = (HashMap) r8.get(BottomPopupData.Default);
        goto L64
    L81:
        final List r29 = r7;
    L83:
        if (r29 != null) goto L85;
        return;
    L85:
        if (r29.isEmpty() == true) goto L115;
        final long r30 = System.currentTimeMillis();
        hb5.a r110 = (hb5.a) org.koin.java.a.a(hb5.a.class);
        if (r110 == null) goto L90;
        r110.Sc().subscribe(new k2(r29, r30, r14, r16), new l2());
        return;
    L90:
        tt5.a.k("DocsDataServiceImpl", "appInitialize == null");
        return;
    L115:
        return;
    L92:
        JSONObject r31 = new JSONObject((String) r0.d("ccm_preload_source_disabled_config", ""));     // Catch: Exception -> L31
        Iterator<String> r32 = r31.keys();     // Catch: Exception -> L31
    L23:
        if (r32.hasNext() == false) goto L94;
        String r33 = r32.next();     // Catch: Exception -> L31
        JSONObject r34 = JSONObjectProtectorUtils.getJSONObject(r31, r33);     // Catch: Exception -> L31
        HashMap<String, Integer> r36 = new HashMap();     // Catch: Exception -> L31
        Iterator<String> r37 = r34.keys();     // Catch: Exception -> L31
    L27:
        if (r37.hasNext() == false) goto L29;
        String r38 = r37.next();     // Catch: Exception -> L31
        r36.put(r38, Integer.valueOf(r34.optInt(r38)));     // Catch: Exception -> L31
        goto L27
    L29:
        j35.l.a.put(r33, r36);     // Catch: Exception -> L31
    L94:
        JSONObject r39 = new JSONObject(((xm4.a.a) org.koin.java.a.c(xm4.a.a.class, null, null, 6)).b(t25.e.class.getName()));     // Catch: Exception -> L43
        Iterator<String> r40 = r39.keys();     // Catch: Exception -> L43
    L35:
        if (r40.hasNext() == false) goto L45;
        String r41 = r40.next();     // Catch: Exception -> L43
        JSONObject r42 = JSONObjectProtectorUtils.getJSONObject(r39, r41);     // Catch: Exception -> L43
        HashMap<String, Integer> r43 = new HashMap();     // Catch: Exception -> L43
        Iterator<String> r44 = r42.keys();     // Catch: Exception -> L43
    L39:
        if (r44.hasNext() == false) goto L41;
        String r46 = r44.next();     // Catch: Exception -> L43
        r43.put(r46, Integer.valueOf(r42.optInt(r46)));     // Catch: Exception -> L43
        goto L39
    L41:
        j35.l.a.put(r41, r43);     // Catch: Exception -> L43
    L43:
        e = move-exception;
        tt5.a.d("PreloadRemoveStrategy", "abJsonObject parser " + e.getMessage());
    L31:
        e = move-exception;
        tt5.a.d("PreloadRemoveStrategy", "settingString parser " + e.getMessage());
        goto L94
    L16:
        if (r4.isEmpty() == true) goto L19;
        r5 = false;
        goto L20
    L7:
        if (r2.isEmpty() == true) goto L10;
        r3 = false;
    L82:
        r29 = r13;
        goto L83
    }
}
