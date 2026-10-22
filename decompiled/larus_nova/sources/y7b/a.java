package y7b;

import com.ss.android.lark.commonmark.internal.n;
import com.ss.android.lark.commonmark.internal.r;
import java.util.ArrayList;
import v7b.x;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a implements d {
    public a() {
    }

    @Override // y7b.d
    public boolean b() {
        return this instanceof r;
    }

    @Override // y7b.d
    public void c() {
    }

    @Override // y7b.d
    public void d(n r100) {
    }

    @Override // y7b.d
    public void e(w7b.f r100) {
    }

    @Override // y7b.d
    public boolean g(v7b.a r100) {
        return this instanceof com.ss.android.lark.commonmark.internal.c;
    }

    @Override // y7b.d
    public boolean isContainer() {
        return this instanceof com.ss.android.lark.commonmark.internal.c;
    }

    @Override // y7b.d
    public void f(x r100) {
        v7b.a r101 = a();
        if (r101.f553573i != null) goto L5;
        r101.f553573i = new ArrayList();
    L5:
        ((ArrayList) r101.f553573i).add(r100);
    }
}
