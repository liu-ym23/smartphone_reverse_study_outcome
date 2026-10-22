package p2b;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import b3b.f;
import com.ss.android.lark.widget.richtext.Image;
import java.util.List;
import r5b.c;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements r5b.b<v5b.a<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<v5b.a<?>> f527503a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q5b.a f527504b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final q5b.b f527505c;

    public b(f r100) {
        this.f527504b = r100;
        if ((r100 instanceof q5b.b) == true) goto L6;
        r100 = null;
    L6:
        this.f527505c = r100;
    }

    @Override // q5b.b
    public final void b(String r100) {
        q5b.b r101 = this.f527505c;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }

    @Override // q5b.a
    public final boolean c(String r100) {
        q5b.a r101 = this.f527504b;
        if (r101 != null) goto L5;
        return false;
    L5:
        return r101.c(r100);
    }

    @Override // q5b.a
    public final void l(String r100) {
        q5b.a r101 = this.f527504b;
        if (r101 == null) goto L6;
        r101.l(r100);
        return;
    }

    @Override // r5b.c
    public final boolean d(View r100, v5b.c<v5b.a<?>> r101) {
        c<v5b.a<?>> r102 = this.f527503a;
        if (r102 != null) goto L5;
        return false;
    L5:
        return r102.d(r100, r101);
    }

    @Override // q5b.a
    public final void e(int r100, boolean r101) {
        q5b.a r102 = this.f527504b;
        if (r102 == null) goto L6;
        r102.e(r100, r101);
        return;
    }

    @Override // q5b.a
    public final void m(v5b.c r100, AppCompatImageView r101, r5b.a r102) {
        q5b.a r103 = this.f527504b;
        if (r103 == null) goto L6;
        r103.m(r100, r101, r102);
        return;
    }

    @Override // q5b.a
    public final void a(View r100, List<Image> r101, Image r102, String r103) {
        q5b.a r104 = this.f527504b;
        if (r104 == null) goto L6;
        r104.a(r100, r101, r102, r103);
        return;
    }
}
