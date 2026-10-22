package u5a;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.lynx.clay.embedding.engine.renderer.FlutterRenderer;

/* JADX INFO: loaded from: classes32.dex */
public final class b {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static InputMethodManager f548889h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f548890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FlutterRenderer f548891b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f548892c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f548893d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public u5a.a f548894e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.lynx.clay.embedding.android.a f548895f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f548896g;

    public class a implements InterfaceC7836b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f548897a;

        public a(b r100) {
            this.f548897a = r100;
        }
    }

    /* JADX INFO: renamed from: u5a.b$b, reason: collision with other inner class name */
    public interface InterfaceC7836b {
    }

    public b(View r100, FlutterRenderer r101) {
        this.f548892c = 0;
        this.f548893d = 0;
        this.f548896g = false;
        this.f548890a = r100;
        this.f548891b = r101;
        if (f548889h != null) goto L5;
        f548889h = (InputMethodManager) r100.getContext().getApplicationContext().getSystemService("input_method");
    L5:
        a r102 = new a(this);
        r101.f380933a.setInputMethodHandler(r102);
    }
}
