package lx3;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;

/* JADX INFO: loaded from: classes14.dex */
public final class e extends Handler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f511128a;

    @Override // android.os.Handler
    public final void handleMessage(Message r100) {
        super.handleMessage(r100);
        boolean r101 = true;
        if (r100.what != 1) goto L21;
        k r102 = this.f511128a.f511134e;
        if (r102 == null) goto L19;
        Object r103 = r100.obj;
        if ((r103 instanceof String) == false) goto L19;
        String r104 = (String) r103;
        boolean r105 = Objects.equals(r104, r102.f511156b);
        f r106 = this.f511128a;
        if (r106.f511132c == true) goto L12;
    L14:
        r101 = false;
    L15:
        if (r105 == false) goto L19;
        if (r101 == false) goto L19;
        k r107 = this.f511128a.f511134e;
        r107.f511162h = System.currentTimeMillis();
        f r108 = this.f511128a;
        r108.f511136g.d(r108.f511134e);
        f.a(this.f511128a, r104);
        this.f511128a.getClass();
        return;
    L12:
        if (r106.f511131b == false) goto L14;
    L19:
        this.f511128a.f511136g.a();
        this.f511128a.getClass();
        return;
    }

    public e(f r100, Looper r101) {
        this.f511128a = r100;
        super(r101);
    }
}
