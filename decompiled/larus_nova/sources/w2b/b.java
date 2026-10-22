package w2b;

import android.text.Layout;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.h;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutCacheStoreImpl2;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutRender2;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.m;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements z2b.b {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f558082d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public z2b.a f558083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextLayoutRender f558084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextLayoutRender2 f558085c;

    public static final class a {
    }

    static {
        f558082d = new b();
    }

    public b() {
        this.f558084b = new TextLayoutRender();
        this.f558085c = new TextLayoutRender2();
    }

    @Override // z2b.b
    public final CharSequence a(z2b.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if ((r100 instanceof TextLayoutRender.e) == false) goto L7;
        return this.f558084b.a(r100);
    L7:
        if ((r100 instanceof m) == true) goto L9;
        return "";
    L9:
        return this.f558085c.a(r100);
    }

    @Override // z2b.b
    public final Layout b(z2b.b.InterfaceC8412b r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        if ((r100 instanceof TextLayoutRender.g) == false) goto L7;
        return this.f558084b.b(r100);
    L7:
        if ((r100 instanceof p) == true) goto L9;
        return null;
    L9:
        return this.f558085c.b(r100);
    }

    public final void c(z2b.a r100) {
        this.f558083a = r100;
        if ((r100 instanceof h) == false) goto L6;
        this.f558084b.f(r100);
    L6:
        if ((r100 instanceof TextLayoutCacheStoreImpl2) == false) goto L9;
        this.f558085c.f412484g = r100;
    L9:
        if ((r100 instanceof w2b.a) == false) goto L12;
        w2b.a r101 = (w2b.a) r100;
        this.f558084b.f(r101.f558080a);
        TextLayoutRender2 r102 = this.f558085c;
        r102.f412484g = r101.f558081b;
        return;
    }
}
