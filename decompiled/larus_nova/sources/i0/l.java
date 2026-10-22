package i0;

import android.graphics.Matrix;
import android.graphics.Path;
import com.airbnb.lottie.model.content.MergePaths;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes28.dex */
public final class l implements m, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f487790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f487791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f487792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<m> f487793d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MergePaths f487794e;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f487795a = null;

        static {
            int[] r100 = new int[MergePaths.MergePathsMode.values().length];
            f487795a = r100;
            r100[MergePaths.MergePathsMode.Merge.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f487795a[MergePaths.MergePathsMode.Add.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f487795a[MergePaths.MergePathsMode.Subtract.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f487795a[MergePaths.MergePathsMode.Intersect.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f487795a[MergePaths.MergePathsMode.ExcludeIntersections.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    @Override // i0.m
    public final Path getPath() {
        this.f487792c.reset();
        int r100 = a.f487795a[this.f487794e.f24822a.ordinal()];
        if (r100 != 1) goto L5;
        int r101 = 0;
    L19:
        if (r101 >= ((ArrayList) this.f487793d).size()) goto L22;
        this.f487792c.addPath(((m) ListProtector.get(this.f487793d, r101)).getPath());
        r101 = r101 + 1;
    L22:
        return this.f487792c;
    L5:
        if (r100 != 2) goto L7;
        a(Path.Op.UNION);
        goto L22
    L7:
        if (r100 != 3) goto L9;
        a(Path.Op.REVERSE_DIFFERENCE);
        goto L22
    L9:
        if (r100 != 4) goto L11;
        a(Path.Op.INTERSECT);
        goto L22
    L11:
        if (r100 != 5) goto L22;
        a(Path.Op.XOR);
        goto L22
    }

    public l(MergePaths r100) {
        this.f487790a = new Path();
        this.f487791b = new Path();
        this.f487792c = new Path();
        this.f487793d = new ArrayList();
        r100.getClass();
        this.f487794e = r100;
    }

    public final void a(Path.Op r100) {
        this.f487791b.reset();
        this.f487790a.reset();
        int r101 = ((ArrayList) this.f487793d).size() - 1;
    L3:
        if (r101 < 1) goto L15;
        m r102 = (m) ListProtector.get(this.f487793d, r101);
        if ((r102 instanceof d) == false) goto L13;
        d r103 = (d) r102;
        List<m> r104 = r103.e();
        int r105 = r104.size() - 1;
    L7:
        if (r105 < 0) goto L14;
        Path r106 = ((m) ListProtector.get(r104, r105)).getPath();
        j0.o r107 = r103.f487745h;
        if (r107 == null) goto L11;
        Matrix r108 = r107.d();
    L12:
        r106.transform(r108);
        this.f487791b.addPath(r106);
        r105 = r105 - 1;
        goto L7
    L11:
        r103.f487738a.reset();
        r108 = r103.f487738a;
    L14:
        r101 = r101 - 1;
        goto L3
    L13:
        this.f487791b.addPath(r102.getPath());
        goto L14
    L15:
        int r109 = 0;
        m r110 = (m) ListProtector.get(this.f487793d, 0);
        if ((r110 instanceof d) == false) goto L25;
        d r111 = (d) r110;
        List<m> r112 = r111.e();
    L19:
        if (r109 >= r112.size()) goto L26;
        Path r113 = ((m) ListProtector.get(r112, r109)).getPath();
        j0.o r114 = r111.f487745h;
        if (r114 == null) goto L23;
        Matrix r115 = r114.d();
    L24:
        r113.transform(r115);
        this.f487790a.addPath(r113);
        r109 = r109 + 1;
        goto L19
    L23:
        r111.f487738a.reset();
        r115 = r111.f487738a;
    L26:
        this.f487792c.op(this.f487790a, this.f487791b, r100);
        return;
    L25:
        this.f487790a.set(r110.getPath());
        goto L26
    }

    @Override // i0.j
    public final void e(ListIterator<c> r100) {
    L3:
        if (r100.hasPrevious() == false) goto L8;
        if (r100.previous() != this) goto L3;
    L8:
        if (r100.hasPrevious() == false) goto L12;
        c r101 = r100.previous();
        if ((r101 instanceof m) == false) goto L8;
        ArrayList r102 = (ArrayList) this.f487793d;
        r102.add((m) r101);
        r100.remove();
        goto L8
    }

    @Override // i0.c
    public final void b(List<c> r100, List<c> r101) {
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) this.f487793d).size()) goto L6;
        ((m) ListProtector.get(this.f487793d, r102)).b(r100, r101);
        r102 = r102 + 1;
        goto L4
    }
}
