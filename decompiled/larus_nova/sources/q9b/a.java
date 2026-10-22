package q9b;

import android.content.res.Configuration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Configuration f532179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public InterfaceC7301a f532180b;

    /* JADX INFO: renamed from: q9b.a$a, reason: collision with other inner class name */
    public interface InterfaceC7301a {
        void a();
    }

    public a(Configuration r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f532179a = r100;
    }

    public final void a(Configuration r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.diff(this.f532179a);
        if ((r101 & 256) == 0) goto L7;
    L8:
        InterfaceC7301a r102 = this.f532180b;
        if (r102 == null) goto L11;
        r102.a();
    L11:
        this.f532179a = new Configuration(r100);
        return;
    L7:
        if ((r101 & 1024) == 0) goto L11;
        goto L8
    }
}
