package w6a;

import android.view.View;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, WeakReference<View>> f558464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final WeakHashMap<LynxUI, s6a.a> f558465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final WeakHashMap<LynxUI, s6a.a> f558466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final WeakHashMap<LynxUI, s6a.a> f558467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final WeakHashMap<LynxUI, s6a.a> f558468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final WeakHashMap<LynxUI, String> f558469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile boolean f558470g;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final h f558471a = null;

        static {
            f558471a = new h();
        }
    }

    public interface b {
    }

    public interface c {
        void a();
    }

    public h() {
        this.f558464a = new ConcurrentHashMap();
        this.f558465b = new WeakHashMap();
        this.f558466c = new WeakHashMap();
        this.f558467d = new WeakHashMap();
        this.f558468e = new WeakHashMap();
        this.f558469f = new WeakHashMap();
        this.f558470g = true;
    }

    public final void b(LynxView r100) {
        Iterator<LynxUI> r101 = this.f558467d.keySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        LynxUI r102 = r101.next();
        if (r102.getLynxContext().getUIBody().getBodyView() != r100) goto L4;
        r102.execResumeAnim();
        goto L4
    }

    public static void a(Map r100, LynxView r101) {
        Iterator r102 = ((WeakHashMap) r100).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L10;
        LynxUI r103 = (LynxUI) ((Map.Entry) r102.next()).getKey();
        if (r103 == null) goto L4;
        if (r103.getLynxContext().getUIBody().getBodyView() != r101) goto L4;
        r102.remove();
        goto L4
    }
}
