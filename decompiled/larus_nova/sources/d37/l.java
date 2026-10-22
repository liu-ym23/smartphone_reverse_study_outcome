package d37;

import a37.x;
import com.bytedance.navigation.kmp.listener.r;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public final class l implements e37.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x f466753a;

    @Override // e37.h
    public final void b() {
        x r100 = this.f466753a;
        if (r100 == null) goto L6;
        r100.b();
        return;
    }

    public l() {
        int r100 = w27.a.f558036a;
        this.f466753a = new x();
    }

    @Override // e37.h
    public final void a(boolean r100) {
        x r101 = this.f466753a;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    @Override // e37.h
    public final String c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        x r101 = this.f466753a;
        if (r101 == null) goto L6;
        String r102 = r101.c(r100);
        if (r102 == null) goto L6;
        return r102;
    L6:
        return "";
    }

    @Override // e37.h
    public final void d(r r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        x r101 = this.f466753a;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }
}
