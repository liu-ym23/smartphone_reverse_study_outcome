package retrofit2;

import java.io.IOException;
import java.util.Iterator;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class n extends p<Iterable<Object>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f537522a;

    public n(p r100) {
        this.f537522a = r100;
    }

    @Override // retrofit2.p
    public final void a(r r100, @Nullable Iterable<Object> r101) throws IOException {
        Iterable<Object> r102 = r101;
        if (r102 == null) goto L9;
        Iterator<Object> r103 = r102.iterator();
    L7:
        if (r103.hasNext() == false) goto L11;
        Object r104 = r103.next();
        this.f537522a.a(r100, r104);
        goto L7
    L11:
        return;
    }
}
