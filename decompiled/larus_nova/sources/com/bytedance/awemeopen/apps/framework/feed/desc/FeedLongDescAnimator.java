package com.bytedance.awemeopen.apps.framework.feed.desc;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.util.LruCache;
import android.view.View;
import android.view.animation.Interpolator;
import com.bytedance.awemeopen.apps.framework.feed.ui.information.desc.r;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes14.dex */
public final class FeedLongDescAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LruCache<Integer, ValueAnimator> f194620a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final LruCache<Integer, ValueAnimator> f194621b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<Integer, ValueAnimator> f194622c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Lazy f194623d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy f194624e = null;

    static {
        f194620a = new LruCache(5);
        f194621b = new LruCache(5);
        f194622c = new LruCache(5);
        LazyThreadSafetyMode r100 = LazyThreadSafetyMode.NONE;
        f194623d = LazyKt.lazy(r100, FeedLongDescAnimator$animatorInterpolator$2.INSTANCE);
        f194624e = LazyKt.lazy(r100, FeedLongDescAnimator$emptyAnimator$2.INSTANCE);
    }

    public static void c(List r100) {
        List r101 = r100;
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        return;
    L11:
        AnimatorSet r103 = new AnimatorSet();
        r103.setInterpolator((Interpolator) f194623d.getValue());
        r103.playTogether(r101);
        r103.start();
        return;
    L5:
        if (r101.isEmpty() == true) goto L8;
        r102 = false;
        goto L9
    }

    public static final void d(LruCache<Integer, ValueAnimator> r100) {
        Iterator<Map.Entry<Integer, ValueAnimator>> r101 = r100.snapshot().entrySet().iterator();     // Catch: Exception -> L10
    L4:
        if (r101.hasNext() == false) goto L7;
        r101.next().getValue().cancel();     // Catch: Exception -> L10
        goto L4
    L7:
        if (r100.size() <= 0) goto L14;
        r100.evictAll();     // Catch: Exception -> L10
        return;
    L14:
        return;
    }

    @JvmStatic
    public static final Animator a(final ScrollMentionTextView r100, int r101, int r102, r r103) {
        if (r100 == null) goto L15;
        if (r101 == r102) goto L15;
        int r104 = (r100.hashCode() + (r101 * 7)) + (r102 * 9);
        LruCache<Integer, ValueAnimator> r105 = f194620a;
        ValueAnimator r106 = r105.get(Integer.valueOf(r104));
        if (r106 != null) goto L10;
        r106 = ValueAnimator.ofInt(new int[]{r101, r102});
        r106.setDuration(300);
        r106.addUpdateListener(new f(r100));
        r105.put(Integer.valueOf(r104), r106);
    L10:
        if (r106.isRunning() == false) goto L12;
        r106.cancel();
    L12:
        r106.addListener(r103);
        return r106;
    L15:
        return (ValueAnimator) f194624e.getValue();
    }

    @JvmStatic
    public static final Animator b(final View r100, int r101, int r102, long r103) {
        if (r100 == null) goto L14;
        if (r101 == r102) goto L14;
        int r104 = (r100.hashCode() + (r101 * 7)) + (r102 * 9);
        LruCache<Integer, ValueAnimator> r105 = f194621b;
        ValueAnimator r106 = r105.get(Integer.valueOf(r104));
        if (r106 != null) goto L10;
        r106 = ValueAnimator.ofInt(new int[]{r101, r102});
        r106.setDuration(r103);
        r106.addUpdateListener(new g(r100));
        r105.put(Integer.valueOf(r104), r106);
    L10:
        if (r106.isRunning() == false) goto L12;
        r106.cancel();
    L12:
        return r106;
    L14:
        return (ValueAnimator) f194624e.getValue();
    }
}
