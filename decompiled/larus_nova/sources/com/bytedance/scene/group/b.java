package com.bytedance.scene.group;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.util.Pair;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.scene.Scene;
import com.bytedance.scene.State;
import com.bytedance.scene.exceptions.IllegalLifecycleException;
import com.bytedance.scene.p;
import com.bytedance.scene.utlity.SceneInternalException;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final HashMap<Scene, qa7.b> f268675h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final a f268676i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final GroupScene f268677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f268678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.scene.group.a f268679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Handler f268680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<Pair<Scene, String>> f268681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f268682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<g> f268683g;

    public static class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
        }
    }

    /* JADX INFO: renamed from: com.bytedance.scene.group.b$b, reason: collision with other inner class name */
    public class RunnableC3755b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Throwable f268684a;

        @Override // java.lang.Runnable
        public final void run() {
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        L3:
            throw this.f268684a;     // Catch: Throwable -> L4
        }

        public RunnableC3755b(Throwable r100) {
            this.f268684a = r100;
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f268685a = null;

        static {
            int[] r100 = new int[State.values().length];
            f268685a = r100;
            r100[State.NONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f268685a[State.VIEW_CREATED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f268685a[State.ACTIVITY_CREATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f268685a[State.STARTED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f268685a[State.RESUMED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    public final class d extends f {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final int f268686k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final String f268687l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final ja7.b f268688m;

        @Override // com.bytedance.scene.group.b.f
        public final void b(boolean r100) {
            if (r100 == true) goto L4;
            return;
        L4:
            this.f268688m.getClass();
        }

        public d(b r110, int r111, Scene r112, String r113) {
            GroupScene.a r100 = GroupScene.f268654t;
            State r101 = State.RESUMED;
            State r102 = r110.f268677a.f268590h;
            if (r101.value >= r102.value) goto L5;
            State r103 = r101;
        L6:
            super(r110, r112, r111, r113, r103, true, false, false);
            this.f268686k = r111;
            this.f268687l = r113;
            this.f268688m = r100;
            return;
        L5:
            r103 = r102;
            goto L6
        }
    }

    public final class e extends f {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final ja7.b f268689k;

        @Override // com.bytedance.scene.group.b.f
        public final void b(boolean r100) {
            Scene r101 = this.f268694a;
            if (r101.f268586d != null) goto L5;
            return;
        L5:
            b.j(r101, 8);
            if (r100 == true) goto L8;
            return;
        L8:
            this.f268689k.getClass();
        }

        public e(b r110, Scene r111) {
            GroupScene.a r100 = GroupScene.f268654t;
            State r101 = State.ACTIVITY_CREATED;
            State r102 = r110.f268677a.f268590h;
            if (r101.value >= r102.value) goto L5;
            State r103 = r101;
        L6:
            super(r110, r111, -1, null, r103, false, true, false);
            this.f268689k = r100;
            return;
        L5:
            r103 = r102;
            goto L6
        }
    }

    public abstract class f extends g {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final int f268690g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f268691h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final State f268692i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public final /* synthetic */ b f268693j;

        public abstract void b(boolean r100);

        public void c(boolean r100) {
        }

        public final void a(a r110) {
            HashMap<Scene, qa7.b> r100 = b.f268675h;
            qa7.b r101 = r100.get(this.f268694a);
            if (r101 == null) goto L10;
            r101.a();
            if (r100.get(this.f268694a) == null) goto L10;
            throw new SceneInternalException("CancellationSignal cancel callback should remove target Scene from CancellationSignal map");
        L10:
            if (this.f268693j.d(this.f268694a) == false) goto L12;
        L16:
            boolean r102 = false;
            if (this.f268696c == false) goto L20;
            this.f268693j.f268679c.a(this.f268694a).f268650d = false;
        L20:
            if (this.f268697d == false) goto L23;
            this.f268693j.f268679c.a(this.f268694a).f268650d = true;
        L23:
            if (this.f268694a.f268590h == this.f268692i) goto L25;
            r102 = true;
        L25:
            c(r102);
            this.f268693j.b(this.f268694a);
            b r103 = this.f268693j;
            r103.i(r103.f268677a, this.f268694a, this.f268692i, this.f268698e, new com.bytedance.scene.group.f(this));
            if (this.f268698e == false) goto L28;
            com.bytedance.scene.group.a r104 = this.f268693j.f268679c;
            GroupRecord r105 = r104.a(this.f268694a);
            ((ArrayList) r104.f268672a).remove(r105);
            ((HashMap) r104.f268673b).remove(r105.f268648b);
            ((HashMap) r104.f268674c).remove(r105.f268649c);
        L28:
            b(r102);
            r110.getClass();
            return;
        L12:
            if (this.f268694a.f268590h != State.NONE) goto L15;
            qa7.g.d(this.f268691h, "tag can't be null");
            com.bytedance.scene.group.a r106 = this.f268693j.f268679c;
            int r107 = this.f268690g;
            Scene r108 = this.f268694a;
            String r109 = this.f268691h;
            GroupRecord r111 = new GroupRecord();
            r111.f268647a = r107;
            qa7.g.d(r108, "scene can't be null");
            r111.f268648b = r108;
            qa7.g.d(r109, "tag can't be null");
            r111.f268649c = r109;
            r111.f268652f = r108.getClass().getName();
            ((ArrayList) r106.f268672a).add(r111);
            ((HashMap) r106.f268673b).put(r111.f268648b, r111);
            ((HashMap) r106.f268674c).put(r111.f268649c, r111);
            goto L16
        L15:
            throw new SceneInternalException("Scene state is " + this.f268694a.f268590h.name + " but it is not added to record list");
        }

        public f(b r100, Scene r101, int r110, String r111, State r112, boolean r113, boolean r114, boolean r115) {
            this.f268693j = r100;
            super(r100, r101, r112, r113, r114, r115);
            if (r113 == false) goto L8;
            if (r114 == false) goto L8;
            throw new IllegalArgumentException("cant forceShow with forceHide");
        L8:
            this.f268690g = r110;
            this.f268691h = r111;
            this.f268692i = r112;
        }
    }

    public abstract class g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Scene f268694a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final State f268695b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f268696c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f268697d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f268698e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ b f268699f;

        public g(b r100, Scene r101, State r102, boolean r103, boolean r104, boolean r105) {
            this.f268699f = r100;
            this.f268694a = r101;
            this.f268695b = r102;
            this.f268696c = r103;
            this.f268697d = r104;
            this.f268698e = r105;
        }
    }

    public final class h extends f {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final ja7.b f268700k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final boolean f268701l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final View f268702m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public final ViewGroup f268703n;

        @Override // com.bytedance.scene.group.b.f
        public final void b(boolean r100) {
        }

        @Override // com.bytedance.scene.group.b.f
        public final void c(boolean r100) {
            if (r100 == true) goto L5;
            return;
        L5:
            if (this.f268701l == true) goto L7;
            return;
        L7:
            this.f268700k.getClass();
        }

        public h(b r110, Scene r111) {
            GroupScene.a r100 = GroupScene.f268654t;
            super(r110, r111, -1, null, State.NONE, false, false, true);
            this.f268700k = r100;
            View r112 = r111.f268586d;
            if (r112 != null) goto L5;
        L7:
            boolean r113 = false;
        L8:
            this.f268701l = r113;
            if (r113 == false) goto L11;
            View r114 = r111.f268586d;
            this.f268702m = r114;
            this.f268703n = (ViewGroup) r114.getParent();
            return;
        L11:
            this.f268702m = null;
            this.f268703n = null;
            return;
        L5:
            if (r112.getParent() == null) goto L7;
            r113 = true;
            goto L8
        }
    }

    public final class i extends f {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final ja7.b f268704k;

        @Override // com.bytedance.scene.group.b.f
        public final void b(boolean r100) {
            if (r100 == true) goto L5;
            return;
        L5:
            if (this.f268694a.f268586d != null) goto L7;
            return;
        L7:
            this.f268704k.getClass();
        }

        @Override // com.bytedance.scene.group.b.f
        public final void c(boolean r100) {
            Scene r101 = this.f268694a;
            if (r101.f268586d != null) goto L5;
            return;
        L5:
            b.j(r101, 0);
        }

        public i(b r110, Scene r111) {
            GroupScene.a r100 = GroupScene.f268654t;
            State r101 = State.RESUMED;
            State r102 = r110.f268677a.f268590h;
            if (r101.value >= r102.value) goto L5;
            State r103 = r101;
        L6:
            super(r110, r111, -1, null, r103, true, false, false);
            this.f268704k = r100;
            return;
        L5:
            r103 = r102;
            goto L6
        }
    }

    public final class j extends f {
        @Override // com.bytedance.scene.group.b.f
        public final void b(boolean r100) {
            Scene r101 = this.f268694a;
            if (r101.f268586d != null) goto L5;
            return;
        L5:
            if (this.f268697d == false) goto L9;
            b.j(r101, 8);
            return;
        }

        @Override // com.bytedance.scene.group.b.f
        public final void c(boolean r100) {
            Scene r101 = this.f268694a;
            if (r101.f268586d != null) goto L5;
            return;
        L5:
            if (this.f268696c == false) goto L9;
            b.j(r101, 0);
            return;
        }

        public j(b r100, Scene r101, int r102, String r103, State r104, boolean r105, boolean r106, boolean r107) {
            super(r100, r101, r102, r103, r104, r105, r106, r107);
        }
    }

    static {
        f268675h = new HashMap();
        f268676i = new a();
    }

    public final List<Scene> g() {
        com.bytedance.scene.group.a r100 = this.f268679c;
        r100.getClass();
        ArrayList r101 = new ArrayList();
        Iterator<GroupRecord> r102 = r100.f268672a.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(r102.next().f268648b);
        goto L4
    L7:
        return Collections.unmodifiableList(r101);
    }

    public b(GroupScene r100) {
        this.f268679c = new com.bytedance.scene.group.a();
        this.f268680d = new Handler(Looper.getMainLooper());
        this.f268681e = new HashSet();
        this.f268682f = false;
        this.f268683g = new ArrayList();
        this.f268677a = r100;
    }

    public static void e(f r100) {
        r100.a(f268676i);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r100.f268699f.f268680d.post(new com.bytedance.scene.group.g(th));
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static p f(Scene r100) {
        if (r100 != 0) goto L6;
        return null;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        Scene r101 = r100.f268587e;
        if (r101 != null) goto L12;
        return null;
    L12:
        return f(r101);
    L8:
        return (p) r100;
    }

    public final void b(Scene r100) {
        Iterator r101 = ((HashSet) this.f268681e).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        if (((Pair) r101.next()).first != r100) goto L4;
        throw new SceneInternalException("Target scene " + r100.getClass().getCanonicalName() + " is already tracked");
    L10:
        p r102 = f(this.f268677a.f268587e);
        if (r102 == null) goto L13;
        String r103 = r102.b(r100.toString());
    L14:
        ((HashSet) this.f268681e).add(Pair.create(r100, r103));
        return;
    L13:
        r103 = null;
        goto L14
    }

    public final void c(Scene r100) {
        Iterator r101 = ((HashSet) this.f268681e).iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        if (((Pair) r101.next()).first != r100) goto L4;
        throw new IllegalLifecycleException("Cant add/remove/show/hide " + r100.getClass().getCanonicalName() + " before it finish previous add/remove/show/hide operation or in its lifecycle method");
    }

    public final boolean d(Scene r100) {
        List r101 = Collections.unmodifiableList(this.f268679c.f268672a);
        int r102 = 0;
    L4:
        if (r102 >= r101.size()) goto L10;
        if (((GroupRecord) ListProtector.get(r101, r102)).f268648b == r100) goto L7;
        r102 = r102 + 1;
        goto L4
    L7:
        return true;
    L10:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void a(b r100, Scene r101) {
        Iterator r102 = ((HashSet) r100.f268681e).iterator();
    L4:
        if (r102.hasNext() == false) goto L8;
        Pair r103 = (Pair) r102.next();
        if (r103.first != r101) goto L4;
    L9:
        if (r103 == null) goto L16;
        if (((String) r103.second) == null) goto L13;
        f(r100.f268677a.f268587e).e((String) r103.second);
    L13:
        ((HashSet) r100.f268681e).remove(r103);
        return;
    L16:
        throw new SceneInternalException("Target scene " + r101.getClass().getCanonicalName() + " is not tracked");
    L8:
        r103 = null;
        goto L9
    }

    public static void j(Scene r100, int r101) {
        View r102 = r100.f268586d;
        if (r102.getVisibility() == r101) goto L6;
        r102.setVisibility(r101);
        return;
    }

    public static void h(GroupScene r100, Scene r101, State r102, boolean r110, Runnable r111) {
        State r103 = r101.f268590h;
        if (r103 != r102) goto L7;
        r111.run();
        return;
    L7:
        if (r103.value >= r102.value) goto L38;
        int r104 = c.f268685a[r103.ordinal()];
        if (r104 == 1) goto L18;
        if (r104 == 2) goto L17;
        if (r104 == 3) goto L16;
        if (r104 != 4) goto L15;
        r101.M();
        h(r100, r101, r102, r110, r111);
        return;
    L15:
        throw new SceneInternalException("unreachable state case " + r103.getName());
    L16:
        r101.O();
        h(r100, r101, r102, r110, r111);
        return;
    L17:
        GroupRecord r105 = r100.f268655q.f268679c.a(r101);
        r101.g(r105.f268653g);
        r105.f268653g = null;
        h(r100, r101, r102, r110, r111);
        return;
    L18:
        r101.h(r100.h0());
        r101.i(r100);
        GroupRecord r106 = r100.f268655q.f268679c.a(r101);
        Bundle r107 = r106.f268653g;
        r101.j(r107);
        int r108 = r100.f268655q.f268679c.a(r101).f268647a;
        ViewGroup r109 = (ViewGroup) r100.f268586d.findViewById(r108);
        if (r109 == null) goto L60;
        ViewGroup r112 = r109;
    L21:
        if (r112 == null) goto L30;
        if (r112 == r100.f268586d) goto L30;
        Scene r113 = (Scene) r112.getTag(R.id.bytedance_scene_view_scene_tag);
        if (r113 != null) goto L29;
        r112 = (ViewGroup) r112.getParent();
        goto L21
    L29:
        throw new IllegalArgumentException(String.format("cant add Scene to child Scene %s view hierarchy ", new Object[]{r113.toString()}));
    L30:
        r101.k(r107, r109);
        r109.addView(r101.f268586d);
        if (r106.f268650d == false) goto L33;
        j(r101, 8);
    L33:
        h(r100, r101, r102, r110, r111);
        return;
    L60:
        throw new IllegalArgumentException(" " + r100.getResources().getResourceName(r108) + " view not found");     // Catch: Resources.NotFoundException -> L36
    L37:
        throw new IllegalArgumentException(" " + r108 + " view not found");
    L38:
        int r114 = c.f268685a[r103.ordinal()];
        if (r114 == 2) goto L53;
        if (r114 == 3) goto L49;
        if (r114 != 4) goto L43;
        r101.P();
        h(r100, r101, r102, r110, r111);
        return;
    L43:
        if (r114 != 5) goto L46;
        r101.L();
        h(r100, r101, r102, r110, r111);
        return;
    L46:
        throw new SceneInternalException("unreachable state case " + r103.getName());
    L49:
        if (r102 != State.VIEW_CREATED) goto L53;
        throw new IllegalArgumentException("cant switch state ACTIVITY_CREATED to VIEW_CREATED");
    L53:
        View r115 = r101.f268586d;
        r101.m();
        if (r110 == false) goto L58;
        ViewParent r116 = r115.getParent();
        if ((r116 instanceof ViewGroup) == false) goto L58;
        ((ViewGroup) r116).removeView(r115);
    L58:
        r101.l();
        r101.p();
        r101.o();
        h(r100, r101, r102, r110, r111);
    }

    public final void i(GroupScene r100, Scene r101, State r102, boolean r103, Runnable r104) {
        h(r100, r101, r102, r103, r104);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        this.f268680d.post(new RunnableC3755b(th));
        throw th;
    }
}
