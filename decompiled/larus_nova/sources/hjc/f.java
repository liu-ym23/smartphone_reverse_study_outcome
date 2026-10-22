package hjc;

import android.view.View;
import com.ss.android.widget.slider.ProgressListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes40.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f485508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f485509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f485510c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f485511d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<ProgressListener> f485512e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f485513f;

    public class a implements e {
        @Override // hjc.f.e
        public final void a(f r100) {
        }

        public a() {
        }
    }

    public static abstract class b {
        public b() {
        }

        public abstract void a(f r100, View r101, int r102, int r103);
    }

    public static abstract class c {
        public c() {
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public hjc.b.a f485514a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public b f485515b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public b f485516c;

        public d() {
        }
    }

    public interface e {
        void a(f r100);
    }

    public f(int r100) {
        this.f485509b = new a();
        this.f485512e = new ArrayList();
        this.f485513f = true;
        this.f485508a = r100;
    }

    public final void a(float r100, int r101) {
        Iterator r102 = ((ArrayList) this.f485512e).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((ProgressListener) r102.next()).a(r100, r101);
        goto L4
    }
}
