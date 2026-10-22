package x70;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.live.core.tetris.layout.ViewState;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.debug.LocalTestManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap<Integer, HashSet<d>> f562770a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<? extends View>, ViewGroup> f562771b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f562772c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final C8199a f562773d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f562774e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Context f562775f;

    /* JADX INFO: renamed from: x70.a$a, reason: collision with other inner class name */
    public static final class C8199a implements c.e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f562776a;

        public C8199a(a r100) {
            this.f562776a = r100;
        }

        @Override // x70.c.e
        public final void a(View r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            LocalTestManager.a(new Class[]{wy.a.class});
            d r102 = new d(r100, ViewState.CREATED);
            HashSet<d> r103 = this.f562776a.f562770a.get(Integer.valueOf(r101));
            if (r103 == null) goto L5;
            r103.add(r102);
            return;
        L5:
            HashSet<d> r104 = new HashSet();
            this.f562776a.f562770a.put(Integer.valueOf(r101), r104);
            r104.add(r102);
        }
    }

    public final void g() {
        this.f562770a.clear();
        ((LinkedHashMap) this.f562771b).clear();
    }

    @Override // x70.b
    public final int f() {
        return this.f562774e;
    }

    public final Context getContext() {
        return this.f562775f;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f562775f = r100;
        this.f562770a = new HashMap();
        this.f562771b = new LinkedHashMap();
        this.f562772c = new c(r100);
        this.f562773d = new C8199a(this);
        this.f562774e = 1;
    }

    @Override // x70.b
    public final boolean a(int r100) {
        HashSet<d> r101 = this.f562770a.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        return false;
    L5:
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        if (((d) r103).f562793b != ViewState.CREATED) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L7;
    L15:
        if (r103 == null) goto L23;
        return true;
    L23:
        return false;
    L11:
        r104 = false;
        goto L12
    L14:
        r103 = null;
        goto L15
    }

    @Override // x70.b
    public final int c(int r100) {
        HashSet<d> r101 = this.f562770a.get(Integer.valueOf(r100));
        if (r101 != null) goto L7;
        return 0;
    L7:
        return r101.size();
    }

    @Override // x70.b
    public final View e(int r100) {
        HashSet<d> r101 = this.f562770a.get(Integer.valueOf(r100));
        if (r101 != null) goto L5;
        return null;
    L5:
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L14;
        Object r103 = r102.next();
        if (((d) r103).f562793b != ViewState.CREATED) goto L11;
        boolean r104 = true;
    L12:
        if (r104 == false) goto L7;
    L15:
        d r105 = (d) r103;
        if (r105 == null) goto L18;
        r101.remove(r105);
        ViewState r106 = ViewState.USING;
        Intrinsics.checkNotNullParameter(r106, "<set-?>");
        r105.f562793b = r106;
    L18:
        LocalTestManager.a(new Class[]{wy.a.class});
        if (r105 != null) goto L21;
        return null;
    L21:
        return r105.f562792a;
    L11:
        r104 = false;
        goto L12
    L14:
        r103 = null;
        goto L15
    }

    @Override // x70.b
    public final void d(int r100, Class<? extends View> r101) {
        if (r101 != null) goto L5;
        ViewGroup r102 = null;
    L10:
        this.f562772c.a(r100, r102, this.f562773d);
        return;
    L5:
        if (this.f562771b.containsKey(r101) == false) goto L7;
        r102 = (ViewGroup) ((LinkedHashMap) this.f562771b).get(r101);
        goto L10
    L7:
        View r103 = r101.getDeclaredConstructor(new Class[]{Context.class}).newInstance(new Object[]{this.f562775f});
        Map<Class<? extends View>, ViewGroup> r104 = this.f562771b;
        if (r103 == null) goto L13;
        ViewGroup r105 = (ViewGroup) r103;
        r104.put(r101, r105);
        r102 = r105;
        goto L10
    L13:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    @Override // x70.b
    public final View b(int r100, ViewGroup r101, boolean r102) {
        if (a(r100) == false) goto L11;
        View r103 = e(r100);
        if (r102 == false) goto L8;
        if (r101 == null) goto L8;
        r101.addView(r103);
    L8:
        if (r103 == null) goto L13;
        return r103;
    L13:
        return LayoutInflater.from(this.f562775f).inflate(r100, r101, r102);
    L11:
        return LayoutInflater.from(this.f562775f).inflate(r100, r101, r102);
    }
}
