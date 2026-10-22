package tuc;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import xuc.d;

/* JADX INFO: loaded from: classes42.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SparseBooleanArray f547653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<Float> f547654b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f547655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f547656d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f547657e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f547658f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f547659g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f547660h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public a f547661i;

    public interface a {
    }

    public b() {
        this.f547653a = new SparseBooleanArray();
        this.f547654b = new SparseArray();
    }

    public final void a(int r100) {
        a r101 = this.f547661i;
        if (r101 == null) goto L10;
        int r102 = this.f547655c;
        LinearLayout r103 = ((wuc.a) r101).f561487b;
        if (r103 == null) goto L10;
        KeyEvent.Callback r104 = r103.getChildAt(r100);
        if ((r104 instanceof d) == false) goto L10;
        ((d) r104).b(r100, r102);
    L10:
        this.f547653a.put(r100, true);
    }

    public final void d(int r100) {
        a r101 = this.f547661i;
        if (r101 == null) goto L36;
        int r102 = this.f547655c;
        wuc.a r103 = (wuc.a) r101;
        LinearLayout r104 = r103.f561487b;
        if (r104 == null) goto L36;
        KeyEvent.Callback r105 = r104.getChildAt(r100);
        if ((r105 instanceof d) == false) goto L11;
        ((d) r105).a(r100, r102);
    L11:
        if (r103.f561492g == true) goto L36;
        if (r103.f561496k == true) goto L36;
        if (r103.f561486a == null) goto L36;
        if (((ArrayList) r103.f561501p).size() <= 0) goto L36;
        zuc.a r106 = (zuc.a) ListProtector.get(r103.f561501p, Math.min(((ArrayList) r103.f561501p).size() - 1, r100));
        if (r103.f561493h == false) goto L24;
        int r107 = r106.f573672a;
        float r108 = (r107 + ((r106.f573674c - r107) / 2)) - (r103.f561486a.getWidth() * r103.f561494i);
        if (r103.f561495j == false) goto L23;
        r103.f561486a.smoothScrollTo((int) r108, 0);
        goto L36
    L23:
        r103.f561486a.scrollTo((int) r108, 0);
        goto L36
    L24:
        int r109 = r103.f561486a.getScrollX();
        int r110 = r106.f573672a;
        if (r109 > r110) goto L27;
        int r111 = r103.f561486a.getScrollX() + r103.getWidth();
        int r112 = r106.f573674c;
        if (r111 >= r112) goto L36;
        if (r103.f561495j == false) goto L35;
        r103.f561486a.smoothScrollTo(r112 - r103.getWidth(), 0);
        goto L36
    L35:
        r103.f561486a.scrollTo(r112 - r103.getWidth(), 0);
        goto L36
    L27:
        if (r103.f561495j == false) goto L29;
        r103.f561486a.smoothScrollTo(r110, 0);
        goto L36
    L29:
        r103.f561486a.scrollTo(r110, 0);
    L36:
        this.f547653a.put(r100, false);
    }

    public final void b(int r100, float r101, boolean r102, boolean r103) {
        if (this.f547660h == false) goto L5;
    L9:
        a r104 = this.f547661i;
        if (r104 == null) goto L17;
        int r105 = this.f547655c;
        LinearLayout r106 = ((wuc.a) r104).f561487b;
        if (r106 == null) goto L17;
        KeyEvent.Callback r107 = r106.getChildAt(r100);
        if ((r107 instanceof d) == false) goto L17;
        ((d) r107).c(r100, r105, r101, r102);
    L17:
        this.f547654b.put(r100, Float.valueOf(1.0f - r101));
        return;
    L5:
        if (r100 == this.f547656d) goto L9;
        if (this.f547659g == 1) goto L9;
        if (r103 == true) goto L9;
    }

    public final void c(int r100, float r101, boolean r102, boolean r103) {
        if (this.f547660h == false) goto L5;
    L15:
        a r104 = this.f547661i;
        if (r104 == null) goto L23;
        int r105 = this.f547655c;
        LinearLayout r106 = ((wuc.a) r104).f561487b;
        if (r106 == null) goto L23;
        KeyEvent.Callback r107 = r106.getChildAt(r100);
        if ((r107 instanceof d) == false) goto L23;
        ((d) r107).d(r100, r105, r101, r102);
    L23:
        this.f547654b.put(r100, Float.valueOf(r101));
        return;
    L5:
        if (r100 == this.f547657e) goto L15;
        if (this.f547659g == 1) goto L15;
        int r108 = this.f547656d;
        if (r100 == (r108 - 1)) goto L13;
        if (r100 == (r108 + 1)) goto L13;
    L14:
        if (r103 == true) goto L15;
        return;
    L13:
        if (this.f547654b.get(r100, Float.valueOf(0.0f)).floatValue() != 1.0f) goto L15;
        goto L14
    }
}
