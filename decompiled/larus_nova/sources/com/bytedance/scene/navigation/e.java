package com.bytedance.scene.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.core.os.CancellationSignal;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.scene.Scene;
import com.bytedance.scene.State;
import com.bytedance.scene.group.ReuseGroupScene;
import com.bytedance.scene.o;
import com.bytedance.scene.ui.SceneContainerActivity;
import com.bytedance.scene.utlity.SceneInternalException;
import com.bytedance.scene.view.AnimationContainerLayout;
import com.bytedance.scene.view.NavigationFrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes19.dex */
public final class e {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final b f268776m = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final NavigationScene f268777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.scene.navigation.k f268778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final NavigationScene f268779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.scene.navigation.a f268780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayDeque<InterfaceC3756e> f268781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f268782f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final d f268783g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<qa7.e<LifecycleOwner, com.bytedance.scene.navigation.j>> f268784h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Set<String> f268785i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f268786j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f268787k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f268788l;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC3756e f268789a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f268790b;

        public final void a() {
            e r100 = this.f268790b;
            r100.f268787k--;
            if (((HashSet) r100.f268785i).size() > 0) goto L10;
            if (this.f268790b.b() == false) goto L7;
            String r101 = this.f268790b.a("NavigationManager execute operation by Handler.post()");
            e r102 = this.f268790b;
            InterfaceC3756e r103 = this.f268789a;
            b r104 = e.f268776m;
            r102.e(r103);
            this.f268790b.d(r101);
            return;
        L7:
            this.f268790b.f268781e.addLast(this.f268789a);
            this.f268790b.f268782f = System.currentTimeMillis();
            return;
        L10:
            throw new SceneInternalException("miss endSuppressStackOperation(), mIsNavigationStateChangeInProgress content " + TextUtils.join(",", this.f268790b.f268785i));
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

        public a(e r100, InterfaceC3756e r101) {
            this.f268790b = r100;
            this.f268789a = r101;
        }
    }

    public static class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f268791a = null;

