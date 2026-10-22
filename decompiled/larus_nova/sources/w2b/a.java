package w2b;

import android.text.Layout;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.TextLayoutRender;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.h;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutCacheStoreImpl2;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.m;
import com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.p;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class a implements z2b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final h f558080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextLayoutCacheStoreImpl2 f558081b;

    @Override // z2b.a
    public final void clearCache() {
        this.f558080a.clearCache();
        this.f558081b.clearCache();
    }

    public a() {
        this.f558080a = new h();
        this.f558081b = new TextLayoutCacheStoreImpl2();
    }

    @Override // z2b.a
    public final CharSequence b(z2b.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "parseRequest");
        if ((r100 instanceof TextLayoutRender.e) == false) goto L7;
        return this.f558080a.b(r100);
    L7:
        if ((r100 instanceof m) == true) goto L9;
        return null;
    L9:
        return this.f558081b.b(r100);
    }

    @Override // z2b.a
    public final Layout c(z2b.b.InterfaceC8412b r100) {
        Intrinsics.checkNotNullParameter(r100, "renderRequest");
        if ((r100 instanceof TextLayoutRender.g) == false) goto L7;
        return this.f558080a.c(r100);
    L7:
        if ((r100 instanceof p) == true) goto L9;
        return null;
    L9:
        return this.f558081b.c(r100);
    }

    @Override // z2b.a
    public final void a(z2b.b.a r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "parseRequest");
        Intrinsics.checkNotNullParameter(r101, "charSequence");
        if ((r100 instanceof TextLayoutRender.e) == false) goto L7;
        this.f558080a.a(r100, r101);
        return;
    L7:
        if ((r100 instanceof m) == false) goto L10;
        this.f558081b.a(r100, r101);
        return;
    }

    @Override // z2b.a
    public final void d(z2b.b.InterfaceC8412b r100, Layout r101) {
        Intrinsics.checkNotNullParameter(r100, "renderRequest");
        Intrinsics.checkNotNullParameter(r101, "layout");
        if ((r100 instanceof TextLayoutRender.g) == false) goto L7;
        this.f558080a.d(r100, r101);
        return;
    L7:
        if ((r100 instanceof p) == false) goto L10;
        this.f558081b.d(r100, r101);
        return;
    }
}
