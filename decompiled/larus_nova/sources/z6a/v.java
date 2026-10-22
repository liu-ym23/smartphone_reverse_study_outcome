package z6a;

import android.text.Spanned;
import android.util.LruCache;
import com.lynx.tasm.behavior.LynxContext;

/* JADX INFO: loaded from: classes32.dex */
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<com.lynx.tasm.behavior.shadow.text.f, com.lynx.tasm.behavior.shadow.text.e> f570617a;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final v f570618a = null;

        static {
            f570618a = new v();
        }
    }

    public v() {
        this.f570617a = new LruCache(500);
    }

    public final com.lynx.tasm.behavior.shadow.text.e a(LynxContext r100, com.lynx.tasm.behavior.shadow.text.f r101) {
        if (r100.isTextLayoutCacheEnabled() == false) goto L5;
        com.lynx.tasm.behavior.shadow.text.e r102 = this.f570617a.get(r101);
        if (r102 == null) goto L9;
        return r102;
    L9:
        com.lynx.tasm.behavior.shadow.text.e r103 = new com.lynx.tasm.behavior.shadow.text.e(r100, r101);
        com.lynx.tasm.behavior.shadow.text.a r104 = r101.f382299a.f382309b;
        boolean r105 = false;
        if (r104.f382261q == false) goto L12;
    L22:
        if (r105 == false) goto L24;
        this.f570617a.put(r101, r103);
    L24:
        return r103;
    L12:
        if (r104.f382262r == true) goto L22;
        Spanned r106 = (Spanned) r103.f382287a.getText();
        h[] r107 = (h[]) r106.getSpans(0, r106.length(), h.class);
        l[] r108 = (l[]) r106.getSpans(0, r106.length(), l.class);
        if (r107 != null) goto L17;
    L18:
        if (r108 != null) goto L20;
    L21:
        r105 = true;
        goto L22
    L20:
        if (r108.length != 0) goto L22;
    L17:
        if (r107.length != 0) goto L22;
    L5:
        return new com.lynx.tasm.behavior.shadow.text.e(r100, r101);
    }
}
