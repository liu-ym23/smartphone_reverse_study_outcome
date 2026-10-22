package o5a;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.engine.plugins.platformview.InternalPlatformViewRegistry;
import com.lynx.clay.embedding.engine.plugins.platformview.LynxUIClayUIBridge$CompositionPreference;
import com.lynx.clay.embedding.engine.plugins.platformview.PlatformMethodCallbackResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import n5a.j;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final class f extends com.lynx.clay.embedding.engine.plugins.platformview.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Context f522135h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f522136i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f522137j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final List<b> f522138k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final a f522139l;

    public class a implements View.OnAttachStateChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f522140a;

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r100) {
        }

        public a(f r100) {
            this.f522140a = r100;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r100) {
            f r101 = this.f522140a;
            r101.getClass();
            View r102 = r101.f522137j;
            if (r102 == null) goto L6;
            r102.removeOnAttachStateChangeListener(r101.f522139l);
            r101.f522137j = null;
        L6:
            this.f522140a.getClass();
        }
    }

    public static final class b {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final boolean d(String r100, JSONObject r101, n5a.a r102) {
        return false;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void g() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void j() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void l() {
        this.f522136i = false;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void m() {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void n(String r100, Object r101) {
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void h() {
        View r100 = this.f522137j;
        if (r100 == null) goto L6;
        r100.removeOnAttachStateChangeListener(this.f522139l);
        this.f522137j = null;
    L6:
        Iterator r101 = ((ArrayList) this.f522138k).iterator();
        if (r101.hasNext() == true) goto L10;
        ((ArrayList) this.f522138k).clear();
        this.f522136i = false;
        return;
    L10:
        ((b) r101.next()).getClass();
        PlatformMethodCallbackResult r102 = PlatformMethodCallbackResult.NODE_NOT_FOUND;
        throw null;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void k() {
        boolean r100 = this.f522136i;
        this.f522136i = true;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final View a(Context r100) {
        Context r101 = this.f522135h;
        if (r101 != null) goto L29;
        WeakHashMap<Context, WeakReference<Context>> r102 = n5a.g.f518058a;
        monitor-enter(n5a.g.class);
        Context r103 = null;
        if (r100 != null) goto L37;
        monitor-exit(n5a.g.class);
    L10:
        r101 = r103;
        goto L29
    L37:
        WeakHashMap<Context, WeakReference<Context>> r104 = n5a.g.f518058a;     // Catch: Throwable -> L34
        WeakReference<Context> r105 = r104.get(r100);     // Catch: Throwable -> L34
        if (r105 == null) goto L17;
        r103 = r105.get();     // Catch: Throwable -> L34
        if (r103 != null) goto L17;
        r104.remove(r100);     // Catch: Throwable -> L34
    L17:
        Iterator<Map.Entry<Context, WeakReference<Context>>> r106 = r104.entrySet().iterator();     // Catch: Throwable -> L34
    L18:
        if (r106.hasNext() == false) goto L26;
        WeakReference<Context> r107 = r106.next().getValue();     // Catch: Throwable -> L34
        if (r107 == null) goto L24;
        if (r107.get() != null) goto L18;
    L24:
        r106.remove();     // Catch: Throwable -> L34
        goto L18
    L26:
        monitor-exit(n5a.g.class);
    L34:
        th = move-exception;
        throw th;
    L29:
        if (r101 != null) goto L32;
        c5a.c.d(6, "InternalPlatformViewWrapper", "No LynxContext found for " + this.f380855a);
        return new FrameLayout(r100);
    L32:
        c5a.c.d(6, "InternalPlatformViewWrapper", "No LynxUIClayUIBridge provider found for " + this.f380855a);
        return new FrameLayout(r100);
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void o(j r100) {
        this.f380857c = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void p(List<String> r100) {
        this.f380858d = r100;
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void i(int r100, int r101, int r102, int r103) {
        b();
    }

    @Override // com.lynx.clay.embedding.engine.plugins.platformview.a
    public final void r(float r100, float r101, float r102, float r103) {
        super.r(r100, r101, r102, r103);
        b();
    }

    public f(Context r100, int r101, String r102, LynxUIClayUIBridge$CompositionPreference r103, InternalPlatformViewRegistry.ViewDrawType r104) {
        super(r100, r101, r102);
        this.f522136i = false;
        this.f522138k = new ArrayList();
        this.f522139l = new a(this);
        this.f380861g = r103;
        this.f380860f = r104;
    }
}
