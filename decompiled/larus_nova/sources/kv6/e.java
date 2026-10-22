package kv6;

import android.content.Context;
import com.bytedance.locallife.live.experiment.LiveLocalLifeMultiThreadOPT;
import com.bytedance.locallife.live.experiment.a0;
import com.bytedance.locallife.live.experiment.m0;
import com.bytedance.locallife.live.experiment.r0;
import com.bytedance.locallife.live.lynx.LiveLocalLifeLynxView;
import com.bytedance.locallife.live.util.m;
import com.bytedance.locallife.live.util.n;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class e {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static e f506279i;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f506280a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LiveLocalLifeLynxView f506281b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedList<LiveLocalLifeLynxView> f506282c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LiveLocalLifeLynxView f506283d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LiveLocalLifeLynxView f506284e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CopyOnWriteArrayList<LiveLocalLifeLynxView> f506285f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f506286g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f506287h;

    public static final class a {
    }

    static {
    }

    public final void g() {
        f506279i = null;
        LiveLocalLifeLynxView r100 = this.f506281b;
        if (r100 == null) goto L5;
        r100.e();
    L5:
        Iterator<T> r101 = this.f506282c.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((LiveLocalLifeLynxView) r101.next()).e();
        goto L7
    L9:
        this.f506282c.clear();
        Iterator<T> r102 = this.f506285f.iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        ((LiveLocalLifeLynxView) r102.next()).e();
        goto L11
    L13:
        this.f506285f.clear();
        LiveLocalLifeLynxView r103 = this.f506283d;
        if (r103 == null) goto L16;
        r103.e();
    L16:
        LiveLocalLifeLynxView r104 = this.f506284e;
        if (r104 == null) goto L22;
        r104.e();
        return;
    }

    public e(String r100) {
        this.f506280a = r100;
        this.f506282c = new LinkedList();
        this.f506285f = new CopyOnWriteArrayList();
    }

    public final LiveLocalLifeLynxView a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f506283d != null) goto L5;
        this.f506283d = new LiveLocalLifeLynxView(r100, null, 0, this.f506280a, 6);
    L5:
        LiveLocalLifeLynxView r101 = this.f506283d;
        if (r101 == null) goto L8;
        return r101;
    L8:
        return new LiveLocalLifeLynxView(r100, null, 0, this.f506280a, 6);
    }

    public final LiveLocalLifeLynxView b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f506281b != null) goto L5;
        this.f506281b = new LiveLocalLifeLynxView(r100, null, 0, this.f506280a, 6);
    L5:
        LiveLocalLifeLynxView r101 = this.f506281b;
        if (r101 == null) goto L8;
        return r101;
    L8:
        return new LiveLocalLifeLynxView(r100, null, 0, this.f506280a, 6);
    }

    public final LiveLocalLifeLynxView c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f506284e != null) goto L5;
        this.f506284e = new LiveLocalLifeLynxView(r100, null, 0, this.f506280a, 6);
    L5:
        LiveLocalLifeLynxView r101 = this.f506284e;
        if (r101 == null) goto L8;
        return r101;
    L8:
        return new LiveLocalLifeLynxView(r100, null, 0, this.f506280a, 6);
    }

    public final void d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f506287h == false) goto L5;
        return;
    L5:
        boolean r101 = true;
        this.f506287h = true;
        String r102 = com.bytedance.locallife.live.settings.c.n();
        if (r102.length() != 0) goto L8;
        boolean r103 = true;
    L10:
        if (r103 == true) goto L13;
        LiveLocalLifeLynxView.a(b(r100), r102, null, 0, 6);
    L13:
        String r104 = com.bytedance.locallife.live.settings.c.m();
        if (r104.length() != 0) goto L16;
        boolean r105 = true;
    L17:
        if (r105 == true) goto L21;
        LiveLocalLifeLynxView.a(a(r100), r104, null, 0, 6);
    L21:
        if (m0.a() == false) goto L23;
    L31:
        e(r100);
        m r106 = n.f260724a;
        LinkedHashMap r107 = new LinkedHashMap();
        r107.put("type", "other");
        Unit r108 = Unit.INSTANCE;
        n.a("lynx_view_preload", r107);
        return;
    L23:
        if (r0.a() == true) goto L31;
        String r109 = com.bytedance.locallife.live.settings.c.g();
        if (r109.length() == 0) goto L28;
        r101 = false;
    L28:
        if (r101 == true) goto L31;
        LiveLocalLifeLynxView.a(c(r100), r109, null, 0, 6);
        goto L31
    L16:
        r105 = false;
        goto L17
    L8:
        r103 = false;
        goto L10
    }

    public final void e(Context r110) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (a0.a() == true) goto L5;
        return;
    L5:
        boolean r100 = false;
        if (m0.a() == false) goto L15;
        String r101 = com.bytedance.locallife.live.settings.c.h();
        if (r101.length() != 0) goto L10;
        r100 = true;
    L10:
        if (r100 == false) goto L13;
        return;
    L13:
        if (this.f506285f.isEmpty() == false) goto L24;
        LiveLocalLifeLynxView r102 = new LiveLocalLifeLynxView(r110, null, 0, this.f506280a, 6);
        LiveLocalLifeLynxView.a(r102, r101, null, LiveLocalLifeMultiThreadOPT.a(), 2);
        this.f506285f.add(r102);
        return;
    L24:
        return;
    L15:
        String r103 = com.bytedance.locallife.live.settings.c.c();
        if (r103.length() != 0) goto L18;
        r100 = true;
    L18:
        if (r100 == false) goto L21;
        return;
    L21:
        if (this.f506282c.isEmpty() == false) goto L26;
        LiveLocalLifeLynxView r104 = new LiveLocalLifeLynxView(r110, null, 0, this.f506280a, 6);
        LiveLocalLifeLynxView.a(r104, r103, null, LiveLocalLifeMultiThreadOPT.a(), 2);
        this.f506282c.add(r104);
        return;
    }

    public final void f(LiveLocalLifeLynxView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        if (m0.a() == true) goto L5;
        this.f506282c.add(r100);
        return;
    L5:
        if (this.f506285f.contains(r100) == true) goto L9;
        this.f506285f.add(r100);
        return;
    }
}
