package nz6;

import android.graphics.Path;
import com.bytedance.lottie.LottieDrawable;
import com.bytedance.lottie.model.content.ShapeTrimPath;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public final class p implements l, oz6.a.InterfaceC7134a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f521534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LottieDrawable f521535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final oz6.l f521536c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f521537d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public r f521538e;

    @Override // oz6.a.InterfaceC7134a
    public final void a() {
        this.f521537d = false;
        this.f521535b.invalidateSelf();
    }

    @Override // nz6.l
    public final Path getPath() {
        if (this.f521537d == true) goto L5;
        this.f521534a.reset();
        this.f521534a.set(this.f521536c.e());
        this.f521534a.setFillType(Path.FillType.EVEN_ODD);
        wz6.h.b(this.f521534a, this.f521538e);
        this.f521537d = true;
        return this.f521534a;
    L5:
        return this.f521534a;
    }

    @Override // nz6.b
    public final void b(List<b> r100, List<b> r101) {
        int r102 = 0;
    L4:
        if (r102 >= ((ArrayList) r100).size()) goto L11;
        b r103 = (b) ListProtector.get(r100, r102);
        if ((r103 instanceof r) == false) goto L10;
        r r104 = (r) r103;
        if (r104.getType() != ShapeTrimPath.Type.Simultaneously) goto L10;
        this.f521538e = r104;
        r104.e(this);
    L10:
        r102 = r102 + 1;
        goto L4
    }

    public p(LottieDrawable r100, com.bytedance.lottie.model.layer.a r101, sz6.j r102) {
        this.f521534a = new Path();
        r102.getClass();
        this.f521535b = r100;
        oz6.a<sz6.g, Path> r103 = r102.f543981c.a();
        this.f521536c = (oz6.l) r103;
        r101.e(r103);
        r103.a(this);
    }
}