        static {
            int[] r100 = new int[State.values().length];
            f268791a = r100;
            r100[State.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f268791a[State.VIEW_CREATED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f268791a[State.ACTIVITY_CREATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f268791a[State.STARTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f268791a[State.RESUMED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<qa7.c> f268792a;

        public d() {
            this.f268792a = new ArrayList();
        }
    }

    /* JADX INFO: renamed from: com.bytedance.scene.navigation.e$e, reason: collision with other inner class name */
    public interface InterfaceC3756e {
        void execute();
    }

    public class f implements InterfaceC3756e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ja7.i f268793a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f268794b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f268795c;

        @Override // com.bytedance.scene.navigation.e.InterfaceC3756e
        public final void execute() {
            b r100 = e.f268776m;
            this.f268795c.c();
            if (this.f268795c.b() == false) goto L102;
            List<Record> r101 = this.f268795c.f268778b.b();
            int r102 = this.f268794b;
            if (r102 <= 0) goto L100;
            ArrayList r103 = (ArrayList) r101;
            if (r102 >= r103.size()) goto L9;
            ArrayList r104 = new ArrayList();
            int r105 = 0;
        L15:
            if (r105 > (this.f268794b - 1)) goto L17;
            r104.add((Record) ListProtector.get(r101, (r103.size() - 1) - r105));
            r105 = r105 + 1;
            goto L15
        L17:
            Record r106 = (Record) ListProtector.get(r101, (r103.size() - this.f268794b) - 1);
            Record r107 = this.f268795c.f268778b.a();
            Scene r108 = r107.f268768a;
            View r110 = r108.f268586d;
            Iterator r109 = r104.iterator();
        L19:
            if (r109.hasNext() == false) goto L25;
            Record r111 = (Record) r109.next();
            Scene r112 = r111.f268768a;
            e.g(this.f268795c.f268777a, r112, State.NONE, null, false, null);
            ((ArrayList) this.f268795c.f268778b.f268820a).remove(r111);
            if (r111 == r107) goto L19;
            if ((r112 instanceof ReuseGroupScene) == false) goto L19;
            ReuseGroupScene r113 = (ReuseGroupScene) r112;
            this.f268795c.f268777a.f268759x.put(r113.getClass(), r113);
            goto L19
        L25:
            Scene r114 = r106.f268768a;
            NavigationScene r115 = this.f268795c.f268777a;
            State r116 = r115.f268590h;
            if (r116.value < State.STARTED.value) goto L28;
            boolean r117 = true;
        L29:
            e.g(r115, r114, r116, null, false, null);
            na7.f r118 = r107.f268773f;
            if (r118 == null) goto L42;
            Object r119 = r107.f268772e;
            SceneContainerActivity.DelegateScene.a r120 = (SceneContainerActivity.DelegateScene.a) r118;
            Messenger r121 = (Messenger) r120.f268825a.h0().getIntent().getParcelableExtra("SingeProcessMessengerHandler");
            if (r121 == null) goto L34;
            o r122 = new o(r121);
        L35:
            r122.getClass();
            Message r123 = Message.obtain();
            r123.obj = r119;
            r122.f268821a.send(r123);     // Catch: RemoteException -> L38
        L40:
            r120.f268825a.h0().finish();
        L38:
            e = move-exception;
            e.printStackTrace();
            goto L40
        L34:
            r122 = null;
        L42:
            if (r106.f268769b == false) goto L55;
            List<Record> r124 = this.f268795c.f268778b.b();
            ArrayList r125 = (ArrayList) r124;
            if (r125.size() <= 1) goto L55;
            int r126 = r125.size() - 2;
        L46:
            if (r126 < 0) goto L55;
            Record r127 = (Record) ListProtector.get(r124, r126);
            NavigationScene r128 = this.f268795c.f268777a;
            Scene r129 = r127.f268768a;
            State r130 = r128.f268590h;
            State r131 = State.STARTED;
            if (r130.value <= r131.value) goto L50;
            State r132 = r131;
        L51:
            e.g(r128, r129, r132, null, false, null);
            if (r127.f268769b == false) goto L55;
            r126 = r126 - 1;
            goto L46
        L50:
            r132 = r130;
        L55:
            e r133 = this.f268795c;
            ActivityStatusRecord r134 = r106.f268770c;
            Activity r135 = r133.f268777a.getActivity();
            r134.getClass();
            Window r136 = r135.getWindow();
            r136.setStatusBarColor(r134.f268746a);
            r136.setNavigationBarColor(r134.f268747b);
            ActivityStatusRecord.a(r136).setSystemUiVisibility(r134.f268748c);
            r136.setSoftInputMode(r134.f268749d);
            int r137 = r136.getAttributes().flags;
            int r138 = r134.f268750e;
            int r139 = ~(r137 & r138);
            r136.addFlags(r138 & r139);
            r136.clearFlags(r137 & r139);
            r135.setRequestedOrientation(r134.f268751f);
            this.f268795c.f268779c.f(r107.f268768a, r106.f268768a, false);
            ja7.i r140 = this.f268793a;
            if (r140 == null) goto L58;
            r107.f268768a.getClass();
            r106.f268768a.getClass();
            r140.c();
            ja7.i r141 = this.f268793a;
        L59:
            if (r141 != null) goto L63;
            ja7.i r142 = r107.f268771d;
            if (r142 == null) goto L63;
            r107.f268768a.getClass();
            r106.f268768a.getClass();
            r142.c();
            r141 = r107.f268771d;
        L63:
            if (r141 != null) goto L65;
            r141 = this.f268795c.f268777a.f268757v;
        L65:
            e r143 = this.f268795c;
            if (r143.f268788l == true) goto L95;
            if (r117 == false) goto L95;
            if (r141 == null) goto L95;
            r107.f268768a.getClass();
            r106.f268768a.getClass();
            r141.c();
            AnimationContainerLayout r144 = this.f268795c.f268777a.f268756u;
            ViewGroup r145 = (ViewGroup) r144.getParent();
            int r146 = r145.getChildCount();
            int r147 = r145.indexOfChild(r144);
            if (r147 >= 0) goto L72;
        L74:
            r141.f497918a = r144;
            qa7.c r148 = new qa7.c();
            com.bytedance.scene.navigation.g r149 = new com.bytedance.scene.navigation.g(this, r148, r107);
            ja7.a r150 = new ja7.a(r108, r110, r108.f268590h, r107.f268769b);
            Scene r151 = r106.f268768a;
            View r152 = r151.f268586d;
            ja7.a r153 = new ja7.a(r151, r152, r151.f268590h, r106.f268769b);
            ((ArrayList) this.f268795c.f268783g.f268792a).add(r148);
            NavigationScene r154 = this.f268795c.f268777a;
            View r155 = r154.f268586d.getRootView();
            ((NavigationFrameLayout) r154.f268586d).setTouchEnabled(false);
            ja7.f r156 = new ja7.f(r141, r154, r149);
            r148.b(new ja7.g(r156));
            if (r110.getWidth() != 0) goto L77;
        L79:
            boolean r157 = false;
        L81:
            if (r152.getWidth() != 0) goto L83;
        L85:
            boolean r158 = false;
        L86:
            if (r157 == false) goto L90;
            if (r158 == false) goto L90;
            r141.a(r150, r153, r156, r148.c());
            return;
        L90:
            qa7.b r159 = r148.c();
            ja7.i.d(r155, r159, new ja7.h(r141, r157, r110, r159, r150, r153, r156, r148));
            if (r157 == true) goto L93;
            r141.f497918a.addView(r110);
            r110.setVisibility(0);
            r110.requestLayout();
        L93:
            if (r158 == true) goto L116;
            r152.requestLayout();
            return;
        L116:
            return;
        L83:
            if (r152.getHeight() == 0) goto L85;
            r158 = true;
            goto L86
        L77:
            if (r110.getHeight() == 0) goto L79;
            r157 = true;
            goto L81
        L72:
            if (r147 == (r146 - 1)) goto L74;
            r144.bringToFront();
        L95:
            Scene r160 = r107.f268768a;
            if ((r160 instanceof ReuseGroupScene) == false) goto L118;
            ReuseGroupScene r161 = (ReuseGroupScene) r160;
            r143.f268777a.f268759x.put(r161.getClass(), r161);
            return;
        L118:
            return;
        L58:
            r141 = null;
            goto L59
        L28:
            r117 = false;
            goto L29
        L9:
            if (r103.size() <= 1) goto L11;
            new f(this.f268795c, this.f268793a, r103.size() - 1).execute();
        L11:
            this.f268795c.f268777a.h0().onBackPressed();
            return;
        L100:
            throw new IllegalArgumentException("popCount can not be " + this.f268794b + " stackSize is " + ((ArrayList) r101).size());
        L102:
            throw new IllegalArgumentException("Can't pop, current NavigationScene state " + this.f268795c.f268777a.f268590h.name);
        }

        public f(e r100, ja7.i r101, int r102) {
            this.f268795c = r100;
            this.f268793a = r101;
            this.f268794b = r102;
        }
    }

    public class g implements InterfaceC3756e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f268796a;

        @Override // com.bytedance.scene.navigation.e.InterfaceC3756e
        public final void execute() {
            b r100 = e.f268776m;
            new f(this.f268796a, null, 1).execute();
        }

        public g(e r100) {
            this.f268796a = r100;
        }
    }

    public class h implements InterfaceC3756e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final na7.d f268797a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f268798b;

        @Override // com.bytedance.scene.navigation.e.InterfaceC3756e
        public final void execute() {
            b r100 = e.f268776m;
            this.f268798b.f268778b.b();
            this.f268797a.getClass();
            new f(this.f268798b, this.f268797a.f518472a, 1).execute();
        }

        public h(e r100, na7.d r101) {
            this.f268798b = r100;
            this.f268797a = r101;
        }
    }

    public class i implements InterfaceC3756e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Scene f268799a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final na7.e f268800b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f268801c;

        @Override // com.bytedance.scene.navigation.e.InterfaceC3756e
        public final void execute() {
            b r100 = e.f268776m;
            this.f268801c.c();
            if (this.f268801c.b() == false) goto L95;
            Record r101 = this.f268801c.f268778b.a();
            ja7.i r102 = null;
            if (r101 == null) goto L7;
            View r103 = r101.f268768a.f268586d;
        L8:
            Scene r104 = this.f268799a.f268587e;
            if (r104 != null) goto L11;
            this.f268800b.getClass();
            if (r101 != null) goto L18;
        L37:
            ja7.i r105 = this.f268800b.f518473a;
            Scene r106 = this.f268799a;
            Record r107 = new Record();
            r107.f268768a = r106;
            r107.f268774g = r106.getClass().getName();
            r107.f268769b = false;
            r107.f268771d = r105;
            r107.f268773f = this.f268800b.f518474b;
            ((ArrayList) this.f268801c.f268778b.f268820a).add(r107);
            NavigationScene r110 = this.f268801c.f268777a;
            e.g(r110, this.f268799a, r110.f268590h, null, false, null);
            NavigationScene r108 = this.f268801c.f268779c;
            if (r101 == null) goto L40;
            Scene r109 = r101.f268768a;
        L41:
            r108.f(r109, this.f268799a, true);
            e r111 = this.f268801c;
            if (r111.f268777a.f268590h.value < State.STARTED.value) goto L44;
            boolean r112 = true;
        L46:
            if (r111.f268788l == true) goto L98;
            if (r112 == false) goto L99;
            if (r101 == null) goto L100;
            ja7.i r113 = r107.f268771d;
            if (r113 == null) goto L52;
            r101.f268768a.getClass();
            this.f268799a.getClass();
            r113.c();
            r102 = r113;
        L52:
            if (r102 != null) goto L55;
            if (r105 == null) goto L55;
            r101.f268768a.getClass();
            this.f268799a.getClass();
            r105.c();
        L56:
            if (r105 != null) goto L58;
            ja7.i r114 = this.f268801c.f268777a.f268757v;
        L59:
            if (r114 == null) goto L101;
            r101.f268768a.getClass();
            this.f268799a.getClass();
            r114.c();
            Scene r115 = r101.f268768a;
            FrameLayout r116 = this.f268801c.f268777a.f268755t;
            ViewGroup r117 = (ViewGroup) r116.getParent();
            int r118 = r117.getChildCount();
            int r119 = r117.indexOfChild(r116);
            if (r119 >= 0) goto L63;
        L65:
            r114.f497918a = this.f268801c.f268777a.f268756u;
            State r120 = r115.f268590h;
            ja7.a r121 = new ja7.a(r115, r103, r120, r101.f268769b);
            Scene r122 = this.f268799a;
            View r123 = r122.f268586d;
            ja7.a r124 = new ja7.a(r122, r123, r122.f268590h, r107.f268769b);
            qa7.c r125 = new qa7.c();
            ((ArrayList) this.f268801c.f268783g.f268792a).add(r125);
            NavigationScene r126 = this.f268801c.f268777a;
            View r127 = r126.f268586d.getRootView();
            com.bytedance.scene.navigation.h r128 = new com.bytedance.scene.navigation.h(this, r125);
            ((NavigationFrameLayout) r126.f268586d).setTouchEnabled(false);
            if (r120.value >= State.VIEW_CREATED.value) goto L68;
            r114.f497918a.getOverlay().add(r103);
        L68:
            ja7.c r129 = new ja7.c(r114, r126, r121, r103, r128);
            r125.b(new ja7.d(r129));
            if (r103.getWidth() != 0) goto L71;
        L73:
            boolean r130 = false;
        L75:
            if (r123.getWidth() != 0) goto L77;
        L79:
            boolean r131 = false;
        L81:
            if (r103.getVisibility() != 0) goto L83;
            boolean r132 = true;
        L84:
            if (r130 == false) goto L88;
            if (r131 == false) goto L88;
            r114.b(r121, r124, r129, r125.c());
            return;
        L88:
            qa7.b r133 = r125.c();
            ja7.i.d(r127, r133, new ja7.e(r114, r130, r103, r133, r121, r124, r129, r125, r132));
            if (r130 == true) goto L91;
            r103.setVisibility(0);
            r103.requestLayout();
        L91:
            if (r131 == true) goto L103;
            r123.requestLayout();
            return;
        L103:
            return;
        L83:
            r132 = false;
            goto L84
        L77:
            if (r123.getHeight() == 0) goto L79;
            r131 = true;
            goto L81
        L71:
            if (r103.getHeight() == 0) goto L73;
            r130 = true;
            goto L75
        L63:
            if (r119 == (r118 - 1)) goto L65;
            r116.bringToFront();
            goto L65
        L101:
            return;
        L58:
            r114 = r105;
        L55:
            r105 = r102;
            goto L56
        L100:
            return;
        L99:
            return;
        L98:
            return;
        L44:
            r112 = false;
            goto L46
        L40:
            r109 = null;
            goto L41
        L18:
            if (((ArrayList) this.f268801c.f268778b.b()).contains(r101) == false) goto L37;
            Activity r134 = r101.f268768a.h0();
            ActivityStatusRecord r135 = new ActivityStatusRecord();
            Window r136 = r134.getWindow();
            View r137 = ActivityStatusRecord.a(r136);
            r135.f268746a = r136.getStatusBarColor();
            r135.f268747b = r136.getNavigationBarColor();
            r135.f268748c = r137.getSystemUiVisibility();
            r135.f268749d = r136.getAttributes().softInputMode;
            r135.f268750e = r136.getAttributes().flags;
            r135.f268751f = r134.getRequestedOrientation();
            r101.f268770c = r135;
            Scene r138 = r101.f268768a;
            State r139 = State.ACTIVITY_CREATED;
            NavigationScene r140 = this.f268801c.f268777a;
            State r141 = r140.f268590h;
            if (r139.value <= r141.value) goto L22;
            State r142 = r141;
        L23:
            e.g(r140, r138, r142, null, false, null);
            List<Record> r143 = this.f268801c.f268778b.b();
            ArrayList r144 = (ArrayList) r143;
            if (r144.size() <= 1) goto L37;
            if (r101.f268769b == false) goto L37;
            int r145 = r144.size() - 2;
        L28:
            if (r145 < 0) goto L37;
            Record r146 = (Record) ListProtector.get(r143, r145);
            NavigationScene r147 = this.f268801c.f268777a;
            Scene r148 = r146.f268768a;
            State r149 = State.ACTIVITY_CREATED;
            State r150 = r147.f268590h;
            if (r149.value <= r150.value) goto L32;
            State r151 = r150;
        L33:
            e.g(r147, r148, r151, null, false, null);
            if (r146.f268769b == false) goto L37;
            r145 = r145 - 1;
            goto L28
        L32:
            r151 = r149;
            goto L33
        L22:
            r142 = r139;
            goto L23
        L11:
            if (r104 != this.f268801c.f268777a) goto L14;
            return;
        L14:
            throw new IllegalArgumentException("Scene already has a parent, parent " + this.f268799a.f268587e);
        L7:
            r103 = null;
            goto L8
        L95:
            throw new IllegalArgumentException("Can't push, current NavigationScene state " + this.f268801c.f268777a.f268590h.name);
        }

        public i(e r100, Scene r101, na7.e r102) {
            this.f268801c = r100;
            this.f268799a = r101;
            this.f268800b = r102;
        }
    }

    public class j implements InterfaceC3756e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final State f268802a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f268803b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ e f268804c;

        @Override // com.bytedance.scene.navigation.e.InterfaceC3756e
        public final void execute() {
            b r100 = e.f268776m;
            if (this.f268804c.f268778b.a() != null) goto L5;
            return;
        L5:
            List<Record> r101 = this.f268804c.f268778b.b();
            if (this.f268803b == false) goto L8;
            ArrayList r102 = new ArrayList(r101);
            Collections.reverse(r102);
            r101 = r102;
        L8:
            int r103 = 0;
        L10:
            if (r103 >= r101.size()) goto L12;
            Scene r104 = ((Record) ListProtector.get(r101, r103)).f268768a;
            e.g(this.f268804c.f268777a, r104, this.f268802a, null, true, null);
            r103 = r103 + 1;
            goto L10
        }

        public j(e r100, State r101) {
            this.f268804c = r100;
            this.f268802a = r101;
            this.f268803b = true;
        }
    }

