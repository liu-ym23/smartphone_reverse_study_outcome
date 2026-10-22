package la7;

import android.graphics.drawable.Drawable;
import androidx.core.os.CancellationSignal;
import androidx.core.view.ViewCompat;
import com.bytedance.scene.Scene;
import com.bytedance.scene.navigation.NavigationScene;
import com.bytedance.scene.ui.template.SwipeBackGroupScene;
import java.util.Iterator;
import java.util.List;
import qa7.g;

/* JADX INFO: loaded from: classes19.dex */
public abstract class d {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static CancellationSignal f508210k;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public NavigationScene f508211a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<ma7.a> f508212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f508213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f508214d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Scene f508215e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Scene f508216f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Drawable f508217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f508218h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f508219i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public CancellationSignal f508220j;

    public class a extends ma7.a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ d f508221d;

        public a(d r100) {
            this.f508221d = r100;
            super(0);
        }

        @Override // ma7.a
        public final void a(float r100) {
            b r101 = this.f508221d.f508219i;
            if (r101 == null) goto L6;
            r101.onProgress(r100);
            return;
        }
    }

    public interface b {
        void onFinish();

        void onProgress(float r100);

        void onStart();
    }

    public final void a() {
        if (f508210k != this.f508220j) goto L5;
        f508210k = null;
    L5:
        NavigationScene r100 = this.f508211a;
        if (r100.f268753r.f268817c == false) goto L8;
        ViewCompat.setBackground(r100.f268586d, g.b(r100.j0()));
    L8:
        this.f508216f.f268586d.setVisibility(this.f508218h);
        ViewCompat.setBackground(this.f508215e.f268586d, this.f508217g);
        SwipeBackGroupScene.a r101 = (SwipeBackGroupScene.a) this;
        ViewCompat.setElevation(r101.f268839m, 0.0f);
        r101.f268838l.setVisibility(8);
        r101.f268840n.getClass();
        b r102 = this.f508219i;
        if (r102 == null) goto L12;
        r102.onFinish();
        return;
    }

    public d() {
        this.f508213c = false;
    }

    public final void b(float r100) {
        if (this.f508213c == true) goto L5;
        return;
    L5:
        Iterator<ma7.a> r101 = this.f508212b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ma7.a r102 = r101.next();
        float r103 = Math.min(1.0f, r100 / r102.f512711a);
        r102.f512712b = r103;
        r102.a(r103);
        goto L7
    L9:
        this.f508214d = r100;
    }
}
