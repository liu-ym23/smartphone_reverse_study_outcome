package com.bytedance.scene.group;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.scene.Scene;
import com.bytedance.scene.State;
import com.bytedance.scene.m;
import com.bytedance.scene.utlity.SceneInstanceUtility;
import com.bytedance.scene.utlity.SceneInternalException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public abstract class GroupScene extends Scene implements m {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final a f268654t = null;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final b f268655q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final List<qa7.e<na7.b, Boolean>> f268656r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f268657s;

    public static class a implements ja7.b {
        public a() {
        }
    }

    @Override // com.bytedance.scene.m
    public final void a() {
        this.f268657s = false;
    }

    @Override // com.bytedance.scene.Scene
    public final void p() {
        this.f268587e = null;
    }

    public abstract ViewGroup t0(LayoutInflater r100, ViewGroup r101, Bundle r102);

    public void u0() {
    }

    public void v0() {
    }

    public void w0() {
    }

    static {
        f268654t = new a();
    }

    @Override // com.bytedance.scene.Scene
    public final void L() {
        n0(State.STARTED);
        super.L();
    }

    @Override // com.bytedance.scene.Scene
    public final void P() {
        n0(State.ACTIVITY_CREATED);
        super.P();
    }

    @Override // com.bytedance.scene.Scene
    public final void m() {
        m0(State.NONE);
        super.m();
    }

    public GroupScene() {
        this.f268656r = new ArrayList();
        this.f268657s = true;
        this.f268655q = new b(this);
    }

    @Override // com.bytedance.scene.Scene
    public final void M() {
        super.M();
        n0(State.RESUMED);
        v0();
    }

    @Override // com.bytedance.scene.Scene
    public final void O() {
        super.O();
        n0(State.STARTED);
        w0();
    }

    @Override // com.bytedance.scene.m
    public final boolean c() {
        return this.f268657s;
    }

    @Override // com.bytedance.scene.Scene
    public final void l() {
        super.l();
    }

    @Override // com.bytedance.scene.Scene
    public final void o() {
        super.o();
    }

    @Override // com.bytedance.scene.Scene
    public final void N(Bundle r100) {
        super.N(r100);
    }

    @Override // com.bytedance.scene.Scene
    public void W(Bundle r110) {
        this.f268595m = true;
        if (r110 == null) goto L31;
        int r100 = 0;
        if (r110.getBoolean("bd-scene-group:support_restore", this.f268657s) == true) goto L8;
        this.f268657s = false;
    L8:
        if (this.f268657s == false) goto L35;
        b r101 = this.f268655q;
        Activity r102 = h0();
        com.bytedance.scene.group.a r103 = r101.f268679c;
        List<GroupRecord> r104 = r103.f268672a;
        if (r104 != null) goto L12;
    L16:
        ArrayList r105 = new ArrayList(r110.getParcelableArrayList("bd-scene-nav:group_stack"));
        r103.f268672a = r105;
        Iterator r106 = r105.iterator();
    L18:
        if (r106.hasNext() == false) goto L20;
        GroupRecord r107 = (GroupRecord) r106.next();
        Scene r108 = SceneInstanceUtility.c(r102, r107.f268652f, null);
        r107.f268648b = r108;
        ((HashMap) r103.f268673b).put(r108, r107);
        ((HashMap) r103.f268674c).put(r107.f268649c, r107);
        goto L18
    L20:
        List r109 = Collections.unmodifiableList(r101.f268679c.f268672a);
        if (r109.size() == 0) goto L36;
        ArrayList r111 = r110.getParcelableArrayList("bd-scene-nav:group_scene_manager");
    L25:
        if (r100 > (r109.size() - 1)) goto L37;
        GroupRecord r112 = (GroupRecord) ListProtector.get(r109, r100);
        Scene r113 = r112.f268648b;
        r112.f268653g = (Bundle) ListProtector.get(r111, r100);
        if (r101.d(r113) == false) goto L30;
        r101.b(r113);
        GroupScene r114 = r101.f268677a;
        r101.i(r114, r113, r114.f268590h, false, new e(r101, r113));
        r100 = r100 + 1;
        goto L25
    L30:
        throw new SceneInternalException("Scene is not found");
    L37:
        return;
    L36:
        return;
    L12:
        if (((ArrayList) r104).size() <= 0) goto L16;
        throw new IllegalStateException("mSceneList size is not zero, Scene is added before restore");
    L35:
        return;
    }

    @Override // com.bytedance.scene.Scene
    public void f0(Bundle r100) {
        super.f0(r100);
        if (r100.containsKey("bd-scene-group:support_restore") == true) goto L23;
        r100.putBoolean("bd-scene-group:support_restore", this.f268657s);
        if (this.f268657s == false) goto L30;
        b r101 = this.f268655q;
        com.bytedance.scene.group.a r102 = r101.f268679c;
        r102.getClass();
        ArrayList r103 = new ArrayList(r102.f268672a);
        ArrayList r104 = new ArrayList(r103.size());
        int r105 = 0;
        int r106 = 0;
    L8:
        if (r106 > (r103.size() - 1)) goto L13;
        GroupRecord r107 = (GroupRecord) ListProtector.get(r103, r106);
        if (r107.f268648b.f268593k == false) goto L12;
        r104.add(r107);
    L12:
        r106 = r106 + 1;
        goto L8
    L13:
        r100.putParcelableArrayList("bd-scene-nav:group_stack", new ArrayList(r104));
        ArrayList<? extends Parcelable> r108 = new ArrayList();
        List<Scene> r109 = r101.g();
    L15:
        if (r105 > (r109.size() - 1)) goto L20;
        Scene r110 = (Scene) ListProtector.get(r109, r105);
        if (r110.f268593k == false) goto L19;
        Bundle r111 = new Bundle();
        r110.N(r111);
        r108.add(r111);
    L19:
        r105 = r105 + 1;
        goto L15
    L20:
        r100.putParcelableArrayList("bd-scene-nav:group_scene_manager", r108);
        return;
    L30:
        return;
    L23:
        throw new IllegalArgumentException("outState already contains key bd-scene-group:support_restore");
    }

    @Override // com.bytedance.scene.Scene
    public final void g(Bundle r100) {
        super.g(r100);
        m0(State.ACTIVITY_CREATED);
        u0();
    }

    @Override // com.bytedance.scene.Scene
    public final void h(Activity r100) {
        super.h(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void i(Scene r100) {
        super.i(r100);
        if (r100 != 0) goto L6;
        return;
    L6:
        if ((r100 instanceof m) == false) goto L12;
        if (((m) r100).c() == true) goto L13;
        this.f268657s = false;
        return;
    L13:
        return;
    L12:
        throw new SceneInternalException("unknown parent Scene type " + r100.getClass());
    }

    @Override // com.bytedance.scene.Scene
    public final void j(Bundle r100) {
        super.j(r100);
    }

    public final void m0(State r110) {
        b r100 = this.f268655q;
        List<Scene> r101 = r100.g();
        int r102 = 0;
    L4:
        if (r102 > (r101.size() - 1)) goto L9;
        Scene r103 = (Scene) ListProtector.get(r101, r102);
        if (r100.d(r103) == false) goto L8;
        r100.b(r103);
        r100.i(r100.f268677a, r103, r110, false, new c(r100, r103));
    L8:
        r102 = r102 + 1;
        goto L4
    }

    public final void n0(State r110) {
        b r100 = this.f268655q;
        List r101 = Collections.unmodifiableList(r100.f268679c.f268672a);
        int r102 = 0;
    L4:
        if (r102 > (r101.size() - 1)) goto L11;
        GroupRecord r103 = (GroupRecord) ListProtector.get(r101, r102);
        if (r103.f268650d == true) goto L10;
        Scene r104 = r103.f268648b;
        if (r100.d(r104) == false) goto L10;
        r100.b(r104);
        r100.i(r100.f268677a, r103.f268648b, r110, false, new d(r100, r104));
    L10:
        r102 = r102 + 1;
        goto L4
    }

    public final <T extends Scene> T p0(String r100) {
        qa7.f.a();
        if (r100 != null) goto L5;
        return null;
    L5:
        GroupRecord r101 = (GroupRecord) ((HashMap) this.f268655q.f268679c.f268674c).get(r100);
        if (r101 != null) goto L8;
        return null;
    L8:
        return (T) r101.f268648b;
    }

    public final void q0(Scene r100) {
        qa7.f.a();
        b r101 = this.f268655q;
        r101.c(r100);
        if (r101.f268682f == false) goto L5;
    L9:
        b.e r102 = new b.e(r101, r100);
        if (r101.f268682f == false) goto L12;
        ((ArrayList) r101.f268683g).add(r102);
        return;
    L12:
        b.e(r102);
        return;
    L5:
        if (r101.f268679c.a(r100) != null) goto L9;
        throw new IllegalStateException("Target scene is not find");
    }

    public final boolean r0(Scene r100) {
        if (this.f268655q.f268679c.a(r100) == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean s0(Scene r100) {
        GroupRecord r101 = this.f268655q.f268679c.a(r100);
        if (r101 != null) goto L7;
        return false;
    L7:
        return !r101.f268650d;
    }

    public final void y0(Scene r100) {
        qa7.f.a();
        b r101 = this.f268655q;
        r101.c(r100);
        if (r101.f268682f == false) goto L5;
    L9:
        b.h r102 = new b.h(r101, r100);
        if (r101.f268682f == false) goto L12;
        ((ArrayList) r101.f268683g).add(r102);
        return;
    L12:
        b.e(r102);
        return;
    L5:
        if (r101.f268679c.a(r100) != null) goto L9;
        throw new IllegalStateException("Target scene is not find");
    }

    public final void z0(Scene r100) {
        qa7.f.a();
        b r101 = this.f268655q;
        r101.c(r100);
        if (r101.f268682f == false) goto L5;
    L9:
        b.i r102 = new b.i(r101, r100);
        if (r101.f268682f == false) goto L12;
        ((ArrayList) r101.f268683g).add(r102);
        return;
    L12:
        b.e(r102);
        return;
    L5:
        if (r101.f268679c.a(r100) != null) goto L9;
        throw new IllegalStateException("Target scene is not find");
    }

    public static void o0(List<ScenePlaceHolderView> r100, ViewGroup r101) {
        int r102 = r101.getChildCount();
        if (r102 != 0) goto L5;
        return;
    L5:
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L14;
        View r104 = r101.getChildAt(r103);
        if ((r104 instanceof ScenePlaceHolderView) == false) goto L11;
        ArrayList r105 = (ArrayList) r100;
        r105.add((ScenePlaceHolderView) r104);
    L13:
        r103 = r103 + 1;
        goto L6
    L11:
        if ((r104 instanceof ViewGroup) == false) goto L13;
        o0(r100, (ViewGroup) r104);
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void C(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).p();
    L11:
        super.C(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void D(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).i();
    L11:
        super.D(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void E(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).d();
    L11:
        super.E(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void G(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).a();
    L11:
        super.G(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void H(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).q();
    L11:
        super.H(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void K(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).e();
    L11:
        super.K(r100, r101);
    }

    @Override // com.bytedance.scene.Scene
    public final void k(Bundle r310, ViewGroup r311) {
        GroupScene r100 = this;
        super.k(r310, r311);
        View r101 = r100.f268586d;
        if ((r101 instanceof ViewGroup) == false) goto L116;
        r100.f268655q.f268678b = (ViewGroup) r101;
        ArrayList r102 = new ArrayList();
        View r103 = r100.f268586d;
        if (r103 == null) goto L114;
        o0(r102, (ViewGroup) r103);
        if (r102.size() != 0) goto L10;
    L109:
        m0(State.VIEW_CREATED);
        return;
    L10:
        if (r100.f268657s == true) goto L112;
        SparseArray r104 = new SparseArray();
        int r105 = r102.size();
        int r106 = 0;
    L12:
        if (r106 >= r105) goto L109;
        ScenePlaceHolderView r107 = (ScenePlaceHolderView) ListProtector.get(r102, r106);
        ViewGroup r108 = (ViewGroup) r107.getParent();
        int r109 = r108.getId();
        if (r109 == (-1)) goto L108;
        if (r104.get(r109) != null) goto L19;
        r104.put(r109, r108);
    L20:
        ViewGroup.LayoutParams r110 = r107.getLayoutParams();
        String r111 = r107.getSceneName();
        String r112 = r107.getSceneTag();
        Bundle r113 = r107.getArguments();
        r107.getSceneComponentFactory();
        Scene r114 = SceneInstanceUtility.c(j0(), r111, r113);
        int r115 = r108.indexOfChild(r107);
        r108.removeView(r107);
        if (r107.getVisibility() != 0) goto L24;
        r100.l0(r109, r114, r112);
        ArrayList r210 = r102;
        SparseArray r211 = r104;
        int r212 = r105;
    L72:
        View r116 = r114.f268586d;
        if (r116 == null) goto L94;
        if (r107.getId() == (-1)) goto L92;
        if (r116.getId() != (-1)) goto L80;
        r116.setId(r107.getId());
        goto L92
    L80:
        if (r107.getId() == r116.getId()) goto L92;
        Context r117 = j0();
        int r118 = r107.getId();
        String r119 = r117.getResources().getResourceName(r118);     // Catch: Resources.NotFoundException -> L85
    L86:
        Context r120 = j0();
        int r121 = r116.getId();
        String r122 = r120.getResources().getResourceName(r121);     // Catch: Resources.NotFoundException -> L89
    L91:
        throw new IllegalStateException(String.format("ScenePlaceHolderView's id %s is different from Scene root view's id %s", new Object[]{r119, r122}));
    L89:
        r122 = String.valueOf(r121);
    L85:
        r119 = String.valueOf(r118);
    L92:
        r108.removeView(r116);
        r108.addView(r116, r115, r110);
        r106 = r106 + 1;
        r100 = this;
        r102 = r210;
        r104 = r211;
        r105 = r212;
        goto L12
    L94:
        throw new IllegalStateException("requireView() should not be called before onCreateView() or after onDestroyView()");
    L24:
        if (r107.getVisibility() != 8) goto L100;
        b r123 = r100.f268655q;
        if (r123.f268682f == true) goto L98;
        r123.f268682f = true;
        r100.l0(r109, r114, r112);
        r100.q0(r114);
        b r124 = r100.f268655q;
        if (r124.f268682f == false) goto L96;
        if (((ArrayList) r124.f268683g).size() <= 0) goto L70;
        Iterator r125 = ((ArrayList) r124.f268683g).iterator();
        LinkedHashMap r126 = new LinkedHashMap();
    L33:
        if (r125.hasNext() == false) goto L39;
        b.g r127 = (b.g) r125.next();
        List r128 = (List) r126.get(r127.f268694a);
        if (r128 != null) goto L38;
        r128 = new ArrayList();
        r126.put(r127.f268694a, r128);
    L38:
        r128.add(r127);
        r102 = r102;
        goto L33
    L39:
        r210 = r102;
        Iterator r129 = r126.keySet().iterator();
    L41:
        if (r129.hasNext() == false) goto L69;
        Scene r130 = (Scene) r129.next();
        List r131 = (List) r126.get(r130);
        State r132 = r130.f268590h;
        Iterator r213 = r129;
        State r133 = ((b.g) ListProtector.get(r131, r131.size() - 1)).f268695b;
        SparseArray r214 = r104;
        boolean r134 = ((b.g) ListProtector.get(r131, r131.size() - 1)).f268696c;
        int r215 = r105;
        boolean r135 = ((b.g) ListProtector.get(r131, r131.size() - 1)).f268697d;
        LinkedHashMap r216 = r126;
        boolean r136 = ((b.g) ListProtector.get(r131, r131.size() - 1)).f268698e;
        if (r132 != r133) goto L49;
        if (r134 == true) goto L49;
        if (r135 == true) goto L49;
        if (r136 == true) goto L49;
    L68:
        r129 = r213;
        r104 = r214;
        r105 = r215;
        r126 = r216;
    L49:
        if (r132 != State.NONE) goto L66;
        int r137 = r131.size();
    L51:
        int r138 = r137 - 1;
        if (r138 < 0) goto L57;
        b.g r139 = (b.g) ListProtector.get(r131, r138);
        if ((r139 instanceof b.d) == true) goto L55;
        r137 = r138;
        goto L51
    L55:
        b.d r140 = (b.d) r139;
    L58:
        if (r140 == null) goto L65;
        if (((GroupRecord) ((HashMap) r124.f268679c.f268674c).get(r140.f268687l)) != null) goto L63;
        b.e(new b.j(r124, r130, r140.f268686k, r140.f268687l, r133, r134, r135, r136));
        goto L68
    L63:
        throw new IllegalStateException("already have a Scene with tag " + r140.f268687l);
    L65:
        throw new IllegalStateException("you must add Scene first");
    L57:
        r140 = null;
        goto L58
    L66:
        b.e(new b.j(r124, r130, -1, null, r133, r134, r135, r136));
        goto L68
    L69:
        r211 = r104;
        r212 = r105;
        ((ArrayList) r124.f268683g).clear();
    L71:
        r124.f268682f = false;
        goto L72
    L70:
        r210 = r102;
        r211 = r104;
        r212 = r105;
        goto L71
    L96:
        throw new IllegalStateException("you must call beginTransaction before commitTransaction");
    L98:
        throw new IllegalStateException("you must call commitTransaction before another beginTransaction");
    L100:
        throw new IllegalStateException("ScenePlaceHolderView's visibility can't be View.INVISIBLE, use View.VISIBLE or View.GONE instead");
    L19:
        if (r104.get(r109) == r108) goto L20;
        StringBuilder r141 = new StringBuilder("ScenePlaceHolderView' parent ViewGroup should have unique id, the duplicate id is ");
        String r142 = j0().getResources().getResourceName(r109);     // Catch: Resources.NotFoundException -> L104
    L105:
        r141.append(r142);
        throw new IllegalArgumentException(r141.toString());
    L104:
        r142 = String.valueOf(r109);
        goto L105
    L108:
        throw new IllegalArgumentException("ScenePlaceHolderView parent id can't be View.NO_ID");
    L112:
        throw new IllegalStateException("ScenePlaceHolderView can only be used when support restore is disabled");
    L114:
        throw new IllegalStateException("requireView() should not be called before onCreateView() or after onDestroyView()");
    L116:
        throw new IllegalArgumentException("GroupScene onCreateView view must be ViewGroup");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void t(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).g();
    L11:
        super.t(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void u(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).f();
    L11:
        super.u(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void v(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).j();
    L11:
        super.v(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void w(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).b();
    L11:
        super.w(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void x(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).r();
    L11:
        super.x(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void z(Scene r100, boolean r101) {
        if (r100 == this) goto L11;
        Iterator r102 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r102.hasNext() == false) goto L11;
        qa7.e r103 = (qa7.e) r102.next();
        if (r101 == true) goto L10;
        if (((Boolean) r103.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r103.f532273a).o();
    L11:
        super.z(r100, r101);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void A(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).k();
    L11:
        super.A(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void B(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).s();
    L11:
        super.B(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void F(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).l();
    L11:
        super.F(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void J(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).c();
    L11:
        super.J(r100, r101, r102);
    }

    @Override // com.bytedance.scene.Scene
    public /* bridge */ /* synthetic */ View Z(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        return t0(r100, r101, r102);
    }

    public final void l0(int r100, Scene r101, String r102) {
        qa7.f.a();
        if (TextUtils.isEmpty(r102) == true) goto L46;
        if (r101 == this) goto L44;
        if (r0(r101) == false) goto L19;
        int r103 = this.f268655q.f268679c.a(r101).f268647a;
        if (r103 != r100) goto L47;
        String r104 = this.f268655q.f268679c.a(r101).f268649c;
        if (r104.equals(r102) == false) goto L13;
    L21:
        Scene r105 = r101.f268587e;
        if (r105 == null) goto L28;
        if (r105 == this) goto L28;
        throw new IllegalArgumentException("Scene already has a parent, parent " + r101.f268587e);
    L28:
        if (this.f268657s == true) goto L30;
    L36:
        b r106 = this.f268655q;
        r106.c(r101);
        b.d r107 = new b.d(r106, r100, r101, r102);
        if (r106.f268682f == false) goto L39;
        ((ArrayList) r106.f268683g).add(r107);
        return;
    L39:
        b.e(r107);
        return;
    L30:
        if (r101.f268593k == false) goto L36;
        if (SceneInstanceUtility.d(r101) == true) goto L36;
        throw new IllegalArgumentException("Scene " + r101.getClass().getName() + " must be a public class or public static class, and have only one parameterless constructor to be properly recreated from instance state.");
    L13:
        throw new IllegalArgumentException("Scene is already added, tag ".concat(r104));
    L47:
        String r108 = getResources().getResourceName(r103);     // Catch: Resources.NotFoundException -> L16
    L18:
        throw new IllegalArgumentException("Scene is already added to another container, viewId " + r108);
    L16:
        r108 = String.valueOf(r103);
        goto L18
    L19:
        Scene r109 = p0(r102);
        if (r109 == null) goto L21;
        throw new IllegalArgumentException("already have a Scene " + r109.toString() + " with tag " + r102);
    L44:
        throw new IllegalArgumentException("GroupScene can't be added to itself");
    L46:
        throw new IllegalArgumentException("tag can't be empty");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void r(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).h();
    L11:
        super.r(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void s(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).m();
    L11:
        super.s(r100, r101, r102);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.scene.Scene
    public final void y(Scene r100, Bundle r101, boolean r102) {
        if (r100 == this) goto L11;
        Iterator r103 = new ArrayList(this.f268656r).iterator();
    L5:
        if (r103.hasNext() == false) goto L11;
        qa7.e r104 = (qa7.e) r103.next();
        if (r102 == true) goto L10;
        if (((Boolean) r104.f532274b).booleanValue() == false) goto L5;
    L10:
        ((na7.b) r104.f532273a).n();
    L11:
        super.y(r100, r101, r102);
    }
}
