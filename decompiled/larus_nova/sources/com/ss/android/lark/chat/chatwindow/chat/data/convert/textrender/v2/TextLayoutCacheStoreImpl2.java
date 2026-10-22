package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2;

import android.text.Layout;
import android.view.View;
import androidx.collection.LruCache;
import androidx.core.util.Pools;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class TextLayoutCacheStoreImpl2 implements z2b.a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f412478e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<String, j.a> f412479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LruCache<String, CharSequence> f412480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextLayoutCacheStoreImpl2$layoutCache$1 f412481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Pools.SynchronizedPool<View>> f412482d;

    public static final class a {
    }

    static {
    }

    @Override // z2b.a
    public final void clearCache() {
        evictAll();
        this.f412480b.evictAll();
        this.f412482d.clear();
        this.f412479a.evictAll();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.v2.TextLayoutCacheStoreImpl2$layoutCache$1] */
    public TextLayoutCacheStoreImpl2() {
        this.f412479a = new LruCache(512);
        this.f412480b = new LruCache(120);
        this.f412481c = new TextLayoutCacheStoreImpl2$layoutCache$1(this);
        this.f412482d = new ConcurrentHashMap(0);
    }

    @Override // z2b.a
    public final CharSequence b(z2b.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "parseRequest");
        m r101 = (m) r100;
        j.a r102 = j.f412511a;
        j.a r103 = j.a(r101.f412526b);
        if (Intrinsics.areEqual(r103, j.f412511a) == false) goto L6;
        return null;
    L6:
        CharSequence r104 = this.f412480b.get(r101.f412526b.f412528b + '-' + (r103.hashCode() + (r101.f412525a.hashCode() * 31)));
        if (r104 != null) goto L9;
        e(r101.f412526b, r103);
    L9:
        return r104;
    }

    @Override // z2b.a
    public final Layout c(z2b.b.InterfaceC8412b r100) {
        Intrinsics.checkNotNullParameter(r100, "renderRequest");
        p r101 = (p) r100;
        j.a r102 = j.f412511a;
        j.a r103 = j.a(r101.f412538b);
        if (Intrinsics.areEqual(r103, j.f412511a) == false) goto L6;
        return null;
    L6:
        Layout r104 = get(r101.f412538b.f412528b + '-' + (r103.hashCode() + (System.identityHashCode(r101.f412537a) * 31)));
        if (r104 != null) goto L9;
        e(r101.f412538b, r103);
    L9:
        return r104;
    }

    public final String f(Object r100) {
        return r100.getClass().getSimpleName() + '#' + r100.hashCode();
    }

    @Override // z2b.a
    public final void a(z2b.b.a r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "parseRequest");
        Intrinsics.checkNotNullParameter(r101, "charSequence");
        m r102 = (m) r100;
        j.a r103 = j.f412511a;
        j.a r104 = j.a(r102.f412526b);
        if (Intrinsics.areEqual(r104, j.f412511a) == false) goto L5;
        return;
    L5:
        String r105 = r102.f412526b.f412528b;
        int r106 = r104.hashCode() + (r102.f412525a.hashCode() * 31);
        this.f412479a.put(r105, r104);
        this.f412480b.put(r105 + '-' + r106, r101);
    }

    @Override // z2b.a
    public final void d(z2b.b.InterfaceC8412b r100, Layout r101) {
        Intrinsics.checkNotNullParameter(r100, "renderRequest");
        Intrinsics.checkNotNullParameter(r101, "layout");
        p r102 = (p) r100;
        j.a r103 = j.f412511a;
        j.a r104 = j.a(r102.f412538b);
        if (Intrinsics.areEqual(r104, j.f412511a) == false) goto L5;
        return;
    L5:
        String r105 = r102.f412538b.f412528b;
        int r106 = r104.hashCode() + (System.identityHashCode(r102.f412537a) * 31);
        this.f412479a.put(r105, r104);
        put(r105 + '-' + r106, r101);
    }

    public final void e(n r100, j.a r101) {
        String r102 = r100.f412528b;
        j.a r103 = this.f412479a.get(r102);
        if (r103 != null) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(r103, r101) == false) goto L8;
        return;
    L8:
        StringBuilder r104 = new StringBuilder();
        if (r103.f412512a == r101.f412512a) goto L12;
        r104.append(" contextHash changed");
    L12:
        if (r103.f412513b == r101.f412513b) goto L15;
        r104.append(" richTextNodeParseHash changed");
    L15:
        if (r103.f412514c == r101.f412514c) goto L18;
        r104.append(" themeParseHash changed");
    L18:
        if (r103.f412515d == r101.f412515d) goto L21;
        r104.append(" markdownPluginHash changed");
    L21:
        if (r103.f412516e == r101.f412516e) goto L23;
        r104.append(" parseListenersHash changed");
    L23:
        Log.i("TextLayoutCacheStoreImpl", "message " + r102 + ", obtain data not hit cache, because " + r104);
    }

    public final void g(final com.ss.android.lark.widget.light.viewstub.h r100, View r101) {
        Pools.SynchronizedPool<View> r102 = this.f412482d.get(Integer.valueOf(new TextLayoutCacheStoreImpl2$recycleViewImplIfNeed$cachePool$1(r100).hashCode()));
        if (r102 != null) goto L5;
        return;
    L5:
        Log.d("TextLayoutCacheStoreImpl", "recycle: span is " + f(r100) + " , view is " + f(r101));
        r102.release(r101);
    }
}
