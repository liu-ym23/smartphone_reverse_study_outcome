package com.larksuite.component.card.component.text.span;

import android.util.LruCache;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes24.dex */
public final class UniversalCardPrefixSpanUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UniversalCardPrefixSpanUtils f283665a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<String, String> f283666b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, Float> f283667c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LruCache<Integer, Float> f283668d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final LruCache<String, Float> f283669e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final LruCache<Integer, Float> f283670f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final LruCache<String, Float> f283671g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Lazy f283672h = null;

    public UniversalCardPrefixSpanUtils() {
    }

    static {
        f283665a = new UniversalCardPrefixSpanUtils();
        f283666b = new LruCache(5);
        f283667c = new LruCache(5);
        f283668d = new LruCache(5);
        f283669e = new LruCache(5);
        f283670f = new LruCache(5);
        f283671g = new LruCache(5);
        f283672h = LazyKt.lazy(UniversalCardPrefixSpanUtils$themeColor$2.INSTANCE);
    }
}
