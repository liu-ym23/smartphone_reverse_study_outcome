package msc;

import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;
import org.commonmark.node.Image;
import org.commonmark.node.Link;

/* JADX INFO: loaded from: classes5.dex */
public final class p extends o {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final lsc.q<String> f515538d = null;

    public static final class a {
    }

    @Override // msc.o, lsc.a, lsc.j
    public final void a(TextView r100, uvc.b r101, lsc.p r102) {
        Intrinsics.checkNotNullParameter(r101, "node");
        Intrinsics.checkNotNullParameter(r102, "visitor");
    }

    @Override // msc.o, lsc.a, lsc.j
    public final void d(CharSequence r100, uvc.b r101, lsc.p r102) {
        Intrinsics.checkNotNullParameter(r101, "node");
        Intrinsics.checkNotNullParameter(r102, "visitor");
    }

    static {
        f515538d = new lsc.q("link-title");
    }

    public p() {
    }

    @Override // msc.o, lsc.a, lsc.j
    public final void c(lsc.p.a r100) {
        Intrinsics.checkNotNullParameter(r100, "builder");
        super.c(r100);
        r100.a(Link.class, q.f515539a);
        r100.a(Image.class, new r(this));
    }
}
