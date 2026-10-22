package retrofit2;

import java.io.IOException;
import java.lang.reflect.Array;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class o extends p<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p f537523a;

    public o(p r100) {
        this.f537523a = r100;
    }

    @Override // retrofit2.p
    public final void a(r r100, @Nullable Object r101) throws IOException {
        if (r101 != null) goto L4;
        return;
    L4:
        int r102 = Array.getLength(r101);
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L7;
        this.f537523a.a(r100, Array.get(r101, r103));
        r103 = r103 + 1;
        goto L5
    }
}
