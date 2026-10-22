package li9;

import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f509442a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final SparseArray<a> f509443b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Set<f> f509444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f509445b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f509444a, r101.f509444a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f509445b, r101.f509445b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f509444a.hashCode() * 31) + this.f509445b.hashCode();
        }

        public final String toString() {
            return "TracingData(traceModelSet=" + this.f509444a + ", shownCellIdSet=" + this.f509445b + ')';
        }

        public a(Set<f> r100, Set<String> r101) {
            Intrinsics.checkNotNullParameter(r100, "traceModelSet");
            Intrinsics.checkNotNullParameter(r101, "shownCellIdSet");
            this.f509444a = r100;
            this.f509445b = r101;
        }
    }

    public e() {
    }

    static {
        f509442a = new e();
        f509443b = new SparseArray();
    }

    public static void a(int r110, int r111) {
        a r112 = f509443b.get(r110);
        if (r112 != null) goto L5;
        return;
    L5:
        if (r112.f509444a.size() == 0) goto L77;
        Iterator<T> r100 = r112.f509444a.iterator();
        HashSet r101 = null;
    L9:
        if (r100.hasNext() == false) goto L58;
        f r102 = (f) r100.next();
        if (r102.f509446a.f().contains(Integer.valueOf(r111)) == false) goto L9;
        View r103 = r102.a().get();
        if (r103 == null) goto L15;
        e r104 = f509442a;
        float r105 = r102.f509446a.d();
        r102.f509446a.e();
        r104.getClass();
        boolean r106 = true;
        boolean r107 = false;
        if (r103.isAttachedToWindow() == true) goto L19;
    L25:
        boolean r108 = true;
    L26:
        if (r108 == false) goto L29;
    L51:
        String r109 = r102.f509446a.a().invoke();
        if (r109 == null) goto L9;
        boolean r113 = r112.f509445b.contains(r109);
        if (r107 == false) goto L9;
        if (r113 == true) goto L9;
        r112.f509445b.add(r109);
        r102.f509446a.b().invoke();
        goto L9
    L29:
        if (r103.getWidth() > 0) goto L31;
    L36:
        boolean r114 = true;
    L37:
        if (r114 == true) goto L51;
        Rect r115 = new Rect();
        if (r103.getGlobalVisibleRect(r115) == false) goto L51;
        int r116 = r103.getMeasuredWidth();
        int r117 = r103.getMeasuredHeight();
        if (r105 > 0.0f) goto L45;
        float r118 = 1.0f;
    L47:
        if ((r115.height() * r115.width()) >= r118) goto L50;
        r106 = false;
    L50:
        r107 = r106;
        goto L51
    L45:
        r118 = (r116 * r117) * r105;
        goto L47
    L31:
        if (r103.getHeight() <= 0) goto L36;
        if (r103.getAlpha() <= 0.0f) goto L36;
        r114 = false;
        goto L37
    L19:
        if (r103.hasWindowFocus() == false) goto L25;
        if (r103.isShown() == false) goto L25;
        r108 = false;
        goto L26
    L15:
        r101 = new HashSet();
        r101.add(r102);
        goto L9
    L58:
        if (r101 == null) goto L76;
        r112.f509444a.removeAll(r101);
        return;
    L76:
        return;
    }
}
