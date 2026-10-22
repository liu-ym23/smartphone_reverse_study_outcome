package com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender;

import android.text.Layout;
import android.view.View;
import androidx.collection.LruCache;
import androidx.core.util.Pools;
import com.ss.android.lark.log.Log;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class AbsTextLayoutCacheStore implements z2b.a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f412436d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LruCache<b, CharSequence> f412437a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AbsTextLayoutCacheStore$layoutCache$1 f412438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap<Integer, Pools.SynchronizedPool<View>> f412439c;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f412440a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f412441b;

        public final int hashCode() {
            return (this.f412440a.hashCode() * 31) + this.f412441b;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(b.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.AbsTextLayoutCacheStore.KeyImpl");
            b r102 = (b) r100;
            if (Intrinsics.areEqual(this.f412440a, r102.f412440a) == true) goto L16;
            return false;
        L16:
            if (this.f412441b == r102.f412441b) goto L18;
            return false;
        L18:
            return true;
        L8:
            r101 = null;
            goto L10
        }

        public b(String r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "messageId");
            this.f412440a = r100;
            this.f412441b = r101;
        }
    }

    public abstract b f(TextLayoutRender.e r100);

    public abstract b g(TextLayoutRender.g r100);

    static {
        f412436d = new b("", 0);
    }

    @Override // z2b.a
    public final void clearCache() {
        evictAll();
        this.f412437a.evictAll();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.lark.chat.chatwindow.chat.data.convert.textrender.AbsTextLayoutCacheStore$layoutCache$1] */
    public AbsTextLayoutCacheStore() {
        this.f412437a = new LruCache(120);
        this.f412438b = new AbsTextLayoutCacheStore$layoutCache$1(this);
        this.f412439c = new ConcurrentHashMap(0);
    }

    @Override // z2b.a
    public final CharSequence b(z2b.b.a r100) {
        Intrinsics.checkNotNullParameter(r100, "parseRequest");
        b r101 = f((TextLayoutRender.e) r100);
        if (Intrinsics.areEqual(r101, f412436d) == false) goto L6;
        return null;
    L6:
        Log.d("TextLayoutCacheStore", "obtainCharSequence: " + r101.f412440a + " , " + r101.f412441b);
        return this.f412437a.get(r101);
    }

    @Override // z2b.a
    public final Layout c(z2b.b.InterfaceC8412b r100) {
        Intrinsics.checkNotNullParameter(r100, "renderRequest");
        b r101 = g((TextLayoutRender.g) r100);
        if (Intrinsics.areEqual(r101, f412436d) == false) goto L6;
        return null;
    L6:
        Log.d("TextLayoutCacheStore", "obtainLayout: " + r101.f412440a + " , " + r101.f412441b);
        return get(r101);
    }

    public final String e(Object r100) {
        return r100.getClass().getSimpleName() + '#' + r100.hashCode();
    }

    @Override // z2b.a
    public final void a(z2b.b.a r100, CharSequence r101) {
        Intrinsics.checkNotNullParameter(r100, "parseRequest");
        Intrinsics.checkNotNullParameter(r101, "charSequence");
        b r102 = f((TextLayoutRender.e) r100);
        if (Intrinsics.areEqual(r102, f412436d) == false) goto L5;
        return;
    L5:
        Log.d("TextLayoutCacheStore", "onCacheCharSequence: " + r102.f412440a + " , " + r102.f412441b);
        this.f412437a.put(r102, r101);
    }

    @Override // z2b.a
    public final void d(z2b.b.InterfaceC8412b r100, Layout r101) {
        Intrinsics.checkNotNullParameter(r100, "renderRequest");
        Intrinsics.checkNotNullParameter(r101, "layout");
        b r102 = g((TextLayoutRender.g) r100);
        if (Intrinsics.areEqual(r102, f412436d) == false) goto L5;
        return;
    L5:
        Log.d("TextLayoutCacheStore", "onCacheLayout: " + r102.f412440a + " , " + r102.f412441b);
        put(r102, r101);
    }

    public final void h(final com.ss.android.lark.widget.light.viewstub.h r100, View r101) {
        Pools.SynchronizedPool<View> r102 = this.f412439c.get(Integer.valueOf(new AbsTextLayoutCacheStore$recycleViewImplIfNeed$cachePool$1(r100).hashCode()));
        if (r102 != null) goto L5;
        return;
    L5:
        Log.d("TextLayoutCacheStore", "recycle: span is " + e(r100) + " , view is " + e(r101));
        r102.release(r101);
    }
}
