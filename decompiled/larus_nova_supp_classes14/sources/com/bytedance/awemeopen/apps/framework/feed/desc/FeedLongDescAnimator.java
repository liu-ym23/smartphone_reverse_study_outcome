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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class FeedLongDescAnimator {
    public static final LruCache<Integer, ValueAnimator> a = null;
    public static final LruCache<Integer, ValueAnimator> b = null;
    public static final LruCache<Integer, ValueAnimator> c = null;
    public static final Lazy d = null;
    public static final Lazy e = null;

    static {
        a = new LruCache(5);
        b = new LruCache(5);
        c = new LruCache(5);
        LazyThreadSafetyMode r0 = LazyThreadSafetyMode.NONE;
        d = LazyKt.lazy(r0, FeedLongDescAnimator$animatorInterpolator$2.INSTANCE);
        e = LazyKt.lazy(r0, FeedLongDescAnimator$emptyAnimator$2.INSTANCE);
    }

    public static void c(List r2) {
        List r3 = r2;
        if (r3 != null) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L11;
        return;
    L11:
        AnimatorSet r1 = new AnimatorSet();
        r1.setInterpolator((Interpolator) d.getValue());
        r1.playTogether(r3);
        r1.start();
        return;
    L5:
        if (r3.isEmpty() == true) goto L8;
        r0 = false;
        goto L9
    }

    public static final void d(LruCache<Integer, ValueAnimator> r2) {
        Iterator<Map.Entry<Integer, ValueAnimator>> r0 = r2.snapshot().entrySet().iterator();     // Catch: Exception -> L10
    L4:
        if (r0.hasNext() == false) goto L7;
        r0.next().getValue().cancel();     // Catch: Exception -> L10
        goto L4
    L7:
        if (r2.size() <= 0) goto L14;
        r2.evictAll();     // Catch: Exception -> L10
        return;
    L14:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmStatic
    public static final Animator a(final ScrollMentionTextView r4, int r5, int r6, r r7) {
        if (r4 == 0) goto L15;
        if (r5 == r6) goto L15;
        int r0 = (r4.hashCode() + (r5 * 7)) + (r6 * 9);
        LruCache<Integer, ValueAnimator> r1 = a;
        ValueAnimator r2 = r1.get(Integer.valueOf(r0));
        if (r2 != null) goto L10;
        r2 = ValueAnimator.ofInt(new int[]{r5, r6});
        r2.setDuration(300);
        r2.addUpdateListener(new f(r4));
        r1.put(Integer.valueOf(r0), r2);
    L10:
        if (r2.isRunning() == false) goto L12;
        r2.cancel();
    L12:
        r2.addListener(r7);
        return r2;
    L15:
        return (ValueAnimator) e.getValue();
    }

    @JvmStatic
    public static final Animator b(final View r4, int r5, int r6, long r7) {
        if (r4 == null) goto L14;
        if (r5 == r6) goto L14;
        int r0 = (r4.hashCode() + (r5 * 7)) + (r6 * 9);
        LruCache<Integer, ValueAnimator> r1 = b;
        ValueAnimator r2 = r1.get(Integer.valueOf(r0));
        if (r2 != null) goto L10;
        r2 = ValueAnimator.ofInt(new int[]{r5, r6});
        r2.setDuration(r7);
        r2.addUpdateListener(new g(r4));
        r1.put(Integer.valueOf(r0), r2);
    L10:
        if (r2.isRunning() == false) goto L12;
        r2.cancel();
    L12:
        return r2;
    L14:
        return (ValueAnimator) e.getValue();
    }
}
