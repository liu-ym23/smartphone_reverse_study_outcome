package com.bytedance.android.livesdk.live.listprovider;

import com.bytedance.android.livesdk.utils.personalfeed.PersonalizedFeedUtils;
import io.reactivex.disposables.Disposable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class m {
    public static final ConcurrentHashMap<String, Object> a = null;
    public static final ConcurrentHashMap<String, Disposable> b = null;

    static {
        a = new ConcurrentHashMap();
        b = new ConcurrentHashMap();
    }

    public static void a(String r1, long r2) {
        Intrinsics.checkNotNullParameter(r1, "enterFromMerge");
        if (PersonalizedFeedUtils.c() == true) goto L5;
        return;
    L5:
        if (PersonalizedFeedUtils.b().a() == false) goto L13;
        String r3 = r1 + '_' + r2;
        a.remove(r3);
        Disposable r4 = b.remove(r3);
        if (r4 == null) goto L12;
        r4.dispose();
        return;
    L12:
        return;
    }
}
