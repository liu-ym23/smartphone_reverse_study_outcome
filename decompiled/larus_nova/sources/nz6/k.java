package nz6;

import android.graphics.Matrix;
import android.graphics.Path;
import com.bytedance.lottie.model.content.MergePaths;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: classes21.dex */
public final class k implements l, i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f521496a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f521497b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Path f521498c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<l> f521499d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MergePaths f521500e;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f521501a = null;

        static {
            int[] r100 = new int[MergePaths.MergePathsMode.values().length];
            f521501a = r100;
            r100[MergePaths.MergePathsMode.Merge.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L14:
            f521501a[MergePaths.MergePathsMode.Add.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L18:
            f521501a[MergePaths.MergePathsMode.Subtract.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L22:
            f521501a[MergePaths.MergePathsMode.Intersect.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L16:
            f521501a[MergePaths.MergePathsMode.ExcludeIntersections.ordinal()] = 5;     // Catch: NoSuchFieldError -> L13
            return;
        }
    }

    @Override // nz6.l
    public final Path getPath() {
        this.f521498c.reset();
        int r100 = a.f521501a[this.f521500e.f264460a.ordinal()];
        if (r100 != 1) goto L5;
        int r101 = 0;
    L19:
        if (r101 >= ((ArrayList) this.f521499d).size()) goto L22;
        this.f521498c.addPath(((l) ListProtector.get(this.f521499d, r101)).getPath());
        r101 = r101 + 1;
    L22:
        return this.f521498c;
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

    public k(MergePaths r100) {
        this.f521496a = new Path();
        this.f521497b = new Path();
        this.f521498c = new Path();
        this.f521499d = new ArrayList();
        r100.getClass();
        this.f521500e = r100;
    }

    public final void a(Path.Op r100) {
        this.f521497b.reset();
        this.f521496a.reset();
        int r101 = ((ArrayList) this.f521499d).size() - 1;
    L3:
        if (r101 < 1) goto L15;
        l r102 = (l) ListProtector.get(this.f521499d, r101);
        if ((r102 instanceof c) == false) goto L13;
        c r103 = (c) r102;
        List<l> r104 = r103.e();
        int r105 = r104.size() - 1;
    L7:
        if (r105 < 0) goto L14;
        Path r106 = ((l) ListProtector.get(r104, r105)).getPath();
        oz6.o r107 = r103.f521452h;
        if (r107 == null) goto L11;
        Matrix r108 = r107.d();
    L12:
        r106.transform(r108);
        this.f521497b.addPath(r106);
        r105 = r105 - 1;
        goto L7
    L11:
        r103.f521445a.reset();
        r108 = r103.f521445a;
    L14:
        r101 = r101 - 1;
        goto L3
    L13:
        this.f521497b.addPath(r102.getPath());
        goto L14
    L15:
        int r109 = 0;
        l r110 = (l) ListProtector.get(this.f521499d, 0);
        if ((r110 instanceof c) == false) goto L25;
        c r111 = (c) r110;
        List<l> r112 = r111.e();
    L19:
        if (r109 >= r112.size()) goto L26;
        Path r113 = ((l) ListProtector.get(r112, r109)).getPath();
        oz6.o r114 = r111.f521452h;
        if (r114 == null) goto L23;
        Matrix r115 = r114.d();
    L24:
        r113.transform(r115);
        this.f521496a.addPath(r113);
        r109 = r109 + 1;
        goto L19
    L23:
        r111.f521445a.reset();
        r115 = r111.f521445a;
    L26:
        this.f521498c.op(this.f521496a, this.f521497b, r100);
        return;
    L25:
        this.f521496a.set(r110.getPath());
        goto L26
    }

    @Override // nz6.i
    public final void e(ListIterator<b> r100) {
    L3:
        if (r100.hasPrevious() == false) goto L8;
        if (r100.previous() != this) goto L3;
    L8:
        if (r100.hasPrevious() == false) goto L12;
        b r101 = r100.previous();
        if ((r101 instanceof l) == false) goto L8;
        ArrayList r102 = (ArrayList) this.f521499d;
        r102.add((l) r101);
        r100.remove();
        goto L8
    }

    @Override // nz6.b
    public final void b(List<b> r100, List<b> r101) {
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) this.f521499d).size()) goto L6;
        ((l) ListProtector.get(this.f521499d, r102)).b(r100, r101);
        r102 = r102 + 1;
        goto L4
    }
}