    public class k implements InterfaceC3756e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final State f268805a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f268806b;

        @Override // com.bytedance.scene.navigation.e.InterfaceC3756e
        public final void execute() {
            b r100 = e.f268776m;
            if (this.f268806b.f268778b.a() != null) goto L5;
            return;
        L5:
            List<Record> r101 = this.f268806b.f268778b.b();
            State r102 = this.f268805a;
            ArrayList r103 = (ArrayList) r101;
            int r110 = r103.size() - 1;
        L6:
            if (r110 < 0) goto L30;
            Record r111 = (Record) ListProtector.get(r101, r110);
            if (r110 != (r103.size() - 1)) goto L13;
            e.g(this.f268806b.f268777a, r111.f268768a, r102, null, true, r100);
            if (r111.f268769b == true) goto L29;
            return;
        L29:
            r110 = r110 - 1;
            goto L6
        L13:
            if (r102 != State.RESUMED) goto L16;
            State r104 = State.STARTED;
        L26:
            e.g(this.f268806b.f268777a, r111.f268768a, r104, null, true, r100);
            if (r111.f268769b == true) goto L29;
            return;
        L16:
            r104 = State.STARTED;
            if (r102 == r104) goto L26;
            r104 = State.ACTIVITY_CREATED;
            if (r102 == r104) goto L26;
            r104 = State.VIEW_CREATED;
            if (r102 == r104) goto L26;
            r104 = null;
            goto L26
        }

