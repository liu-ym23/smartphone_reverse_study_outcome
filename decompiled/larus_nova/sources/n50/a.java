package n50;

import android.opengl.Matrix;
import com.bytedance.android.live.core.gl.camera.BaseCamera;
import com.bytedance.android.live.core.gl.primitive.e;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import k50.f;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<m50.b> f517987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public f f517988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, List<Integer>> f517989c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final b f517990d;

    /* JADX INFO: renamed from: n50.a$a, reason: collision with other inner class name */
    public static final class C6892a {
    }

    static {
    }

    public a() {
        this(new b());
    }

    public final void b() {
        ArrayList<m50.b> r100 = this.f517987a;
        monitor-enter(r100);
        this.f517987a.clear();     // Catch: Throwable -> L8
        Unit r101 = Unit.INSTANCE;     // Catch: Throwable -> L8
        monitor-exit(r100);
        ((LinkedHashMap) this.f517989c).clear();
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public a(b r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneParams");
        this.f517990d = r100;
        this.f517987a = new ArrayList();
        this.f517989c = new LinkedHashMap();
    }

    public final void a(r50.b r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ArrayList<m50.b> r101 = this.f517987a;
        monitor-enter(r101);
        this.f517987a.add(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void c(f r110) {
        Intrinsics.checkNotNullParameter(r110, "rendererParams");
        BaseCamera r100 = this.f517990d.f517991a;
        int r101 = 0;
        Matrix.setIdentityM(r100.f64801c, 0);
        float[] r102 = r100.f64801c;
        e r103 = r100.f64802d;
        float r104 = r103.f64841a;
        float r105 = r103.f64842b;
        float r106 = r103.f64843c;
        e r107 = r100.f64803e;
        float r108 = r107.f64841a;
        float r109 = r107.f64842b;
        float r111 = r107.f64843c;
        e r112 = r100.f64804f;
        Matrix.setLookAtM(r102, 0, r104, r105, r106, r108, r109, r111, r112.f64841a, r112.f64842b, r112.f64843c);
        ArrayList<m50.b> r113 = this.f517987a;
        monitor-enter(r113);
        int r114 = this.f517987a.size();     // Catch: Throwable -> L10
    L5:
        if (r101 >= r114) goto L7;
        this.f517987a.get(r101).a(r110, this.f517990d);     // Catch: Throwable -> L10
        r101 = r101 + 1;     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r115 = Unit.INSTANCE;     // Catch: Throwable -> L10
        monitor-exit(r113);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final void e(r50.b r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        ArrayList<m50.b> r101 = this.f517987a;
        monitor-enter(r101);
        this.f517987a.remove(r100);     // Catch: Throwable -> L7
        monitor-exit(r101);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void d(f r100, int r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, "rendererParams");
        BaseCamera r103 = this.f517990d.f517991a;
        int[] r104 = r103.f64799a;
        r104[0] = 0;
        r104[1] = 0;
        r104[2] = r101;
        r104[3] = r102;
        r103.a();
    }
}
