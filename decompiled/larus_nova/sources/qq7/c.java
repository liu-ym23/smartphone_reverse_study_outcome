package qq7;

import android.content.Context;
import com.bytedance.webx.core.webview.WebViewContainer;
import com.bytedance.webx.event.EventManager;
import iq7.d;

/* JADX INFO: loaded from: classes22.dex */
public final class c extends uq7.a {

    public static abstract class a extends com.bytedance.webx.event.a<c> implements qq7.a {
        public a() {
        }

        @Override // qq7.a
        public final WebViewContainer a(Context r100, iq7.b r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "createContainer");
            if ((r102 instanceof a) == false) goto L7;
            return ((a) r102).a(r100, r101);
        L7:
            return c.e(b(), r100, r101);
        }

        public final <T extends d> T e(Context r100, Class<T> r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "createContainer");
            if ((r102 instanceof a) == false) goto L7;
            return (T) ((a) r102).e(r100, r101);
        L7:
            return (T) b().d(r100, r101);
        }

        public final <T extends d> T f(Context r100, Class<T> r101) {
            com.bytedance.webx.event.a r102 = EventManager.a(c(), this, "newContainer");
            if ((r102 instanceof a) == false) goto L7;
            return (T) ((a) r102).f(r100, r101);
        L7:
            return c.f(b(), r100, r101);
        }
    }

    public c() {
    }

    @Override // uq7.a, qq7.a
    public final WebViewContainer a(Context r100, iq7.b r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "createContainer");
        if ((r102 instanceof a) == false) goto L7;
        pq7.c.b r103 = pq7.c.f530286b;
        r103.get().b();
        WebViewContainer r104 = ((a) r102).a(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return super.a(r100, r101);
    }

    @Override // uq7.a
    public final <T extends d> T d(Context r100, Class<T> r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "newContainer");
        if ((r102 instanceof a) == false) goto L7;
        pq7.c.b r103 = pq7.c.f530286b;
        r103.get().b();
        T r104 = (T) ((a) r102).f(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return (T) super.d(r100, r101);
    }

    public final <T extends d> T g(Context r100, Class<T> r101) {
        com.bytedance.webx.event.a r102 = EventManager.b(getExtendableContext(), "createContainer");
        if ((r102 instanceof a) == false) goto L7;
        pq7.c.b r103 = pq7.c.f530286b;
        r103.get().b();
        T r104 = (T) ((a) r102).e(r100, r101);
        r103.get().a();
        return r104;
    L7:
        return (T) d(r100, r101);
    }

    public static WebViewContainer e(c r100, Context r101, iq7.b r102) {
        return super.a(r101, r102);
    }

    public static WebViewContainer f(c r100, Context r101, Class r102) {
        return (WebViewContainer) super.d(r101, r102);
    }
}