        public k(e r100, State r101) {
            this.f268806b = r100;
            this.f268805a = r101;
        }
    }

    static {
        f268776m = new b();
    }

    public final boolean b() {
        if (this.f268777a.f268590h.value < State.ACTIVITY_CREATED.value) goto L5;
        return true;
    L5:
        return false;
    }

    public final void c() {
        d r100 = this.f268783g;
        if (((ArrayList) r100.f268792a).size() == 0) goto L10;
        ArrayList r101 = new ArrayList(r100.f268792a);
        Iterator r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        qa7.c r103 = (qa7.c) r102.next();
        r102.remove();
        r103.a();
        goto L7
    L9:
        ((ArrayList) r100.f268792a).removeAll(r101);
    L10:
        CancellationSignal r104 = la7.d.f508210k;
        if (r104 == null) goto L15;
        r104.cancel();
        la7.d.f508210k = null;
        return;
    }

    public final Scene f() {
        Record r100 = this.f268778b.a();
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.f268768a;
    }

    public e(NavigationScene r100) {
        this.f268778b = new com.bytedance.scene.navigation.k();
        this.f268780d = new com.bytedance.scene.navigation.a(Looper.getMainLooper());
        this.f268781e = new ArrayDeque();
        this.f268782f = -1;
        this.f268783g = new d();
        this.f268784h = new ArrayList();
        this.f268785i = new HashSet();
        this.f268786j = 0;
        this.f268787k = 0;
        this.f268788l = false;
        this.f268777a = r100;
        this.f268779c = r100;
    }

    public final String a(String r100) {
        StringBuilder r101 = new StringBuilder();
        r101.append(r100);
        r101.append("_");
        int r102 = this.f268786j;
        this.f268786j = r102 + 1;
        r101.append(r102);
        String r103 = r101.toString();
        if (((HashSet) this.f268785i).add(r103) == false) goto L6;
        return r103;
    L6:
        throw new SceneInternalException("suppressTag already exists");
    }

    public final void d(String r100) {
        if (((HashSet) this.f268785i).remove(r100) == false) goto L9;
        if (((HashSet) this.f268785i).size() != 0) goto L10;
        this.f268786j = 0;
        return;
    L10:
        return;
    L9:
        throw new SceneInternalException("suppressTag not found");
    }

    public final void e(InterfaceC3756e r100) {
        r100.execute();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.f268780d.post(new com.bytedance.scene.navigation.f(th));
        throw th;
    }

    public final void h(com.bytedance.scene.navigation.j r100) {
        int r101 = ((ArrayList) this.f268784h).size() - 1;
    L3:
        if (r101 < 0) goto L8;
        qa7.e r102 = (qa7.e) ListProtector.get(this.f268784h, r101);
        if (r102.f532274b == r100) goto L9;
        r101 = r101 - 1;
    L9:
        ((ArrayList) this.f268784h).remove(r102);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public final void i(InterfaceC3756e r100) {
        if (b() == true) goto L5;
        this.f268781e.addLast(r100);
        this.f268782f = System.currentTimeMillis();
        return;
    L5:
        if (((HashSet) this.f268785i).size() <= 0) goto L7;
    L10:
        a r101 = new a(this, r100);
        this.f268787k++;
        com.bytedance.scene.navigation.a r102 = this.f268780d;
        r102.getClass();
        Message r103 = Message.obtain(r102, r101);
        if (r102.f268775a == false) goto L13;
        r103.setAsynchronous(true);
    L13:
        r102.sendMessage(r103);
        return;
    L7:
        if (this.f268787k > 0) goto L10;
        String r104 = a("NavigationManager execute operation directly");
        e(r100);
        d(r104);
    }

    public void setResult(Scene r100, Object r101) {
        Iterator r102 = ((ArrayList) this.f268778b.f268820a).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Record r103 = (Record) r102.next();
        if (r103.f268768a != r100) goto L4;
    L9:
        if (r103 == null) goto L13;
        r103.f268772e = r101;
        return;
    L13:
        throw new IllegalArgumentException("Scene is not found in stack");
    L8:
        r103 = null;
        goto L9
    }

    public static void g(NavigationScene r100, Scene r101, State r110, Bundle r111, boolean r112, b r113) {
        State r102 = r101.f268590h;
        if (r102 != r110) goto L6;
        return;
    L6:
        if (r102.value >= r110.value) goto L38;
        int r103 = c.f268791a[r102.ordinal()];
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 == 3) goto L15;
        if (r103 != 4) goto L14;
        r101.M();
        g(r100, r101, r110, r111, r112, r113);
        return;
    L14:
        throw new SceneInternalException("unreachable state case " + r102.getName());
    L15:
        r101.f268586d.setVisibility(0);
        r101.O();
        g(r100, r101, r110, r111, r112, r113);
        return;
    L16:
        r101.g(r111);
        g(r100, r101, r110, r111, r112, r113);
        return;
    L17:
        r101.h(r100.h0());
        r101.i(r100);
        r101.j(r111);
        FrameLayout r104 = r100.f268755t;
        r101.k(r111, r104);
        if (r112 == false) goto L20;
    L37:
        r101.f268586d.setVisibility(8);
        g(r100, r101, r110, r111, r112, r113);
        return;
    L20:
        if (r101.f268586d.getBackground() != null) goto L36;
        Iterator r105 = ((ArrayList) r100.f268754s.f268778b.f268820a).iterator();
    L23:
        if (r105.hasNext() == false) goto L27;
        Record r106 = (Record) r105.next();
        if (r106.f268768a != r101) goto L23;
    L29:
        if (r106.f268769b == true) goto L36;
        com.bytedance.scene.navigation.i r107 = r100.f268753r;
        if (r107.f268818d == false) goto L36;
        int r108 = r107.f268819e;
        if (r108 <= 0) goto L35;
        r101.f268586d.setBackgroundDrawable(r101.j0().getResources().getDrawable(r108));
        goto L36
    L35:
        r101.f268586d.setBackgroundDrawable(qa7.g.b(r101.j0()));
        goto L36
    L27:
        r106 = null;
    L36:
        r104.addView(r101.f268586d);
        goto L37
    L38:
        int r109 = c.f268791a[r102.ordinal()];
        if (r109 == 2) goto L56;
        if (r109 == 3) goto L52;
        if (r109 != 4) goto L43;
        r101.P();
        if (r112 == true) goto L50;
        r101.f268586d.setVisibility(8);
    L50:
        g(r100, r101, r110, r111, r112, r113);
        return;
    L43:
        if (r109 != 5) goto L46;
        r101.L();
        g(r100, r101, r110, r111, r112, r113);
        return;
    L46:
        throw new SceneInternalException("unreachable state case " + r102.getName());
    L52:
        if (r110 != State.VIEW_CREATED) goto L56;
        throw new IllegalArgumentException("cant switch state ACTIVITY_CREATED to VIEW_CREATED");
    L56:
        View r114 = r101.f268586d;
        r101.m();
        if (r112 == true) goto L61;
        ViewParent r115 = r114.getParent();
        if ((r115 instanceof ViewGroup) == false) goto L61;
        ((ViewGroup) r115).removeView(r114);
    L61:
        r101.l();
        r101.p();
        r101.o();
        g(r100, r101, r110, r111, r112, r113);     // Catch: Throwable -> L64
        return;
    L64:
        th = move-exception;
        throw th;
    }
}
